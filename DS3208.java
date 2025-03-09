public class DS3208 {
    class Solution {
        public int numberOfAlternatingGroups(int[] colors, int k) {
            int n = colors.length;
            int count = 0;
            int validSize = 1;
            for(int i=1;i<n+k-1;i++){
                if(colors[i%n] != colors[(i-1) % n]){
                    validSize++;
                    if(validSize >= k){
                        count++;
                    }
                }
                else{
                    validSize = 1;
                }
            }    
            return count; 
            }
    }
    public static void main(String[] args) {
        DS3208 obj = new DS3208();
        Solution sol = obj.new Solution();
        int[] colors = {1,2,1,2,1,2};
        int k = 2;
        int num = sol.numberOfAlternatingGroups(colors,k);
        System.out.println(num);    
    }
}
