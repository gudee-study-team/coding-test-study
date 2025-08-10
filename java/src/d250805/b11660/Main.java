package d250805.b11660;

import java.util.*;
import java.io.*;


public class Main {
    //한 행씩 누적합을 정함 1행이면 1행의 누적합, 2행이면 2행의 누적합
    //x1에서 x2까지 반복하면서 y2까지의 누적합에서 y1-1의 누적합을 빼고 최종합에 더함 
    static BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
    public static void main(String[] args) throws Exception{
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int [][] array = prefixSum(N);
    
        for(int i =0 ; i<M; i++){
            st=new StringTokenizer(br.readLine());
            int x1=Integer.parseInt(st.nextToken())-1;
            int y1=Integer.parseInt(st.nextToken())-1;
            int x2=Integer.parseInt(st.nextToken())-1;
            int y2=Integer.parseInt(st.nextToken())-1;  
            int sum = prefixSum(array, x1, y1, x2, y2);
            sb.append(sum+"\n");
        }
        System.out.println(sb);

    }



    /*
     누적합 2차원 배열에 저장 
     1 2 3         1 3 6
     2 3 4   ->    2 5 9
     5 6 7         5 11 18
     */
    public static int[][] prefixSum(int N)throws Exception{
        int[][] multiArray = new int[N][N];
        for(int i = 0; i < N ; i++ ){
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j = 0; j<N ; j++){
                if(j==0){
                    multiArray[i][j]=Integer.parseInt(st.nextToken());
                }else{
                    multiArray[i][j]=Integer.parseInt(st.nextToken())+multiArray[i][j-1];
                }
            }
        }
        return multiArray;
    }
    //x1에서 x2까지 반복하면서 y2까지의 누적합에서 y1-1의 누적합을 빼고 최종합에 더함 
    public static int prefixSum(int[][]multiArray,int x1 , int y1 , int x2 ,int y2){
        int result =0;
        for(int i = x1 ; i<=x2; i++){

            if(y1==0){
                result += multiArray[i][y2];
            }else{
                result += multiArray[i][y2]-multiArray[i][y1-1];
            }
        }
        return result;
    }
}
