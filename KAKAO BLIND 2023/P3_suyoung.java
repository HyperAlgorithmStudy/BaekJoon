class Solution {
    static int[] result;
    static int[] discount;
  
    public int[] solution(int[][] users, int[] emoticons) {
        discount = new int[emoticons.length];
        result = new int[2];
        dfs(users, emoticons, 0);
        return result;
    }
  
    void dfs(int[][] users, int[] emoticons, int depth){
        if(depth == emoticons.length) {
            compare(sales(users, emoticons));
            return;
        }

        for (int i = 10; i <= 40; i+=10) {
            discount[depth] = i;
            dfs(users, emoticons,  depth+1);
        }
    }
  
    void compare(int[] temp){
        if(temp[0] > result[0]){
            result[0] = temp[0];
            result[1] = temp[1];
        }else if(temp[0] == result[0] && temp[1] > result[1]){
            result[1] = temp[1];
        }
    }

    int[] sales(int[][] users, int[] emoticons){
        int[] result = new int[2];
        for (int[] user : users) {
            int total = 0;
            for (int j = 0; j < emoticons.length; j++) {
                if (user[0] <= discount[j]) {
                    total += emoticons[j] * (100 - discount[j]) / 100;
                }
            }
            if (user[1] <= total) {
                result[0]++;
            } else {
                result[1] += total;
            }
        }
        return result;
    }
}
