/**
 * @author kun
 * @date 2022/3/27
 */
public class Answer10 {

    private static volatile String R;

    public static void main(String[] args) {
        new Thread(() -> {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            R = AsyncResult.random();
        }).start();
        while (R == null) {
            // it's same with Answer02, but it can be more graceful after JDK9
            Thread.onSpinWait();
        }
        System.out.println(R);
    }
}
