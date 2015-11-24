package com.goitjb4.projects.tictactoe;

/**
 * THIS CLASS DISPALYES THE CURRENT BOARD STATUS
 * 
 */

import java.util.Arrays;

public class DisplayBoard {
	
	private static char [] charBoard = new char [Game.BOARDSIZE];
			
	private static void getAndConverBoard (){// method for converting int [] board to char [] with X and O
		System.out.println("CHK Master Board: "+Arrays.toString(Game.getBoard()));// CHM Master Board before making CharBoard - DELETE AFTER CHECK OK!
		for (int i=0;i<Game.getBoard().length;i++){
			if (Game.getBoard()[i]==PlayerManager.PLAYER1INT)
				charBoard[i]=PlayerManager.PLAYER1CHAR;
			else {if (Game.getBoard()[i]==PlayerManager.PLAYER2INT)
					charBoard[i]=PlayerManager.PLAYER2CHAR;
				else
					charBoard[i]=' ';
			}
		}
	}

	public static void draw (){// DiSPLAYS THE BOARD IN CONSOLE
		getAndConverBoard();
		System.out.println(" ----------- ");
		for (int i=0;i<Game.BOARDSIZE;i+=3){
		System.out.printf ("| %c | %c | %c |\n",charBoard[i],charBoard[i+1],charBoard[i+2]);
		if (i<6)
			System.out.println("----+---+----");
		}
		System.out.println(" ----------- ");
	}
}
