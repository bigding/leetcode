public class TwoKeysKeyboard_650 {
    public int minSteps(int n){
        int sum = 0;
        int num = n;
        while(num > 1){
            for(int i = 2; i <= num; i++){
                if(num % i == 0 || i == num){
                    sum += i;
                    num /= i;
                    break;
                }
            }
        }
        return sum;
    }

    public static void main(String[] args) {
        TwoKeysKeyboard_650 obj = new TwoKeysKeyboard_650();
        System.out.println(obj.minSteps(25));
    }
}
