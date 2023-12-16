

package GUIClienteCRUD;

import GUIQuartoCRUD.*;
import Classes_hotel.Quarto;
import GUIReservaCRUD.*;
import Classes_hotel.Reserva;
import DAO_hotel.ErpDAOException;
import DAO_hotel.QuartoDAO;
import DAO_hotel.ReservaDAO;
import GUI.Principal;
import static GUI.Principal.carregaComboReserva;
import java.sql.Time;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;

public class AlteraQuarto extends javax.swing.JFrame {
    private static ArrayList<Quarto> lista = new ArrayList<Quarto>();
    private static DefaultListModel Valores = new DefaultListModel();
    private static int codigo = 0;
    private static int posicao = 0;

    private Quarto P = new Quarto();

    
    
    public AlteraQuarto(int cod) {
        codigo = cod;
        initComponents();
    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jSeparator1 = new javax.swing.JSeparator();
        jLabel1 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        OK = new javax.swing.JButton();
        Cancela = new javax.swing.JButton();
        T4 = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        T5 = new javax.swing.JTextField();
        T6 = new javax.swing.JTextField();
        CB = new javax.swing.JComboBox();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Alterar Pessoa");
        addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentShown(java.awt.event.ComponentEvent evt) {
                formComponentShown(evt);
            }
        });
        addWindowFocusListener(new java.awt.event.WindowFocusListener() {
            public void windowGainedFocus(java.awt.event.WindowEvent evt) {
                formWindowGainedFocus(evt);
            }
            public void windowLostFocus(java.awt.event.WindowEvent evt) {
            }
        });
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowActivated(java.awt.event.WindowEvent evt) {
                formWindowActivated(evt);
            }
            public void windowClosed(java.awt.event.WindowEvent evt) {
                formWindowClosed(evt);
            }
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        jLabel1.setText("id do quarto");

        jLabel4.setText("Descricao do quarto");

        OK.setText("Ok");
        OK.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                OKMouseClicked(evt);
            }
        });

        Cancela.setText("Cancelar");
        Cancela.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                CancelaMouseClicked(evt);
            }
        });
        Cancela.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CancelaActionPerformed(evt);
            }
        });

        jLabel5.setText("Tamanho do quarto");

        jLabel6.setText("Capacidade do quarto");

        T5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                T5ActionPerformed(evt);
            }
        });

        CB.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                CBItemStateChanged(evt);
            }
        });
        CB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CBActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(T4, javax.swing.GroupLayout.PREFERRED_SIZE, 295, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(134, 134, 134))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(OK, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(22, 22, 22)
                        .addComponent(Cancela)
                        .addGap(186, 186, 186))))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(157, 157, 157)
                        .addComponent(jLabel1)
                        .addGap(33, 33, 33)
                        .addComponent(CB, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(37, 37, 37)
                        .addComponent(jLabel6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(T6, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(34, 34, 34)
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(T5, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(59, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jLabel4)
                .addGap(226, 226, 226))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(CB, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(73, 73, 73)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(T6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6)
                    .addComponent(T5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 96, Short.MAX_VALUE)
                .addComponent(jLabel4)
                .addGap(18, 18, 18)
                .addComponent(T4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(36, 36, 36)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Cancela)
                    .addComponent(OK))
                .addGap(40, 40, 40))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void OKMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_OKMouseClicked
        Quarto P = new Quarto();
        int id_quarto = 0, capacidade_maxima = 0, tamanho_quarto = 0;
        String descricao = null;

        
            if (T5.getText().equals("") || T6.getText().equals("") || T4.getText().equals("")) {
                JOptionPane.showMessageDialog(rootPane, "Você precisa informar todos os campos do quarto");
            } else {
                try{
                id_quarto = codigo; // nao sei se funciona realmente /////////////////////////////////////////////////////////////
                tamanho_quarto = Integer.parseInt(T5.getText());
                capacidade_maxima = Integer.parseInt(T6.getText());
                descricao = T4.getText();
                System.out.println("atualizando os dados");
                //nome_cliente = T4.getText();
                }catch(Exception ex){
                        System.out.println("Problema na atualização dos dados");
                }
                
                P.setCapacidade_maxima(capacidade_maxima);
                P.setTamanho_quarto(tamanho_quarto);
                P.setDescricao(descricao);
                P.setId_quarto(id_quarto);
                
                try {
                    QuartoDAO PDAO = new QuartoDAO();
                    PDAO.atualizar(P);
                    JOptionPane.showMessageDialog(rootPane, "Atualização efetuada com sucesso!!");
                } catch (Exception ex) {
                    System.out.println("problema na atualização");
                }
                dispose();
            }
        
    }//GEN-LAST:event_OKMouseClicked

    private void CancelaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_CancelaMouseClicked
        dispose();
    }//GEN-LAST:event_CancelaMouseClicked

    private void formComponentShown(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_formComponentShown
        try {
          QuartoDAO PDAO= new QuartoDAO();
            P = PDAO.procurar(codigo);
        } catch (Exception ex) {
            System.out.println("reserva não localizado");
        }

        T4.setText(P.getDescricao());
        T5.setText(Integer.toString(P.getTamanho_quarto()));
        T6.setText(Integer.toString(P.getCapacidade_maxima()));
        
    }//GEN-LAST:event_formComponentShown

    private void formWindowClosed(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosed
        carregaComboQuarto();
    }//GEN-LAST:event_formWindowClosed

    private void T5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_T5ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_T5ActionPerformed

    private void CancelaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CancelaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_CancelaActionPerformed

    private void CBItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_CBItemStateChanged
        posicao = (int) CB.getSelectedIndex();

        if (posicao != -1) {

            codigo = lista.get(posicao).getId_quarto();
            
            T6.setText(Integer.toString(lista.get(posicao).getCapacidade_maxima()));
            T5.setText(Integer.toString(lista.get(posicao).getTamanho_quarto()));
            T4.setText(lista.get(posicao).getDescricao());
            
        }
    }//GEN-LAST:event_CBItemStateChanged

    private void CBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CBActionPerformed
        //carregaComboReserva();
    }//GEN-LAST:event_CBActionPerformed

    private void formWindowActivated(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowActivated
        // TODO add your handling code here:
    }//GEN-LAST:event_formWindowActivated

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        carregaComboQuarto();
    }//GEN-LAST:event_formWindowOpened

    private void formWindowGainedFocus(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowGainedFocus
        carregaComboQuarto();
    }//GEN-LAST:event_formWindowGainedFocus

    
    public static void carregaComboQuarto() {
        try {
            CB.removeAllItems();
            QuartoDAO PDAO = new QuartoDAO();
            lista = PDAO.listar();
        } catch (Exception ex) {
            System.out.println("problema");
        }

        for (int i = 0; i < lista.size(); i++) {
            CB.addItem(lista.get(i).getId_quarto());

        }
    }
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private static javax.swing.JComboBox CB;
    private javax.swing.JButton Cancela;
    private javax.swing.JButton OK;
    private javax.swing.JTextField T4;
    private javax.swing.JTextField T5;
    private javax.swing.JTextField T6;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JSeparator jSeparator1;
    // End of variables declaration//GEN-END:variables


}
