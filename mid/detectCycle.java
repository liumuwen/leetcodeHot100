package mid;
import java.util.*;

public class detectCycle {
    public static class ListNode{
        int val;
        ListNode next;
        public ListNode(int val){
            this.val = val;
        }
    }

    public static boolean detectCycle(ListNode head){
        if(head == null){
            return false;
        }
        ListNode slow = head;
        ListNode fast = head.next;
        while(fast != null && fast.next != null && slow != fast){
            slow = slow.next;
            fast = fast.next.next;
        }
//        System.out.println(slow.val+ ":" + fast.val);
        return slow == fast;
    }
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String[] strs = sc.nextLine().split(",");
        Map<Integer,ListNode> map = new HashMap<>();
        ListNode dummyHead = new ListNode(0);
        ListNode cur = dummyHead;
        for(int i = 0;i < strs.length;i++){
            cur.next = new ListNode(Integer.parseInt(strs[i]));
            cur = cur.next;
            map.put(i,cur);
        }
        int pos = sc.nextInt();
//        System.out.println(cur.val);
        cur.next = map.get(pos);
//        System.out.println(cur.next.val);
        String res = detectCycle(dummyHead.next) ? "true" : "false";
        System.out.println(res);
    }
}
