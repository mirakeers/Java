/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fietsverhuur.swing;


import fietsverhuur.dao.*;
import fietsverhuur.model.*;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Myra
 */
public class VerhuringenEditDialog extends javax.swing.JDialog {

    /**
     * Creates new form VerhuringenEditDialog2
     */
    private ArrayList<javax.swing.JTextField> verhuringIdTxts;
    private ArrayList<javax.swing.JTextField> begindatumTxts;
    private ArrayList<javax.swing.JTextField> duurTxts;
    private ArrayList<javax.swing.JTextField> huurderIdTxts;
    private ArrayList<javax.swing.JTextField> fietsnummerTxts;
    
    private Resultaat formulierResultaat;

    public Resultaat getFormulierResultaat() {
        return formulierResultaat;
    }
    
    public enum Resultaat{
        GEANNULEERD,
        BEVESTIGD
    }
    
    public VerhuringenEditDialog(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        verhuringIdTxts = new ArrayList<javax.swing.JTextField>();
        begindatumTxts = new ArrayList<javax.swing.JTextField>();
        duurTxts = new ArrayList<javax.swing.JTextField>();
        huurderIdTxts = new ArrayList<javax.swing.JTextField>();
        fietsnummerTxts = new ArrayList<javax.swing.JTextField>();
    }
    public void createTextFieldsAndSetVerhuringen(ArrayList<Verhuring> verhuringlist) {
        int amount = verhuringlist.size();
        for (int i = 0; i < amount; i++) {
            
            java.awt.GridBagConstraints gridBagConstraints;
            
            javax.swing.JTextField verhuringIdTxt = new javax.swing.JTextField();
            javax.swing.JTextField begindatumTxt = new javax.swing.JTextField();
            javax.swing.JTextField duurTxt = new javax.swing.JTextField();
            javax.swing.JTextField einddatumTxt = new javax.swing.JTextField();
            javax.swing.JTextField huurderIdTxt = new javax.swing.JTextField();
            javax.swing.JTextField fietsnummerTxt = new javax.swing.JTextField();
            javax.swing.JTextField kostprijsTxt = new javax.swing.JTextField();
            
            verhuringIdTxts.add(verhuringIdTxt);
            begindatumTxts.add(begindatumTxt);
            duurTxts.add(duurTxt);
            huurderIdTxts.add(huurderIdTxt);
            fietsnummerTxts.add(fietsnummerTxt);
            
            Verhuring currentVerhuring = verhuringlist.get(i);
            verhuringIdTxt.setText(Integer.toString(currentVerhuring.getVerhuringId()));
            begindatumTxt.setText(Calculate.df.format(currentVerhuring.getBegindatum()));
            duurTxt.setText(Integer.toString(currentVerhuring.getDuurInDagen()));
            huurderIdTxt.setText(Integer.toString(currentVerhuring.getHuurderId()));
            fietsnummerTxt.setText(Integer.toString(currentVerhuring.getFietsnummer()));
            einddatumTxt.setText(Calculate.df.format(currentVerhuring.getEinddatum()));

            Double kostprijs = KostprijsPerVerhuringIdDao.getKostprijzenPerVerhuringIdByVerhuringId(currentVerhuring.getVerhuringId()).getKostprijs();
            kostprijsTxt.setText("€" + Calculate.roundAndAddZeroes(kostprijs, 2));
            
            
            
            
            pack();
            
            verhuringIdTxt.setEnabled(false);
            verhuringIdTxt.setPreferredSize(new java.awt.Dimension(100, 27));
            gridBagConstraints = new java.awt.GridBagConstraints();
            gridBagConstraints.gridx = 0;
            gridBagConstraints.gridy = i + 2;
            gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
            gridBagConstraints.anchor = java.awt.GridBagConstraints.FIRST_LINE_START;
            gridBagConstraints.insets = new java.awt.Insets(3, 3, 3, 3);
            getContentPane().add(verhuringIdTxt, gridBagConstraints);

            begindatumTxt.setPreferredSize(new java.awt.Dimension(100, 27));
            gridBagConstraints = new java.awt.GridBagConstraints();
            gridBagConstraints.gridx = 1;
            gridBagConstraints.gridy = i + 2;
            gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
            gridBagConstraints.anchor = java.awt.GridBagConstraints.FIRST_LINE_START;
            gridBagConstraints.insets = new java.awt.Insets(3, 3, 3, 3);
            getContentPane().add(begindatumTxt, gridBagConstraints);

            duurTxt.setPreferredSize(new java.awt.Dimension(100, 27));
            gridBagConstraints = new java.awt.GridBagConstraints();
            gridBagConstraints.gridx = 2;
            gridBagConstraints.gridy = i + 2;
            gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
            gridBagConstraints.anchor = java.awt.GridBagConstraints.FIRST_LINE_START;
            gridBagConstraints.insets = new java.awt.Insets(3, 3, 3, 3);
            getContentPane().add(duurTxt, gridBagConstraints);

            einddatumTxt.setEnabled(false);
            einddatumTxt.setPreferredSize(new java.awt.Dimension(100, 27));
            gridBagConstraints = new java.awt.GridBagConstraints();
            gridBagConstraints.gridx = 3;
            gridBagConstraints.gridy = i + 2;
            gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
            gridBagConstraints.anchor = java.awt.GridBagConstraints.FIRST_LINE_START;
            gridBagConstraints.insets = new java.awt.Insets(3, 3, 3, 3);
            getContentPane().add(einddatumTxt, gridBagConstraints);
            
            huurderIdTxt.setPreferredSize(new java.awt.Dimension(100, 27));
            gridBagConstraints = new java.awt.GridBagConstraints();
            gridBagConstraints.gridx = 4;
            gridBagConstraints.gridy = i + 2;
            gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
            gridBagConstraints.anchor = java.awt.GridBagConstraints.FIRST_LINE_START;
            gridBagConstraints.insets = new java.awt.Insets(3, 3, 3, 3);
            getContentPane().add(huurderIdTxt, gridBagConstraints);

            fietsnummerTxt.setPreferredSize(new java.awt.Dimension(100, 27));
            gridBagConstraints = new java.awt.GridBagConstraints();
            gridBagConstraints.gridx = 5;
            gridBagConstraints.gridy = i + 2;
            gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
            gridBagConstraints.anchor = java.awt.GridBagConstraints.FIRST_LINE_START;
            gridBagConstraints.insets = new java.awt.Insets(3, 3, 3, 3);
            getContentPane().add(fietsnummerTxt, gridBagConstraints);

            kostprijsTxt.setEnabled(false);
            kostprijsTxt.setPreferredSize(new java.awt.Dimension(100, 27));
            gridBagConstraints = new java.awt.GridBagConstraints();
            gridBagConstraints.gridx = 6;
            gridBagConstraints.gridy = i + 2;
            gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
            gridBagConstraints.anchor = java.awt.GridBagConstraints.FIRST_LINE_START;
            gridBagConstraints.insets = new java.awt.Insets(3, 3, 3, 3);
            getContentPane().add(kostprijsTxt, gridBagConstraints);
            
            
            begindatumTxt.addKeyListener(new java.awt.event.KeyAdapter() {
                public void keyReleased(java.awt.event.KeyEvent evt) {
                    checkFields(begindatumTxt, duurTxt, einddatumTxt, fietsnummerTxt, kostprijsTxt, lblFoutmelding);
                    enableDisableOpslaanButton(begindatumTxt, duurTxt, huurderIdTxt, fietsnummerTxt, lblFoutmelding);
                }
            });
            duurTxt.addKeyListener(new java.awt.event.KeyAdapter() {
                public void keyReleased(java.awt.event.KeyEvent evt) {
                    checkFields(begindatumTxt, duurTxt, einddatumTxt, fietsnummerTxt, kostprijsTxt, lblFoutmelding);
                    enableDisableOpslaanButton(begindatumTxt, duurTxt, huurderIdTxt, fietsnummerTxt, lblFoutmelding);
                }
            });
            huurderIdTxt.addKeyListener(new java.awt.event.KeyAdapter() {
                public void keyReleased(java.awt.event.KeyEvent evt) {
                    checkFields(begindatumTxt, duurTxt, einddatumTxt, fietsnummerTxt, kostprijsTxt, lblFoutmelding);
                    enableDisableOpslaanButton(begindatumTxt, duurTxt, huurderIdTxt, fietsnummerTxt, lblFoutmelding);
                }
            });
            fietsnummerTxt.addKeyListener(new java.awt.event.KeyAdapter() {
                public void keyReleased(java.awt.event.KeyEvent evt) {
                    checkFields(begindatumTxt, duurTxt, einddatumTxt, fietsnummerTxt, kostprijsTxt, lblFoutmelding);
                    enableDisableOpslaanButton(begindatumTxt, duurTxt, huurderIdTxt, fietsnummerTxt, lblFoutmelding);
                }
            });
        }
        pack();
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
        lblVerhuringId = new javax.swing.JLabel();
        lblBegindatum = new javax.swing.JLabel();
        lblDuur = new javax.swing.JLabel();
        lblEinddatum = new javax.swing.JLabel();
        lblHuurderId = new javax.swing.JLabel();
        lblFietsnummer = new javax.swing.JLabel();
        lblKostprijs = new javax.swing.JLabel();
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

        lblVerhuringId.setText("VerhuringId");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.FIRST_LINE_START;
        gridBagConstraints.insets = new java.awt.Insets(3, 3, 3, 3);
        getContentPane().add(lblVerhuringId, gridBagConstraints);

        lblBegindatum.setText("Begindatum");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.FIRST_LINE_START;
        gridBagConstraints.insets = new java.awt.Insets(3, 3, 3, 3);
        getContentPane().add(lblBegindatum, gridBagConstraints);

        lblDuur.setText("Duur (dagen)");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.FIRST_LINE_START;
        gridBagConstraints.insets = new java.awt.Insets(3, 3, 3, 3);
        getContentPane().add(lblDuur, gridBagConstraints);

        lblEinddatum.setText("Einddatum");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.FIRST_LINE_START;
        gridBagConstraints.insets = new java.awt.Insets(3, 3, 3, 3);
        getContentPane().add(lblEinddatum, gridBagConstraints);

        lblHuurderId.setText("HuurderId");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 4;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.FIRST_LINE_START;
        gridBagConstraints.insets = new java.awt.Insets(3, 3, 3, 3);
        getContentPane().add(lblHuurderId, gridBagConstraints);

        lblFietsnummer.setText("Fietsnummer");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 5;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.FIRST_LINE_START;
        gridBagConstraints.insets = new java.awt.Insets(3, 3, 3, 3);
        getContentPane().add(lblFietsnummer, gridBagConstraints);

        lblKostprijs.setText("Kostprijs");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 6;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.FIRST_LINE_START;
        gridBagConstraints.insets = new java.awt.Insets(3, 3, 3, 3);
        getContentPane().add(lblKostprijs, gridBagConstraints);

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
        this.setVisible(false);
    }//GEN-LAST:event_btnCloseGUIActionPerformed

    private void btnSaveDataAndCloseGUIActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSaveDataAndCloseGUIActionPerformed

        for(int i = 0; i < verhuringIdTxts.size(); i++) {
            int verhuringId = Integer.parseInt(verhuringIdTxts.get(i).getText());
            Date begindatum = CheckUserInput.parseDate(begindatumTxts.get(i).getText());
            int duurInDagen = Integer.parseInt(duurTxts.get(i).getText());
            int huurderId = Integer.parseInt(huurderIdTxts.get(i).getText());
            int fietsnummer = Integer.parseInt(fietsnummerTxts.get(i).getText());
            Verhuring nieuweVerhuring = new Verhuring(verhuringId, begindatum, duurInDagen, huurderId, fietsnummer);
            VerhuringDao.updateVerhuring(nieuweVerhuring);
        }

        this.setVisible(false);
    }//GEN-LAST:event_btnSaveDataAndCloseGUIActionPerformed

    public void enableDisableOpslaanButton(javax.swing.JTextField begindatumTxt, javax.swing.JTextField duurTxt, javax.swing.JTextField huurderIdTxt, javax.swing.JTextField fietsnummerTxt, javax.swing.JLabel foutmeldingLbl) {
        if(begindatumTxt.getText().equals("") || duurTxt.getText().equals("") || huurderIdTxt.getText().equals("") || fietsnummerTxt.getText().equals("")) {
            btnSaveDataAndCloseGUI.setEnabled(false);
            foutmeldingLbl.setText("Vul a.u.b. alle velden in.");
            
        } else {
            if(CheckUserInput.doesFietsnummerExist(fietsnummerTxt.getText(), foutmeldingLbl)
                    && CheckUserInput.doesHuurderIdExist(huurderIdTxt.getText(), foutmeldingLbl)
                    && CheckUserInput.isDateParsable(begindatumTxt.getText(), foutmeldingLbl)
                    && CheckUserInput.isDuurValid(duurTxt.getText(), foutmeldingLbl)
                    ) {
                btnSaveDataAndCloseGUI.setEnabled(true);
                foutmeldingLbl.setText(" ");
            } else {
                btnSaveDataAndCloseGUI.setEnabled(false);
            }
        }
    }
    public void checkFields(javax.swing.JTextField begindatumTxt, javax.swing.JTextField duurTxt, javax.swing.JTextField einddatumTxt, javax.swing.JTextField fietsnummerTxt, javax.swing.JTextField kostprijsTxt, javax.swing.JLabel foutmeldingLbl) {
        if(CheckUserInput.isDateParsable(begindatumTxt.getText(), foutmeldingLbl) && CheckUserInput.isDuurValid(duurTxt.getText(), foutmeldingLbl)) {
            einddatumTxt.setText(Calculate.calculateEinddatum(begindatumTxt.getText(), Integer.parseInt(duurTxt.getText())));
        } else {
            einddatumTxt.setText("");
        }
        
        if(CheckUserInput.isDuurValid(duurTxt.getText(), foutmeldingLbl)&& CheckUserInput.isStringInteger(fietsnummerTxt.getText())) {
            double kostprijs = Calculate.calculateVerhuringKostprijs(Integer.parseInt(duurTxt.getText()), Integer.parseInt(fietsnummerTxt.getText()));
            kostprijsTxt.setText("€" + Calculate.roundAndAddZeroes(kostprijs, 2));
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
            java.util.logging.Logger.getLogger(VerhuringenEditDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(VerhuringenEditDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(VerhuringenEditDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(VerhuringenEditDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                VerhuringenEditDialog dialog = new VerhuringenEditDialog(new javax.swing.JFrame(), true);
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
    private javax.swing.JLabel lblBegindatum;
    private javax.swing.JLabel lblDuur;
    private javax.swing.JLabel lblEinddatum;
    private javax.swing.JLabel lblFietsnummer;
    private javax.swing.JLabel lblFoutmelding;
    private javax.swing.JLabel lblHuurderId;
    private javax.swing.JLabel lblKostprijs;
    private javax.swing.JLabel lblTitel;
    private javax.swing.JLabel lblVerhuringId;
    // End of variables declaration//GEN-END:variables
}
