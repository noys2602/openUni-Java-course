package university;

import java.util.Random;

/**
 * The class represents a Railway station
 * @author : Noy Swisa 318851821
 * @version 31/03/20
 */



public class RailwayStation {
	
	private Train [] _station;
	private int _noOfTrs ;
	private final int MAX_TRAINS = 100;
	
	
	/**
	 * Constructor of class RailwayStation Constructs a new-default Railway station. 
	 * It sets 100 trains in a day for a station .
	 * It sets 0 trains in the station
	 */
	public RailwayStation() 
	{
		this._station = new Train[MAX_TRAINS];
		this._noOfTrs = 0 ;
	}
	
	
	/**
	 * Add a train to the train station (if she is'nt already exist)
	 * The train will be added to the first free place in the staion(if there is one)
	 * @param f the new train to add to the station
	 * @return true if the new train is successfully added, 
	 * else return false if there are no trains or if the train is already exists
	 */
	public boolean addTrain(Train f) // 4
	{
	        if (f==null)
	           return false ;
	           
		if (this._noOfTrs == this.MAX_TRAINS) // checks if station is full
			return false ; 
		
		for (int i = 0; i<this._noOfTrs;i++)
			if (this._station[i].equals(f)) //checks if train already exist
				return false;
		
		this._station[this._noOfTrs] = new Train(f) ; // adding the new train
		this._noOfTrs++ ;
		return true;
		
	}
	
	/**
	 * Remove a train from the train station (if she already exist) 
	 * In the place of the deleted train we will enter the last train.
	 * @param f the train that we remove from the station
	 * @return true if the removing procedure was successfully,
	 * else return false if there are no trains or if the train is not exists
	 */
	public boolean removeTrain (Train f)//5 
	{
	     if (f==null)
	           return false ;
	           
		if (this._noOfTrs == 0) // checks if  station is empty
			return false ;
					
		for (int i=0;i<this._noOfTrs;i++)
		{
			if (this._station[i].equals(f))
			{
				this._station[i] = new Train(this._station[_noOfTrs - 1]);
				this._station[_noOfTrs-1] = null ;
				this._noOfTrs-- ;
				return true ;
			}//end of if statement - train found
		}//end of for loop
		
		return false ; //if train was'nt found
	}
	
	/**
	 * Checks the first train to depart from  the station to the destination city
	 * @param place the destination city
	 * @return the earliest departure time to the destination city,
	 * return null if there aren't trains in the station or there isnt a train to this destination city 
	 */
	public Time1 firstDepartureToDestination (String place) //6
	{
		if(this._noOfTrs == 0) //checks if station is empty
			return null ;
		
		Time1 earlyTrainTime = null ;
		int i = 0;
		for (i=0;i<this._noOfTrs;i++)
		{
			if (this._station[i].getDestination().equals(place))
			{
				earlyTrainTime = new Time1(this._station[i].getDeparture());//gets the first train in the array to this dest(not the earliest)
				break ;
			}
		}
		
		
		if (i >= this._noOfTrs) // checks if there arent trains to this destination
			return null ;
		
		else
			for (int j=i;j<_noOfTrs;j++)
			{
				if (this._station[j].getDestination().equals(place) && 
						this._station[j].getDeparture().before(earlyTrainTime))//checks if the train is to the right dest and if it is earlier
					earlyTrainTime = new Time1(this._station[j].getDeparture());
			}
				
		
		return new Time1(earlyTrainTime) ;
	}
	
	
	/**
	 * Checks how many full trains are there in the station
	 * @return how many full trains are there in the station
	 */
	public int howManyFullTrains() //7
	{
		int fullTrainIndex = 0;
		for (int i=0;i<this._noOfTrs;i++)
		{
			if(this._station[i].isFull()==true)//counting the full trains
				fullTrainIndex++;
		}
		return fullTrainIndex ;
	}
	
