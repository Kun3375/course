/**
 * @author kun
 * @date 2022/3/27
 */
public class Answer09 {

    private static volatile String R;
    public static void main(String[] args) {
        Thread main = Thread.currentThread();
        new Thread(() -> {
            try {
                // the thread can sleep even more time.
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            R = AsyncResult.random();
            main.interrupt();
        }).start();
        // just be stronger
        if (main.isInterrupted()) {
            System.out.println(R);
        }
        // get result by interrupt flag
        try {
            Thread.sleep(Long.MAX_VALUE);
        } catch (InterruptedException e) {
            System.out.println(R);
        }
    }
}
