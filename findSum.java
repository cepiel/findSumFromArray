/*
 * Given a sorted array of integers in non-decreasing order, you need to find two numbers in the array that
    add up to a specific target. The indices of these two numbers, denoted as index1 and index2, should be
    returned in a 1-indexed array [index1, index2].

    Here&#39;s an example:

    Input: numbers = [2,7,11,15], target = 9
    Output: [1,2]
    Explanation: The sum of 2 and 7 is 9. Therefore, index1 is 1, and index2 is 2. The function returns [1, 2].

    Constraints:

    The array &quot;numbers&quot; has at least two elements and at most 30,000 elements.
    Each element in &quot;numbers&quot; is between -1000 and 1000.
    The array &quot;numbers&quot; is sorted in non-decreasing order.
    The target value is between -1000 and 1000.
    There is exactly one solution for each test case.

 */

public class findSum {

    // Put your test case in main and run it
    public static void main(String[] args) {
        int[] intArray = new int[] { 2, 7, 11, 15 };
        int target = 9;

        int[] output = findSumFromArray(intArray, target);

        System.out.println(output[0] + "," + output[1]);
    }

    /*
     * Solution Approach:
     * You can create a simple for loop for this and go item by item and check the
     * sum, but you'll have n^2 complexity which is not ideal.
     * 
     * I originally thought of starting in the middle of the array, and depending on
     * the sum, jump to a different point, similar to a binary search,
     * to jump around and try to get closer to the solution, but it was complex and
     * seemed like it could have issues with a very unbalanced array where
     * the numbers are not evenly distributed in the list. i.e. most of the items
     * are very low or negative and some are very high.
     * 
     * I thought up a pointer solution of watching 2 points and determining if you
     * needed to go higher or lower from there. I considered starting in the middle
     * of the list,
     * but decided to start at the beginning and end instead.
     */
    public static int[] findSumFromArray(int[] intArray, int target) {
        int[] solution = new int[2];
        int posA = 0;
        int posB = intArray.length - 1;
        while (posA <= posB) {
            int sum = intArray[posA] + intArray[posB];
            if (sum == target) {
                solution[0] = posA + 1;
                solution[1] = posB + 1;
                return solution;
            } else if (sum < target) {
                posA++;
            } else {
                posB--;
            }
        }
        return solution;
    }
}
