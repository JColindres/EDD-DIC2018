/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edd.proyecto1_cliente;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
import com.rabbitmq.client.DeliverCallback;

/**
 *
 * @author pablo
 */
public class EDDProyecto1_Cliente {

    /**
     * @param args the command line arguments
     */
    private final static String QUEUE_NAME = "hello";
    public static String message = "";
    public static String messageC = "";
    public static String messageF = "";
    private static int c = 0; ;
    
    public String mensajemapa() {
        return message;
    }

    public int mensajemapaC() {
        int hh = Integer.parseInt(messageC);
        return hh;
    }

    public int mensajemapaF() {
        int hh = Integer.parseInt(messageC);
        return hh;
    }
    
    
    public void runMapa() throws Exception {
        ConnectionFactory factory = new ConnectionFactory();
        factory.setHost("localhost");
        Connection connection = factory.newConnection();
        Channel channel = connection.createChannel();

        channel.queueDeclare(QUEUE_NAME, false, false, false, null);
        System.out.println(" [*] Waiting for messages. To exit press CTRL+C");

        DeliverCallback deliverCallback = (consumerTag, delivery) -> {
            if (c == 0) {
                messageC = new String(delivery.getBody(), "UTF-8");
                System.out.println(" [x] Received '" + messageC + "'");
                c++;
            }else if(c == 1){
                messageF = new String(delivery.getBody(), "UTF-8");
                System.out.println(" [x] Received '" + messageF + "'");
                c++;                
            }else if(c == 2){
                message = new String(delivery.getBody(), "UTF-8");
                System.out.println(" [x] Received '" + message + "'");
                c++;                
            }
        };
        channel.basicConsume(QUEUE_NAME, true, deliverCallback, consumerTag -> {
        });
    }

}
