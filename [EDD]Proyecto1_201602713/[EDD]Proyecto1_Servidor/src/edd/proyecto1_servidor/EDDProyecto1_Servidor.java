/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edd.proyecto1_servidor;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
import com.rabbitmq.client.DeliverCallback;

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
    
    private final static String QUEUE = "adios";
    public static String posI = "";
    public static String posF = "";
    public static String jugador = "";
    private static int c = 0;

    public String posI() {
        return posI;
    }

    public String posF() {
        return posF;
    }

    public String jugador() {
        return jugador;
    }

    public void actualizarPosJugador() throws Exception {
        ConnectionFactory factory = new ConnectionFactory();
        factory.setHost("localhost");
        Connection connection = factory.newConnection();
        Channel channel = connection.createChannel();

        channel.queueDeclare(QUEUE, false, false, false, null);
        System.out.println(" [*] Waiting for messages. To exit press CTRL+C");

        c = 0;
        DeliverCallback deliverCallback = (consumerTag, delivery) -> {
            switch (c) {
                case 0:
                    posI = new String(delivery.getBody(), "UTF-8");
                    System.out.println(" [x] Received '" + posI + "'");
                    c++;
                    break;
                case 1:
                    posF = new String(delivery.getBody(), "UTF-8");
                    System.out.println(" [x] Received '" + posF + "'");
                    c++;
                    break;
                case 2:
                    jugador = new String(delivery.getBody(), "UTF-8");
                    System.out.println(" [x] Received '" + jugador + "'");
                    c++;
                    break;
                default:
                    break;
            }
        };
        channel.basicConsume(QUEUE, true, deliverCallback, consumerTag -> {
        });
    }

}
