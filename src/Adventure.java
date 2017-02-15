import java.util.Scanner;

public class Adventure 
{
	static int level = 1;
	static int  exp;
	static int expNeeded = 40 ;
	static int currentHeath = 20;
	static int totalHeath = 20;
	static boolean inCave = false;
	static int monsterHP = 15;
	static int monsterLevel = 1;
	static int numOfPotions =0;
	static int numOfTurns = 0;
	static String name;
	static Scanner in = new Scanner(System.in);
	 
	public static void main(String[] args)
	{
		showMain();

	}
	public Adventure()
	{
		//"What is your name, adventurer? : ";
		//name= in.next();
	}
	static void  showMain()
	{
		int choice;
		System.out.println("1: Explore the Area\n2: Items\n3: Player Info\n4: Quit ");
		System.out.print("Enter the Number of what you want to do ");
		choice = Integer.parseInt(in.next());
		if(choice == 1 )
		{
			explore();
		}
		else if(choice == 2)
		{
			items();
			showMain();
		}
		else if(choice == 3)
		{
			playerInfo();
			showMain();
		}
		else
		{
			quit();
		}
	}
	static void explore()
	{
		
		int result = rollnum10();
		//did we find cave
		if(result == 1 | result == 2)
		{
			System.out.println("You Found a Cave!");
			inCave = true;
			inCave();
		}
		//did we find healing center
		else if(result == 3 | result == 4 | result == 5 )
		{
			System.out.println("You Found A Healing Center! Your Heath has been Restored");
			currentHeath = totalHeath;
		}
		else
		{
			result = rollnum10();
			System.out.println("You Continue in the Field");
			//did we find a potion
			if(result == 1)
			{
				System.out.println(" You Found a Potion! Use it to restore your heath. You can use it from the items menu ");
				numOfPotions++;
			}
			//did we find a monster
			if(result == (5 | 6 | 7 | 8 | 9));
			{
				foundMonster();
			}
			
		}
		showMain();
		
	}
	static void inCave()
	{
		
	}
	static void items()
	{
		System.out.println("you have " + numOfPotions + " potions  \n Use a potion to restore 20 heath? Y/N ");
		in.next();
		System.out.println();
		//display how many potions person has
	}
	static void playerInfo()
	{
		System.out.println("Level: " + level + "\n EXP Needed for Next Level: " + expNeeded 
				+ "\n Heath: " + currentHeath  + "/" + totalHeath );
		//exp and heath and level
		
	}
	static void foundMonster()
	{
			//monster fighting
		int currentMonsterHP = monsterHP;
		System.out.println("You ran into a monster! Time to fight!");
		while(currentMonsterHP > 0)
		{
			System.out.println("1: Fight With Sword \n2: Items\n3: Player Info\n4: Run Away ");
			System.out.print("Enter the Number of what you want to do ");
			int choice = Integer.parseInt(in.next());
			if(choice == 1 )
			{
				int damageDone= rollnum10();
				currentMonsterHP -= damageDone;
;				System.out.println("You Strike the monster with your sword " +  damageDone  + "Damage! "
						+ "\n Monster heath: " + currentMonsterHP + "\\" + monsterHP );
			}
			else if(choice == 2)
			{
				items();
			}
			else if(choice == 3)
			{
				playerInfo();
			}
		}
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
