import java.util.*;
import random.*;

class L460 {
    class LFUCache {

        class Node {
            int key;
            int value;
            int freq = 0;
            Node next;
            Node prev;

            Node(int key, int value) {
                this.key = key;
                this.value = value;
            }
        }

        class DoubleLinkedList {
            int listSize;
            Node head;
            Node tail;

            public DoubleLinkedList() {
                this.listSize = 0;
                this.head = new Node(0, 0);
                this.tail = new Node(0, 0);
                head.next = tail;
                tail.prev = head;
            }

            public void addNode(Node curNode) {
                Node nextNode = head.next;
                curNode.next = nextNode;
                curNode.prev = head;
                head.next = curNode;
                nextNode.prev = curNode;
                listSize++;
            }

            public void removeNode(Node curNode) {
                Node prevNode = curNode.prev;
                Node nextNode = curNode.next;
                prevNode.next = nextNode;
                nextNode.prev = prevNode;
                listSize--;
            }
        }

        HashMap<Integer, DoubleLinkedList> frequencyBuckets = new HashMap<>();
        HashMap<Integer, Node> nodeMap = new HashMap<>();
        int capacity = 0;
        int currentCapacity = 0;
        int currentMinFrequency = 0;

        public LFUCache(int capacity) {
            this.capacity = capacity;
        }

        public int get(int key) {
            Node exisiting = this.nodeMap.get(key);
            if (exisiting != null) {
                updateNode(exisiting);
                return exisiting.value;
            }
            return -1;
        }

        public void put(int key, int value) {
            if (capacity == 0)
                return;
            Node exisiting = this.nodeMap.get(key);
            if (exisiting != null) {
                exisiting.value = value;
                updateNode(exisiting);
            } else {
                currentCapacity++;
                if (currentCapacity > capacity) {
                    var minList = frequencyBuckets.get(currentMinFrequency);
                    nodeMap.remove(minList.tail.prev.key);
                    minList.removeNode(minList.tail.prev);

                    currentCapacity--;
                }
                currentMinFrequency = 1;
                DoubleLinkedList freqDoubleLinkedList = frequencyBuckets.getOrDefault(currentMinFrequency,
                        new DoubleLinkedList());
                Node node = new Node(key, value);
                node.freq = 1;
                freqDoubleLinkedList.addNode(node);
                nodeMap.put(node.key, node);
                frequencyBuckets.put(node.freq, freqDoubleLinkedList);
            }
        }

        private void updateNode(Node exisiting) {
            DoubleLinkedList freqDoubleLinkedList = frequencyBuckets.get(exisiting.freq);
            freqDoubleLinkedList.removeNode(exisiting);
            if (freqDoubleLinkedList.head.next == freqDoubleLinkedList.tail && exisiting.freq == currentMinFrequency) {
                currentMinFrequency++;
            }
            exisiting.freq++;
            DoubleLinkedList newList = frequencyBuckets.getOrDefault(exisiting.freq, new DoubleLinkedList());
            newList.addNode(exisiting);
            frequencyBuckets.put(exisiting.freq, newList);
        }
    }

    class Node {
        int key;
        int value;
        int freq = 0;
        Node next;
        Node prev;

        Node(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }

    class DoubleLinkedList {
        int listSize;
        Node head;
        Node tail;

        public DoubleLinkedList() {
            this.listSize = 0;
            this.head = new Node(0, 0);
            this.tail = new Node(0, 0);
            head.next = tail;
            tail.prev = head;
        }

        public void addNode(Node curNode) {
            Node nextNode = head.next;
            curNode.next = nextNode;
            curNode.prev = head;
            head.next = curNode;
            nextNode.prev = curNode;
            listSize++;
        }

        public void removeNode(Node curNode) {
            Node prevNode = curNode.prev;
            Node nextNode = curNode.next;
            prevNode.next = nextNode;
            nextNode.prev = prevNode;
            listSize--;
        }
    }

    HashMap<Integer, DoubleLinkedList> frequencyBuckets = new HashMap<>();
    HashMap<Integer, Node> nodeMap = new HashMap<>();
    int capacity = 0;
    int currentCapacity = 0;
    int currentMinFrequency = 0;

    public LFUCache(int capacity) {
            this.capacity = capacity;
        }

    public int get(int key) {
        Node exisiting = this.nodeMap.get(key);
        if (exisiting != null) {
            updateNode(exisiting);
            return exisiting.value;
        }
        return -1;
    }

    public void put(int key, int value) {
        if (capacity == 0)
            return;
        Node exisiting = this.nodeMap.get(key);
        if (exisiting != null) {
            exisiting.value = value;
            updateNode(exisiting);
        } else {
            currentCapacity++;
            if (currentCapacity > capacity) {
                var minList = frequencyBuckets.get(currentMinFrequency);
                nodeMap.remove(minList.tail.prev.key);
                minList.removeNode(minList.tail.prev);

                currentCapacity--;
            }
            currentMinFrequency = 1;
            DoubleLinkedList freqDoubleLinkedList = frequencyBuckets.getOrDefault(currentMinFrequency,
                    new DoubleLinkedList());
            Node node = new Node(key, value);
            node.freq = 1;
            freqDoubleLinkedList.addNode(node);
            nodeMap.put(node.key, node);
            frequencyBuckets.put(node.freq, freqDoubleLinkedList);
        }
    }

    private void updateNode(Node exisiting) {
        DoubleLinkedList freqDoubleLinkedList = frequencyBuckets.get(exisiting.freq);
        freqDoubleLinkedList.removeNode(exisiting);
        if (freqDoubleLinkedList.head.next == freqDoubleLinkedList.tail && exisiting.freq == currentMinFrequency) {
            currentMinFrequency++;
        }
        exisiting.freq++;
        DoubleLinkedList newList = frequencyBuckets.getOrDefault(exisiting.freq, new DoubleLinkedList());
        newList.addNode(exisiting);
        frequencyBuckets.put(exisiting.freq, newList);
    }

    }

    public void main(String[] args) throws Exception {
        L460 obj = new L460();
    }
}
