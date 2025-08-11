package d250804.impl.arraylist;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

// List interface 재정의
interface MyList<T> extends List<T> {

    boolean add(T value); // 요소를 추가
    void add(int index, T value); // 요소를 특정 위치에 추가

    boolean remove(Object value); // 요소를 삭제
    T remove(int index); // 특정 위치에 있는 요소를 삭제

    T get(int index); // 요소 가져오기
    T set(int index, T value); // 특정 위치에 있는 요소를 새 요소로 대체

    boolean contains(Object value); // 특정 요소가 리스트에 있는지 여부를 확인
    int indexOf(Object value); // 특정 요소가 몇 번째 위치에 있는지를 반환 (순차 검색)
    int lastIndexOf(Object o); // 특정 요소가 몇 번째 위치에 있는지를 반환 (역순 검색)

    int size(); // 요소의 개수를 반환
    boolean isEmpty(); // 요소가 비어있는지
    
    public void clear(); // 요소를 모두 삭제
    
}

// 재정의한 List interface 구현
class MyArrayList<T> implements MyList<T> {
	
	private static final int DEFAULT_CAPACITY = 5; // 생성자로 배열이 생성될 때의 기본 용량
	private static final Object[] EMPTY_ELEMENTDATA = {}; // 빈 배열(size = 0)
	
	private int size; // elementData[]에 담긴 데이터의 갯수를 나타냄
	private Object[] elementData; // 자료를 담을 배열
	
	public MyArrayList() {
		this.elementData = new Object[DEFAULT_CAPACITY]; // 기본 용량으로 초기화
		this.size = 0;
	}
	
	public MyArrayList(int capacity) throws IllegalArgumentException {
		if(capacity > 0) {
			this.elementData = new Object[capacity]; // 배열에 사이즈만큼의 용량 할당
		} else if (capacity == 0) {
			this.elementData = EMPTY_ELEMENTDATA; // 빈 배열로 초기화
		} else if (capacity < 0) {
			throw new IllegalArgumentException("Illegal Capacity: " + capacity); // 컴파일예외를 던짐
		}
		
		this.size = 0;
	}
	
	private void resize() {
	    int oldCapacity = elementData.length; // 현재 배열의 크기를 얻음

	    if(oldCapacity == size) {
	    	// 용량이 꽉찬 경우 -> 용량을 늘림
	    	int newCapacity = oldCapacity + 10; // 새 용량의 크기 설정
	    	elementData = Arrays.copyOf(elementData, newCapacity); // 새 크기를 가지는 새 배열을 만들고 기본 배열을 복붙
	    } else if (oldCapacity == 0) {
	    	// 들어있는 데이터가 하나도 없을 경우 (빈 배열 일경우)
	    	elementData = new Object[DEFAULT_CAPACITY]; // 기본 용량 할당
	    }
	}

	@Override
	public Iterator<T> iterator() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object[] toArray() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <T> T[] toArray(T[] a) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean containsAll(Collection<?> c) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean addAll(Collection<? extends T> c) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean addAll(int index, Collection<? extends T> c) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean removeAll(Collection<?> c) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean retainAll(Collection<?> c) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public ListIterator<T> listIterator() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ListIterator<T> listIterator(int index) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<T> subList(int fromIndex, int toIndex) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean add(T value) {
		resize(); // 현재 배열이 꽉 차있으면 리사이징, 배열 길이가 0이면 기본 길이 할당
		
		elementData[size] = value;
		size++;
		
		return true;
	}

	@Override
	public void add(int index, T value) {
		// 해당 인덱스 자리에 값이 이미 있는 경우 -> 한 칸씩 오른쪽으로 밀어내고 넣어야 함
		elementData[index] = value;
		// 값이 없으나 앞에 빈 값이 있는 경우 혹은 index가 음수인 경우 -> 예외 던지기
		// 값도 없고 앞에 빈 값도 없는 경우 -> 값 넣기
		
	}

	@Override
	public boolean remove(Object value) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public T remove(int index) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public T get(int index) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public T set(int index, T value) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean contains(Object value) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public int indexOf(Object value) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int lastIndexOf(Object o) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int size() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void clear() {
		// TODO Auto-generated method stub
		
	}
	
}

public class Main {
	public static void main(String[] args) {
		List<String> list = new ArrayList<String>();
	}
}
