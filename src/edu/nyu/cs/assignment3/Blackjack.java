package edu.nyu.cs.assignment3;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

/**
 * A program to play blackjack.
 * 
 */
public class Blackjack {
  /* Do not modify this method */
  public static Random initRandom(String[] args) {
    if (args.length >= 1) {
      return new Random(Long.parseLong(args[0]));
    } else {
      return new Random();
    }
  }

  // method to calcualte the sum of arraylist
  public static int sumList(List<Integer> list) {
    int sum = 0;

    // Iterate through the ArrayList and sum up the values
    for (int num : list) {
      sum += num;
    }

    return sum;
  }

  public static void main(String[] args) throws Exception {
    Random r = initRandom(args); // Do not modify this line

    /*
     * TODO:
     * Implement the game.
     * Feel free to add additional methods.
     * 
     * Please use the provided random number generator r.
     */
    System.out.println("Welcome to Blackjack!");

    List<Integer> user = new ArrayList<Integer>();
    // the users random starter numbers
    int u1 = r.nextInt(2, 12);
    int u2 = r.nextInt(2, 12);

    user.add(u1);
    user.add(u2);

    int start = 0;
    int total = 0;
    // the dealers random starter numbers

    List<Integer> dealer = new ArrayList<Integer>();
    int d1 = r.nextInt(2, 12);
    int d2 = r.nextInt(2, 12);

    dealer.add(d1);
    dealer.add(d2);

    int dealersSum = 0;

    start = sumList(user);
    total = sumList(user);

    System.out.println("Your cards are: " + user);

    boolean keepGoing = true;

    if (start > 21) {
      keepGoing = false;
      System.out.println("You have bust!");
      System.out.println("Your cards are: " + user);
      System.out.println("The dealer's cards are: " + dealer);
      System.out.println("Dealer wins!");

    }

    while (keepGoing) {
      Scanner draw = new Scanner(System.in);
      System.out.println("Would you like to hit or stand?");
      String userDraw = draw.nextLine();

      if (userDraw.equals("hit")) {
        int u3 = r.nextInt(2, 12);
        user.add(u3);
        total = sumList(user);

        // System.out.println("Your cards are: " + user + " and the sum is " + total);

        if (total > 21) {
          System.out.println("You have bust!");
          total = sumList(user);
          System.out.println("Your cards are: " + user);
          System.out.println("The dealer's cards are: " + dealer);
          keepGoing = false;
          break;
        } else {
          System.out.println("Your cards are: " + user);
          keepGoing = true;
        }
      } else if (userDraw.equals("stand")) {
        break;
      }

    }

    boolean dealersTurn = true;
    if (start > 21) {
      dealersTurn = false;
    }
    while (dealersTurn) {
      int dealersDraw = r.nextInt(2);

      if (dealersDraw == 1 && keepGoing) {
        System.out.println("The dealer hits");
        int d3 = r.nextInt(2, 12);
        dealer.add(d3);
        dealersSum = sumList(dealer);

        if (dealersSum > 21) {
          System.out.println("The dealer has bust!");
          dealersSum = sumList(dealer);
          System.out.println("Your cards are: " + user);
          System.out.println("The dealer's cards are: " + dealer);
          System.out.println("You win!");

          dealersTurn = false;

        } else {
          dealersTurn = true;
        }
      } else if (dealersDraw == 0 && keepGoing) {
        dealersSum = sumList(dealer);
        System.out.println("The dealer stands");
        System.out.println("Your cards are: " + user);
        System.out.println("The dealer's cards are: " + dealer);

        if (total == dealersSum) {
          System.out.println("Tie!");
        } else if (total > dealersSum) {
          System.out.println("You win!");
        } else if (dealersSum > total) {
          System.out.println("Dealer wins!");
        }

        break;
      } else {
        if (total == dealersSum) {
          System.out.println("Tie!");
        } else if (total < dealersSum) {
          System.out.println("You win!");
        } else if (dealersSum < total) {
          System.out.println("Dealer wins!");
        }
        break;
      }
    }

  }
} // end of class
