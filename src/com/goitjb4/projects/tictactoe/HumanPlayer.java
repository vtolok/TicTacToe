package com.goitjb4.projects.tictactoe;

/**
 * THIS CLASS IS FOR JUMAN PLAYER INPUT
 * 
 */

import java.util.Scanner;

public class HumanPlayer {
	
	public static void setPlayer (int playerID){// SETS playr's names + designates his/her figures
		System.out.print("Please set Player ");
		if (playerID==1)
			System.out.printf("%c NAME: ",PlayerManager.PLAYER1CHAR);
		else
			System.out.printf("%c NAME: ",PlayerManager.PLAYER2CHAR);
		Scanner kb = new Scanner (System.in);
		
		if (playerID==1){
			PlayerManager.Player1Name=kb.next();
			System.out.println(PlayerManager.Player1Name+" - is playing \""+PlayerManager.PLAYER1CHAR+"\"\n");
		}else{
			PlayerManager.Player2Name=kb.next();
			System.out.println(PlayerManager.Player2Name+" - is playing \""+PlayerManager.PLAYER2CHAR+"\"\n");
		}
	}
	
	public static int IAmHuman(int [] board, int PlayerID){ 
		int move;
		Scanner key = new Scanner (System.in);
		do{
			System.out.println("Select a cell to make your next move by pressing respective number:\n"
				+"1-2-3\n4-5-6\n7-8-9");
		move = key.nextInt()-1;
		}while((move<0)&&(move>8));
		return move;// the CALLING method will convert from 1-9 t 0-8 int this later
		}
	
	}
