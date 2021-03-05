import java.util.ArrayList;
/**
 * Write a description of class DinoDriver2 here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class DinoDriver2
{
    public static void main(String[] args)
    {
        //Dinosaur[] pop = new Dinosaur[25];
                                                                                                                                                                                                                               //Create an arraylist of dinos called dinopop
        ArrayList <Dinosaur> dinoPop = new ArrayList<Dinosaur>();
        for(int i= 0; i< 25; i++)
        {
            double rand = Math.random();
            if(rand < 0.33)// make a TRex
            {
              Dinosaur t = new TRex();
              dinoPop.add(t);
            }
            else if (rand < 0.67 && rand > 0.33) //velociraptor
            {
                Dinosaur t = new Velociraptor ();
              dinoPop.add(t);
            }
            else // make pterydactyl 
            {
              dinoPop.add( new pterydactyl());
            }
            DinoDriver2.growUp(dinoPop);
            System.out.println(dinoPop);
        }
          /*
            for(int i = 0; i < pop.length; i++)
            {
            double rand = Math.random();// random decimal
            if(rand <0.33)
            {
            pop[i] = new TRex();
            }
            else if (rand < 0.67)
            {
            pop[i] = new Velociraptor();
            }
            else
            {
            pop [i] = new pterydactyl();
            }
            
            }
            */

        for(int i =0; i < 7; i++)
        {
        System.out.println(" ###################### Round "+(i+1)+ " #####################");
        DinoDriver2.battleRound(dinoPop);
        }
        //output my population
        //for(int i = 0; i < pop.length; i++)
        for( Dinosaur d : dinoPop )// d gets assigned to pop[i]
        {

         System.out.println(d);
         
       }
    }
    //Dinosaur t1 = new TRex();// store a child in a parent, cannot do the reverse b/c 
    //TRex is more specific than the parent class
    //TRex t2 = new TRex();
    //DinoDriver2.growUp(t1);
    //Dinosaur t3 = t1;//these are alliases of each other
    //.getbattleFactor(t2));

    private static void battleRound(ArrayList<Dinosaur> p)
    {
        //modify this code to call update method with correct
        //dinos winning and losing.
        /*
        System.out.println("\t"+p[0]);
        System.out.println("\t"+p[1]);
         */
        int attWins = 0;
        int battles = 0;
        
        //traverse the array, and have all dinos battle one other random
        for(Dinosaur d : p )
        {

            if(d.getHealth() >0)
            {
                int rand;

                int x = 0;
                do
                {
                    rand = (int)(Math.random()*p.size());

                    //System.out.println("\t" + p[rand].getType() + " " + p[rand].getHealth());

                }while(p.get(rand)==d || (p.get(rand).getHealth() == 0));

                battles++;

                if(d.attack(p.get(rand)))
                {
                    d.update(p.get(rand));
                    attWins++;
                }
                else
                {
                    p.get(rand).update(d);
                }
            }
            System.out.println("**************** Total Battles " + battles+ " & attacker wins " + attWins +"\t" );
            
        }

    }

    private static void growUp(ArrayList<Dinosaur> p)// d = t1, they're alliases
    {
        int rand = (int)(Math.random()*35);   
        //d.setbattleCount(rand);
        for( int i=0; i < rand; i++)
            p.ageUp();

    }

}