	/**
	 * Checks what is the most popular and traveld destinaion in the station - by the number of trains.
	 * @return the most traveled destination in the station,
	 * if there are'nt trains, return null
	 */
	public String mostPopularDestination () //8
	{
		if(this._noOfTrs == 0) // checks if station is empty
			return null ;
		
		int count = 1 ; 
		int tempCount = 0; 
		
		String popularDest = new String(this._station[0].getDestination());
		String tempDest = new String("");
		
		for (int i = 0; i < (this._noOfTrs ); i++)
		{ // beginning of first loop
			tempDest = new String(this._station[i].getDestination());//get the destination
		    tempCount = 0;
		    
		    
		    for (int j = 1; j < this._noOfTrs; j++)
		    {// beginning of second loop
		    	if (tempDest.equals(this._station[j].getDestination()))//checks how many time the destionation is appeard
		    	  tempCount++;
		    }// end of second loop
		    
		    
		    	if (tempCount > count) // checks eif a new destination is more traveld than the others
		    	{
		    		popularDest = new String(tempDest);
		    		count = tempCount;
		    	}
		    	
		} // end of first loop
		
		return popularDest;
	}
	
	/**
	 * Checks what train has the most expensive ticket
	 * @return the train with the most expensive ticket, 
	 * if there are'nt trains return null.
	 */
	public Train mostExpensiveTicket ()//9
	{
		if(this._noOfTrs == 0) // checks if station is empty
			return null ;
		
		Train expensiveTrain = new Train(this._station[0]);
		int expensiveTicket = expensiveTrain.getPrice();
		
		for (int i=1;i<this._noOfTrs;i++)
		{
			if(this._station[i].getPrice()>expensiveTicket) // checks the higher price for a ticket 
			{
				expensiveTicket = this._station[i].getPrice() ;
				expensiveTrain = new Train(this._station[i]);
			}
		}
		return new Train(expensiveTrain);
	}

	/**
	 * Checks what train has the longest duration
	 * @return the train with the longest duration
	 * if there are'nt trains return null
	 */
	public Train longestTrain ()//10
	{
		if(this._noOfTrs == 0)//checks if station is empty
			return null ;
		
		Train longestTrain = new Train(this._station[0]);
		int longestDuration = longestTrain.getDuration();
		
		for (int i=1;i<this._noOfTrs;i++)
		{
			if(this._station[i].getDuration()>longestDuration) // checks the longest duration
			{
				longestDuration = this._station[i].getDuration() ;
				longestTrain = new Train(this._station[i]);
			}
		}
		
		return new Train(longestTrain);
	}
	
	/**
	 * Returns a string representation of this station in the format :
	 * "The trains today are :"
	 * "Train to XXXX departs at hh:mm. Train is full/not full".
	 * If there arent trains it will print "There are no trains today."
	 * @return String representation of this station.
	 */
	public String toString () //11
	{
		if(this._noOfTrs == 0) //checks if station empty
			return "There are no trains today." ;
		
		String allTrains = new String("The trains today are: \n"); 
		for (int i=0;i<this._noOfTrs;i++)
		{
			allTrains = new String(allTrains + this._station[i].toString() + "\n");//using the toString method of class Train
		}
		return allTrains;
	}
	
