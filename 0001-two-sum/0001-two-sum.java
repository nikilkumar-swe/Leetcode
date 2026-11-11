class Solution {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            int moreNeeded = target - nums[i];
            if (map.containsKey(moreNeeded)) {
                return new int[] { map.get(moreNeeded), i };
            } else {
                map.put(nums[i], i);
            }
        }
        return new int[] {-1,-1};
    }
}