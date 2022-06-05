package Day3_043022;

import java.util.ArrayList;

public class Loop_with_conditions {
    public static void main(String[] args) {
        //create an array list with fruits and print when fruit is only apple or grape
        ArrayList<String> fruits = new ArrayList<>();
        fruits.add("Apple");
        fruits.add("Grape");
        fruits.add("Orange");
        fruits.add("Strawberry");

        for (int i = 0; i < fruits.size(); i++){
            //with if conditions
            if(fruits.get(i) == "Apple"){
                System.out.println("My fruit is " + fruits.get(i));
            } else if(fruits.get(i) == "Grape"){
                System.out.println("My fruit is " + fruits.get(i));
            }
            /*

            //with or operator
            if(fruits.get(i).equalsIgnoreCase("ApPLe") || fruits.get(i) == "Grape") {
                System.out.println("My fruit is " + fruits.get(i));
            }

             */

        }//end of for loop

    }//end of main

}//end of java class
