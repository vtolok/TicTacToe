package com.goitjb4.projects.tictactoe;

/**
 * THIS IS AN ENTRY CLASS
 */

import java.util.Scanner;

public class Entry {
	
	@SuppressWarnings("static-access")
	public static void mainOLD(String[] args) {
		
		//===============AIRoman Calling Example====================
		//@SuppressWarnings("static-access")
		int[] board = { 0, 0, 0, 0, 0, 0, 0, 0, 0 };
		AbstractAI t = new AIRoman();

		int counter = 0;

		while (counter <= 9) {
			++counter;
			int player = 1;
			if (counter % 2 == 0) {
				player = -1;
			}
			((AIRoman) t).NextMove(player, board, t);
		}
		//System.exit(0);
		//===============AIRoman Calling Example====================

		/*System.out.println("A tic-tac-toe game!\n");// WELCOME
		
		PlayerManager.selectPlayers();
		
		Game.zeroBoard();
		
		Game.firstMoveChoice ();
		
		do {
			PlayerManager.tellPlayer();
			
			Game.makeMove(PlayerManager.selectHumanOrAI(Game.getBoard(), Game.getPlayerID()),Game.getPlayerID());
		}while (Game.getVictoryFlag()==false);// VICTORY CONDITION CHECK
			
<<<<<<< HEAD
		System.out.println("Thanks for the game!");//GOODBYE
		}
=======
		System.out.println("\nThanks for the game!");//GOODBYE
*/		}
//>>>>>>> 6b25df660e4fc1613f0415ec72e700cab5bd0407
	}
