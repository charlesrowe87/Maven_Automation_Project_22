package Day3_043022;

public class AI_02 {
    public static void main(String[] args) {
        //declare integer value
            int grade = 90;

            //when grade is 90 to 100 print A
            //when grade is 80 to 89 print  B
            //when grade is 70 to 79 print C
            //when grade is 60 to 69 print grade as D
            //when grade is below 60 print F

            if(grade >= 90 && grade <= 100){
                System.out.println( "When grade is 90 to 100 print grade as A ");
            } else if(grade >= 80 && grade <= 89){
                System.out.println( "When grade is 80 to 89 print grade as B ");
            } else if(grade >= 70 && grade <= 79){
                System.out.println( "When grade is 70 to 79 print grade as C ");
            } else if(grade >= 60 && grade <= 69) {
                System.out.println("When grade is 60 to 69 print grade as D ");
            } else {
                System.out.println("When grade is below 60 print grade as F");
            }//end of conditions
    }//end of main
}//end of java class
