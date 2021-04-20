package Utils;

import java.util.*;

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

}
