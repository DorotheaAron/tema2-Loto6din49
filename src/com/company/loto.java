package com.company;

import java.util.Scanner;

public class loto {
    public static void main(String[] args) {
	// write your code here
        Scanner sc = new Scanner(System.in);
        int[] myNumbers=new int[6];
        System.out.println("choose six numbers from 1 to 49");
        for (int i=0;i<6;i++) {
            System.out.print("The number is:");
            myNumbers[i]=sc.nextInt();
            boolean nrChanged;
            do {
                nrChanged = false;
                for (int j = 0; j < i; j++) {
                    if ((myNumbers[j] == myNumbers[i]) || (myNumbers[i]<1) ||(myNumbers[i]>49)) {
                        System.out.println("Choose another number:");
                        myNumbers[i] = sc.nextInt();
                        nrChanged = true;
                        // it was a duplication
                    }
                }
            }
            while (nrChanged);
        }
        System.out.print("your numbers are: ");
        for (int i:myNumbers)
        {
            System.out.print(i+" ");
        }
        LottoMachine lottoMachine=new LottoMachine();
        lottoMachine.ifYouWin(myNumbers);

    }
}
