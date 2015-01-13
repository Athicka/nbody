
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
 
 
            public static void main (String [] args){
            
            orbits a = new orbits();
            
            a.nbody();
            
 
}
            void round(){
            Double[] xpos = new Double[1000];
            Double[] ypos = new Double[1000];
            Double[] xvel = new Double[1000];
            Double[] yvel = new Double[1000];
            
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
            
            
            xpos[loc]=xpos[loc-1]+xvel[loc]*dt;                                                //fixed x pos
            ypos[loc]=ypos[loc-1]+yvel[loc]*dt;                                                //fixed y pos
            
            loc++;
            
            }
           // graph2(xpos,ypos);
            }
            /*
            private void graph2(Double [] xpos, Double[] ypos) {
                         
                          // create your PlotPanel (you can use it as a JPanel)
                          Plot2DPanel plot = new Plot2DPanel();
                         
                          // add a line plot to the PlotPanel
                          plot.addLinePlot("my plot", xpos, ypos);
                         
                          
                          // put the PlotPanel in a JFrame, as a JPanel
                          JFrame frame = new JFrame("a plot panel");
                         
                          frame.setContentPane(plot);
                          frame.setVisible(true);
                          //makes it appear semi centered
                          frame.setLocation(250, 250);
                          frame.setSize(600, 600);
                        
            }
    
        private void graphN(double xpos,double ypos){
                  double[] xposs = new double[1];
                  double[] yposs = new double[1];
                  xposs[0]=xpos;
                  yposs[0]=ypos;
                  
                  plot.addScatterPlot("Orbits",xposs,yposs);
                         
 
 
 
         }    */
 
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
p.add(new planets("Jupiter",5.2,0.0,1.52,,1.0,1.0));
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
            
            double r;
        
 


 for(double i=.01 ; i<1 ; i=i+.01 , loc++){

// calculate positon of jupiter with cintripital 

r = Math.squrt((p.get(2).getXpos() * p.get(2).getXpos() ) + (p.get(2).getYpos() * p.get(2).getYpos() ));


xvel =p.get(2).getXpos() - ((4 * pi * p.get(2).getXpos() * dt )/(r*r*r));

p.get(2).setXvel(xvel);
yvel =p.get(2).getYpos() - ((4 * pi * p.get(2).getYpos() * dt )/(r*r*r));
p.get(2).setYvel(yvel);
xpos=p.get(2).getXpos()+p.get(2).getXvel() * dt; 
ypos=p.get(2).getYpos()+p.get(2).getYvel() * dt; 
p.get(2).setXpos(xpos);
p.get(2).setYpos(xpos);

txpos[2][loc]= xpos;
typos[2][loc]= ypos;

// Earth 3 body problem

// Earth un effected orbit
r = Math.squrt((p.get(1).getXpos() * p.get(1).getXpos() ) + (p.get(1).getYpos() * p.get(1).getYpos() ));

xvel =p.get(1).getXpos() - ((4 * pi * p.get(1).getXpos() * dt )/(r*r*r));

yvel =p.get(2).getYpos() - ((4 * pi * p.get(1).getYpos() * dt )/(r*r*r));


// Effect added 

xvel = xvel -(((4*pi*)*(4*pi*))*(p.get(2).getMass()/p.get(1).getMass()) * ((p.get(1).getXpos() - p.get(2).getXpos() ) / (r*r*r)));
xpos = p.get(1).getXpos() + xvel * dt;

yvel = yvel -(((4*pi*)*(4*pi*))*(p.get(2).getMass()/p.get(1).getMass()) * ((p.get(1).getYpos() - p.get(2).getYpos() ) / (r*r*r)));
ypos = p.get(1).getYpos() + yvel * dt;

p.get(1).setXpos(xpos);
p.get(1).setYpos(xpos);

txpos[1][loc]= xpos;
typos[1][loc]= ypos;

}






                      //    frame.setContentPane(plot);
                        //  frame.setVisible(true);
                          //makes it appear semi centered
                          frame.setLocation(250, 250);
                          frame.setSize(600, 600);
                          for(int i=i;i<p.size();i++)
                        	  for(int t=0;t<1000;t++)
                        		  System.out.println(txpos[i][t] + " " + typos[i][t]);
                          
}
}
 
 

