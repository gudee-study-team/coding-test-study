import java.util.Scanner;

public class  Main {
    public static void main(String[] args) {
       Scanner sc = new Scanner(System.in);
       int num = sc.nextInt();
       int[] arr = new int[num];
       int sum = 0;
       //수열 B를 입력받음
       for(int i = 0; i<num ; i++){
         arr[i]=sc.nextInt();
       }
       //수열 B를 A로 전환
       for(int i= 0; i<num ; i++){
        arr[i]= arr[i]*(i+1)-sum;
        sum+=arr[i];
       }
       for(int i = 0 ; i<num; i++){
        System.out.println(arr[i]);
       }
       
        
    }
}

