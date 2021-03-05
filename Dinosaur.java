
/**
 * Write a description of class Dinosaur here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public abstract class Dinosaur
{
    // instance variables - replace the example below with your own
    private String type;
    private int age;
    private String gender;
    private int health;// a range between 0-100
    private int battleCount;
    private int wins;
    private static int population;// static can change
    //final int sum;// final is constant

    /**
     * Default Constructor for objects of class Dinosaur
     */
    public Dinosaur()
    {
        this.type = "Dino";
        this.age = 0;
        this.health = 10;
        int w = (int)(Math.random()*10);
        if ( w < 5)
        {
            this.gender = "male";
        }
        else
        {
            this.gender = "female";
        }
        System.out.println(w);
        // write code that will assign 50% to male and 50% to female genders

    }

    /**
     * Explicit Constructor for the Dino class. 
     */
    public Dinosaur(String t)
    {
        this.type = t;
        this.age = 0;
        this.health = 10;
        int w = (int)(Math.random()*10);
        if (w < 5)
        {
            this.gender = "male";
        }
        else
        {
            this.gender = "female";
        }
        this.wins = 0;
        this.battleCount = 0;
        Dinosaur.population = 1;
    }

    /**************** GETTER *********/
    //getters return private data
    public String getType()
    {
        return this.type;
    }

    public int getAge()
    {
        return this.age;
    }

    public String getGender()
    {
        return this.gender;
    }

    public int getHealth()
    {
        return this.health;
    }

    public int getbattleCount()
    {
        return this.battleCount;
    }

    public int getWins()
    {
        return this.wins;
    }

    public static int getPopulation()
    {
        return Dinosaur.population;
    }

    /**************** SETTER *********/
    //is going to set an instance variable to a new value--
    //changes balance after you deposit a check
    public void setAge( int a)
    {
        this.age = a;
    }

    public void setHealth(int h)
    {
        this.health = h;
    }

    public void setType(String t)
    {
        this.type = "Pterydactyl";
    }

    public void setGender(String t)
    {
        this.gender = "male";
    }

    public void setbattleCount(int b)
    {
        this.battleCount = b;
    }

    public void setWins()
    {
        this.wins = 0;
    }
    
    public static void setPopulation(int p)
    {
        Dinosaur.population = p;
    }

    public boolean equals(Dinosaur d)
    {
        if(this.type.equals(d.getType()) // I used getter to grab info from inside the constructor
        && (this.age == d.getAge()) 
        && (this.gender.equals(d.getGender()))
        && (this.health == d.getHealth()))
        {
            return true;
        }
        else 
        {
            return false;
        }
        //write code that will return true if two dinos are equal  
        //return true if they're equal. false otherise.

        /*
         * Clifford's solution
         * boolean same = false;
         * if(this.type.equals(d.getType())
         * {
         *     if(this.gender.equals(d.getGender())
         *     (
         *     int healthDiff = this.health - d.getHealth();
         *     if(Math.abs(healthDiff) < 10)
         *     same = true
         *     )
         *  }
         */

    }

    public void ageUp()
    {
        if(this.health > 0)
        {
            this.age++;
            if(this.age < 11)
                this.health = this.age * 10;
            //if age is less than 10, health increases by 10 
            //No change to health if age is between 10 & 24 
            else if (this.age > 24)
                this.health-=5;
            // health to decrease by 5 if age is betweeen 25-30
            else if( this.age > 30)
                this.health-=10;
            if(this.health <= 0)
            {
                this.setPopulation(this.getPopulation()-1);
            }
            // if health decreases by 10 if age is greater than 30 
        }
    }

    public double getbattleFactor(Dinosaur other)
    {
        double answer = 0;
        double hFactor = this.health/100.0;
        hFactor *= 0.67;
        double expFactor = 0;
        if(this.battleCount + other.getbattleCount() > 0)
       {
         expFactor = (double)this.battleCount/(this.battleCount+ other.getbattleCount());
         expFactor *= 0.33;
       }
        answer =hFactor + expFactor;
        return answer;

    }

     public void update(Dinosaur loser)
    {
        loser.setHealth(loser.getHealth()-10);
        this.setHealth(this.getHealth()-5);
        
        this.wins++;
        this.battleCount++; 
        
        if(loser.getHealth() <= 0)
        {
            loser.setHealth(0);
            
            loser.setPopulation(loser.getPopulation()-1);
            
        }
        System.out.println("\t" + loser + loser.wins + loser.battleCount);
        //System.out.println(this.wins+ "," + this.battleCount +","+ this.health);
        //System.out.print("\t"+loser.wins+ "/" + loser.battleCount +"/"+ loser.health);
        //loser.setbattleCount++;
         // reduce the health of the losing dino, 
        //i decide what happens to the winner???
        // increase the win count of this dino
        //increase battleCount for both
    }

    public abstract boolean attack (Dinosaur other);

    /**
     *Return this dinosaur as a String 
     */

    public String toString()
    {
        String answer = this.type + " " + this.age+ " " + this.health + " " + this.gender;
        return answer;
    }
}
