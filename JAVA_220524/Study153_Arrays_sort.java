package study0524;

import java.util.*;

public class Study153_Arrays_sort {

	public static void main(String[] args) {
		
		int[] su = {5,7,1,2,8,10,3};
		
		Arrays.sort(su);
		
		for(int i : su)
		{
			System.out.println("["+i+"]");
		}
		
		String arr[] = {"apple", "melon", "peach", "banana", "orange"};
	    Arrays.sort(arr);

	    for(String i : arr) 
	    {
	      System.out.println("[" + i + "]");
	    }
		
	}

}
