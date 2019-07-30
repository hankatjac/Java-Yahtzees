/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package yahtzeesp3;

import java.util.Arrays;
import java.util.Scanner;

/**
 *
 * @author Hang Ruan #1896418
 */
public class YahtzeesP3 {

    /**
     * the numValidate method to validate whether user input is in the range x to y
     * @param x - the first number to define the minimum
     * @param y - the second number to define the maximum
     * @return the number user input
     */
    
    
    /*
    It is a method which belongs to the class and not to the object(instance)
    A static method can access only static data. It can not access non-static data (instance variables)
    A static method can call only other static methods and can not call a non-static method from it.
    A static method can be accessed directly by the class name and doesn’t need any object
    A static method cannot refer to "this" or "super" keywords in anyway
    */
    public static int numValidate(int x, int y)
    {
        Scanner sc = new Scanner(System.in);
        while (!sc.hasNextInt()) 
        {
            sc.next();
        }
        int number = sc.nextInt();
        while (number < x || number > y)
        {
            System.out.println();
            System.out.println("invalid number! Please re-enter");
            while (!sc.hasNextInt()) 
            {
                sc.next();
            }
            number = sc.nextInt(); 
        } 
        return number;
    }
    
    /**
     * the answerValidate method to validate whether user input is "y/Y" or "n/N"
     * 
     * @return the response "y" or "n"
     */
    
