/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fietsverhuur.swing;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import fietsverhuur.model.*;
import fietsverhuur.dao.*;
import java.util.ArrayList;
/**
 *
 * @author Myra
 */
public class HerstellingenCreateDialog extends javax.swing.JDialog {

    /**
     * Creates new form VerhuringenCreateGUIb
     */
    
    public HerstellingenCreateDialog(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        ArrayList<Herstelling> lst = HerstellingDao.getHerstellingen();
        int herstellingId = 1 + lst.get(0).getHerstellingId();
        txtHerstellingId.setText(Integer.toString(herstellingId));
    }
    public void showDialog() {
        this.setModal(true);
        this.setVisible(true);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnCloseGUI = new javax.swing.JButton();
        btnSaveDataAndCloseGUI = new javax.swing.JButton();
        lblTitel = new javax.swing.JLabel();
        lblHerstellingId = new javax.swing.JLabel();
        txtHerstellingId = new javax.swing.JTextField();
        lblMeldingsdatum = new javax.swing.JLabel();
        txtMeldingsdatum = new javax.swing.JTextField();
        lblHuurderId = new javax.swing.JLabel();
        txtHuurderId = new javax.swing.JTextField();
        lblFietsnummer = new javax.swing.JLabel();
        txtFietsnummer = new javax.swing.JTextField();
        lblKostprijs = new javax.swing.JLabel();
        txtKostprijs = new javax.swing.JTextField();
        lblDefecten = new javax.swing.JLabel();
        txtDefecten = new javax.swing.JTextField();
        lblFoutmelding = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        btnCloseGUI.setText("Annuleren");
        btnCloseGUI.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCloseGUIActionPerformed(evt);
            }
        });

        btnSaveDataAndCloseGUI.setText("Maak herstelling aan");
        btnSaveDataAndCloseGUI.setEnabled(false);
        btnSaveDataAndCloseGUI.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSaveDataAndCloseGUIActionPerformed(evt);
            }
        });

        lblTitel.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        lblTitel.setText("Nieuwe Herstelling");

        lblHerstellingId.setText("HerstellingId");

        txtHerstellingId.setEnabled(false);

        lblMeldingsdatum.setText("Meldingsdatum *");

        txtMeldingsdatum.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtMeldingsdatumKeyReleased(evt);
            }
        });

        lblHuurderId.setText("HuurderId*");

        txtHuurderId.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtHuurderIdKeyReleased(evt);
            }
        });

        lblFietsnummer.setText("Fietsnummer *");

        txtFietsnummer.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtFietsnummerKeyReleased(evt);
            }
        });

        lblKostprijs.setText("Kostprijs");

        txtKostprijs.setEnabled(false);

        lblDefecten.setText("Defecten*");

        txtDefecten.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtDefectenKeyReleased(evt);
            }
        });

        lblFoutmelding.setText(" ");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(btnCloseGUI)
                        .addGap(18, 18, 18)
                        .addComponent(btnSaveDataAndCloseGUI))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblHerstellingId)
                            .addComponent(txtHerstellingId, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblTitel)
                            .addComponent(lblFoutmelding)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addGroup(layout.createSequentialGroup()
                                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addComponent(txtMeldingsdatum, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addComponent(lblMeldingsdatum))
                                            .addGap(18, 18, 18)
                                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addComponent(txtHuurderId, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addComponent(lblHuurderId)))
                                        .addComponent(txtDefecten))
                                    .addComponent(lblDefecten))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lblFietsnummer)
                                    .addComponent(txtFietsnummer, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(lblKostprijs)
                                    .addComponent(txtKostprijs, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(lblTitel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lblHerstellingId)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtHerstellingId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(11, 11, 11)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lblMeldingsdatum)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtMeldingsdatum, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lblHuurderId)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtHuurderId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lblFietsnummer)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtFietsnummer, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txtKostprijs, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(txtDefecten, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblKostprijs)
                            .addComponent(lblDefecten))
                        .addGap(26, 26, 26)))
                .addGap(25, 25, 25)
                .addComponent(lblFoutmelding)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 41, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnCloseGUI)
                    .addComponent(btnSaveDataAndCloseGUI))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtFietsnummerKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtFietsnummerKeyReleased
        enableDisableOpslaanButton();
    }//GEN-LAST:event_txtFietsnummerKeyReleased

    private void txtMeldingsdatumKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtMeldingsdatumKeyReleased
        enableDisableOpslaanButton();
    }//GEN-LAST:event_txtMeldingsdatumKeyReleased

    private void txtHuurderIdKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtHuurderIdKeyReleased
        enableDisableOpslaanButton();
    }//GEN-LAST:event_txtHuurderIdKeyReleased

    private void txtDefectenKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtDefectenKeyReleased
        checkFields();
        enableDisableOpslaanButton();
    }//GEN-LAST:event_txtDefectenKeyReleased

    private void btnCloseGUIActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCloseGUIActionPerformed
        this.setVisible(false);
    }//GEN-LAST:event_btnCloseGUIActionPerformed

    private void btnSaveDataAndCloseGUIActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSaveDataAndCloseGUIActionPerformed
        this.setVisible(false);
 
        Date meldingsdatum = CheckUserInput.parseDate(txtMeldingsdatum.getText());
        int huurderId = Integer.parseInt(txtHuurderId.getText());
        int fietsnummer = Integer.parseInt(txtFietsnummer.getText());
        
        Herstelling nieuweHerstelling = new Herstelling(meldingsdatum, huurderId, fietsnummer);
        
        HerstellingDao.voegHerstellingToe(nieuweHerstelling);
        
        ArrayList<Herstelling> herstellingenlist = HerstellingDao.getHerstellingen();
        int herstellingId = herstellingenlist.get(0).getHerstellingId();
        
        for(int defectnummer : CheckUserInput.convertDefectenstringNaarArrayList(txtDefecten.getText())) {
            Deelherstelling currentDeelherstelling = new Deelherstelling(herstellingId, defectnummer);
            DeelherstellingDao.voegDeelherstellingToe(currentDeelherstelling);
        }
    }//GEN-LAST:event_btnSaveDataAndCloseGUIActionPerformed

    public void enableDisableOpslaanButton() {
        if(txtMeldingsdatum.getText().equals("") || txtHuurderId.getText().equals("") || txtFietsnummer.getText().equals("") || txtDefecten.getText().equals("")) {
            btnSaveDataAndCloseGUI.setEnabled(false);
            lblFoutmelding.setText("Vul a.u.b. alle velden in.");
            
        } else {
            if(CheckUserInput.doesFietsnummerExist(txtFietsnummer.getText(), lblFoutmelding)
                    && CheckUserInput.doesHuurderIdExist(txtHuurderId.getText(), lblFoutmelding)
                    && CheckUserInput.isDateParsable(txtMeldingsdatum.getText(), lblFoutmelding)
                    && CheckUserInput.isDefectenStringValid(txtDefecten.getText(), lblFoutmelding)
                    && CheckUserInput.doDefectnummersExist(CheckUserInput.convertDefectenstringNaarArrayList(txtDefecten.getText()), lblFoutmelding)
                    ) {
                btnSaveDataAndCloseGUI.setEnabled(true);
                lblFoutmelding.setText("");
            } else {
                btnSaveDataAndCloseGUI.setEnabled(false);
            }
        }
    }
    public void checkFields() {
        if(CheckUserInput.isDefectenStringValid(txtDefecten.getText(), lblFoutmelding) && CheckUserInput.doDefectnummersExist(CheckUserInput.convertDefectenstringNaarArrayList(txtDefecten.getText()), lblFoutmelding)) {
            ArrayList <Integer> defectennummers = CheckUserInput.convertDefectenstringNaarArrayList(txtDefecten.getText());
            double kostprijs = Calculate.calculateHerstellingKostprijs(defectennummers);
            txtKostprijs.setText("€" + Calculate.roundAndAddZeroes(kostprijs, 2));
        } else {
            txtKostprijs.setText("");
        }
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
            java.util.logging.Logger.getLogger(HerstellingenCreateDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(HerstellingenCreateDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(HerstellingenCreateDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(HerstellingenCreateDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                HerstellingenCreateDialog dialog = new HerstellingenCreateDialog(new javax.swing.JFrame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCloseGUI;
    private javax.swing.JButton btnSaveDataAndCloseGUI;
    private javax.swing.JLabel lblDefecten;
    private javax.swing.JLabel lblFietsnummer;
    private javax.swing.JLabel lblFoutmelding;
    private javax.swing.JLabel lblHerstellingId;
    private javax.swing.JLabel lblHuurderId;
    private javax.swing.JLabel lblKostprijs;
    private javax.swing.JLabel lblMeldingsdatum;
    private javax.swing.JLabel lblTitel;
    private javax.swing.JTextField txtDefecten;
    private javax.swing.JTextField txtFietsnummer;
    private javax.swing.JTextField txtHerstellingId;
    private javax.swing.JTextField txtHuurderId;
    private javax.swing.JTextField txtKostprijs;
    private javax.swing.JTextField txtMeldingsdatum;
    // End of variables declaration//GEN-END:variables
}
