package mid;
import java.util.*;
public class sortColors {

    public static int slow = 0;
    public static void sortColors(int[] nums) {
        for(int i = 0;i < 3;i++){
            doublePointer(nums,i);
        }
        System.out.println(Arrays.toString(nums));
    }

    public static void doublePointer(int[]nums,int i){
        int fast = slow;
        while(fast < nums.length){
            if(nums[fast] == i){
                int tmp = nums[fast];
                nums[fast] = nums[slow];
                nums[slow] = tmp;
                slow++;
            }
            fast++;
        }
    }
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String line = sc.nextLine();
        int[] nums = Arrays.stream(line.split(",")).mapToInt(Integer::parseInt).toArray();
        sortColors(nums);
    }
}
