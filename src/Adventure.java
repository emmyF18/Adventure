import java.util.Scanner;

public class Adventure 
{
	 int level = 1;
	 int  exp;
	 int expNeeded = 10 ;
	 int currentHeath = 20;
	 int totalHeath = 20;
	 boolean inCave = false;
	 int monsterHP = 10;
	 int monsterLevel = 1;
	 int numOfPotions =0;
	 int numOfTurns = 0;

	static String name;
	static Scanner in = new Scanner(System.in);
	 
	public static void main(String[] args)
	{
		new Adventure();
	}
	public Adventure()
	{
		System.out.println("What is your name, adventurer? : ");
		name= in.next();
		System.out.println("You awaken in a large field with no memory of how you got there. You can recal your name, but not much else.\n"
				+ "You look around, but there is nothing to that you can see in the distance. Maybe there will be a town nearby. \n"
				+ "You have a sword with you, but nothing else in your bag. What will you do? " );
		showMain();
	}
	 void  showMain()
	{
		int choice;
		System.out.println("1: Explore the Area\n2: Items\n3: Player Info\n4: Quit ");
		System.out.print("?");
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
			//System.out.println("Are you sure you want to quit? Y/N");
			//String ans = in.next();
			//if(ans = "Y")
			//{
			quit();
			//}
			//showMain();
		}
	}
	 void explore()
	{
		
		int result = rollnum(0,10);
		//did we find cave
		if(result == 1 | result == 2 | result == 3)
		{
			System.out.println("You Found a Cave!");
			inCave = true;
			inCave();
		}
		//did we find healing center
		else if(result == 4 | result == 5 )
		{
			System.out.println("You Found A Healing Center! Your Heath has been Restored");
			currentHeath = totalHeath;
		}
		else
		{
			result = rollnum(0, 5);
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
	 void inCave()
	{
		//monsters more frequent, but more potions/items
	}
	 void items()
	{
		System.out.println("you have " + numOfPotions + " potions  \n Use a potion to restore 20 heath? Y/N ");
		in.next();
		System.out.println();
		//display how many potions/items person has
	}
	 void playerInfo()
	{
		System.out.println("Level: " + level + "\n EXP Needed for Next Level: " + expNeeded 
				+ "\n Heath: " + currentHeath  + "/" + totalHeath );
		//exp and heath and level
		
	}
	 void foundMonster()
	{
			//monster fighting
		int currentMonsterHP = monsterHP;
		System.out.println("You ran into a monster! Time to fight!");
		while(currentMonsterHP > 0)
		{
			System.out.println("1: Fight With Sword \n2: Items\n3: Player Info\n4: Run Away ");
			System.out.print("Enter the Number of what you want to do ");
			int choice = Integer.parseInt(in.next());
			if(choice == 1 ) //you attacking
			{
				int damageDone= rollnum(4,10) + level;
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
			else
			{
				 int chance = rollnum(1, 5);
				 if(chance == 1 | chance == 2 | chance == 3)
				 {
					 System.out.println("got away safety");
					 showMain();
				 }
				 else
				 {
					 System.out.println("you can't get away!");
				 }
			}
			//monster attacks
		}
		showMain();
	}
	
	static int rollnum(int begin, int end)
	{
		 return (int) (Math.random() * ((begin-end + end)) + 1);
	}
	 boolean stillAlive()
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
	 void levelUp()
	{
		 level++;
		 totalHeath += 5;
		 monsterLevel++;
		 monsterHP+=2;
		 expNeeded = exp * 2;
		 exp = 0;
		 currentHeath = totalHeath;
		 System.out.println("You are now Level " + level + "!\nYour Heath has been Restored");
	}
	 void quit()
	{
		System.exit(0);
	}

}
