package com.goitjb4.projects.tictactoe;

import java.util.Scanner;

/**
 * THIS IS AN ENTRY CLASS
 */


public class EntryPoint {
	
	static int play=0;
	private static Scanner key=new Scanner (System.in);
	
	public static void main (String args[] ){
 	System.out.println("A tic-tac-toe game!\n");// WELCOME
        
 		do{ 
 			Game.setEndFlag(false);
 			do{
 			System.out.print("Begin a new game? (1) - yes; (2) - no: ");
 			play = key.nextInt();
 			}while((play!=1)&&(play!=2));
 			if (play==2)
 				break;
 			Game.zeroBoard();
 			PlayerManager.selectPlayers();
	        Game.firstMoveChoice ();
	        do {
	            PlayerManager.tellPlayer();
	            Game.makeMove(PlayerManager.selectHumanOrAI(Game.getBoard().clone(), Game.getPlayerID()),Game.getPlayerID());// аег йкнмю дняйю онпрхряъ унднл юх
	        }while (Game.getEndFlag()==false);// ENDGAME CONDITION CHECK
 		}while(play==1);
        System.out.println("\nEnd of game. Thanks for playing!");//GOODBYE
	}
}