    public static char answerValidate() 
    {
        Scanner sc = new Scanner(System.in);
        String ans = sc.nextLine();
        while (ans.trim().isEmpty() || (!ans.trim().toLowerCase().startsWith("y")) && !ans.trim().toLowerCase().startsWith("n")) 
        {
            ans = sc.next();
        }
        char res = ans.trim().toLowerCase().charAt(0);
        return res;  
    }
    
    
    public static void main(String[] args) 
    {
        // game rule see reference: https://en.wikipedia.org/wiki/Yahtzee
        Scanner inputName = new Scanner (System.in);
        Scanner kb = new Scanner(System.in);
        
        // Display game title to console
        System.out.println
        (
            "\t\t\t*******************************************\n"
            + "\t\t\t\t\tWelcome Game Yahtzees\n"
            + "\t\t\t*******************************************\n\n"
        );
        
        // Display game rule to console
        System.out.println
        (
            "\t\t\t\t\tYahtzee Rules\n\n"
            + "\t\t\tThe objective of YAHTZEE is to get as many points as possible\n"
            + "\t\tby rolling five dice and getting certain combinations of dice.\n\n"
        );
        
        // Display instruction to play  
        System.out.println
        (
            "\t\t\t\t\tGameplay\n\n"
            + "\t\t\tIn each turn a player may throw the dice up to three times.\n"
            + "\t\tA player doesn't have to roll all five dice on the second and\n"
            + "\t\tthird throw of a round, he may put as many dice as he wants to\n"
            + "\t\tthe side and only throw the ones that don't have the numbers\n"
            + "\t\the's trying to get. For example, a player throws and gets 1,3,3,4,6.\n"
            + "\t\tHe decides he want to try for the large straight, 1,2,3,4,5.\n"
            + "\t\tSo, he puts 1,3,4 to the side and only throws 3 and 6 again,\n"
            + "\t\thoping to get 2 and 5.\n"
        );
        
        //display score rule
        System.out.println
        (
            "\t\t\t\tUpper section combinations\n\n"
            + "\t\t\tOnes: Get as many ones as possible.\n" 
            + "\t\t\tTwos: Get as many twos as possible.\n"
            + "\t\t\tThrees: Get as many threes as possible.\n"
            + "\t\t\tFours: Get as many fours as possible.\n"
            + "\t\t\tFives: Get as many fives as possible.\n"
            + "\t\t\tSixes: Get as many sixes as possible.\n\n"
        );
        
        System.out.println
        (
            "\t\t\t\tLower section combinations\n\n"
            + "\t\tThree of a kind: Get three dice with the same number. Points\n"
            + "\t\t\t\tare the sum all dice (not just the three of a kind).\n" 
            + "\t\tFour of a kind: Get four dice with the same number. Points are\n"
            + "\t\t\t\the sum all dice (not just the four of a kind).\n"
            + "\t\tFull house: Get three of a kind and a pair, e.g. 1,1,3,3,3 or\n"
            + "\t\t\t\t3,3,3,6,6. Scores 25 points.\n" 
            + "\t\tSmall straight: Get four sequential dice, 1,2,3,4 or 2,3,4,5 or\n"
            + "\t\t\t\t3,4,5,6. Scores 30 points.\n" 
            + "\t\tLarge straight: Get five sequential dice, 1,2,3,4,5 or 2,3,4,5,6.\n"
            + "\t\t\t\tScores 40 points.\n"
            + "\t\tChance: You can put anything into chance, it's basically like\n"
            + "\t\t\t\ta garbage can when you don't have anything else you can use\n"
            + "\t\t\t\tthe dice for. The score is simply the sum of the dice.\n" 
            + "\t\tYAHTZEE: Five of a kind. Scores 50 points.\n\n"
        );
        
        System.out.println("Press enter key to start game");
        kb.nextLine();
        System.out.println();
        System.out.println("How many players?(1 - 5 only)");
            
        int numOfPlayers = numValidate(1, 5);    // method  
        String [] nameOfPlayer = new String[numOfPlayers];
        
        // Display Scoresheet to console
        System.out.println();
        for (int n = 0; n < numOfPlayers; n++)
        {    
            System.out.println("Please enter " +  (n+1) + " player's name");
            nameOfPlayer[n] = inputName.nextLine().trim();
            System.out.println("\t\t\tWelcome " + nameOfPlayer[n] + " !\n");
        }
        Arrays.sort(nameOfPlayer);
        
        System.out.println("\t\t\t\t\tScore Sheet\n");
        System.out.print("\t\t\t\t\t");
        for (int n = 0; n < numOfPlayers; n++)
        {
            System.out.print(nameOfPlayer[n] + "\t");
        }
        
        System.out.println();
        System.out.println
        (
            "\t\t\t------------------------------------------\n"
            + "\t\t\t\t\tUpper Selection\n"
            + "\t\t\t------------------------------------------\n"
            + "\t\t\tOnes\t\t\t|\t|\t|\n"
            + "\t\t\tTwos\t\t\t|\t|\t|\n"
            + "\t\t\tThrees\t\t\t|\t|\t|\n"
            + "\t\t\tFours\t\t\t|\t|\t|\n"
            + "\t\t\tFives\t\t\t|\t|\t|\n"
            + "\t\t\tSixes\t\t\t|\t|\t|\n"
            + "\t\t\t------------------------------------------\n"
            + "\t\t\tUpper Score\t\t|\t|\t|\n"
            + "\t\t\t------------------------------------------\n"
            + "\t\t\t\t\tLower Selection\n"
            + "\t\t\t------------------------------------------\n"
            + "\t\t\tThree of a kind\t\t|\t|\t|\n"
            + "\t\t\tFour of a kind\t\t|\t|\t|\n"
            + "\t\t\tFull House (25)\t\t|\t|\t|\n"
            + "\t\t\tSmall Straight (30)\t|\t|\t|\n"
            + "\t\t\tLarge Straight (40)\t|\t|\t|\n"
            + "\t\t\tYahtzees (50)\t\t|\t|\t|\n"
            + "\t\t\tChance\t\t\t|\t|\t|\n"
            + "\t\t\t------------------------------------------\n"
            + "\t\t\tLower Score\t\t|\t|\t|\n"
            + "\t\t\t------------------------------------------\n"
            + "\t\t\tTotal\t\t\t|\t|\t|\n"     
        );
      
        int[][] scoreboard = new int [13][numOfPlayers];
        for (int row = 0; row < 13; row++)
        {
            for (int col = 0; col < numOfPlayers; col++)
            {
                scoreboard[row][col] = -1;
            }
        }

        int[] dice = new int[5]; //creat and display an array
        int round = 0;
        int roll;
        char answer;  
    
        // start to play game: throw dice, total 6 rounds for each player
        do
        {   
            for (int n = 0; n < numOfPlayers; n++)
            {
                roll = 0;
                System.out.println();
                System.out.println("Ready to play Yahtzees. The play order is alphabetize by player's name. Press enter key to continue"); 
                kb.nextLine();
                
                System.out.println("\t\t\t\tNow player " + nameOfPlayer[n] + " plays the " + (round + 1)+ " round(s)");
                System.out.println();
               
                //roll the dice at beginning
                for(int i=0; i<5; i++)
                {
                    dice[i] = (int)(Math.random()*6+1);    
                }
//                Arrays.sort(dice);
                for(int i=0; i<5; i++)
                {
                    System.out.println("\t\tDice "+ (i + 1) + ":\t\t " + dice[i]+"\n");    
                }
                
                //Let player choose yes or no depend on whether or not he wants continue to re-roll
                do  
                {
                    System.out.println();
                    System.out.println("Do you want to roll again?(y/Y/n/N)");
                    answer = answerValidate(); //method

                    if (answer == 'y')
                    { 
                        System.out.println();
                        System.out.println("How many dice do you want to roll?(1,2,3,4,5 only)");

                        int numOfDiceReroll = numValidate(1, 5); // method 
                        
                        // to generate an array to control which dice to roll
                        int[] reroll = new int[numOfDiceReroll]; 
                        if (numOfDiceReroll < 5) // condition: the numeber of dice to re-roll is less than 5
                        {
                            for (int i = 0; i < numOfDiceReroll; i++) 
                            {
                                System.out.println();
                                System.out.println("Which dice do your want to re-roll?(Please choose the die ID 1,2,3,4,5 only.)");
                                
                                int diceID = numValidate(1, 5); // method
                                reroll[i] = diceID;
                            }

                            for (int i = 0; i < numOfDiceReroll; i++) 
                            {
                                if (reroll[i] == 1) 
                                {dice[0] = (int)(Math.random()*6+1);}
                                if (reroll[i] == 2)
                                {dice[1] = (int)(Math.random()*6+1);}
                                if (reroll[i] == 3)
                                {dice[2] = (int)(Math.random()*6+1);}
                                if (reroll[i] == 4)
                                {dice[3] = (int)(Math.random()*6+1);}
                                if (reroll[i] == 5)
                                {dice[4] = (int)(Math.random()*6+1);}           
                            }
                        }
                        
                        else  // condition: player want to re-roll all the dice 
                        {   
                            for(int i=0; i<5; i++)
                            {
                                dice[i] = (int)(Math.random()*6+1);
                            }    
                        }
//                        Arrays.sort(dice);
                        //display dice value after player re-roll
                        System.out.println();
                        for(int i=0; i<5; i++)
                        {
                            System.out.println("\t\tDice "+ (i + 1) + ":\t\t " + dice[i] + "\n");
                        } 
                    }
              
                    roll++;
                }
                while (roll < 2 && answer == 'y');// to control maximum 3 rolls for each round    
                
                //The player has rolled the dice three times. Display the final dice value after each round      
                System.out.println();

                int[] sum = new int[13];
                int sumOfAllDice = 0;
                for (int i = 0; i < 5; i++)      
                {
                    sumOfAllDice = sumOfAllDice + dice[i];
                }
                   
                //count how many numbers for each dice value 
                int[] count = new int[6]; 
                for (int j = 0; j < 6; j++)
                {
                    for (int i = 0; i < 5; i++)
                    {
                        if  (dice[i] == j + 1 )
                         {
                             count[j] = count[j] + 1;
                         }
                    }
                }
 
                if (count[1] == 1 && count[2] == 1 && count[3] == 1 && count[4] == 1 )// large straight
                {
                    sum[9] = 30;  
                    sum[10] = 40;
                    sum[12] = sumOfAllDice;
                } 

                else if (count[0] == 1 && count[2] == 1 && count[3] == 1 && count[5] == 1)  //small straight
                {
                    sum[9] = 30;
                    sum[12] = sumOfAllDice;
                }

                else if ((count[0] + count[1] + count[2] + count[3] == 5)&& count[0] > 0 && count[1] > 0 && count[2] > 0 && count[3] > 0)  //small straight      
                {
                    sum[9] = 30;
                    sum[12] = sumOfAllDice;
                }

                else if ((count[1] + count[2] + count[3] + count[4] == 5)&& count[1] > 0 && count[2] > 0 && count[3] > 0 && count[4] > 0)  //small straight      
                {
                    sum[9] = 30;
                    sum[12] = sumOfAllDice;
                }

                else if ( (count[2] + count[3] + count[4] + count[5] == 5)&& count[2] > 0 && count[3] > 0 && count[4] > 0 && count[5] > 0)  //small straight      
                {
                    sum[9] = 30;
                    sum[12] = sumOfAllDice;
                }

                else 
                {
                    for ( int j = 0; j < 6; j++)
                    {
                        switch (count[j]) 
                        {
                            case 5:  //Yahzees
                                sum[6] = sumOfAllDice;
                                sum[7] = sumOfAllDice;
                                sum[11] = 50;
                                sum[12] = sumOfAllDice;
                                break;
                            case 4:  //four of a kind
                                sum[6] = sumOfAllDice;
                                sum[7] = sumOfAllDice;
                                sum[12] = sumOfAllDice;
                                break;
                            case 3: //three of a kind
                                for ( int i = 0; i < 6; i++)
                                {
                                    if (count[i] == 2)//full house
                                    {
                                        sum[8] = 25;
                                    }
                                }   
                                sum[6] = sumOfAllDice;
                                sum[12] = sumOfAllDice;
                                break;
                            default: //chance
                                sum[12] = sumOfAllDice;
                                break;
                        }
                    }
                }
                
                //show the each category score for player to choose               
                for (int j = 0; j < 6; j++)
                {
                   for (int i = 0; i < 5; i++)
                    {
                       if  (dice[i] == j + 1 )
                        {
                            sum[j] = sum[j] + (j + 1);
                        }
                    }     
                }
                
                String[] category = {"Aces", "Twos", "Threes", "Fours", "Fives", "Sixes", "Three Of A Kind", "Four Of A Kind", "Full House", "Small Straight", "Large Straight", "Yahtzee,Chance", "Chance"};
 
                System.out.println("This is not your scoreboard. It just a hint of list of score for each category. "
                        + "Please choose one of categories and assign it to your scoreboard.\n");
                
                for (int i = 0; i < 13; i++)
                {
                    System.out.println("\t\tCategorie " + (i + 1) + " " + category[i] + " :\t\t\t\t" + sum[i] + "\n");
                }
                
                // The player selects the category for the dice.
                int[] playerChoice = new int[numOfPlayers];
                System.out.println("Which category do you want to choose. (1 - 13 only)");

                playerChoice[n] = numValidate(1, 13); //method
               
                // The player cannot select a category that he/she already chose in a previous turn.
                while (scoreboard[playerChoice[n]-1][n]!= -1)
                { 
                    System.out.println();
                    System.out.println("The categogries has already been chosen, please select other category!");
                    playerChoice[n] = numValidate(1, 13); //method
                }
                scoreboard[playerChoice[n]-1][n]= sum[playerChoice[n] - 1];  

                 //display the scoreboard for each round
                System.out.println();
                System.out.println("This is " + nameOfPlayer[n] + " scoreboard for the " + (round + 1) + " round\n");
                
                for(int i=0; i<13; i++)
                { 
                    if (scoreboard[i][n] == -1) 
                    {
                        System.out.println("\t\tCategorie "+ (i + 1) + " " + category[i] + ":\n");
                    }
                    else   
                    {
                        System.out.println("\t\tCategorie "+ (i + 1)+ " " + category[i] + ":\t\t\t\t" + scoreboard[i][n] + "\n");
                    }  
                } 
            }
       
            round += 1;
        }    
        while (round < 13);
        
        //display player's final upper scoreboard
        System.out.println(); 
        System.out.println("All players have already done all 13 rounds. This is a complete scoreboard for all the players.\n");
       
        System.out.println
        (
            "\t\t------------------------------------------\n"
            + "\t\t\t\tUpper Section\n"
            + "\t\t------------------------------------------\n"
        );
      
        System.out.print("\t\t\t\t");
        for (int n =0; n < numOfPlayers; n++)
        { 
            System.out.print(nameOfPlayer[n]+ "\t\t");
        }
        System.out.println();
        
        
        int [] totalUpperScore = new int[numOfPlayers]; 
        for(int row=0; row<=5; row++)
        {
            System.out.print("\t\tCategorie " + (row + 1) + ":\t\t");
            for ( int col =0; col < numOfPlayers; col++)
            {
                System.out.print(scoreboard[row][col] + "\t");
                totalUpperScore[col] = totalUpperScore[col] + scoreboard[row][col];
            }
            System.out.println();
        }
         
        System.out.println( "\t\t------------------------------------------");
        System.out.print("\t\tTotal Upper Score: \t");
        for ( int n = 0; n < numOfPlayers; n++)
        {
            System.out.print(totalUpperScore[n] + "\t");
        }
        System.out.println();
        System.out.println("\t\t------------------------------------------");
 
        System.out.println();        
        System.out.println
        (
            "\t\t------------------------------------------\n"
            + "\t\t\t\tLower Section\n"
            + "\t\t------------------------------------------\n"
        );
      
        System.out.print("\t\t\t\t");
        for (int n =0; n < numOfPlayers; n++)
        { 
            System.out.print(nameOfPlayer[n]+ "\t\t");
        }
        System.out.println();
        
        
        int[] totalLowerScore = new int[numOfPlayers]; 
        
        for(int row=6; row<=12; row++)
        {
            System.out.print("\t\tCategorie " + (row + 1) + ":\t\t");
            for ( int col =0; col < numOfPlayers; col++)
            {
                System.out.print(scoreboard[row][col] + "\t");
                totalLowerScore[col] = totalLowerScore[col] + scoreboard[row][col];
            }
            System.out.println();
        }
        
        System.out.println( "\t\t------------------------------------------");
        System.out.print("\t\tTotal Lower Score: \t");
        for ( int n = 0; n < numOfPlayers; n++)
        {
            System.out.print(totalLowerScore[n] + "\t");
        }
        System.out.println();
        System.out.println("\t\t------------------------------------------");
        
        int[] totalScore = new int[numOfPlayers]; 
        for (int n =0; n < numOfPlayers; n++)
        { 
            totalScore[n] = totalUpperScore[n] + totalLowerScore[n];
        }
        System.out.println();
        
        System.out.println( "\t\t------------------------------------------");
        System.out.print("\t\tTotal Score: \t\t");
        for ( int n = 0; n < numOfPlayers; n++)
        {
            System.out.print(totalScore[n] + "\t");
        }
        System.out.println();
        System.out.println("\t\t------------------------------------------\n");
        
        int maxScore = 0;
        for (int i=0; i < numOfPlayers; i++)
        {
            if (maxScore < totalScore[i])
            {
                maxScore = totalScore[i];
            }
        }
        
          for (int i=0; i < numOfPlayers; i++)
        {
            if (totalScore[i]== maxScore)
            {
                System.out.println("\t\t\t\t" + nameOfPlayer[i]+ " is winner !");
            }
        }

        System.out.println("GAME OVER");
    }

   
 
  
    
    
}

