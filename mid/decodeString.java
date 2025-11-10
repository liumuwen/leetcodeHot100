package mid;
import java.util.*;
import java.util.stream.Collectors;

public class decodeString {

    public static String decodeString(String s){
        char[] chs = s.toCharArray();
        Deque<Integer> numSk = new LinkedList<>();
        Deque<String> strSk = new LinkedList<>();
        int i = 0;
        while(i < chs.length){
            if('0' <= chs[i] && chs[i] <= '9'){
                int cnt = 1;
                int num = 0;
                while(i < chs.length && '0' <= chs[i] && chs[i] <= '9'){
                    num += cnt * (chs[i] - '0');
                    cnt *= 10;
                    i++;
                }
                numSk.push(num);
            }else if(chs[i] == '['){
                strSk.push(String.valueOf(chs[i++]));
            }else if('a' <= chs[i] && chs[i] <= 'z'){
                strSk.push(String.valueOf(chs[i++]));
            }else{
                //遇到 ]
//                System.out.println(chs[i]);
                List<String> sb = new ArrayList<>();
                while(!strSk.peek().equals("[")){
                    sb.add(strSk.pop());
                }
                strSk.pop();
                Collections.reverse(sb);
                String str = String.join("",sb);
                int cnt = numSk.pop();
                sb.clear();
                while(cnt-- > 0){
                    sb.add(str);
                }
                strSk.push(String.join("",sb));
                i++;
            }
        }
        List<String> sb = new ArrayList<>();
        while(!strSk.isEmpty()){
            sb.add(strSk.pop());
        }
        Collections.reverse(sb);
        return String.join("",sb);
    }

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String line = sc.nextLine();
        System.out.println(decodeString(line));
    }
}
