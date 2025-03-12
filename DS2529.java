public class DS2529 {
    class Solution {
        public int maximumCount(int[] nums) {
            int a = 0;
            int b = 0;
            for(int i=0;i<nums.length;i++){
                if(nums[i] > 0){
                    a++;
                }
                else if(nums[i] < 0){
                    b++;
                }
            }
            return Math.max(a,b);
        }
    }
    public static void main(String[] args) {
        DS2529 obj = new DS2529();
        Solution sol = obj.new Solution();
        int[] nums = {1, -2, -3, 4};
        System.out.println(sol.maximumCount(nums));
    }
}
