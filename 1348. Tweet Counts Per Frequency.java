import java.util.*;

class L1348 {
    class TweetCounts {
        HashMap<String, List<Integer>> map;

        public TweetCounts() {
            map = new HashMap<>();
        }

        public void recordTweet(String tweetName, int time) {
            map.putIfAbsent(tweetName, new ArrayList<>());
            map.get(tweetName).add(time);
        }

        public List<Integer> getTweetCountsPerFrequency(String freq, String tweetName, int startTime, int endTime) {
            int interval = 60;
            if (freq.equals("hour"))
                interval = interval * 60;
            if (freq.equals("day"))
                interval = interval * 60 * 24;
            List<Integer> intervals = new ArrayList<Integer>();
            for (int i = 0; i <= (endTime - startTime) / interval; i++)
                intervals.add(0);
            for (int i : map.get(tweetName)) {
                if (i >= startTime && i <= endTime)
                    intervals.set((i - startTime) / interval, intervals.get((i - startTime) / interval) + 1);
            }
            return intervals;
        }
    }

    public static void main(String[] args) throws Exception {
        L1348 obj = new L1348();
    }
}
