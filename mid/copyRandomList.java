package mid;
import java.util.*;
public class copyRandomList {

    public static class Node{
        int val;
        Node next;
        Node random;
        public Node(int val){
            this.val = val;
        }
    }

    public static Node copyRandomList(Node head){
        Map<Node,Node> map = new HashMap<>();
        Node cur = head;
        while(cur != null){
            map.put(cur,new Node(cur.val));
            cur = cur.next;
        }
        cur = head;
        while(cur != null){
            Node newNode = map.get(cur);
            newNode.next = map.get(cur.next);
            newNode.random = map.get(cur.random);
            cur = cur.next;
        }
        return map.get(head);
    }
}
