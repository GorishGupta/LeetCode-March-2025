public class DS2594 {
        public long repairCars(int[] ranks, int cars) {
            long left = 1;
            long right = (long) ranks[0] * cars * cars;
            while(left < right)
            {
                long mid = (left + right)/2;
                long currCars = 0;
                for(int rank : ranks)
                {
                    currCars += (long) Math.sqrt(mid/rank);
                }
                if(currCars < cars)
                {
                    left = mid + 1;
                }
                else
                {
                    right = mid;
                }
            }
            return left;
        }   
        public static void main(String[] args) {
            DS2594 obj = new DS2594();
            int[] ranks = {1, 2, 3, 4, 5};
            int cars = 2;
            System.out.println(obj.repairCars(ranks, cars)); // Output: 3
        }
}
