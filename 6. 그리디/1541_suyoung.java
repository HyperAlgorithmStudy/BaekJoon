import java.util.Scanner;

public class Main {

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String[] block = sc.nextLine().split("-");
        int ans = sum(block[0]);
        for (int i = 1; i < block.length; i++) {
            ans -= sum(block[i]);
        }
        System.out.println(ans);
    }

    static int sum(String s){
        String[] nums = s.split("[+]");
        int total = 0;
        for (String num : nums) {
            total += Integer.parseInt(num);
        }
        return total;
    }
}
