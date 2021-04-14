package com.mani;

public class ABC {

	public static final void main(String[] str) {

		int[] a = { 2, 5, 7, 10, 9, 4, 6, 8 };
		stack(a);
		merge(a, 0, a.length);

		//int[] b = mergeSort(a);

		for (int i = 1; i <= 10; i++) {
			boolean check = false;
			for (int num : a) {
				if (i == num) {
					check = true;
				}
			}
			if (!check) {
				System.out.println(i);
			}
		}

	}
	static Node head = null;

	private static void stack(int[] a) {

 
		node(int i){
			 if(head ==null) {
				 Node node = new Node(1);
				 head = node;
			 }
		}
	
	}
	
	private static int[] mergeSort(int[] a) {

		merge(a, 0, a.length);

		return null;
	}

	private static void merge(int[] a, int start, int end) {

		if (start < end) {
			int mid = (start + end)/2;
			
			merge(a,start, mid);
			merge(a, mid+1,end);
			operate(a,start,mid,end);
		}

	}

	private static void operate(int[] a, int start, int mid, int end) {

		int[] a1= new int[mid-start+2];
		int[] a2= new int[end-mid+1];
		
		for(int i=0; i<mid-start+1;i++) {
			a1[i]=a[i];
		}
		for(int i=0; i<end-mid;i++) {
			a2[i]=a[mid];
			mid++;
		}
		int a1length=0;
		int a2length=0;
		for(int i=start; i<end;i++) {
			if(a1[a1length]<a2[a2length]) {
				a[i]=a1[a1length];
				a1length++;
			}else {
				a[i]=a2[a2length];
				a2length++;
			}
		}
		

		
	}
	
	class Node{
		int value;
		Node next;
		
		Node(){
			
		}
		Node(int i){
			this.value=i;
			this.next=null;
		}
		
	}
}
