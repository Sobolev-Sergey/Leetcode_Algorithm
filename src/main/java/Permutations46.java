package main.java;

public class Permutations46 {
    /**
     * 46. Permutations
     * Given an array nums of distinct integers, return all the possible permutations. You can return the answer in any order.
     *
     *
     * Example 1:
     *
     * Input: nums = [1,2,3]
     * Output: [[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]
     * Example 2:
     *
     * Input: nums = [0,1]
     * Output: [[0,1],[1,0]]
     * Example 3:
     *
     * Input: nums = [1]
     * Output: [[1]]
     *
     *
     * Constraints:
     *
     * 1 <= nums.length <= 6
     * -10 <= nums[i] <= 10
     * All the integers of nums are unique.
     */

    class Solution {
        public List<List<Integer>> permute(int[] nums) {
            List<List<Integer>> result = new ArrayList<List<Integer>>();

            result.add(new ArrayList<Integer>());
            List<List<Integer>> current = new ArrayList<List<Integer>>();
            for (int i = 0; i < nums.length; i++) {
                current.clear();
                for (List<Integer> l : result) {
                    for (int j = 0; j < l.size()+1; j++) {
                        l.add(j, nums[i]);
                        ArrayList<Integer> temp = new ArrayList<Integer>(l);
                        current.add(temp);
                        l.remove(j);
                    }
                }
                result = new ArrayList<List<Integer>>(current);
            }

            return result;
        }
    }
}
