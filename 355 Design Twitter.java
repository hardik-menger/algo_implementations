import java.util.*;
import random.*;

class L355 {

    HashMap<Integer, Set<Integer>> userFollows = new HashMap<>();
    HashMap<Integer, Queue<Integer>> userFeed = new HashMap<>();

    public void Twitter() {
    }

    public void postTweet(int userId, int tweetId) {
        this.fillUser(userId);
    }

    public List<Integer> getNewsFeed(int userId) {
        return userFeed.getOrDefault(userId, new LinkedList<>()).stream().toList();
    }

    public void follow(int followerId, int followeeId) {
        this.fillUser(followerId);
        this.fillUser(followeeId);
        Set<Integer> userFollows = this.userFollows.get(followerId);
        userFollows.add(followeeId);

        // updadte followeeId feed;

    }

    private void fillUser(int followerId) {
        this.userFollows.put(followerId, new HashSet<>());
        this.userFeed.put(followerId, new PriorityQueue<>(Collections.reverseOrder()));
    }

    public void unfollow(int followerId, int followeeId) {

    }

    public class LimitedSizePriorityQueue<E extends Comparable<E>> {
        private final int maxSize;
        private final PriorityQueue<E> queue;

        public LimitedSizePriorityQueue(int maxSize) {
            this.maxSize = maxSize;
            this.queue = new PriorityQueue<>(maxSize);
        }

        public boolean add(E element) {
            if (queue.size() < maxSize) {
                queue.add(element);
                return true;
            } else if (element.compareTo(queue.peek()) > 0) {
                queue.poll();
                queue.add(element);
                return true;
            }
            return false;
        }

        // Other methods you may need to implement or wrap around the underlying
        // PriorityQueue

        public int size() {
            return queue.size();
        }

        public boolean isEmpty() {
            return queue.isEmpty();
        }

        // ...
    }

    public static void main(String[] args) throws Exception {
        L355 obj = new L355();
    }
}
