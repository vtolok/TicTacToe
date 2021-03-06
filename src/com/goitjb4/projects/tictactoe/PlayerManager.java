package com.goitjb4.projects.tictactoe;

/**
 * THIS CLASS SELECT PLAYER ACCORDING TO GAME'S TURNS
 */

import java.util.Scanner;


public class PlayerManager {
	

	public static String Player1Name = "";
	private static boolean Player1IsAI;
	
	public  static String Player2Name = "";
	private static boolean Player2IsAI;
	
	private static int ctrl;
	private static int ctrlAI;
	private static Scanner key=new Scanner (System.in);
	
	public static void selectPlayers(){// SELECTING HUMAN OR CPU PLAYERS 		
		do{// SELECT 1 of 3 GAME TYPES
			System.out.print("Please set a game TYPE:\n(1) HUMAN Vs HUMAN, (2) HUMAN Vs CPU, (3) CPU Vs CPU: ");
			ctrl=key.nextInt();
			}while((ctrl!=1)&&(ctrl!=2)&&(ctrl!=3));
			
		switch (ctrl){
		case 1:{
			Game.setPlayerID (Constants.PLAYER_1_INT);
			HumanPlayer.setPlayer(Game.getPlayerID());
			Player1IsAI=false;
			Game.setPlayerID (Constants.PLAYER_2_INT);
			HumanPlayer.setPlayer(Game.getPlayerID());
			Player2IsAI=false;
			break;
			}
		case 2:{
			Game.setPlayerID (Constants.PLAYER_1_INT);
			HumanPlayer.setPlayer(Game.getPlayerID());
			Player1IsAI=false;
			Game.setPlayerID (Constants.PLAYER_2_INT);
			PlayerManager.setAI(Game.getPlayerID());
			Player2IsAI=true;
			break;
			}
		case 3:{
			Game.setPlayerID (Constants.PLAYER_1_INT);
			PlayerManager.setAI(Game.getPlayerID());
			Player1IsAI=true;
			Game.setPlayerID (Constants.PLAYER_2_INT);
			PlayerManager.setAI(Game.getPlayerID());
			Player2IsAI=true;
			break;
			}
//		defalut:
//			System.out.println("I cant believe you've got this message! The program must be fucked up! Hurry up and fix it!");
		}
		ctrl=0;//RESET ctrl
	}
	
	public static void setAI(int playerID){// SELECTING THE AI AS A CPU PLAYER
		do{
			System.out.print("Setting CPU Player ");
			if (playerID==Constants.PLAYER_1_INT)
				System.out.printf("%c: ",Constants.PLAYER_1_CHAR);
			else
				System.out.printf("%c: ",Constants.PLAYER_2_CHAR);
			
			System.out.print("select the AI:\n(1) - ROMAN, (2) - ANTON, (3) - CONSTANTIN: ");
			String AIName="nobody";
			
			ctrlAI=key.nextInt();
			if (ctrlAI==1)
				AIName="ROMAN'S AI";
			if (ctrlAI==2)
				AIName="ANTON'S AI";
			if (ctrlAI==3)
				AIName="CONSTANTIN'S AI";

			if (playerID==Constants.PLAYER_1_INT){
				PlayerManager.Player1Name=AIName;
				System.out.println(AIName+" - is playing \""+Constants.PLAYER_1_CHAR+"\"");
			}else{
				PlayerManager.Player2Name=AIName;
				System.out.println(AIName+" - is playing \""+Constants.PLAYER_2_CHAR+"\"");
			}
			if (ctrlAI==0)
				selectPlayers();
			
		}while((ctrlAI!=1)&&(ctrlAI!=2)&&(ctrlAI!=3));
		ctrl=0;//RESET ctrl
	}
	
	
	public static void tellPlayer(){// SHOWS WHICH PLAYE'S MOVE IS BEinG MADE
	if (Game.getPlayerID()==Constants.PLAYER_1_INT)
		System.out.printf("It is now "+PlayerManager.Player1Name+" (Player %c)'s turn:\n",Constants.PLAYER_1_CHAR);
	else{
		if (Game.getPlayerID()==Constants.PLAYER_2_INT) 
		System.out.printf("It is now "+PlayerManager.Player2Name+" (Player %c)'s turn:\n",Constants.PLAYER_2_CHAR);
		else
			System.out.println("Fuck... system is confused! Whose turn was that, again?");
		}
	}
	
	public static int selectHumanOrAI(int[] board, int playerID) {// SELECT BETWEEN HUMAN AND AI CALSS to ADRESS the next MOVE
		int move = 10;// if no move is RETURNED, the "out Of Bounds" Exception will appear
		if (((Game.getPlayerID() == Constants.PLAYER_1_INT) && (Player1IsAI == false)) 
				|| ((Game.getPlayerID() == Constants.PLAYER_2_INT) && (Player2IsAI == false))) {
			move = HumanPlayer.IAmHuman(board, Game.getPlayerID());
		} else {
			//String currentPlayerName = (Game.getPlayerID() == Constants.PLAYER_1_INT) ? Player1Name : Player2Name;   
			switch (ctrlAI) {
			case 1:
				AbstractAI t = new AIRoman();
				move = t.move(board, Game.getPlayerID());
				break;
			case 2:
				AbstractAI a = new AIAnton();
				move = a.move(board, Game.getPlayerID());
				break;
			case 3:
				AbstractAI kossAI = new AIKoss();
				move = kossAI.move(board, Game.getPlayerID());
				break;
			}
		}
		return move;
	}
}
