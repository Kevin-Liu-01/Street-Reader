package com.company;
public class StreetFinder {

//    public static void main(String[] args) {
//
//        Animal animal = new Animal("kevin");
//        System.out.println("animal1 name is " + animal.getName());
//
//        Animal anima2 = new Animal("matthew");
//        System.out.println("animal2 name is " + anima2.getName());
//
//
//
//
//        StreetFinderUtil.sayHi();
//
//
//        StreetFinderUtil util = new StreetFinderUtil(args);
//        util.printArgs();
//        util.processTarget();
//
//        String[] args2 = new String[] { "neighbor 259, kensINGTon Dr., morganville, NJ"};
//        StreetFinderUtil util2 = new StreetFinderUtil(args2);
//        util2.printArgs();
//        util2.processTarget();
//
//    }

    public static void main(String[] args) {
        Module m = new Module();
            System.out.println(m.x);
            System.out.println("m.x equals " + m.getX());
            System.out.println(m.getY());

        if (args.length == 0) { //For if the input is empty
            System.out.println("Please specify your address!");
            return;
        } else {
            String[] secondaryArgument=Seperator(args); //Split up the string by commas and spaces to seperate words
            switch (secondaryArgument[0]) {
                case "neighbor":
                    String upperState = secondaryArgument[5].toUpperCase();//Capitalize the state name
                    StringBuilder returnLocation = new StringBuilder(); //Put everything together.
                    System.out.println(returnLocation.append("Your address is: "+(Integer.parseInt(secondaryArgument[1])+1)+", "
                            + Capitalizer(secondaryArgument,"street")+" "+ Capitalizer(secondaryArgument, "drive")
                            +", "+Capitalizer(secondaryArgument, "city")+", "+upperState)); //Print out everything put together
                    break;
                case "state":
                    System.out.println("Your address is: "+secondaryArgument[5].toUpperCase()); //Prints out state; does not need capitalization method as states are fully capitalized
                    break;
                case "number":
                    System.out.println("Your address is: "+(Integer.parseInt(secondaryArgument[1]))); //Prints out house number
                    break;
                case "city":
                    System.out.println("Your address is: "+Capitalizer(secondaryArgument, "city")); //Prints out city
                    break;
                case "street":
                    StringBuilder completeStreet = new StringBuilder(); //String builder to put street name and drive together
                    System.out.println("Your address is: "+completeStreet.append(Capitalizer(secondaryArgument, "street")+" "+Capitalizer(secondaryArgument, "drive")));
                    break; //Prints out street name and drive
            }
        }
    }

    static String Capitalizer(String[] inputArray, String refString) { //For proper capitalization of words
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

    //
    static String[] Seperator(String[] initialArray) {
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

//    String stringHouseNumber = String.valueOf(Integer.parseInt(secondaryArgument[1])+1); //Get neighbor's house number
//    String streetOutput=Capitalizer(secondaryArgument, "street"); //Capitalize the street name
//    String driveOutput=Capitalizer(secondaryArgument, "drive"); //Capitalize the street abbreviation (Drive, etc.)
//    String cityOutput=Capitalizer(secondaryArgument, "city"); // Capitalize the city name
//    For the more refined coder ^^  =