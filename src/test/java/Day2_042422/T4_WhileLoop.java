package Day2_042422;

public class T4_WhileLoop {
    public static void main(String[] args) {
                String[] zipCodes = new String[]{"11215" , "11223" , "11204" , "11213"};
                int[] houseNumber = new int[]{179,209,1720,157};

                //initialize your starting point before calling while loop
                int i = 0;
                //define the end point in the while loop
                while (i < houseNumber.length){
                    System.out.println("my zipcode is " + zipCodes[i] + " and house number " + houseNumber[i]);

                    //incrementing
                    i = i +1;

                }//end of while loop

            }//end of main

}//end of java class