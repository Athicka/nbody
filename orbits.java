
import javax.swing.JFrame;

import java.util.ArrayList;
//import org.math.plot.*;
           
 
public class orbits {
 

//Plot2Dpanel plot = new Plot2DPanel();
  JFrame frame = new JFrame("");
            
        
ArrayList<planets> p = new ArrayList<planets>();
 Double [][] txpos = new Double[p.size()][1000];
 Double [][] typos = new Double[p.size()][1000];
 
            double pi = 3.14159;
            Double dt = .001;
 
            public static void main (String [] args){
            
            orbits a = new orbits();
            
            a.nbody();
            
 
}
     
private void nbody(){
/*
no longers mass independent
will we have to keep track of where jupiter or locaiton of other plantets? Keep track of all locations
using jupiter to start with 3-body program
i see how it gets complicated sincde all planets are moving and all pulling on each other.
 
 
force EJ = (-) G * mass J * mass E* (xpos earth - xpos jumpiter)  / distace between planets ^3
 
repeat for y but tade out xpos with ypos for jupiter and earth
 
xpos = earthSunOrbit - xforce
ypos = earthSUnOrbit - yforce;
 
xvel = xVelEarthOrbit -  G * mass jupiter (xpos earth - xpos jupiter)  / distance between planets ^ 3
 
 
*/  p.add(new planets("Sun",332946.0, 0.0,0.0,0.0,0.0));
p.add(new planets("Earth",1.0,1.0,0.0,2.0,2.0));
p.add(new planets("Jupiter",5.2,0.0,1.52,1.0,1.0));
Double [][] txpos = new Double[p.size()][1000];
Double [][] typos = new Double[p.size()][1000];
            double xpos;
        double ypos;
        double xvel;
        double yvel;
        double forcex;
        double forcey;
                 double dt=0.01;   
            int loc =0;
            Double [][] forcesX = new Double[p.size()][p.size()-1];
	Double [][] forcesY = new Double[p.size()][p.size()-1];
	
            double r;
        
 

// new
for(int n =0; n<1000;n++){
for(int i=0;i<p.size();i++){
	for(int t=0;t<p.size()-1;t++){
		r = getDist(i,t);
if(t!=i){
forcesX[i][t]= calcForceX(i,t,r);
forcesY[i][t]= calcForceY(i,t,r);


}

}


}
Double forceTX[] = new Double[p.size()];
for(int t=0;t<p.size();t++){
for(int i=0;i<p.size()-1;i++){
		forceTX[t]+=forcesX[t][i];
	
}
}

Double forceTY[] = new Double[p.size()];
for(int t=0;t<p.size();t++){
for(int i=0;i<p.size()-1;i++){
		forceTY[t]+=forcesY[t][i];
	
}
}

for(int i=1;i<p.size();i++){
	Double temp;
	temp = dt * forceTX[i] / p.get(i).getMass();
	p.get(i).setXvel(temp);
	temp = dt * forceTY[i] / p.get(i).getMass();
	p.get(i).setYvel(temp);
	
	
	temp = calcXpos(p.get(i).getXvel(),i);
	p.get(i).setXpos(temp);
	
	temp = calcYpos(p.get(i).getYvel(),i);
	p.get(i).setYpos(temp);
}
	for(int w=0;w<p.size();w++){
		System.out.println(p.get(w).getXpos() + " " + p.get(w).getYpos());
		System.out.println("");
	}
	
}

}


private double getDist(int i, int t) {
				Double temp1;
				Double temp2;
				temp1 = (p.get(i).getXpos()- p.get(t).getXpos()) * (p.get(i).getXpos()- p.get(t).getXpos());
				temp2 = (p.get(i).getYpos()- p.get(t).getYpos()) * (p.get(i).getYpos()- p.get(t).getYpos());
				return Math.sqrt(temp1 + temp2);
			}

public Double calcForceX(int p1, int p2,Double r){
Double G = 16197000000.0; 
Double temp;

temp = G* p.get(p1).getMass() * p.get(p2).getMass() *(p.get(p1).getXpos()- p.get(p2).getXpos());

temp/=(r*r*r);
return (temp * (p.get(p2).getXpos() - p.get(p1).getXpos() )) /r;
}

public Double calcForceY(int p1, int p2,Double r){
Double G = 16197000000.00; 
Double temp;

temp = G* p.get(p1).getMass() * p.get(p2).getMass() *(p.get(p1).getYpos()- p.get(p2).getYpos());

temp/=(r*r*r);
return (temp * (p.get(p2).getYpos() - p.get(p1).getYpos() )) /r;
}

public Double calcXpos(Double vel, int p1){
Double temp;

temp = (p.get(p1).getXpos())-(vel* dt);
return temp;

}

public Double calcYpos(Double vel, int p1){
Double temp;

temp = p.get(p1).getYpos() - (vel* dt);
return temp;

}

public Double calcXvel(Double Fx, int p1)
{

	Double temp;
	temp = dt* (Fx / p.get(p1).getMass());
	
	return temp;
	
}

public Double calcYvel(Double Fy, int p1)
{

	Double temp;
	temp = dt* (Fy / p.get(p1).getMass());
	
	return temp;
	
}

}
 
