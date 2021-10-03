package com.cg.main;

import java.util.HashMap;
import java.util.Random;

public class Board {
	
	public HashMap<Integer, Integer> setBoard(int ns, int ls, int[][] snakes, int[][] ladders) {
		HashMap<Integer, Integer>hm= new HashMap<>();
		for(int i=0; i<snakes.length; i++)
			hm.put(snakes[i][0], snakes[i][1]);
		for(int i=0; i<ladders.length; i++)
			hm.put(ladders[i][0], ladders[i][0]);
		return hm;
	}
	
	// returns random no from 1-6
	public int getN() {
		Random r= new Random();
		return 1+r.nextInt(6);
	}
	
	// return winner
	public int play(int bs, HashMap<Integer, Integer>hm, int[] users, String[] userName) {
		
		Board b= new Board();
		boolean flag= false;
		int i=0;
		while(flag == false) {
			for(i=0; i<users.length; i++) {
				int prevPos= users[i];
				int n= b.getN();
				users[i]= users[i]+n;
				if(users[i]>bs)
					users[i]= prevPos;
				if(hm.containsKey(users[i]))
					users[i]= hm.get(users[i]);
				System.out.println(userName[i]+" rolled a "+n+" and moved from "+prevPos+" to "+users[i]);
				if(users[i] == bs)
					return i;
			}
		}
		
		return 0;
	}
}
