package com.backend;

public class App 
{

    boolean checkPalindrome(String str){
        String reverse = "";
        for(int i = 0; i < str.length(); i++){
            reverse = str.charAt(i) + reverse;
        }
        return str.equalsIgnoreCase(reverse);
    }

    public String getPalindrome(String str){
        String max = "";
        System.out.println( "we got: " + str );
        for(int i = 0; i < str.length(); i++){
            for(int j = i; j <= str.length(); j++){
                String nstr = str.substring(i, j);
                System.out.println( "checking: " + nstr );
                if(checkPalindrome(nstr)){
                    System.out.println( "ispalindrome");
                    if(max.length() < nstr.length()){
                        System.out.println( max + " updated to: " + nstr );
                        max = nstr;
                    }
                }
            }
        }
        return max;
    }
    // public static void main( String[] args )
    // {
    //     App ob = new App();

    //     String str = ob.getPalindrome("asdfgh");
    //     
    // }
}
