package Ventanas;

import Braille.Braille;
import Conexiones.Arduino;
import Conexiones.FileManager;

public class Pruebas extends javax.swing.JFrame {

    Braille braille;
    Arduino ino;

    public Pruebas() {
        initComponents();
        //Braille---------------------------------------------------------------
        braille = new Braille();
        //----------------------------------------------------------------------  
        //Arduino
        ino = new Arduino();
        //----------------------------------------------------------------------
        setVisible(true);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        txtImprimir = new javax.swing.JTextArea();
        btnImprimir = new javax.swing.JButton();
        btnCarga = new javax.swing.JButton();
        btnDescargar = new javax.swing.JButton();
        puertosCOM = new javax.swing.JComboBox<>();
        btnConectar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        txtImprimir.setColumns(20);
        txtImprimir.setRows(5);
        jScrollPane1.setViewportView(txtImprimir);

        btnImprimir.setText("Imprimir");
        btnImprimir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnImprimirActionPerformed(evt);
            }
        });

        btnCarga.setText("Carga");
        btnCarga.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCargaActionPerformed(evt);
            }
        });

        btnDescargar.setText("Descarga");
        btnDescargar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDescargarActionPerformed(evt);
            }
        });

        btnConectar.setText("Escanear");
        btnConectar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnConectarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(btnConectar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(puertosCOM, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 78, Short.MAX_VALUE)
                        .addComponent(btnImprimir)
                        .addGap(63, 63, 63)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(btnCarga, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnDescargar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnImprimir)
                    .addComponent(btnCarga)
                    .addComponent(puertosCOM, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnDescargar)
                    .addComponent(btnConectar))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnImprimirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnImprimirActionPerformed
        braille.imprimirBraille(txtImprimir.getText(), 2);
    }//GEN-LAST:event_btnImprimirActionPerformed

    private void btnConectarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnConectarActionPerformed
        if (btnConectar.getText().equals("Conectar")) {
            ino.conectar(puertosCOM.getSelectedItem().toString());
            if (ino != null) {
                braille.setArduino(ino);
                btnConectar.setText("Desconectar");
                btnImprimir.setEnabled(true);
            }
            return;
        }
        if (btnConectar.getText().equals("Desconectar")) {
            braille.setArduino(null);
            ino.finalizarConexion();
            btnConectar.setText("Conectar");
            //btnImprimir.setEnabled(false);
            ino = null;
            return;
        }
        if (btnConectar.getText().equals("Escanear")) {
            for (int x = 0; x < ino.getPortsAvailable(); x++) {
                puertosCOM.addItem(ino.getSerialPorts().get(x));
                btnConectar.setText("Conectar");
            }
        }
        return;
    }//GEN-LAST:event_btnConectarActionPerformed

    private void btnCargaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCargaActionPerformed
        ino.cargarPapel();
        btnDescargar.setEnabled(true);
        btnCarga.setEnabled(false);
    }//GEN-LAST:event_btnCargaActionPerformed

    private void btnDescargarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDescargarActionPerformed
        ino.expulsarPapel();
        btnCarga.setEnabled(true);
        btnDescargar.setEnabled(false);
    }//GEN-LAST:event_btnDescargarActionPerformed

    /**
     * @param args the command line arguments
     */
    /*
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Pruebas().setVisible(true);
            }
        });*/

    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCarga;
    private javax.swing.JButton btnConectar;
    private javax.swing.JButton btnDescargar;
    private javax.swing.JButton btnImprimir;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JComboBox<String> puertosCOM;
    private javax.swing.JTextArea txtImprimir;
    // End of variables declaration//GEN-END:variables
}
