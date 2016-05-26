/**
 * Created by look on 16/6/4.
 */
public class TestInitOrder {

    public void TestInitOrder() {
        System.out.println("Object constructor");
    }


    static{
        System.out.println("Class init block");
    }

    private String s = null;



    {
        System.out.println("Object init block");
    }

    public static void main(String[] args) {
        new TestInitOrder().TestInitOrder();
    }
}
