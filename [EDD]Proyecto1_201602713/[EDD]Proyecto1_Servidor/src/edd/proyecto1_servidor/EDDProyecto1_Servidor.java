/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edd.proyecto1_servidor;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

/**
 *
 * @author pablo
 */
public class EDDProyecto1_Servidor {

    /**
     * @param args the command line arguments
     */
    private final static String QUEUE_NAME = "hello";
    public static String message = "";
    public static String messageC = "";
    public static String messageF = "";

    public void mensajemapa(String h) {
        message = h;
    }
    
    public void mensajemapaC(int h) {
        String hh = Integer.toString(h);
        messageC = hh;
    }
    
    public void mensajemapaF(int h) {
        String hh = Integer.toString(h);
        messageF = hh;
    }

    public void enviarmapa() throws Exception {
        ConnectionFactory factory = new ConnectionFactory();
        factory.setHost("localhost");
        try (Connection connection = factory.newConnection();
                Channel channel = connection.createChannel()) {
            channel.queueDeclare(QUEUE_NAME, false, false, false, null);
            channel.basicPublish("", QUEUE_NAME, null, messageC.getBytes("UTF-8"));
            channel.basicPublish("", QUEUE_NAME, null, messageF.getBytes("UTF-8"));
            channel.basicPublish("", QUEUE_NAME, null, message.getBytes("UTF-8"));
            System.out.println(" [x] Sent '" + message + "'");
            //Thread.sleep(5000);

        }
    }

}
