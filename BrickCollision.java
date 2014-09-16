   /*****************************************************************
	* BrickCollision is an object that maintains information about the closest Brick to a Ball.
	* It determines which brick is hit by the ball.
	* BrickCollision checks to see if a Ball and a Brick contact each other, finds the point of impact, 
	* calculate distance, and update the coordinates of the closest Brick.
	
	* @author Rachel Li
	* @author Rashid Lasker
	****************************************************************/
	
	public class BrickCollision
   {
      private static double nearestX;	// used to approximate what point of the brick  
      private static double nearestY;  // a ball collided with
   	
		/***************************************************************
   	* Finds the collision of a Ball and a Brick
   	* @param brick			an array of Bricks
		* @param ball			a Ball
		* @param brickpos		a boolean array
		* @return brickpos
   	**************************************************************/
      public static boolean[][] collide(Brick[][] brick, Ball ball, boolean[][] brickpos)
      {
         for(int r = 0; r < 10; r++)
         {
            for(int c = 0; c < 8; c++)
            {
            // see if the ball hit the brick!
               if((brickpos[r][c] == true) && (brick[r][c].inBrick(ball)))
               {	   	
               // back the ball up until it is just outside the brick
                  while(brick[r][c].inBrick(ball))
                  {
                     ball.setX(ball.getX() - ball.getdx() / 10.0);
                     ball.setY(ball.getY() - ball.getdy() / 10.0);
                  }
               
               // find the point on the edge of the brick closest to the ball
                  findImpactPoint(brick[r][c], ball);
               
                  double ux = nearestX - ball.getX();
                  double uy = nearestY - ball.getY();
                  double ur = Math.sqrt(ux * ux + uy * uy);
                  ux/=ur;
                  uy/=ur;
                  int dx = (int) ball.getdx();
                  int dy = (int) ball.getdy();
                  double ball_1 = ux * dx + uy * dy;
                  double ball_2 = -uy * dx + ux * dy;
                  ball_1 *= -1; // this is the actual "bounce"
                  double[] d = new double[2];
                  d[0]=ball_1 * ux - ball_2 * uy;      //vector math
                  d[1]=ball_1 * uy + ball_2 * ux;      //vector math
                  dx = (int) Math.round(d[0]);
                  dy = (int) Math.round(d[1]);
                  ball.setdx(dx);
                  ball.setdy(dy);
               	
                  brickpos[r][c] = false;
               }
            }
         }
         return brickpos;
      }
		
		/***************************************************************
   	* Finds the place of impact between the Ball and Brick
   	* @param ball		a Ball
		* @param brick		a Brick
   	**************************************************************/      
      private static void findImpactPoint(Brick brick, Ball ball)
      {
          // first assume the nw corner is closest
         nearestX = brick.getX();  
         nearestY = brick.getY();
         
         // now work around the edge of the brick looking for a closer point
         for(int x = brick.getX(); x <= brick.getX() + brick.getWidth(); x++)  // top & bottom edges
         {
            updateIfCloser(x, brick.getY(), ball);
            updateIfCloser(x, brick.getY() + brick.getWidth(), ball);
         }
         for(int y = brick.getY(); y <= brick.getY() + brick.getWidth(); y++)  // right & left edges
         {
            updateIfCloser(brick.getX(), y, ball);
            updateIfCloser(brick.getX() + brick.getWidth(), y, ball);
         }
      }
        
		/***************************************************************
   	* Checks if (x, y) is closer to the Ball than (nearestX, nearestY)
   	* @param x	assigns x to nearestX if the distance between (x, y) is closer than (nearestX, nearestY) to the center of the ball
		* @param y	assigns y to nearestY if the distance between (x, y) is closer than (nearestX, nearestY) to the center of the ball
   	**************************************************************/ 
      // makes (x,y) the nearest point if it is closer to the ball
      private static void updateIfCloser(int x, int y, Ball b)
      {
         if(distance(x, y, b.getX(), b.getY()) < distance(nearestX, nearestY, b.getX(), b.getY()))
         {
            nearestX = x;
            nearestY = y;
         }
      }
		
      /***************************************************************
   	* Finds the distance between two points
   	* @param x1 the x-coordinate of the first point
		* @param y1 the y-coordinate of the first point
		* @param x2 the x-coordinate of the second point
		* @param y2	the y-coordinate of the second point
		* @return distance
   	**************************************************************/     
      // returns distance between (x1, y1) and (x2, y2)
      private static double distance(double x1, double y1, double x2, double y2)
      {
         return Math.sqrt(Math.pow(x1 - x2, 2) + Math.pow(y1 - y2, 2));
      }	
   }