/**
 * Created by DongHyun on 2015-11-11.
 */
public class HashMap<K,V> {
    private final static int TABLE_SIZE = 128;

    LinkedHashEntry[] table;

    public HashMap() {
        table = new LinkedHashEntry[TABLE_SIZE];
        for (int i = 0; i < TABLE_SIZE; i++)
            table[i] = null;
    }

    public V get(K key) {
        int hash = getIndex(key);
        if (table[hash] == null)
            return null;
        else {
            LinkedHashEntry entry = table[hash];
            while (entry != null && !entry.getKey().equals(key))
                entry = entry.getNext();
            if (entry == null)
                return null;
            else
                return (V)entry.getValue();
        }
    }

    public void put(K key, V value) {
        int hash = getIndex(key);
        if (table[hash] == null) //해싱된 곳에 아무것도 없으면 바로추가
            table[hash] = new LinkedHashEntry(key, value);
        else { //이미 같은 hash를 가진 entry가 존재
            LinkedHashEntry entry = table[hash];
            while (entry.getNext() != null && !entry.getKey().equals(key))
                entry = entry.getNext();
            if (entry.getKey().equals(key)) // 같은 key면 value 수정
                entry.setValue(value);
            else
                entry.setNext(new LinkedHashEntry(key, value));
        }
    }

    public void remove(K key) {
        int hash = getIndex(key);
        if (table[hash] != null) {
            LinkedHashEntry prevEntry = null;
            LinkedHashEntry entry = table[hash];
            while (entry.getNext() != null && !entry.getKey().equals(key)) {
                prevEntry = entry;
                entry = entry.getNext();
            }
            if (entry.getKey().equals(key)) {
                if (prevEntry == null)
                    table[hash] = entry.getNext();
                else
                    prevEntry.setNext(entry.getNext());
            }
        }
        else
            System.out.println("Not Found !!");
    }

    private int getIndex(K key) {
        int hash =Math.abs(key.hashCode()) % table.length;

        return hash;
    }

    public static void main(String[] args){
        HashMap hashMap = new HashMap();

        for(int i=1;i<130;i++){
            hashMap.put("가나다라"+i,i);
        }

        for(int i=1;i<130;i++){
            System.out.println(hashMap.get("가나다라"+i));
        }
        hashMap.put("Lorem ipsum dolor sit amet", "Lorem ipsum dolor sit amet, consectetur adipiscing elit.");

        hashMap.put("In eget lacus rhoncus", "In eget lacus rhoncus, facilisis justo ac, venenatis turpis.");
        hashMap.put("Vestibulum aliquet", "Vestibulum aliquet leo sed tellus faucibus, quis feugiat felis lobortis.");
        hashMap.put("Nunc ut augue sit", "Nunc ut augue sit amet leo consectetur volutpat.");
        hashMap.put("Praesent fermentum", "Praesent fermentum ex quis nunc porta, sit amet ultricies justo ultricies.");

        hashMap.put("Morbi vehicula justo", "Morbi vehicula justo aliquam velit lacinia tristique.");

        hashMap.put("Suspendisse varius", "Suspendisse varius orci ullamcorper, porta tellus sed, dignissim diam.");
        hashMap.put("Nunc fermentum arcu", "Nunc fermentum arcu viverra, porta nibh eget, luctus quam.");
        hashMap.put("Nam finibus felis non", "Nam finibus felis non magna scelerisque, eget fringilla nulla scelerisque.");
        hashMap.put("Donec sagittis eros", "Donec sagittis eros quis dui auctor porta.");


        System.out.println(hashMap.get("Lorem ipsum dolor sit amet"));


        hashMap.remove("Morbi vehicula justo");

        System.out.println(hashMap.get("Morbi vehicula justo"));

    }
}