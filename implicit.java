public class implicit {
    public static void main(String[] args) {
        //byte to int (widening)
        byte bytevalue = 10;
        int intvalue = bytevalue;
        System.out.println("Byte to int: "+intvalue);

        //double to float (narrowing)
        double doublevalue = 9.78666666666666;
        float floatvalue = (float) doublevalue;
        System.out.println("Double to float: "+floatvalue);

        //int to byte (narrowing)
        int i = 130;
        byte bytevalue1 = (byte) i;
        System.out.println("Int to byte: " +bytevalue1);
    }
}
