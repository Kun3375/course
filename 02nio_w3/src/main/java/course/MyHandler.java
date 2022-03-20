package course;

import course.custom.*;
import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelHandler;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.handler.codec.http.*;

import java.nio.charset.StandardCharsets;
import java.util.List;

@ChannelHandler.Sharable
class MyHandler extends SimpleChannelInboundHandler<FullHttpRequest> {

    private static final MyHandler INSTANCE = new MyHandler();

    private final OkRequest request = new OkRequest();
    private final RequestFilter requestFilter;
    private final RequestBalancer requestBalancer;
    private final DiscoveryAndRouter discoveryAndRouter;

    private MyHandler() {
        requestFilter = new CheckTokenFilter();
        requestBalancer = new RoundRobinBalancer();
        discoveryAndRouter = new FixedDiscoveryAndRouter();
    }

    public static MyHandler getInstance() {
        return INSTANCE;
    }

    @Override
    protected void channelRead0(ChannelHandlerContext ctx, FullHttpRequest msg) throws Exception {
        // filter
        if (!requestFilter.check(msg)) {
            ByteBuf content = Unpooled.copiedBuffer("the request without token header!".getBytes(StandardCharsets.UTF_8));
            DefaultFullHttpResponse response =
                    new DefaultFullHttpResponse(HttpVersion.HTTP_1_1, HttpResponseStatus.UNAUTHORIZED, content);
            response.headers()
                    .add(HttpHeaderNames.CONTENT_TYPE, HttpHeaderValues.TEXT_PLAIN)
                    .add(HttpHeaderNames.CONTENT_LENGTH, content.readableBytes());
            ctx.writeAndFlush(response);
            return;
        }

        // router
        List<String> candidates = discoveryAndRouter.get(msg);
        if (candidates.isEmpty()) {
            ByteBuf content = Unpooled.copiedBuffer("the request has not router!".getBytes(StandardCharsets.UTF_8));
            DefaultFullHttpResponse response =
                    new DefaultFullHttpResponse(HttpVersion.HTTP_1_1, HttpResponseStatus.NOT_FOUND, content);
            response.headers()
                    .add(HttpHeaderNames.CONTENT_TYPE, HttpHeaderValues.TEXT_PLAIN)
                    .add(HttpHeaderNames.CONTENT_LENGTH, content.readableBytes());
            ctx.writeAndFlush(response);
            return;
        }

        String target = requestBalancer.choose(candidates);

        DefaultFullHttpResponse resp = request.exec(target, msg);
        ctx.writeAndFlush(resp);
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        System.err.println("exception occur: " + cause.getMessage());
        ctx.close();
    }
}