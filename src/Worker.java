
import java.util.Random;

public class Worker implements AutoCloseable {

    public static Random random = new Random();

    @Override
    public void close() throws MyCheckedException {
        if (random.nextBoolean()) {

            /**
             * Пробросить выше (throws)
             * нет возможности, так как мы не можем нарушать
             * изменять обЪявление переопределяемого метода close()
             */
            throw new MyCheckedException();
        }
    }

    void work() /*throws MyUncheckedException*/ {
        if (random.nextBoolean()) {
            throw new MyUncheckedException();
        }
    }
}
