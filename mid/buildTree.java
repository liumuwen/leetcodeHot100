package mid;
import java.sql.SQLOutput;
import java.util.*;

public class buildTree {

    public static class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;
        public TreeNode(int val){
            this.val = val;
        }
    }
    public static int findPos(int[] nums, int num){
        for(int i = 0;i < nums.length;i++){
            if(nums[i] == num){
                return i;
            }
        }
        return -1;
    }

    public static TreeNode build(int[] pre, int[] ord){
        if(pre.length <= 0){
            return null;
        }
        TreeNode root = new TreeNode(pre[0]);
        int index = findPos(ord,pre[0]);
        if(index == -1){
            System.out.println(pre[0]+" " + ord[0]);
        }
        int[]lpre = Arrays.copyOfRange(pre,1,1+index);
        int[]rpre = Arrays.copyOfRange(pre,1+index,pre.length);
        int[]lord = Arrays.copyOfRange(ord,0,index);
        int[]rord = Arrays.copyOfRange(ord,index+1,ord.length);
        //你是怎么放的
        root.left = build(lpre,lord);
        root.right = build(rpre,rord);
        return root;
    }

    public static void levelTree(TreeNode root){
        if(root == null){
            return;
        }
        List<Integer> list = new ArrayList<>();
        Deque<TreeNode> dq = new LinkedList<TreeNode>();
        dq.offer(root);
        StringBuilder sb = new StringBuilder();
        while(!dq.isEmpty()){
            TreeNode node = dq.poll();
            list.add(node.val);
            if(node.left != null){
                dq.offer(node.left);
            }
            if(node.right != null) {
                dq.offer(node.right);
            }
        }
        for(int i = 0;i < list.size()-1;i++){
            System.out.print(list.get(i) + " ");
        }
        System.out.println(list.get(list.size()-1));
    }



    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String pres = sc.nextLine();
        String ords = sc.nextLine();
        int[] pre = Arrays.stream(pres.split(",")).mapToInt(Integer::parseInt).toArray();
        int[] ord = Arrays.stream(ords.split(",")).mapToInt(Integer::parseInt).toArray();
        TreeNode root = build(pre,ord);
        levelTree(root);
    }
}
