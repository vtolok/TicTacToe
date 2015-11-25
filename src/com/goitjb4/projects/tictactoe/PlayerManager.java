package com.goitjb4.projects.tictactoe;

/**
 * THIS CLASS SELECT PLAYER ACCORDING TO GAME'S TURNS
 */

import java.util.Scanner;

public class PlayerManager {
	
	public static final String PLAYER1="Player 1";
	public static final int PLAYER1INT=1;
	public static final char PLAYER1CHAR='X';
	public static String Player1Name = "";
	private static boolean Player1IsAI;
	
	public final String PLAYER2="Player 2";
	public static final int PLAYER2INT=-1;
	public static final char PLAYER2CHAR='O';
	public  static String Player2Name = "";
	private static boolean Player2IsAI;
	
	static int ctrl;
	static Scanner key=new Scanner (System.in);
	
	public static void selectPlayers(){// SELECTING HUMAN OR CPU PLAYERS 									
		do{
			Game.setPlayerID (PLAYER1INT);// PLAYER 1
			System.out.printf("Select player %c:\n(1) - Human, (2) - CPU:  ", PLAYER1CHAR);
			ctrl=key.nextInt();
			}while((ctrl!=1)&&(ctrl!=2));
			
		if (ctrl==1){
			HumanPlayer.setPlayer(Game.getPlayerID());
			Player1IsAI=false;
		}else{
			PlayerManager.setAI(Game.getPlayerID());
			Player1IsAI=true;
		}
			
		do{
			Game.setPlayerID (PLAYER2INT);// PLAYER 2
			System.out.printf("Select player %c:\n(1) - Human, (2) - CPU: ",PLAYER2CHAR);
			ctrl=key.nextInt();
		}while((ctrl!=1)&&(ctrl!=2));
			
		if (ctrl==1){
			HumanPlayer.setPlayer(Game.getPlayerID());
			Player2IsAI=false;
		}else{
			PlayerManager.setAI(Game.getPlayerID());
			Player2IsAI=true;
		}
		
		ctrl=0;//RESET ctrl
		}
	
	public static void setAI(int playerID){// SELECTING THE AI AS A CPU PLAYER
		do{
			System.out.print("Setting CPU Player ");
			if (playerID==PLAYER1INT)
				System.out.printf("%c: ",PLAYER1CHAR);
			else
				System.out.printf("%c: ",PLAYER2CHAR);
			
			System.out.print("select the AI:\n(1) - ROMAN, (2) - ANTON, (3) - CONSTANTIN, (0) - NO CPU, return: ");
			String AIName="nobody";
			
			ctrl=key.nextInt();
			if (ctrl==1)
				AIName="ROMAN'S AI";
			if (ctrl==2)
				AIName="ANTON'S AI";
//<<<<<<< HEAD
			if (ctrl==3)
//=======
			if (ctrl==3) //WAS FIXED BY ANTON
//>>>>>>> 0d9500f01cd15dacad6f29ddd570bd854919b265
				AIName="CONSTANTIN'S AI";

			if (playerID==PLAYER1INT){
				PlayerManager.Player1Name=AIName;
				System.out.println(AIName+" - is playing \""+PlayerManager.PLAYER1CHAR+"\"\n");
			}else{
				PlayerManager.Player2Name=AIName;
				System.out.println(AIName+" - is playing \""+PlayerManager.PLAYER2CHAR+"\"\n");
			}
			if (ctrl==0)
				selectPlayers();
			
		}while((ctrl!=1)&&(ctrl!=2)&&(ctrl!=3)&&(ctrl!=0));
		ctrl=0;//RESET ctrl
	}
	
	
	public static void tellPlayer(){// SHOWS WHICH PLAYE'S MOVE IS BEinG MADE
	if (Game.getPlayerID()==PlayerManager.PLAYER1INT)
		System.out.printf("It is now "+PlayerManager.Player1Name+" (Player %c)'s turn:\n",PLAYER1CHAR);
	else{
		if (Game.getPlayerID()==PlayerManager.PLAYER2INT) 
		System.out.printf("It is now "+PlayerManager.Player2Name+" (Player %c)'s turn:\n",PLAYER2CHAR);
		else
			System.out.println("Fuck... system is confused! Whose turn was that, again?");
		}
	}
	
	public static int selectHumanOrAI (int [] board, int playerID){// SELECT BETWEEN HUMAN AND AI CALSS to ADRESS the next MOVE
		int move=0;
		if (playerID==PLAYER1INT){
			if (Player1IsAI==false)
				move=HumanPlayer.IAmHuman(board, Game.getPlayerID());
			else
				switch (Player1Name){
					case "ROMAN'S AI":
						move=CPUDummyPlug.IAmCPU(board, Game.getPlayerID());// *************REPLACE WITH ROMA'S AI CALLING METHOD!!!
						break;
					case "ANTON'S AI":
//<<<<<<< HEAD
						move=CPUDummyPlug.IAmCPU(board, Game.getPlayerID());// *************REPLACE WITH ANTON'S AI CALLING METHOD!!!!
//=======
						move=new AnteBot(board, playerID).smartMove();// It's Alive!!! ALIVE!!!!!!!!!
//>>>>>>> 0d9500f01cd15dacad6f29ddd570bd854919b265
						break;
					case "CONSTANTIN'S AI":
						move=CPUDummyPlug.IAmCPU(board, Game.getPlayerID());// *************REPLACE WITH CONSTATIN'S AI CALLING METHOD!!!!
						break;	
				};
		}else{
			if (Player1IsAI==false)
				move=HumanPlayer.IAmHuman(board, Game.getPlayerID());
			else
				switch (Player1Name){
					case "ROMAN'S AI":
						move=CPUDummyPlug.IAmCPU(board, Game.getPlayerID());// *************REPLACE WITH ROMA'S AI CALLING METHOD!!!!
						break;
					case "ANTON'S AI":
//<<<<<<< HEAD
						move=CPUDummyPlug.IAmCPU(board, Game.getPlayerID());// *************REPLACE WITH ANTON'S AI CALLING METHOD!!!!
//=======
						move=new AnteBot(board, playerID).smartMove();// It's Alive!!! ALIVE!!!!!!!!
//>>>>>>> 0d9500f01cd15dacad6f29ddd570bd854919b265
						break;
					case "CONSTANTIN'S AI":
						move=CPUDummyPlug.IAmCPU(board, Game.getPlayerID());// *************REPLACE WITH CONSTATIN'S AI CALLING METHOD!!!!
						break;	
				};
		}
		return move;
	}
}
