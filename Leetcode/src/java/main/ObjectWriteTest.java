import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by look on 16/6/10.
 */
public class ObjectWriteTest {
    public static void main(String[] args) throws IOException {
        ObjectOutputStream os = new ObjectOutputStream(new FileOutputStream("a.txt"));
        char c = 'a';
        os.writeChar(c);
        os.close();
        List aList = new ArrayList();

    }
}
