package course.custom;

import io.netty.buffer.Unpooled;
import io.netty.handler.codec.http.*;
import okhttp3.*;

import java.io.IOException;

/**
 * @author kun
 * @date 2022/3/20
 */
public class OkRequest {

    private static final MediaType PLAIN = MediaType.get(HttpHeaderValues.TEXT_PLAIN.toString());

    private static final OkHttpClient CLIENT = new OkHttpClient.Builder().build();

    public DefaultFullHttpResponse exec(String target, FullHttpRequest request) throws IOException {
        String contentType = request.headers().get(HttpHeaderNames.CONTENT_TYPE);
        Request r = new Request.Builder()
                .url(target + request.uri())
                .method(
                        request.method().name(),
                        request.method() == HttpMethod.GET ? null :
                                RequestBody.create(
                                        contentType == null ? PLAIN : MediaType.parse(contentType),
                                        request.content().toString()
                                )
                )
                .build();
        Response resp = CLIENT.newCall(r).execute();
        ResponseBody body = resp.body();
        DefaultHttpHeaders h = new DefaultHttpHeaders();
        resp.headers().toMultimap().forEach(h::add);
        return new DefaultFullHttpResponse(
                HttpVersion.HTTP_1_1,
                HttpResponseStatus.valueOf(resp.code()),
                body == null ? Unpooled.EMPTY_BUFFER : Unpooled.copiedBuffer(body.bytes()),
                h, EmptyHttpHeaders.INSTANCE);
    }
}
