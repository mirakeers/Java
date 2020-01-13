/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fietsverhuur.swing;

import fietsverhuur.model.*;
import java.util.ArrayList;

/**
 *
 * @author Myra
 */
public class FietsenDetailsDialog extends javax.swing.JDialog {

    /**
     * Creates new form VerhuringenEditDialog2
     */
    
    
    public FietsenDetailsDialog(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
    }
    public void createTextFieldsAndSetFietsen(ArrayList<Fiets> fietslist) {
        int amount = fietslist.size();
        for (int i = 0; i < amount; i++) {
            
            java.awt.GridBagConstraints gridBagConstraints;
            
            
            javax.swing.JTextField fietsnummerTxt = new javax.swing.JTextField();
            javax.swing.JTextField genderTxt = new javax.swing.JTextField();
            javax.swing.JTextField fietstypeTxt = new javax.swing.JTextField();
            javax.swing.JTextField aantalVitessenTxt = new javax.swing.JTextField();
            javax.swing.JTextField dikteBandTxt = new javax.swing.JTextField();
            javax.swing.JTextField kleurTxt = new javax.swing.JTextField();
            javax.swing.JTextField verhuurpuntIdTxt = new javax.swing.JTextField();
            
            
            Fiets currentFiets = fietslist.get(i);
            fietsnummerTxt.setText(Integer.toString(currentFiets.getFietsnummer()));
            genderTxt.setText(currentFiets.getGender());
            fietstypeTxt.setText(currentFiets.getFietstype());
            if(currentFiets.getAantalVitessen() != 0) {
                aantalVitessenTxt.setText(Integer.toString(currentFiets.getAantalVitessen()));
            } else {
                aantalVitessenTxt.setText("");
            }
            dikteBandTxt.setText(currentFiets.getDikteBand());
            kleurTxt.setText(currentFiets.getKleur());
            verhuurpuntIdTxt.setText(Integer.toString(currentFiets.getVerhuurpuntId()));
            
            
            
            
            pack();
            
            
            fietsnummerTxt.setEnabled(false);
            fietsnummerTxt.setPreferredSize(new java.awt.Dimension(100, 27));
            gridBagConstraints = new java.awt.GridBagConstraints();
            gridBagConstraints.gridx = 0;
            gridBagConstraints.gridy = i + 2;
            gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
            gridBagConstraints.anchor = java.awt.GridBagConstraints.FIRST_LINE_START;
            gridBagConstraints.insets = new java.awt.Insets(3, 3, 3, 3);
            getContentPane().add(fietsnummerTxt, gridBagConstraints);

            genderTxt.setEnabled(false);
            genderTxt.setPreferredSize(new java.awt.Dimension(100, 27));
            gridBagConstraints = new java.awt.GridBagConstraints();
            gridBagConstraints.gridx = 1;
            gridBagConstraints.gridy = i + 2;
            gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
            gridBagConstraints.anchor = java.awt.GridBagConstraints.FIRST_LINE_START;
            gridBagConstraints.insets = new java.awt.Insets(3, 3, 3, 3);
            getContentPane().add(genderTxt, gridBagConstraints);

            fietstypeTxt.setEnabled(false);
            fietstypeTxt.setPreferredSize(new java.awt.Dimension(100, 27));
            gridBagConstraints = new java.awt.GridBagConstraints();
            gridBagConstraints.gridx = 2;
            gridBagConstraints.gridy = i + 2;
            gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
            gridBagConstraints.anchor = java.awt.GridBagConstraints.FIRST_LINE_START;
            gridBagConstraints.insets = new java.awt.Insets(3, 3, 3, 3);
            getContentPane().add(fietstypeTxt, gridBagConstraints);

            aantalVitessenTxt.setEnabled(false);
            aantalVitessenTxt.setPreferredSize(new java.awt.Dimension(100, 27));
            gridBagConstraints = new java.awt.GridBagConstraints();
            gridBagConstraints.gridx = 3;
            gridBagConstraints.gridy = i + 2;
            gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
            gridBagConstraints.anchor = java.awt.GridBagConstraints.FIRST_LINE_START;
            gridBagConstraints.insets = new java.awt.Insets(3, 3, 3, 3);
            getContentPane().add(aantalVitessenTxt, gridBagConstraints);
            
            dikteBandTxt.setEnabled(false);
            dikteBandTxt.setPreferredSize(new java.awt.Dimension(100, 27));
            gridBagConstraints = new java.awt.GridBagConstraints();
            gridBagConstraints.gridx = 4;
            gridBagConstraints.gridy = i + 2;
            gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
            gridBagConstraints.anchor = java.awt.GridBagConstraints.FIRST_LINE_START;
            gridBagConstraints.insets = new java.awt.Insets(3, 3, 3, 3);
            getContentPane().add(dikteBandTxt, gridBagConstraints);

            kleurTxt.setEnabled(false);
            kleurTxt.setPreferredSize(new java.awt.Dimension(100, 27));
            gridBagConstraints = new java.awt.GridBagConstraints();
            gridBagConstraints.gridx = 5;
            gridBagConstraints.gridy = i + 2;
            gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
            gridBagConstraints.anchor = java.awt.GridBagConstraints.FIRST_LINE_START;
            gridBagConstraints.insets = new java.awt.Insets(3, 3, 3, 3);
            getContentPane().add(kleurTxt, gridBagConstraints);

            verhuurpuntIdTxt.setEnabled(false);
            verhuurpuntIdTxt.setPreferredSize(new java.awt.Dimension(100, 27));
            gridBagConstraints = new java.awt.GridBagConstraints();
            gridBagConstraints.gridx = 6;
            gridBagConstraints.gridy = i + 2;
            gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
            gridBagConstraints.anchor = java.awt.GridBagConstraints.FIRST_LINE_START;
            gridBagConstraints.insets = new java.awt.Insets(3, 3, 3, 3);
            getContentPane().add(verhuurpuntIdTxt, gridBagConstraints);
            
        }
        pack();
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
        java.awt.GridBagConstraints gridBagConstraints;

        lblTitel = new javax.swing.JLabel();
        lblFietsnummer = new javax.swing.JLabel();
        lblGender = new javax.swing.JLabel();
        lblFietstype = new javax.swing.JLabel();
        lblAantalVitessen = new javax.swing.JLabel();
        lblDikteBand = new javax.swing.JLabel();
        lblKleur = new javax.swing.JLabel();
        lblVerhuurpuntId = new javax.swing.JLabel();
        btnCloseGUI = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        getContentPane().setLayout(new java.awt.GridBagLayout());

        lblTitel.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        lblTitel.setText("Details Selectie");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridwidth = 7;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.FIRST_LINE_START;
        gridBagConstraints.insets = new java.awt.Insets(3, 3, 9, 3);
        getContentPane().add(lblTitel, gridBagConstraints);

        lblFietsnummer.setText("Fietsnummer");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.FIRST_LINE_START;
        gridBagConstraints.insets = new java.awt.Insets(3, 3, 3, 3);
        getContentPane().add(lblFietsnummer, gridBagConstraints);

        lblGender.setText("Gender");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.FIRST_LINE_START;
        gridBagConstraints.insets = new java.awt.Insets(3, 3, 3, 3);
        getContentPane().add(lblGender, gridBagConstraints);

        lblFietstype.setText("Fietstype");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.FIRST_LINE_START;
        gridBagConstraints.insets = new java.awt.Insets(3, 3, 3, 3);
        getContentPane().add(lblFietstype, gridBagConstraints);

        lblAantalVitessen.setText("Aantal vitessen");
        lblAantalVitessen.setToolTipText("");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.FIRST_LINE_START;
        gridBagConstraints.insets = new java.awt.Insets(3, 3, 3, 3);
        getContentPane().add(lblAantalVitessen, gridBagConstraints);

        lblDikteBand.setText("Dikte band");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 4;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.FIRST_LINE_START;
        gridBagConstraints.insets = new java.awt.Insets(3, 3, 3, 3);
        getContentPane().add(lblDikteBand, gridBagConstraints);

        lblKleur.setText("Kleur");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 5;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.FIRST_LINE_START;
        gridBagConstraints.insets = new java.awt.Insets(3, 3, 3, 3);
        getContentPane().add(lblKleur, gridBagConstraints);

        lblVerhuurpuntId.setText("VerhuurpuntId");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 6;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.FIRST_LINE_START;
        gridBagConstraints.insets = new java.awt.Insets(3, 3, 3, 3);
        getContentPane().add(lblVerhuurpuntId, gridBagConstraints);

        btnCloseGUI.setText("Sluit venster");
        btnCloseGUI.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCloseGUIActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 5;
        gridBagConstraints.gridy = 100;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LAST_LINE_END;
        gridBagConstraints.insets = new java.awt.Insets(30, 3, 3, 3);
        getContentPane().add(btnCloseGUI, gridBagConstraints);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnCloseGUIActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCloseGUIActionPerformed
        this.setVisible(false);
    }//GEN-LAST:event_btnCloseGUIActionPerformed

   
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
            java.util.logging.Logger.getLogger(FietsenDetailsDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FietsenDetailsDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FietsenDetailsDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FietsenDetailsDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
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

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                FietsenDetailsDialog dialog = new FietsenDetailsDialog(new javax.swing.JFrame(), true);
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
    private javax.swing.JLabel lblAantalVitessen;
    private javax.swing.JLabel lblDikteBand;
    private javax.swing.JLabel lblFietsnummer;
    private javax.swing.JLabel lblFietstype;
    private javax.swing.JLabel lblGender;
    private javax.swing.JLabel lblKleur;
    private javax.swing.JLabel lblTitel;
    private javax.swing.JLabel lblVerhuurpuntId;
    // End of variables declaration//GEN-END:variables
}
