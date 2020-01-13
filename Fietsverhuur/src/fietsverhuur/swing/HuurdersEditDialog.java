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
public class HuurdersEditDialog extends javax.swing.JDialog {

    /**
     * Creates new form VerhuringenEditDialog2
     */
    private ArrayList<javax.swing.JTextField> huurderIdTxts;
    private ArrayList<javax.swing.JTextField> voornaamTxts;
    private ArrayList<javax.swing.JTextField> achternaamTxts;
    private ArrayList<javax.swing.JTextField> adresTxts;
    private ArrayList<javax.swing.JTextField> stadTxts;
    private ArrayList<javax.swing.JTextField> telefoonnummerTxts;
    private ArrayList<javax.swing.JTextField> emailadresTxts;
    
    private Resultaat formulierResultaat;

    public Resultaat getFormulierResultaat() {
        return formulierResultaat;
    }
    
    public enum Resultaat{
        GEANNULEERD,
        BEVESTIGD
    }
    
    public HuurdersEditDialog(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        huurderIdTxts = new ArrayList<javax.swing.JTextField> ();
        voornaamTxts = new ArrayList<javax.swing.JTextField> ();
        achternaamTxts = new ArrayList<javax.swing.JTextField> ();
        adresTxts = new ArrayList<javax.swing.JTextField> ();
        stadTxts = new ArrayList<javax.swing.JTextField> ();
        telefoonnummerTxts = new ArrayList<javax.swing.JTextField> ();
        emailadresTxts = new ArrayList<javax.swing.JTextField> ();
    }
    public void createTextFieldsAndSetHuurders(ArrayList<Huurder> huurderlist) {
        int amount = huurderlist.size();
        for (int i = 0; i < amount; i++) {
            
            java.awt.GridBagConstraints gridBagConstraints;
            
            javax.swing.JTextField huurderIdTxt = new javax.swing.JTextField();
            javax.swing.JTextField voornaamTxt = new javax.swing.JTextField();
            javax.swing.JTextField achternaamTxt = new javax.swing.JTextField();
            javax.swing.JTextField adresTxt = new javax.swing.JTextField();
            javax.swing.JTextField stadTxt = new javax.swing.JTextField();
            javax.swing.JTextField telefoonnummerTxt = new javax.swing.JTextField();
            javax.swing.JTextField emailadresTxt = new javax.swing.JTextField();
            
            huurderIdTxts.add(huurderIdTxt);
            voornaamTxts.add(voornaamTxt);
            achternaamTxts.add(achternaamTxt);
            adresTxts.add(adresTxt);
            stadTxts.add(stadTxt);
            telefoonnummerTxts.add(telefoonnummerTxt);
            emailadresTxts.add(emailadresTxt);
            
            Huurder currentHuurder = huurderlist.get(i);
            huurderIdTxt.setText(Integer.toString(currentHuurder.getHuurderId()));
            voornaamTxt.setText(currentHuurder.getVoornaam());
            achternaamTxt.setText(currentHuurder.getAchternaam());
            adresTxt.setText(currentHuurder.getAdres());
            stadTxt.setText(currentHuurder.getStad());
            telefoonnummerTxt.setText(currentHuurder.getTelefoonnummer());
            emailadresTxt.setText(currentHuurder.getEmailadres());
            
            
            
            
            pack();
            
            huurderIdTxt.setEnabled(false);
            huurderIdTxt.setPreferredSize(new java.awt.Dimension(100, 27));
            gridBagConstraints = new java.awt.GridBagConstraints();
            gridBagConstraints.gridx = 0;
            gridBagConstraints.gridy = i + 2;
            gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
            gridBagConstraints.anchor = java.awt.GridBagConstraints.FIRST_LINE_START;
            gridBagConstraints.insets = new java.awt.Insets(3, 3, 3, 3);
            getContentPane().add(huurderIdTxt, gridBagConstraints);

            voornaamTxt.setPreferredSize(new java.awt.Dimension(100, 27));
            gridBagConstraints = new java.awt.GridBagConstraints();
            gridBagConstraints.gridx = 1;
            gridBagConstraints.gridy = i + 2;
            gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
            gridBagConstraints.anchor = java.awt.GridBagConstraints.FIRST_LINE_START;
            gridBagConstraints.insets = new java.awt.Insets(3, 3, 3, 3);
            getContentPane().add(voornaamTxt, gridBagConstraints);

            achternaamTxt.setPreferredSize(new java.awt.Dimension(100, 27));
            gridBagConstraints = new java.awt.GridBagConstraints();
            gridBagConstraints.gridx = 2;
            gridBagConstraints.gridy = i + 2;
            gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
            gridBagConstraints.anchor = java.awt.GridBagConstraints.FIRST_LINE_START;
            gridBagConstraints.insets = new java.awt.Insets(3, 3, 3, 3);
            getContentPane().add(achternaamTxt, gridBagConstraints);

            adresTxt.setPreferredSize(new java.awt.Dimension(150, 27));
            gridBagConstraints = new java.awt.GridBagConstraints();
            gridBagConstraints.gridx = 3;
            gridBagConstraints.gridy = i + 2;
            gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
            gridBagConstraints.anchor = java.awt.GridBagConstraints.FIRST_LINE_START;
            gridBagConstraints.insets = new java.awt.Insets(3, 3, 3, 3);
            getContentPane().add(adresTxt, gridBagConstraints);
            
            stadTxt.setPreferredSize(new java.awt.Dimension(100, 27));
            gridBagConstraints = new java.awt.GridBagConstraints();
            gridBagConstraints.gridx = 4;
            gridBagConstraints.gridy = i + 2;
            gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
            gridBagConstraints.anchor = java.awt.GridBagConstraints.FIRST_LINE_START;
            gridBagConstraints.insets = new java.awt.Insets(3, 3, 3, 3);
            getContentPane().add(stadTxt, gridBagConstraints);

            telefoonnummerTxt.setPreferredSize(new java.awt.Dimension(110, 27));
            gridBagConstraints = new java.awt.GridBagConstraints();
            gridBagConstraints.gridx = 5;
            gridBagConstraints.gridy = i + 2;
            gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
            gridBagConstraints.anchor = java.awt.GridBagConstraints.FIRST_LINE_START;
            gridBagConstraints.insets = new java.awt.Insets(3, 3, 3, 3);
            getContentPane().add(telefoonnummerTxt, gridBagConstraints);
            
            emailadresTxt.setPreferredSize(new java.awt.Dimension(200, 27));
            gridBagConstraints = new java.awt.GridBagConstraints();
            gridBagConstraints.gridx = 6;
            gridBagConstraints.gridy = i + 2;
            gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
            gridBagConstraints.anchor = java.awt.GridBagConstraints.FIRST_LINE_START;
            gridBagConstraints.insets = new java.awt.Insets(3, 3, 3, 3);
            getContentPane().add(emailadresTxt, gridBagConstraints);
            
            
            voornaamTxt.addKeyListener(new java.awt.event.KeyAdapter() {
                public void keyReleased(java.awt.event.KeyEvent evt) {
                    enableDisableOpslaanButton(voornaamTxt, achternaamTxt, adresTxt, stadTxt, telefoonnummerTxt, emailadresTxt, lblFoutmelding);
                }
            });
            achternaamTxt.addKeyListener(new java.awt.event.KeyAdapter() {
                public void keyReleased(java.awt.event.KeyEvent evt) {
                    enableDisableOpslaanButton(voornaamTxt, achternaamTxt, adresTxt, stadTxt, telefoonnummerTxt, emailadresTxt, lblFoutmelding);
                }
            });
            adresTxt.addKeyListener(new java.awt.event.KeyAdapter() {
                public void keyReleased(java.awt.event.KeyEvent evt) {
                    enableDisableOpslaanButton(voornaamTxt, achternaamTxt, adresTxt, stadTxt, telefoonnummerTxt, emailadresTxt, lblFoutmelding);
                }
            });
            stadTxt.addKeyListener(new java.awt.event.KeyAdapter() {
                public void keyReleased(java.awt.event.KeyEvent evt) {
                    enableDisableOpslaanButton(voornaamTxt, achternaamTxt, adresTxt, stadTxt, telefoonnummerTxt, emailadresTxt, lblFoutmelding);
                }
            });
            telefoonnummerTxt.addKeyListener(new java.awt.event.KeyAdapter() {
                public void keyReleased(java.awt.event.KeyEvent evt) {
                    enableDisableOpslaanButton(voornaamTxt, achternaamTxt, adresTxt, stadTxt, telefoonnummerTxt, emailadresTxt, lblFoutmelding);
                }
            });
            emailadresTxt.addKeyListener(new java.awt.event.KeyAdapter() {
                public void keyReleased(java.awt.event.KeyEvent evt) {
                    enableDisableOpslaanButton(voornaamTxt, achternaamTxt, adresTxt, stadTxt, telefoonnummerTxt, emailadresTxt, lblFoutmelding);
                }
            });
        }
        pack();
    }
    
