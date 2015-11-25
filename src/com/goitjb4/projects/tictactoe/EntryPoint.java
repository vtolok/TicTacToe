package com.goitjb4.projects.tictactoe;

/**
 * THIS IS AN ENTRY CLASS
 */


public class EntryPoint {
	
	public static void main (String args[] ){
 	System.out.println("A tic-tac-toe game!\n");// WELCOME
        
        PlayerManager.selectPlayers();
        
        Game.zeroBoard();
        
        Game.firstMoveChoice ();
        
        do {
            PlayerManager.tellPlayer();
            
            Game.makeMove(PlayerManager.selectHumanOrAI(Game.getBoard(), Game.getPlayerID()),Game.getPlayerID());
        }while (Game.getEndFlag()==false);// ENDGAME CONDITION CHECK
            
        System.out.println("\nThanks for the game!");//GOODBYE
	}
}

