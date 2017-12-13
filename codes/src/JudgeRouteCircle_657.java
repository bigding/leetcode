public class JudgeRouteCircle_657 {
    public boolean judgeCircle(String moves) {
        int status1 = 0, status2 = 0;
        for(int i = 0; i < moves.length(); i++){
            if(moves.charAt(i) == 'U'){
                status1++;
            }
            if(moves.charAt(i) == 'D'){
                status1--;
            }
            if(moves.charAt(i) == 'L'){
                status2++;
            }
            if(moves.charAt(i) == 'R'){
                status2--;
            }
        }
        if(status1 == 0 && status2 == 0)
            return true;
        return false;
    }
}
