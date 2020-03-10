package Behaviours;


import jade.core.Agent;
import jade.core.behaviours.TickerBehaviour;

import java.util.Random;


/**
 * @author Arnau Ruana | @arnauruana
 */
public class TickerBehaviourAgent extends Agent
{
    public class Thermometer extends TickerBehaviour
    {
        public Thermometer(Agent agent, int period)
        {
            super(agent, period);
        }

        public void onStart()
        {
            System.out.println("Initialized agent: thermometer");
        }

        public void onTick()
        {
            Random rand = new Random();
            int temp = rand.nextInt(41) - 10;
            System.out.println("Send random temperature: " + temp);
        }

        public int onEnd()
        {
            System.out.println("Finalized agent: thermometer");
            return 0;
        }
    }

    protected void setup()
    {
        Thermometer t = new Thermometer(this, 10000);
        this.addBehaviour(t);
    }
}
