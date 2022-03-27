/**
 * @author kun
 * @date 2022/3/27
 */
public class Answer08 {

    private static volatile String R;
    private static final Object MONITOR = new Object();

    public static void main(String[] args) throws InterruptedException {
        synchronized (MONITOR) {
            new Thread(() -> {
                synchronized (MONITOR) {
                    R = AsyncResult.random();
                    MONITOR.notifyAll();
                }
            }).start();
            MONITOR.wait();
            System.out.println(R);
        }

    }
}
