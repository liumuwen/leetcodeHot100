package mid;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class combinationSum {

    public static List<List<Integer>> res = new ArrayList<>();
    public static void backtrack(int[] candidates, int target, int index,List<Integer> path){
        int sum = path.stream().reduce(0,(a,b)->a+b);
        if(sum >= target){
            if(sum == target){
                res.add(new ArrayList<>(path));
            }
            return;
        }
        for(int i = index;i < candidates.length;i++){
            path.add(candidates[i]);
            backtrack(candidates,target,i,path);
            path.remove(path.size()-1);
        }
    }

    public static List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<Integer> path = new ArrayList<>();
        backtrack(candidates,target,0,path);
        return res;
    }

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String line = sc.nextLine();
        int[] nums = Arrays.stream(line.split(",")).mapToInt(Integer::parseInt).toArray();
        int target = sc.nextInt();
        combinationSum(nums,target);
        System.out.println(res.toString());
    }
}
