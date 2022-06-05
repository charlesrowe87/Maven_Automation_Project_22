package Day2_042422;

import java.util.ArrayList;

public class ActionItem01 {
    public static void main(String[] args) {
        //set an arraylist for countries and loop/iterating through all values using for loop
        ArrayList<String> countries = new ArrayList<>();
        countries.add("USA");
        countries.add("Canada");
        countries.add("India");
        countries.add("Spain");
        countries.add("Egypt");

        //set and arraylist for country codes
        ArrayList<Integer> countryCode = new ArrayList<>();
        countryCode.add(1111);
        countryCode.add(2222);
        countryCode.add(3333);
        countryCode.add(4444);
        countryCode.add(5555);

        for (int i = 0; i < countries.size() ; i++){
        System.out.println("My country is " + countries.get(i) + " and my countryCode is " + countryCode.get(i));
        }//end of for loop
    }//end of main
}//end of java class
