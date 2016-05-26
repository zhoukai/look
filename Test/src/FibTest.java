public class FibTest {
    private static long count = 0;


    public static long fib(int n) {
        long[] fibs = new long[n+1];

        return _fib(n, fibs);
    }

    public static long _fib(int n, long[] fibs) {
        count++;
        System.out.println(n);
        if (n == 0){
            return 0;
        }
        long result = fibs[n];
        if (result == 0) {
            if (n == 1) {
                result = n;
            } else {
                result = _fib(n - 1, fibs) + _fib(n - 2, fibs);
            }
            fibs[n - 1] = result;
        }
        return result;
    }

    public static void main(String[] args) {
        long result = fib(100);
        System.out.println(count+":"+result);
    }
}
