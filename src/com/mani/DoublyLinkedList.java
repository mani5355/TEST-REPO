package com.mani;

public class DoublyLinkedList {
	static Node head = null;

	public static void main(String[] args) {

		int[] list = { 1, 2, 3, 4, 5, 6, 7, 8, 9 };
		create(list);

		System.out.print("before...");
		print();
		insert(3, 10);
		System.out.print("after insertion...");
		print();
		delete(3);
		System.out.print("after deletion...");
		print();

	}

	private static void print() {
		Node ll = head;
		while (ll != null) {
			System.out.print(ll.val + " ");
			ll = ll.next;
		}
		System.out.println();

	}

	private static void insert(int position, int val) {

		Node ll = head;
		int count = 0;
		while (count < position - 1) {
			ll = ll.next;
			count++;
		}
		Node temp = ll.next;
		Node newNode = new Node(val);
		ll.next = newNode;
		newNode.next = temp;
		newNode.previous=ll;
		// 1,2,3.,4,5
	}

	private static void delete(int position) {

		Node ll = head;
		int count = 0;
		while (count < position - 1) {
			ll = ll.next;
			count++;
		}
		// LL temp=ll.next;
		// LL newNode= new LL(val);
		ll.next = ll.next.next;
		ll.next.previous=ll;
		// newNode.next=temp;
		// 1,2,3.,4,5
	}

	private static void create(int[] list) {

		createList(list, 0);

	}

	private static void createList(int[] list, int i) {

		if (i == list.length) {
			return;
		}
		if (i == 0) {
			head = new Node(list[i]);
			head.next = null;
			head.previous = null;

		} else {

			Node ll = head;
			while (ll.next != null) {
				ll = ll.next;
			}
			ll.next = new Node(list[i]);
			ll.next.previous=ll;
		}
		createList(list, ++i);
	}

}

class Node {
	int val;
	Node next;
	Node previous;

	Node(int val) {
		this.val = val;
	}
}