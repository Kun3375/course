import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author kun
 * @date 2022/3/27
 */
public class Answer04 {

    private static ExecutorService EXEC = Executors.newSingleThreadExecutor();

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        System.out.println(EXEC.submit(AsyncResult::random).get());
        EXEC.shutdown();
    }
}
