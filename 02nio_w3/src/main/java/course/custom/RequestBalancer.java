package course.custom;

import java.util.List;

/**
 * @author kun
 * @date 2022/3/20
 */
public interface RequestBalancer {

    String choose(List<String> candidates);
}
