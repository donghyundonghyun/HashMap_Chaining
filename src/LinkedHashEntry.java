import java.util.LinkedList;

/**
 * Created by DongHyun on 2015-11-11.
 */
public class LinkedHashEntry<K,V> extends LinkedList{
    private K key;
    private V value;
    private LinkedHashEntry next;

    public LinkedHashEntry(K key, V value) {
        this.key = key;
        this.value = value;
        this.next = null;
    }

    public V getValue() {
        return value;
    }

    public void setValue(V value) {
        this.value = value;
    }

    public K getKey() {
        return key;
    }

    public LinkedHashEntry getNext() {
        return next;
    }

    public void setNext(LinkedHashEntry next) {
        this.next = next;
    }
}