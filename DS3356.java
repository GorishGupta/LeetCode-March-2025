public class DS3356 {
        public int minZeroArray(int[] nums, int[][] queries) {
            int n = nums.length, sum = 0, k = 0;  
            int[] differenceArray = new int[n + 1];  
            for (int index = 0; index < n; index++) {
                while (sum + differenceArray[index] < nums[index]) {  
                    k++;  
                    if (k > queries.length) {  
                        return -1;
                    }
                    int left = queries[k - 1][0];  
                    int right = queries[k - 1][1];  
                    int val =  queries[k - 1][2];  
                    if (right >= index) {  
                        differenceArray[Math.max(left, index)] += val;  
                        differenceArray[right + 1] -= val;  
                        }
                }
                sum += differenceArray[index];  
            }
        return k; 
    }
public static void main(String[] args) {
    DS3356 obj = new DS3356();
    int[] nums = {1, 2, 3, 4};
    int[][] queries = {{0, 1, 1}, {1, 2, 2}, {2, 3, 3}};
    System.out.println(obj.minZeroArray(nums, queries));
}
}
