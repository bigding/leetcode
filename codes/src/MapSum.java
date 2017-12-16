import java.util.HashMap;

public class MapSum {
    /**
     *  677. Map Sum Pairs
     */
    HashMap<String, Integer> map = new HashMap<>();

    public void insert(String key, int val) {
        map.put(key,val);
    }

    public int sum(String prefix) {
        int num = 0;
        for(String str:map.keySet()){
            if(prefix.length() > str.length())
                continue;
            else {
                boolean isOK = true;
                for(int i = 0; i < prefix.length();i++){
                    if(prefix.charAt(i) != str.charAt(i)){
                        isOK = false;
                        break;
                    }
                }
                if(isOK){
                    num += map.get(str);
                }
            }
        }
        return num;
    }
}
