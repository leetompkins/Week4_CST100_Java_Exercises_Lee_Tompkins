/* Summary: A Time & TestTime class, with constructors for a time object (current time)
 * (elapsed time) (specified time), three getter methods, and a setter method
 * File: TestTime.java
 * Author Lee Tompkins 
 * Date: Jul 12 2016
 */

//import java.util.concurrent.TimeUnit;

public class TestTime {

	public static void main(String[] args) {
		Time time1 = new Time();
		Time time2 = new Time(555550000);
		System.out.println("The current time is " + time1.getHour() + ":" + time1.getMinute() + ":" + time1.getSecond() + " hours:minutes:seconds past Jan 1 1970 at Midnight");
		System.out.println("The specified time is " + time2.getHour() + ":" + time2.getMinute() + ":" + time2.getSecond() + " hours:minutes:seconds past Jan 1 1970 at Midnight");
	}

}




// void to set



class Time {
	// Data Fields 
	private int hour;
	private int second;
	private int minute;
	
	
	
	// No args constructor for current time
	public Time(){
		long totalMillis = System.currentTimeMillis();	
		hour = (int) (totalMillis / 1000) % 60;
		minute = (int) ((totalMillis / (1000 * 60)) % 60);
		second = (int) ((totalMillis / (1000 * 60 * 60)) % 24);
	} 

	// Constructor that constructs time with specified hour minute and second
	public Time(long elapsedMillis){
		hour = (int) (elapsedMillis / 1000) % 60;
		minute = (int) ((elapsedMillis / (1000 * 60)) % 60);
		second = (int) ((elapsedMillis / (1000 * 60 * 60)) % 24);
	}
	
	// Constructor for Time with specified time in hour minute second
	public Time(int newHour, int newMinute, int newSecond) {
		hour = newHour;
		minute = newMinute;
		second = newSecond;
	}
	
	// Getter methods for hours, minutes, and seconds
	public int getHour(){
		return hour;
	}
	public int getMinute() {
		return minute;
	}
	public int getSecond() {
		return second;
	}
	//Setter method for setting time using milliseconds
	
	public void setTime(long elapseTime) {
		hour = (int) (elapseTime / 1000) % 60;
		minute = (int) ((elapseTime / (1000 * 60)) % 60);
		second = (int) ((elapseTime / (1000 * 60 * 60)) % 24);
	}



}