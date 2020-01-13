/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fietsverhuur.swing;

import fietsverhuur.dao.*;
import fietsverhuur.model.*;
import java.util.ArrayList;

/**
 *
 * @author Myra
 */
public class FietsenEditDialog extends javax.swing.JDialog {

    /**
     * Creates new form VerhuringenEditDialog2
     */
    private ArrayList<javax.swing.JTextField> fietsnummerTxts;
    private ArrayList<javax.swing.JComboBox> genderCmbs;
    private ArrayList<javax.swing.JComboBox> fietstypeCmbs;
    private ArrayList<javax.swing.JTextField> aantalVitessenTxts;
    private ArrayList<javax.swing.JComboBox> dikteBandCmbs;
    private ArrayList<javax.swing.JTextField> kleurTxts;
    private ArrayList<javax.swing.JTextField> verhuurpuntIdTxts;
    
    private Resultaat formulierResultaat;

    public Resultaat getFormulierResultaat() {
        return formulierResultaat;
    }
    
    public enum Resultaat{
        GEANNULEERD,
        BEVESTIGD
    }
    
    public FietsenEditDialog(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        fietsnummerTxts = new ArrayList<javax.swing.JTextField>();
        genderCmbs = new ArrayList<javax.swing.JComboBox>();
        fietstypeCmbs = new ArrayList<javax.swing.JComboBox>();
        aantalVitessenTxts = new ArrayList<javax.swing.JTextField>();
        dikteBandCmbs = new ArrayList<javax.swing.JComboBox>();
        kleurTxts = new ArrayList<javax.swing.JTextField>();
        verhuurpuntIdTxts = new ArrayList<javax.swing.JTextField>();
    }
    public void createTextFieldsAndSetFietsen(ArrayList<Fiets> fietslist) {
        int amount = fietslist.size();
        for (int i = 0; i < amount; i++) {
            
            java.awt.GridBagConstraints gridBagConstraints;
            
            javax.swing.JTextField fietsnummerTxt = new javax.swing.JTextField();
            javax.swing.JComboBox genderCmb = new javax.swing.JComboBox();
            javax.swing.JComboBox fietstypeCmb = new javax.swing.JComboBox();
            javax.swing.JTextField aantalVitessenTxt = new javax.swing.JTextField();
            javax.swing.JComboBox dikteBandCmb = new javax.swing.JComboBox();
            javax.swing.JTextField kleurTxt = new javax.swing.JTextField();
            javax.swing.JTextField verhuurpuntIdTxt = new javax.swing.JTextField();
            
            fietsnummerTxts.add(fietsnummerTxt);
            genderCmbs.add(genderCmb);
            fietstypeCmbs.add(fietstypeCmb);
            aantalVitessenTxts.add(aantalVitessenTxt);
            dikteBandCmbs.add(dikteBandCmb);
            kleurTxts.add(kleurTxt);
            verhuurpuntIdTxts.add(verhuurpuntIdTxt);
            
            
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

            genderCmb.setPreferredSize(new java.awt.Dimension(110, 27));
            genderCmb.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "mannelijk", "vrouwelijk", "unisex" }));
            gridBagConstraints = new java.awt.GridBagConstraints();
            gridBagConstraints.gridx = 1;
            gridBagConstraints.gridy = i + 2;
            gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
            gridBagConstraints.anchor = java.awt.GridBagConstraints.FIRST_LINE_START;
            gridBagConstraints.insets = new java.awt.Insets(3, 3, 3, 3);
            getContentPane().add(genderCmb, gridBagConstraints);

            fietstypeCmb.setPreferredSize(new java.awt.Dimension(90, 27));
            fietstypeCmb.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "stadsfiets", "sportfiets" }));
            gridBagConstraints = new java.awt.GridBagConstraints();
            gridBagConstraints.gridx = 2;
            gridBagConstraints.gridy = i + 2;
            gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
            gridBagConstraints.anchor = java.awt.GridBagConstraints.FIRST_LINE_START;
            gridBagConstraints.insets = new java.awt.Insets(3, 3, 3, 3);
            getContentPane().add(fietstypeCmb, gridBagConstraints);

            aantalVitessenTxt.setPreferredSize(new java.awt.Dimension(100, 27));
            gridBagConstraints = new java.awt.GridBagConstraints();
            gridBagConstraints.gridx = 3;
            gridBagConstraints.gridy = i + 2;
            gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
            gridBagConstraints.anchor = java.awt.GridBagConstraints.FIRST_LINE_START;
            gridBagConstraints.insets = new java.awt.Insets(3, 3, 3, 3);
            getContentPane().add(aantalVitessenTxt, gridBagConstraints);
            
            dikteBandCmb.setPreferredSize(new java.awt.Dimension(100, 27));
            dikteBandCmb.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Kies dikte...", "dun", "middel", "dik" }));
            gridBagConstraints = new java.awt.GridBagConstraints();
            gridBagConstraints.gridx = 4;
            gridBagConstraints.gridy = i + 2;
            gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
            gridBagConstraints.anchor = java.awt.GridBagConstraints.FIRST_LINE_START;
            gridBagConstraints.insets = new java.awt.Insets(3, 3, 3, 3);
            getContentPane().add(dikteBandCmb, gridBagConstraints);

            kleurTxt.setPreferredSize(new java.awt.Dimension(100, 27));
            gridBagConstraints = new java.awt.GridBagConstraints();
            gridBagConstraints.gridx = 5;
            gridBagConstraints.gridy = i + 2;
            gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
            gridBagConstraints.anchor = java.awt.GridBagConstraints.FIRST_LINE_START;
            gridBagConstraints.insets = new java.awt.Insets(3, 3, 3, 3);
            getContentPane().add(kleurTxt, gridBagConstraints);

            verhuurpuntIdTxt.setPreferredSize(new java.awt.Dimension(100, 27));
            gridBagConstraints = new java.awt.GridBagConstraints();
            gridBagConstraints.gridx = 6;
            gridBagConstraints.gridy = i + 2;
            gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
            gridBagConstraints.anchor = java.awt.GridBagConstraints.FIRST_LINE_START;
            gridBagConstraints.insets = new java.awt.Insets(3, 3, 3, 3);
            getContentPane().add(verhuurpuntIdTxt, gridBagConstraints);
            
            
            aantalVitessenTxt.addKeyListener(new java.awt.event.KeyAdapter() {
                public void keyReleased(java.awt.event.KeyEvent evt) {
                    enableDisableOpslaanButton(aantalVitessenTxt, kleurTxt, verhuurpuntIdTxt, lblFoutmelding);
                }
            });
            kleurTxt.addKeyListener(new java.awt.event.KeyAdapter() {
                public void keyReleased(java.awt.event.KeyEvent evt) {
                    enableDisableOpslaanButton(aantalVitessenTxt, kleurTxt, verhuurpuntIdTxt, lblFoutmelding);
                }
            });
            verhuurpuntIdTxt.addKeyListener(new java.awt.event.KeyAdapter() {
                public void keyReleased(java.awt.event.KeyEvent evt) {
                    enableDisableOpslaanButton(aantalVitessenTxt, kleurTxt, verhuurpuntIdTxt, lblFoutmelding);
                }
            });
            fietstypeCmb.addItemListener(new java.awt.event.ItemListener() {
                public void itemStateChanged(java.awt.event.ItemEvent evt) {
                    enableDisableOptionalFields(fietstypeCmb, aantalVitessenTxt, dikteBandCmb, kleurTxt);
                }
            });
            
            
            Fiets currentFiets = fietslist.get(i);
            
            fietsnummerTxt.setText(Integer.toString(currentFiets.getFietsnummer()));
            genderCmb.getModel().setSelectedItem(currentFiets.getGender());
            fietstypeCmb.getModel().setSelectedItem(currentFiets.getFietstype());
            if(currentFiets.getAantalVitessen() != 0) {
                aantalVitessenTxt.setText(Integer.toString(currentFiets.getAantalVitessen()));
            }
            
            if(currentFiets.getDikteBand() != null) {
                if(!currentFiets.getDikteBand().equals("")) {
                dikteBandCmb.getModel().setSelectedItem(currentFiets.getDikteBand());
                } else {
                    dikteBandCmb.getModel().setSelectedItem("Kies dikte...");
                }
            }
            if(currentFiets.getKleur() != null) {
                kleurTxt.setText(currentFiets.getKleur());
            }
            verhuurpuntIdTxt.setText(Integer.toString(currentFiets.getVerhuurpuntId()));
            
            
            enableDisableOptionalFields(fietstypeCmb, aantalVitessenTxt, dikteBandCmb, kleurTxt);
        }
        pack();
    }
    

    public ArrayList<Fiets> getFietsen() {
        ArrayList<Fiets> resultaat = new ArrayList<Fiets>();
        
        for(int i = 0; i < fietsnummerTxts.size(); i++) {
            int fietsnummer = Integer.parseInt(fietsnummerTxts.get(i).getText());
            String gender = genderCmbs.get(i).getModel().getSelectedItem().toString();
            String fietstype = fietstypeCmbs.get(i).getModel().getSelectedItem().toString();
            int aantalVitessen;
            if(!aantalVitessenTxts.get(i).getText().equals("")) {
                aantalVitessen = Integer.parseInt(aantalVitessenTxts.get(i).getText());
            } else {
                aantalVitessen = 0;
            }
            String dikteBand = dikteBandCmbs.get(i).getModel().getSelectedItem().toString();
            if(dikteBand.equals("Kies dikte...")) {
                dikteBand = "";
            }
            String kleur = kleurTxts.get(i).getText();
            int verhuurpuntId = Integer.parseInt(verhuurpuntIdTxts.get(i).getText());
            
            resultaat.add(new Fiets(fietsnummer, gender, fietstype, aantalVitessen, dikteBand, kleur, verhuurpuntId));
        }
        return resultaat;
    }
    
    
    public Resultaat showDialog() {
        this.setModal(true);
        this.setVisible(true);
        return this.formulierResultaat;
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
        btnSaveDataAndCloseGUI = new javax.swing.JButton();
        btnCloseGUI = new javax.swing.JButton();
        lblFoutmelding = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        getContentPane().setLayout(new java.awt.GridBagLayout());

        lblTitel.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        lblTitel.setText("Selectie aanpassen");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridwidth = 7;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.FIRST_LINE_START;
        gridBagConstraints.insets = new java.awt.Insets(3, 3, 9, 3);
        getContentPane().add(lblTitel, gridBagConstraints);

        lblFietsnummer.setText("Fietsnummer");
        lblFietsnummer.setToolTipText("");
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
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.FIRST_LINE_START;
        gridBagConstraints.insets = new java.awt.Insets(3, 3, 3, 3);
        getContentPane().add(lblFietstype, gridBagConstraints);

        lblAantalVitessen.setText("Aantal vitessen");
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

        lblVerhuurpuntId.setText("VerhuurpuntId*");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 6;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.FIRST_LINE_START;
        gridBagConstraints.insets = new java.awt.Insets(3, 3, 3, 3);
        getContentPane().add(lblVerhuurpuntId, gridBagConstraints);

        btnSaveDataAndCloseGUI.setText("Wijzigingen Opslaan");
        btnSaveDataAndCloseGUI.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSaveDataAndCloseGUIActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 5;
        gridBagConstraints.gridy = 100;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LAST_LINE_END;
        gridBagConstraints.insets = new java.awt.Insets(30, 15, 3, 3);
        getContentPane().add(btnSaveDataAndCloseGUI, gridBagConstraints);

        btnCloseGUI.setText("Annuleren");
        btnCloseGUI.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCloseGUIActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 4;
        gridBagConstraints.gridy = 100;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LAST_LINE_END;
        gridBagConstraints.insets = new java.awt.Insets(30, 3, 3, 3);
        getContentPane().add(btnCloseGUI, gridBagConstraints);

        lblFoutmelding.setText(" ");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 99;
        gridBagConstraints.gridwidth = 7;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        gridBagConstraints.insets = new java.awt.Insets(15, 3, 3, 3);
        getContentPane().add(lblFoutmelding, gridBagConstraints);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnCloseGUIActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCloseGUIActionPerformed
        this.formulierResultaat = Resultaat.GEANNULEERD;
        this.setVisible(false);
    }//GEN-LAST:event_btnCloseGUIActionPerformed

    private void btnSaveDataAndCloseGUIActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSaveDataAndCloseGUIActionPerformed
        this.formulierResultaat = Resultaat.BEVESTIGD;
        this.setVisible(false);
    }//GEN-LAST:event_btnSaveDataAndCloseGUIActionPerformed

    public void enableDisableOpslaanButton(javax.swing.JTextField aantalVitessenTxt, javax.swing.JTextField kleurTxt, javax.swing.JTextField verhuurpuntIdTxt, javax.swing.JLabel foutmeldingLbl) {
        if(verhuurpuntIdTxt.getText().equals("")) {
            btnSaveDataAndCloseGUI.setEnabled(false);
            foutmeldingLbl.setText("Vul a.u.b. alle verplichte velden in.");
            
        } else {
            if(CheckUserInput.doesVerhuurpuntIdExist(verhuurpuntIdTxt.getText(), foutmeldingLbl)) {
                if(CheckUserInput.isStringInteger(aantalVitessenTxt.getText()) || aantalVitessenTxt.getText().equals("")) {
                    btnSaveDataAndCloseGUI.setEnabled(true);
                    foutmeldingLbl.setText(" ");
                } else {
                    btnSaveDataAndCloseGUI.setEnabled(false);
                    foutmeldingLbl.setText("Vul a.u.b. een geldig aantal vitessen in, of laat het tekstveld leeg.");
                }
            } else {
                btnSaveDataAndCloseGUI.setEnabled(false);
            }
        }
    }
    
    public void enableDisableOptionalFields(javax.swing.JComboBox fietstypeCmb, javax.swing.JTextField aantalVitessenTxt, javax.swing.JComboBox dikteBandCmb, javax.swing.JTextField kleurTxt) {
        if(fietstypeCmb.getModel().getSelectedItem().toString().equals("stadsfiets")) {
            aantalVitessenTxt.setText("");
            aantalVitessenTxt.setEnabled(false);
            dikteBandCmb.getModel().setSelectedItem("Kies dikte...");
            dikteBandCmb.setEnabled(false);
            kleurTxt.setEnabled(true);
        } else {
            aantalVitessenTxt.setEnabled(true);
            dikteBandCmb.setEnabled(true);
            kleurTxt.setText("");
            kleurTxt.setEnabled(false);
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
            java.util.logging.Logger.getLogger(FietsenEditDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FietsenEditDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FietsenEditDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FietsenEditDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                FietsenEditDialog dialog = new FietsenEditDialog(new javax.swing.JFrame(), true);
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
    private javax.swing.JLabel lblAantalVitessen;
    private javax.swing.JLabel lblDikteBand;
    private javax.swing.JLabel lblFietsnummer;
    private javax.swing.JLabel lblFietstype;
    private javax.swing.JLabel lblFoutmelding;
    private javax.swing.JLabel lblGender;
    private javax.swing.JLabel lblKleur;
    private javax.swing.JLabel lblTitel;
    private javax.swing.JLabel lblVerhuurpuntId;
    // End of variables declaration//GEN-END:variables
}
