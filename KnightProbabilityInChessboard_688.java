import java.util.Arrays;
import java.math.BigDecimal;
import java.math.BigInteger;;

public class KnightProbabilityInChessboard_688 {
	BigInteger[][][] tip;
	int maxDeep = 0;
	public double knightProbability(int N,int K,int r, int c){
		if(K == 0){
			return 1;
		}
        if(N < 3){
            return 0;
        }
		tip = new BigInteger[N][N][K+1];
		for(BigInteger[][] inner: tip)
			for(BigInteger[] in:inner){
				Arrays.fill(in, new BigInteger("-1"));
			}
		maxDeep = K;
		
		
		BigDecimal count =new BigDecimal(findCount(r, c, 0, N));
		BigDecimal deep = new BigDecimal("8");
		BigDecimal amount = deep.pow(K);
		System.out.println(count);
		System.out.println(amount);
		return count.divide(amount).doubleValue();
	}
	public BigInteger findCount(int a,int b,int deep,int N){
		System.out.println(a+" "+b+" "+deep+" "+maxDeep+" "+N);
		if(!tip[a][b][deep].equals(new BigInteger("-1"))){
			return tip[a][b][deep];
		}
		else{
			BigInteger num = new BigInteger("0");
			if(deep == maxDeep){
				if(isFine(a,b,N)){
					return new BigInteger("1");
				}
				return new BigInteger("0");
			}
			else if(!isFine(a, b, N)){
				return new BigInteger("0");
			}
			else{
				System.out.println("inner");
				if(isFine(a+1, b+2, N)){
					num = num.add(findCount(a+1, b+2, deep+1, N));
				}
				if(isFine(a+1, b-2, N)){
					num = num.add(findCount(a+1, b-2, deep+1, N));
				}
				if(isFine(a-1, b+2, N)){
					num = num.add(findCount(a-1, b+2, deep+1, N));
				}
				if(isFine(a-1, b-2, N)){
					num = num.add(findCount(a-1, b-2, deep+1, N));
				}
				if(isFine(a+2, b+1, N)){
					num = num.add(findCount(a+2, b+1, deep+1, N));
				}
				if(isFine(a+2, b-1, N)){
					num = num.add(findCount(a+2, b-1, deep+1, N));
				}
				if(isFine(a-2, b+1, N)){
					num = num.add(findCount(a-2, b+1, deep+1, N));
				}
				if(isFine(a-2, b-1, N)){
					num = num.add(findCount(a-2, b-1, deep+1, N));
				}
			}
			if(deep < 5)
				System.out.println(deep+" "+num);
			tip[a][b][deep] = num;
		}
		return tip[a][b][deep];
	}
	public boolean isFine(int a, int b, int N){
		if(a >= N|| a < 0 || b >= N || b < 0){
			return false;
		}
		return true;
	}
}