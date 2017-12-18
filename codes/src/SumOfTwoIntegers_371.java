public class SumOfTwoIntegers_371 {
    public int getSum(int a, int b){
        int value = a ^ b;
        int carry = a & b;
        carry <<= 1;
        while(carry != 0){
            int tmp = value;
            value = value ^ carry;
            carry = tmp & carry;
            carry <<= 1;
        }
        return value;
    }

    public static void main(String[] args) {
        SumOfTwoIntegers_371 obj = new SumOfTwoIntegers_371();
        System.out.println(obj.getSum(2,3));
    }
}
