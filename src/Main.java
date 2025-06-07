package src;

import src.backtracking.TwoSumBacktrack;


public class Main {
    public static void main(String[] args) {
        TwoSumBacktrack t = new TwoSumBacktrack();
        int[] result = t.twoSum(new int[]{-1,-2,-3,-4,-5}, -8);
        for (int i : result) {
            System.out.println(i + "\t");
        }
    }


}
