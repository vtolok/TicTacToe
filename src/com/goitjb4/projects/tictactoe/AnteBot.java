package com.goitjb4.projects.tictactoe;

public class AnteBot {
	
	AnteBot(int inputboard[], int playerid){
		this.cell=translateInputInformation(inputboard, playerid);
	}
	
	private int cell[][];
	

	public int smartMove(){ //general method for creating a smart move
		
		String decision = firstTryNotToLose();
		if(decision.equals(Constants.NO_DANGER_CELLS)){
		int [] line=lineAnalysis();
		int[][] cellanalysis=cellAnalysis(line);
         decision = decision(cellanalysis);
		}
		
		int translateanswer = translateDecision(decision);
         return translateanswer;
	}
	
	private  int[] lineAnalysis(){ //calculate free cells in the lines
		
		int line[]=new int[Constants.LINES];
		
		for(int k=0; k<Constants.LINES; k++){
			for(int i=0; i<cell.length; i++){
				for(int j=0; j<cell.length; j++){
					
					
					if(cell[i][j]%10==0)	{
					if(k==i){
						line[k]++;
					}
					
					if(k-cell.length==j){
						line[k]++;
					}	
					if(j==i && k==Constants.LINES-2){
						line[Constants.LINES-2]++;
					}
					if(cell.length-j-1==i && k==Constants.LINES-1){
						line[Constants.LINES-1]++;
					}
					
			}
			}
		}
		}
		
	
		return line;
	}
	private  int[][] cellAnalysis(int line[]){//calculate win lines at all cells
		
		int goodCell[][]=new int[cell.length][cell.length];
		for(int i=0; i<cell.length; i++){
			for(int j=0; j<cell.length; j++){
				for(int k=0; k<line.length; k++){
					if(cell[i][j]==0){
						if(line[k]==Constants.NEEDS_POINTS_TO_WIN && (k==i||k-cell.length==j)){
							goodCell[i][j]++;}
						if(line[Constants.LINES-2]==Constants.NEEDS_POINTS_TO_WIN && i==j){
							goodCell[i][j]++;
							}
						if(line[Constants.LINES-1]==Constants.NEEDS_POINTS_TO_WIN && cell.length-j-1==i){
							goodCell[i][j]++;
							}
						
					}
				}
			}
		}
		
	
		return goodCell;
	}
	private  String decision( int cellanalysis[][]){//  make a decision
		
		int thinking = -1;
		String decision="";
		
		for(int i=0; i<cell.length; i++){
			for(int j=0; j<cell.length; j++){
				if(cell[i][j]==0){
					if (cellanalysis[i][j]>thinking){
						thinking=cellanalysis[i][j];
						
						decision = ""+j+i;
					}
				}
	}
		}
		if(cell[cell.length/2][cell.length/2]==0){
			decision = ""+cell.length/2+cell.length/2;
		}
		return decision;}
	
	private  String firstTryNotToLose(){ //checking for lines where we can lose
int dangerline[]=new int[Constants.LINES];
		int temp=0;
		for(int k=0; k<Constants.LINES; k++){
			for(int i=0; i<cell.length; i++){
				for(int j=0; j<cell.length; j++){
				
					if(cell[i][j]==Constants.O)	{temp = Constants.O;}
					if(cell[i][j]==Constants.X)	{temp = Constants.X;}
					if(cell[i][j]==0){temp = 0;}
						if(k==i ||k-cell.length==j){
							dangerline[k]=dangerline[k]+temp;
						}
						if(j==i && k==Constants.LINES-2){
							dangerline[Constants.LINES-2]=dangerline[Constants.LINES-2]+temp;
						}
						if(cell.length-j-1==i && k==Constants.LINES-1){
							dangerline[Constants.LINES-1]=dangerline[Constants.LINES-1]+temp;
						}
				
				}
				
				}
				}String dangercell = saveCell(dangerline);
				return dangercell;
					
				}
	private  String saveCell(int dangerline[]){//cell which save from losing and looking for a winners
		
		String needcell = Constants.NO_DANGER_CELLS;
		
		for(int k=0;k<Constants.LINES;k++){
			
			if(dangerline[k]==Constants.DANGER_COUNT_OF_POINTS){
				needcell =goodMove(k);	
			
		}
	}
		for(int k=0;k<Constants.LINES;k++){
			if(dangerline[k]==Constants.DANGER_COUNT_OF_POINTS*Constants.X ){
				needcell =goodMove(k);}
		
	}return needcell;
}
	private  String goodMove( int k){ //help method for saving from lose or winning
		
		String needcell = Constants.NO_DANGER_CELLS;
		for(int i=0; i<cell.length; i++){
			for(int j=0; j<cell.length; j++){
				if(cell[i][j]==0){
					if((k<Constants.LINES-2&&(i==k||k-cell.length==j)||
							(j==i && k==Constants.LINES-2)||
							(cell.length-j-1==i && k==Constants.LINES-1))){
						needcell=""+j+i;			
					}		
				}
			}	
	}return needcell;
	}
	private int[][] translateInputInformation(int inputboard[], int playerid){ //translate information for my bot
		
		for(int i=0; i<inputboard.length;i++){
			if(playerid==1){
				if(inputboard[i]==1){
					inputboard[i]=Constants.X;
				}
					if(inputboard[i]==-1){
						inputboard[i]=Constants.O;
				}
			}
			if(playerid==-1){
				if(inputboard[i]==1){
					inputboard[i]=Constants.O;
				}
					if(inputboard[i]==-1){
						inputboard[i]=Constants.X;
				}
			}
		}
		int cell[][]={{inputboard[0], inputboard[1],inputboard[2]},
				      {inputboard[3], inputboard[4],inputboard[5]},
				      {inputboard[6], inputboard[7],inputboard[8]}};
				      
		return cell;
	}
	private int translateDecision(String decision){ //translate information for pogram
		
		int answer = Integer.parseInt(decision);
		int mark =answer%10;
		int result=0;
		if (mark==0){
			result = mark+answer/10;
		}
		if (mark==1){
			result = 2+mark+answer/10;
		}
		if (mark==2){
			result = 4+mark+answer/10;
		}
		
		return result;
		
	}
}
