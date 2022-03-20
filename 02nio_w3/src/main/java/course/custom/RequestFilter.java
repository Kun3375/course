package course.custom;

import io.netty.handler.codec.http.HttpMessage;

/**
 * @author kun
 * @date 2022/3/20
 */
public interface RequestFilter {

    boolean check(HttpMessage msg);
}
