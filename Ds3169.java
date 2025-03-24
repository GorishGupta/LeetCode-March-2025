import java.util.Arrays;

public class Ds3169 {
    public int countDays(int days, int[][] meetings) {
        Arrays.sort(meetings, (a, b) -> Integer.compare(a[0], b[0]));

        int meetingDaysCount = 0;
        int currentStart = -1, currentEnd = -1;

        for (int[] meeting : meetings) {
            int start = meeting[0], end = meeting[1];
            if (start > currentEnd) {
                if (currentEnd != -1) {
                    meetingDaysCount += (currentEnd - currentStart + 1);
                }
                currentStart = start;
                currentEnd = end;
            } else {
                currentEnd = Math.max(currentEnd, end);
            }
        }

        if (currentEnd != -1) {
            meetingDaysCount += (currentEnd - currentStart + 1);
        }

        return days - meetingDaysCount;
    }

    public static void main(String[] args) {
        System.out.println("DS3169");
        Ds3169 obj = new Ds3169();
        int[][] meetings = { { 1, 4 }, { 2, 3 }, { 3, 6 } };
        System.out.println(obj.countDays(6, meetings));
    }
}
