import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        char[] arr1 = br.readLine().toCharArray();
        char[] arr2 = br.readLine().toCharArray();
        int[][] D = new int[arr1.length + 1][arr2.length + 1];
        for (int i = 1; i <= arr1.length; i++) {
            for (int j = 1; j <= arr2.length; j++) {
                if(arr1[i-1] == arr2[j-1])
                    D[i][j] = D[i - 1][j - 1] + 1; // 첫 번째 줄도 점화식으로 구하기 위해 인덱스 1부터
                else
                    D[i][j] = Math.max(D[i-1][j], D[i][j-1]); // 왼쪽, 위쪽 중 큰 수

            }
        }
        System.out.println(D[arr1.length][arr2.length]);

        Stack<Character> stack = new Stack<>();
        int i = arr1.length;
        int j = arr2.length;
        while(i >= 1 && j >= 1){
            if(D[i][j] == D[i-1][j]) // 위와 같을 때 위로 이동
                i--;
            else if(D[i][j] == D[i][j-1]) // 왼쪽과 같을 때 왼쪽으로 이동
                j--;
            else{
                stack.push(arr1[i-1]);
                i--; j--; // 대각선으로 이동
            }
        }
        while(!stack.isEmpty())
            System.out.print(stack.pop());
    }
}
