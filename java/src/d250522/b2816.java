import java.util.Scanner;

public class b2816 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        int count = 0;
        String[] arr = new String[num];
        int[] result =new int [500]; // 결과 배열, ArrayList 는 배우고 나서 사용하려고

        //문자열 입력받기
        for (int i=0; i < num ; i++ ){
            arr[i]=sc.next();
        }    
        //KBS1 리스트 첫번째로 이동  
        for(int i = 0; i<num ; i++ ){
            if(arr[i].equals("KBS1")){
                for(int j = 0 ; j<i; j++){
                    result[count++] = 1;
                }
                //배열도 같이 변경
                for(int j = i; j>0; j--){
                    String re = arr[j];
                    arr[j]=arr[j-1];
                    arr[j-1]=re;
                    result[count++] = 4;
                }
            }
        
        }
        //KBS1 이동 후 화살표를 한칸 아래로 이동 
        result[count++] =1;

        //KBS2 리스트 두번째로 이동
        for(int i = 1; i<num ; i++ ){
            if(arr[i].equals("KBS2")){
                for(int j = 1 ; j<i; j++){
                    result[count++] = 1;
                }
                //KBS2까지만 하면 돼서 굳이 배열 변경 x
                for(int j = 1; j<i; j++){
                    result[count++] = 4;
                }
            }
        
        }
        //결과 출력
        for(int i = 0 ; i<count ; i++){
            System.out.print(result[i]);
        }
        }

    
}
