/**
 * Created by look on 16/6/11.
 */
public class CloneTest implements Cloneable{
    private int a = 0;

    @Override
    public CloneTest clone(){
     return null;
    }

    public static void main(String[] args) {
        CloneTest clone = new CloneTest();
        clone.clone();
    }
}
