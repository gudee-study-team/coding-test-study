package d250812.b20920;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.TreeSet;

public class Main2 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String [] split= br.readLine().split(" ");
        StringBuilder sb = new StringBuilder();
        int wordCount = Integer.parseInt(split[0]);
        int standard= Integer.parseInt(split[1]);
        Word word = null;
        //comparator 생성
        //count 큰값이 먼저 , 같을경우 단어길이 긴게 먼저 , 같을 경우 알파벳 정렬순
        Comparator<Word> myComparator = new Comparator<Word>() {
            public int compare(Word o1, Word o2) {
                if(o1.word.equals(o2.word)){
                    return 0;
                }
                if(o1.count>o2.count){
                    return -1;
                }else if(o1.count==o2.count){
                    if(o1.word.length()>o2.word.length()){
                      return -1;
                    }else if(o1.word.length()==o2.word.length()){
                      return o1.word.compareTo(o2.word);
                    }else{
                     return 1;
                    }
                }else{
                    return 1;
                }
               
            };
        };

        TreeSet<Word> set = new TreeSet<Word>(myComparator);
        for(int i = 0; i<wordCount; i++){
            word=new Word();
            word.word=br.readLine();
            if(word.word.length()<standard){
                continue;
            }
            if(set.contains(word)){
                word=set.ceiling(word);
                set.remove(word);
                word.count++;
                set.add(word);
                continue;
            }
            set.add(word);
        }

        for(Word w : set){
            sb.append(w.word+"\n");
        }
        System.out.println(sb);
}
}
class Word implements Comparable<Word>{
    public String word=null;
    public int count = 0;    
    @Override
    public int compareTo(Word o) {
        
        return this.word.compareTo(o.word);
    }
}
