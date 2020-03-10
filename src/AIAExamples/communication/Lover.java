/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package AIAExamples.communication;


import jade.core.AID;
import jade.core.Agent;
import jade.core.behaviours.OneShotBehaviour;
import jade.domain.DFService;
import jade.domain.FIPAAgentManagement.DFAgentDescription;
import jade.domain.FIPAException;
import jade.lang.acl.ACLMessage;
import jade.lang.acl.MessageTemplate;

import java.util.logging.Level;
import java.util.logging.Logger;


/**
 * @author igomez
 */
public class Lover extends Agent {
    AID OtherAID;

    public class SendMessageOneShotBehaviour extends OneShotBehaviour {
        public SendMessageOneShotBehaviour() {

        }

        public void action() {
            MessageTemplate template = MessageTemplate.MatchSender(OtherAID);
            ACLMessage message = myAgent.blockingReceive(template);
            System.out.println("I was lonely but my beloved '" + OtherAID.getLocalName() + "' is here!");
        }

    }

    protected void setup() {

        //Get the default directory facilitator
        AID df = getDefaultDF();

        //Register on the DF
        DFAgentDescription register_template = new DFAgentDescription();
        register_template.setName(getAID());

        try {
            DFService.register(this, df, register_template);
        } catch (FIPAException ex) {
            Logger.getLogger(Lover.class.getName()).log(Level.SEVERE, null, ex);
        }

        //Build Other's
        Object[] args = getArguments();
        OtherAID = new AID();
        OtherAID.setLocalName(args[0].toString());

        DFAgentDescription search_template = new DFAgentDescription();
        search_template.setName(OtherAID);

        DFAgentDescription[] search_results;
        try {
            search_results = DFService.search(this, df, search_template);
            if (search_results.length > 0) {
                System.out.println("My beloved '" + OtherAID.getLocalName() + "' is here!");
                ACLMessage msg = new ACLMessage(ACLMessage.INFORM);
                msg.addReceiver(OtherAID);


            } else {
                System.out.println("I am lonely...");
                SendMessageOneShotBehaviour b = new SendMessageOneShotBehaviour();
                this.addBehaviour(b);
            }
        } catch (FIPAException ex) {
            Logger.getLogger(Lover.class.getName()).log(Level.SEVERE, null, ex);
        }


    }
}
