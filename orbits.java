
import javax.swing.JFrame;

import java.util.ArrayList;
//import org.math.plot.*;
public class orbits {
//Plot2DPanel plot = new Plot2DPanel();
	Double G = 1.1853E-4;  // <-- Not Correct Units   Double G = 75080000000.0; 
static JFrame frame = new JFrame(""); 
Double FXpos[][]= new Double[2][1000];
Double FYpos[][]= new Double[2][1000];
ArrayList<planets> p = new ArrayList<planets>();
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
i see how it gets complicated since all planets are moving and all pulling on each other.
force EJ = (-) G * mass J * mass E* (xpos earth - xpos jumpiter) / distace between planets ^3
repeat for y but trade out xpos with ypos for jupiter and earth
xpos = earthSunOrbit - xforce
ypos = earthSUnOrbit - yforce;
xvel = xVelEarthOrbit - G * mass jupiter (xpos earth - xpos jupiter) / distance between planets ^ 3

*/ p.add(new planets("Sun",332946.0, 0.0,0.0,0.0,0.0));
p.add(new planets("Earth",1.0,1.0,0.0,0.0,2.0 * pi));
p.add(new planets("Jupiter",5.2,0.0,1.52,-1.0 * pi,0.0));

// new

for(int n=0;n<1000;n++){

Double temp;
/*
temp = calcXvel(0);
p.get(0).setXvel(temp);
temp = calcYvel(0);
p.get(0).setYvel(temp);
*/ //										movement of sun
temp =calcXvel(1);
p.get(1).setXvel(temp);
temp =calcYvel(1);
p.get(1).setYvel(temp);

temp =calcXvel(2);
p.get(2).setXvel(temp);
temp =calcYvel(2);
p.get(2).setYvel(temp);



temp = calcXpos(p.get(1).getXvel(),1);
p.get(1).setXpos(temp);
temp = calcYpos(p.get(1).getYvel(),1);
p.get(1).setYpos(temp);
temp = calcXpos(p.get(2).getXvel(),2);
p.get(2).setXpos(temp);
temp = calcYpos(p.get(2).getYvel(),2);
p.get(2).setYpos(temp);


//System.out.println(p.get(1).getXvel() + " " + p.get(1).getYvel()); /////////////////////////////////
System.out.println(p.get(2).getXpos() + " " + p.get(2).getYpos()); /////////////////////////////////
System.out.println("");
} // N loop


//graphN(testX , testY);
//frame.add(plot);
//frame.setLocation(250, 250);
//frame.setSize(600, 600);
// frame.setVisible(true);

}
//methods !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
private double getDist(int i, int t) {
Double temp1;
Double temp2;
temp1 = (p.get(i).getXpos()- p.get(t).getXpos()) * (p.get(i).getXpos()- p.get(t).getXpos());
temp2 = (p.get(i).getYpos()- p.get(t).getYpos()) * (p.get(i).getYpos()- p.get(t).getYpos());
return Math.sqrt(temp1 + temp2);
}

public Double calcXpos(Double vel,int P){
Double temp;
temp = (p.get(P).getXpos())+vel* dt;
return temp;
}
public Double calcYpos(Double vel, int P){
Double temp;
temp = p.get(P).getYpos()+(vel* dt);
return temp;
}
public Double calcXvel(int i)
{
	int OP;
	if(i==2)
		OP =1;
	else
		OP = 2;
		
	Double temp,temp2;
	Double vel= p.get(i).getXvel();
	temp = (G * p.get(0).getMass()* (p.get(i).getXpos())) * dt;
	temp = temp /(getDist(i,0) *getDist(i,0) *getDist(i,0));
	temp2 = (G  * p.get(OP).getMass() * (p.get(i).getXpos() - p.get(OP).getXpos())) * dt;
	temp2 = temp2/ (getDist(i,OP) * getDist(i,OP) * getDist(i,OP));
	vel = vel - temp - temp2;
	
	return vel;
	
}
public Double calcYvel(int i)
{
	int OP;
	if(i==2)
		OP =1;
	else
		OP = 2;
		
	Double temp,temp2;
	Double vel= p.get(i).getYvel();
	temp = (G  * p.get(0).getMass()* (p.get(i).getYpos())) * dt;
	temp = temp /(getDist(i,0) *getDist(i,0) *getDist(i,0));
	
	temp2 = (G *  p.get(OP).getMass() * (p.get(i).getYpos() - p.get(OP).getYpos())) * dt;
	temp2 = temp2/ (getDist(i,OP) * getDist(i,OP) * getDist(i,OP));
	
	vel = vel - temp - temp2;
	
	return vel;
	
}
/*              
private void graphN(Double xpos[],Double ypos[]){
double temp[][]= new double[xpos.length][ypos.length];
plot.addScatterPlot("Orbits",Color.blue,temp);
frame.add(plot);
}
*/

}
