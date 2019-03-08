
/**
 * SciFiName gathers input from a user to generate a custom name that
 * sounds like it could be used in a science fiction book or movie.
 *
 * @author ckinnard
 * @version 3/4/16
 */
import java.util.Random;
public class SciFiName
{
    /**
     * All input that you privide should be at least three letters long
     * or the program may crash (but feel free to test this!)
     *
     * For best results, user lowercase letters and do not use spaces in your input
     */
    public static void main(String[] args)
    {
        String firstNameThree;
        String lastNameTwo;
        String firstSciName;
        String cityTwo;
        String schoolThree;
        String lastSciName;
        String relativeOneLetters;
        String relativeTwoLetters;
        String sciLocation;

        System.out.println("If you provide me some information I will provide a Science Fiction name for you.");
        System.out.println("Please have all responses  be at least three characters long.");
        System.out.println("For best results, user lowercase letters with no spaces.\n");

        // notice this methd (print) does not print a newline
        System.out.print("Enter your first name: ");
        String firstName = UserInput.getString();
        System.out.print("Enter your last name: ");
        String lastName = UserInput.getString();
        System.out.print("Enter the city where you or one of your parents were born: ");
        String city = UserInput.getString();
        System.out.print("Enter the name of your grammar school: ");
        String school = UserInput.getString();
        System.out.print("Enter the first name of a sibling or other relative: ");
        String relativeName1 = UserInput.getString();
        System.out.print("Enter the first name of a second sibling or relative: ");
        String relativeName2 = UserInput.getString();

        // generate a sciFi name

        firstNameThree = firstName.substring(0,3);
        lastNameTwo = lastName.substring(0,2);
        firstSciName = firstNameThree + lastNameTwo;

        cityTwo = city.substring(0,2);
        schoolThree = school.substring(0,3);
        lastSciName = cityTwo + schoolThree;


        Random rand = new Random();
        int firstRelative = rand.nextInt(relativeName1.length());
        int secondRelative = rand.nextInt(relativeName2.length());
        relativeOneLetters = relativeName1.substring(firstRelative, relativeName1.length());
        relativeTwoLetters = relativeName2.substring(secondRelative, relativeName2.length());
        sciLocation = relativeOneLetters + relativeTwoLetters;

        System.out.println("Hello " + firstSciName + " " + lastSciName + " of " + sciLocation + ". Weclome!");
    }
}


