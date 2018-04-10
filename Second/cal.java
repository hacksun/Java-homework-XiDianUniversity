import java.util.*;

public class cal {

	final static String[] DAYS ={ "Sunday",
				  "Monday",
				  "Tuesday",
				  "Wednesday",
				  "Thursday",
				  "Friday",
				  "Saturday" };

    /**
     *  define an array of strings that can translate between integer
     *  MONTH and strings. According to a Calendar object, the first
     *  month (January) is month 0.
     */

    static final String[] MONTHS = { "January",
				     "February",
				     "March",
				     "April",
				     "May",
				     "June",
				     "July",
				     "August",
				     "September",
				     "October",
				     "November",
				     "December"};

    /**
     * main can handle a month day and year specified on the command
     * line (all as integers). If it find acceptable values on the
     * command line this program uses today's date.
     *
     * main figures out the date for the following day, and prints it out.
     */

	/**
	 * daysInMonth looks up the number of days in the current month
	 * in a Calendar object. This takes care of leap year for us!
	 * @param c is the Calendar object holding the date we want to
	 *          find out about.
	 * @return the number of days in the month. 
	 */
	static int daysInMonth( Calendar c) {
		return(c.getActualMaximum(Calendar.DAY_OF_MONTH));
	}


	/**
	 * dayName looks up the string version of the day of the week
	 * for the date in a Calendar object
	 * @param c the Calendar object holding the date
	 * @return an string holding the (english) day of the week
	 */

	static String dayName( Calendar c) {
		// Need to subtract 1, since the first DAY_OF_WEEK is 1 !
		return(DAYS[c.get(Calendar.DAY_OF_WEEK)-1]);
	}	

	/**
	 * monthName looks up the string version of the month
	 * for the date in a Calendar object
	 * @param c the Calendar object holding the date
	 * @return an string holding the (english) month
	 */

	static String monthName(Calendar c) {
		return(MONTHS[c.get(Calendar.MONTH)]);
    }

	cal(int month,int year){
		Calendar c = Calendar.getInstance();

		c.clear();//clear the memory to avoid mistake.
		
		c.set(Calendar.YEAR,year);
		
		c.set(Calendar.MONTH,month);
		int day=daysInMonth(c);
		int ex=c.get(Calendar.DAY_OF_WEEK);
		
		String MonthName=monthName(c);
		
		System.out.println(MonthName+" "+year);
		System.out.println("Su"+"\t"+"Mo"+"\t"+"Tu"+"\t"+"We"+"\t"+"Th"+"\t"+"Fr"+"\t"+"Sa");
		
		for(int i=1;i<ex;i++){
			System.out.print("  ");
		}

		//System.out.print("  ");
		
		for(int i=1;i<=day;i++){
			System.out.print(i+"\t");
			/*
			if (i<10){
				
				System.out.print("\t"+i+"\t");
				
			}else{
				System.out.print(i+"\t");
			}
			*/
			if(ex==7){
				System.out.println();
				ex=1;
			}else{
				ex++;
			}
		}
	}



	static int j=0;

	public static void main(String[] args) {
		Calendar c=Calendar.getInstance();
		
		for (String arg:args ) {
			j++;
		}
		
		if(j==0){
			int year=c.get(Calendar.YEAR);
			int month=c.get(Calendar.MONTH);
			cal calendar=new cal(month,year);
		}else{
		int year = Integer.parseInt(args[1]);
		int month = Integer.parseInt(args[0])-1;
		cal calendar = new cal(month,year);
		}
	}
}
