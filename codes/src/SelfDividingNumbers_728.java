import java.util.ArrayList;
import java.util.List;

public class SelfDividingNumbers_728 {
    public List<Integer> selfDividingNumbers(int left, int right) {
        List<Integer> list = new ArrayList<>();
        for(int i = left; i <= right; i++){
            int num = i,remain = i, value = 0;
            boolean isOK = true;
            while(remain > 0){
                value = remain%10;
                remain = remain/10;
                if(value == 0 || num % value != 0){
                    isOK = false;
                    break;
                }
            }
            if(isOK)
                list.add(num);
        }
        return list;
    }
}
