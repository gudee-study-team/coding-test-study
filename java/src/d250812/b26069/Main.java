package d250812.b26069;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {
    //Set에 무지개 댄스를 추는 사람의 이름을 저장해둠 
    //Set에 있는 사람을 만날경우 Set에 추가
    //최종적으로 Set의 데이터 개수를 출력
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()); 
        Set<String> rainbowDance = new HashSet<>();
        
        rainbowDance.add("ChongChong"); // 총총이는 set에 미리 넣어둠
        int meetCount =Integer.parseInt(st.nextToken());
        String person1=null,person2=null;

        for(int i = 0; i<meetCount; i++){
            st= new StringTokenizer(br.readLine());
            person1=st.nextToken();
            person2=st.nextToken();

            //두사람 모두 set에 없으면 아무일도 없음
            if(!rainbowDance.contains(person1)&&!rainbowDance.contains(person2)){

            }else{
                rainbowDance.add(person2);
                rainbowDance.add(person1);
            }
        }
        System.out.println(rainbowDance.size());


    }

}
