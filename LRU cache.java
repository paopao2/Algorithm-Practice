/*
Design and implement a data structure for Least Recently Used (LRU) cache. It should support the following operations: get and set.

get(key) - Get the value (will always be positive) of the key if the key exists in the cache, otherwise return -1.
set(key, value) - Set or insert the value if the key is not already present. When the cache reached its capacity, it should invalidate the least recently used item before inserting a new item.
*/

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