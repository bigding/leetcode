import org.omg.PortableInterceptor.INACTIVE;

import java.util.*;

/**
 * leetcode 732 my calender III
 */

public class MyCalenderThree {
    TreeMap<Integer,Integer> map = new TreeMap<>();

    public MyCalenderThree() {

    }

    public int book(int start, int end) {
        map.put(start,map.getOrDefault(start,0)+1);
        map.put(end,map.getOrDefault(end,0)- 1);
        int max = 0,num = 0;
        for(int n:map.values()){
            num += n;
            max = Math.max(max,num);
        }
        return max;
    }
}
