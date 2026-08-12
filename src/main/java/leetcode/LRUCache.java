package leetcode;

import java.util.HashMap;
import java.util.Map;

public class LRUCache {

    //Node of Doubly LinkedList
    static class Node {
        int key;
        int value;
        Node prev;
        Node next;

        Node(int key, int value){
            this.key = key;
            this.value = value;
        }
    }

    private final int capacity;
    private final Map<Integer, Node> map;

    //Dummy Nodes
    private final Node head;
    private final Node tail;

    public LRUCache(int capacity){
        this.capacity = capacity;
        this.map = new HashMap<>();

        head = new Node(0, 0);
        tail = new Node(0, 0);

        head.next = tail;
        tail.prev = head;
    }

    //Add node just before tail = MRU position
    public void addNode(Node node){
        node.prev = tail.prev;
        node.next = tail;

        tail.prev.next = node;
        tail.prev = node;
    }

    //Remove node from current posiiton
    public void removeNode(Node node){
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }

    public int get(int key){
        Node node = map.get(key);

        //key doesn't exists
        if(node == null){
            return -1;
        }

        // Move accessed node to MRU
        removeNode(node);
        addNode(node);

        return node.value;
    }

    public void put(int key, int value){
        // Key already exists
        if(map.containsKey(key)){
            Node node = map.get(key);

            // Update value
            node.value = value;

            // Move to MRU
            removeNode(node);
            addNode(node);
            return;
        }

        // Cache is full
        if (map.size() == capacity){

            // LRU node
            Node lru = head.next;
            removeNode(lru);

            // Remove from Hashmap also
            map.remove(lru.key);
        }
        // Create new Node
        Node newNode = new Node(key, value);

        // Add to MRU
        addNode(newNode);

        // Add to Hashmap
        map.put(key, newNode);
    }

    // for testing
    public void printCache(){
        Node current = head.next;

        while (current != tail){
            System.out.print("(" + current.key + "," + current.value + ")");
            if(current.next != tail){
                System.out.print("<->");
            }
            current = current.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        LRUCache cache = new LRUCache(3);
        cache.put(1, 100);
        cache.put(2, 200);
        cache.put(3, 300);

        cache.printCache(); // (1,100) <-> (2,200) <-> (3,300)
        System.out.println(cache.get(1));   // 100
        cache.printCache(); //  (2,200) <-> (3,300) <-> (1,100)
        cache.put(4, 400);
        cache.printCache(); //(3,300) <-> (1,100) <-> (4,400)
        System.out.println(cache.get(2));   // -1 because 2 was removed as LRU
        System.out.println(cache.get(3));   //300
        cache.printCache(); //(1,100) <-> (4,400) <-> (3,300)
    }
}
