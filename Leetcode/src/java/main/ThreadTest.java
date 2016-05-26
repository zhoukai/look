/**
 * Created by look on 2017/2/26.
 */
public class ThreadTest {

    public ThreadTest clone() throws CloneNotSupportedException {
        return (ThreadTest) super.clone();
    }

    public static void main(String[] args) throws CloneNotSupportedException {
        ThreadTest test = new ThreadTest();
        test.clone();


        Thread loopThread = new Thread(() -> {while(true){
            System.out.println("hello");
        }});
        loopThread.start();
        loopThread.interrupt();
        Runtime runtime = Runtime.getRuntime();

        Object object = new Object();


    }
}
