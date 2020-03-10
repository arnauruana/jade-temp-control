package Behaviours;


import jade.core.Agent;
import jade.core.behaviours.OneShotBehaviour;

import java.util.Random;


/**
 * @author Arnau Ruana | @arnauruana
 */
public class OneShotBehaviourAgent extends Agent
{
    public class Thermostat extends OneShotBehaviour
    {
        private static final int TEMP_MAX = 25;
        private static final int TEMP_MIN = 15;

        public Thermostat() {}

        public void onStart()
        {
            System.out.println("Initialized agent: thermostat");
        }

        public void action()
        {
            String msg;

            Random rand = new Random();
            int temp = rand.nextInt(41) - 10;
            System.out.println(temp);

            if (temp < this.TEMP_MIN)
            {
                msg = "Heating on";
            }
            else if (temp > this.TEMP_MAX)
            {
                msg = "Refrigeration on";
            }
            else {
                msg = "Idle temperature";
            }
            System.out.println(msg);
        }

        public int onEnd()
        {
            System.out.println("Finalized agent: thermostat");
            return 0;
        }
    }

    protected void setup()
    {
        Thermostat t = new Thermostat();
        this.addBehaviour(t);
    }
}
