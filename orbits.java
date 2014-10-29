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
		//still dosnt work out bounds
	xpos[0]=1.0;
	ypos[0]=0.0;
	xvel[0]=0.0;
	yvel[0]=0.0;
	double dt=0.001;
	double r=1;
	int loc= 1;

	for(double i=.001 ; i<1000 ; i=i+.001){
	if(i==.001)		r=Math.sqrt(xpos[loc]*xpos[loc] + (ypos[loc]*ypos[loc]));
	
	xvel[loc]=xvel [loc-1]-((4*pi*xpos[loc-1]*.001)/(r*r*r));
	yvel[loc]=yvel [loc-1]-((4*pi*ypos[loc-1]*.001)/(r*r*r));
	
	
	xpos[loc]=xpos[i-1]+xvel[loc]*dt;				//fixed x position
	ypos[loc]=ypos[i-1]+yvel[loc]*dt;				//fixed y pos
	
	loc++;
	
	}
	graph();
	}
	
	private void graph() {
		 //untested
		  // create your PlotPanel (you can use it as a JPanel)
		  Plot2DPanel plot = new Plot2DPanel();
		 
		  // add a line plot to the PlotPanel
		  plot.addLinePlot("my plot", xpos, ypos);
		 
		  // put the PlotPanel in a JFrame, as a JPanel
		  JFrame frame = new JFrame("a plot panel");
		  frame.setContentPane(plot);
		  frame.setVisible(true);
		
	}

}
