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
	ypos[loc]=(ypos[loc-1]*19891*9.81)/(r*r*r);

	loc++;
	
	}
	
	}


}
