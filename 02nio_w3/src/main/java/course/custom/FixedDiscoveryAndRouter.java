package course.custom;

import io.netty.handler.codec.http.HttpRequest;

import java.util.*;

/**
 * @author kun
 * @date 2022/3/20
 */
public class FixedDiscoveryAndRouter implements DiscoveryAndRouter {

    private final Map<String, List<String>> candidates;

    public FixedDiscoveryAndRouter() {
        Map<String, List<String>> map = new HashMap<>(4);
        List<String> c1 = new ArrayList<>(2);
        c1.add("http://localhost:8900");
        c1.add("http://localhost:8901");
        map.put("test1", Collections.unmodifiableList(c1));
        List<String> c2 = new ArrayList<>(2);
        c2.add("http://localhost:8800");
        c2.add("http://localhost:8801");
        map.put("test2", Collections.unmodifiableList(c2));
        candidates = Collections.unmodifiableMap(map);
    }

    @Override
    public List<String> get(HttpRequest msg) {
        String uri = msg.uri();
        String[] split = uri.split("/");
        if (split.length == 0) {
            return Collections.emptyList();
        }
        uri = split[1];
        if (split.length > 2) {
            return candidates.getOrDefault(uri, Collections.emptyList());
        }
        int i = uri.indexOf("?");
        if (i == -1) {
            return candidates.getOrDefault(uri, Collections.emptyList());
        }
        return candidates.getOrDefault(uri.substring(0, i), Collections.emptyList());
    }
}
