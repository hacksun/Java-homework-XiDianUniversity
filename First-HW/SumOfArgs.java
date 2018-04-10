/*SunHui
15130120141
*/
import java.util.*;
public class SumOfArgs {
	
public static void main(String[] args) {

	int sum=0;


		for(String arg:args) {//this is foreach method
			if(arg.matches("[-+]?\\d+")){
			//the string '?' means that matches the preceding string '-' and '+' once or none, '\\d' means the string is [0-9] which equals to an interge, meanwhile, 
			//the symbol '+' represents that there will be more than one interge.
			sum += Integer.parseInt(arg); 
			}
		}//if arg is a float or some other kinds of  arguments, what should I do?
		//well, one of my friends proposes a novel method that I don't know, he uses regular expression to slove this problem which is easier than what I've thought.
		
	System.out.println(sum);

    }
}