package PastYear2019.Q3;

import java.util.Scanner;


public class Tester {
	public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        while(true) {
        	System.out.print("Enter genome string [quit to stop]: ");
            String genome = sc.nextLine();
            
            if(genome.equals("quit"))
            	break;
            
           System.out.println(new Genome(genome).getGenes());
        }
        
        sc.close();
    }
}
