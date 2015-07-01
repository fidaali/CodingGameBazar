/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package stockExMedium;

import java.util.Scanner;

/**
 *
 * @author Jahan
 */
public class StockEx {
        public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        in.nextLine();
        String vs = in.nextLine();
        String[] vsp=vs.split(" ");
        
        int max=0;
        int min=Integer.MAX_VALUE;
        int currLoss=0;
        for(String s : vsp){
            int i=Integer.parseInt(s);
            if(max <i){
                max=i;
                min=Integer.MAX_VALUE;
            }
            if(min > i){
                min=i;
                if(min<max){
                    if(currLoss>min-max){
                        currLoss= min-max;
                    }
                }
            }
            
        }

        // Write an action using System.out.println()
        // To debug: System.err.println("Debug messages...");

        System.out.println(""+currLoss);
    }
}
