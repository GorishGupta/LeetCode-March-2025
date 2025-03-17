import java.util.*;
import java.util.HashMap;
public class DS2206 {
    public boolean divideArray(int [] nums){
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int num : nums){
            map.put(num, map.getOrDefault(num,0)+1);
        }
        for(int count :map.values()){
            if(count % 2 != 0){
                return false;
            }
        }
        return true;
    }
    // Test cases to validate the solution
    // Test case 1: nums = [3, 2, 3, 2, 2, 2]
    // Output: true
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        DS2206 obj = new DS2206();
        int num = sc.nextInt();
        int [] nums = {};
        for(int i=0;i<num;i++){
            nums[i] = sc.nextInt();
        }
        System.out.println(obj.divideArray(nums));

    }
}
