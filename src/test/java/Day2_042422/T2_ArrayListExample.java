package Day2_042422;

import java.util.ArrayList;

public class T2_ArrayListExample {
    public static void main(String[] args) {
        //create Arraylist for Countries
        ArrayList<String> countries = new ArrayList<>();
        countries.add("USA");
        countries.add("Bangladesh");
        countries.add("India");
        countries.add("Canada");
        countries.add("Pakistan");

        //for (int i = 0;i < countries.size();i++){
        //System.out.println("My Country is " + countries.get(i));
        //}//end of for loop


        //I want to print 4th value from the list
        System.out.println("My last country is " + countries.get(4) + " and my third country is " + countries.get(2));


    }//end of main

}//end of java class
