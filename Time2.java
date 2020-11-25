package university;

/**
 * This class Represents time by the minutes from midnight.
 * Values must represent a proper time.
 * @author : Noy Swisa 318851821
 * @version 19/03/20
 */
public class Time2 {
	

	// declarations
	private int _minFromMid ; 
	
	private final int DEFAULT_VAR = 0 ;
	private final int iS_TWO_NUM_DIGIT = 10 ;
	private final int HOURS_IN_DAY = 24 ;
	private final int MINUTES_IN_HOUR = 60;
	private final int MINUTES_IN_DAY = 1440 ;
	
	/**
	 * Constructs a Time2 object. 
	 * Construct a new time instance with the specified hour and minute . 
	 * hour should be between 0-23, otherwise it should be set to 0. 
	 * minute should be between 0-59, otherwise they should be set to 0.
	 * @param h
	 * @param m
	 */
	public Time2(int h,int m)
	{
		if(h < DEFAULT_VAR || h >= HOURS_IN_DAY)
			h = DEFAULT_VAR;
		if(m < DEFAULT_VAR || m >= MINUTES_IN_HOUR)
			m = DEFAULT_VAR;
		
		this._minFromMid = (h * MINUTES_IN_HOUR) + m ; 
		
	}
	
	/**
	 * Copy constructor for Time2. 
	 * Constructs a time with the same variables as another time.
	 * @param t
	 */
	public Time2(Time2 t)
	{
		this._minFromMid = t._minFromMid ;
	}
	
	/**
	 * Returns the hour of the time.
	 * @return The hour of the time
	 */
	public int getHour() {
		return _minFromMid/MINUTES_IN_HOUR;
	}
	
	/**
	 * Returns the minute of the time.
	 * @return The minute of the time
	 */
	public int getMinute() {
		return _minFromMid % MINUTES_IN_HOUR;
	}
	
	/**
	 * Changes the hour of the time. 
	 * If an illegal number is received hour will remain unchanged.
	 * @param h The new hour
	 */
	public void setHour(int h)
	{
		
		if(h >= 0 && h < HOURS_IN_DAY)
			this._minFromMid = (h * MINUTES_IN_HOUR) + this.getMinute();
		
			 
	}
	
	/**
	 * Changes the minute of the time. 
	 * If an illegal number is received minute will remain unchanged.
	 * @param m The new minute
	 */
	public void setMinute(int m)
	{
		if(m >= DEFAULT_VAR && m < MINUTES_IN_HOUR)
			this._minFromMid = (this.getHour() * MINUTES_IN_HOUR) + m ;
			 
	}
	
	/**
	 * Return the amount of minutes since midnight.
	 * @return amount of minutes since midnight.
	 */
	public int minFromMidnight()
	{
		return this._minFromMid;
	}
	
	/**
	 * Checks if the received time is equal to this time.
	 * @param other The time to be compared with this time
	 * @return True if the received time is equal to this time
	 */
	public boolean equals (Time2 other)
	{
		return(this._minFromMid == other._minFromMid);
	}
	
	/**
	 * Checks if this time is  before  a received time.
	 * @param other he time to check if this time is before
	 * @return True if this time is before other time
	 */
	public boolean before (Time2 other)
	{
		return(this._minFromMid < other._minFromMid) ;
	}
	
	/**
	 * Checks if this time is after a received time.
	 * @param other The time to check if this time is after
	 * @return True if this time is after other time
	 */
	public boolean after (Time2 other)
	{
		return !this.before(other);
	}
	
	/**
	 * Calculates the difference (in minutess) between two times.
	 * @param The time to check the difference with. Assumption: this time is after other time
	 * @return int difference in minutes
	 */
	public int difference(Time2 other)
	{
		return (this._minFromMid - other._minFromMid);
	}
	
	/**
	 * Returns a string representation of this time(hh:mm).
	 */
	public String toString()
	{
		int h = this.getHour();
		int m = this.getMinute();
		String hour = String.valueOf(h);
		String minute = String.valueOf(m);
		String zero = String.valueOf(DEFAULT_VAR);
		
		//adding '0' to minute/hour if they are not 2 digit num
		if (h<iS_TWO_NUM_DIGIT )
			hour = zero + hour ; 
		if (m<iS_TWO_NUM_DIGIT)
			minute = zero + minute ; 
		return hour + ":" + minute ;		
	}
	
	/**
	 * Adds num Minutes to time.
	 * @param num The number of minutes to add
	 * @return the update time
	 */
	public Time2 addMinutes(int num)
	{
		int newObjHours = DEFAULT_VAR;
		int newObjminutes = DEFAULT_VAR;
		
		int nowTimeInMinutes = this.minFromMidnight();
		int newObjInMinuts = (nowTimeInMinutes + num)%MINUTES_IN_DAY ;
		
		if (newObjInMinuts < DEFAULT_VAR)
			newObjInMinuts = MINUTES_IN_DAY + newObjInMinuts ;
			
		
		newObjHours = newObjInMinuts / MINUTES_IN_HOUR;
		newObjminutes = newObjInMinuts % MINUTES_IN_HOUR;	
	
		return new Time2(newObjHours,newObjminutes);

	}

	
	
	
	
	public static void main(String[] args) {
		 System.out.println("\n********** Test Time2 - Started **********\n");
	        System.out.println("\n1. Testing Constructors and toString:");
	        Time2 t1 = new Time2(17, 45);
	        System.out.println("\tt1=" + t1);
	        Time2 t2 = new Time2(t1);
	        System.out.println("\tt2=" + t2);
	        
	        System.out.println("\n2. Testing accessors and mutators:");
	        t1.setHour(20);
	        t1.setMinute(10);
	        System.out.println("\tt1=" + t1);
	        System.out.println("\tHour   of t1=" + t1.getHour());
	        System.out.println("\tMinute of t1=" + t1.getMinute());
	        
	        System.out.println("\n3. Testing minFromMidnight method:");
	        t1 = new Time2(10, 15);
	        System.out.println("\tt1=" + t1);
	        System.out.println("\tMinutes from midnight of t1=" + t1.minFromMidnight());
	       
	        System.out.println("\n4. Testing equals method:");
	        Time2 t3=new Time2(12, 34);
	        Time2 t4=new Time2(23, 45);
	        System.out.println("\tt3=" + t3);
	        System.out.println("\tt4=" + t4);
	        if(t3.equals(t4))
	             System.out.println("\tt3 is the same time as t4");
	        else 
	             System.out.println("\tt3 isn't the same time as t4");
	             
	        System.out.println("\n5. Testing before method:");
	        if(t3.before(t4))
	             System.out.println("\tt3 is before t4");        
	        else 
	             System.out.println("\tt3 isn't before t1");  
	             
	        System.out.println("\n6. Testing after method:");
	        if(t4.after(t3))
	             System.out.println("\tt4 is after t3");
	        else 
	             System.out.println("\tt4 isn't after t3");     
	             
	        System.out.println("\n7. Testing difference method:");
	        t1=new Time2(11, 25);
	        t2=new Time2(10, 15);
	        System.out.println("\tt1=" + t1);
	        System.out.println("\tt2=" + t2);
	        System.out.println("\tThe difference in minutes between times t1 and t2 is : "+t1.difference(t2));
	        
	        System.out.println("\n8. Testing addMinutes method:");
	        System.out.println("\tt1=" + t1);
	        System.out.println("\tAdding 10 minutes to t1="+t1.addMinutes(10));
	        
	        System.out.println("\n********** Test Time2 - Finished **********\n");
		
	}

}
