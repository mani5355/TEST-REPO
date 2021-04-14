package com.mani;

import java.util.*;

class solution {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int days = sc.nextInt();
		List<List<SubjectInfo>> parent = new ArrayList<>();

		for (int n = 0; n < days; n++) {
			int slot = sc.nextInt();
			List<SubjectInfo> child = new ArrayList<>();
			for (int m = 0; m < slot; m++) {
				String name = sc.next();
				String startTime = sc.next();
				String endTime = sc.next();
				SubjectInfo subjectInfo = new SubjectInfo(name, startTime, endTime);
				child.add(subjectInfo);
			}
			Collections.sort(child);
			System.out.print(child);
			parent.add(child);
		}

		for (List<SubjectInfo> list : parent) {
			int count = 0;
			int res = 0;
			String end = null;
			for (SubjectInfo subjectInfo : list) {
				if (count == 0) {
					count++;
					res++;
					end = subjectInfo.getEndTime();

				} else {
					if (subjectInfo.getStartTime().compareTo(end) >= 0) {
						end = subjectInfo.getEndTime();
						res++;
					}
				}
			}
			System.out.println(res);
		}
		// int a = sc.nextInt();
		// int b = sc.nextInt();
		// System.out.println(a + b);
	}

}

class SubjectInfo implements Comparable<SubjectInfo> {

	private String name;
	private String startTime;
	private String endTime;

	public SubjectInfo(String name, String startTime, String endTime) {
		this.name = name;
		this.startTime = startTime;
		this.endTime = endTime;
	}

	public String getName() {
		return this.name;
	}

	public String getStartTime() {
		return this.startTime;
	}

	public String getEndTime() {
		return this.endTime;
	}

	public String toString() {
		return name + " " + startTime + " " + endTime;
	}

	@Override
	public int compareTo(SubjectInfo o) {
			return this.endTime.compareTo(o.endTime);
		}

}