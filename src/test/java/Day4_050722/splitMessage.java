package Day4_050722;

public class splitMessage {
    public static void main(String[] args) {
        //declare string variable
        String splitMessage = "My Name is John";

        //declare array of string to store string message
        String[] splitMessageArray = splitMessage.split(" ");

        //print out John to the console
        System.out.println("My first name is " + splitMessageArray[3]);

    }//end of main

}//end of java class
