package Behaviours;


import jade.core.Agent;
import jade.core.behaviours.OneShotBehaviour;
import jade.lang.acl.ACLMessage;


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
            ACLMessage msg = receive();

            if (msg != null)
                System.out.println(msg);

            int temp = 20;
            String str;
            if (temp < this.TEMP_MIN)
            {
                str = "Heating on";
            }
            else if (temp > this.TEMP_MAX)
            {
                str = "Refrigeration on";
            }
            else {
                str = "Idle temperature";
            }
            System.out.println(str);
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
