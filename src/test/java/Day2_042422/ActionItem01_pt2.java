package Day2_042422;

public class ActionItem01_pt2 {
    public static void main(String[] args) {
        //create string array for regions and areaCodes
        String[] region = new String[]{"Brooklyn ", " Manhattan ", " New Jersey ", " Florida ", " California "};
        int[] areaCode = new int[]{718, 212, 201, 305, 310};

        //initialize starting point before calling while loop
        int i = 0;
        //define endpoint for while loop
        while (i < region.length){
            System.out.println("My region is " + region[i] + " and my area code is " + areaCode[i]);

       //incrementing
       i = i+1;
        }//end of while loop
    }//end of main
}//end of java class
