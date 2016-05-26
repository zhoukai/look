import java.math.BigDecimal;

/**
 * Created by look on 16/5/22.
 */
public class TestBigDecimal {

    public static void main(String[] args) {
        BigDecimal d = new BigDecimal("0.112");
        System.out.println(d.intValue());
        System.out.println(d.scale());
        System.out.println(d.unscaledValue());

        System.out.println(d.negate());
        System.out.println(d.negate().plus());

        d = new BigDecimal("100000");
        System.out.println(d.scale());
        System.out.println(d.unscaledValue());
        d = d.setScale(-2);
        System.out.println(d.unscaledValue());
    }
}
