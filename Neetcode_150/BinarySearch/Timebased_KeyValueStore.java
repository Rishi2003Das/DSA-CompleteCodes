/*
981. Design a time-based key-value data structure that can store multiple values for the same key at 
different timestamps and retrieve the key's value at a certain timestamp.

Implement the TimeMap class:

TimeMap() initialises the data structure object.
void set(String key, String value, int timestamp)- Stores the key key with the value value at the given time timestamp.
String get(String key, int timestamp) - Returns a value such that set was called previously, with timestamp_prev <= timestamp. 
If there are multiple such values, it returns the value associated with the largest timestamp_prev. If there are no values, it returns "".
*/

class Data {
    String val;
    int time;
    Data(String val, int time) {
        this.val = val;
        this.time = time;
    }
}
class TimeMap {

    /** Initialize your data structure here. */
    Map<String, List<Data>> map;
    public TimeMap() {
        map = new HashMap<String, List<Data>>();
    }

    public void set(String key, String value, int timestamp) {
        map.computeIfAbsent(key, k -> new ArrayList<Data>()).add(new Data(value, timestamp));
    }

    public String get(String key, int timestamp) {
        if (!map.containsKey(key)) return "";
        return binarySearch(map.get(key), timestamp);
    }

    private String binarySearch(List<Data> list, int time) {
        int left = 0, right = list.size() - 1;
        while (left < right) {
            int mid = (left + right + 1) >>> 1;
            if (time < list.get(mid).time)
                right = mid - 1;
            else
                left = mid;
        }
        return list.get(left).time <= time ? list.get(left).val : "";  // left == right
    }
}
