package d250818.b11725;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/*
 * node 클래스를 만들고,
 * num, connectedSet, ChildSet, parent 필드를 만듦
 * 숫자 하나 받을때마다 node 인스턴스를 만들어서
 * num에는 그 숫자를, conectedSet에는 그 숫자 옆에 입력된 숫자를 넣음
 * 다 입력받으면 num이 1인 것부터 connectedSet을 확인함
 * connectedSet에 있으면 childSet에 넣음
 * childSet을 돌면서 그 childSet에 있는 숫자를 num으로 가지는 node의 parent에 num을 넣음
 * 반복
 * ...
 * num = 2 인것부터 오름차순으로 parent 출력
 */
class Node {
	public Set<Integer> connectedSet = new HashSet<>();
	public Set<Integer> childSet  = new HashSet<>();
	public int parent;
	
	@Override
	public String toString() {
		return "Node [connectedSet=" + connectedSet + ", childSet=" + childSet + ", parent=" + parent + "]";
	}
}

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		Map<Integer, Node> map = new HashMap<>();
		
		int n = Integer.parseInt(br.readLine());
		System.out.println(n);
		
		for (int i = 0; i < n - 1; i++) {
//			System.out.println(i);
			String nodes[] = br.readLine().split(" ");
			int num1 = Integer.parseInt(nodes[0]);
			int num2 = Integer.parseInt(nodes[1]);
			
			if (map.get(num1) == null) map.put(num1, new Node());
			map.get(num1).connectedSet.add(num2);
			
			if (map.get(num2) == null) map.put(num2, new Node());
			map.get(num2).connectedSet.add(num1);
		}
		
		Set<Integer> parentSet = new HashSet<>();
		int i = 1;
		
		for (int num : map.get(1).connectedSet) {
			
			setChildren(map, parentSet, i, n);
		}
		
		for (int k : map.keySet()) {
			System.out.println(map.get(k).parent);
		}
	}
	
	public static void setChildren(Map<Integer, Node> map, Set<Integer> parentSet, int i, int n) {
		System.out.println(i);
		if (!parentSet.contains(i)) map.get(i).childSet.add(i);
		
		for(int num : map.get(i).childSet) {
			setChildren(map, parentSet, num, n);
			parentSet.add(i);
			map.get(num).parent = i;
			
			
			if (num < n - 1) break;
		}
	}
}
