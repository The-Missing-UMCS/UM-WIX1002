package PastYear2020.Q3;

import java.util.Scanner;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        while(true){
            String s = sc.nextLine();
            
            if (s.equals("quit")) 
            	break;
            
            if (!(containStartGene(s) && containEndGene(s))) {
                System.out.println("No gene.");
                continue;
            }
            
            ArrayList<String> genes = getGenes(s);
            
            if(genes.size() == 0) {
            	System.out.println("No gene is found");
            } else {
            	genes.forEach(System.out::println);
            }
        }
        
        sc.close();
    }
    
    public static ArrayList<String> getGenes(String s) {
    	ArrayList<String> ls = new ArrayList<>();
    	
        int start = s.indexOf("ATG");
        int n = s.length();
        
        while(start < n - 6 && start != -1) {
            String res = "";
            
            for(int i = start + 3; i <= n - 3; i += 3){
                if (containEndGene(s.substring(i, i+3)) && isValidGene(res)) 
                    break;
                res += s.substring(i, i + 3);
            }
            
            ls.add(res);
            start = s.indexOf("ATG", start + 3);
        }
        
        return ls;
    }
    
    public static boolean isValidGene(String s){
        return s.length() > 0 && s.length() % 3 == 0 && !containStartGene(s) && !containEndGene(s);
    }
    
    public static boolean containEndGene(String s) {
    	return s.contains("TAG") || s.contains("TAA") || s.contains("TGA");
    }
    
    public static boolean containStartGene(String s) {
    	return s.contains("ATG");
    }    
    
}