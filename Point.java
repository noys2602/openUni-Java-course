package maman15;

/**
 * this class represent a point (x,y) in a cartesian coordinate system
 * @author Noy Swisa
 *
 */
public class Point {
		
	//varibles declrations
	private double _x ; 
	private double _y ;
	
	/**
	 * constructs a Point object
	 * the function complicity of time is O(1) 
     * the function complicity of space is O(1)
	 * @param x for x coordinate
	 * @param y for y coordinate
	 */
	public Point(double x, double y)
	{
		this._x = x ;
		this._y = y ;
	}
	
	/**
	 * copy constructor of Point object
	 * the function complicity of time is O(1) 
     *the function complicity of space is O(1)
	 * @param other - the object to copy the x,y coordinated from
	 */
	public Point (Point other)
	{
		this._x = other._x ;
		this._y = other._y ;
	}
	
	
	/**
	 * return x value
	 * the function complicity of time is O(1) 
     * the function complicity of space is O(1)
	 * @return x value
	 */
	public double getX()
	{
		return this._x ;
	}
	
	/**
	 * return y value
	 * the function complicity of time is O(1) 
     * the function complicity of space is O(1)
	 * @return y value
	 */
	public double getY()
	{
		return this._y ;
	}
	
	/**
	 * set x value
	 * the function complicity of time is O(1) 
     * the function complicity of space is O(1)
	 * @param num for x value
	 */
	public void setX(double num)
	{
		this._x = num ;
	}
	
	/**
	 * set y value
	 * the function complicity of time is O(1) 
     * the function complicity of space is O(1)
	 * @param num for y value
	 */
	public void setY(double num)
	{
		this._y = num ;
	}
	
	/**
	 * return x y coordinates in "(x,y)" format
	 * the function complicity of time is O(1) 
     * the function complicity of space is O(1)
	 */
	public String toString()
	{
		return "("+this._x+","+this._y+")" ;
	}
	
	/**
	 * checks if two points are the same
	 * the function complicity of time is O(1) 
     * the function complicity of space is O(1)
	 * @param other the object to compare with the main object
	 * @return true if the points are equal, false if they are different
	 */
	public boolean equals (Point other)
	{
		return (this._x == other._x && this._y == other._y) ;
	}
	
	/**
	 * checks if the point is above from the point we got
	 * the function complicity of time is O(1) 
     * the function complicity of space is O(1)
	 * @param other the point to compare the y value with
	 * @return true if the point is above
	 */
	public boolean isAbove(Point other)
	{
		
		return !(other._y >= this._y) ;
	}
	
	/**
	 * checks if the point is under from the point we got
	 * the function complicity of time is O(1) 
     * the function complicity of space is O(1)
	 * @param other the point to compare the y value with
	 * @return true if the point is under
	 */
	public boolean isUnder (Point other)
	{
		return !this.isAbove(other) ; //check what if equal
	}
	
	/**
	 * checks if the point is left from the point we got
	 * the function complicity of time is O(1) 
     * the function complicity of space is O(1)
	 * @param other the point we want to compare the x value with
	 * @return true if the main point is from the left
	 */
	public boolean isLeft(Point other)
	{
		
		return !(other._x <= this._x) ;
	}
	
	/**
	 * checks if the point is right from the point we got
	 * the function complicity of time is O(1) 
     * the function complicity of space is O(1)
	 * @param other the point we want to comapre the x value with
	 * @return true if the main point is from the right
	 */
	public boolean isRight (Point other)
	{
		return !this.isLeft(other) ;
	}
	
	/**
	 * checks what is the distance between two points
	 * the function complicity of time is O(1) 
     * the function complicity of space is O(1)
	 * @param p the other point to check the distance from
	 * @return the disntance
	 */
	public double distance(Point p)
	{
		double x1 = this._x ;
		double x2 = p._x ;
		
		double y1 = this._y ;
		double y2 = p._y ;
		
		double xSubtraction = x2 - x1 ;
		double ySubtraction = y2 - y1 ;
		
		return Math.sqrt(Math.pow(ySubtraction, 2) + Math.pow(xSubtraction, 2)) ;
	}
	
	/**
	 * moves the point coordinates
	 * the function complicity of time is O(1) 
     * the function complicity of space is O(1) 
	 * @param dx how much to move in x
	 * @param dy how much to move in y 
	 */
	public void move(double dx, double dy)
	{
		this.setX(this._x + dx) ;
		this.setY(this._y + dy) ;

	}
	
	

}
