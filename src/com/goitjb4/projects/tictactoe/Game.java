package com.goitjb4.projects.tictactoe;

/**
 * THIS CLASS MANAGES THE BOARD AND ALL MOVES ON IT
 */

import java.util.Scanner;

public class Game {
	
	private static int [] masterBoard = new int [Constants.BOARD_SIZE];
	public static int [] getBoard(){
		return masterBoard;
	}
	
	private static boolean endFlag=false;
	
	public static boolean getEndFlag (){
		return endFlag;
	}
	public static  void setEndFlag (boolean Flag){
		endFlag=Flag;
	}
	
			private static int playerID=0;// we use this in to pass info to other methods about which player is in current context
				
				public static void setPlayerID (int playerID){
					Game.playerID=playerID;
				}
				public static int getPlayerID (){
					return playerID;
				}
	
	public static void zeroBoard(){// set board to all-0
			for (int i=0;i<Constants.BOARD_SIZE;i++)
				masterBoard[i]=0;
	}
	
	public static void firstMoveChoice (){// set 1st player to make a move
		int temp;
		Scanner choice = new Scanner (System.in);
		do {
			System.out.printf("Choose a player to move first:\n(1) - Player %c, (2) - Player %c: ",Constants.PLAYER_1_CHAR,Constants.PLAYER_2_CHAR);
			temp = choice.nextInt();
			if (temp==1)
				playerID=Constants.PLAYER_1_INT;
			else
				playerID=Constants.PLAYER_2_INT;
		} while ((temp!=1)&&(temp!=2));
		System.out.print("\n");
	}

	//***************************************************************************************************************************************
	
	public static void makeMove(int move, int playerID){ //receives a move and puts it on a board
		
		if (checkIllegalMove(move)){//ILLEGAL MOVE, RETRY 
			System.out.print("Oops! That move is illegal! Try again:!");
			return;
		}
		
		masterBoard[move]=playerID;// ASSUMES  "MOVE int" is in 0-8 range
		
		DisplayBoard.draw();
		
		if (checkVictory(playerID)){
			String name="";
			if (Game.getPlayerID()==Constants.PLAYER_1_INT)
				name=PlayerManager.Player1Name;
			else
				name=PlayerManager.Player2Name;
			System.out.printf("Victory for %s! Congratulations!", name);
			endFlag=true;//	VICTORY, FINISH PROGRAM
			return;
		}
		
		if(checkFullBoard(move)){
			System.out.println("Its a DRAW. GG.");
			endFlag=true;//	DRAW, FINISH PROGRAM
			return;
		}
		switchPlayer();
	}
	
	///////////////////////////////////////utility methods - for makeMove:
	private static void switchPlayer(){// SWiTCH TO NEXT PLAYER
		System.out.println("The end of turn!\n***");
		if (playerID==Constants.PLAYER_1_INT){
			playerID=Constants.PLAYER_2_INT;
		}else
			if(playerID==Constants.PLAYER_2_INT){
				playerID=Constants.PLAYER_1_INT;
			}
			else
				System.out.println("Fuck! The system should've switched player - but failed to do do miserably!");
	}
	
	private static boolean checkIllegalMove(int move){//for checking if the move was legal
		if ((move<0)&&(move>8))
			return true;
		if (masterBoard[move]==0)// ASSUMES  "MOVE int" is in 0-8 range
			return false;
		return true;
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
	private static boolean checkFullBoard (int move){//for checking if board is FULL
		for (int i=0;i<Constants.BOARD_SIZE;i++)// ASSUMES  "MOVE int" is in 0-8 range
			if (masterBoard[i]==0){
				return false;
			}
		return true;
		}
}
	
	

