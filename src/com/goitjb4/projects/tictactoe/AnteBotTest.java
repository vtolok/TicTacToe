package com.goitjb4.projects.tictactoe;



import org.junit.Assert;
import org.junit.Test;


public class AnteBotTest {
	
	@Test
	public void smartMoveTest(){
	int cell[]={
		      -1,0,0,
		      0,1,-1,
		      -1,1,0
		      };

AnteBot test =new AnteBot(cell, 1);
int testing = test.smartMove();

int waitingresult = 1;

Assert.assertEquals(testing, waitingresult);

}
	@Test
	public void smartMoveTest1(){
	int cell[]={
		      -1,-1,0,
		      0,0,-1,
		      1,0,0
		      };

AnteBot test =new AnteBot(cell, -1);
int testing = test.smartMove();

int waitingresult = 2;

Assert.assertEquals(testing, waitingresult);

}
	@Test
	public void smartMoveTest2(){
	int cell[]={
		      0,0,0,
		      0,0,0,
		      0,0,0
		      };

AnteBot test =new AnteBot(cell, -1);
int testing = test.smartMove();

int waitingresult = 4;

Assert.assertEquals(testing, waitingresult);
	}
}
