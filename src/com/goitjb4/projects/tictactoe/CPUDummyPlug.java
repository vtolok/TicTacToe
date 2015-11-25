package com.goitjb4.projects.tictactoe;

/**
 * THIS CLASS SIMULATES AN AI (like a DUMMY PLUG for Unit 00)
 * 
 * DELETE AFTER PROPPER AI'S ARE ADDED
 */

import java.util.Scanner;

public class CPUDummyPlug {
	
	public static int IAmCPU(int [] board, int PlayerID){//this is a dummy to emulate a CPU
		int move;
		do{Scanner key = new Scanner (System.in);
		
			System.out.println("IMAGINE YOU ARE AN AI MAKING A MOVE:\n"
				+"1-2-3\n4-5-6\n7-8-9");
		move = key.nextInt()-1;
		}while((move<0)&&(move>8));
		return move;// the CALLING method will convert from 1-9 t 0-8 int this later
		}
}
