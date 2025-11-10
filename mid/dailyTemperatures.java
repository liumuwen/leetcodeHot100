package mid;
import java.util.*;
import java.util.stream.Collectors;

public class dailyTemperatures {

    public static int[] dailyTemperatures(int[] temperatures) {
        int[] res = new int[temperatures.length];
        Deque<Integer> dq = new LinkedList<>();
        dq.push(0);
        for(int i = 1;i < temperatures.length;i++){
            while(!dq.isEmpty() && temperatures[i] > temperatures[dq.peek()]){
                int index = dq.pop();
                res[index] = i - index;
            }
            dq.push(i);
        }
        return res;
    }
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String line = sc.nextLine();
        int[] temperatures = Arrays.stream(line.split(",")).mapToInt(Integer::parseInt).toArray();
        int[] res= dailyTemperatures(temperatures);
        System.out.println(Arrays.toString(res));
    }
}
