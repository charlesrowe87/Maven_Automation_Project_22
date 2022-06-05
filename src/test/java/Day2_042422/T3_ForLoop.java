package Day2_042422;

import java.util.ArrayList;

public class T3_ForLoop {
    public static void main(String[] args) {
        //set an array list for cities and loop/iterating through all values using for loop
        ArrayList<String> cities = new ArrayList<>();
        cities.add("Brooklyn");
        cities.add("Queens");
        cities.add("Bronx");
        cities.add("Long Island");


        for (int i = 0; i < cities.size() ; i++){
            System.out.println("i is now " + i);
            //System.out.println("My city is " + cities.get(i));
        }//end of for loop

    }//end of main

}//end of java class
