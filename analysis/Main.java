// Java program to demonstrate working of Comparator
// interface and Collections.sort() to sort according
// to user defined criteria.
// https://www.geeksforgeeks.org/collections-sort-java-examples/

import java.util.*;
import java.lang.*;
import java.io.*;

// A class to represent a student.
class Data {
	int first;
  double second;
//	String name, address;

	// Constructor
	public Data(int first, double second) {
		this.first = first;
		this.second = second;
	}

	// Used to print student details in main()
	public String toString() {
		return this.first + " " + this.second;
	}
}

class SortData implements Comparator<Data> {
	// Used for sorting in ascending order of
	// roll number
	public int compare(Data a, Data b) {
		return a.first - b.first;
	}
}

// Driver class
class Main {
	public static void main (String[] args)
	{
		ArrayList<Data> ar = new ArrayList<Data>();
		ar.add(new Data(111, 24.1));
		ar.add(new Data(131, 16.37));
		ar.add(new Data(121, 19.24));
		ar.add(new Data(111, 11.01));

		System.out.println("Unsorted");
		for (int i=0; i<ar.size(); i++)
			System.out.println(ar.get(i));

		Collections.sort(ar, new SortData());

		System.out.println("\nSorted by first");
		for (int i=0; i<ar.size(); i++)
			System.out.println(ar.get(i));
	}
}

