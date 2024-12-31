public class randome {
    public static void main(String[] args) {
        int a = 8;
        int b = a << 2;
        int c = b >> 1;
        int d = c >>>2;
        int result = a&b | c^d;

        System.out.println(result);
    }
    
}
 