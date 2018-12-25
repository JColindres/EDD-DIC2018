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

    public void runMapaC() throws Exception {
        ConnectionFactory factory = new ConnectionFactory();
        factory.setHost("localhost");
        Connection connection = factory.newConnection();
        Channel channel = connection.createChannel();

        channel.queueDeclare(stringMapaC, false, false, false, null);
        System.out.println(" [*] Waiting for messages. To exit press CTRL+C");

        DeliverCallback deliverCallback = (consumerTag, delivery) -> {
                messageC = new String(delivery.getBody(), "UTF-8");
                System.out.println(" [x] Received C'" + messageC + "'");
        };
        channel.basicConsume(stringMapaC, true, deliverCallback, consumerTag -> {
        });
    }
        
    public void runMapaF() throws Exception {
        ConnectionFactory factory = new ConnectionFactory();
        factory.setHost("localhost");
        Connection connection = factory.newConnection();
        Channel channel = connection.createChannel();

        channel.queueDeclare(stringMapaF, false, false, false, null);
        System.out.println(" [*] Waiting for messages. To exit press CTRL+C");

        DeliverCallback deliverCallback = (consumerTag, delivery) -> {
                messageF = new String(delivery.getBody(), "UTF-8");
                System.out.println(" [x] Received F'" + messageF + "'");
        };
        channel.basicConsume(stringMapaF, true, deliverCallback, consumerTag -> {
        });
    }
    
    public void runMapa() throws Exception {
        ConnectionFactory factory = new ConnectionFactory();
        factory.setHost("localhost");
        Connection connection = factory.newConnection();
        Channel channel = connection.createChannel();

        channel.queueDeclare(stringMapa, false, false, false, null);
        System.out.println(" [*] Waiting for messages. To exit press CTRL+C");

        DeliverCallback deliverCallback = (consumerTag, delivery) -> {
                message = new String(delivery.getBody(), "UTF-8");
                System.out.println(" [x] Received mapa '" + message + "'");
        };
        channel.basicConsume(stringMapa, true, deliverCallback, consumerTag -> {
        });
    }
    
    public void runJugador1() throws Exception {
        ConnectionFactory factory = new ConnectionFactory();
        factory.setHost("localhost");
        Connection connection = factory.newConnection();
        Channel channel = connection.createChannel();

        channel.queueDeclare(stringJ1, false, false, false, null);
        System.out.println(" [*] Waiting for messages. To exit press CTRL+C");

        DeliverCallback deliverCallback = (consumerTag, delivery) -> {
                messageJ1 = new String(delivery.getBody(), "UTF-8");
                System.out.println(" [x] Received j1'" + messageJ1 + "'");
        };
        channel.basicConsume(stringJ1, true, deliverCallback, consumerTag -> {
        });
    }
    
    public void runJugador2() throws Exception {
        ConnectionFactory factory = new ConnectionFactory();
        factory.setHost("localhost");
        Connection connection = factory.newConnection();
        Channel channel = connection.createChannel();

        channel.queueDeclare(stringJ2, false, false, false, null);
        System.out.println(" [*] Waiting for messages. To exit press CTRL+C");

        DeliverCallback deliverCallback = (consumerTag, delivery) -> {
                messageJ2 = new String(delivery.getBody(), "UTF-8");
                System.out.println(" [x] Received j2'" + messageJ2 + "'");
        };
        channel.basicConsume(stringJ2, true, deliverCallback, consumerTag -> {
        });
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

    public void jugador(String h) {
        jugador = h;
    }

    public void posI(String h) {
        posI = h;
    }

    public void posF(String h) {
        posF = h;
    }
    
    public void dano1(String h){
        dano1 = h;
    }    
    
    public void dano2(String h){
        dano2 = h;
    }

    public void enviarmovimientoI() throws Exception {
        ConnectionFactory factory = new ConnectionFactory();
        factory.setHost("localhost");
        try (Connection connection = factory.newConnection();
                Channel channel = connection.createChannel()) {
            channel.queueDeclare(stringPOSI, false, false, false, null);
            channel.basicPublish("", stringPOSI, null, posI.getBytes("UTF-8"));
            System.out.println(" [x] Sent posI '" + posI + "'");
        }
    }
    
    public void enviarmovimientoF() throws Exception {
        ConnectionFactory factory = new ConnectionFactory();
        factory.setHost("localhost");
        try (Connection connection = factory.newConnection();
                Channel channel = connection.createChannel()) {
            channel.queueDeclare(stringPOSF, false, false, false, null);
            channel.basicPublish("", stringPOSF, null, posF.getBytes("UTF-8"));
            System.out.println(" [x] Sent posF '" + posF + "'");
        }
    }
    
    public void enviarmovimientoID() throws Exception {
        ConnectionFactory factory = new ConnectionFactory();
        factory.setHost("localhost");
        try (Connection connection = factory.newConnection();
                Channel channel = connection.createChannel()) {
            channel.queueDeclare(stringJugadorID, false, false, false, null);
            channel.basicPublish("", stringJugadorID, null, jugador.getBytes("UTF-8"));
            System.out.println(" [x] Sent j '" + jugador + "'");
        }
    }
    
    public void enviarAtaqueI() throws Exception {
        ConnectionFactory factory = new ConnectionFactory();
        factory.setHost("localhost");
        try (Connection connection = factory.newConnection();
                Channel channel = connection.createChannel()) {
            channel.queueDeclare(ataquePOSI, false, false, false, null);
            channel.basicPublish("", ataquePOSI, null, posI.getBytes("UTF-8"));
            System.out.println(" [x] Sent posI '" + posI + "'");
        }
    }
    
    public void enviarAtaqueF() throws Exception {
        ConnectionFactory factory = new ConnectionFactory();
        factory.setHost("localhost");
        try (Connection connection = factory.newConnection();
                Channel channel = connection.createChannel()) {
            channel.queueDeclare(ataquePOSF, false, false, false, null);
            channel.basicPublish("", ataquePOSF, null, posF.getBytes("UTF-8"));
            System.out.println(" [x] Sent posF '" + posF + "'");
        }
    }
    
    public void enviarAtaqueID() throws Exception {
        ConnectionFactory factory = new ConnectionFactory();
        factory.setHost("localhost");
        try (Connection connection = factory.newConnection();
                Channel channel = connection.createChannel()) {
            channel.queueDeclare(ataqueJugadorID, false, false, false, null);
            channel.basicPublish("", ataqueJugadorID, null, jugador.getBytes("UTF-8"));
            System.out.println(" [x] Sent j '" + jugador + "'");
        }
    }
    
    public void enviarDano1() throws Exception {
        ConnectionFactory factory = new ConnectionFactory();
        factory.setHost("localhost");
        try (Connection connection = factory.newConnection();
                Channel channel = connection.createChannel()) {
            channel.queueDeclare(ataqueDano1, false, false, false, null);
            channel.basicPublish("", ataqueDano1, null, dano1.getBytes("UTF-8"));
            System.out.println(" [x] Sent dano1 '" + dano1 + "'");
        }
    }
    
    public void enviarDano2() throws Exception {
        ConnectionFactory factory = new ConnectionFactory();
        factory.setHost("localhost");
        try (Connection connection = factory.newConnection();
                Channel channel = connection.createChannel()) {
            channel.queueDeclare(ataqueDano2, false, false, false, null);
            channel.basicPublish("", ataqueDano2, null, dano2.getBytes("UTF-8"));
            System.out.println(" [x] Sent dano2 '" + dano2 + "'");
        }
    }

}
