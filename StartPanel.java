   /*****************************************************************
	* BrickCollision is an object that holds all the information
	* about the game, such as the brick placement, colors, backgrounds, and score.
	* It is displayed onto the screen.
	
	* @author Rachel Li
	* @author Rashid Lasker
	****************************************************************/
	
	import javax.swing.*;
   import java.awt.*;
   import java.awt.event.*;
   import java.awt.image.*;

   public class StartPanel extends JPanel
   {
      private static final int FRAME = 400;
      private static final Color BACKGROUND = new Color(204, 204, 204);
      private ImageIcon backdrop;
      private Color one;
      private Color two;
      private BufferedImage myImage;
      private Graphics myBuffer;
      private Ball ball;
      private Paddle p;
      private Timer t;
      private int placement;
      private int totalBricks;
      private int countOut;
      private boolean[][] brickpos = new boolean[10][8];
      private Brick[][] brick = new Brick[10][8];
      private int hits = 0; 
   	
   	//constructor 
		/************************************************************* 
   	* Constructs a StartPanel with a Paddle, Ball, and Timer with a
		* Listener. The default background is gray. There are inputs for
		* the user, such as Background Selection, Brick Placement, and
		* Level Selection.
   	**************************************************************/  
      public StartPanel()
      {
         myImage =  new BufferedImage(FRAME, FRAME, BufferedImage.TYPE_INT_RGB);
         myBuffer = myImage.getGraphics();
         myBuffer.setColor(BACKGROUND);
         myBuffer.fillRect(0, 0, FRAME,FRAME);
         p = new Paddle();
         ball = new Ball();
         t = new Timer(5, new Listener());
      	
         addKeyListener(new Key());
         setFocusable(true);
      	
         for(int r = 0; r < 10; r++)
         {
            for(int c = 0; c < 8; c++)
            {
               brickpos[r][c] = true;
            }
         }
      	
         int background = 0;
         while((background != 1) && (background != 2) && (background != 3) && (background != 4))
         {
            String message = "";
            message = message + "\nBackground Selection";
            message = message + "\n1. Blue/Black Cubes";
            message = message + "\n2. Blue/Green Cubes";
            message = message + "\n3. Waterfall";
            message = message + "\n4. Default";
            message = message + "\n5. Quit";
            background = Integer.parseInt(JOptionPane.showInputDialog(message));
            switch(background)
            {
               case 1: 
                  backdrop = new ImageIcon("Blue_Black.jpg");
                  one = Color.BLUE.brighter();
                  two = Color.BLACK.brighter();
                  p.setColor(Color.WHITE);
                  ball.setColor(Color.GRAY);
                  break;
               case 2: 
                  backdrop = new ImageIcon("Blue_Green.jpg");
                  one = Color.BLUE.brighter();
                  two = Color.GREEN.brighter();
                  p.setColor(Color.WHITE);
                  ball.setColor(Color.GRAY);
                  break;
               case 3: 
                  backdrop = new ImageIcon("Waterfall.jpg");
                  one = Color.BLUE.brighter();
                  two = Color.GREEN.brighter();
                  ball.setColor(Color.GREEN);
                  p.setColor(Color.BLUE);
                  break;
               case 4: 
                  backdrop = new ImageIcon("Cubes.jpg");
                  one = Color.CYAN;
                  two = Color.PINK;
                  ball.setColor(Color.CYAN.brighter());
                  p.setColor(Color.PINK.brighter());
                  break;
               case 5: 
                  JOptionPane.showMessageDialog(null, "Exiting game.");
                  System.exit(0);
                  break;
               default: 
                  JOptionPane.showMessageDialog(null, "Not a valid selection.");
                  break;
            }
         }
      	
         int placement = 0;
         while((placement != 1) && (placement != 2) && (placement != 3) && (placement != 4))
         {
            String message = "";
            message = message + "\nBrick Placement";
            message = message + "\n1. All";
            message = message + "\n2. Checkerboard";
            message = message + "\n3. Alternating columns";
            message = message + "\n4. Alternating rows";
            message = message + "\n5. Quit";
            placement = Integer.parseInt(JOptionPane.showInputDialog(message));
            switch(placement)
            {
               case 1: 
                  for(int r = 0; r < 10; r++)
                  {
                     for(int c = 0; c < 8; c++)
                     {
                        brickpos[r][c] = true;
                     }
                  }
                  totalBricks = 0;
                  break;
               case 2: 
                  for(int r = 0; r < 10; r++)
                  {
                     for(int c = 0; c < 8; c++)
                     {
                        if(r % 2 == 0)
                        {
                           if(c % 2 == 0)
                              brickpos[r][c] = true;
                           if(c % 2 == 1)
                              brickpos[r][c] = false;
                        }
                        if(r % 2 == 1)
                        {
                           if(c % 2 == 0)
                              brickpos[r][c] = false;
                           if(c % 2 == 1)
                              brickpos[r][c] = true;
                        }
                     }
                  } 
                  totalBricks = 40;
                  break;
               case 3: 
                  for(int r = 0; r < 10; r++)
                  {
                     for(int c = 0; c < 8; c++)
                     {
                        if(r % 2 == 0)
                        {
                           brickpos[r][c] = false;
                        }
                        if(r % 1 == 1)
                        {
                           brickpos[r][c] = false;
                        }
                     }
                  } 
                  totalBricks = 40;
                  break;
               case 4: 
                  for(int r = 0; r < 10; r++)
                  {
                     for(int c = 0; c < 8; c++)
                     {
                        if(c % 2 == 0)
                        {
                           brickpos[r][c] = true;
                        }
                        if(c % 2 == 1)
                        {
                           brickpos[r][c] = false;
                        }
                     }
                  }
                  totalBricks = 40;
                  break;
               case 5: 
                  JOptionPane.showMessageDialog(null, "Exiting game.");
                  System.exit(0);
                  break;
               default: 
                  JOptionPane.showMessageDialog(null, "Not a valid selection.");
                  break;
            }
         }
      
         int choice = 0;
         while((choice != 1) && (choice != 2) && (choice != 3))
         {
            String message = "";
            message = message + "\nLevel Selection";
            message = message + "\n1. Easy";
            message = message + "\n2. Medium";
            message = message + "\n3. Hard";
            message = message + "\n4. Quit";
            choice = Integer.parseInt(JOptionPane.showInputDialog(message));
            switch(choice)
            {
               case 1: 
                  JOptionPane.showMessageDialog(null, "Ready to play?");
                  ball.setdx(1);
                  ball.setdy(-2);
                  t.start();
                  break;
               case 2: 
                  JOptionPane.showMessageDialog(null, "Ready to play?");
                  ball.setdx(2);
                  ball.setdy(-3);
                  t.start();
                  break;
               case 3: 
                  JOptionPane.showMessageDialog(null, "Ready to play?");
                  ball.setdx(4);
                  ball.setdy(-4);
                  t.start();
                  break;
               case 4: 
                  JOptionPane.showMessageDialog(null, "Exiting game.");
                  System.exit(0);
                  break;
               default: 
                  JOptionPane.showMessageDialog(null, "Not a valid selection.");
                  break;
            }
         }
      }
		
		/*************************************************************** 
   	* Paints the image onto the screen.
   	**************************************************************/  	
      public void paintComponent(Graphics g)
      {
         g.drawImage(myImage, 0, 0, getWidth(), getHeight(), null);
      }
		
		/*************************************************************** 
   	* Plays the actual game. Updates the screen by repainting the
		* bricks, background, ball, paddle, and score.
   	**************************************************************/  	
      private class Listener implements ActionListener
      {
         public void actionPerformed(ActionEvent e)
         {
            myBuffer.drawImage(backdrop.getImage(), 0, 0, FRAME, FRAME, null);
           
            ball.move(FRAME, FRAME);
            collide(ball, p);
            ball.draw(myBuffer);
            p.draw(myBuffer);
         	
            for(int r = 0; r < 10; r++)
            {
               for(int c = 0; c < 8; c++)
               {
                  if(brickpos[r][c] == true)
                  {
                     brick[r][c] = new Brick(r * 45, c * 15);
                     if(r % 2 == 0)
                     {
                        if(c % 2 == 0)
                           brick[r][c].setColor(one);
                        if(c % 2 == 1)
                           brick[r][c].setColor(two);
                     }
                     if(r % 2 == 1)
                     {
                        if(c % 2 == 0)
                           brick[r][c].setColor(two);
                        if(c % 2 == 1)
                           brick[r][c].setColor(one);
                     }
                     brick[r][c].draw(myBuffer, brickpos[r][c]);
                  }
               }
            } 
            BrickCollision.collide(brick, ball, brickpos);
         	
            countOut = 0;
            for(int r = 0; r < 10; r++)
            {
               for(int c = 0; c < 8; c++)
               {
                  if(brickpos[r][c] == false)
                  {
                     countOut++;
                  }
               }
            }
            hits = countOut - totalBricks;
         	
         	//newGame
            if(ball.getX() == 600)
            {
               int choice = 0;
               while((choice != 1) && (choice != 2))
               {
                  String message = "";
                  message = message + "\nYou lost! What would you like to do?";
                  message = message + "\n1. Play again.";
                  message = message + "\n2. Quit.";
                  choice = Integer.parseInt(JOptionPane.showInputDialog(message));
                  switch(choice)
                  {
                     case 1: 
                        Driver.newGame();
                        break;
                     case 2: 
                        JOptionPane.showMessageDialog(null, "Exiting game.");
                        System.exit(0);
                        break;
                     default: 
                        JOptionPane.showMessageDialog(null, "Not a valid selection.");
                        break;
                  }
               }
            }
         	
            myBuffer.setColor(Color.WHITE);
            myBuffer.setFont(new Font("Monospaced", Font.BOLD, 24));
            myBuffer.drawString("Score:" + hits, FRAME - 150, 25);
            repaint();
         }
      } 
		
   	/***************************************************************
   	* Collide calculates the distance between the Ball and Paddle
		* and checks to see if they hit each other. If they do, the
		* direction of the Ball is reversed, so it "bounces."
   	* @param b		a Ball
		* @param p		a Paddle
   	**************************************************************/  	  
      private void collide(Ball b, Paddle p)
      {
      	//x-value (top left corner)
         double x1 = b.getX();
         double x2 = p.getX();
      	//y-value (top left corner)
         double y1 = b.getY();
         double y2 = p.getY();
      	//radii
         double r1 = b.getRadius();
         double r2 = p.getWidth();
      	//center coordinates (ball)
         double xx1 = x1 + r1;
         double yy1 = y1 + r1;
      	//center coordinates (paddle)
         double xx2 = x2 + r2;
         double yy2 = y2 + r2;
      	//calculates distance
         double d = Math.sqrt((Math.pow(xx2-xx1, 2)) + (Math.pow(yy2-yy1, 2)));
         double s = r1+r2;
        //Distance formula: sqrt(xx1-xx2)^2+(y1-y2)^2
         if(d <= s)
         {
            b.setdy(-1 * b.getdy());
         }
      }
   	
		/***************************************************************
   	* Finds the distance between two points
   	* @param xx1 the x-coordinate of the first point
		* @param yy1 the y-coordinate of the first point
		* @param xx2 the x-coordinate of the second point
		* @param yy2	the y-coordinate of the second point
		* @return d	distance between the two points
   	**************************************************************/    
      private double distance(double xx1, double yy1, double xx2, double yy2)
      {
         double dis1 = Math.pow(xx1 - xx2, 2);
         double dis2 = Math.pow(yy1 - yy2, 2);
         double d = Math.sqrt(dis2+dis1);
         return d;  	 // enter the calculation here.      
      }
   	
		/***************************************************************
   	* Takes input from the left and right arrow keys and causes the 
		* Paddle to move left and right, respectively.
   	**************************************************************/  
      private class Key extends KeyAdapter
      {
         public void keyPressed(KeyEvent e)
         {
            if(e.getKeyCode() == KeyEvent.VK_LEFT)
            {
               if(p.getX() <= FRAME - 400)	//hits the left edge
                  p.setX(FRAME - 400);
               else
                  p.setX(p.getX() - 5);
            }
            if(e.getKeyCode() == KeyEvent.VK_RIGHT)
            {
               if(p.getX() >= FRAME - p.getWidth())			//hits the right edge
                  p.setX(FRAME - p.getWidth()); 
               else
                  p.setX(p.getX() + 5);           
            }
         }
      }
   }