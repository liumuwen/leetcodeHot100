package mid;
import java.util.*;
public class exist {
    public static boolean res = false;
    public static int[][] dirs = new int[][]{{0,1},{0,-1},{1,0},{-1,0}};
    public static boolean exist(char[][] board, String word){
        int m = board.length;
        int n = board[0].length;
        boolean[][] visited = new boolean[m][n];
        for(int i = 0;i < m;i++){
            for(int j = 0;j < n;j++){
                if(board[i][j] == word.charAt(0)){
                    dfs(board,word,visited,i,j,0);
                    if(res){
                        return true;
                    }
                }
            }
        }
        return false;
    }
    public static void dfs(char[][] board, String word,boolean[][] visited, int i, int j, int start){
        if(start == word.length()-1){
            res = true;
            return;
        }
        visited[i][j] = true;
        for(int[] dir : dirs){
            int ni = i + dir[0];
            int nj = j + dir[1];
            if(ni < 0 || ni >= board.length || nj < 0 || nj >= board[0].length
                    || visited[ni][nj]
                    || board[ni][nj] != word.charAt(start+1)){
                continue;
            }
            dfs(board,word,visited,ni,nj,start+1);
        }
    }
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int m = sc.nextInt();
        int n = sc.nextInt();
        System.out.println(m + ":" + n);
        sc.nextLine();//吃一个换行符
        char[][] board = new char[m][n];
        for(int i = 0;i < m;i++){
            board[i] = String.join("",sc.nextLine().split(",")).toCharArray();
        }
        String word = sc.nextLine();
        for(char[] b : board){
            System.out.println(Arrays.toString(b));
        }
        System.out.println(word);
        System.out.println(exist(board,word));
    }
}
