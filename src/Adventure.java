import java.util.Scanner;

public class Adventure 
{
	static int level;
	static int  exp;
	static int expNeeded;
	static int currentHeath;
	static int totalHeath;
	static boolean inCave;
	static int monsterHP;
	static int numOfPotions;
	static int numOfTurns;
	static String name;
	static Scanner in = new Scanner(System.in);
	 
	public static void main(String[] args)
	{
		showMain();
		//Adventure();

	}
	public Adventure()
	{
		//"What is your name, adventurer? : ";
		//name= in.next();
	}
	static void  showMain()
	{
		int choice;
		System.out.println("1: Explore the Field \n 2: Items \n 3: Player Info \n 4: Quit \n Enter the Number of what you want to do");
		
		choice = Integer.parseInt(in.next());
	}
	static void explore()
	{
		//did we find cave
		
		//did we find healing center
		
		//did we find a potion
		
		//did we find a monster
		
	}
	static void items()
	{
		//display how many potions person has
	}
	static void person()
	{
		//exp and heath and level
		
	}
	static void foundMonster()
	{
		//monster fighting
	}
	static int rollnum10()
	{
		 return (int) (Math.random() * ((10-1 + 1)) + 1);
	}
	static int rollnum5()
	{
		 return (int) (Math.random() * ((5-1 + 1)) + 1);	
	}
	static boolean stillAlive()
	{
		if(totalHeath >= currentHeath)
		{
			return true;
		}
		else
		{
			return false;
		}
	}
	static void levelUp()
	{
		//increase
	}
	static void quit()
	{
		System.exit(0);
	}

}
