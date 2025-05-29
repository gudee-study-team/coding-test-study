package d250527.b2231;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws Exception {
        // 분해합
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String buff = br.readLine();

        int n = Integer.parseInt(buff);
        int len = buff.length()

        // 자릿수, /= 연산에 쓰려면 문자열 길이보다 하나 작게
        int figure = 1;
        for(int i=0; i< len - 1; i++){
            figure *= 10;
        }

        int[] arr = new int[len];
        for(int i=0; n > 10; i++){

        }

    }

    @Override
    public String toString() {
        return "Main []";
    }
}
