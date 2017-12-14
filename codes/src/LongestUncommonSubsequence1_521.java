public class LongestUncommonSubsequence1_521 {
    public int findLUSlength(String a, String b) {
        int lengthA = a.length(), lengthB = b.length();
        if(lengthA != lengthB)
            return Math.max(lengthA, lengthB);
        else if(a.equals(b))
            return -1;
        return lengthA;
    }
}
