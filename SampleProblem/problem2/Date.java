/*
 * Date.java - a blueprint class for objects that represent
 * an individual date.
 */
package problem2;
import java.time.LocalDate;
public class Date {
    /* a class constant for the smallest allowed year */
    public static final int MIN_YEAR = 1583; 
    
    // task 3
    private int date,month,year;

    // task 4 - implement a constructor
    public Date(int date,int month,int year){
        this.date = date;
        this.month = month;
        this.year = year;
    }

    // task 5 -> implement accesor 
    public int getMonth(){
        return this.month;
    }

    public int getDate(){
        return this.date;
    }

    public int getYear(){
        return this.year;
    }

    public String getMonthName(){
        return this.MONTHS[this.month];
    }

    public String getDayOfWeekName(){
        return this.DAYS_OF_WEEK[this.dayOfWeekNumber(this.month, this.date, this.MIN_YEAR)];
    }
    public String toString(){
        return this.getDayOfWeekName() + ", " + this.getMonthName() + " " +this.date + "," + this.year;
    }

    // task 6 -> add method to compare to date objects

    public boolean isEqual(Date m) {
        LocalDate date1 = LocalDate.of(this.getYear(), this.getMonth(), this.getDate());
        LocalDate date2 = LocalDate.of(m.getYear(), m.getMonth(), m.getDate());
        return date1.compareTo(date2) == 0;
    }

    public boolean isBefore(Date m){
        LocalDate date1 = LocalDate.of(this.getYear(), this.getMonth(), this.getDate());
        LocalDate date2 = LocalDate.of(m.getYear(), m.getMonth(), m.getDate());
        return date1.compareTo(date2) < 0;
    }

    public boolean isAfter(Date m) {
        LocalDate date1 = LocalDate.of(this.getYear(), this.getMonth(), this.getDate());
        LocalDate date2 = LocalDate.of(m.getYear(), m.getMonth(), m.getDate());
        return date1.compareTo(date2) > 0;
    }

    
    /*
     * A class-constant array containing the names of the months.
     * The positions of the names in the array correspond to the 
     * numbers of the months. For example, "January" is at position 1
     * in the array because its month number is 1, and "December" is in 
     * position 12 because its month number is 12.
     * The string "none" appears in position 0, because there 
     * is no month that corresponds to the number 0.
     */
    public static final String[] MONTHS = {"none", "January", "February",
        "March", "April", "May", "June", "July", "August",
        "September", "October", "November", "December"};
    
    /*
     * A class-constant array containing the number of days in each
     * month. Here again, the positions of the values correspond to the 
     * numbers of the months. For example, NUM_DAYS[1] is 31, because
     * January (month 1) has 31 days, and NUM_DAYS[2] is 28, because
     * February usually has 28 days.
     * -1 appears in position 0, because there is no month that 
     * corresponds to the number 0.
     */
    public static final int[] NUM_DAYS = {-1, 31, 28, 31, 30, 31, 30,
        31, 31, 30, 31, 30, 31};
    
    /*
     * A class-constant array containing the names of the days of the week.
     */
    public static final String[] DAYS_OF_WEEK = {"Sunday", "Monday",
         "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday"};
    
    /*
     * dayOfWeekNumber - a static helper method that takes a month number, 
     * day number, and year as parameters, and returns the *number* of the
     * day of the week on which the corresponding date falls:
     * 0 for Sunday, 1 for Monday, 2 for Tuesday, etc.
     * The algorithm for computing the appropriate number comes from 
     * Robert Sedgewick and Kevin Wayne.
     */
    public static int dayOfWeekNumber(int month, int day, int year) {
        int y0 = year - (14 - month)/12;
        int x = y0 + y0/4 - y0/100 + y0/400;
        int m0 = month + 12*((14 - month)/12) - 2;
        
        return (day + x + (31*m0)/12) % 7;
    }    
    
    /* 
     * Implement the rest of the class below,
     * as specified in the assignment.
     */
    // TASK 2
    public static boolean isLeapYear(int year) {
        return year % 4 == 0;
    }

    public static int numDaysInMonth(int month, int year){
        if(isLeapYear(year) && month == 2) return 29;
        else return NUM_DAYS[month];
    }
}
