import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
  public static void main(String[] args) throws Exception{
    //자연수 N의 생성자 중 가장 작은 값- > N까지의 값들의 분해합 중 가장 작은값 
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int num = Integer.parseInt(br.readLine());
    int result=num;

    //생성자가 몇개인지 체크
    int count=0;
    // 1~N까지 분해합 
    for(int i = 1 ; i<=num; i++){
      //1~N까지 반복문을 돌림
      int swift=i; // 분해합값
      int re = i; // 연산에 사용될 변수
      while (re>0) {
        //각 자리수의 합을 swift에 저장
        swift += re%10;
        re = re/10;
      }
      //i의 분해합이 num과 같다면 그때의 i값이 num의 생성자가 됨
      if(swift==num){
        count++; // 생성자 개수 
        if(i<result) // 굳이 최소값을 if문으로 안하고 처음 나온 i값을 반환하면 그게 최소값이 된다
        // 생성자 중 최소값을 저장
        result=i;
      } 
    }
    if(count==0){
      System.out.println(count);
    }else{
      System.out.println(result); 
    }   
    }
      
}
