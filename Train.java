package university;

/**
 * The class represents a Train
 * @author : Noy Swisa 318851821
 * @version 20/03/20
 */
public class Train {

    private String _destination ; 
    private Time1 _departure ;
    private int _duration ;
    private int _passengers;
    private int _seats;
    private int _price ;
    
    private final int DEFAULT_VAR = 0 ;

    /**
     * Constructor of class Train Constructs a new train. 
     * duration should be positive, otherwise it should be set to 0. 
     * pass should be positive, otherwise it should be set to 0. 
     * pass should be less than seats otherwise it should be set to seats. 
     * seats should be positive, otherwise it should be set to 0. 
     * price should be positive, otherwise it should be set to 0.
     * @param trainDest the destination of the train
     * @param hour the hour of departure
     * @param minute the minute of departue
     * @param travelDura the duration of the travel
     * @param passengersAmount the number of passeners
     * @param trainSeats the number of seats in the train
     * @param ticketPrice the price of the travel
     */
    public Train (String trainDest, int hour, int minute, int travelDura, 
            int passengersAmount, int trainSeats, int ticketPrice)
    {
        this._destination = new String(trainDest);
        
        if (passengersAmount > trainSeats)
            passengersAmount = trainSeats;
        if (passengersAmount < DEFAULT_VAR)
            passengersAmount = DEFAULT_VAR;
        this._passengers = passengersAmount;
        
        if (trainSeats < DEFAULT_VAR)
            trainSeats = DEFAULT_VAR;
        this._seats = trainSeats ;
        
        if (travelDura < DEFAULT_VAR)
            travelDura = DEFAULT_VAR;
        this._duration = travelDura;
        
        if(ticketPrice < DEFAULT_VAR)
            ticketPrice = DEFAULT_VAR;
        this._price = ticketPrice;

        
        this._departure = new Time1(hour,minute);

    }
    
    /**
     * Copy constructor for Train. 
     * Construct a train with the same instance variables as another train.
     * @param other The train object from which to construct the new train
     */
    public Train(Train other)
    {
        this._destination = other._destination ;
        this._departure = new Time1 (other._departure);
        this._duration = other._duration;
        this._passengers = other._passengers ;
        this._seats = other._seats ;
        this._price = other._price ;
        
    }

    /**
     * returns the destination
     * @return the destination of the train
     */
    public String getDestination()
    {
        return new String(this._destination);
    }
    
    /**
     * returns the departure time
     * @return the departure time
     */
    public Time1 getDeparture()
    {
        return new Time1(this._departure);
    }
    
    /**
     * returns the duration of the train
     * @return the duration of the train
     */
    public int getDuration()
    {
        return this._duration;
    }
    
    /**
     * returns the number of passengers
     * @return the number of passengers
     */
    public int getPassengers()
    {
        return this._passengers;
    }
    
    /**
     * returns the number of seats
     * @return the number of seats
     */
    public int getSeats() {
        return this._seats;
    }
    
    /**
     * returns the price of the train
     * @return the price of the train
     */
    public int getPrice()
    {
        return this._price;
    }
    
    /**
     * updates the destination of the train d in not null
     * @param d the new detination of the train
     */
    public void setDestination(String d) {
        this._destination = new String(d);
    }
    
    /**
     * updates the departure time of the train t in not null
     * @param t the new departure time of the train
     */
    public void setDeparture(Time1 t)
    {
        this._departure = new Time1(t);
    }
    
    /**
     * updates the duration of the train d should be positive, 
     * otherwise duration is unchanged
     * @param d the new duration of the train
     */
    public void setDuration (int d) {
        if(d >= DEFAULT_VAR)
            this._duration = d ;        
    }
    
    /**
     * updates the number of passengers p should be positive, 
     * otherwise seats is unchanged p should be less than seats 
     * otherwise it should be set to seats.
       * @param p the new number of passengers
     */
    public void setPassengers(int p) {
        
        
        if (p >= DEFAULT_VAR && p <= this._seats)
            this._passengers = p ;
        if (p > this._seats)
            this._passengers = this._seats ;
    }
    
    /**
     * updates the number of seats s should be positive, 
     * otherwise seats is unchanged.
     *  s should be larger than passengers, 
     * otherwise seats is unchanged
     * @param s
     */
    public void setSeats(int s)
    {
        if (s > DEFAULT_VAR && s > this._passengers)
            this._seats = s ;
        
    }
    
    /**
     * updates the price p should be positive, 
     * otherwise price is unchanged
     * @param p the new price
     */
    public void setPrice (int p) {
        if (p >= DEFAULT_VAR)
            this._price = p ;
    }
    
