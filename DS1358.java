public class DS1358 {
    class Solution {
        public int numberOfSubstrings(String s) {
            int count = 0;
            int left = 0;
            int[] charCount = new int[3];
    
            for (int right = 0; right < s.length(); right++) {
                charCount[s.charAt(right) - 'a']++;
    
                while (charCount[0] > 0 && charCount[1] > 0 && charCount[2] > 0) {
                    count += s.length() - right;
                    charCount[s.charAt(left) - 'a']--;
                    left++;
                }
            }
    
            return count;
        }
    }
    public static void main(String[] args) {
        DS1358 obj = new DS1358();
        Solution sol = obj.new Solution();
        String s = "abcabc";
        System.out.println(sol.numberOfSubstrings(s));
    }
}
