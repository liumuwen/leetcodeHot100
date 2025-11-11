package mid;
import java.util.*;

public class canFinish {


//采用拓扑排序
    public static boolean canFinish(int numCourses, int[][] prerequisites){
        Map<Integer,List> map = new HashMap<>();
        Deque<Integer> dq = new LinkedList<>();
        int[] degree = new int[numCourses];
        for(int[] pre : prerequisites){
            List list = map.getOrDefault(pre[1], new ArrayList<Integer>());
            list.add(pre[0]);
            map.put(pre[1],list);
            degree[pre[0]]++;
        }
        for(int i =0;i < degree.length;i++){
            if(degree[i] == 0){
                dq.offer(i);
            }
        }
        while(!dq.isEmpty()){
            int c = dq.poll();
            List<Integer> nexts = map.get(c);
            if(nexts == null){
                continue;
            }
            for(int next : nexts){
                degree[next]--;
                if(degree[next] == 0){
                    dq.offer(next);
                }
            }
        }
        for(int d : degree){
            if(d != 0){
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int numCourse = sc.nextInt();
        int len = sc.nextInt();
        int[][] pres = new int[len][2];
        for(int i = 0;i < len;i++){
            pres[i][0] = sc.nextInt();
            pres[i][1] = sc.nextInt();
        }
        String res = canFinish(numCourse,pres) ? "true" : "false";
        System.out.println(res);
    }
}
