package day20211127;

public interface Map<K extends Comparable<K>,V> {
    public static class Entry<K,V>{
        K key;
        V value;
        K getKey(){
            return key;
        }

        V getValue(){
            return value;
        }

        V setValue(V value){
            V oldValue=this.value;
            this.value=value;
            return oldValue;
        }
    }

    public V put(K key,V value);
    public V get(K key);
    public V getOrDefault(K key,V value);
    public V remove(K key);
    public boolean containsKey(K key);
    public boolean containsValue(V value);
    public int size();

}
