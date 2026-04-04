class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int[] result = new int[]{};
        if(numbers == null || numbers.length == 0) return result;
        int left = 0, right = numbers.length - 1;
        while (left < right) {
            int sum = numbers[left] + numbers[right];
            if( sum == target) {
                return new int[] {left +1 , right + 1};
            }
            if(sum < target) left++;
            if (sum > target) right --;
        }
        return result;
    }
}
