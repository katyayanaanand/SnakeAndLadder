package com.cg.main;

public class Users {
	// set initial position of users

	public int[] initPos(int n) {
		
		int[] arr= new int[n];
		for(int i=0; i<n; i++)
			arr[i]= 0;
		return arr;
	}
}
