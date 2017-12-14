import java.util.HashMap;
import java.util.LinkedList;

public class StickersToSpellWord_691 {
    public int minStickers(String[] stickers, String target) {
        LinkedList<HashMap<Character,Integer>> list = new LinkedList<>();
        HashMap<Character,Integer> tar = new HashMap<>();
        for(int i = 0; i < stickers.length; i++){
            for(int j = 0; j < stickers[i].length(); j++){
                if(list.get(i).containsKey((Character)stickers[i].charAt(j))){
                    int count = list.get(i).get((Character)stickers[i].charAt(j));
                    list.get(i).put((Character)stickers[i].charAt(j),count+1);
                }
                else{
                    list.get(i).put((Character)stickers[i].charAt(j),1);
                }
            }
        }
        for(int i = 0; i < target.length(); i++){
            if(tar.containsKey((Character)target.charAt(i))){
                int count = tar.get((Character)target.charAt(i));
                tar.put((Character)target.charAt(i),count+1);
            }
            else{
                tar.put((Character)target.charAt(i),1);
            }
        }


        return 0;
    }
}
