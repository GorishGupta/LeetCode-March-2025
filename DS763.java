import java.util.ArrayList;
import java.util.List;

public class DS763 {
    class Solution {

        public List<Integer> partitionLabels(String s) {
            // Stores the last index of each character in 's'
            int[] lastOccurrence = new int[26];
            for (int i = 0; i < s.length(); ++i) {
                lastOccurrence[s.charAt(i) - 'a'] = i;
            }

            int partitionEnd = 0, partitionStart = 0;
            List<Integer> partitionSizes = new ArrayList<>();
            for (int i = 0; i < s.length(); ++i) {
                partitionEnd = Math.max(
                        partitionEnd,
                        lastOccurrence[s.charAt(i) - 'a']);
                // End of the current partition
                if (i == partitionEnd) {
                    partitionSizes.add(i - partitionStart + 1);
                    partitionStart = i + 1;
                }
            }
            return partitionSizes;
        }
    }

    public static void main(String[] args) {
        DS763 ds = new DS763();
        Solution solution = ds.new Solution();
        String s = "ababcbacadefegdehijhklij";
        List<Integer> result = solution.partitionLabels(s);
        System.out.println(result); // Output: [9, 7, 8]
    }
}
