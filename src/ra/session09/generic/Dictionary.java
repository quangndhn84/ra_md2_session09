package ra.session09.generic;

public class Dictionary<K,V> {
    //Generic cho Class: định nghĩa sau tên Class
    /*
    * Study: học
    * Student: sinh viên
    * love: yêu
    * Key: Value
    * */
    private K key;
    private V value;

    public K getKey() {
        return key;
    }

    public void setKey(K key) {
        this.key = key;
    }

    public V getValue() {
        return value;
    }

    public void setValue(V value) {
        this.value = value;
    }
}
