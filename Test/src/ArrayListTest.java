import java.lang.reflect.Field;
import java.util.ArrayList;

public class ArrayListTest {
    public static void main(String[] args) throws NoSuchFieldException, IllegalAccessException {
        ArrayList list = new ArrayList();
        Class clazz = list.getClass();
        Field elementDataField = clazz.getDeclaredField("elementData");
        elementDataField.setAccessible(true);
        for(int i=0; i< 1000;i++){
            list.add(i);
            Object[] elementData = (Object[]) elementDataField.get(list);
            System.out.println(""+elementData.length);
        }
    }
}
