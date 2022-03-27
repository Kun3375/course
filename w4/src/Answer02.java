/**
 * @author kun
 * @date 2022/3/27
 */
public class Answer02 {

    private static volatile String r;

    public static void main(String[] args) {
        new Thread(() -> {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            r = AsyncResult.random();
        }).start();
        // or join
        while (r == null) {
            // do nothing or sleep
        }
        System.out.println(r);
    }
}
