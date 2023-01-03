import java.util.Arrays;
import java.util.Scanner;

public class Main {
    static int[] arr;

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = sc.nextInt();
        }
        Arrays.sort(arr);

        int M = sc.nextInt();
        for (int i = 0; i < M; i++) {
            binary(sc.nextInt());
        }
    }
    static void binary(int target){
        int start = 0;
        int end = arr.length - 1;
        while(start <= end){
            int mid = (start + end) / 2;
            int midValue = arr[mid];
            if(midValue > target){
                end = mid - 1;
            }else if(midValue < target){
                start = mid + 1;
            }else{
                System.out.println(1);
                return;
            }
        }
        System.out.println(0);
    }

}
