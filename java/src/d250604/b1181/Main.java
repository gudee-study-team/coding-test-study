package d250604.b1181;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Main  {
  public static void main(String[] args) throws Exception{
    // 배열을 사전순으로 정렬하고 길이순으로 정렬을 하면 둘다 적용된 효과가 남

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int num = Integer.parseInt(br.readLine());
    
    //Set을 이용한 중복 제거
    Set<String> set = new HashSet<String>() ;
    for(int i =0; i<num; i++){
      set.add(br.readLine());
    }
    num=set.size();
    //Set을 배열로 변환
    String [] strArray= set.toArray(new String[0]);   

    //사전순 정렬
    
    Arrays.sort(strArray);


    //길이순 정렬
    for(int j = 0; j<num-1;j++){
    
    for(int i =0; i <num-1; i++){
        String str;
        if(strArray[i].length()<=strArray[i+1].length()){
          continue;
        }else{
        str=strArray[i];
        strArray[i]=strArray[i+1];
        strArray[i+1]=str;
        }
      }
    }
    for(int i =0 ; i<num; i++){
      System.out.println(strArray[i]);
    }
  }
}
