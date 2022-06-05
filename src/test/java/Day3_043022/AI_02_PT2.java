package Day3_043022;

import java.util.ArrayList;

public class AI_02_PT2 {
    public static void main(String[] args) {
        //create an arrayList with cities
        ArrayList<String> cities = new ArrayList<>();
        cities.add("Brooklyn");
        cities.add("Queens");
        cities.add("Manhattan");
        cities.add("Staten Island");

        //declare for loop
        for (int i = 0; i < cities.size(); i++) {
            //with else if conditions print city if it is Brooklyn or Manhattan
            if (cities.get(i) == "Brooklyn") {
                System.out.println("My city is " + cities.get(i));
            } else if (cities.get(i) == "Manhattan") {
                System.out.println("My City is " + cities.get(i));
            }//end of else if conditions
            //with or operator print Brooklyn or Manhattan
            // if (cities.get(i) == "Brooklyn" || cities.get(i) == "Manhattan") {
            //System.out.println("My city is " + cities.get(i));

        }//end of for loop
    }//end of main
}//end of java class
