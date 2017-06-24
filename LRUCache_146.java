/*******
    ***created by bigding at 2017年06月18日 星期日 10时42分10秒
    ***introduce:
 *******/
import java.util.*;

public class LRUCache_146{
    List<MapValue> valueList = new ArrayList<MapValue>();
    List<integer> orderQueue = new LinkedList<Integer>();
    int capacity;
    int capacityNow;
    int posi = -1;
    int prePosi = -1;
    public LRUCache_146(int capacity){
        this.capacity = capacity;
    }
    public int get(int key){
        System.out.println("list:");
        for(int i = 0; i < valueList.size(); i++){
            System.out.println("a:"+valueList.get(i).getA()+"\tb:"+valueList.get(i).getB());
        }
        prePosi = key;
        if(capacityNow == 0)
            return -1;
        int returnNum = -1;
        for(int i = 0; i < capacityNow; i++){
            if(valueList.get(i).getA() == key){
                returnNum =  valueList.get(i).getB();
            }
        }
        if(returnNum != -1){
            orderQueue.offer(key);
        }
        System.out.print("key "+ key +"\tout:");
        return returnNum;
    }
    public void put(int key, int value){
        posi = (posi+1) % capacity;
        if(capacityNow < capacity){
            valueList.add(new MapValue(key,value));
            capacityNow++;
        }
        else{
            valueList.remove(posi);
            valueList.add(posi,new MapValue(key,value));
        }
        System.out.println("status:"+capacity+"\t"+capacityNow);
    }
    public static void main(String[] args){
        int capacity = 3;
        LRUCache_146 cache = new LRUCache_146(capacity);
        cache.put(1,1);
        cache.put(2,2);
        cache.put(3,3);
        cache.put(4,4);
        System.out.println(cache.get(4));
        System.out.println(cache.get(3));
        System.out.println(cache.get(2));
        System.out.println(cache.get(1));
        cache.put(5,5);
        System.out.println(cache.get(1));
        System.out.println(cache.get(2));
        System.out.println(cache.get(3));
        System.out.println(cache.get(4));
        System.out.println(cache.get(5));
    }
}
class MapValue{
    int a;
    int b;
    MapValue(int i,int j){
        a = i;
        b = j;
    }
    int getA(){
        return a;
    }
    int getB(){
        return b;
    }
}
