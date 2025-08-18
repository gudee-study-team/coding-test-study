package d250804.impl.arraylist;

import java.util.Arrays;

//재정의한 List interface 구현
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
	public boolean add(T value) {
		resize(); // 현재 배열이 꽉 차있으면 리사이징, 배열 길이가 0이면 기본 길이 할당
		
		elementData[size] = value;
		size++;
		
		return true;
	}

	@Override
	public void add(int index, T value) {
		// 해당 인덱스 자리에 값이 이미 있는 경우 -> 값 대체 | 값도 없고 앞에 빈 값도 없는 경우 -> 값 넣기
		elementData[index] = value;
		// 값이 없으나 앞에 빈 값이 있는 경우 혹은 index가 음수인 경우 -> 예외 던지기
		if (index < 0 || index > size) {
			throw new IllegalArgumentException("Illegal Index: " + index);
		}
	}

	@Override
	public boolean remove(Object value) {
		// value 값과 일치하는 가장 작은 인덱스의 값을 삭제하고 삭제여부 반환
		boolean isRemoved = false;
		for (int i = 0; i < elementData.length; i++) {
			if (elementData[i].equals(value)) {
				elementData[i] = null;
				isRemoved = true;
				break;
			}
		}
		
		return isRemoved;
	}

	@Override
	public T remove(int index) {
		// 해당 인덱스에 들어있는 값을 삭제하고 값 반환
		// 만약 index가 음수거나 size-1보다 크면 예외 던지기
		if (index < 0 || index > size-1) {
			throw new IllegalArgumentException("Illegal Index: " + index);
		}
		T removedEl = (T)elementData[index];
		elementData[index] = null;
		
		
		return removedEl;
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