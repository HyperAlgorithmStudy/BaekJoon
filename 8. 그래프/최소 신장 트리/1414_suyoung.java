import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    static int[] arr;
    static PriorityQueue<Edge> queue;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());

        queue = new PriorityQueue<>();
        int sum = 0; // 전체 랜선 길이

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            char[] tmp = st.nextToken().toCharArray();

            for (int j = 0; j < N; j++) {
                int value = 0;
                if(tmp[j] >= 'a' && tmp[j] <= 'z')
                    value = tmp[j] - 'a' + 1;
                else if(tmp[j] >= 'A' && tmp[j] <= 'Z')
                    value = tmp[j] - 'A' + 27;

                sum += value;

                if(value != 0 && i != j)
                    queue.add(new Edge(i, j, value));
            }

        }

        arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = i;
        }

        int edgeNum = 0;
        int ans = 0;
        while(!queue.isEmpty()){ 
            Edge now = queue.poll();
            if(find(now.start) != find(now.end)){
                ans += now.value;
                edgeNum++;
                union(now.start, now.end);
            }
        }

        if(edgeNum != N-1) // 모든 컴퓨터가 연결되어 있지 않을 때
            System.out.println(-1);
        else
            System.out.println(sum - ans);

    }
    static void union(int a, int b){
        arr[find(b)] = find(a);
    }
    static int find(int a){
        if(arr[a] == a) return a;
        return arr[a] = find(arr[a]);
    }
}

class Edge implements Comparable<Edge>{
    int start,end,value;

    public Edge(int start, int end, int value) {
        this.start = start;
        this.end = end;
        this.value = value;
    }

    @Override
    public int compareTo(Edge o) {
        return this.value - o.value;
    }
}
