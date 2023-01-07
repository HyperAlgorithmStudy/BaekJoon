import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
    static int[] arr;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();

        arr = new int[N+1];
        for (int i = 1; i <= N; i++) {
            arr[i] = i;
        }
        int truthNum = sc.nextInt();
        int[] truthArr = new int[truthNum];
        for (int i = 0; i < truthNum; i++) {
            truthArr[i] = sc.nextInt();
        }

        int[] party = new int[M]; // 각 파티 첫 노드 저장
        for (int i = 0; i < M; i++) {
            int partyPeople = sc.nextInt();
            int first = sc.nextInt();
            party[i] = first;
            for (int j = 1; j < partyPeople; j++) {
                int next = sc.nextInt();
                union(first, next);
                first = next;
            }
        }

        int cnt = 0;
        for (int i = 0; i < M; i++) {
            boolean success = true;
            for (int j : truthArr) {
                if(find(party[i]) == find(j)){
                    success = false; // i번 파티는 진실
                    break;
                }
            }
            if(success) cnt++;
        }
        System.out.println(cnt);

    }
    static void union(int a, int b){
        arr[find(b)] = find(a);
    }
    static int find(int a){
        if(arr[a] == a) return a;
        return arr[a] = find(arr[a]);
    }

}
