public class practen {
    public static void main(String[] args) {
        int[] arr = {10,20,30};
        for(int x : arr) {
            x = x+5;
        }
        System.out.println(arr[0]);
    }
}
