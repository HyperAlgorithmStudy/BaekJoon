import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        int[] left = new int[N];
        int[] right = new int[N];
        left[0] = arr[0];
        int max = left[0]; // 0이 아님!!!!
        right[N-1] = arr[N-1];
        for (int i = 1; i < N; i++) {
            left[i] = Math.max(arr[i], left[i-1] + arr[i]);
            max = Math.max(left[i], max); // 1개도 제거하지 않을 때
        }
        for (int i = N-2; i >= 0; i--) {
            right[i] = Math.max(arr[i], right[i+1] + arr[i]);
        }
        for (int i = 1; i < N-1; i++) {
            max = Math.max(left[i-1] + right[i+1], max); // i번째 값 제거할 때
        }
        System.out.println(max);

    }
}
