package com.company;

import java.util.Scanner;

/**
 * Created by user376 on 24.06.2015.
 */
public class LottoMachine {

    private int compareNumbers(int[] lottonr,int[] myNumbers) {
        int counter=0;
        for (int i = 0; i < 6; i++) {
            for (int j = 0; j <6; j++) {
                if (lottonr[i]==myNumbers[j]) {
                    counter++;
                    break;
                }
            }}
        return counter;
    }
    private void howmanyTickets(int[] a,int[] test)
    {

        double counter=0;
        double ticketprice=4.8;
        double value;
        for(int i=3;i<=6;i++) {
            while (compareNumbers(a, test)!=i)
            {
                test = generateLottoNumber();
                counter++;
            }
            System.out.println("to win " + i + " numbers you must buy :" + counter + " tickets");
            value=ticketprice*counter;
            System.out.println("Must spend "+value+" Ron ");
        }
        System.out.println("FINISH");
    }
    public void ifYouWin(int[] numbers) {
        int[] getNumberWinners=generateLottoNumber();
        int a = compareNumbers(getNumberWinners, numbers);
        System.out.print("\nWinning numbers at lotto are:");
        for (int i : getNumberWinners) {
            System.out.print(i + " ");
        }
        if (a < 3)
        { System.out.println("\n You have not won!");
            howmanyTickets(getNumberWinners, generateLottoNumber());
        }
        else
        {if(a==3)
            System.out.println("You won the category 4 to 3 numbers!");
            if(a==4)
                System.out.println("You won the category 3 to 4 numbers!");
            if(a==5)
                System.out.println("You won the category 2 to 5 numbers!");
            if(a==6)
                System.out.println("You won the category 1 to 6 numbers!");}
    }

    private int[] generateLottoNumber() {
        // prepare the lotto machine and init it
        java.util.Random lottoMachine = new java.util.Random();
        lottoMachine.setSeed(System.currentTimeMillis());

        // generate the numbers
        int[] sixGeneratedNumbers = new int[6];
        for (int i = 0; i < 6; i++) {
            int nr = lottoMachine.nextInt(49) + 1;
            //check if nr is not already in the array, if it is generate a new one
            boolean nrChanged;
            do {
                nrChanged = false;
                for (int j = 0; j <= i; j++) {
                    if (sixGeneratedNumbers[j] == nr) {
                        nr = lottoMachine.nextInt(49) + 1;
                        nrChanged = true;
                        // it was a duplication
                    }
                }
            }
            while (nrChanged);
            sixGeneratedNumbers[i] = nr;
        }
        return sixGeneratedNumbers;
    }
}
