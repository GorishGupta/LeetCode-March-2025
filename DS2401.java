public class DS2401 {
    class Solution {
        public int longestNiceSubarray(int[] nums) {
            
            int maxLength = 0;
            int orValue =0;
            int left = 0;
            for(int i=0;i<nums.length;i++){
                while((orValue & nums[i]) != 0 ){
                    orValue ^= nums[left];
                    left++;
                }
                orValue |= nums[i];
                maxLength = Math.max(maxLength, i-left+1);
            }
            return maxLength;
        }
    }
    public static void main(String[] args) {
        DS2401 obj = new DS2401();
        Solution sol = obj.new Solution();
        // Test case 1
        int [] nums = {2,4,3,3,3,2,4,2,1};
        System.out.println(sol.longestNiceSubarray(nums));
        

    }
}