	/////////////////////////////////////////////
	public static void main(String []args)
    {

		/***********  RailwayStation CLASS TESTER ***********/
        /*****************************/
        Random rand = new Random();
        //Check constructor

        System.out.println("1. check addTrain:");
        RailwayStation rs = new RailwayStation();
        RailwayStation rsSmall = new RailwayStation();
        RailwayStation rsEmptyDes = new RailwayStation();
        RailwayStation rsTestCost = new RailwayStation();


        //AddTrain
        Train f11 = new Train("Haifa", 12, 0, 210, 250, 250, 55);
        Train f12 = new Train("Jerusalem", 10, 50, 210, 250, 250, 40);
        Train f13 = new Train("Jerusalem", 10, 50, 210, 250, 250, 40);
        Train f14 = new Train("Jerusalem", 10, 50, 210, 250, 250, 40);
        Train f15 = new Train("Tel-Aviv", 10, 50, 210, 250, 250, 40);
        Train f16 = new Train("", 22, 22, 210, 250, 250, 40);
        Train f17 = new Train("Amsterdam", 12, 0, 210, 250, 250, 40);
        Train f18 = new Train("Berlin", 13, 0, 210, 250, 250, 40);

        System.out.println("\t t: \t" + rs.addTrain(f11) + "\t;\t" + f11);
        System.out.println("\t t: \t" + rs.addTrain(f12) + "\t;\t" + f12);
        System.out.println("\t f: \t" + rs.addTrain(f13) + "\t;\t" + f13);
        System.out.println("\t f: \t" + rs.addTrain(f14) + "\t;\t" + f14);

        Train tst1 = new Train("same", 12, 30, 60, 25, 50, 10);
        Train tst2 = new Train("same", 12, 30, 61, 41, 50, 11);
        Train tst3 = new Train("not same", 12, 30, 60, 40, 50, 10);
        Train tst4 = new Train("same", 12, 31, 60, 40, 50, 10);
        Train tst5 = new Train("same", 13, 30, 60, 40, 50, 10);
        Train tst6 = new Train("same", 12, 30, 61, 40, 51, 10);

        System.out.println("\t t: \t" + rs.addTrain(tst1) + "\t;\t" + tst1);
        System.out.println("\t f: \t" + rs.addTrain(tst2) + "\t;\t" + tst2);
        System.out.println("\t t: \t" + rs.addTrain(tst3) + "\t;\t" + tst3);
        System.out.println("\t t: \t" + rs.addTrain(tst4) + "\t;\t" + tst4);
        System.out.println("\t t: \t" + rs.addTrain(tst5) + "\t;\t" + tst5);
        System.out.println("\t t: \t" + rs.addTrain(tst6) + "\t;\t" + tst6);



        RailwayStation rs_full = new RailwayStation();
        for (int i = 0; i <= 150; i++)
            rs_full.addTrain(new Train("rio", rand.nextInt(23) + 1, rand.nextInt(59) + 1, 210, 25, (int) (Math.random() * 100) + +35, 55));
        System.out.print("\t f:\t \t");
        System.out.print(rs_full.addTrain(new Train("Not Same", 0, 0, 210, 25, 0, 55)));
        System.out.println("\t;\tAdd one to full RailwayStation\t");

        System.out.print("\t f:\t \t");
        System.out.print(rs.addTrain(null));
        System.out.println("\t;\tAdd null train\t");


        System.out.println("\n");

        System.out.println("2. check removeTrain:");
        //need to check holes after remove.


        //RemoveTrain
//        System.out.println(rs);
        RailwayStation rs_empty = new RailwayStation();
        System.out.println("\tt:\t regular remove f11:    \t" + rs.removeTrain(tst3));
//        System.out.println(rs);
        System.out.print("\tf:\t remove not exist one : \t");
        System.out.println(rs_full.removeTrain(new Train("Not Same", 0, 0, 210, 25, 0, 55)));
        System.out.print("\tf:\t remove when empty :    \t");
        System.out.println(rs_empty.removeTrain(new Train("Not Same", 0, 0, 210, 25, 0, 55)));
        System.out.println("\tf:\t remove null train :\t\t" +rs.removeTrain(null));




        //First Train to Destination
        RailwayStation rs_one_train = new RailwayStation();
        Train f3a = new Train("Tel-Aviv", 7, 15, 180, 200, 200, 35);
        rs.addTrain(f3a);
        Train f3 = new Train("Tel-Aviv", 11, 35, 180, 100, 200, 35);
        rs.addTrain(f3);

        Train f3b = new Train("Tel-Aviv", 8, 14, 180, 200, 199, 35);

        rs.addTrain(f3b);
        System.out.println();

        System.out.println("3. check firstDepartureToDestination:");

        Time1 t1 = rs.firstDepartureToDestination("Tel-Aviv");
        System.out.println("\t07:15:\tThe first train to Tel-Aviv departs at  " + t1);

        f11 =  new Train("Tokyo", 23, 59, 180, 200, 200, 35);
        rs_one_train.addTrain(f11);
        Time1 t11 = rs_one_train.firstDepartureToDestination("Tokyo");
        System.out.println("\t23:59:\tThe first train to Tel-Aviv departs at  " + t11);

        Time1 t2 = rs_full.firstDepartureToDestination("Tel-Aviv");
        System.out.println("\tnull:\tThe Destination not there:  \t\t\t" + t2);

        Time1 t3 = rs_empty.firstDepartureToDestination("Haifa");
        System.out.println("\tnull:\tThe RailwayStation is empty:   \t\t\t" + t3);

        Time1 t4 = rs.firstDepartureToDestination(null);
        System.out.println("\tnull:\tThe Destination is null:   \t\t\t\t" + t4);

        rsEmptyDes.addTrain(f16);
        Time1 t5 = rsEmptyDes.firstDepartureToDestination("");
        System.out.println("\t22:22:\tThe Destination time is \"\":   \t\t\t" + t5);

        System.out.println();


        //toString
        System.out.println("4. toString:");
        System.out.println("empty: \n" + rs_empty);
        System.out.println("\n" + rs);
        System.out.println(rs_one_train);

        String shouldBeA =  "The trains today are:\nTrain to Tokyo departs at 23:59. Train is full.\n";
        String shouldBeB =  "The trains today are:\nTrain to Tokyo departs at 23:59. Train is full\n";
        String shouldBeEmpty =  "There are no trains today.";

        System.out.println("is to string ok:\n\t check regular station - " +  (shouldBeA.equals(rs_one_train.toString()) || shouldBeB.equals(rs_one_train.toString()) )
                +"\n\t check empty station - " +  shouldBeEmpty.equals(rs_empty.toString()) );
        System.out.println();
        System.out.println();


        //HowMany Full Trains
        RailwayStation rs_full_full = new RailwayStation();
        for (int i = 0; i <= 150; i++)
            rs_full_full.addTrain(new Train("rio", rand.nextInt(23) + 1, rand.nextInt(59) + 1, 210, 900, (int) (Math.random() * 100) + +35, 55));

        System.out.println("5. How Many Full Trains:");
        int x = rs.howManyFullTrains();
        System.out.println("\t4\t - rs_reg: number if Full Trains - " + x);
        System.out.println("\t0\t - rs_empty:   - " + rs_empty.howManyFullTrains());
        System.out.println("\t0\t - rs all not Full :  - " + rs_full.howManyFullTrains());
        System.out.println("\t100\t - rs all full :  - " + rs_full_full.howManyFullTrains());
        System.out.println();

        //Most Popular Destination
        System.out.println("6. Most Popular Destination:");
        String mostPopular = rs.mostPopularDestination();
        System.out.println("\tsame \t - " + mostPopular);
        System.out.println("\tnull \t - " + rs_empty.mostPopularDestination());
        System.out.println("\trio  \t - " + rs_full.mostPopularDestination());
        System.out.println("\tTokyo\t - " + rs_one_train.mostPopularDestination());
        System.out.println();

        //Most Expensive Ticket
        rsTestCost.addTrain(f17);
        rsTestCost.addTrain(f18);
        rsTestCost.addTrain(f12);
        rsTestCost.addTrain(f15);

        System.out.println("7. Most Expensive Ticket:");
        Train mostExpensive = rs.mostExpensiveTicket();
        System.out.println("\tHaifa    \t - Most Expensive Ticket - " + mostExpensive);
        System.out.println("\tAmsterdam\t - Most Expensive Ticket - " + rsTestCost.mostExpensiveTicket());
        System.out.println("\tnull     \t - Most Expensive Ticket - " + rs_empty.mostExpensiveTicket());
        System.out.println();


        //Longest Train
        System.out.println("8. Longest Train:");
        Train longestTrain = rs.longestTrain();
        System.out.println("\tHaifa    \t - Longest Train - " + longestTrain);
        System.out.println("\tAmsterdam\t - Longest Train - " + rsTestCost.longestTrain());
        System.out.println("\tnull     \t - Longest Train - " + rs_empty.longestTrain());

    }
}

