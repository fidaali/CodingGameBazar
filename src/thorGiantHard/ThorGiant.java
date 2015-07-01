/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package thorGiantHard;

import java.util.Scanner;

/**
 *
 * @author Jahan
 */
public class ThorGiant {
        public static void mark(boolean[] dirocc, int TX,int TY,int X,int Y){
                if (Math.abs(X - TX) <= 1 && Math.abs(Y - TY) <= 1) {
                    int dx = X - TX;
                    int dy = Y - TY;
                    if (dx < 0) {
                        dx = -1;
                    }
                    if (dx > 0) {
                        dx = 1;
                    }
                    if (dy < 0) {
                        dy = -1;
                    }
                    if (dy > 0) {
                        dy = 1;
                    }

                    dirocc[4] = true;

                    dirocc[(dx + 1) + 3 * (dy + 1)] = true;
                    //System.err.print("giant rel " + dx + " " + dy + " |");
                }        
    }

    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        int TX = in.nextInt();
        int TY = in.nextInt();

        int t = 0;
        // game loop
        while (true) {

            boolean[] dirocc = new boolean[]{
                false, false, false,
                false, false, false,
                false, false, false
            };
            if(TX<2){
                for(int i=0;i<3;i++){
                    dirocc[i*3]=true;
                }
            }
            if(TX > 38){
                for(int i=0;i<3;i++){
                    dirocc[i*3 +2]=true;
                }                
            }
            
            if(TY<2){
                for(int i=0;i<3;i++){
                    dirocc[i]=true;
                }
            }
            if(TY > 16){
                for(int i=0;i<3;i++){
                    dirocc[i+2*3]=true;
                }                
            }               
            String[] dirS = new String[]{
                "NW", "N", "NE",
                "W", "WAIT", "E",
                "SW", "S", "SE"
            };

            int H = in.nextInt(); // the remaining number of hammer strikes.
            int N = in.nextInt(); // the number of giants which are still present on the map.

            int giantPerHam = N / H;
            if (giantPerHam < 1) {
                giantPerHam = 1;
            }
            int countGiantToDie = 0;

            for (int i = 0; i < N; i++) {
                int X = in.nextInt();
                int Y = in.nextInt();

                if (Math.abs(X - TX) <= 4 && Math.abs(Y - TY) <= 4) {
                    countGiantToDie++;
                }
                
                
                for(int ix=-2;ix<5;ix++){
                    for(int jx=-2;jx<5;jx++){
                        mark(dirocc,TX,TY,X+ix,Y+jx);
                    }
                }       
                System.err.println("Giant at " + X + " " + Y);
            }

            // Write an action using System.out.println()
            // To debug: System.err.println("Debug messages...");
            System.err.println("Will die " + countGiantToDie + " needs to die " + giantPerHam);
            System.err.println("THOR IS " + TX + " " + TY);
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    System.err.print(dirocc[j + 3 * i] + "" + dirS[j + 3 * i] + " |");
                }
                System.err.println();
            }
            if (dirocc[4] == false) {
                System.out.println("WAIT"); // The movement or action to be carried out: WAIT STRIKE N NE E SE S SW W or N
            } else {
                if (countGiantToDie >= giantPerHam) {
                    System.out.println("STRIKE");
                } else {

                    boolean found=false;
                    for (int i = 0; i < 9; i++) {
                        if (dirocc[i] == false) {

                            int k = i % 3;
                            int l = i / 3;
                            TX += k - 1;
                            TY += l - 1;
                            System.out.println("" + dirS[i]);
                            found=true;
                            break;
                        }
                    }
                    if(!found){
                        System.out.println("STRIKE");
                        System.err.println("NO ESCAPE FOUND");
                    }
                }
            }

        }
    }
}
