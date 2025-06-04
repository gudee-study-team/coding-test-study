import java.util.Scanner;

public class b17269 {
    public static void main(String[] args) {
      Scanner sc = new Scanner(System.in);
      int num1 = sc.nextInt();
      int num2 = sc.nextInt();
      String str1 = sc.next();
      String str2 = sc.next();
      char arr[] = new char[num1+num2];
      int arrInt[] = new int[num1+num2];
      if(num1<=num2){//문자열 순서에 따라 

        //짝수번째 인덱스에 첫번째 문자열 저장 
        for(int i = 0; i< num1 ; i++){
          arr[i*2]=str1.charAt(i);
        }
        //홀수번째 인덱스에 두번재 문자열 저장
        for(int i = 0; i< num1 ; i++){
          arr[i*2+1]=str2.charAt(i);
        }
        //나머지 저장
        for(int i = num1; i<num2  ; i++){
          arr[num1+i]=str2.charAt(i);
        } 
      }else{
        for(int i = 0; i< num2 ; i++){
          arr[i*2]=str1.charAt(i);
        }
        for(int i = 0; i< num2; i++){
          arr[i*2+1]=str2.charAt(i);
        }
        for(int i = num2; i<num1  ; i++){
          arr[num2+i]=str1.charAt(i);
        }
      
      } 
      //문자를 숫자로 매핑
      for(int i = 0 ; i<arr.length;i++){
        if(arr[i]=='A'||arr[i]=='F'||arr[i]=='H'||arr[i]=='K'||arr[i]=='M'){
          arrInt[i]=3;
        }else if(arr[i]=='B'||arr[i]=='D'||arr[i]=='N'||arr[i]=='P'||arr[i]=='Q'||arr[i]=='R'||arr[i]=='T'||arr[i]=='X'||arr[i]=='Y'){
          arrInt[i]=2;
        }else if(arr[i]=='E'){
          arrInt[i]=4;
        }else{
          arrInt[i]=1;
        }

      }

      //각항의 오른쪽과 더해서10으로 나눈 나머지를 저장
      while(true){
        if(arrInt.length==2){
          break;
        }
        int[] arrInt2 = new int[arrInt.length-1];
        for(int i = 0 ; i<arrInt2.length; i++){
          arrInt2[i] =(arrInt[i]+arrInt[i+1])%10; 
        }
        arrInt=arrInt2;
      }
      //출력
      if(arrInt[0]==0){
        System.out.println(arrInt[1]+"%");
      }else{
      System.out.println(arrInt[0]+""+arrInt[1]+"%");

      }


    }
}
