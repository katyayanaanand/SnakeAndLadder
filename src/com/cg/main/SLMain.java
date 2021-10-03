package com.cg.main;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

public class SLMain {

	public static void main(String[] args) throws IOException {
		
		// get all the data and sends to the board class
		// 1, 2 , 3, 4 ....... , 100
		// 2->22
		// 7->30
		// 18->3
		BufferedReader in= new BufferedReader(new InputStreamReader(System.in));
		int ns= Integer.parseInt(in.readLine());
		int[][] snakes= new int[ns][2];
		for(int i=0; i<ns; i++) {
			String str= in.readLine();
			String[] s= str.split(" ");
			snakes[i][0]=Integer.parseInt(s[0]);
			snakes[i][1]=Integer.parseInt(s[1]);
		}
		int nl= Integer.parseInt(in.readLine());
		int[][] ladders= new int[ns][2];
		for(int i=0; i<nl; i++) {
			String str= in.readLine();
			String[] s= str.split(" ");
			ladders[i][0]=Integer.parseInt(s[0]);
			ladders[i][1]=Integer.parseInt(s[1]);
		}
		int nu= Integer.parseInt(in.readLine());
		Users u= new Users();
		String[] users= new String[nu];
		int[] usersPos= new int[nu];
		for(int i=0; i<nu; i++) {
			users[i]= in.readLine();
		}
		Board b= new Board();
		HashMap<Integer, Integer> hm= b.setBoard(ns, nl, snakes, ladders);
		usersPos= u.initPos(nu);
		int winIdx= b.play(100, hm, usersPos, users);
		System.out.println(users[winIdx]+" wins the game");
	}

}
