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
    private final static String stringMapa = "stringMapa";
    private final static String stringMapaC = "stringMapaC";
    private final static String stringMapaF = "stringMapaF";
    private final static String stringJ1 = "stringMapaJ1";
    private final static String stringJ2 = "stringMapaJ2";
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

    public void mensajeJ1(String h) {
        messageJ1 = h;
    }

    public void mensajeJ2(String h) {
        messageJ2 = h;
    }

    public void enviarmapa() throws Exception {
        ConnectionFactory factory = new ConnectionFactory();
        factory.setHost("localhost");
        try (Connection connection = factory.newConnection();
                Channel channel = connection.createChannel()) {
            channel.queueDeclare(stringMapa, false, false, false, null);
            channel.basicPublish("", stringMapa, null, message.getBytes("UTF-8"));
            System.out.println(" [x] Sent mapa '" + message + "'");
        }
    }
    
    public void enviarmapaC() throws Exception {
        ConnectionFactory factory = new ConnectionFactory();
        factory.setHost("localhost");
        try (Connection connection = factory.newConnection();
                Channel channel = connection.createChannel()) {
            channel.queueDeclare(stringMapaC, false, false, false, null);
            channel.basicPublish("", stringMapaC, null, messageC.getBytes("UTF-8"));
            System.out.println(" [x] Sent columnas '" + messageC + "'");
        }
    }
    
    public void enviarmapaF() throws Exception {
        ConnectionFactory factory = new ConnectionFactory();
        factory.setHost("localhost");
        try (Connection connection = factory.newConnection();
                Channel channel = connection.createChannel()) {
            channel.queueDeclare(stringMapaF, false, false, false, null);
            channel.basicPublish("", stringMapaF, null, messageF.getBytes("UTF-8"));
            System.out.println(" [x] Sent filas '" + messageF + "'");
        }
    }

    public void enviartropa1() throws Exception {
        ConnectionFactory factory = new ConnectionFactory();
        factory.setHost("localhost");
        try (Connection connection = factory.newConnection();
                Channel channel = connection.createChannel()) {
            channel.basicPublish("", stringJ1, null, messageJ1.getBytes("UTF-8"));
            System.out.println(" [x] Sent j1 '" + messageJ1 + "'");
        }
    }
    
    public void enviartropa2() throws Exception {
        ConnectionFactory factory = new ConnectionFactory();
        factory.setHost("localhost");
        try (Connection connection = factory.newConnection();
                Channel channel = connection.createChannel()) {
            channel.basicPublish("", stringJ2, null, messageJ2.getBytes("UTF-8"));
            System.out.println(" [x] Sent j2 '" + messageJ2 + "'");
        }
    }

    private final static String stringPOSI = "stringPOSI";
    private final static String stringPOSF = "stringPOSF";
    private final static String stringJugadorID = "stringJugadorID";
    private final static String ataquePOSI = "ataPOSI";
    private final static String ataquePOSF = "ataPOSF";
    private final static String ataqueJugadorID = "ataJugadorID";
    private final static String ataqueDano1 = "ataDano1";
    private final static String ataqueDano2 = "ataDano2";
    public static String jugador = "";
    public static String posI = "";
    public static String posF = "";
    public static String dano1 = "";
    public static String dano2 = "";

    public String posI() {
        return posI;
    }

    public String posF() {
        return posF;
    }

    public String jugador() {
        return jugador;
    }
    
    public String dano1(){
        return dano1;
    }
    
    public String dano2(){
        return dano2;
    }

    public void actualizarPosJugadorI() throws Exception {
        ConnectionFactory factory = new ConnectionFactory();
        factory.setHost("localhost");
        Connection connection = factory.newConnection();
        Channel channel = connection.createChannel();

        channel.queueDeclare(stringPOSI, false, false, false, null);
        System.out.println(" [*] Waiting for messages. To exit press CTRL+C");

        DeliverCallback deliverCallback = (consumerTag, delivery) -> {
                posI = new String(delivery.getBody(), "UTF-8");
                System.out.println(" [x] Received posI '" + posI + "'");
        };
        channel.basicConsume(stringPOSI, true, deliverCallback, consumerTag -> {
        });
    }
        
    public void actualizarPosJugadorF() throws Exception {
        ConnectionFactory factory = new ConnectionFactory();
        factory.setHost("localhost");
        Connection connection = factory.newConnection();
        Channel channel = connection.createChannel();

        channel.queueDeclare(stringPOSF, false, false, false, null);
        System.out.println(" [*] Waiting for messages. To exit press CTRL+C");

        DeliverCallback deliverCallback = (consumerTag, delivery) -> {
                posF = new String(delivery.getBody(), "UTF-8");
                System.out.println(" [x] Received posF '" + posF + "'");
        };
        channel.basicConsume(stringPOSF, true, deliverCallback, consumerTag -> {
        });
    }
        
    public void actualizarPosJugadorID() throws Exception {
        ConnectionFactory factory = new ConnectionFactory();
        factory.setHost("localhost");
        Connection connection = factory.newConnection();
        Channel channel = connection.createChannel();

        channel.queueDeclare(stringJugadorID, false, false, false, null);
        System.out.println(" [*] Waiting for messages. To exit press CTRL+C");

        DeliverCallback deliverCallback = (consumerTag, delivery) -> {
                jugador = new String(delivery.getBody(), "UTF-8");
                System.out.println(" [x] Received j '" + jugador + "'");
        };
        channel.basicConsume(stringJugadorID, true, deliverCallback, consumerTag -> {
        });
    }
    
    public void ataquePosJugadorI() throws Exception {
        ConnectionFactory factory = new ConnectionFactory();
        factory.setHost("localhost");
        Connection connection = factory.newConnection();
        Channel channel = connection.createChannel();

        channel.queueDeclare(ataquePOSI, false, false, false, null);
        System.out.println(" [*] Waiting for messages. To exit press CTRL+C");

        DeliverCallback deliverCallback = (consumerTag, delivery) -> {
                posI = new String(delivery.getBody(), "UTF-8");
                System.out.println(" [x] Received posI '" + posI + "'");
        };
        channel.basicConsume(ataquePOSI, true, deliverCallback, consumerTag -> {
        });
    }
        
    public void ataquePosJugadorF() throws Exception {
        ConnectionFactory factory = new ConnectionFactory();
        factory.setHost("localhost");
        Connection connection = factory.newConnection();
        Channel channel = connection.createChannel();

        channel.queueDeclare(ataquePOSF, false, false, false, null);
        System.out.println(" [*] Waiting for messages. To exit press CTRL+C");

        DeliverCallback deliverCallback = (consumerTag, delivery) -> {
                posF = new String(delivery.getBody(), "UTF-8");
                System.out.println(" [x] Received posF '" + posF + "'");
        };
        channel.basicConsume(ataquePOSF, true, deliverCallback, consumerTag -> {
        });
    }
        
    public void ataquePosJugadorID() throws Exception {
        ConnectionFactory factory = new ConnectionFactory();
        factory.setHost("localhost");
        Connection connection = factory.newConnection();
        Channel channel = connection.createChannel();

        channel.queueDeclare(ataqueJugadorID, false, false, false, null);
        System.out.println(" [*] Waiting for messages. To exit press CTRL+C");

        DeliverCallback deliverCallback = (consumerTag, delivery) -> {
                jugador = new String(delivery.getBody(), "UTF-8");
                System.out.println(" [x] Received j '" + jugador + "'");
        };
        channel.basicConsume(ataqueJugadorID, true, deliverCallback, consumerTag -> {
        });
    }
    
    public void ataqueDano1() throws Exception {
        ConnectionFactory factory = new ConnectionFactory();
        factory.setHost("localhost");
        Connection connection = factory.newConnection();
        Channel channel = connection.createChannel();

        channel.queueDeclare(ataqueDano1, false, false, false, null);
        System.out.println(" [*] Waiting for messages. To exit press CTRL+C");

        DeliverCallback deliverCallback = (consumerTag, delivery) -> {
                dano1 = new String(delivery.getBody(), "UTF-8");
                System.out.println(" [x] Received dano1 '" + dano1 + "'");
        };
        channel.basicConsume(ataqueDano1, true, deliverCallback, consumerTag -> {
        });
    }
    
    public void ataqueDano2() throws Exception {
        ConnectionFactory factory = new ConnectionFactory();
        factory.setHost("localhost");
        Connection connection = factory.newConnection();
        Channel channel = connection.createChannel();

        channel.queueDeclare(ataqueDano2, false, false, false, null);
        System.out.println(" [*] Waiting for messages. To exit press CTRL+C");

        DeliverCallback deliverCallback = (consumerTag, delivery) -> {
                dano2 = new String(delivery.getBody(), "UTF-8");
                System.out.println(" [x] Received dano2 '" + dano2 + "'");
        };
        channel.basicConsume(ataqueDano2, true, deliverCallback, consumerTag -> {
        });
    }

}
