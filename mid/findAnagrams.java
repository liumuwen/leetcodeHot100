package mid;
import java.util.*;
public class findAnagrams {

    // 时间复杂度高，采用滑动窗口时间复杂度低
//    public static boolean Anagrams(String s1, String s2){
//        char[] ch1 = s1.toCharArray();
//        char[] ch2 = s2.toCharArray();
//        Arrays.sort(ch1);
//        Arrays.sort(ch2);
//        String str1 = new String(ch1);
//        String str2 = new String(ch2);
//        return str1.equals(str2);
//    }
//    public static List<Integer> findAnagrams(String s, String p){
//        int len = p.length();
//        List<Integer> res = new ArrayList<>();
//        for(int i = 0;i < s.length() - len;i++){
//            String str = s.substring(i,i+len);
//            if(Anagrams(str,p)){
//                res.add(i);
//            }
//        }
//        return res;
//    }

    public static boolean check(int[] nums){
        return Arrays.stream(nums).allMatch(a -> a == 0);
    }

    public static List<Integer> findAnagrams(String s, String p){
        int[] letters = new int[26];
        List<Integer> res = new ArrayList<>();
        for(int i =0;i < p.length();i++){
            letters[p.charAt(i) - 'a']++;
        }
        for(int i = 0;i < p.length();i++){
            letters[s.charAt(i)- 'a']--;
        }
        if(check(letters)){
            res.add(0);
        }
        for(int i = 0;i < s.length() - p.length();i++){
            letters[s.charAt(i)-'a']++;
            letters[s.charAt(i+p.length()) - 'a']--;
            if(check(letters)){
                res.add(i+1);
            }
        }
        return res;
    }

    public static void  main(String[] args){
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        String p = sc.nextLine();
        System.out.println(findAnagrams(s,p).toString());
    }
}
