package mid;
import java.util.*;

public class findTargetSumWays {
    public static int findTargetSumWays(int[] nums, int target){
        int sum = Arrays.stream(nums).sum() + target;
        if(sum % 2 != 0){
            return 0;
        }
        int weights = sum / 2;
        int[] dp = new int[weights+1];
        dp[0] = 1;
        for(int num : nums){
            for(int j = weights;j >= num;j--){
                dp[j] += dp[j-num];
            }
        }
        return dp[weights];
    }
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String oriStr = sc.nextLine();
        int beginArr = oriStr.indexOf('[')+1;
        int endinArr = oriStr.indexOf(']');
        String[] strs = oriStr.substring(beginArr,endinArr).split(",");
        int[] nums = new int[strs.length];
        for(int i = 0;i < strs.length;i++){
            nums[i] = Integer.parseInt(strs[i].trim());
        }
        String tstr = oriStr.substring(oriStr.lastIndexOf(':')+1);
        int target = Integer.parseInt(tstr.trim());
        System.out.println(findTargetSumWays(nums,target));
    }
}
