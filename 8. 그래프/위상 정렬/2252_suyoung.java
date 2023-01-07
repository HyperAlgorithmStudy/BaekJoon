import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
    static ArrayList<Integer>[] arr;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();

        arr = new ArrayList[N+1];
        for (int i = 0; i <= N ; i++) {
            arr[i] = new ArrayList<>();
        }

        int[] indegree = new int[N+1]; // 진입 차수: 방향이 자신 쪽으로 향하는 간선의 수

        for (int i = 0; i < M; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            arr[a].add(b);
            indegree[b]++;
        }
        
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 1; i <= N ; i++) {
            if(indegree[i] == 0)
                queue.add(i);
        }
        while(!queue.isEmpty()){
            int now = queue.poll();
            System.out.print(now+" ");

            for (Integer i : arr[now]) {
                indegree[i]--;
                if(indegree[i] == 0)
                    queue.add(i);
            }
        }

    }

}

// 메서드 이용

/*
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
    static ArrayList<Integer>[] arr;
    static int[] indegree;
    static ArrayList<Integer> result;
    static int N;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        int M = sc.nextInt();

        arr = new ArrayList[N+1];
        for (int i = 0; i <= N ; i++) {
            arr[i] = new ArrayList<>();
        }

        indegree = new int[N+1];

        for (int i = 0; i < M; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            arr[a].add(b);
            indegree[b]++;
        }
        result = new ArrayList<>();
        topoplogySort();
        for (Integer i : result) {
            System.out.print(i + " ");
        }

    }
    static void topoplogySort(){
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 1; i <= N ; i++) {
            if(indegree[i] == 0){
                queue.add(i);
                result.add(i);
            }
        }
        while(!queue.isEmpty()){
            int now = queue.poll();
            for (Integer i : arr[now]) {
                indegree[i]--;
                if(indegree[i] == 0){
                    queue.add(i);
                    result.add(i);
                }
            }
        }
    }
    

}*/
