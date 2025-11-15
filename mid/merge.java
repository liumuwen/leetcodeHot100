package mid;
import java.util.*;
public class merge {

    public static int[][] merge(int[][] intervals){
        Arrays.sort(intervals,(a,b)->{
            if(a[0] == b[0]){
                return a[1] - b[1];
            }
            return a[0] - b[0];
        });
        Deque<int[]> dq = new LinkedList<>();
        dq.push(intervals[0]);
        for(int i = 1;i < intervals.length;i++){
            if(dq.peek()[1] >= intervals[i][0]){
                // dq相关的
                int[] tmp = dq.pop();
                tmp[1] = Math.max(tmp[1],intervals[i][1]);
                dq.push(tmp);
            }else{
                dq.push(intervals[i]);
            }
        }
        int[][] res = new int[dq.size()][2];
        int n = dq.size();
        for(int i = 0;i < n;i++){
            // 你这里的n能替换成dq.size()吗
            res[n - i - 1] = dq.pop();
        }
        return res;
    }

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[][] intervals = new int[n][2];
        for(int i = 0;i < n;i++){
            intervals[i][0] = sc.nextInt();
            intervals[i][1] = sc.nextInt();
        }
        int[][] res = merge(intervals);
        for(int[] r : res){
            System.out.println(r[0] + ":" + r[1]);
        }
        sc.close();
    }
}
