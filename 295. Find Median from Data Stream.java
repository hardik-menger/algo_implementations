import java.util.*;

class MedianFinder {
    PriorityQueue<Integer> left = new PriorityQueue<>();
    PriorityQueue<Integer> right = new PriorityQueue<>((a, b) -> b - a);
    boolean isEven = false;

    public MedianFinder() {

    }

    public void addNum(int num) {
        left.add(num);
        right.add(left.poll());
        if (left.size() < right.size()) { // maintain size property
            left.add(right.poll());
        }
    }

    public double findMedian() {
        return left.size() > right.size() ? left.peek() : (double) (left.peek() + right.peek()) / 2;
    }
}