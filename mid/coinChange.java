package mid;
import java.util.*;
public class coinChange {
    public static int coinChange(int[] nums,int amount){
        int[] dp = new int[amount+1];
        Arrays.fill(dp,Integer.MAX_VALUE);
        dp[0] = 0;
        for(int num : nums){
            for(int j = num;j <= amount;j++){
                dp[j] = Math.min(dp[j],dp[j-num]+1);
            }
        }
        return dp[amount] == Integer.MAX_VALUE ? -1 : dp[amount];
    }

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String oriStr = sc.nextLine();
        String[] strs = oriStr.substring(oriStr.indexOf('[')+1,oriStr.indexOf(']')).split(",");
        int amount = Integer.parseInt(oriStr.substring(oriStr.lastIndexOf('=')+1).trim());
        int[] nums = new int[strs.length];
        for(int i = 0;i < nums.length;i++){
            nums[i] = Integer.parseInt(strs[i].trim());
        }
        System.out.println(coinChange(nums,amount));
    }
}
