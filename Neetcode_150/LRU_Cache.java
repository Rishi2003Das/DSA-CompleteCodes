//The actual approach of an LRUCache should be by a hash map and a doubly linked list. 


import java.util.HashMap;
import java.util.Map;

class LRUCache {

    class Node {
        int key;
        int value;
        Node prev;
        Node next;

        Node(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }

    private int capacity;
    private Map<Integer, Node> map;
    private Node head;
    private Node tail;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        map = new HashMap<>();

        // Dummy nodes to simplify insertion and deletion
        head = new Node(-1, -1);
        tail = new Node(-1, -1);

        head.next = tail;
        tail.prev = head;
    }

    // Remove a node from its current position
    private void remove(Node node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }

    // Insert a node immediately after head (most recently used)
    private void insertAtFront(Node node) {
        node.next = head.next;
        node.prev = head;

        head.next.prev = node;
        head.next = node;
    }

    public int get(int key) {
        if (!map.containsKey(key)) {
            return -1;
        }

        Node node = map.get(key);

        // Access makes this key the most recently used
        remove(node);
        insertAtFront(node);

        return node.value;
    }

    public void put(int key, int value) {

        // Update an existing key
        if (map.containsKey(key)) {
            Node node = map.get(key);
            node.value = value;

            // Mark it as most recently used
            remove(node);
            insertAtFront(node);
            return;
        }

        // Evict the least recently used key if full
        if (map.size() == capacity) {
            Node lru = tail.prev;

            remove(lru);
            map.remove(lru.key);
        }

        // Insert the new key as most recently used
        Node newNode = new Node(key, value);
        insertAtFront(newNode);
        map.put(key, newNode);
    }
}

// This is an approach with a hash map and a priority queue. 
/* This approach has been done by me completely with the thought process 
of storing an entry along with the key and the timestamp of the latest used key. */
  import java.util.*;
class LRUCache {

    private static class Entry {
        int key;
        int value;
        long timestamp;

        Entry(int key, int value, long timestamp) {
            this.key = key;
            this.value = value;
            this.timestamp = timestamp;
        }
    }

    private final int capacity;
    private long clock = 0;

    private final Map<Integer, Entry> cache;
    private final PriorityQueue<Entry> pq;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.cache = new HashMap<>();

        // Smallest timestamp = least recently used
        this.pq = new PriorityQueue<>(
            Comparator.comparingLong(e -> e.timestamp)
        );
    }

    public int get(int key) {
        Entry entry = cache.get(key);

        if (entry == null) {
            return -1;
        }

        // Refresh the access timestamp
        Entry updated = new Entry(
            key, entry.value, ++clock
        );

        cache.put(key, updated);
        pq.offer(updated);

        compactQueue();

        return updated.value;
    }

    public void put(int key, int value) {
        if (capacity == 0) {
            return;
        }

        // Update an existing key
        if (cache.containsKey(key)) {
            Entry updated = new Entry(
                key, value, ++clock
            );

            cache.put(key, updated);
            pq.offer(updated);

            compactQueue();
            return;
        }

        // Evict the LRU key if the cache is full
        if (cache.size() == capacity) {
            evictLRU();
        }

        // Insert the new key
        Entry entry = new Entry(
            key, value, ++clock
        );

        cache.put(key, entry);
        pq.offer(entry);

        compactQueue();
    }

    private void evictLRU() {
        while (!pq.isEmpty()) {
            Entry oldest = pq.poll();

            // Ignore stale entries from previous accesses
            if (cache.get(oldest.key) == oldest) {
                cache.remove(oldest.key);
                return;
            }
        }
    }

    // Prevent stale queue entries from growing indefinitely
    private void compactQueue() {
        if (pq.size() > 2L * cache.size() + 64) {
            pq.clear();
            pq.addAll(cache.values());
        }
    }
}

/**
 * Usage:
 * LRUCache obj = new LRUCache(capacity);
 * int value = obj.get(key);
 * obj.put(key, value);
 */
