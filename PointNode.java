package maman15;


/**
 * this class represent a vertex in a polygon .
 * @author Noy Swisa
 */
public class PointNode
{
	
	//varibles declreations
    private Point _point;
    private PointNode _next;
    
    
    /**
     * This constructor set a point with no other point connected
     * the function complicity of time is O(1) .
     * the function complicity of space is O(1) .
     * @param p - the point to set
     */
    public PointNode (Point p)
    {
        this._point = new Point (p);
        this._next=null;
    }
    
    /**
     * This constructor add a point to the list.
     * the function complicity of time is O(1) .
     * the function complicity of space is O(1) .
     * @param p - the point to add
     * @param n - the next pointNode
     */
     
    public PointNode (Point p, PointNode n)
    {
        this._point = new Point (p);
        this._next = n;
    }
    
    
    /**
     * a copy constructor.
     * the function complicity of time is O(1) .
     * the function complicity of space is O(1) .
     * @param p - the point to add
     */
    public PointNode (PointNode p)
    {
        this._point = new Point (p._point);
        this._next =p._next;        
    }
    
    /**
     * get a copy of the point.
     * the function complicity of time is O(1) .
     * the function complicity of space is O(1) .
     * @return a copy of the point.
     */
    public Point getPoint()
    {
        return new Point (this._point);
    }
    
    /**
     * get the next point.
     * the function complicity of time is O(1) .
     * the function complicity of space is O(1) .
     * @return the next point.
     */
    public PointNode getNext()
    {
        return this._next;
    }
    
    /**
     * set a new point.
     * the function complicity of time is O(1) .
     * the function complicity of space is O(1) .
     * @param p  the point to set.
     */
    public void setPoint(Point p)
    {
        this._point= new Point (p);
    }
    
    /**
     * set a new next to a point.
     * the function complicity of time is O(1) .
     * the function complicity of space is O(1) .
     * @param next - the next point to set.
     */
    public void setNext(PointNode next)
    {
        this._next=next;
    }
}

