class Solution {
    public int[] productExceptSelf(int[] nums) {
        int[] ans = new int[nums.length];
        int val = 1;
        for (int i = 0; i < nums.length; ++i) {
            if (i > 0) {
                val = val * nums[i - 1];
                ans[i] = val;
            } else {
                ans[i] = 1;
            }
        }

        val = 1;
        for (int i = nums.length - 1; i >= 0; --i) {
            ans[i] = ans[i] * val;
            val = val * nums[i]; 
        }

        return ans;
    }
}  
