package mid;
import java.util.*;
public class canPartition {

    public static boolean canPartition(int[] nums){
        if(nums.length == 0){
            return true;
        }
        int sum = Arrays.stream(nums).sum();
        if(sum % 2 != 0){
            return false;
        }
        int target = sum / 2;
        int[] dp = new int[target+1];
        for(int i = 0;i < nums.length;i++){
            for(int j = target;j >= nums[i];j--){
                dp[j] = Math.max(dp[j],dp[j-nums[i]] + nums[i]);
            }
        }
        return dp[target] == target;
    }
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String oriStr = sc.nextLine();
        String str = oriStr.substring(1,oriStr.length()-1);
        String[] strs = str.split(",");
        int[] nums = new int[strs.length];
        for(int i = 0;i < nums.length;i++){
            nums[i] = Integer.parseInt(strs[i].trim());
        }
        System.out.println(canPartition(nums));
    }
}
