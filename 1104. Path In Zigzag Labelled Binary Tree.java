import java.util.*;

class L1104 {

    public List<Integer> pathInZigZagTree(int label) {
        ArrayList<Integer> path = new ArrayList<Integer>();
        if (label == 1) {
            path.add(1);
            return path;
        }

        int nearestLevel = (int) (Math.log(label) / Math.log(2)) - 1;
        int nearestLevelMax = (int) Math.pow(2, nearestLevel + 1) - 1;
        int parent = (int) label / 2;
        boolean isReversed = (nearestLevel) % 2 == 0;

        if (!isReversed)
            fillPath((int) Math.pow(2, nearestLevel) + nearestLevelMax - parent, path);
        else
            fillPath(label, path);
        if (!isReversed)
            path.add((int) Math.pow(2, nearestLevel) + nearestLevelMax - parent);
        path.add(label);
        return path;
    }

    private void fillPath(int label, ArrayList<Integer> path) {
        if (label == 1)
            return;
        int nearestLevel = (int) (Math.log(label) / Math.log(2)) - 1;
        int nearestLevelMax = (int) Math.pow(2, nearestLevel + 1) - 1;
        boolean isReversed = (nearestLevel) % 2 == 0;
        int parent = (int) label / 2;
        if (isReversed)
            parent = (int) Math.pow(2, nearestLevel) + nearestLevelMax - parent;
        fillPath(label / 2, path);
        path.add(parent);
    }

    public static void main(String[] args) throws Exception {
        L1104 obj = new L1104();
        System.out.println(obj.pathInZigZagTree(14));
        System.out.println(obj.pathInZigZagTree(26));
    }
}
