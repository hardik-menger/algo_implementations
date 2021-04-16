import java.util.*;

class WordLadder {
    class Pair<T, Q> {
        T p1;
        Q p2;

        Pair() {
            // default constructor
        }

        Pair(T a, Q b) {
            this.p1 = a;
            this.p2 = b;
        }

        void setValue(T a, Q b) {
            this.p1 = a;
            this.p2 = b;
        }

        Pair<T, Q> getValue() {
            return this;
        }

    }

    public int ladderLength(String start, String end, List<String> wordList) {
        if (!wordList.contains(end))
            return 0;
        HashMap<String, ArrayList<String>> umap = new HashMap<String, ArrayList<String>>();
        for (String s : wordList) {
            for (int i = 0; i < s.length(); i++) {
                String str = s.substring(0, i) + "*" + s.substring(i + 1);
                ArrayList<String> words = umap.getOrDefault(str, new ArrayList<String>());
                words.add(s);
                umap.put(str, words);
            }
        }
        Queue<Pair<String, Integer>> queue = new LinkedList<>();
        HashMap<String, Integer> visited = new HashMap<String, Integer>();
        queue.add(new Pair<String, Integer>(start, 1));
        visited.put(start, 1);
        while (!queue.isEmpty()) {
            Pair<String, Integer> p = queue.poll();

            String word = p.p1;
            int dist = p.p2;

            if (word.equals(end)) {
                return dist;
            }

            for (int i = 0; i < word.length(); i++) {
                String str = word.substring(0, i) + "*" + word.substring(i + 1);
                ArrayList<String> vect = umap.getOrDefault(str, new ArrayList<String>());
                for (int j = 0; j < vect.size(); j++) {
                    // If the word is not visited
                    if (visited.getOrDefault(vect.get(j), 0) == 0) {
                        visited.put(vect.get(j), 1);
                        queue.add(new Pair<String, Integer>(vect.get(j), dist + 1));
                    }
                }
            }
        }
        return 0;
    }

    // solution1
    public int ladderLength1(String start, String end, List<String> wordList) {
        HashSet<String> wordListSet = new HashSet<String>(wordList);
        if (!wordListSet.contains(end))
            return 0;
        wordListSet.add(start);
        List<String> wordListWithLocations = new ArrayList<String>(wordListSet);
        int i = wordListWithLocations.indexOf(start), j = wordListWithLocations.indexOf(end);
        List<List<Integer>> graph = getRelations(wordListWithLocations);
        HashSet<Integer> visited = new HashSet<>();
        int level = bfs(graph, visited, i, j);

        return level;
    }

    private int bfs(List<List<Integer>> graph, HashSet<Integer> visited, int u, int v) {

        Queue<Integer> q = new LinkedList<Integer>();
        int level = 0;
        q.add(u);
        visited.add(u);
        while (true) {
            if (q.isEmpty())
                break;
            int size = q.size();
            level++;
            while (size > 0) {
                int source = q.poll();
                if (source == v)
                    return level;
                visited.add(source);
                for (int child : graph.get(source)) {
                    if (!visited.contains(child)) {
                        q.add(child);
                    }
                }
                size--;

            }
        }
        return level;

    }

    List<List<Integer>> getRelations(List<String> wordList) {
        List<List<Integer>> graph = new ArrayList<List<Integer>>();
        for (int i = 0; i < wordList.size(); i++)
            graph.add(i, new ArrayList<Integer>());
        for (int i = 0; i < wordList.size(); i++)
            for (int j = i + 1; j < wordList.size(); j++)
                if (isOneDifferent(wordList.get(j), wordList.get(i)))
                    addEdge(graph, i, j);
        return graph;
    }

    boolean isOneDifferent(String word, String testAgainst) {
        if (word.length() != testAgainst.length()) {
            return false;
        }

        int diffs = 0;

        for (int i = 0; i < word.length(); i++) {
            if (word.charAt(i) != testAgainst.charAt(i)) {
                diffs++;
            }

            if (diffs > 1) {
                return false;
            }
        }

        if (diffs == 1) {
            return true;
        } else {
            return false;
        }

    }

    void addEdge(List<List<Integer>> graph, int u, int v) {
        graph.get(u).add(v);
        graph.get(v).add(u);
    }

    public static void main(String[] args) {
        String start = "qa", end = "sq";
        ArrayList<String> al = new ArrayList<String>(Arrays.asList("si", "go", "se", "cm", "so", "ph", "mt", "db", "mb",
                "sb", "kr", "ln", "tm", "le", "av", "sm", "ar", "ci", "ca", "br", "ti", "ba", "to", "ra", "fa", "yo",
                "ow", "sn", "ya", "cr", "po", "fe", "ho", "ma", "re", "or", "rn", "au", "ur", "rh", "sr", "tc", "lt",
                "lo", "as", "fr", "nb", "yb", "if", "pb", "ge", "th", "pm", "rb", "sh", "co", "ga", "li", "ha", "hz",
                "no", "bi", "di", "hi", "qa", "pi", "os", "uh", "wm", "an", "me", "mo", "na", "la", "st", "er", "sc",
                "ne", "mn", "mi", "am", "ex", "pt", "io", "be", "fm", "ta", "tb", "ni", "mr", "pa", "he", "lr", "sq",
                "ye"));
        System.out.println(new WordLadder().ladderLength(start, end, al));
    }

}