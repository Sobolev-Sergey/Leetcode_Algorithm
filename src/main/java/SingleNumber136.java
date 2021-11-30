package main.java;

public class SingleNumber136 {
    /**
     * 136. Single Number
     * Given a non-empty array of integers nums, every element appears twice except for one. Find that single one.
     *
     * You must implement a solution with a linear runtime complexity and use only constant extra space.
     *
     *
     *
     * Example 1:
     *
     * Input: nums = [2,2,1]
     * Output: 1
     * Example 2:
     *
     * Input: nums = [4,1,2,1,2]
     * Output: 4
     * Example 3:
     *
     * Input: nums = [1]
     * Output: 1
     *
     *
     * Constraints:
     *
     * 1 <= nums.length <= 3 * 104
     * -3 * 104 <= nums[i] <= 3 * 104
     * Each element in the array appears twice except for one element which appears only once.
     *
     *
     * Start with value 0, if there are two same number, when you do a XOR,
     * you flip the bit twice which means the bit will remain 0.
     * but for the unique number, the corresponding bit only flipped once,
     * 0 -> 1, so the value will end up as the unique number.
     */

    class Solution {
        public int singleNumber(int[] nums) {
            int result = 0;

            for (int i = 0; i < nums.length; i ++)
                result = result ^ nums[i];

            return result;
        }
    }
}
