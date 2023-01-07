import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        ArrayList<ArrayList<Integer>> arr = new ArrayList<>();
        for (int i = 0; i <= N ; i++) {
            arr.add(new ArrayList<>());
        }

        int[] time = new int[N+1]; // 각 건물을 짓는데 걸리는 시간
        int[] indegree = new int[N+1]; // 진입 차수 배열
        int[] ans = new int[N+1];

        for (int i = 1; i <= N; i++) {
            time[i] = sc.nextInt();
            int node = sc.nextInt();
            while(node != -1){
                arr.get(node).add(i);
                indegree[i]++;
                node = sc.nextInt();
            }
        }

        // 위상 정렬
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 1; i <= N ; i++) {
            if(indegree[i] == 0)
                queue.add(i);
        }
        while(!queue.isEmpty()){
            int now = queue.poll();
            for (Integer i : arr.get(now)) {
                indegree[i]--;
                ans[i] = Math.max(ans[now] + time[now], ans[i]); // indegree가 0인 노드 여러 개에 같은 인접 노드가 있을 때
                if(indegree[i] == 0)
                    queue.add(i);
            }
        }
        for (int i = 1; i <= N ; i++) {
            System.out.println(ans[i]+time[i]);
        }

    }

}
