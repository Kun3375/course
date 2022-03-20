package course.previous;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.*;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.handler.codec.http.*;

import java.nio.charset.StandardCharsets;

public class BackServer {

    public static void main(String[] args) {
        EventLoopGroup parent = new NioEventLoopGroup();
        EventLoopGroup child = new NioEventLoopGroup();

        try {
            ServerBootstrap serverBootstrap = new ServerBootstrap()
                    .group(parent, child)
                    .channel(NioServerSocketChannel.class)
                    .option(ChannelOption.SO_BACKLOG, 128)
                    .childOption(ChannelOption.SO_KEEPALIVE, true)
                    .childHandler(new ChannelInitializer<SocketChannel>() {
                        @Override
                        protected void initChannel(SocketChannel ch) throws Exception {
                            ch.pipeline()
                                    .addLast("HttpBaseHandler", new HttpServerCodec())
                                    .addLast("CustomHandler", HttpHandler.getInstance());
                        }
                    });

            ChannelFuture channelFuture = serverBootstrap
                    .bind(Integer.parseInt(System.getProperty("server.port", "8900")))
                    .addListener(future -> {
                        if (future.isSuccess()) {
                            System.out.println("back server is ready!");
                        }
                    })
                    .syncUninterruptibly();

            channelFuture.channel().closeFuture().awaitUninterruptibly();
        } finally {
            parent.shutdownGracefully().awaitUninterruptibly();
            child.shutdownGracefully().awaitUninterruptibly();
        }
    }
}

@ChannelHandler.Sharable
class HttpHandler extends SimpleChannelInboundHandler<HttpRequest> {

    private static HttpHandler INSTANCE = new HttpHandler();

    private HttpHandler() {

    }

    public static HttpHandler getInstance() {
        return INSTANCE;
    }


    @Override
    protected void channelRead0(ChannelHandlerContext ctx, HttpRequest msg) throws Exception {
        System.out.println("received request " + msg.uri());
        ByteBuf content = Unpooled.copiedBuffer("Hello, http client!".getBytes(StandardCharsets.UTF_8));
        DefaultFullHttpResponse response =
                new DefaultFullHttpResponse(HttpVersion.HTTP_1_1, HttpResponseStatus.OK, content);
        response.headers()
                .add(HttpHeaderNames.CONTENT_TYPE, HttpHeaderValues.TEXT_PLAIN)
                .add(HttpHeaderNames.CONTENT_LENGTH, content.readableBytes());
        ctx.writeAndFlush(response);
    }

}
