public class OneBitAndTwoBitCharacters_717 {
    public boolean isOneBitCharacter(int[] bits) {
        int length = bits.length;
        int i;
        for(i= 0; i < length;i++){
            System.out.println(i);
            if(bits[i] == 1){
                i++;
                if(i == length-1){
                    return false;
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        OneBitAndTwoBitCharacters_717 obj = new OneBitAndTwoBitCharacters_717();
        System.out.println(obj.isOneBitCharacter(new int[]{1, 1, 0}));
    }
}
