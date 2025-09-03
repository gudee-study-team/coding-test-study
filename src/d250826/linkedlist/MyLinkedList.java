package d250826.linkedlist;

import java.util.Arrays;
import java.util.Objects;

public class MyLinkedList<E> {
	private Node<E> headNode;
	private Node<E> tailNode;
	private int size;

	// 값을 담을 노드
	private static class Node<E> {
		private E data;
		private Node<E> nextNode;
		
		Node(E data) {
			this.data = data;
		}
	}
	
	// 생성자
	public MyLinkedList() {
		this.headNode = null;
		this.tailNode = null;
		this.size = 0;
	}
	
	// index 검색을 위한 메서드
	private Node<E> search(int index) {
		Node<E> node = this.headNode;
		
		for (int i = 0; i < index; i++) {
			node = node.nextNode;
		}
		
		return node;
	}
	
	// index 위치에 element를 추가하는 메서드
	public void add(int index, E element) {
		if (index > this.size || index < 0) throw new ArrayIndexOutOfBoundsException();
		if (index == 0) addFirst(element);
		if (index == this.size) addLast(element);
		
		Node<E> newNode = new Node<E>(element);
		Node<E> prevNode = search(index - 1);
		
		newNode.nextNode = prevNode.nextNode;
		prevNode.nextNode = newNode;
		
		this.size++;
	}
	
	// 맨 앞에 element를 추가하는 메서드
	public void addFirst(E element) {
		Node<E> newNode = new Node<E>(element);
		
		if (this.headNode == null) {
			this.headNode = newNode;
			this.tailNode = newNode;
		} else {
			Node<E> head = this.headNode;
			newNode.nextNode = head;
			this.headNode = newNode;
		}
		
		this.size++;
	}
	
	// 맨 뒤에 element를 추가하는 메서드
	public void addLast(E element) {
		if (this.tailNode == null) {
			addFirst(element);
		} else {
			Node<E> newNode = new Node<E>(element);
			Node<E> tail = this.tailNode;
			tail.nextNode = newNode;
			this.tailNode = newNode;
		}
		
		this.size++;
	}

	// 맨 앞의 값을 삭제하는 메서드
	public E removeFirse() {
		if (this.headNode == null) return null;
		
		Node<E> head = this.headNode;
		this.headNode = head.nextNode;
		
		this.size--;
		return head.data;
	}
	
	// 맨 뒤의 값을 삭제하는 메서드
	public E removeLast() {
		if (this.tailNode == null) return null;
		
		Node<E> tail = this.tailNode;
		Node<E> prevTailNode = search(size - 2);
		
		prevTailNode.nextNode = null;
		this.tailNode = prevTailNode;
		
		this.size--;
		return tail.data;
	}
	
	// index 위치의 값을 삭제하는 메서드
	public E remove(int index) {
		if (index > size - 1 || index < 0) throw new ArrayIndexOutOfBoundsException();
		if (index == 0) removeFirse();
		if (index == size - 1) removeLast();
		
		Node<E> selectNode = search(index);
		Node<E> prevNode = search(index - 1);
		
		prevNode.nextNode = selectNode.nextNode;
		this.size--;
		return selectNode.data;
	}
	
	// value와 일치하는 element를 삭제하는 메서드 (중복이 있는 경우 맨 앞을 삭제)
	public boolean remove(Object value) {
		if (this.headNode == null) return false;
		
		Node<E> prevNode = null;
		Node<E> node = this.headNode;
		while (true) {
			if (Objects.equals(node.data, value)) {
				if (node == this.headNode) {
					removeFirse();
					return true;
				}
				
				if (node == this.tailNode) {
					removeLast();
					return true;
				}
				
				prevNode.nextNode = node.nextNode;
				this.size--;
				return true;
			}
			
			if (node == this.tailNode) return false;
			
			prevNode = node;
			node = node.nextNode;
		}
	}
	
	// index 위치의 element 값을 가져오는 메서드
	public E get(int index) {
		if (index > size - 1) throw new ArrayIndexOutOfBoundsException();
		
		Node<E> node = search(index);
		return node.data;
	}
	
	// index 위치의 element 값을 value로 교체하는 메서드
	public void set(int index, E value) {
		if (index > size - 1) throw new ArrayIndexOutOfBoundsException();
		
		Node<E> node = search(index);
		node.data = value;
	}
	
	// 리스트 내의 모든 값을 출력하는 메서드
	@Override
	public String toString() {
		if (this.headNode == null) return null;
		
		Object[] result = new Object[this.size];
		Node<E> node = this.headNode;
		
		for (int i = 0; i < result.length; i++) {
			result[i] = node.data;
			node = node.nextNode;
		}
		
		return Arrays.toString(result);
	}
}
