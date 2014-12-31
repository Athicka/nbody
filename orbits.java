import javax.swing.JFrame;
import java.util.Scanner;
 
            import org.math.plot.*;
            JFrame frame = new JFrame("a plot panel");
 
public class orbits {
Plot2Dpanel plot = new Plot2DPanel();
 
            Scanner input = new Scanner(System.in);
        
ArrayList<planets> p = new ArrayList<planets>();
p.add("Sun",332,946.0, 0,0);
p.add("Earth",1,1,0);
p.add("Jupiter",5.2,0,1.52);
 
 
            double pi = 3.14159;
 
 
            public static void main (String [] args){
            
            orbits a = new orbits();
            
            
 
}
            void round(){
            double[] xpos = new double[1000];
            double[] ypos = new double[1000];
            double[] xvel = new double[1000];
            double[] yvel = new double[1000];
            
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
            graph();
            }
            
            private void grap2() {
                         
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
 
 
*/  
            double xpos;
        double ypos;
        double xvel;
        double yvel;
        double forcex;
        double forcey;
                    
            
            
            double r;
        
 
        
         for(int i=1;i<p.length;i++){
                         
             for(double j=.001;j<1;j+=.001){
                                    
                      
             for(int t=0;t<p.length;t++){
             forcex=0;
             forcey=0;
             r=sqrt(p.get(i).getXpos()*p.get(i).getXpos())*(p.get(t).getYpos()*(p.get(t).getYpos());
             forcex=-(p.get(i).getMass()*p.get(t).getMass()*(p.get(i).getXpos())-p.get(t).getYpos())/(r*r*r);
             forcey=-(p.get(i).getMass()*p.get(t).getMass()*(p.get(i).getYpos())-p.get(t).getYpos())/(r*r*r);           
                          
                 xpos=p.get(i).getXpos()+forcex;
                 p.get(i).setXpos(xpos);
                 ypos=p.get(i).getYpos()+forcey;
                 p.get(i).setYpos(ypos);
                              
                                    }
                        graphN(p.get(i).getXpos(),p.get(i).getYpos());
                        // need to calculate cumulative xvelocities. What used for???
                        }
                        
            }
            
            
            
}
                          frame.setContentPane(plot);
                          frame.setVisible(true);
                          //makes it appear semi centered
                          frame.setLocation(250, 250);
                          frame.setSize(600, 600);
 
}
 
 
void addNew(){
Double x;
Double y;
Double m;
x = input.next();     // might needs tweaking
y = input.next();
m = input.next();
p.add(“Other”);
data.addOther(x,y,m);
 
}
