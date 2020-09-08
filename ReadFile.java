/**
 * 🦄
 *
 * @author Viktoria Cseke
 * R00180598 Feb 2020
 */
import java.io.File;
import java.io.FileNotFoundException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;
public class ReadFile {
    //private ActivityList activityList;
    //private ActivityList activityList;

    public void readFile(String filename,ArrayList<Activity> actList) {
        try {
            File f = new File(filename);
            Scanner scanner = new Scanner(f);
            while (scanner.hasNextLine()) {
                //read first line and process it
                String inputLine = scanner.nextLine();
                if (inputLine.length() != 0) {//ignored if blank line
                    processLine(inputLine,actList);
                }
            }
        }
        //if the file is not found, stop with system exit
        catch (FileNotFoundException fnf){
            System.out.println( filename + " not found ");
            System.exit(0);
        }
    }

    /**
     * Processes line, extracts data, creates object
     * and adds to list
     * Checks for non-numeric year and missing items
     * Will still crash if name entered without a space
     * @param line the line to be processed
     */
    private void processLine(String line,ArrayList<Activity> actList) {
        try {
            String parts [] = line.split(",");
            //Activity act = new Activity();

            String activity=parts[0];
            int points= Integer.parseInt(parts[1]);
            LocalDate userDate=LocalDate.parse(parts[2]);
            String week=parts[3];


            //create an Activity object and add to the list
            Activity a=new Activity();
            a.setActivity(activity);
            a.setWeek(week);
            a.setPoints(points);
            a.setUserDate(userDate);

            //this.add(a);
            System.out.println(a);
            actList.add(a);

        }
        //for these two formatting errors, ignore lines in error and try and carry on
        //this catches trying to convert a String to an integer
        // if used  ………………….
        catch (NumberFormatException nfe) {
            String error = "Number conversion error in '" + line + "'  - "
                    + nfe.getMessage();
            System.out.println(error);
        }
        //this catches missing items if only one or two items
        //other omissions will result in other errors
        catch (ArrayIndexOutOfBoundsException air) {
            String error = "Not enough items in  : '" + line
                    + "' index position : " + air.getMessage();
            System.out.println(error);
        }

    }

}
