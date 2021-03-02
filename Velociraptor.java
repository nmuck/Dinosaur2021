
/**
 * Write a description of class Velociraptor here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Velociraptor extends Dinosaur
{
    // instance variables - replace the example below with your own
    private int x;

    /**
     * Constructor for objects of class Velociraptor
     */
    public Velociraptor()
    {
        super("Velociraptor");
    }
    
    public boolean attack(Dinosaur other)
    {
        int rand1 = (int) Math.random();
        int rand2 = (int) Math.random();
        double bf1 = this.getbattleFactor(other);
        double bf2 = other.getbattleFactor(this);
        int attacker = (int) bf1*rand1*101;
        int weighting = 0;
        boolean result = false;
        if(other.getType().equals( this.getType()))
        {
            weighting = (rand2*30)+55;
        }
        else if(other.getType().equals("TRex"))
        {
            weighting = (rand2*30)+40;
        }
        else if(other.getType().equals("pterydactyl"))
        {
            weighting = (rand2*30)+45;
        }
        bf2 = bf2*weighting;
        if(attacker-bf2 > -1)
        {
            return true;
        }
        return result;
    }

    /**
     * An example of a method - replace this comment with your own
     *
     * @param  y  a sample parameter for a method
     * @return    the sum of x and y
     */
    public String toString()
    {
       if(this.getAge() == 0)
         return super.toString();//calls method of the parent class 
        else
       return this.getType() +" "+ this.getWins() +" "+this.getbattleCount() +" "+ this.getHealth();
    }
}
