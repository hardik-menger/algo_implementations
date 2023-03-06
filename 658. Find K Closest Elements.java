import java.util.*;
import java.util.stream.Collectors;

import random.*;

class L658 {
    public static int findLastIndex(int[] arr, int x) {
        int left = 0;
        int right = arr.length - 1;
        int lastIndex = -1;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (arr[mid] < x) {
                left = mid + 1;
            } else {
                lastIndex = mid;
                right = mid - 1;
            }
        }

        return lastIndex;
    }

    public List<Integer> findClosestElements1(int[] arr, int k, int x) {
        int index = findLastIndex(arr, x);
        if (index == -1 && arr[0] > x)
            index = 0;
        if (index == -1 && arr[arr.length - 1] < x)
            index = arr.length - 1;
        int l = index - 1, r = index;
        ArrayList<Integer> result = new ArrayList<Integer>();
        while (l >= 0 && r <= arr.length - 1 && k != 0) {
            if (Math.abs(arr[l] - x) > Math.abs(arr[r] - x)) {
                result.add(arr[r]);
                r++;
            } else {
                result.add(arr[l]);
                l--;
            }
            k--;
        }
        while (l >= 0 && r == arr.length && k != 0) {
            result.add(arr[l--]);
            k--;
        }
        while (l == -1 && r <= arr.length - 1 && k != 0) {
            result.add(arr[r++]);
            k--;
        }
        Collections.sort(result);
        return result;
    }

    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        int l = 0, r = arr.length - k - 1;
        while (l <= r) {
            int mid = l + (r - l) / 2;
            if (x - arr[mid] <= arr[mid + k] - x) {
                r--;
            } else {
                l++;
            }
        }
        return Arrays.stream(arr, l, l + k).boxed().collect(Collectors.toList());
    }

    public static void main(String[] args) throws Exception {
        L658 obj = new L658();
    }
}
