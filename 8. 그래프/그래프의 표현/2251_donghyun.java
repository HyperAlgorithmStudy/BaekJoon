import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
    static int[] Sender = {0, 0, 1, 1, 2, 2};
    static int[] Receiver = {1, 2, 0 ,2, 0, 1};
    static boolean visit[][];
    static boolean answer[];
    static int now[];

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        now = new int[3]; // A, B, C 물통
        now[0] = sc.nextInt(); // 각 물통 크기들
        now[1] = sc.nextInt();
        now[2] = sc.nextInt();
        visit = new boolean[201][201]; // 최대가 200이라?
        answer = new boolean[201];
        bfs();
        for(int i = 0 ; i < answer.length; i++){
            if(answer[i])
                System.out.print(i+ " ");
        }
    }

    public static void bfs() {
        Queue<Bucket> q = new LinkedList<>();
        q.add(new Bucket(0,0));
        visit[0][0] = true;
        answer[now[2]] = true;
        while(!q.isEmpty()){
            Bucket bucket = q.poll();
            int a = bucket.a;
            int b = bucket.b;
            int c = now[2] - a - b; // C는 전체 물 양에서 A와 B를 뺀 것

            for(int i = 0; i < 6; i++){
                int[] next = {a, b, c};
                next[Receiver[i]] += next[Sender[i]];
                next[Sender[i]] = 0;
                if(next[Receiver[i]] > now[Receiver[i]]){ // 물이 넘칠 때
                    // 초과하는 만큼 다시 이전 물통에 넣어 줌
                    next[Sender[i]] = next[Receiver[i]] - now[Receiver[i]];
                    next[Receiver[i]] = now[Receiver[i]];
                }

                if(!visit[next[0]][next[1]]){ // A와 B의 물의 양을 이용해 방문 배열 체크
                    visit[next[0]][next[1]] = true;
                    q.add(new Bucket(next[0], next[1]));
                    if(next[0] == 0) // A의 물의 양이 0일 때 C의 물의 무게를 정답 변수에 저장
                        answer[next[2]] = true;

                }

            }
        }
    }
}

class Bucket {
    int a;
    int b;

    public Bucket(int a, int b) {
        this.a = a;
        this.b = b;
    }
}

/* 노가다 방식!
import java.util.*;

public class Main {
        static int a, b, c;
        static boolean[][][] visit;

        public static void main(String[] args) {
            Scanner sc = new Scanner(System.in);
            a = sc.nextInt(); // 8
            b = sc.nextInt();; // 9
            c = sc.nextInt();; // 10
            visit = new boolean[a + 1][b + 1][c + 1];

            ArrayList<int[]> list = new ArrayList<>();
            ArrayList<Integer> ans = new ArrayList<>();
            Queue<int[]> q = new LinkedList<>();

            q.add(new int[]{0, 0, c}); // 시작할 때는 C만 물이 있기 때문에

           while (!q.isEmpty()) {
                int[] temp = q.poll(); // {0, 0, 10}

                // 확인했던 용량이면 패스
                if (visit[temp[0]][temp[1]][temp[2]])
                    continue;
                // 확인안했다면 체크하고
                visit[temp[0]][temp[1]][temp[2]] = true;

                // 만약 a물통이 비었다면 c물통에 담긴 물 양 답에 저장
                if (temp[0] == 0)
                    ans.add(temp[2]);

                // a물통, b물통
                if (temp[0] + temp[1] > a) { // 합이 a보다 크면, a 다 채우고 나머지 b
                    q.add(new int[]{a, temp[0] + temp[1] - a, temp[2]});
                } else { // 합이 a보다 작으면, 전부 a로 옮기기
                    q.add(new int[]{temp[0] + temp[1], 0, temp[2]});
                }

                if (temp[0] + temp[1] > b) { // 합이 b보다 크면, b 다 채우고 나머지 a
                    q.add(new int[]{temp[0] + temp[1] - b, b, temp[2]});
                } else { // 합이 b보다 작으면, 전부 b로 옮기기
                    q.add(new int[]{0, temp[0] + temp[1], temp[2]});
                }

                // a물통, c물통
                if (temp[0] + temp[2] > a) { // 합이 a보다 크면, a 다 채우고 나머지 c
                    q.add(new int[]{a, temp[1], temp[0] + temp[2] - a});
                } else { // 합이 a보다 작으면, 전부 a로 옮기기
                    q.add(new int[]{temp[0] + temp[2], temp[1], 0});
                }

                if (temp[0] + temp[2] > c) { // 합이 c보다 크면, c 다 채우고 나머지 a
                    q.add(new int[]{temp[0] + temp[2] - c, temp[1], c});
                } else { // 합이 c보다 작으면, 전부 c로 옮기기
                    q.add(new int[]{0, temp[1], temp[0] + temp[2]});
                }

                // b물통, c물통
                if (temp[1] + temp[2] > b) { // 합이 b보다 크면, b 다 채우고 나머지 c
                    q.add(new int[]{temp[0], b, temp[1] + temp[2] - b});
                } else { // 합이 b보다 작으면, 전부 b로 옮기기
                    q.add(new int[]{temp[0], temp[1] + temp[2], 0});
                }

                if (temp[1] + temp[2] > c) { // 합이 c보다 크면, c 다 채우고 나머지 b
                    q.add(new int[]{temp[0], temp[1] + temp[2] - c, c});
                } else { // 합이 c보다 작으면, 전부 c로 옮기기
                    q.add(new int[]{temp[0], 0, temp[1] + temp[2]});
                }
            }

            Collections.sort(ans);
            for (int i = 0; i < ans.size(); i++)
                System.out.print(ans.get(i) + " ");
        }
    }


*/