    /**
     * Check if the received train is equal to this train.
     * @param other The train to be compared with this train
     * @return True if the received train is equals to this train
     */
    public boolean equals (Train other)
    {
        if(this._destination != other._destination)
            return false ;
        
        if(this._departure.getHour() != other._departure.getHour())
            return false ;
        if(this._departure.getMinute() != other._departure.getMinute())
            return false ;
        
        
        if(this._seats != other._seats)
            return false;
        else
            return true;
    }
    
    /**
     * Returns the arrival time.
     * @return the arrival time
     */
    public Time1 getArrivalTime()
    {
        return new Time1(this._departure.addMinutes(this._duration));
        
            
    }
    
    /**
     * Add num passengers to the train.
     * @param num The number of passengers to add
     * @return True if the total number of current passengers and num is less or equal to seats
     */
    public boolean addPassengers (int num)
    {
        if ((this._passengers + num) <= this._seats)
        {
            this._passengers = this._passengers + num;
            return true;
        }
        else
            return false;
                
    }
    
    /**
     * Returns true if train is full.
     * @return true if train is full.
     */
    public boolean isFull() {
        return (this._seats == this._passengers);
    }
    
    /**
     * Returns true if the price for this train is cheaper than the other train. 
     * other is not null
     * @param other the other train to compare price with
     * @return true if the price for this train is cheaper than the other train.
     */
    public boolean isCheaper (Train other)
    {
        return (this._price<other._price);
    }
    
    /**
     * Returns the total price for all passengers.
     * @return the total price for all passengers.
     */
    public int totalPrice() {
        return (this._price * this._passengers);
    }
    
    /**
     * Returns true if the arrival time of this train is earlier than the arrival time of the other train. 
     * other is not null
     * @param other the other train to compare arrival time with
     * @return true if the arrival time of this train is earlier than arrival time of the other train.
     */
    public boolean arrivesEarlier(Train other)
    {
        return (this.getArrivalTime().before(other.getArrivalTime()));
    }

    /**
     * Return a string representation of the train.
     * @return String representation of the train.
     */
    public String toString() {
        String dest = this._destination;
        String time  = this._departure.toString();
        String capacity = "";
        if (this.isFull() == true)
            capacity= "Train is full";
        else
            capacity= "Train is not full";
        
        return "Train to " + dest + " departs at " + time +
                ". "+capacity;
    }
    
    
    public static void main(String[] args) {
        
        System.out.println("********** Test Train - Started **********");
        System.out.println("\n1. Testing Constructors and toString:");               
        // test concstructor with 7 parameters and toString
        Train tr1=new Train(new String("Paris"), 12, 30, 90, 70, 100, 10); 
        System.out.println("\tTrain 1: " + tr1);
        // test copy concstructor
        Train tr2 = new Train(tr1);
        System.out.println("\tTrain 2: " + tr2);
        
        System.out.println("\n2. Testing accessors and mutators:");
        // test getters
        
        System.out.println("\tTrain 1 destination: " + tr1.getDestination());
        System.out.println("\tTrain 1 departure: " + tr1.getDeparture());
        System.out.println("\tTrain 1 duration: " + tr1.getDuration());
        System.out.println("\tTrain 1 passengers: " + tr1.getPassengers());
        System.out.println("\tTrain 1 seats: " + tr1.getSeats());
        System.out.println("\tTrain 1 price: " + tr1.getPrice());
        
        // test setters   
        tr2.setDestination("London"); 
        tr2.setDeparture(new Time1(17,15)); 
        tr2.setDuration(60);
        tr2.setPassengers(80); 
        tr2.setSeats(200); 
        tr2.setPrice(25);
        System.out.println("\tTrain 2: " + tr2);
        
        System.out.println("\n3. Testing equal method:");
        System.out.println("\tTrain 1: " + tr1);
        System.out.println("\tTrain 2: " + tr2);
        System.out.println("\tTrain 1 is equal to Train 2: " + tr1.equals(tr2));
        
        System.out.println("\n4. Testing getArrivalTime method:");
        System.out.println("\tTrain 1 arrives at " + tr1.getArrivalTime());
        
        System.out.println("\n5. Testing addPassengers method:");
        System.out.println("\tAdding 20 passengers to Train 1 returns "+tr1.addPassengers(20)+
                           ". It now has "+tr1.getPassengers()+" passengers.");
                           
        System.out.println("\n6. Testing isFull method:");
        System.out.println("\tTrain 1 is full: " + tr1.isFull());
        
        System.out.println("\n7. Testing isCheaper method:");
        System.out.println("\tTrain 1 is cheaper than Train 2: " + tr1.isCheaper(tr2));
        
        System.out.println("\n8. Testing totalPrice method:");
        System.out.println("\tTrain 1 total price is: " + tr1.totalPrice());
        
        System.out.println("\n9. Testing arrivesEarlier method:");
        System.out.println("\tTrain 1 arrives earlier than Train 2: " + tr1.arrivesEarlier(tr2));
        
        System.out.println("\n********** Test Train - Finished **********\n");
    }

}
