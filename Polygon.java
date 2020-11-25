package maman15;

/**
 * this class represents a convex polygon .
 * @author Noy Swisa
 */
public class Polygon
{
    private PointNode _head;
    
    
    /**
     * Constructor of empty Polygon.
     * Initializing the head to null .
     * the function complicity of time is O(1) .
     * the function complicity of space is O(1) .
     */
    public Polygon() 
    {
        this._head = null;
    }

    /**
     * This method add a new vertex .
     * the time complexity is o(n) .
     * the space complexity is o(1) .
     * @param P point  to add to the polygon.
     * @param Pos where to add the point.
     * @return true if the point added 
     */
    public boolean addVertex ( Point p , int pos)
    {
       
        if(pos <=0 ) 
            return false;
        
        PointNode point = new PointNode(p);
        
        if(this._head==null) // first point
        { 
            if(pos==1) // check  if the first point added in the right way
            {
                this._head = new PointNode(p,null);
                return true;
            }
            return false;
        }
        
        
        else // add the rest of the points.
        {
            PointNode temp = this._head;
            PointNode prev = null;
            
            for (int i = 0 ;i!= pos-1; i++)
            {
                if(temp != null)
                {
                    prev = temp;
                    temp = temp.getNext();
                }
                else
                    return false;
            } 
            
            if(prev != null)
            {
                point.setNext(temp);
                prev.setNext(point);
            }
            if(prev == null && pos ==1)
            {
                this._head=new PointNode(p,temp);
            }
            return true;
        }
    }

    /**
     * this method return the highest vertex .
     * if the polygon is empty return null.
     * the time complexity is o(n).
     * the space complexity is o(1).
     * @return The highest vertex.
     */
    public Point highestVertex()
    {
        if ( this._head == null)
            return null;
        
        Point max = this._head.getPoint(); // holds the highest point
         
        for(PointNode temp = this._head ; temp != null; temp=temp.getNext())
        {
            if ((temp.getPoint()).isAbove(max))
                max = temp.getPoint();
        } 
        return new Point(max);
    }

    /**
     *  string representation of a polygon in a format  :
     * The polygon has n vertices:
     *((x,y),(x,y),(x,y))
     * the time complexity is o(n) .
     * the space complexity is o(n) .
     * @return A String representation of the polygon.
     */
    public String toString()
    {
        if(this._head == null)
        	return "The polygon has 0 vertices." ;
        else
        {
        	
        	String str = new String ( "(" +(this._head.getPoint()).toString()) ; //main string to return
            int verticesCount = 1; // ammount of vertices
            
            for (PointNode temp = this._head.getNext() ; temp != null; temp = temp.getNext())
            {
                str += ","+ temp.getPoint() ;
                verticesCount++;
            }
            return  "The polygon has " + verticesCount + " vertices:\n" +  str + ")"  ;  
        }
        
    }

    /**
     * This  method calculates the perimeter of the polygon.
     * the time complexity is o(n) .
     * the space complexity is o(1).
     * @return The polygon perimeter.
     */
    public double calcPerimeter ()
    {
        if(this._head == null || this._head.getNext() == null) // in case of 1 or 0 points
            return 0;
        
        if((this._head.getNext()).getNext()== null) // in case of 2 points
            return (this._head.getPoint()).distance((this._head.getNext()).getPoint());
        
        else
        {
            double polyPerimeter =0 ;
            PointNode temp = this._head;
            while (  temp.getNext() != null)
            {
            	polyPerimeter += (temp.getPoint()).distance((temp.getNext()).getPoint()); // calculation
                temp = temp.getNext(); 
            } 
            polyPerimeter += temp.getPoint().distance(this._head.getPoint()); //adding the disntcance between the "last" point to the head
            return polyPerimeter;
        }
    }

    
    /**
     * This method calculates the area of the polygon.
     * the time complexity is o(n) .
     * the space complexity is o(1).
     * @return The polygon's area.
     */
    public double calcArea()
    {
        if(this._head==null || this._head.getNext()== null)
            return 0;
        
        else
        {
            double polyArea = 0;
            PointNode temp = this._head;
            
            while ((temp.getNext()).getNext()!= null)
            {
                
                double a =  (this._head.getPoint()).distance (((temp.getNext()).getPoint())) ; // first side
                double b =  (temp.getNext().getPoint()).distance ((temp.getNext()).getNext().getPoint()) ; // second side 
                double c = (temp.getNext()).getNext().getPoint().distance (this._head.getPoint());// third side
                double s = (a+b+c)/2; //  Half of perimeter
                
                polyArea += Math.sqrt(s * (s - a) * (s - b) * (s - c)); // Heron's way
                temp=temp.getNext();
            } 
            return polyArea;
        } // end of else
    }

