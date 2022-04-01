/*

 *  Program Information:

 *    - Developer: Klaus Mayeaux


 *    - Program Name: "Starbucks Tip Distribution"

 *    - Date(s) Developed: 30 November 2020

 *    - Program Function:

 *        > This program retrieves the baristas names, hours worked for each barista, and the total 

 *   amount of tips that is being distributed. Then the program calculates and displays the amount of

 *  tips each barista is entitled to.

 *

 */

// Import the Scanner

import java.util.Scanner;

public class TipsDistribution {

    public static double calcAverageTip(double overallTips, double overallHours) {

        // Calculate Average Hourly Tip Distribution

        return overallTips / overallHours;

    } // End of calcAverageTip Method

    public static void main(String[] args) {

        // Declare the Scanner

        Scanner uInput = new Scanner(System.in);

        // Prompt User to Enter the Number of Baristas

        System.out.println("How many baristas are you distributing tips to?");

        System.out.print("User: ");

        int numOfBarista = uInput.nextInt();

        // Error Check and Continue if None

        if (numOfBarista >= 1) {

            // Prompt the User to Enter the Total Amount of Tips

            System.out.println("How much in USD is the total amount of tips overall?");

            System.out.print("User: ");

            double overallTips = uInput.nextDouble();

            // Error Check and Continue if None

            if (overallTips >= 1) {

                // Retrieve the Baristas Names

                String[] baristaNames = new String[numOfBarista];

                for (int i = 0; i < baristaNames.length; i++) {

                    // Fix a Future Grammar Issue

                    int corNum = i + 1;

                    String corSuf;

                    if (corNum == 1) {

                        corSuf = "st";

                    } else if (corNum == 2) {

                        corSuf = "nd";

                    } else if (corNum == 3) {

                        corSuf = "rd";

                    } else {

                        corSuf = "th";

                    } // End of Grammar Correction

                    // Prompt the User and Retrieve Input

                    System.out.println("What is the name of the " + corNum + corSuf + " barista?");

                    System.out.print("User: ");

                    baristaNames[i] = uInput.next();

                } // End of For Loop

                // Retrieve the Hours Worked for Each Barista

                double[] baristaHours = new double[numOfBarista];

                for (int i = 0; i < baristaHours.length; i++) {

                    // Prompt the User and Retrieve Input

                    System.out.println("What is the number of hours worked by " + baristaNames[i] + "?");

                    System.out.print("User: ");

                    baristaHours[i] = uInput.nextDouble();

                } // End of For Loop

                // Calculate the Overall Hours Worked

                double overallHours = 0;

                for (int i = 0; i < baristaHours.length; i++) {

                    // Add All of the Hours Each Barista Worked Together

                    overallHours = overallHours + baristaHours[i];

                } // End of For Loop

                // Compute the Average Tips Per Hour to be Distributed

                double averageTip = calcAverageTip(overallTips, overallHours);

                // Compute the Amount of Tips Each Barista is Entitled To

                double[] baristaTips = new double[numOfBarista];

                for (int i = 0; i < baristaTips.length; i++) {

                    baristaTips[i] = baristaHours[i] * averageTip;

                } // End of For Loop

                // Display the Report

                for (int i = 0; i < baristaNames.length; i++) {

                    System.out.println(baristaNames[i] + " = " + baristaTips[i]);

                } // End of For Loop

            } else {

                // Display an Error Message

                System.out.println("Error 001: An invalid amount in overall tips has been inputted! Please try again...");

            } // End of If-Else Statement

        } else {

            // Display an Error Message

            System.out.println("Error 001: An invalid number of baristas have been inputted! Please try again...");

        } // End of If-Else Statement

        // Terminate the Scanner

        uInput.close();

    } // End of Main Method

} // End of TipDistribution Class
