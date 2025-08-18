package d250804.impl.arraylist;

import java.util.Arrays;

//재정의한 List interface 구현
class MyArrayList<T> implements MyList<T> {
	// 필드: 데이터가 담기는 배열, List 기본 용량, List 안에 있는 데이터의 갯수
	private Object[] elementData; // 실제로 데이터가 담기는 배열
	private static final int DEFAULT_CAPACITY = 10; // 생성자로 List가 생성될 때의 기본 용량
	private int size; // List에 담긴 데이터의 갯수

	// 기본 생성자: List를 기본 용량으로 만듦
	public MyArrayList() {
		this.elementData = new Object[DEFAULT_CAPACITY];
		this.size = 0;
	}
	
	// List 용량 지정 생성자
	// 음수: 예외 던짐 | 0: 기본 용량 | 양수: 지정한 용량
	public MyArrayList(int capacity) throws IllegalArgumentException {
		if (capacity < 0) throw new IllegalArgumentException("Illegal Capacity: " + capacity);
		
		if (capacity == 0) this.elementData = new Object[DEFAULT_CAPACITY];
		else this.elementData = new Object[capacity];

		this.size = 0;
	}

	private void resize() {
		// 데이터 갯수 == List 용량인 경우 -> 현재 용량에 +기본용량
		if (size >= elementData.length) {
			int newCapacity = elementData.length + DEFAULT_CAPACITY;
			elementData = Arrays.copyOf(elementData, newCapacity); // 새 크기를 가지는 새 배열을 만들고 기존 배열을 복사
		}
	}

	@Override
	public boolean add(T value) {
		resize(); // 현재 배열이 꽉 차있으면 리사이징

		elementData[size] = value;
		size++;

		return true;
	}

	@Override
	public void add(int index, T value) {
		// index가 음수거나 size보다 크면 예외 던지기
		if (index < 0 || index > size) throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);

		resize(); // 필요시 배열 크기 증가

		// index부터 끝까지의 요소들을 한 칸씩 뒤로 이동
		// 예: [A, B, C, D] → index=2에 NEW 삽입
		// 이동 전: [A, B, C, D, _]
		// i=4: [A, B, C, D, D] (D를 뒤로 복사)
		// i=3: [A, B, C, C, D] (C를 뒤로 복사) 
		// 삽입 후: [A, B, NEW, C, D]
		for (int i = size; i > index; i--) {
			elementData[i] = elementData[i - 1];
		}
		elementData[index] = value;
		size++;
	}

	@Override
	public boolean remove(Object value) {
		// 매개변수가 null이면 예외 던짐
		if (value == null) throw new NullPointerException(value.getClass().getName() +"is null");
		
		// List가 비어있다면 false
		if(size == 0) return false;
		
		// value 값과 일치하는 가장 작은 인덱스의 값을 삭제하고 삭제여부 반환
		for (int i = 0; i < size; i++) {
			if (value.equals(elementData[i])) {
				remove(i); // 인덱스로 삭제
				return true;
			}
		}
		
		// value와 일치하는 값이 없다면 false
		return false;
	}

	@Override
	public T remove(int index) {
		// 해당 인덱스에 들어있는 값을 삭제하고 값 반환
		// 만약 index가 음수거나 size-1보다 크면 예외 던지기
		if (index < 0 || index >= size) throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);

		T removedEl = (T) elementData[index];

		// index 이후의 요소들을 한 칸씩 앞으로 이동
		// 예: [A, B, C, D, E] → index=2의 값 삭제
		// 이동 전: [A, B, _, D, E]
		// i=2: [A, B, D, D, E] (D를 앞으로 복사)
		// i=3: [A, B, D, E, E] (E를 앞으로 복사) 
		// 삭제 후: [A, B, D, E, null]
		for (int i = index; i < size - 1; i++) {
			elementData[i] = elementData[i + 1];
		}
		size--;
		elementData[size] = null;

		return removedEl;
	}

	@Override
	public T get(int index) {
		// 해당 인덱스의 요소 반환
		if (index < 0 || index >= size) throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);

		return (T) elementData[index];
	}

	@Override
	public T set(int index, T value) {
		// 특정 위치에 있는 요소를 새 요소로 대체하고 기존 값 반환
		if (index < 0 || index >= size) throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);

		T oldValue = (T) elementData[index];
		elementData[index] = value;
		return oldValue;
	}

	@Override
	public boolean contains(Object value) {
		return indexOf(value) >= 0;
	}

	@Override
	public int indexOf(Object value) {
		// 매개변수가 null이면 예외 던짐
		if (value == null) throw new NullPointerException(value.getClass().getName() +"is null");
		
		// List가 비어있다면 -1
		if(size == 0) return -1;
		
		// value 값과 일치하는 가장 작은 인덱스의 값을 반환
		for (int i = 0; i < size; i++) {
			if (value.equals(elementData[i])) return i;
		}
		
		// value와 일치하는 값이 없다면 -1
		return -1;
	}

	@Override
	public int lastIndexOf(Object value) {
		// 매개변수가 null이면 예외 던짐
		if (value == null) throw new NullPointerException(value.getClass().getName() +"is null");
		
		// List가 비어있다면 -1
		if(size == 0) return -1;
		
		// value 값과 일치하는 가장 큰 인덱스의 값을 반환
		for (int i = size - 1; i >= 0; i--) {
			if (value.equals(elementData[i])) return i;
		}
		// value와 일치하는 값이 없다면 -1
		return -1;
	}

	@Override
	public int size() {
		return size;
	}

	@Override
	public boolean isEmpty() {
		return size == 0;
	}

	@Override
	public void clear() {
		// 요소를 모두 삭제
		for (int i = 0; i < size; i++) elementData[i] = null;
		size = 0;
	}
}