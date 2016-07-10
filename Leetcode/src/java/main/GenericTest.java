import java.util.ArrayList;
import java.util.List;

/**
 * Created by look on 16/6/4.
 */
public class GenericTest {

    public static class A {

    }

    public static class B extends A{

    }

    public static void process(List<? extends A> list){
    }

    public static void process2(List<? super A> list){
    }

    public static void main(String[] args) {
        List<A> alist = new ArrayList<>();
        List<? super A> list = alist;
        B b = new B();
        A a = new A();

        list.add(a);

        list.add(b);


//        process(list);

//        process2(list)
    }
}
