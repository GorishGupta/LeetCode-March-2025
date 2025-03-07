import java.util.Arrays;

public class DS2523 {
    class Solution {
    private boolean[] sieve(int n) {
        boolean[] prime = new boolean[n+1];

        Arrays.fill(prime, true);
        prime[0] = prime[1] = false;

        for(int i=2; i*i<=n; i++) {
            if(prime[i]) {
                for(int j=i*i; j<=n; j+=i) {
                    prime[j] = false;
                }
            }
        }

        return prime;
    }

    public int[] closestPrimes(int left, int right) {
        boolean prime[] = sieve(right);
        int num1 = -1, num2 = -1;
        int prev = -1;

        for(int i=left; i<=right; i++) {
            if(prime[i]) {
                if(prev == -1) {
                    prev = i;
                }
                else {
                    if((num1 == -1 && num2 == -1) || i-prev < num2-num1) {
                        num1 = prev;
                        num2 = i;
                    }
                }
                prev = i;
            }
        }

        return new int[] {num1, num2};
    }
}
}
