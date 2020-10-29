import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.Random;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeAll;

import org.junit.jupiter.api.Test;

import org.junit.jupiter.api.DisplayName;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class MyTest {

	static Random randomGenerator;
	Integer randomNum,currentWinAmount;
	static Integer totalWinAmount;
	static ArrayList<Integer> winnings;
	
	@BeforeAll
	static void setUp()
	{
		randomGenerator = new Random();
		winnings = new ArrayList<Integer>();
		totalWinAmount = 0;
		
	}
	
	ArrayList<Integer> winningsTest(int numMatches,int numSpots)
	{
		if(numMatches == 0)
		{
			if(numSpots == 10)
			{
				currentWinAmount = 5;
				totalWinAmount += 5;
			}
			else
			{
				currentWinAmount = 0;
			}
		}
		//1 match
		else if(numMatches == 1)
		{
			if(numSpots == 1)
			{
				currentWinAmount = 2;
				totalWinAmount += 2;
			}
			else
			{
				currentWinAmount = 0;
			}
		}
		
		//2 matches
		else if(numMatches == 2)
		{
			if(numSpots == 4)
			{
				currentWinAmount = 1;
				totalWinAmount += 1;
			}
			else
			{
				currentWinAmount = 0;
			}
		}
		
		//3 matches
		else if(numMatches == 3)
		{
			if(numSpots == 4)
			{
				currentWinAmount = 5;
				totalWinAmount += 5;
			}
			else
			{
				currentWinAmount = 0;
			}
		}
		
		//4 matches
		else if(numMatches == 4)
		{
			if(numSpots == 4)
			{
				currentWinAmount = 75;
				totalWinAmount += 75;
			}
			else if(numSpots == 8)
			{
				currentWinAmount = 2;
				totalWinAmount += 2;
			}
			else
			{
				currentWinAmount = 0;
			}
		}
		
		//5 matches
		else if(numMatches == 5)
		{
			if(numSpots == 8)
			{
				currentWinAmount = 12;
				totalWinAmount += 12;
			}
			else if(numSpots ==10)
			{
				currentWinAmount = 2;
				totalWinAmount += 2;
			}
		}
		
		//6 matches
		else if(numMatches == 6)
		{
			if(numSpots == 8)
			{
				currentWinAmount = 50;
				totalWinAmount += 50;
			}
			else if(numSpots ==10)
			{
				currentWinAmount = 15;
				totalWinAmount += 15;
			}
		}
		
		//7 matches
		else if(numMatches == 7)
		{
			if(numSpots == 8)
			{
				currentWinAmount = 750;
				totalWinAmount += 750;
			}
			else if(numSpots ==10)
			{
				currentWinAmount = 40;
				totalWinAmount += 40;
			}
		}
		
		//8 matches
		else if(numMatches == 8)
		{
			if(numSpots == 8)
			{
				currentWinAmount = 10000;
				totalWinAmount += 10000;
			}
			else if(numSpots ==10)
			{
				currentWinAmount = 450;
				totalWinAmount += 450;
			}
		}
		
		//9 matches
		else if(numMatches == 9)
		{
			if(numSpots ==10)
			{
				currentWinAmount = 4250;
				totalWinAmount += 4250;
			}
		} 
		
		//10 matches
		else if(numMatches == 10)
		{
			if(numSpots ==10)
			{
				currentWinAmount = 100000;
				totalWinAmount += 100000;
			}
		}
		winnings.clear();
		winnings.add(currentWinAmount);
		currentWinAmount = 0;
		return winnings;
	}
	
	
	//Testing the random number generator logic
	@Test
	void randomNumberLogic_test1() {
		randomNum = randomGenerator.nextInt(79) + 1;
		assertEquals((randomNum<81 && randomNum>0),true,"Wrong Value!");
	}
	
	/*
	 * Testing every possible 1-spot scenario
	 */
	
	@Test
	void currentWinnings_test1() {
		assertEquals(2,winningsTest(1,1).get(0),"Wrong Value!");
	}
	@Test
	void currentWinnings_test2() {
		assertEquals(winningsTest(0,1).get(0),0,"Wrong Value!");
	}
	
	/*
	 * Testing every possible 4-spot scenario
	 */
	
	@Test
	void currentWinnings_test3() {
		assertEquals(winningsTest(1,4).get(0),0,"Wrong Value!");
	}
	@Test
	void currentWinnings_test4() {
		assertEquals(winningsTest(2,4).get(0),1,"Wrong Value!");
	}
	@Test
	void currentWinnings_test5() {
		assertEquals(winningsTest(3,4).get(0),5,"Wrong Value!");
	}
	@Test
	void currentWinnings_test6() {
		assertEquals(winningsTest(4,4).get(0),75,"Wrong Value!");
	}
	@Test
	void currentWinnings_test7() {
		assertEquals(winningsTest(0,4).get(0),0,"Wrong Value!");
	}
	
	/*
	 * Testing every possible 8-spot scenario
	 */
	
	@Test
	void currentWinnings_test8() {
		assertEquals(winningsTest(1,8).get(0),0,"Wrong Value!");
	}
	@Test
	void currentWinnings_test9() {
		assertEquals(winningsTest(2,8).get(0),0,"Wrong Value!");
	}
	@Test
	void currentWinnings_test10() {
		assertEquals(winningsTest(3,8).get(0),0,"Wrong Value!");
	}
	@Test
	void currentWinnings_test11() {
		assertEquals(winningsTest(4,8).get(0),2,"Wrong Value!");
	}
	@Test
	void currentWinnings_test12() {
		assertEquals(winningsTest(5,8).get(0),12,"Wrong Value!");
	}
	@Test
	void currentWinnings_test13() {
		assertEquals(winningsTest(6,8).get(0),50,"Wrong Value!");
	}
	@Test
	void currentWinnings_test14() {
		assertEquals(winningsTest(7,8).get(0),750,"Wrong Value!");
	}
	@Test
	void currentWinnings_test15() {
		assertEquals(winningsTest(8,8).get(0),10000,"Wrong Value!");
	}
	@Test
	void currentWinnings_test16() {
		assertEquals(winningsTest(0,8).get(0),0,"Wrong Value!");
	}
	
	/*
	 * Testing every possible 10-spot scenario
	 */
	
	@Test
	void currentWinnings_test17() {
		assertEquals(winningsTest(1,10).get(0),0,"Wrong Value!");
	}
	
	@Test
	void currentWinnings_test18() {
		assertEquals(winningsTest(2,10).get(0),0,"Wrong Value!");
	}
	@Test
	void currentWinnings_test19() {
		assertEquals(winningsTest(3,10).get(0),0,"Wrong Value!");
	}
	@Test
	void currentWinnings_test20() {
		assertEquals(winningsTest(4,10).get(0),0,"Wrong Value!");
	}
	@Test
	void currentWinnings_test21() {
		assertEquals(winningsTest(5,10).get(0),2,"Wrong Value!");
	}
	@Test
	void currentWinnings_test22() {
		assertEquals(winningsTest(6,10).get(0),15,"Wrong Value!");
	}
	@Test
	void currentWinnings_test23() {
		assertEquals(winningsTest(7,10).get(0),40,"Wrong Value!");
	}
	@Test
	void currentWinnings_test24() {
		assertEquals(winningsTest(8,10).get(0),450,"Wrong Value!");
	}
	@Test
	void currentWinnings_test25() {
		assertEquals(winningsTest(9,10).get(0),4250,"Wrong Value!");
	}
	@Test
	void currentWinnings_test26() {
		assertEquals(winningsTest(10,10).get(0),100000,"Wrong Value!");
	}
	@Test
	void currentWinnings_test27() {
		assertEquals(winningsTest(0,10).get(0),5,"Wrong Value!");
	}
	
	/*
	 * Testing the total winnings logic
	 */
	
	@Test
	void totalWinnings_test() {
		assertEquals(totalWinAmount,115576,"Wrong Value!");
	}
	
	

}
