package d250812.b20920;

import java.io.*;
import java.util.*;

/*
 * 정렬 기준
 * 1. 빈도
 * 2. 길이
 * 3. 알파벳순
 * 
 * 길이가 m이상인 단어만 포함
 * 단어 길이: 1~10
 * 
 * 빈도, 길이, 알파벳순 정렬은 한꺼번에 불가능
 * 빈도순으로 정렬한 다음
 * 그걸 중복제거 한 다음
 * 같은 빈도 내에서 길이 정렬하고
 * 같은 빈도 + 길이 내에서 알파벳순으로 정렬해야 함
 */

class Voca {
	private Integer freq;
	private Integer len;
	private String word;
	
	public Voca() {
		
	}
	public Voca(Integer freq, Integer len, String word) {
		this.freq = freq;
		this.len = len;
		this.word = word;
	}
	
	public void setFreq(Integer freq) {
		this.freq = freq;
	}
	public Integer getFreq() {
		return this.freq;
	}
	public Integer getLen() {
		return len;
	}
	public String getWord() {
		return this.word;
	}
	
	@Override
	public String toString() {
		return "Voca [freq=" + freq + ", len=" + len + ", word=" + word + "]";
	}
}

public class Main {
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String nums[] = br.readLine().split(" ");
		int n = Integer.parseInt(nums[0]);
		int m = Integer.parseInt(nums[1]);
		Map<String, Voca> map = new HashMap<>();
		
		for (int i = 0; i < n; i++) {
			String word = br.readLine();
			
			// 길이가 m 미만이면 건너뜀
			if (word.length() < m) continue;
			
			if (!map.keySet().contains(word)) {
				// 처음 등장한 단어라면
				map.put(word, new Voca(1, word.length(), word));
			} else {
				// 이미 등장한 단어라면 
				map.get(word).setFreq(map.get(word).getFreq() + 1);
				
				// 이 코드에서 시간초과가 나서 word를 키, Voca를 값으로 하여 map에다 넣고
				// map의 키로 값을 찾아오는 방법으로 변경...
//				for (Voca v : list) {
//				    if (v.getWord().equals(word)) v.setFreq(v.getFreq() + 1);
//				}
			}
		}
		
		// 정렬하기 위해 List에 옮겨담음
		List<Voca> list = new LinkedList<>();
		map.forEach((w, v) -> list.add(v));
		
		list.sort(Comparator.comparing(Voca::getFreq) // 오름차순정렬
				  .thenComparing(Voca::getLen).reversed() // 오름차순정렬 후, 지금까지 정렬한 결과를 reverse (빈도, 길이 둘 다 내림차순으로 정렬되게 됨)
				  .thenComparing(Voca::getWord));
		
		// 출력이 많으므로 StringBuilder에 옮겨담아서 출력
		StringBuilder sb = new StringBuilder();
		list.forEach(e -> sb.append(e.getWord()).append("\n"));
		System.out.print(sb);
	}
}
