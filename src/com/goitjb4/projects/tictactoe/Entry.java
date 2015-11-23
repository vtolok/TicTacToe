package com.goitjb4.projects.tictactoe;

/**
 * THIS IS AN ENTRY CLASS
 */

import java.util.Scanner;

public class Entry {
	
	public static void main(String[] args) {
		
		System.out.println("A tic-tac-toe game!\n");// WELCOME
		
		PlayerManager.selectPlayers();
		
		Game.zeroBoard();
		
		Game.firstMoveChoice ();
		
		do {
			PlayerManager.tellPlayer();
			
			Game.makeMove(PlayerManager.selectorHumanOrAI(Game.getBoard(), Game.getPlayerID()),Game.getPlayerID());
		}while (Game.getVictoryFlag()==false);// VICTORY CONDITION CHECK
			
		System.out.println("Thanks for the game!");//GOODBYE
		}
	}
