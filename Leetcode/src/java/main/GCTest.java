import java.lang.management.GarbageCollectorMXBean;
import java.lang.management.ManagementFactory;
import java.util.List;

/**
 * Created by look on 16/6/9.
 */
public class GCTest {
    public static void main(String[] args) {
        List<GarbageCollectorMXBean> gcs = ManagementFactory.getGarbageCollectorMXBeans();
        for (GarbageCollectorMXBean gcMxBean : gcs){
            System.out.println(gcMxBean.getObjectName());
        }
    }
}
