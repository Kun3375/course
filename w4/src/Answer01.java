import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

/**
 * @author kun
 * @date 2022/3/27
 */
public class Answer01 {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        CompletableFuture<String> future = CompletableFuture.supplyAsync(AsyncResult::random);
        System.out.println(future.get());
    }

}
