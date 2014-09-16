    /*****************************************************************
    * A Polkadot is an object that maintains information about its center, diameter, color, and radius. A Polkadot
    * knows how to return its data, set its data, move from place to place, and be drawn.
     
    * @author Rachel Li
    * @author Rashid Lasker
    ****************************************************************/
	import java.awt.*;
  
	public class Polkadot
	{
		private double myX;   // x and y coordinates of center
		private double myY;
		private double myDiameter;
		private Color myColor;
		private double myRadius;
		
		//constructors
      /*************************************************************
      * Constructs a Polkadot with its coordinates at (200,200),
		* a diameter of 25, and sets its color as red.
      **************************************************************/
		public Polkadot()     //default constructor
		{
			myX = 200;
			myY = 200;
			myDiameter = 25;
			myColor = Color.RED;
			myRadius = myDiameter/2;
		}

      /*************************************************************
      * Constructs a brick with its coordinates at (x,y), a diameter of d, and sets its color to c.
      * @param x    initial X value
      * @param y    initial Y value
      * @param d    initial diameter
      * @param c    initial color
      **************************************************************/
		public Polkadot(double x, double y, double d, Color c)
		{
			myX = x;
			myY = y;
 			myDiameter = d;
			myColor = c;
			myRadius = d/2;
		}
	  
		//modifier methods
      /***************************************************************
      * Sets the X value to the input number.
      * @param x     assigns x to myX
      **************************************************************/
		public void setX(double x)
		{
			myX = x;
		}
	  
      /***************************************************************
      * Sets the Y value to the input number.
      * @param y     assigns y to myY
      **************************************************************/
		public void setY(double y)
		{
			myY = y;
		}

      /***************************************************************
      * Sets the Polkadot's color to the input Color.
      * @param c     assigns c to myColor
      **************************************************************/
		public void setColor(Color c)
		{
			myColor = c;
		}

      /***************************************************************
      * Sets the diameter to the input number.
      * @param d     assigns d to myDiameter
      **************************************************************/
		public void setDiameter(double d)
		{
			myDiameter = d;
			myRadius = d/2;
		}

      /***************************************************************
      * Sets the radius to the input number.
      * @param r     assigns r to myDiameter
      **************************************************************/
		public void setRadius(double r)
		{
			myRadius = r;
			myDiameter = 2 * r;
		}

		//accessor methods
      /***************************************************************
      * Returns the Polkadot's X value
      * @return     myX
      **************************************************************/
		public double getX()
		{
			return myX;
		}

      /***************************************************************
      * Returns the Polkadot's Y value
      * @return     myY
      **************************************************************/
		public double getY()      
		{
 			return myY;
		}

      /***************************************************************
      * Returns the Polkadot's diameter
      * @return     myDiameter
      **************************************************************/
		public double getDiameter()
		{
			return myDiameter;
		}

      /***************************************************************
      * Returns the Polkadot's color
      * @return     myColor
      **************************************************************/
		public Color getColor()
		{
 			return myColor;
 		}

      /***************************************************************
      * Returns the Polkadot's radius
      * @return     myRadius
      **************************************************************/
		public double getRadius()
		{
			return myRadius;
		}
		
		//instance methods
      /***************************************************************
      * Puts the Polkadot in a random location
      * @param rightEdge     defines the right edge
      * @param bottomEdge     defines the bottom edge
      **************************************************************/
		public void jump(int rightEdge, int bottomEdge)
		{
			myX = (Math.random()* (rightEdge-myDiameter) + myRadius);
			myY = (Math.random()* (bottomEdge-myDiameter) + myRadius);
		}

      /***************************************************************
      * Draws the Polkadot
      * @param myBuffer     draws the Polkadot
      **************************************************************/
		public void draw(Graphics myBuffer)
		{
			myBuffer.setColor(myColor);
			myBuffer.fillOval((int)(myX - myRadius), (int)(myY-myRadius), (int)myDiameter, (int)myDiameter);
		}
	}


