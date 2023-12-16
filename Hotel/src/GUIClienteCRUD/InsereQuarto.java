/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUIClienteCRUD;

import GUIQuartoCRUD.*;
import Classes_hotel.Quarto;
import GUIReservaCRUD.*;
import Classes_hotel.Reserva;
import DAO_hotel.ErpDAOException;
import DAO_hotel.QuartoDAO;
import DAO_hotel.ReservaDAO;
import GUI.Principal;
import java.sql.Time;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JOptionPane;

/**
 *
 * @author Cesar
 */
public class InsereQuarto extends javax.swing.JFrame {

    /**
     * Creates new form Insere
     */
    public InsereQuarto() {
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

        T2 = new javax.swing.JTextField();
        T7 = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        OK1 = new javax.swing.JButton();
        Cancela1 = new javax.swing.JButton();
        T8 = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Inserir Pessoa");
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosed(java.awt.event.WindowEvent evt) {
                formWindowClosed(evt);
            }
        });

        jLabel6.setText("Tamanho em M²");

        jLabel8.setText("Capacidade máxima");

        OK1.setText("Ok");
        OK1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                OK1MouseClicked(evt);
            }
        });

        Cancela1.setText("Cancelar");
        Cancela1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Cancela1MouseClicked(evt);
            }
        });
        Cancela1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Cancela1ActionPerformed(evt);
            }
        });

        T8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                T8ActionPerformed(evt);
            }
        });

        jLabel9.setText("Descricao do quarto");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(44, 44, 44)
                .addComponent(jLabel6)
                .addGap(30, 30, 30)
                .addComponent(T2, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 57, Short.MAX_VALUE)
                .addComponent(jLabel8)
                .addGap(10, 10, 10)
                .addComponent(T7, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(51, 51, 51))
            .addGroup(layout.createSequentialGroup()
                .addGap(212, 212, 212)
                .addComponent(jLabel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(T8, javax.swing.GroupLayout.PREFERRED_SIZE, 331, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(113, 113, 113))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(OK1, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(38, 38, 38)
                        .addComponent(Cancela1)
                        .addGap(177, 177, 177))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(T2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6)
                    .addComponent(T7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8))
                .addGap(52, 52, 52)
                .addComponent(jLabel9)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(T8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 89, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(OK1)
                    .addComponent(Cancela1))
                .addGap(40, 40, 40))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void formWindowClosed(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosed
        Principal.carregaComboReserva();
    }//GEN-LAST:event_formWindowClosed

    private void OK1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_OK1MouseClicked
        Quarto P = new Quarto();
        int id_quarto = 0, tamanho_quarto = 0, capacidade_maxima = 0;
        String descricao = "";

        
            if (T7.getText().equals("") || T2.getText().equals("") || T8.getText().equals("")) {
                JOptionPane.showMessageDialog(rootPane, "Você precisa informar os dados do quarto");
            } else {
                try{
                    tamanho_quarto = Integer.parseInt(T2.getText());
                    capacidade_maxima = Integer.parseInt(T7.getText());
                    descricao = T8.getText();
                    
                }catch(Exception ex){
                    System.out.println("Erro no cadastro do quarto");
                }
                
                P.setId_quarto(id_quarto);
                P.setCapacidade_maxima(capacidade_maxima);
                P.setTamanho_quarto(tamanho_quarto);
                P.setDescricao(descricao);

                try {
                    QuartoDAO PDAO = new QuartoDAO();
                    PDAO.inserir(P);
                    JOptionPane.showMessageDialog(rootPane, "Inserção efetuada com sucesso!!");
                } catch (Exception ex) {
                    System.out.println("problema na inserção do quarto");
                }
                
                
                dispose();
            }
        //}
    }//GEN-LAST:event_OK1MouseClicked

    private void Cancela1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Cancela1MouseClicked
        dispose();
    }//GEN-LAST:event_Cancela1MouseClicked

    private void Cancela1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Cancela1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_Cancela1ActionPerformed

    private void T8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_T8ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_T8ActionPerformed

    /**
     * @param args the command line arguments
     */
   
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Cancela1;
    private javax.swing.JButton OK1;
    private javax.swing.JTextField T2;
    private javax.swing.JTextField T7;
    private javax.swing.JTextField T8;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    // End of variables declaration//GEN-END:variables
}
