public class FreeDomTrail_514 {
    int[][] tip;
    public int findRotateSteps(String ring, String key){
        tip = new int[key.length()+1][ring.length()+1];
        for(int i = 0; i < key.length(); i++){
            for(int j = 0; j < ring.length(); j++){
                tip[i][j] = 0;
            }
        }
        return f(0,0, ring, key);
    }
    public int f(int n, int posi, String ring, String key){
        if(n >= key.length()){
            return 0;
        }
        if(tip[n][posi] == 0){
            int minValue = Integer.MAX_VALUE;
            for(int i = 0; i <= ring.length()/2; i++){
                if(ring.charAt((posi+i)%ring.length()) == key.charAt(n)){
                    minValue = Math.min(minValue,1+i+f(n+1,(posi+i)%ring.length(),ring,key));
                }
                if(ring.charAt((posi+ring.length() - i)%ring.length()) == key.charAt(n)){
                    minValue = Math.min(minValue,1+i+f(n+1,(posi+ring.length() - i)%ring.length(),ring,key));
                }
            }
            tip[n][posi] = minValue;
        }
        return tip[n][posi];
    }
    public static void main(String args[]){
        FreeDomTrail_514 obj = new FreeDomTrail_514();
        System.out.println(obj.findRotateSteps("abcde","abe"));
    }
}
