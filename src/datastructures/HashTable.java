package datastructures;

import java.util.List;
import java.util.logging.Logger;
import java.util.ArrayList;

public class HashTable<K,V> {
    public static Logger LOGGER = Logger.getLogger(HashTable.class.getName());
    private static class HashEntry<K, V> {
        K first;
        V second;
        public HashEntry(K first, V second) {
            this.first = first;
            this.second = second;
        }
    }
    private List<HashEntry<K,V>>[] slots; // in this implementation we will use chaining for colissions
    private int nbOfElements = 0;
    private double maxLoadFactor = 0.75;
    public HashTable(int nbOfSlots) {
        slots = (ArrayList<HashEntry<K,V>>[]) new ArrayList[nbOfSlots];
        for (int i = 0; i < slots.length; i++)
            slots[i] = new ArrayList<>();            
    }
    
    private int getIndexForKey(K key, int numberOfSlots){
        int hash = key.hashCode();
        hash = hash & 0x7FFFFFFF; // make sure hashCode is positive, in java -4 % 3 = -1
        return hash % numberOfSlots;
    }
    public void put(K key, V value){
        if(loadFactor() > maxLoadFactor)
            resize(slots.length * 2);
        
        int index = getIndexForKey(key, slots.length);

        for(HashEntry<K,V> pair : slots[index])
            if(pair.first.equals(key)){ // it is veryyyy important to use equals instead of ==!!!
                                        // System.out.println(new String("david") == new String("david"));      // false
                                        // System.out.println(new String("david").equals(new String("david"))); // true :))))))
                pair.second = value;
                return;
            }
        slots[index].add(new HashEntry<>(key,value));
        nbOfElements++;
    }
    private void resize(int newSize) {
        LOGGER.info("Resize : "+newSize);

        List<HashEntry<K,V>>[] newslots = (ArrayList<HashEntry<K,V>>[]) new ArrayList[newSize];
        for (int i = 0; i < newslots.length; i++)
            newslots[i] = new ArrayList<>();
        
        for (int i = 0; i < slots.length; i++)
            for(HashEntry<K,V> e : slots[i])
                // we don't need to check if the key exists already because we checked already in the old slots
                newslots[getIndexForKey(e.first, newSize)].add(e);
        
        slots = newslots;        
    }
    public V get(K key){
        int index = getIndexForKey(key, slots.length);
        if(slots[index] == null)
            return null;
        for(HashEntry<K,V> p : slots[index])
            if(p.first.equals(key)) // it is veryyyy important to use equals instead of ==!!!!
                return p.second;
        return null;
    }
    public boolean contains(K key){
        return get(key) != null;
    }
    public double loadFactor(){
        return nbOfElements/(slots.length*1.0);
    }
    
    public static void main(String[] args) {
        HashTable<String,Integer> t = new HashTable<>(5);
        for (char i = 0; i < 26; i++){
            System.out.println(Character.toString((char)(i+'a'))+" - "+(int)i);
            t.put(Character.toString((char)(i+'a')),(int) i);
        }
        System.out.println(t.loadFactor());
        System.out.println(t.get("z"));
        System.out.println(t.get("d"));
        System.out.println(t.contains("david"));
        System.out.println(t.contains("m"));
    }
    
    
    

}
