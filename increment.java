class increment {
    public static void main(String[] args) {
        /*int x = 2;
        System.out.println("before prefix increment: "+ x);
        int y = ++x;
        System.out.println("after prefix increment: " + y);
        */

        int a = 1;
        int b = 2;
        int c;
        int d;
        c = ++b;
        d = a++;
        c++;
        System.out.println("a = " + a);
        System.out.println("b = "+ b);
        System.out.println("c = "+ c);
        System.out.println("d = "+ d);

    }
}