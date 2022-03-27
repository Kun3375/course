import java.util.Queue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.SynchronousQueue;

/**
 * @author kun
 * @date 2022/3/27
 */
public class Answer03 {

    private static final BlockingQueue<String> QUEUE = new SynchronousQueue<>();

    public static void main(String[] args) throws InterruptedException {
        new Thread(() -> {
            try {
                QUEUE.put(AsyncResult.random());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();
        System.out.println(QUEUE.take());
    }
}
