package course.custom;

import io.netty.handler.codec.http.HttpMessage;

/**
 * @author kun
 * @date 2022/3/20
 */
public class CheckTokenFilter implements RequestFilter {

    @Override
    public boolean check(HttpMessage msg) {
        // mock. the request that it has header 'token' is illegal
        return msg.headers().contains("token");
    }
}
