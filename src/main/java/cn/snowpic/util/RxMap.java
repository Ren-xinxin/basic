package cn.snowpic.util;

import java.util.Arrays;

/**
 * @className RxMap
 * @description
 * @author lf
 * @time 2019/8/11 13:27
 **/

public class RxMap<K, V> {

    private Object[] bucket = new Object[16];

    private class Entry<K, V> {
        private K key;
        private V value;

        public Entry<K, V> next;

        public Entry(K key, V value) {
            this.key = key;
            this.value = value;
        }
    }

    public void put(K key, V value) {
        int hashCode = key.hashCode();
        int index = hashCode % (bucket.length - 1);
        if (bucket[index] == null) {
            bucket[index] = new Entry<K, V>(key, value);
        } else {
            Entry<K, V> entry = new Entry<>(key, value);
            entry.next = (Entry<K, V>) bucket[index];
            bucket[index] = entry;
        }
    }

    @Override
    public String toString() {
        return "RxMap{" +
                "bucket=" + Arrays.toString(bucket) +
                '}';
    }
}
