package lab3.uwaterloo.ca.lab3_202_24;

/**
 * Created by patri on 2017-03-05.
 */

interface Movement{
    public void setLocation(int x, int y);
    public int getX();
    public int getY();
}

public class Animator {
    Movement contextObject;
    Animator(Movement object){
        this.contextObject = object;
        
    }
}
