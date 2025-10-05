import java.util.*;
import random.*;

class L1368 {

    class Node {
        int x, y, cost;

        Node(int x, int y, int cost) {
            this.x = x;
            this.y = y;
            this.cost = cost;
        }
    }
    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        int temp[]=new int[n];
        for(int[] edge:edges){
            temp[edge[0]]++;
            temp[edge[1]]++;
        }
        var list=new ArrayList<Integer>();
         list.add(Arrays.stream(temp).max().getAsInt());
         return list;
    }

    public int minCost(int[][] grid) {
        Deque<Node> dq = new LinkedList<>();
        boolean[][] vis = new boolean[grid.length][grid[0].length];
        dq.add(new Node(0, 0, 0));
        while (!dq.isEmpty()) {
            Node top = dq.removeFirst();
            vis[top.x][top.y] = true;
            if (top.x == grid.length - 1 && top.y == grid[0].length - 1) return top.cost; else {
                if (top.x > 0 && !vis[top.x - 1][top.y]) {
                    if (grid[top.x][top.y] == 4) dq.addFirst(new Node(top.x - 1, top.y, top.cost)); else dq.addLast(new Node(top.x - 1, top.y, top.cost + 1));
                }
                if (top.x < grid.length - 1 && !vis[top.x + 1][top.y]) {
                    if (grid[top.x][top.y] == 3) dq.addFirst(new Node(top.x + 1, top.y, top.cost)); else dq.addLast(new Node(top.x + 1, top.y, top.cost + 1));
                }
                if (top.y > 0 && !vis[top.x][top.y - 1]) {
                    if (grid[top.x][top.y] == 2) dq.addFirst(new Node(top.x, top.y - 1, top.cost)); else dq.addLast(new Node(top.x, top.y - 1, top.cost + 1));
                }
                if (top.y < grid[0].length - 1 && !vis[top.x][top.y + 1]) {
                    if (grid[top.x][top.y] == 1) dq.addFirst(new Node(top.x, top.y + 1, top.cost)); else dq.addLast(new Node(top.x, top.y + 1, top.cost + 1));
                }
            }
        }
        return -1;
    }    
    
    public static void main(String[] args) throws Exception {
        L1368 obj = new L1368();
    }
}
