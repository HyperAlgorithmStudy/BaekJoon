import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] arr = new int[10000001]; // 1003001
        for (int i = 2; i < arr.length; i++) {
            arr[i] = i;
        }
        for (int i = 2; i <= Math.sqrt(arr.length); i++) { // N이 아닌 arr.length
            if (arr[i] == 0) continue;
            for (int j = 2 * i; j < arr.length; j += i) { // i의 배수
                arr[j] = 0;
            }
        }
        int i = N;
        while(true){
            if(arr[i] != 0){
                if(isPalindrome(arr[i])){
                    System.out.println(arr[i]); break;
                }
            }
            i++;
        }
    }
    static boolean isPalindrome(int num){
        char[] chars = String.valueOf(num).toCharArray();
        int s = 0;
        int e = chars.length-1;
        while(s < e){
            if(chars[s] != chars[e]) return false;
            s++;
            e--;
        }
        return true;
    }
}
