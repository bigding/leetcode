public class SuperWashingMachines_517 {
    public int findMinMoves(int[] machines){
        int sum = 0;
        for(int i: machines)
            sum += i;
        if(sum % machines.length != 0)
            return -1;
        int avg = sum/machines.length, cnt = 0, max = 0;
        for(int load: machines){
            cnt += load-avg; //load-avg is "gain/lose"
            max = Math.max(Math.max(max, Math.abs(cnt)), load-avg);
        }
        return max;
    }

    public static void main(String[] args) {
        SuperWashingMachines_517 obj = new SuperWashingMachines_517();
        System.out.println(obj.findMinMoves(new int[]{9,1,8,8,9}));
    }
}
