package com.goitjb4.projects.tictactoe;

/**
 * THIS CLASS MANAGES THE BOARD AND ALL MOVES ON IT
 */

import java.util.Scanner;

public class Game {
	
	
	public static final int BOARDSIZE=9;
	private static int [] masterBoard = new int [BOARDSIZE];
	public static int [] getBoard(){
		return masterBoard;
	}
	
	private static boolean victoryFlag=false;
	public static boolean getVictoryFlag (){
		return victoryFlag;
	}
	
			private static int playerID=0;// we use this in to pass info to other methods about which player is in current context
				
				public static void setPlayerID (int playerID){
					Game.playerID=playerID;
				}
				
				public static int getPlayerID (){
					return playerID;
				}
	
	public static void zeroBoard(){// set board to all-0
			for (int i=0;i<BOARDSIZE;i++)
				masterBoard[i]=0;
	}
	
	public static void firstMoveChoice (){// set 1st player to make a move
		int temp;
		Scanner choice = new Scanner (System.in);
		do {
			System.out.printf("Choose a player to move first:\n(1) - Player %c, (2) - Player %c: ",PlayerManager.PLAYER1CHAR,PlayerManager.PLAYER2CHAR);
			temp = choice.nextInt();
			if (temp==1)
				playerID=PlayerManager.PLAYER1INT;
			else
				playerID=PlayerManager.PLAYER2INT;
		} while ((temp!=1)&&(temp!=2));
	}

	//***************************************************************************************************************************************
	
	public static void makeMove(int move, int playerID){ //receives a move and puts it on a board
		
		if (checkLegalMove(move)){//ILLEGAL MOVE, RETRY 
			System.out.print("Oops! That move is illegal! Try again:!");
			return;
		}
		
		masterBoard[move]=playerID;// ASSUMES  "MOVE int" is in 0-8 range
		
		DisplayBoard.draw();
		
		if (checkVictory(playerID)){
			System.out.println("Victory!!! Congratulations!");
			victoryFlag=true;//	VICTORY, FINISH PROGRAM
			return;
		}
		
		switchPlayer();
	}
	
	///////////////////////////////////////utility methods - for makeMove:
	
	private static void switchPlayer(){// SWiTCH TO NEXT PLAYER
		System.out.println("The end of turn!\n***");
		if (playerID==PlayerManager.PLAYER1INT){
			playerID=PlayerManager.PLAYER2INT;
		}else
			if(playerID==PlayerManager.PLAYER2INT){
				playerID=PlayerManager.PLAYER1INT;
			}
			else
				System.out.println("Fuck! The sistem should've switched player - but failed to do do miserably!");
	}
	
	private static boolean checkLegalMove(int move){//for checking if the move was legal
		boolean illegal=true;
		if (masterBoard[move]==0)// ASSUMES  "MOVE int" is in 0-8 range
			illegal=false;
		return illegal;
		}
	
	private static boolean checkVictory (int playerID){// for checking if a victory has been achieved
		boolean victory=false;
		for (int i=0;i<8;i+=3)
			if((masterBoard[i]==masterBoard[i+1])&&(masterBoard[i+1]==masterBoard[i+2])&&(masterBoard[i+2]==playerID))
				victory=true;
		for (int i=0;i<3;i++)
			if((masterBoard[i]==masterBoard[i+3])&&(masterBoard[i+3]==masterBoard[i+6])&&(masterBoard[i+6]==playerID))
				victory=true;
		for (int i=0;i<1;i++)
			if((masterBoard[i]==masterBoard[i+4])&&(masterBoard[i+4]==masterBoard[i+8])&&(masterBoard[i+8]==playerID))
				victory=true;
		for (int i=2;i<3;i++)
			if((masterBoard[i]==masterBoard[i+2])&&(masterBoard[i+2]==masterBoard[i+4])&&(masterBoard[i+4]==playerID))
				victory=true;
		return victory;
	}
}
	
	

