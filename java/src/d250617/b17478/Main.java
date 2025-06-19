package d250617.b17478;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
  public static void main(String[] args) throws Exception{
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int num = Integer.parseInt(br.readLine());
    String str = "어느 한 컴퓨터공학과 학생이 유명한 교수님을 찾아가 물었다.\n";
    str += recursion(num, 0);// 재귀함수 호출 횟수를 세기위해 
    System.out.println(str);

    
  }
// 재귀함수 호출 횟수에 따라 '____' 수를 정해줘야한다
// 재귀함수를 호출할 때 마다 몇번 째 호출인지 count를 센다
// String 변수에 출력문을 저장해서 반환해줌
  public static String recursion(int num , int c){
    String str=null;
    int count = c;
    //최종적으로 한번 출력
    if(num==0 ){
      str = "____".repeat(count)+"\"재귀함수가 뭔가요?\"\n";  
      str += "____".repeat(count)+"\"재귀함수는 자기 자신을 호출하는 함수라네\"\n";
      str += "____".repeat(count)+"라고 답변하였지.\n";
      return str;
    }
    // num개수에 따라 아래 출력문을 String 변수에 저장
    str = "____".repeat(count)+"\"재귀함수가 뭔가요?\"\n";
    str+= "____".repeat(count)+"\"잘 들어보게. 옛날옛날 한 산 꼭대기에 이세상 모든 지식을 통달한 선인이 있었어.\n";
    str+= "____".repeat(count)+"마을 사람들은 모두 그 선인에게 수많은 질문을 했고, 모두 지혜롭게 대답해 주었지.\n";
    str+= "____".repeat(count)+"그의 답은 대부분 옳았다고 하네. 그런데 어느 날, 그 선인에게 한 선비가 찾아와서 물었어.\"\n";
    count++;
    
    //재귀 함수 호출
    str+=recursion(num-1,count);



    str+="____".repeat(count-1)+"라고 답변하였지.\n";
      return str;
  }
}
