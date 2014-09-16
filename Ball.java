   import java.awt.*;
  
    /*****************************************************************
    * A Ball is a Polkadot that bounces around the screen. A Ball
    * knows how to return its data, set its data, move, bounce, hit, and be drawn.
     
    * @author Rachel Li
    * @author Rashid Lasker
    ****************************************************************/

   public class Ball extends Polkadot
   {
      private int dx;       // pixels to move each time step() is called.
      private int dy;
      private static final Color BACKGROUND = new Color(204, 204, 204);
   
		//constructors
      /*************************************************************
      * Constructs ball with its coordinates at (200,200), 
		* a diameter of 50, and sets its color as black. 
		* It also sets the movement speed and direction.
      **************************************************************/
      public Ball()         //default constructor
      {
         super(200, 200, 50, Color.BLACK);
         dx = 2;          // to move sideways
         dy = -3;          // to move vertically
      }
   
      /*************************************************************
      * Constructs a ball with its coordinates at (x,y), 
		* a diameter of d, sets its color to c, and sets 
		* the movement speed and direction.
      * @param x		initial X value
      * @param y		initial Y value
      * @param dia	initial diameter
      * @param c		initial color
      **************************************************************/
      public Ball(int x, int y, int dia, Color c)
      {
         super(x, y, dia, c);
         dx = (int) (Math.random() * 6 - 3);
         dy = (int) (Math.random() * 6 - 3);
      }
		
		//modifier methods
      /***************************************************************
      * Sets the horizontal speed to the input number.
      * @param x     assigns x to dx
      **************************************************************/
      public void setdx(int x)        
      {
         dx = x;
      }
     
      /***************************************************************
      * Sets the vertical speed to the input number.
      * @param y     assigns y to dy
      **************************************************************/
      public void setdy(int y)
      {
         dy = y;
      }
   
      /***************************************************************
      * Returns the Ball's horizontal speed
      * @return     dx
      **************************************************************/
      public int getdx()             
      {
         return dx;
      }
     
      /***************************************************************
      * Returns the Ball's vertical speed
      * @return     dy
      **************************************************************/
      public int getdy()
      {
         return dy;
      }
		
  		//instance methods 
      /***************************************************************
      * Moves the ball
      * @param rightEdge     defines the right edge
      * @param bottomEdge     defines the bottom edge
      **************************************************************/
      public void move(int rightEdge, int bottomEdge)
      {
         setX(getX() + dx);                    // x = x + dx
         setY(getY() + dy);
       // check for left & right edge bounces
         if(getX() >= rightEdge - getRadius())     //hits the right edge
         {
            setX(rightEdge - getRadius());
            dx = dx * -1;
         }
         else if(getY() <= bottomEdge - 400 + getRadius())     //hits the top edge
         {
            setY(bottomEdge - 400 + getRadius());
            dy = dy * -1;
         }
         else if (getX() <= rightEdge - 400 + getRadius())     //hits the left edge
         {
            setX(rightEdge - 400 + getRadius());
            dx = dx * -1;
         }
         else if(getY() >= bottomEdge - getRadius())     //hits the bottom edge
         {
            setY(600);
            setX(600);
            dy = 0;
            dx = 0;
         }
      }
	}