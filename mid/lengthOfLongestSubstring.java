package mid;
import java.util.*;
public class lengthOfLongestSubstring {

    public static boolean check(int[] nums){
        return Arrays.stream(nums).allMatch(x->x <= 1);
    }
    // o(n)
    public static int lengthOfLongestSubstring(String s){
        // 滑动窗口
        int[] nums = new int[26];
        char[] strs = s.toCharArray();
        int res = 0;
        int slow = 0;
        for(int i = 0;i < s.length();i++){
            nums[strs[i] - 'a']++;
            while(!check(nums)){
                nums[strs[slow++] - 'a']--;
            }
            res = Math.max(res,i-slow+1);
        }
        return res;
    }
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        System.out.println(lengthOfLongestSubstring(str));
    }
}
