public class BinaryNumberWithAlternatingBits_693 {
    public boolean hasAlternatingBits(int n) {
        if(n < 3)
            return true;
        int bit = n %2;
        int num = n/2;
        while(num > 0){
            if(bit == num % 2)
                return false;
            bit = num %2;
            num = num /2;
        }
        return true;
    }
}
