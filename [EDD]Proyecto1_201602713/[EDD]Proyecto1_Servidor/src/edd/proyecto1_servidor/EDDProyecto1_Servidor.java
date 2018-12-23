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
    public static String messageJ1 = "";
    public static String messageJ2 = "";

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
    
    public void mensajeJ1(String h){
        messageJ1 = h;
    }
    
    public void mensajeJ2(String h){
        messageJ2 = h;
    }

    public void enviarmapa() throws Exception {
        ConnectionFactory factory = new ConnectionFactory();
        factory.setHost("localhost");
        try (Connection connection = factory.newConnection();
                Channel channel = connection.createChannel()) {
            channel.queueDeclare(QUEUE_NAME, false, false, false, null);
            channel.basicPublish("", QUEUE_NAME, null, messageC.getBytes("UTF-8"));
            System.out.println(" [x] Sent '" + messageC + "'");
            channel.basicPublish("", QUEUE_NAME, null, messageF.getBytes("UTF-8"));
            System.out.println(" [x] Sent '" + messageF + "'");
            channel.basicPublish("", QUEUE_NAME, null, message.getBytes("UTF-8"));
            System.out.println(" [x] Sent '" + message + "'");
            //Thread.sleep(5000);

        }
    }
    
    public void enviartropa12() throws Exception {
        ConnectionFactory factory = new ConnectionFactory();
        factory.setHost("localhost");
        try (Connection connection = factory.newConnection();
                Channel channel = connection.createChannel()) {
            channel.basicPublish("", QUEUE_NAME, null, messageJ1.getBytes("UTF-8"));
            System.out.println(" [x] Sent '" + messageJ1 + "'");
            channel.basicPublish("", QUEUE_NAME, null, messageJ2.getBytes("UTF-8"));
            System.out.println(" [x] Sent '" + messageJ2 + "'");
            //Thread.sleep(5000);

        }
    }

}
