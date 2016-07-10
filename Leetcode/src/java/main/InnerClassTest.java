/**
 * Created by look on 16/6/10.
 */
public class InnerClassTest {
    private int a;

    private class InnerClass{
        private  int b;

        public void getSome(){
            int a = InnerClassTest.this.a;
        }
    }

    public static void main(String[] args) {
        InnerClassTest test = new InnerClassTest();
        InnerClass innerClass = test.new InnerClass();
    }
}
