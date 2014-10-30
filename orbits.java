import javax.swing.JFrame;

	import org.math.plot.*;

public class orbits {

	double[] xpos = new double[1000];
	double[] ypos = new double[1000];
	double[] xvel = new double[1000];
	double[] yvel = new double[1000];
	




	double pi = 3.14159;


	public static void main (String [] args){
	
	orbits a = new orbits();
	a.round();
	

}
	void round(){
		
	xpos[0]=1.0;
	ypos[0]=0.0;
	xvel[0]=2.0;
	yvel[0]=2.0;
	double dt=0.01;
	double r=1;
	int loc= 1;
	
	for(double i=.01 ; i<1 ; i=i+.01){
	System.out.println(xpos[loc-1]);
	System.out.println(ypos[loc-1]);
	r=Math.sqrt((xpos[loc-1]*xpos[loc-1]) + (ypos[loc-1]*ypos[loc-1])); 
	
	xvel[loc]=xvel [loc-1]-((4*pi*xpos[loc-1]*dt)/(r*r*r));   
	yvel[loc]=yvel [loc-1]-((4*pi*ypos[loc-1]*dt)/(r*r*r));
	
	
	xpos[loc]=xpos[loc-1]+xvel[loc]*dt;				//fixed x pos
	ypos[loc]=ypos[loc-1]+yvel[loc]*dt;				//fixed y pos
	
	loc++;
	
	}
	graph();
	}
	
	private void graph() {
		  
		  // create your PlotPanel (you can use it as a JPanel)
		  Plot2DPanel plot = new Plot2DPanel();
		 
		  // add a line plot to the PlotPanel
		  plot.addLinePlot("my plot", xpos, ypos);
		  //why is it graphing the first point at (0,0) not (1,0)
		  
		  // put the PlotPanel in a JFrame, as a JPanel
		  JFrame frame = new JFrame("a plot panel");
		 
		  frame.setContentPane(plot);
		  frame.setVisible(true);
		  //makes it appear semi centered
		  frame.setLocation(250, 250);
		  frame.setSize(600, 600);
		
	}

}
