package course.custom;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author kun
 * @date 2022/3/20
 */
public class RoundRobinBalancer implements RequestBalancer {

    private final AtomicInteger last = new AtomicInteger(0);

    @Override
    public String choose(List<String> candidates) {
        return candidates.get(last.incrementAndGet() % candidates.size());
    }
}
