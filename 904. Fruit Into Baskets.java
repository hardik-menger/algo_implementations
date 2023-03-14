import java.util.*;
import random.*;

class L904 {

    public int totalFruit1(int[] fruits) {
        int i = 0, j = 0, n = fruits.length;
        HashMap<Integer, Integer> map = new HashMap<>();
        int result = 0;
        while (j < n) {
            map.putIfAbsent(fruits[j], 0);
            map.put(fruits[j], map.get(fruits[j]) + 1);
            while (map.size() > 2) {
                int fruit = fruits[i++];
                int count = map.get(fruit);
                map.put(fruit, --count);
                if (count == 0)
                    map.remove(fruit);
            }
            result = Math.max(result, j - i + 1);
            j++;
        }
        return result;
    }

    public int totalFruit(int[] tree) {
        int lastFruit = -1;
        int secondLastFruit = -1;
        int lastFruitCount = 0;
        int currMax = 0;
        int max = 0;

        for (int fruit : tree) {
            if (fruit == lastFruit || fruit == secondLastFruit)
                currMax++;
            else
                currMax = lastFruitCount + 1;

            if (fruit == lastFruit)
                lastFruitCount++;
            else
                lastFruitCount = 1;

            if (fruit != lastFruit) {
                secondLastFruit = lastFruit;
                lastFruit = fruit;
            }

            max = Math.max(max, currMax);
        }

        return max;
    }

    public static void main(String[] args) throws Exception {
        L904 obj = new L904();
    }
}
