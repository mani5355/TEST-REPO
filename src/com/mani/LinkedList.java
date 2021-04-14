package com.mani;

public class LinkedList {
	static LL head = null;

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
		LL ll = head;
		while (ll != null) {
			System.out.print(ll.val + " ");
			ll = ll.next;
		}
		System.out.println();

	}

	private static void insert(int position, int val) {

		LL ll = head;
		int count = 0;
		while (count < position - 1) {
			ll = ll.next;
			count++;
		}
		LL temp = ll.next;
		LL newNode = new LL(val);
		ll.next = newNode;
		newNode.next = temp;
		// 1,2,3.,4,5
	}

	private static void delete(int position) {

		LL ll = head;
		int count = 0;
		while (count < position - 1) {
			ll = ll.next;
			count++;
		}
		// LL temp=ll.next;
		// LL newNode= new LL(val);
		ll.next = ll.next.next;
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
			head = new LL(list[i]);
			head.next = null;
		} else {

			LL ll = head;
			while (ll.next != null) {
				ll = ll.next;
			}
			ll.next = new LL(list[i]);
		}
		createList(list, ++i);
	}

}

class LL {
	int val;
	LL next;

	LL(int val) {
		this.val = val;
	}
}