
import java.util.Arrays;

/**
 * Created by Роман on 31.03.2017.
 */
public class Program {

    public static void main(String[] args) {

        try {
            new Program().throwable();
        }catch(MyUncheckedException | MyCheckedException e){
            System.out.println("Exception: ");
            System.out.println(e/*toString()*/);
            System.out.println("Cause of exception: ");
            System.out.println(e.getCause());
            System.out.println("Suppressed exception: ");
            System.out.println(Arrays.toString(e.getSuppressed()));
        }
    }

    void throwable() throws MyCheckedException {
        try(Worker worker = new Worker()){
            worker.work();
        }catch (MyUncheckedException e){
            e.initCause(new MyError());
            throw e;
        }
    }
}


//сделать РАЗЛИЧНЫЕ НАБОРЫ конструкторов!
