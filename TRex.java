
/**
 * Write a description of class TRex here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class TRex extends Dinosaur
{
    // instance variables - replace the example below with your own
    private int numEaten;// specific only to TRex class not dinosaurs

    /**
     * Constructor for objects of class TRex
     */
    public TRex()
    {
       //super(); must be the first line of constructor
        super("TRex");// calls the default constructor of the parent class 
        this.numEaten = 0;
    }
    
    public boolean attack(Dinosaur other)
    {
        int rand1 = (int) Math.random();
        int rand2 = (int) Math.random();
        double bf1 = this.getbattleFactor(other);
        double bf2 = other.getbattleFactor(this);
        int attacker = (int) bf1*rand1*101;
        boolean result = false;
        if(other.getType().equals( this.getType()))
        {
            if(attacker-bf2*(rand2*101)>0)
             result = true;
        }
        else if(other.getType().equals("Velociraptor"))
        
        {
            if(attacker-bf2*(rand2*91)>0)
             result = true;
        }
        else if(other.getType().equals("pterydactyl"))
        {
            if(attacker-bf2*(rand2*81)>0)
             result = true;
        }
       
        return result;
    }

    /**
     * An example of a method - replace this comment with your own
     *
     * @param  y  a sample parameter for a method
     * @return    the sum of x and y
     */
    public String toString ()
    {
        //if(this.getAge() == 0)
        // return super.toString();//calls method of the parent class 
       // else
       // return this.getType() +" "+ this.getWins()+" "+this.getbattleCount()+" "+ this.getHealth();
       return this.getType()+" "+this.getAge()+" "+this.getHealth();
    }
}
