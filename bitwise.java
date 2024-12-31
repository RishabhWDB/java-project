public class bitwise {
    public static void main(String[] args) {
        int a = 4;
        int b = 7;
        //bitwise and
        // a and b become binary
        //0101 and 0111 = 0101 = 5
        System.out.println("a&b = "+(a&b));

        //bitwise or
        //0101 or 0111 = 0111 = 7
        System.out.println("a | b ="+(a|b));

        //bitwise xor
        //0101 xor 0111 = 0100
        System.out.println("a^b = "+ (a^b));

        //bitwise not
        //0101 = 1010
        //0111 = 1000
        System.out.println("~a ="+ ~a);
        System.out.println("~b=" + ~b);
    }
}
