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
    public static String messageJ1 = "";
    public static String messageJ2 = "";
    private static int c = 0;
    
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

    public String mensajeJ1() {
        return messageJ1;
    }

    public String mensajeJ2() {
        return messageJ2;
    }

    public void runMapa() throws Exception {
        ConnectionFactory factory = new ConnectionFactory();
        factory.setHost("localhost");
        Connection connection = factory.newConnection();
        Channel channel = connection.createChannel();

        channel.queueDeclare(QUEUE_NAME, false, false, false, null);
        System.out.println(" [*] Waiting for messages. To exit press CTRL+C");

        c = 0;
        DeliverCallback deliverCallback = (consumerTag, delivery) -> {
            switch (c) {
                case 0:
                    messageC = new String(delivery.getBody(), "UTF-8");
                    System.out.println(" [x] Received '" + messageC + "'");
                    c++;
                    break;
                case 1:
                    messageF = new String(delivery.getBody(), "UTF-8");
                    System.out.println(" [x] Received '" + messageF + "'");
                    c++;
                    break;
                case 2:
                    message = new String(delivery.getBody(), "UTF-8");
                    System.out.println(" [x] Received '" + message + "'");
                    c++;
                    break;
                case 3:
                    messageJ1 = new String(delivery.getBody(), "UTF-8");
                    System.out.println(" [x] Received '" + messageJ1 + "'");
                    c++;
                    break;
                case 4:
                    messageJ2 = new String(delivery.getBody(), "UTF-8");
                    System.out.println(" [x] Received '" + messageJ2 + "'");
                    c++;
                    break;
                default:
                    break;
            }
        };
        channel.basicConsume(QUEUE_NAME, true, deliverCallback, consumerTag -> {
        });
    }
    
    public static String posI = "";
    public static String posF = "";
    
    public void posI(String h){
        posI = h;
    }
    
    public void posF(String h){
        posF = h;
    }

    public void enviarmovimiento() throws Exception {
        ConnectionFactory factory = new ConnectionFactory();
        factory.setHost("localhost");
        try (Connection connection = factory.newConnection();
                Channel channel = connection.createChannel()) {
            channel.queueDeclare(QUEUE_NAME, false, false, false, null);
            channel.basicPublish("", QUEUE_NAME, null, posI.getBytes("UTF-8"));
            System.out.println(" [x] Sent '" + posI + "'");
            channel.basicPublish("", QUEUE_NAME, null, posF.getBytes("UTF-8"));
            System.out.println(" [x] Sent '" + posF + "'");
            //Thread.sleep(5000);

        }
    }

}
