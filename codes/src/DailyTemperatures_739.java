public class DailyTemperatures_739 {
    public int[] dailyTemperatures(int[] temperatures) {
        int[] tem = new int[temperatures.length];
        for(int i = 0; i < temperatures.length; i++){
            int day = 0;
            for(int j = i+1; j < temperatures.length; j++){
                if(temperatures[i] >= temperatures[j]){
                    day++;
                }
                else{
                    tem[i] = day+1;
                    break;
                }
            }
        }
        return tem;
    }
}