    public ArrayList<Huurder> getHuurders() {
        ArrayList<Huurder> resultaat = new ArrayList<Huurder>();
        for(int i = 0; i < huurderIdTxts.size(); i++) {
            int huurderId = Integer.parseInt(huurderIdTxts.get(i).getText());
            String voornaam = voornaamTxts.get(i).getText();
            String achternaam = achternaamTxts.get(i).getText();
            String adres = adresTxts.get(i).getText();
            String stad = stadTxts.get(i).getText();
            String telefoonnummer = telefoonnummerTxts.get(i).getText();
            String emailadres = emailadresTxts.get(i).getText();
            
            resultaat.add(new Huurder(huurderId, voornaam, achternaam, adres, stad, telefoonnummer, emailadres));
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
        lblHuurderId = new javax.swing.JLabel();
        lblVoornaam = new javax.swing.JLabel();
        lblAchternaam = new javax.swing.JLabel();
        lblAdres = new javax.swing.JLabel();
        lblStad = new javax.swing.JLabel();
        lblTelefoonnummer = new javax.swing.JLabel();
        lblEmailadres = new javax.swing.JLabel();
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

        lblHuurderId.setText("HuurderId");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.FIRST_LINE_START;
        gridBagConstraints.insets = new java.awt.Insets(3, 3, 3, 3);
        getContentPane().add(lblHuurderId, gridBagConstraints);

        lblVoornaam.setText("Voornaam*");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.FIRST_LINE_START;
        gridBagConstraints.insets = new java.awt.Insets(3, 3, 3, 3);
        getContentPane().add(lblVoornaam, gridBagConstraints);

        lblAchternaam.setText("Achternaam*");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.FIRST_LINE_START;
        gridBagConstraints.insets = new java.awt.Insets(3, 3, 3, 3);
        getContentPane().add(lblAchternaam, gridBagConstraints);

        lblAdres.setText("Adres*");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.FIRST_LINE_START;
        gridBagConstraints.insets = new java.awt.Insets(3, 3, 3, 3);
        getContentPane().add(lblAdres, gridBagConstraints);

        lblStad.setText("Stad*");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 4;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.FIRST_LINE_START;
        gridBagConstraints.insets = new java.awt.Insets(3, 3, 3, 3);
        getContentPane().add(lblStad, gridBagConstraints);

        lblTelefoonnummer.setText("Telefoonnummer");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 5;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.FIRST_LINE_START;
        gridBagConstraints.insets = new java.awt.Insets(3, 3, 3, 3);
        getContentPane().add(lblTelefoonnummer, gridBagConstraints);

        lblEmailadres.setText("E-mailadres*");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 6;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.FIRST_LINE_START;
        gridBagConstraints.insets = new java.awt.Insets(3, 3, 3, 3);
        getContentPane().add(lblEmailadres, gridBagConstraints);

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

    javax.swing.JTextField huurderIdTxt = new javax.swing.JTextField();
            javax.swing.JTextField voornaamTxt = new javax.swing.JTextField();
            javax.swing.JTextField achternaamTxt = new javax.swing.JTextField();
            javax.swing.JTextField adresTxt = new javax.swing.JTextField();
            javax.swing.JTextField stadTxt = new javax.swing.JTextField();
            javax.swing.JTextField telefoonnummerTxt = new javax.swing.JTextField();
            javax.swing.JTextField emailadresTxt = new javax.swing.JTextField();
            
    public void enableDisableOpslaanButton(javax.swing.JTextField voornaamTxt, javax.swing.JTextField achternaamTxt, javax.swing.JTextField adresTxt, javax.swing.JTextField stadTxt, javax.swing.JTextField telefoonnummerTxt, javax.swing.JTextField emailadresTxt, javax.swing.JLabel foutmeldingLbl) {
        if(voornaamTxt.getText().equals("") || achternaamTxt.getText().equals("") || adresTxt.getText().equals("") || stadTxt.getText().equals("") || emailadresTxt.getText().equals("")) {
            btnSaveDataAndCloseGUI.setEnabled(false);
            foutmeldingLbl.setText("Vul a.u.b. alle verplichte velden in.");
            
        } else {
            if(CheckUserInput.isNameValid(voornaamTxt.getText(), foutmeldingLbl)
                    && CheckUserInput.isNameValid(achternaamTxt.getText(), foutmeldingLbl)
                    ) {
                btnSaveDataAndCloseGUI.setEnabled(true);
                foutmeldingLbl.setText(" ");
            } else {
                btnSaveDataAndCloseGUI.setEnabled(false);
            }
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
            java.util.logging.Logger.getLogger(HuurdersEditDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(HuurdersEditDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(HuurdersEditDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(HuurdersEditDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                HuurdersEditDialog dialog = new HuurdersEditDialog(new javax.swing.JFrame(), true);
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
    private javax.swing.JLabel lblAchternaam;
    private javax.swing.JLabel lblAdres;
    private javax.swing.JLabel lblEmailadres;
    private javax.swing.JLabel lblFoutmelding;
    private javax.swing.JLabel lblHuurderId;
    private javax.swing.JLabel lblStad;
    private javax.swing.JLabel lblTelefoonnummer;
    private javax.swing.JLabel lblTitel;
    private javax.swing.JLabel lblVoornaam;
    // End of variables declaration//GEN-END:variables
}
