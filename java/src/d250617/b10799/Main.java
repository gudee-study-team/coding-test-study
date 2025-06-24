package d250617.b10799;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;

public class Main {
  public static void main(String[] args) throws Exception {
    // '(' 들어오면 count를 증가 ')'이들어오면 count를 감소 시킴 이때 직전이'('라면 레이저이므로 
    // 레이저가 자른 쇠막대기의 왼쪽 부분의 개수를 더함 
    // 그냥 ')'가 들어오면 쇠막대기가 끝나는 부분이므로 개수를 1 증가시킴 
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String[] strArr = br.readLine().split("");
    Deque<String> deque = new ArrayDeque<>();
    int count =0 , result=0;
    
    for(int i = 0 ; i<strArr.length; i++){
      if(strArr[i].equals("(")){
        count++; // 쇠막대기 시작
      }
      else if(strArr[i].equals(")")){
        count--;  
        if(strArr[i-1].equals("(")){
          
          result += count; // 레이저가 자른 왼쪽 부분의 개수를 더함
        }else{
          result++; // 쇠막대기가 닫히면 레이저의 오른쪽 부분의 개수를 더함
        }
        
      }

    }
    System.out.println(result);
  
  }
}
