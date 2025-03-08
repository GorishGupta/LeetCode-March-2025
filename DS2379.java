public class DS2379{
    class Solution{
        public int minimumRecolors(String blocks, int k){
            int min = Integer.MAX_VALUE;
            int n= blocks.length();
            for(int i=0;i<=n-k;i++){
                int ch=0;
                for(int j=i;j<i+k;j++){
                    if(blocks.charAt(j)=='W'){
                        ch++;
                    }
                }
                // for finding the minimun value
                    min = Math.min(min,ch);
            }
            return min;
        }
    }
    public static void main(String[] args) {
        DS2379 obj = new DS2379();
        Solution sol = obj.new Solution();
        String blocks = "WBWBBBW";
        int k = 2;
        int num = sol.minimumRecolors(blocks,k);
        System.out.println(num);    
    }
}