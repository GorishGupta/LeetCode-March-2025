public class DS3191 {
    class Solution {
        public int minOperations(int[] nums) {
    
            int count = 0;
            for(int i = 0;i < nums.length - 2;i++){
    
                if(nums[i] == 0){
    
                    nums[i] = 1 - nums[i];
                    nums[i + 1] = 1 - nums[i + 1];
                    nums[i + 2] = 1 - nums[i + 2];
                    count += 1;
                }
            }
            if(nums[nums.length - 1] == 0 || nums[nums.length - 2] == 0){
    
                return -1;
            }
            
            return count;
        }
    }
    public static void main(String[] args) {
        DS3191 obj = new DS3191();
        Solution sol = obj.new Solution();
        // Test case 1
        int [] nums = {1,0,0,1,0,1};
        System.out.println(sol.minOperations(nums));
        

    }
}
