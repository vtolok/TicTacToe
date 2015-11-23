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
			Game.setPlayerID (1);// PLAYER 1
			System.out.println("Select player 1:\n(1) - Human, (2) - CPU");
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
			Game.setPlayerID (-1);// PLAYER 2
			System.out.println("Select player 2:\n(1) - Human, (2) - CPU");
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
			System.out.print("Please set Player ");
			if (playerID==1)
				System.out.println("1 NAME: ");
			else
				System.out.println("2 NAME: ");
			
			System.out.println("Select the AI for this CPU player:\n(1) - ROMAN, (2) - ANTON, (3) - CONSTANTIN, (0) - NO CPU, return");
			String AIName="noname";
			
			ctrl=key.nextInt();
			if (ctrl==1)
				AIName="ROMAN'S AI";
			if (ctrl==2)
				AIName="ANTON'S AI";
			if (ctrl==2)
				AIName="CONSTANTIN'S AI";

			if (playerID==1){
				PlayerManager.Player1Name=AIName;
				System.out.println(AIName+" - is playing \""+PlayerManager.PLAYER1CHAR+"\"\n");
			}else{
				PlayerManager.Player2Name=AIName;
				System.out.println(AIName+" - is playing \""+PlayerManager.PLAYER2CHAR+"\"\n");
			}
			if (ctrl==0)
				selectPlayers();// Рекурсия для выбора игрока заново - РАБОТАЕТ ЛИ?
			
		}while((ctrl!=1)&&(ctrl!=2)&&(ctrl!=3)&&(ctrl!=0));
		ctrl=0;//RESET ctrl
	}
	
	
	public static void tellPlayer(){// SHOWS WHICH PLAYE'S MOVE IS BEinG MADE
	if (Game.getPlayerID()==PlayerManager.PLAYER1INT)
		System.out.println("It is now "+PlayerManager.Player1Name+" (Player 1)'s turn");
	else{
		if (Game.getPlayerID()==PlayerManager.PLAYER2INT) 
		System.out.println("It is now "+PlayerManager.Player2Name+" (Player 2)'s turn");
		else
			System.out.println("Fuck... system is confused! Whose turn was that, again?");
		}
	}
	
	public static int selectorHumanOrAI (int [] board, int playerID){// SELECST BETWEE HUMAN AND AI CALSS to ADRESS the next MOVE
		int move=0;
		if (playerID==PLAYER1INT){
			if (Player1IsAI==false)
				move=HumanPlayer.IAmHuman(board);
			else
				switch (Player1Name){
					case "ROMAN'S AI":
						move=CPUDummyPlug.IAmCPU(board);// *************REPLACE WITH ROMA'S AI CALLING METHOD!!!
						break;
					case "ANTON'S AI":
						move=CPUDummyPlug.IAmCPU(board);// *************REPLACE WITH ANTON'S AI CALLING METHOD!!!!
						break;
					case "CONSTANTIN'S AI":
						move=CPUDummyPlug.IAmCPU(board);// *************REPLACE WITH CONSTATIN'S AI CALLING METHOD!!!!
						break;	
				};
		}else{
			if (Player1IsAI==false)
				move=HumanPlayer.IAmHuman(board);
			else
				switch (Player1Name){
					case "ROMAN'S AI":
						move=CPUDummyPlug.IAmCPU(board);// *************REPLACE WITH ROMA'S AI CALLING METHOD!!!!
						break;
					case "ANTON'S AI":
						move=CPUDummyPlug.IAmCPU(board);// *************REPLACE WITH ANTON'S AI CALLING METHOD!!!!
						break;
					case "CONSTANTIN'S AI":
						move=CPUDummyPlug.IAmCPU(board);// *************REPLACE WITH CONSTATIN'S AI CALLING METHOD!!!!
						break;	
				};
		}
		return move;
	}
}
