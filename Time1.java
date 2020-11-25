package university;

/**
 * This class Represents time - hours:minutes.
 * @author : Noy Swisa 318851821
 * @version 18/03/20
 */
public class Time1 {
	

	// declarations
	private int _hour ;
	private int _minute ;
	
	private final int DEFAULT_VAR = 0 ;
	private final int iS_TWO_NUM_DIGIT = 10 ;
	private final int HOURS_IN_DAY = 24 ;
	private final int MINUTES_IN_HOUR = 60;
	private final int MINUTES_IN_DAY = 1440 ;
	
	//constructor definitions
	/**
	 * Constructs a Time1 object. 
	 * Construct a new time instance with the specified hour and minute .
	 * hour should be between 0-23, otherwise it should be set to 0. 
	 * minute should be between 0-59, otherwise it should be set to 0.
	 * @param h the hour of the time
	 * @param m the minute of the time
	 */
	public Time1(int h,int m)
	{
		if(h < DEFAULT_VAR || h >= HOURS_IN_DAY)
			h = DEFAULT_VAR;
		if(m < DEFAULT_VAR || m >= MINUTES_IN_HOUR)
			m = DEFAULT_VAR;
		this._hour = h ;
		this._minute = m;
		
	}
	
	/**
	 * Copy constructor for Time1.
	 * Construct a time with the same instance variables as another time
	 * @param t The time object from which to construct the new time
	 */
	public Time1(Time1 t)
	{
		this._hour = t._hour ;
		this._minute = t._minute;
	}
	
	//method definitions
	
	/**
	 * Returns the hour of the time.
	 * @return The hour of the time
	 */
	public int getHour() {
		return _hour;
	}
	
	/**
	 * Returns the minutes of the time.
	 * @return The minutes of the time
	 */
	public int getMinute() {
		return _minute;
	}

	/**
	 * Changes the hour of the time. 
	 * If an illegal number is received hour will be unchanged.
	 * @param num The new hour
	 */
	public void setHour(int num)
	{
		if(num >= DEFAULT_VAR && num < HOURS_IN_DAY)
			this._hour = num;
		
			 
	}
	
	/**
	 * Changes the minute of the time. 
	 * If an illegal number is received minute will be unchanged.
	 * @param num The new minute
	 */
	public void setMinute(int num)
	{
		if(num >= DEFAULT_VAR && num < MINUTES_IN_HOUR)
			this._minute = num;
		
			 
	}
	
	/**
	 * Returns a string representation of this time ("hh:mm").
	 * @return String representation of this time ("hh:mm").
	 */
	public String toString()
	{
		String hour = String.valueOf(this._hour);
		String minute = String.valueOf(this._minute);
		String zero = String.valueOf(DEFAULT_VAR);
		
		//adding '0' if the hour/minute isnt 2 num digit
		if (this._hour < iS_TWO_NUM_DIGIT )
			hour = zero + hour ; 
		if (this._minute < iS_TWO_NUM_DIGIT)
			minute = zero + minute ; 
		return hour + ":" + minute ;		
	}
	
	/**
	 * Return the amount of minutes since midnight.
	 * @return amount of minutes since midnight.
	 */
	public int minFromMidnight()
	{
		int hourToMinutes = this._hour * MINUTES_IN_HOUR ;
		int minutes = this._minute ; 
		int minutsAfterMidnight = hourToMinutes + minutes ;
		return minutsAfterMidnight ; 
	}
	
	/**
	 * Checks if the received time is equal to this time.
	 * @param other The time to be compared with this time
	 * @return true if the received time is equal to this time
	 */
	public boolean equals (Time1 other)
	{
		return(this._hour == other._hour && this._minute == other._minute);
	}
	
	/**
	 * Checks if this time is before a received time.
	 * @param other The time to check if this time is before
	 * @return true if this time is before other time
	 */
	public boolean before (Time1 other)
	{
		int myObjectTime = this.minFromMidnight();
		int otherObjectTime = other.minFromMidnight();
		return (myObjectTime < otherObjectTime) ;
	}
	
	/**
	 * Check if this time is after a received time.
	 * @param other The time to check if this point is after.
	 * @return True if this time is after other time
	 */
	public boolean after (Time1 other)
	{
		return !this.before(other);
	}
	
	/**
	 * Calculates the difference (in minutes) between two times. 
	 * Assumption: this time is after other time.
	 * @param other The time to check the difference to
	 * @return int difference in minutes
	 */
	public int difference (Time1 other)
	{
		return this.minFromMidnight()-other.minFromMidnight();
	}

	/**
	 * Adds num Minutes to time.
	 * @param num The number of minutes to add
	 * @return the update time
	 */
	public Time1 addMinutes (int num)
	{
		int newObjHours = DEFAULT_VAR;
		int newObjminutes = DEFAULT_VAR;
		
		int nowTimeInMinutes = this.minFromMidnight();
		int newObjInMinuts = (nowTimeInMinutes + num) % MINUTES_IN_DAY ;
		
		if (newObjInMinuts < DEFAULT_VAR) // check if the number of minuts is negitive - so it will go  "back"
			newObjInMinuts = MINUTES_IN_DAY + newObjInMinuts ;
			
		
		newObjHours = newObjInMinuts / MINUTES_IN_HOUR;
		newObjminutes = newObjInMinuts % MINUTES_IN_HOUR;	
	
		return new Time1(newObjHours,newObjminutes);
		
		
	}
	
	
	
	
	
	public static void main(String[] args)
	{
		System.out.println("\n********** Test Time1 - Started **********\n");
        System.out.println("\n1. Testing Constructors and toString:");
        Time1 t1 = new Time1(17, 45);
        System.out.println("\tt1=" + t1);
        Time1 t2 = new Time1(t1);
        System.out.println("\tt2=" + t2);
        
        System.out.println("\n2. Testing accessors and mutators:");
        t1.setHour(2);
        t1.setMinute(10);
        System.out.println("\tt1=" + t1);
        System.out.println("\tHour   of t1=" + t1.getHour());
        System.out.println("\tMinute of t1=" + t1.getMinute());
        
        System.out.println("\n3. Testing minFromMidnight method:");
        t1 = new Time1(10, 15);
        System.out.println("\tt1=" + t1);
        System.out.println("\tMinutes from midnight of t1=" + t1.minFromMidnight());
       
        System.out.println("\n4. Testing equals method:");
        Time1 t3=new Time1(12, 34);
        Time1 t4=new Time1(23, 45);
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
        t1=new Time1(11, 25);
        t2=new Time1(10, 15);
        System.out.println("\tt1=" + t1);
        System.out.println("\tt2=" + t2);
        System.out.println("\tThe difference in minutes between times t1 and t2 is : "+t1.difference(t2));
        
        System.out.println("\n8. Testing addMinutes method:");
        System.out.println("\tt1=" + t1);
        System.out.println("\tAdding 10 minutes to t1="+t1.addMinutes(10));
        
        System.out.println("\n********** Test Time1 - Finished **********\n");
    
		
		
		
		
	}
	
	
}
