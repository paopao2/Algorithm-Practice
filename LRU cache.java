/*
Design and implement a data structure for Least Recently Used (LRU) cache. It should support the following operations: get and set.

get(key) - Get the value (will always be positive) of the key if the key exists in the cache, otherwise return -1.
set(key, value) - Set or insert the value if the key is not already present. When the cache reached its capacity, it should invalidate the least recently used item before inserting a new item.
*/

//final solution --> double linked list
class Node {
    int val;
    int key;
    Node next;
    Node previous;
    public Node(int key, int val) {
        this.key = key;
        this.val = val;
        next = null;
        previous = null;
    }
}

public class LRUCache {
    //Node
    LinkedList<Node> list;
    //key, value
    HashMap<Integer, Node> map;
    int size;
    Node head = null;
    Node tail = null;
    int curSize;
    
    public LRUCache(int capacity) {
        size = capacity;
        curSize = 0;
        list = new LinkedList<Node>();
        map = new HashMap<Integer, Node>();
    }
    
    public int get(int key) {
        if (!map.containsKey(key)) return -1;
        else {
            Node node = map.get(key);
            if (node == head) return node.val;
            else if (node == tail) {
                node.previous.next = null;
                tail = node.previous;
            } else {
                node.next.previous = node.previous;
                node.previous.next = node.next;
            }
            
            node.next = head;
            head.previous = node;
            head = node;
            return head.val;
        }
        
    }
    
    public void set(int key, int value) {
        Node node = new Node(key, value);
        if (head == null) {
            head = node;
            tail = node;
            curSize++;
        }  else {
            //insert to head
            node.next = head;
            head.previous = node;
            head = node;
            curSize++;
        }
        
        //update
        if (map.containsKey(key)) {
            Node old = map.get(key);
            //delete old
            if (old == tail) {
                tail = old.previous;
                old.previous.next = null;
            } else {
                old.next.previous = old.previous;
                old.previous.next = old.next;
            }
            curSize--;
            //update map
            map.put(key, node);
        } else {
            //add
           if (curSize > size) {
                //delete tail
                map.remove(tail.key);
                tail = tail.previous;
                tail.next = null;
                curSize--;
            }
            map.put(key, node);
        }
        
    }
}

//can't pass large data set
public class LRUCache {
    //value -> key
    Queue<Integer> queue;
    //key, value
    HashMap<Integer, Integer> map;
    int size;
    
    public LRUCache(int capacity) {
        size = capacity;
        queue = new LinkedList<Integer>();
        map = new HashMap<Integer, Integer>();
    }
    
    public int get(int key) {
        return map.containsKey(key)? map.get(key) : -1;
        
    }
    
    public void set(int key, int value) {
        
        if (map.containsKey(key)) {
            queue.remove(key);
        }
        if (map.size() < size) {
            map.put(key, value);
        } else {
            map.remove(queue.poll());
            map.put(key, value);
        }
        queue.add(key);
    }
}


import java.util.LinkedHashMap;
public class LRUCache {
    LinkedHashMap<Integer, Integer> map;
    int size;
    
    public LRUCache(int capacity) {
        size = capacity;
        map = new LinkedHashMap<Integer, Integer>();
    }
    
    public int get(int key) {
        if (map.containsKey(key)) {
            int value = map.get(key);
            map.remove(key);
            map.put(key, value);
            return value;
        } else {
            return -1;
        }
        
    }
    
    public void set(int key, int value) {
        if (map.size() < size) {
            if (map.containsKey(key)) {
                map.remove(key);
            }
            map.put(key, value);
        } else {
            if (map.containsKey(key)) {
                map.remove(key);
                map.put(key, value);
            } else {
                int j = 0;
                int removedKey = 0;
                while (j < size - 1) {
                    for (int i: map.keySet()) {
                        removedKey = i;
                    }
                }
                map.remove(removedKey);
                map.put(key, value);
            }
        }
    }
}
