package d250805.arraylist;

import java.util.Arrays;

public class MyArrayList<E> implements MyList<E> {
  private Object[] array;
  private int pointer;

  private static final int DEFAULT_CAPACITY = 10;

  public MyArrayList() {
    this(DEFAULT_CAPACITY);
  }

  public MyArrayList(int size) {
    if (size < 0) throw new IllegalArgumentException();
    if (size < 10) size = DEFAULT_CAPACITY;

    this.array = new Object[size];
    this.pointer = 0;
  }

  private void resize() {
    int arrLength = this.array.length;

    if (this.pointer >= arrLength) {
      this.array = Arrays.copyOf(this.array, arrLength * 2);
    }

    if (this.pointer < (arrLength / 3)) {
      this.array = Arrays.copyOf(this.array, arrLength / 2);
    }
  }

  @Override // 요소를 추가
  public boolean add(E value) {
    resize();

    this.array[pointer] = value;
    pointer++;

    return true;
  }

  @Override // 요소를 특정 위치에 추가
  public void add(int index, E value) {
    if (index > pointer || index < 0) throw new ArrayIndexOutOfBoundsException();

    resize();

    for (int i = pointer - 1; i >= index; i--) {
      this.array[i + 1] = this.array[i];
    }

    this.array[index] = value;
    pointer++;
  }

  @Override // 요소를 삭제
  public boolean remove(Object value) {
    for (int i = 0; i < this.pointer; i++) {
      if (array[i].equals(value)) {
        for (int j = i; j < this.pointer - 1; j++) {
          array[j] = array[j + 1];
        }

        pointer--;
        return true;
      }
    }

    return false;
  }

  @Override // 특정 위치에 있는 요소를 삭제
  @SuppressWarnings("unchecked")
  public E remove(int index) {
    if (index >= pointer || index < 0) throw new ArrayIndexOutOfBoundsException();

    E result = (E) array[index];

    if (index != pointer - 1) {
      for (int i = index; i < this.pointer - 1; i++) {
        array[i] = array[i + 1];
      }
    }

    pointer--;
    return result;
  }

  @Override // 요소 가져오기
  @SuppressWarnings("unchecked")
  public E get(int index) {
    if (index >= pointer || index < 0) throw new ArrayIndexOutOfBoundsException();

    return (E) array[index];
  }

  @Override // 특정 위치에 있는 요소를 새 요소로 대체
  public void set(int index, E value) {
    if (index >= pointer || index < 0) throw new ArrayIndexOutOfBoundsException();

    array[index] = value;
  }

  @Override // 특정 요소가 리스트에 있는지 여부를 확인
  public boolean contains(Object value) {
    for (int i = 0; i < this.pointer; i++) {
      if (array[i].equals(value)) return true;
    }

    return false;
  }

  @Override // 특정 요소가 몇 번째 위치에 있는지를 반환 (순차 검색)
  public int indexOf(Object value) {
    for (int i = 0; i < this.pointer; i++) {
      if (array[i].equals(value)) return i;
    }

    return -1;
  }

  @Override // 특정 요소가 몇 번째 위치에 있는지를 반환 (역순 검색)
  public int lastIndexOf(Object o) {
    for (int i = pointer - 1; i >= 0; i--) {
      if (array[i].equals(o)) return i;
    }

    return -1;
  }

  @Override // 요소의 개수를 반환
  public int size() {
    return this.pointer;
  }

  @Override // 요소가 비어있는지
  public boolean isEmpty() {
    if (this.pointer == 0) return true;
    else return false;
  }

  @Override // 요소를 모두 삭제
  public void clear() {
    this.array = new Object[DEFAULT_CAPACITY];
    this.pointer = 0;
  }
}
