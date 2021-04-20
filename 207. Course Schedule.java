
import java.util.*;

class CourseSchedule {

    class Graph<T> {
        private Map<T, List<T>> map = new HashMap<>();

        public void addVertex(T s) {
            map.put(s, new LinkedList<T>());
        }

        public void addEdge(T source, T destination) {

            if (!map.containsKey(source))
                addVertex(source);

            if (!map.containsKey(destination))
                addVertex(destination);

            map.get(source).add(destination);
        }

        public boolean hasVertex(T s) {
            return map.containsKey(s);
        }

        public boolean hasEdge(T s, T d) {
            return (map.get(s).contains(d));
        }

        public int getSize() {
            return map.keySet().size();
        }

        public boolean isCyclic() {
            HashSet<T> visited = new HashSet<T>();
            HashSet<T> recStack = new HashSet<T>();
            for (Map.Entry<T, List<T>> entry : map.entrySet())
                for (T node : entry.getValue())
                    if (isCyclicUtil(node, visited, recStack))
                        return true;
            return false;
        }

        private boolean isCyclicUtil(T node, HashSet<T> visited, HashSet<T> recStack) {
            if (recStack.contains(node))
                return true;
            if (visited.contains(node))
                return false;
            recStack.add(node);
            visited.add(node);
            for (T child : map.get(node))
                if (isCyclicUtil(child, visited, recStack))
                    return true;
            recStack.remove(node);
            return false;
        }

    }

    public boolean canFinish1(int numCourses, int[][] prerequisites) {
        Graph<Integer> graph = new Graph<>();
        if (prerequisites.length <= 1)
            return true;
        for (int[] link : prerequisites) {
            graph.addEdge(link[1], link[0]);
        }
        return !graph.isCyclic();
    }

    public boolean canFinish(int numCourses, int[][] prerequisites) {
        int[] incomingEdges = new int[numCourses];
        List<Integer>[] goCourses = new List[numCourses];
        for (int i = 0; i < goCourses.length; i++) {
            goCourses[i] = new LinkedList<Integer>();
        }
        for (int[] pair : prerequisites) {
            incomingEdges[pair[0]]++;
            goCourses[pair[1]].add(pair[0]);
        }
        Queue<Integer> queue = new LinkedList<Integer>();
        for (int i = 0; i < incomingEdges.length; i++) {
            if (incomingEdges[i] == 0) {
                queue.add(i);
            }
        }
        int edgeCnt = prerequisites.length;
        while (!queue.isEmpty()) {
            int cur = queue.poll();
            for (int goCrs : goCourses[cur]) {
                edgeCnt--;
                if (--incomingEdges[goCrs] == 0)
                    queue.add(goCrs);
            }
        }
        return edgeCnt == 0;
    }
}