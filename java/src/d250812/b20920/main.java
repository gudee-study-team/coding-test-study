package d250812.b20920;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class main {
    public static void main(String[] args)throws Exception {
         BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String [] split= br.readLine().split(" ");
        StringBuilder sb = new StringBuilder();
        int wordCount = Integer.parseInt(split[0]);
        int standard= Integer.parseInt(split[1]);
        Map<String,Integer> map = new HashMap<>();
        String word= null;
        for(int i =0; i<wordCount; i++){
            word= br.readLine();
            if(word.length()<standard) continue;
            //map에 해당 키값이 존재하면 value를 꺼내서 1을 더해줌
            //없으면 기본값으로 0을 넣음
            map.put(word,map.getOrDefault(word,0)+1);
        }
        List<String> list = new ArrayList<>(map.keySet());
        
        list.sort((o1, o2) -> {
            //map에서 해당 단어의 빈도수를 검사
             if(map.get(o1)>map.get(o2)){
                    return -1;
            }else if(map.get(o1)==map.get(o2)){
                    if(o1.length()>o2.length()){
                        return -1;
                    }else if(o1.length()==o2.length()){
                        return o1.compareTo(o2);
                    }else{
                        return 1;
                    }
                }else{
                    return 1;
                }
        });
        for(String w : list){
            sb.append(w+"\n");
        }
        System.out.println(sb);
    }
}
