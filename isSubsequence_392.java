/*******
    ***created by bigding at 2017年06月25日 星期日 23时17分28秒
    ***introduce:
 *******/

public class isSubsequence_392{
    public boolean isSubsequence(String s, String t){
        int lengths = s.length(), lengtht = t.length();
        int posis = 0, posit = 0;
        while(posis < lengths && posit < lengtht){
            if(t.charAt(posit) != s.charAt(posis)){
                posit++;
            }
            else if(t.charAt(posit) == s.charAt(posis)){
                posis++;
                posit++;
            }
        }
        if(posis == lengths){
            return true;
        }
        return false;
    }
}
