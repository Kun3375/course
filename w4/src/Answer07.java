import java.util.concurrent.atomic.AtomicStampedReference;

/**
 * @author kun
 * @date 2022/3/27
 */
public class Answer07 {

    private static final AtomicStampedReference<String> REFERENCE = new AtomicStampedReference<>(null, 1);

    public static void main(String[] args) {
        new Thread(() -> {
            REFERENCE.compareAndSet(null, AsyncResult.random(), 1, 2);
        }).start();
        while (true) {
            if (REFERENCE.getStamp() == 2) {
                break;
            }
        }
        System.out.println(REFERENCE.getReference());
    }
}
