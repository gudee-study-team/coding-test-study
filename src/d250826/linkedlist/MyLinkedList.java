package d250826.linkedlist;

public class MyLinkedList<E> {
	private Node<E> headNode;
	private Node<E> tailNode;
	private int size;
	private int pointer;

	private static class Node<E> {
		private E data;
		private Node<E> nextNode;
		
		Node(E data) {
			this.data = data;
		}
	}
	
	public MyLinkedList() {
		this.headNode = null;
		this.tailNode = null;
		this.size = 0;
		this.pointer = 0;
	}
	
	public void add(int index, Object element) {
		// index에 element 삽입
	}
	
	public void addFirst(Object element) {
		// 맨 앞에 element 삽입
	}
	
	public void addLast(Object element) {
		// 맨 뒤에 element 삽입
	}
	
	public boolean add (Object element) {
		// element 단순 삽입
		return false;
	}
}
