/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interfaz;

import edd.proyecto1_cliente.EDDProyecto1_Cliente;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.Image;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JButton;

/**
 *
 * @author pablo
 */
public class Interfaz extends javax.swing.JFrame {

    JButton[][] Matrizbotones;
    String[][] pintar;
    String[][] j1;
    String[][] j2;

    public Interfaz() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jInternalFrame1 = new javax.swing.JInternalFrame();
        jPanel1 = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jInternalFrame1.setResizable(true);
        jInternalFrame1.setAutoscrolls(true);
        jInternalFrame1.setVisible(true);

        jPanel1.setAutoscrolls(true);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 702, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        jButton1.setText("Cargar Mapa");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jInternalFrame1Layout = new javax.swing.GroupLayout(jInternalFrame1.getContentPane());
        jInternalFrame1.getContentPane().setLayout(jInternalFrame1Layout);
        jInternalFrame1Layout.setHorizontalGroup(
            jInternalFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jInternalFrame1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jButton1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 42, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jInternalFrame1Layout.setVerticalGroup(
            jInternalFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jInternalFrame1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jInternalFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jInternalFrame1Layout.createSequentialGroup()
                        .addComponent(jButton1)
                        .addGap(0, 456, Short.MAX_VALUE))
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jInternalFrame1, javax.swing.GroupLayout.Alignment.TRAILING)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jInternalFrame1, javax.swing.GroupLayout.Alignment.TRAILING)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        EDDProyecto1_Cliente eee = new EDDProyecto1_Cliente();
        try {
            eee.runMapa();
            Thread.sleep(500);
            int dimensionX = eee.mensajemapaC();
            int dimensionY = eee.mensajemapaF();
            pintar = new String[3][dimensionY * dimensionX];
            j1 = new String[3][dimensionY * dimensionX];
            j2 = new String[3][dimensionY * dimensionX];
            leerMapa(eee.mensajemapa());
            leerJ1(eee.mensajeJ1());
            leerJ2(eee.mensajeJ2());
            Matrizbotones = new JButton[dimensionX][dimensionY];
            jPanel1.setLayout(new GridLayout(dimensionX, dimensionY));
            int contadorX, contadorY;
            for (contadorY = 0; contadorY < dimensionY; contadorY++) {
                for (contadorX = 0; contadorX < dimensionX; contadorX++) {
                    String color = "";
                    String tropa1 = "";
                    String tropa2 = "";
                    for (int j = 0; j < dimensionY * dimensionX; j++) {
                        if (pintar[0][j] == null ? (Integer.toString(contadorX + 1)) == null : pintar[0][j].equals(Integer.toString(contadorX + 1)) && (pintar[1][j] == null ? (Integer.toString(contadorY + 1)) == null : pintar[1][j].equals(Integer.toString(contadorY + 1))) && (pintar[2][j] == null ? ("blue") == null : pintar[2][j].equals("blue"))) {
                            color = pintar[2][j];
                            break;
                        } else if (pintar[0][j] == null ? (Integer.toString(contadorX + 1)) == null : pintar[0][j].equals(Integer.toString(contadorX + 1)) && (pintar[1][j] == null ? (Integer.toString(contadorY + 1)) == null : pintar[1][j].equals(Integer.toString(contadorY + 1))) && (pintar[2][j] == null ? ("green") == null : pintar[2][j].equals("green"))) {
                            color = pintar[2][j];
                            break;
                        } else if (pintar[0][j] == null ? (Integer.toString(contadorX + 1)) == null : pintar[0][j].equals(Integer.toString(contadorX + 1)) && (pintar[1][j] == null ? (Integer.toString(contadorY + 1)) == null : pintar[1][j].equals(Integer.toString(contadorY + 1))) && (pintar[2][j] == null ? ("darkgreen") == null : pintar[2][j].equals("darkgreen"))) {
                            color = pintar[2][j];
                            break;
                        } else if (pintar[0][j] == null ? (Integer.toString(contadorX + 1)) == null : pintar[0][j].equals(Integer.toString(contadorX + 1)) && (pintar[1][j] == null ? (Integer.toString(contadorY + 1)) == null : pintar[1][j].equals(Integer.toString(contadorY + 1))) && (pintar[2][j] == null ? ("gray") == null : pintar[2][j].equals("gray"))) {
                            color = pintar[2][j];
                            break;
                        } else if (pintar[0][j] == null ? (Integer.toString(contadorX + 1)) == null : pintar[0][j].equals(Integer.toString(contadorX + 1)) && (pintar[1][j] == null ? (Integer.toString(contadorY + 1)) == null : pintar[1][j].equals(Integer.toString(contadorY + 1))) && (pintar[2][j] == null ? ("brown") == null : pintar[2][j].equals("brown"))) {
                            color = pintar[2][j];
                            break;
                        } 
                    }
                    for (int j = 0; j < dimensionY * dimensionX; j++) {
                        if (j1[0][j] == null ? (Integer.toString(contadorX + 1)) == null : j1[0][j].equals(Integer.toString(contadorX + 1)) && (j1[1][j] == null ? (Integer.toString(contadorY + 1)) == null : j1[1][j].equals(Integer.toString(contadorY + 1))) && (j1[2][j] == null ? ("infanteria") == null : j1[2][j].equals("infanteria"))) {
                            tropa1 = j1[2][j];
                            break;
                        } else if (j1[0][j] == null ? (Integer.toString(contadorX + 1)) == null : j1[0][j].equals(Integer.toString(contadorX + 1)) && (j1[1][j] == null ? (Integer.toString(contadorY + 1)) == null : j1[1][j].equals(Integer.toString(contadorY + 1))) && (j1[2][j] == null ? ("infanteriam") == null : j1[2][j].equals("infanteriam"))) {
                            tropa1 = j1[2][j];
                            break;
                        }else if (j1[0][j] == null ? (Integer.toString(contadorX + 1)) == null : j1[0][j].equals(Integer.toString(contadorX + 1)) && (j1[1][j] == null ? (Integer.toString(contadorY + 1)) == null : j1[1][j].equals(Integer.toString(contadorY + 1))) && (j1[2][j] == null ? ("reconocimiento") == null : j1[2][j].equals("reconocimiento"))) {
                            tropa1 = j1[2][j];
                            break;
                        }else if (j1[0][j] == null ? (Integer.toString(contadorX + 1)) == null : j1[0][j].equals(Integer.toString(contadorX + 1)) && (j1[1][j] == null ? (Integer.toString(contadorY + 1)) == null : j1[1][j].equals(Integer.toString(contadorY + 1))) && (j1[2][j] == null ? ("tanque") == null : j1[2][j].equals("tanque"))) {
                            tropa1 = j1[2][j];
                            break;
                        }else if (j1[0][j] == null ? (Integer.toString(contadorX + 1)) == null : j1[0][j].equals(Integer.toString(contadorX + 1)) && (j1[1][j] == null ? (Integer.toString(contadorY + 1)) == null : j1[1][j].equals(Integer.toString(contadorY + 1))) && (j1[2][j] == null ? ("mtanque") == null : j1[2][j].equals("mtanque"))) {
                            tropa1 = j1[2][j];
                            break;
                        }else if (j1[0][j] == null ? (Integer.toString(contadorX + 1)) == null : j1[0][j].equals(Integer.toString(contadorX + 1)) && (j1[1][j] == null ? (Integer.toString(contadorY + 1)) == null : j1[1][j].equals(Integer.toString(contadorY + 1))) && (j1[2][j] == null ? ("artilleria") == null : j1[2][j].equals("artilleria"))) {
                            tropa1 = j1[2][j];
                            break;
                        }
                    }
                    
                    for (int j = 0; j < dimensionY * dimensionX; j++) {
                        if (j2[0][j] == null ? (Integer.toString(contadorX + 1)) == null : j2[0][j].equals(Integer.toString(contadorX + 1)) && (j2[1][j] == null ? (Integer.toString(contadorY + 1)) == null : j2[1][j].equals(Integer.toString(contadorY + 1))) && (j2[2][j] == null ? ("infanteria") == null : j2[2][j].equals("infanteria"))) {
                            tropa2 = j2[2][j];
                            break;
                        } else if (j2[0][j] == null ? (Integer.toString(contadorX + 1)) == null : j2[0][j].equals(Integer.toString(contadorX + 1)) && (j2[1][j] == null ? (Integer.toString(contadorY + 1)) == null : j2[1][j].equals(Integer.toString(contadorY + 1))) && (j2[2][j] == null ? ("infanteriam") == null : j2[2][j].equals("infanteriam"))) {
                            tropa2 = j2[2][j];
                            break;
                        }else if (j2[0][j] == null ? (Integer.toString(contadorX + 1)) == null : j2[0][j].equals(Integer.toString(contadorX + 1)) && (j2[1][j] == null ? (Integer.toString(contadorY + 1)) == null : j2[1][j].equals(Integer.toString(contadorY + 1))) && (j2[2][j] == null ? ("reconocimiento") == null : j2[2][j].equals("reconocimiento"))) {
                            tropa2 = j2[2][j];
                            break;
                        }else if (j2[0][j] == null ? (Integer.toString(contadorX + 1)) == null : j2[0][j].equals(Integer.toString(contadorX + 1)) && (j2[1][j] == null ? (Integer.toString(contadorY + 1)) == null : j2[1][j].equals(Integer.toString(contadorY + 1))) && (j2[2][j] == null ? ("tanque") == null : j2[2][j].equals("tanque"))) {
                            tropa2 = j2[2][j];
                            break;
                        }else if (j2[0][j] == null ? (Integer.toString(contadorX + 1)) == null : j2[0][j].equals(Integer.toString(contadorX + 1)) && (j2[1][j] == null ? (Integer.toString(contadorY + 1)) == null : j2[1][j].equals(Integer.toString(contadorY + 1))) && (j2[2][j] == null ? ("mtanque") == null : j2[2][j].equals("mtanque"))) {
                            tropa2 = j2[2][j];
                            break;
                        }else if (j2[0][j] == null ? (Integer.toString(contadorX + 1)) == null : j2[0][j].equals(Integer.toString(contadorX + 1)) && (j2[1][j] == null ? (Integer.toString(contadorY + 1)) == null : j2[1][j].equals(Integer.toString(contadorY + 1))) && (j2[2][j] == null ? ("artilleria") == null : j2[2][j].equals("artilleria"))) {
                            tropa2 = j2[2][j];
                            break;
                        }
                    }
                    if (color.equals("blue")) {
                        JButton btnNuevo = new JButton();
                        btnNuevo.setSize(5, 5);
                        ImageIcon icono = new ImageIcon(new ImageIcon("aguaAW.jpg").getImage().getScaledInstance(47, 40, Image.SCALE_DEFAULT));
                        btnNuevo.setIcon(icono);
                        btnNuevo.setToolTipText(Integer.toString(contadorX + 1) + "," + Integer.toString(contadorY + 1));
                        Matrizbotones[contadorX][contadorY] = btnNuevo;
                        jPanel1.add(Matrizbotones[contadorX][contadorY]);
                        jPanel1.validate();
                        jPanel1.repaint();
                    } else if (color.equals("green")) {
                        JButton btnNuevo = new JButton();
                        btnNuevo.setSize(5, 5);
                        ImageIcon icono = new ImageIcon(new ImageIcon("gramaAW.jpg").getImage().getScaledInstance(47, 40, Image.SCALE_DEFAULT));
                        btnNuevo.setIcon(icono);
                        btnNuevo.setToolTipText(Integer.toString(contadorX + 1) + "," + Integer.toString(contadorY + 1));
                        Matrizbotones[contadorX][contadorY] = btnNuevo;
                        jPanel1.add(Matrizbotones[contadorX][contadorY]);
                        jPanel1.validate();
                        jPanel1.repaint();
                    } else if (color.equals("darkgreen")) {
                        JButton btnNuevo = new JButton();
                        btnNuevo.setSize(5, 5);
                        ImageIcon icono = new ImageIcon(new ImageIcon("arbolAW.jpg").getImage().getScaledInstance(47, 40, Image.SCALE_DEFAULT));
                        btnNuevo.setIcon(icono);
                        btnNuevo.setToolTipText(Integer.toString(contadorX + 1) + "," + Integer.toString(contadorY + 1));
                        Matrizbotones[contadorX][contadorY] = btnNuevo;
                        jPanel1.add(Matrizbotones[contadorX][contadorY]);
                        jPanel1.validate();
                        jPanel1.repaint();
                    } else if (color.equals("gray")) {
                        JButton btnNuevo = new JButton();
                        btnNuevo.setSize(5, 5);
                        ImageIcon icono = new ImageIcon(new ImageIcon("carreteraAW.jpg").getImage().getScaledInstance(47, 40, Image.SCALE_DEFAULT));
                        btnNuevo.setIcon(icono);
                        btnNuevo.setToolTipText(Integer.toString(contadorX + 1) + "," + Integer.toString(contadorY + 1));
                        Matrizbotones[contadorX][contadorY] = btnNuevo;
                        jPanel1.add(Matrizbotones[contadorX][contadorY]);
                        jPanel1.validate();
                        jPanel1.repaint();
                    } else if (color.equals("brown")) {
                        JButton btnNuevo = new JButton();
                        btnNuevo.setSize(5, 5);
                        ImageIcon icono = new ImageIcon(new ImageIcon("montaniaAW.jpg").getImage().getScaledInstance(47, 40, Image.SCALE_DEFAULT));
                        btnNuevo.setIcon(icono);
                        btnNuevo.setToolTipText(Integer.toString(contadorX + 1) + "," + Integer.toString(contadorY + 1));
                        Matrizbotones[contadorX][contadorY] = btnNuevo;
                        jPanel1.add(Matrizbotones[contadorX][contadorY]);
                        jPanel1.validate();
                        jPanel1.repaint();
                    } else {
                        JButton btnNuevo = new JButton();
                        btnNuevo.setSize(5, 5);
                        btnNuevo.setToolTipText(Integer.toString(contadorX + 1) + "," + Integer.toString(contadorY + 1));
                        Matrizbotones[contadorX][contadorY] = btnNuevo;
                        jPanel1.add(Matrizbotones[contadorX][contadorY]);
                        jPanel1.validate();
                        jPanel1.repaint();
                    }
                    if (tropa1.equals("infanteria")) {
                        ImageIcon icono = new ImageIcon(new ImageIcon("infanteriaJ1.png").getImage().getScaledInstance(47, 40, Image.SCALE_DEFAULT));
                        Matrizbotones[contadorX][contadorY].setIcon(icono);
                        jPanel1.validate();
                        jPanel1.repaint();
                    } else if (tropa1.equals("infanteriam")) {
                        ImageIcon icono = new ImageIcon(new ImageIcon("infanteriamJ1.png").getImage().getScaledInstance(47, 40, Image.SCALE_DEFAULT));
                        Matrizbotones[contadorX][contadorY].setIcon(icono);
                        jPanel1.validate();
                        jPanel1.repaint();
                    } else if (tropa1.equals("reconocimiento")) {
                        ImageIcon icono = new ImageIcon(new ImageIcon("reconocimientoJ1.png").getImage().getScaledInstance(47, 40, Image.SCALE_DEFAULT));
                        Matrizbotones[contadorX][contadorY].setIcon(icono);
                        jPanel1.validate();
                        jPanel1.repaint();
                    } else if (tropa1.equals("tanque")) {
                        ImageIcon icono = new ImageIcon(new ImageIcon("tanqueJ1.png").getImage().getScaledInstance(47, 40, Image.SCALE_DEFAULT));
                        Matrizbotones[contadorX][contadorY].setIcon(icono);
                        jPanel1.add(Matrizbotones[contadorX][contadorY]);
                        jPanel1.validate();
                        jPanel1.repaint();
                    } else if (tropa1.equals("mtanque")) {
                        ImageIcon icono = new ImageIcon(new ImageIcon("mtanqueJ1.png").getImage().getScaledInstance(47, 40, Image.SCALE_DEFAULT));
                        Matrizbotones[contadorX][contadorY].setIcon(icono);
                        jPanel1.validate();
                        jPanel1.repaint();
                    } else if (tropa1.equals("artilleria")) {
                        ImageIcon icono = new ImageIcon(new ImageIcon("artilleriaJ1.png").getImage().getScaledInstance(47, 40, Image.SCALE_DEFAULT));
                        Matrizbotones[contadorX][contadorY].setIcon(icono);
                        jPanel1.validate();
                        jPanel1.repaint();
                    } 
                    if (tropa2.equals("infanteria")) {
                        ImageIcon icono = new ImageIcon(new ImageIcon("infanteriaJ2.png").getImage().getScaledInstance(47, 40, Image.SCALE_DEFAULT));
                        Matrizbotones[contadorX][contadorY].setIcon(icono);
                        jPanel1.validate();
                        jPanel1.repaint();
                    } else if (tropa2.equals("infanteriam")) {
                        ImageIcon icono = new ImageIcon(new ImageIcon("infanteriamJ2.png").getImage().getScaledInstance(47, 40, Image.SCALE_DEFAULT));
                        Matrizbotones[contadorX][contadorY].setIcon(icono);
                        jPanel1.validate();
                        jPanel1.repaint();
                    } else if (tropa2.equals("reconocimiento")) {
                        ImageIcon icono = new ImageIcon(new ImageIcon("reconocimientoJ2.png").getImage().getScaledInstance(47, 40, Image.SCALE_DEFAULT));
                        Matrizbotones[contadorX][contadorY].setIcon(icono);
                        jPanel1.validate();
                        jPanel1.repaint();
                    } else if (tropa2.equals("tanque")) {
                        ImageIcon icono = new ImageIcon(new ImageIcon("tanqueJ2.png").getImage().getScaledInstance(47, 40, Image.SCALE_DEFAULT));
                        Matrizbotones[contadorX][contadorY].setIcon(icono);
                        jPanel1.validate();
                        jPanel1.repaint();
                    } else if (tropa2.equals("mtanque")) {
                        ImageIcon icono = new ImageIcon(new ImageIcon("mtanqueJ2.png").getImage().getScaledInstance(47, 40, Image.SCALE_DEFAULT));
                        Matrizbotones[contadorX][contadorY].setIcon(icono);
                        jPanel1.validate();
                        jPanel1.repaint();
                    } else if (tropa2.equals("artilleria")) {
                        ImageIcon icono = new ImageIcon(new ImageIcon("artilleriaJ2.png").getImage().getScaledInstance(47, 40, Image.SCALE_DEFAULT));
                        Matrizbotones[contadorX][contadorY].setIcon(icono);
                        jPanel1.validate();
                        jPanel1.repaint();
                    } 
                }
            }
        } catch (Exception ex) {
            Logger.getLogger(Interfaz.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    public void leerMapa(String mensaje) {
        Scanner input = new Scanner(mensaje);
        int cont = 0;
        while (input.hasNext()) {

            String estring = input.nextLine();
            String[] part = estring.split(",");
            pintar[0][cont] = part[0];
            pintar[1][cont] = part[1];
            pintar[2][cont] = part[2];
            cont++;
        }
        input.close();
    }

    public void leerJ1(String mensaje){
        Scanner input = new Scanner(mensaje);
        int cont = 0;
        while (input.hasNext()) {

            String estring = input.nextLine();
            String[] part = estring.split(",");
            j1[0][cont] = part[0];
            j1[1][cont] = part[1];
            j1[2][cont] = part[2];
            cont++;
        }
        input.close();        
    }
    
    public void leerJ2(String mensaje){
        Scanner input = new Scanner(mensaje);
        int cont = 0;
        while (input.hasNext()) {

            String estring = input.nextLine();
            String[] part = estring.split(",");
            j2[0][cont] = part[0];
            j2[1][cont] = part[1];
            j2[2][cont] = part[2];
            cont++;
        }
        input.close();        
    }
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Interfaz.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Interfaz.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Interfaz.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Interfaz.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Interfaz().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JInternalFrame jInternalFrame1;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables
}
