package LeetCodeEasy;

class Solution {
    public String removeDuplicates(String s) {
        String str;
        boolean isContinue = true;
        
        while (isContinue) {
        	isContinue = false;
        		str = "";
        		for(int j = 0; j < s.length() - 2; j++){
                    if (s.charAt(j) != s.charAt(j+1))
                        str += Character.toString(s.charAt(j));
                    else {
                    	j += 2;
                    	isContinue = true;
                    }
                    	
                    
                    // Skip these two number
                }
        		
        		str += s.charAt(s.length() - 1);
        		s = str;
        }
        
        return s;
    }
}

public class LCQ1047 {
	public static void main(String[] args) {
		Solution sol = new Solution();
		System.out.println(sol.removeDuplicates("abbaca"));
	}
}
