import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
  public static void main(String[] args) throws Exception {
    //체스판이 왼쪽 위가 흰색일 경우, 검정일 경우 두가지 뿐이다. 두 가지 체스판을 입력된 체스판의 일부와 비교하여 색이 다른 체스판의 개수가 가장 적을 때 그수를 출력
    

    //첫 줄 입력 받아서 보드판 크기 설정
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String [] in = br.readLine().split(" ");
    String str;
    int row =Integer.parseInt(in[0]);
    int col = Integer.parseInt(in[1]) ;

    int result=32;
    char [][]board = new char[row][col];
    char [][]chess1 = chess1();
    char [][]chess2= chess2();

    for(int i=0; i< row ; i++){
      str = br.readLine();
      for(int j=0; j<col; j++){
        board[i][j]=str.charAt(j);
      }
    }

    //chess1과비교
    for(int i = 0 ; i <row-7; i++){ // 인덱스가 0부터 시작임으로 8이아닌 7을 빼줌
      for(int j = 0 ; j<col-7;j++){
        //입력된 보드판의 좌측상단 (시작지점 인덱스)

        int count =0; // 다른 정사각형의 개수
        for(int k = i; k<i+8;k++){
          for(int y= j; y<j+8; y++){
            if(board[k][y]!=chess1[k-i][y-j]){
              count++;
            }
          }
        }
        if(count<result){
            result=count; //최소값을 저장
          }
      }
    }
    //chess2와비교
    for(int i = 0 ; i <row-7; i++){
      for(int j = 0 ; j<col-7;j++){
        int count=0;
        for(int k = i; k<i+8;k++){
          for(int y= j; y<j+8; y++){
            if(board[k][y]!=chess2[k-i][y-j]){
              count++;
            }
          }
        }
        if(count<result){
            result=count; //최소값을 저장
          }
      }
    }

    System.out.println(result);
    


    
  }



  //왼쪽 위가 W로시작하는 체스판
  public static char[][] chess1(){
    char[][] arrStrings =new char[8][8];
    
    for(int i=0; i<8; i++){
      for(int j=0; j<8; j++){
        if(i%2==0){
          arrStrings[i][j] = j%2== 0? 'W':'B';
        }
        else{
          arrStrings[i][j] = j%2== 0? 'B':'W';
        }
      }
      
    }
    return arrStrings;
  }

  //왼쪽 위가 B로시작하는 체스판

  public static char[][] chess2(){
    char[][] arrStrings =new char[8][8];
      
    for(int i=0; i<8; i++){
      for(int j=0; j<8; j++){
        if(i%2==0){
          arrStrings[i][j] = j%2== 0? 'B':'W';
        }
        else{
          arrStrings[i][j] = j%2== 0? 'W':'B';
        }
      }
      
    }
    return arrStrings;
  }
}

