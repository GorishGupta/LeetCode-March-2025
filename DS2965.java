import java.util.Set;
import java.util.TreeSet;
public class DS2965 {
    class Solution {
    public int[] findMissingAndRepeatedValues(int[][] grid) {
       int n=grid.length;
       Set<Integer> b=new TreeSet<Integer>();
       int[] a=new int[2];
       for(int i=0;i<n;i++)
       {
        for(int j=0;j<n;j++)
        {
            if(b.contains(grid[i][j]))
            {
                a[0]=grid[i][j];
            }
            b.add(grid[i][j]);
        }
       }
       int i=1;
       for(int z:b)
       {
        if(i!=z)
        {
            a[1]=i;
            return a;
        }
        i++;
       }
       
       if(i==n*n)
       {
        a[1]=i;
       }
       return a;
       
    }
}
public static void main(String[] args) {
    DS2965 obj = new DS2965();
    Solution sol = obj.new Solution();
    int mat[][] = {{1,3},{2,2}};
    int arr[] = sol.findMissingAndRepeatedValues(mat);
    for(int i=0;i<arr.length;i++){
        System.out.print(arr[i]+" ");
    }
}
}
