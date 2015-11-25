package com.goitjb4.projects.tictactoe;

/**
 * THIS CLASS DISPALYES THE CURRENT BOARD STATUS
 * 
 */

import java.util.Arrays;

public class DisplayBoard {
	
	private static char [] charBoard = new char [Constants.BOARD_SIZE];
			
	private static void getAndConverBoard (){// method for converting int [] board to char [] with X and O
		System.out.println("CHK Master Board: "+Arrays.toString(Game.getBoard()));// CHM Master Board before making CharBoard - DELETE AFTER CHECK OK!
		for (int i=0;i<Game.getBoard().length;i++){
			if (Game.getBoard()[i]==Constants.PLAYER_1_INT)
				charBoard[i]=Constants.PLAYER_1_CHAR;
			else {if (Game.getBoard()[i]==Constants.PLAYER_2_INT)
					charBoard[i]=Constants.PLAYER_2_CHAR;
				else
					charBoard[i]=' ';
			}
		}
	}

	public static void draw (){// DiSPLAYS THE BOARD IN CONSOLE
		getAndConverBoard();
		System.out.println(" ----------- ");
		for (int i=0;i<Constants.BOARD_SIZE;i+=3){
		System.out.printf ("| %c | %c | %c |\n",charBoard[i],charBoard[i+1],charBoard[i+2]);
		if (i<6)
			System.out.println("----+---+----");
		}
		System.out.println(" ----------- ");
	}
}
