public class DetectCapital_520 {
    public boolean detectCapitalUse(String word) {
        boolean first = false;
        if(word.charAt(0) <= 'Z' && word.charAt(0) >= 'A'){
            first = true;
        }
        else{
            first = false;
        }

        if(!first){
            for(int i = 1; i < word.length() ; i++){
                if(word.charAt(i) <= 'Z' && word.charAt(i) >= 'A')
                    return false;
            }
            return true;
        }
        else{
            if(word.length() == 1)
                return true;
            boolean sec = false;
            if(word.charAt(1) <= 'Z' && word.charAt(1) >= 'A'){
                sec = true;
            }
            else
                sec = false;
            if(sec){
                for (int i = 2; i < word.length(); i++){
                    if(word.charAt(i) <= 'z' && word.charAt(i) >= 'a')
                        return false;
                }
                return true;
            }
            else{
                for (int i = 2; i < word.length(); i++){
                    if(word.charAt(i) <= 'Z' && word.charAt(i) >= 'A')
                        return false;
                }
                return true;
            }
        }
    }
}
