	/*****************************************************************
	* A Brick is an object that maintains information about its location, color, and dimensions.
	* Its main purpose is to be an obstacle to the ball.
	* A Brick knows how to set its Y value, X value, and color. It also knows how to return
	* its Y value, X value, and color. It knows how to draw itself as well.
	 
	* @author Rachel Li
	* @author Rashid Lasker
	****************************************************************/
   import java.awt.*;
   public class Brick
   {
      private int myX;
      private int myY;
      private Color myColor;
      private int height;
      private int width;
		
		//constructors
   	/************************************************************* 
   	* Constructs a brick with its coordinates at (x,y).
   	* @param x    initial X value
   	* @param y    initial Y value
   	**************************************************************/
      public Brick(int x, int y)
      {
         myX = x;
         myY = y;
         myColor = Color.BLUE;
         height = 10;
         width = 40;     	
      }
		
		//accessor methods		
    	/*************************************************************** 
   	* Returns the Brick's X value
   	* @return	 myX
   	**************************************************************/
      public int getX()
      {
         return myX;
      }
		
   	/*************************************************************** 
   	* Returns the Brick's Y value
   	* @return	 myY
   	**************************************************************/
      public int getY()
      {
         return myY;
      }
		
		/*************************************************************** 
   	* Returns the Brick's Color
   	* @return	 myColor
   	**************************************************************/
      public Color getColor()
      {
         return myColor;
      }
		
		/*************************************************************** 
   	* Returns the Brick's width
   	* @return	 width
   	**************************************************************/
		public int getWidth()
		{
			return width;
		}
		
		/*************************************************************** 
   	* Returns the Brick's height
   	* @return	 height
   	**************************************************************/
		public int getHeight()
		{
			return height;
		}
		
		//modifier methods		
     	/***************************************************************
   	* Sets the X value to the input number.
   	* @param x	 assigns x to myX
   	**************************************************************/
      public void setX(int x)
      {
         myX = x;
      }
		
   	/***************************************************************
   	* Sets the Y value to the input number.
   	* @param y	 assigns y to myY
   	**************************************************************/
      public void setY(int y)
      {
         myY = y;
      }
		
   	/***************************************************************
   	* Sets the Brick's color to the input Color.
   	* @param c	 assigns c to myColor
   	**************************************************************/
      public void setColor(Color c)
      {
         myColor = c;
      }
				
		//instance methods		
   	/***************************************************************
   	* Draws the Brick onto the frame
   	* @param myBuffer	 	draws the brick
		* @param b 				decides if there is a brick to be drawn
   	**************************************************************/
      public void draw(Graphics myBuffer, boolean b) 
      {
			if(b == true)
			{
         	myBuffer.setColor(myColor);
         	myBuffer.fillRect((int) (myX), (int) (myY + height * 3), (int) (width), (int) (height));
			}
      }
		
		/***************************************************************
   	* Calculates if the Ball hits the Brick
   	* @param		ball	 
		* @return	boolean
   	**************************************************************/
		public boolean inBrick(Ball ball)
      {
         for(int x = getX(); x <= getX() + getWidth(); x++)   //starts at upper left corner(x,y)
            for(int y = getY(); y <= getY() + getWidth(); y++)
               if(distance(x, y, ball.getX(), ball.getY()) <= ball.getRadius()) //checks every point on the brick
                  return true;            
         return false;
		}
		
		/***************************************************************
   	* Calculates distance between two points
   	* @param		x1
		* @param		y1
		* @param		x2
		* @param		y2
		* @return	double
   	**************************************************************/
		private double distance(int x1, int y1, double x2, double y2)
      {
         return Math.sqrt(Math.pow(x1 - x2, 2) + Math.pow(y1 - y2, 2));
      }	
   }



