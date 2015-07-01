/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package conwayMedium;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author Jahan
 */
public class ConWay {
        public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        int R = in.nextInt();
        int L = in.nextInt();
        
        List<Integer> them=new ArrayList<Integer>();
        List<Integer> them2=new ArrayList<Integer>();
        
        them.add(R);
        for(int i=0;i<L;i++){
            them2.clear();
            
            int count=0;
            int curv=-1;
            for(Integer v : them){
                if(curv!=v){
                    if(count>0){ them2.add(count); them2.add(curv);}                    
                    count=1;
                    curv=v;
                }else{
                    count++;
                }
                
                
            }
            if(count>0){ them2.add(count); them2.add(curv);}               
            
            List<Integer> buff=them;
            them=them2;
            them2=buff;
            
            System.err.println(""+them);
        }
        String r="";
        for(int k : them){
            r+=k+" ";
        }

        System.out.println(""+r.substring(0,r.length()-1));
    }
}
