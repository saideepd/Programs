import java.util.*;
import java.io.*;

class LeftFactoring{

    public static String [] prods, pr;
    public static String temp = null,root;

    public static void main(String[] args) throws IOException{ 
        System.out.println("Enter the production");
        BufferedReader bfr = new BufferedReader(new InputStreamReader(System.in));
        String x = bfr.readLine();
        pr = x.split("->");
        root = pr[0];
        prods = pr[1].split("/");
        int c = get_best_substring();
        factor_it(c);
    }

    private static int get_best_substring(){
        int i=0;
        getShortestString();
        String shortest_production = temp;
        while(i<shortest_production.length()){
            String check_letter = Character.toString(prods[0].charAt(i));
            for(int c=1; c<prods.length; c++){
                if(!check_letter.equals(Character.toString(prods[c].charAt(i)))){
                    return i;
                }
            }
            i++;           
        }
        return i;
    }

    private static void getShortestString(){
        int length = 1000;    
        for(int i=0; i<prods.length; i++){
            String x = prods[i];
            if(x.length() < length){
                length = x.length();
                temp = x;
            }
        }  
    }

    private static void factor_it(int lim){
        String [] remaining_letters = new String[prods.length];
        for(int i=0; i<prods.length; i++){
            String t = prods[i];
            remaining_letters[i] = t.substring(lim);
        }
        System.out.print(root+"->");
        System.out.print(temp.substring(0,lim)+"P\nP->");
        for(int i=0; i<remaining_letters.length; i++)
        {
            if(remaining_letters[i].equals(""))
                System.out.print("#/");
            else
            System.out.print(remaining_letters[i]+"/");
        }
    }

}
/*Enter the production
A->bcd/bcf
A->bcP
P->d/f/*/