    /**
     * This method check if this polygon has a bigger area . 
     * the time complexity is o(n) .
     * the space complexity is o(1).
     * @param Other - the other polygon
     * @return true if this polygon is bigger then the other polygon.
     */
    public boolean isBigger(Polygon other)
    {
        return (this.calcArea() > other.calcArea()) ;
       
    }

    
    /**
     * This method check if the given vertex exists .
     * the time complexity is o(n) .
     * the space complexity is o(1).
     * @param p - the vertex 
     * @return the index of the vertex , else return -1 if  isnt exists.
     */
    public int findVertex(Point p)
    {
        PointNode temp = this._head;
        int place =0;
        while (temp!= null)
        {
            place++;
            if((temp.getPoint()).equals(p))
            	return place;
            temp = temp.getNext();
            
        } 
        
        return -1; 
    }

    
    /**
     * This method check if a vertex is located on the polygon and return the next vertex .
     * the time complexity is o(n) .
     * the space complexity is o(1).
     * @param p - a vertex 
     * @return the next vertex after p 
     */
    public Point getNextVertex(Point p)
    {
        if(this.findVertex(p) == -1)
            return null;
        
        else
        {
            PointNode temp = this._head; 
            while (temp.getNext() != null)
            {
                if((temp.getPoint()).equals(p))
                {
                    return new Point(temp.getNext().getPoint());
                }
                temp = temp.getNext();
            }
        }
        return new Point(this._head.getPoint());
    }

    /**
     * This method return the rectangle that blocks the polygon .
     * the time complexity is o(n) .
     * the space complexity is o(1).
     * @return The rectangle .
     */
    public Polygon getBoundingBox()
    {
        if (this._head == null || this._head.getNext() == null || (this._head.getNext()).getNext() == null) //chekss there are more than 3 vertexes
            return  null;
        
        PointNode temp = this._head.getNext(); 
        
        Point upLimit = this.highestVertex();
        Point downLimit = this._head.getPoint();
        
        Point rightLimit = this._head.getPoint();
        Point leftLimit = this._head.getPoint();
        
        while (temp != null)
        {
            if( temp.getPoint().isUnder(downLimit))
            	downLimit = temp.getPoint();
            
            if( temp.getPoint().isRight(rightLimit))
            	rightLimit= temp.getPoint();
            
            if( temp.getPoint().isLeft(leftLimit))
            	leftLimit = temp.getPoint();
            
            temp = temp.getNext();
        }
        
        
        Polygon BoundingBox = new Polygon(); // the rectenagle (as a polygon)
        Point leftDownPoint = new Point(leftLimit.getX(),downLimit.getY()) ; 
        Point rightDownPoint = new Point(rightLimit.getX(),downLimit.getY()) ;
        Point rightUpPoint = new Point(rightLimit.getX(),upLimit.getY()) ; 
        Point leftUpPoint = new Point(leftLimit.getX(),upLimit.getY()) ;
        
        BoundingBox.addVertex(leftDownPoint , 1);
        BoundingBox.addVertex(rightDownPoint , 2);
        BoundingBox.addVertex(rightUpPoint , 3);
        BoundingBox.addVertex(leftUpPoint,4);
       
        return BoundingBox;
    } 
    
   
    
}
