import java.util.concurrent.Semaphore;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author kun
 * @date 2022/3/27
 */
public class Answer06 {

    private static volatile String R;
    private static Lock LOCK = new ReentrantLock();
    private static Condition OK = LOCK.newCondition();

    public static void main(String[] args) throws InterruptedException {
        LOCK.lock();
        try {
            new Thread(() -> {
                LOCK.lock();
                try {
                    R = AsyncResult.random();
                    OK.signalAll();
                } finally {
                    LOCK.unlock();
                }
            }).start();
            OK.await();
            System.out.println(R);
        } finally {
            LOCK.unlock();
        }
    }
}
