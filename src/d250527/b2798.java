package d250527;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class b2798 {
  
    public static void main(String[] args) throws Exception{
      //중첩 반복문으로 3개의 값을 합하는 모든 경우의 수를 구하고 그중 500보다 작은 최대값을 출력
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

      //한줄을 공백을 기준으로 배열에 저장
      String[] In = br.readLine().split(" ");
      int count = Integer.parseInt(In[0]);
      int fix = Integer.parseInt(In[1]);

      //정수로 입력 받기      
      In = br.readLine().split(" ");
      int [] sToI = new int[count];
      int sum = 0; // 합 저장 
      int max = 0; // 최대값

      //int형으로 배열에 저장
      for(int i = 0 ; i<count; i++){
        sToI[i]=Integer.parseInt(In[i]);
      }

      //첫번째 숫자 -> 두번째 숫자 -> 세번째 숫자 왼쪽부터 반복을 돌면서 모든 숫자 3개의 합을 구함
      for(int i = 0 ; i<count; i++){
        for(int j=i+1; j<count; j++){
          for(int k=j+1;k<count; k++){
            if((sToI[i]+sToI[j]+sToI[k])<=fix){
              sum = sToI[i]+sToI[j]+sToI[k];
              if(sum>max){
                max=sum;
              }
            }
          }
        }
      }
      System.out.println(max);
    }
}
