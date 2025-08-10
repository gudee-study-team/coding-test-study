package d250805.b2559;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static void main(String[] args) throws Exception {
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken())-1;// 2일동안이라면 index상으로는 1차이
        int[] array = prefixSum(new StringTokenizer(br.readLine()), N);
        System.out.println(MaxSum(array, K));

    }

    //누적합을 저장
    public static int[] prefixSum(StringTokenizer st,int N){
        int[] array = new int[N];
        for(int i = 0; i<N; i++){
            if(i==0){
                array[i]=Integer.parseInt(st.nextToken());
            }else{
                array[i]=Integer.parseInt(st.nextToken())+array[i-1];                
            }
        }
        return array;
    }

    //누적합을 통해 구간의 최대값을 구함
    public static int MaxSum(int[] array , int K){
        int sum=array[K];
        int max=sum;
        int i=1;
        while (array.length-1>=i+K) {
           
            sum= array[i+K]-array[i-1];
            if(max<sum){
                max=sum;
            }

            i++;
        }
        return max;
    }
}
