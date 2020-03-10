package Behaviours;


import jade.core.AID;
import jade.core.Agent;
import jade.core.behaviours.CyclicBehaviour;
import jade.lang.acl.ACLMessage;

import java.lang.Integer;


/**
 * @author Arnau Ruana | @arnauruana
 */
public class CyclicBehaviourAgent extends Agent
{
    public class Thermostat extends CyclicBehaviour
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
            ACLMessage msg = receive();

            if (msg != null)
            {
                int temp = Integer.parseInt(msg.getContent());
                
                if (temp < this.TEMP_MIN)
                {
                    System.out.println("Heating on");
                }
                else if (temp > this.TEMP_MAX)
                {
                    System.out.println("Refrigeration on");
                }
                else
                {
                    System.out.println("Suitable temperature");
                }
            }
            else
            {
                block();
            }
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
