import java.util.HashSet;
import java.util.Set;

/**
 * Created by look on 16/6/29.
 */
public class ObjectTest {
    @Override
    public boolean equals(Object obj) {
        System.out.println("calling equals");
        return super.equals(obj);
    }

    @Override
    public int hashCode() {
        System.out.println("calling hashCode");
        return 1;
    }

    public static void main(String[] args) {
        ObjectTest o1 = new ObjectTest();
        ObjectTest o2 = new ObjectTest();
        Set<ObjectTest> set = new HashSet<>();
        set.add(o1);
        set.add(o2);
        System.out.println("==============");
        set.contains(o1);
        set.contains(o2);
    }
}
