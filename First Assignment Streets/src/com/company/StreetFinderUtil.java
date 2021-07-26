package com.company;

public class StreetFinderUtil {
    private String[] args;

    public StreetFinderUtil(String[] args) {
        this.args = args;
    }

    public void printArgs() {
        for (String s: args ) {
            System.out.println("arg is " + s);
        }
    }

    public static void sayHi() {
        System.out.println("Hi Im StreetFinder Util class");
    }


    public void processTarget() {
        if (args.length == 0) { //For if the input is empty
            System.out.println("Please specify your address!");
            return;
        } else {
            String[] secondaryArgument=Seperator(args); //Split up the string by commas and spaces to seperate words
            switch (secondaryArgument[0]) {
                case "neighbor":
                    String upperState = secondaryArgument[5].toUpperCase();//Capitalize the state name
                    StringBuilder returnLocation = new StringBuilder(); //Put everything together.
                    System.out.println(returnLocation.append("Your address is: "+String.valueOf(Integer.parseInt(secondaryArgument[1])+1)+", "
                            +Capitalizer(secondaryArgument,"street")+" "+ Capitalizer(secondaryArgument, "drive")
                            +", "+Capitalizer(secondaryArgument, "city")+", "+upperState)); //Print out everything put together
                    break;
                case "state":
                    System.out.println("Your address is: "+secondaryArgument[5].toUpperCase()); //Prints out state; does not need capitalization method as states are fully capitalized
                    break;
                case "number":
                    System.out.println("Your address is: "+String.valueOf(Integer.parseInt(secondaryArgument[1]))); //Prints out house number
                    break;
                case "city":
                    System.out.println("Your address is: "+Capitalizer(secondaryArgument, "city")); //Prints out city
                    break;
                case "street":
                    StringBuilder completestreet = new StringBuilder(); //String builder to put street name and drive together
                    System.out.println("Your address is: "+completestreet.append(Capitalizer(secondaryArgument, "street")+" "+Capitalizer(secondaryArgument, "drive")));
                    break; //Prints out street name and drive
            }
        }
    }

     String Capitalizer(String[] inputArray, String refString) { //For proper capitalization of words
        int refNumber=0;
        switch(refString){
            case "street":
                refNumber=2;
                break;
            case "drive":
                refNumber=3;
                break;
            case "city":
                refNumber=4;
                break;
        }
        String Input = inputArray[refNumber].substring(1);
        String Output = inputArray[refNumber].substring(0, 1).toUpperCase() + Input.toLowerCase(); //Take the capitalized first letter plus the rest of the lowercase text

        return Output;
    }

    String[] Seperator(String[] initialArray) {
        String initialArgument = initialArray[0];
        String[] splitWords = initialArgument.split(",");
        StringBuffer sb = new StringBuffer();
        for (String s : splitWords) {
            sb.append(s); }//put the string back together
        String restructured = sb.toString();
        String[] secondaryArgument2 = restructured.split(" "); //split by spaces
        return secondaryArgument2;
    }


}
