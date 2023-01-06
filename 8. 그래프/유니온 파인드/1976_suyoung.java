import java.io.IOException;
import java.util.Scanner;

public class Main {
    static int[] arr;
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();
      
        // 대표 노드 자기 자신으로 초기화
        arr = new int[N+1]; 
        for (int i = 1; i <= N; i++) {
            arr[i] = i;
        }
      
        // 도시가 연결되었으면 union 실행
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                int node = sc.nextInt();
                if(node == 1) union(i,j); 
            }
        }
      
        // 여행 경로 저장
        int[] travel = new int[M]; 
        for (int i = 0; i < M; i++) {
            travel[i] = sc.nextInt();
        }
      
        // 여행 도시들이 같은 대표 도시로 연결돼 있는지 확인
        for (int i = 1; i < M; i++) { 
            if(find(travel[i-1]) != find(travel[i])){ 
                System.out.println("NO");
                return;
            }
        }
        System.out.println("YES");
    }
  
    static void union(int a, int b){
        arr[find(b)] = find(a);
    }
    static int find(int a){
        if(arr[a] == a) return a;
        return arr[a] = find(arr[a]); // 경로 압축
    }

}
