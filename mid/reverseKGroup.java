package mid;
import java.util.*;
public class reverseKGroup {
    public static class ListNode {
        int val;
        ListNode next;

        public ListNode() {
        }

        public ListNode(int val) {
            this.val = val;
        }
    }
    public static void reverse(ListNode start, ListNode end){
        ListNode pre = end.next;
        ListNode next = end.next;
        ListNode cur = start;

        //这里不能直接写cur != end.next 因为他是变化的
        while(cur != next){
            ListNode tmp = cur.next;
            cur.next = pre;
            pre = cur;
            cur = tmp;
        }
    }
    public static ListNode reverseKGroup(ListNode head,int k){
        ListNode dummy = new ListNode();
        dummy.next = head;
        ListNode cur = dummy;
        while(cur != null){
            ListNode startPre = cur;
            for(int i = 0;i < k && cur != null;i++){
                cur = cur.next;
            }
            ListNode start = startPre.next;
            if(cur != null){
                reverse(start,cur);
                startPre.next = cur;
                cur = start;
            }
        }
        return dummy.next;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        String[] split = s.split(",");
        ListNode head = new ListNode(Integer.parseInt(split[0]));
        ListNode cur = head;
        for (int i = 1; i < split.length; i++) {
            cur.next = new ListNode(Integer.parseInt(split[i]));
            cur = cur.next;
        }
        int k = sc.nextInt();
        ListNode node = reverseKGroup(head, k);
        while (node != null){
            System.out.print(node.val + " ");
            node = node.next;
        }
    }
}
