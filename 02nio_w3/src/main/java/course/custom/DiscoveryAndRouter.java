package course.custom;

import io.netty.handler.codec.http.HttpRequest;

import java.util.List;

/**
 * @author kun
 * @date 2022/3/20
 */
public interface DiscoveryAndRouter {

    List<String> get(HttpRequest msg);
}
