import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static long[] tree;
    static int treeSize;
    static int startIdx;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int temp = N;
        int height = 0;
        while(temp != 0){
            temp = temp / 2;
            height++;
        }

        treeSize = (int) Math.pow(2, height + 1);
        tree = new long[treeSize];
        startIdx = (int) Math.pow(2, height);

        for (int i = startIdx; i < startIdx + N; i++) {
            tree[i] = Long.parseLong(br.readLine());
        }

        setTree();

        for (int i = 0; i < M + K; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            if(a == 1){
                int b = Integer.parseInt(st.nextToken());
                long c =  Long.parseLong(st.nextToken());
                changeTree(startIdx + b - 1, c);
            }else{
                int b = Integer.parseInt(st.nextToken());
                int c =  Integer.parseInt(st.nextToken());
                System.out.println(getSum(b + startIdx - 1,c + startIdx - 1));
            }
        }

    }

    static long getSum(int s, int e) {
        long sum = 0;
        while(s <= e){
            if(s % 2 == 1){
                sum += tree[s];
            }
            if(e % 2 == 0){
                sum += tree[e];
            }
            s = (s+1)/2;
            e = (e-1)/2;
        }
        return sum;
    }

    static void changeTree(int idx, long value) {
        long diff = value - tree[idx];
        while(idx > 0){
            tree[idx] = tree[idx] + diff;
            idx = idx / 2;
        }

    }

    static void setTree() {
        int idx = treeSize - 1;
        while(idx != 1){
            tree[idx/2] += tree[idx];
            idx--;
        }
    }


}

