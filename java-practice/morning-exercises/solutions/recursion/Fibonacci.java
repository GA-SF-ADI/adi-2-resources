public class Fibonacci{
    public static int fibonacci(int fibIndex) {
        if (fibIndex == 0) {
         return 0;
     } else if (fibIndex == 1) {
         return 1;
     } else {
         return fibonacci(fibIndex - 1) + fibonacci(fibIndex - 2);
      }
    }
}