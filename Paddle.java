   /*****************************************************************
	* A Paddle is an object that maintains information about its location, color, and dimensions.
	* It's controlled by the player to keep the ball in action.
	* A Paddle knows how to set its Y value, X value, and color. It also knows how to return
	* its Y value, X value, height, width, and color. It knows how to draw itself as well.
	 
	* @author Rachel Li
	* @author Rashid Lasker
	****************************************************************/
   import java.awt.*;
   import java.awt.event.*;
   public class Paddle
   {
      private double myX; //x-coordinate
      private double myY; //y-coordinate
      private Color myColor; //color
      private double height; //height
      private double width; //width
    	
		// constructors	
      /************************************************************* 
   	* Constructs a Paddle with its coordinates at (225, 400).
   	* The default color is red, and the Paddle has a height of 10
   	* and a width of 50.
   	**************************************************************/
      public Paddle()         //default constructor
      {
         myX = 175;
         myY = 400;
         myColor = Color.RED;
         height = 10;
         width = 50;
      }
		
      //modifier methods 
      /***************************************************************
   	* Sets the X value to the input number.
   	* @param x	 assigns x to myX
   	**************************************************************/
      public void setX(double x)        
      {
         myX = x;
      }
		
      /***************************************************************
   	* Sets the Y value to the input number.
   	* @param y	 assigns y to myY
   	**************************************************************/
      public void setY(double y)
      {
         myY = y;
      }
		
      /***************************************************************
   	* Sets the Paddle's color to the input Color.
   	* @param c	 assigns c to myColor
   	**************************************************************/
      public void setColor(Color c)
      {
         myColor = c;
      }
		
      //accessor methods
      /*************************************************************** 
   	* Returns the Paddle's X value
   	* @return	 myX
   	**************************************************************/
      public double getX()             
      {
         return myX;
      }
		
      /*************************************************************** 
   	* Returns the Paddle's Y value
   	* @return	 myY
   	**************************************************************/
      public double getY()
      {
         return myY;
      }
		
      /*************************************************************** 
   	* Returns the Paddle's height
   	* @return	 height
   	**************************************************************/
		public double getHeight()             
      {
         return height;
      }
		
      /*************************************************************** 
   	* Returns the Paddle's width
   	* @return	 width
   	**************************************************************/
		public double getWidth()
      {
         return width;
      }
		
      /*************************************************************** 
   	* Returns the Paddle's Color
   	* @return	 myColor
   	**************************************************************/
		public Color getColor()
      {
         return myColor;
      }
		
     	//instance methods
   	/***************************************************************
   	* Draws Paddle onto the frame
   	* @param myBuffer	 draws the brick
   	**************************************************************/
      public void draw(Graphics myBuffer) 
      {
         myBuffer.setColor(myColor);
         myBuffer.fillRect((int) (myX), (int) (myY - height * 2), (int)width, (int)height);
      }   
   }

