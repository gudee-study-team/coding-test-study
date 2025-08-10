package d250805.b11659;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    //배열에 숫자를 넣고 구간합을 구하면 명령이 올때 마다 배열을 탐색해서 더해야함으로 시간초과가 남
    //배열에 저장할때 누적합으로 저장하고 구하고 싶은 구간합은 끝인덱스와 시작인덱스의 배열의 값(해당 번호까지의 누적합)을 빼서 구함 
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[] array = prefixSum(new StringTokenizer(br.readLine()),N);

        StringBuilder sb = new StringBuilder();
        int startIndex=0,endIndex=0;  

        //시작,끝 인덱스 받아서 처리 인덱스처리를 위해 -1을 해줌
        for(int i = 0; i<M;  i++) {
            st= new StringTokenizer(br.readLine()); 
            startIndex=Integer.parseInt(st.nextToken())-1;
            endIndex=Integer.parseInt(st.nextToken())-1;
            sb.append(prefixSum(array,startIndex,endIndex)+"\n");
        }        
        System.out.println(sb);
    }

    // 누적합으로 배열에 저장
    public static int[] prefixSum(StringTokenizer st ,int N){
        int[] array= new int[N];
        for(int i =0 ; i<N; i++){
            if(i==0){
                array[i]=Integer.parseInt(st.nextToken());
                continue;
            }
            array[i]= array[i-1]+ Integer.parseInt(st.nextToken());
        }
        return array;
    }

    // end인덱스 누적합에서 start인덱스-1 누적합 빼기(시작 인덱스 값도 포함되어야 하니까)
    public static int prefixSum(int[] array , int startIndex, int endIndex){
            int result=0;
            if(startIndex==0){
             
                result=array[endIndex];
            }else{
                result= array[endIndex] -array[startIndex-1];
            }
        return result;
    }

}