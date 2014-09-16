  /*****************************************************************
	* The Driver runs the program (BrickBreaker)
	*	 
	* @author Rachel Li
	* @author Rashid Lasker
	****************************************************************/
  
  import javax.swing.JFrame;
  
  public class Driver
  {
  	  /***************************************************************
   	* Runs the program (BrickBreaker)
   	**************************************************************/
     public static void main(String[] args)
     {
        JFrame frame = new JFrame("BrickBreaker");
        frame.setSize(500, 500);
        frame.setLocation(100, 50);   
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setContentPane(new StartPanel());
        frame.setVisible(true);
     }
	  
	  /***************************************************************
   	* Creates a new window to run the program (BrickBreaker)
   	**************************************************************/
	  public static void newGame()
 	 {
  		  JFrame frame = new JFrame("BrickBreaker");
        frame.setSize(500, 500);
        frame.setLocation(100, 50);   
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setContentPane(new StartPanel());
        frame.setVisible(true);
	  }
	}