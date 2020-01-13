/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fietsverhuur.swing;

import fietsverhuur.dao.*;
import fietsverhuur.model.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author Myra
 */
public class HerstellingenEditDialog extends javax.swing.JDialog {

    /**
     * Creates new form VerhuringenEditDialog2
     */
    private ArrayList<javax.swing.JTextField> herstellingIdTxts;
    private ArrayList<javax.swing.JTextField> meldingsdatumTxts;
    private ArrayList<javax.swing.JTextField> huurderIdTxts;
    private ArrayList<javax.swing.JTextField> defectenTxts;
    private ArrayList<javax.swing.JTextField> fietsnummerTxts;
    
    public HerstellingenEditDialog(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        herstellingIdTxts = new ArrayList<javax.swing.JTextField>();
        meldingsdatumTxts = new ArrayList<javax.swing.JTextField>();
        huurderIdTxts = new ArrayList<javax.swing.JTextField>();
        defectenTxts = new ArrayList<javax.swing.JTextField>();
        fietsnummerTxts = new ArrayList<javax.swing.JTextField>();
    }
    public void createTextFieldsAndSetHerstellingen(ArrayList<Herstelling> herstellinglist) {
        int amount = herstellinglist.size();
        for (int i = 0; i < amount; i++) {
            
            java.awt.GridBagConstraints gridBagConstraints;
            
            javax.swing.JTextField herstellingIdTxt = new javax.swing.JTextField();
            javax.swing.JTextField meldingsdatumTxt = new javax.swing.JTextField();
            javax.swing.JTextField huurderIdTxt = new javax.swing.JTextField();
            javax.swing.JTextField fietsnummerTxt = new javax.swing.JTextField();
            javax.swing.JTextField defectenTxt = new javax.swing.JTextField();
            javax.swing.JTextField kostprijsTxt = new javax.swing.JTextField();
            
            herstellingIdTxts.add(herstellingIdTxt);
            meldingsdatumTxts.add(meldingsdatumTxt);
            huurderIdTxts.add(huurderIdTxt);
            defectenTxts.add(defectenTxt);
            fietsnummerTxts.add(fietsnummerTxt);
            
            Herstelling currentHerstelling = herstellinglist.get(i);
            
            herstellingIdTxt.setText(Integer.toString(currentHerstelling.getHerstellingId()));
            meldingsdatumTxt.setText(Calculate.df.format(currentHerstelling.getMeldingsdatum()));
            huurderIdTxt.setText(Integer.toString(currentHerstelling.getHuurderId()));
            fietsnummerTxt.setText(Integer.toString(currentHerstelling.getFietsnummer()));

            Double kostprijs = 0.0;
            
            ArrayList<Deelherstelling> deelherstellingenList = DeelherstellingDao.getDeelherstellingenByHerstellingId(currentHerstelling.getHerstellingId());
            ArrayList<Integer> defectnummerList = new ArrayList<Integer>();
            
            for(Deelherstelling currentDeelherstelling : deelherstellingenList) {
                int defectnummer = currentDeelherstelling.getDefectnummer();
                
                defectnummerList.add(defectnummer);
                
                Defect currentDefect = DefectDao.getDefectById(defectnummer);
                kostprijs += currentDefect.getKostprijs();
            }
            
            defectenTxt.setText(CheckUserInput.convertArrayListNaarDefectenstring(defectnummerList));
            
            kostprijsTxt.setText("€" + Calculate.roundAndAddZeroes(kostprijs, 2));
            
            
            
            
            pack();
            
            herstellingIdTxt.setEnabled(false);
            herstellingIdTxt.setPreferredSize(new java.awt.Dimension(100, 27));
            gridBagConstraints = new java.awt.GridBagConstraints();
            gridBagConstraints.gridx = 0;
            gridBagConstraints.gridy = i + 2;
            gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
            gridBagConstraints.anchor = java.awt.GridBagConstraints.FIRST_LINE_START;
            gridBagConstraints.insets = new java.awt.Insets(3, 3, 3, 3);
            getContentPane().add(herstellingIdTxt, gridBagConstraints);

            meldingsdatumTxt.setPreferredSize(new java.awt.Dimension(100, 27));
            gridBagConstraints = new java.awt.GridBagConstraints();
            gridBagConstraints.gridx = 1;
            gridBagConstraints.gridy = i + 2;
            gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
            gridBagConstraints.anchor = java.awt.GridBagConstraints.FIRST_LINE_START;
            gridBagConstraints.insets = new java.awt.Insets(3, 3, 3, 3);
            getContentPane().add(meldingsdatumTxt, gridBagConstraints);

            huurderIdTxt.setPreferredSize(new java.awt.Dimension(100, 27));
            gridBagConstraints = new java.awt.GridBagConstraints();
            gridBagConstraints.gridx = 2;
            gridBagConstraints.gridy = i + 2;
            gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
            gridBagConstraints.anchor = java.awt.GridBagConstraints.FIRST_LINE_START;
            gridBagConstraints.insets = new java.awt.Insets(3, 3, 3, 3);
            getContentPane().add(huurderIdTxt, gridBagConstraints);

            fietsnummerTxt.setPreferredSize(new java.awt.Dimension(100, 27));
            gridBagConstraints = new java.awt.GridBagConstraints();
            gridBagConstraints.gridx = 3;
            gridBagConstraints.gridy = i + 2;
            gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
            gridBagConstraints.anchor = java.awt.GridBagConstraints.FIRST_LINE_START;
            gridBagConstraints.insets = new java.awt.Insets(3, 3, 3, 3);
            getContentPane().add(fietsnummerTxt, gridBagConstraints);
            
            defectenTxt.setPreferredSize(new java.awt.Dimension(100, 27));
            gridBagConstraints = new java.awt.GridBagConstraints();
            gridBagConstraints.gridx = 4;
            gridBagConstraints.gridy = i + 2;
            gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
            gridBagConstraints.anchor = java.awt.GridBagConstraints.FIRST_LINE_START;
            gridBagConstraints.insets = new java.awt.Insets(3, 3, 3, 3);
            getContentPane().add(defectenTxt, gridBagConstraints);
            
            kostprijsTxt.setEnabled(false);
            kostprijsTxt.setPreferredSize(new java.awt.Dimension(100, 27));
            gridBagConstraints = new java.awt.GridBagConstraints();
            gridBagConstraints.gridx = 5;
            gridBagConstraints.gridy = i + 2;
            gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
            gridBagConstraints.anchor = java.awt.GridBagConstraints.FIRST_LINE_START;
            gridBagConstraints.insets = new java.awt.Insets(3, 3, 3, 3);
            getContentPane().add(kostprijsTxt, gridBagConstraints);
            
            meldingsdatumTxt.addKeyListener(new java.awt.event.KeyAdapter() {
                public void keyReleased(java.awt.event.KeyEvent evt) {
                    enableDisableOpslaanButton(meldingsdatumTxt, huurderIdTxt, fietsnummerTxt, defectenTxt, lblFoutmelding);
                }
            });
            huurderIdTxt.addKeyListener(new java.awt.event.KeyAdapter() {
                public void keyReleased(java.awt.event.KeyEvent evt) {
                    enableDisableOpslaanButton(meldingsdatumTxt, huurderIdTxt, fietsnummerTxt, defectenTxt, lblFoutmelding);
                }
            });
            fietsnummerTxt.addKeyListener(new java.awt.event.KeyAdapter() {
                public void keyReleased(java.awt.event.KeyEvent evt) {
                    enableDisableOpslaanButton(meldingsdatumTxt, huurderIdTxt, fietsnummerTxt, defectenTxt, lblFoutmelding);
                }
            });
            defectenTxt.addKeyListener(new java.awt.event.KeyAdapter() {
                public void keyReleased(java.awt.event.KeyEvent evt) {
                    checkFields(defectenTxt, kostprijsTxt, lblFoutmelding);
                    enableDisableOpslaanButton(meldingsdatumTxt, huurderIdTxt, fietsnummerTxt, defectenTxt, lblFoutmelding);
                }
            });
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
        lblHerstellingId = new javax.swing.JLabel();
        lblMeldingsdatum = new javax.swing.JLabel();
        lblHuurderId = new javax.swing.JLabel();
        lblFietsnummer = new javax.swing.JLabel();
        lblBedrag = new javax.swing.JLabel();
        btnSaveDataAndCloseGUI = new javax.swing.JButton();
        btnCloseGUI = new javax.swing.JButton();
        lblFoutmelding = new javax.swing.JLabel();
        lblDefecten = new javax.swing.JLabel();

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

        lblHerstellingId.setText("HerstellingId");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.FIRST_LINE_START;
        gridBagConstraints.insets = new java.awt.Insets(3, 3, 3, 3);
        getContentPane().add(lblHerstellingId, gridBagConstraints);

        lblMeldingsdatum.setText("Meldingsdatum");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.FIRST_LINE_START;
        gridBagConstraints.insets = new java.awt.Insets(3, 3, 3, 3);
        getContentPane().add(lblMeldingsdatum, gridBagConstraints);

        lblHuurderId.setText("HuurderId");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.FIRST_LINE_START;
        gridBagConstraints.insets = new java.awt.Insets(3, 3, 3, 3);
        getContentPane().add(lblHuurderId, gridBagConstraints);

        lblFietsnummer.setText("Fietsnummer");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.FIRST_LINE_START;
        gridBagConstraints.insets = new java.awt.Insets(3, 3, 3, 3);
        getContentPane().add(lblFietsnummer, gridBagConstraints);

        lblBedrag.setText("Bedrag");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 5;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.FIRST_LINE_START;
        gridBagConstraints.insets = new java.awt.Insets(3, 3, 3, 3);
        getContentPane().add(lblBedrag, gridBagConstraints);

        btnSaveDataAndCloseGUI.setText("Wijzigingen Opslaan");
        btnSaveDataAndCloseGUI.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSaveDataAndCloseGUIActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 4;
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
        gridBagConstraints.gridx = 3;
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

        lblDefecten.setText("Defecten");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 4;
        gridBagConstraints.gridy = 1;
        getContentPane().add(lblDefecten, gridBagConstraints);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnCloseGUIActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCloseGUIActionPerformed
        this.setVisible(false);
    }//GEN-LAST:event_btnCloseGUIActionPerformed

    private void btnSaveDataAndCloseGUIActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSaveDataAndCloseGUIActionPerformed

        for(int i = 0; i < herstellingIdTxts.size(); i++) {
                        
            int herstellingId = Integer.parseInt(herstellingIdTxts.get(i).getText());
            Date meldingsdatum = CheckUserInput.parseDate(meldingsdatumTxts.get(i).getText());
            int huurderId = Integer.parseInt(huurderIdTxts.get(i).getText());
            int fietsnummer = Integer.parseInt(fietsnummerTxts.get(i).getText());
            
            
            DeelherstellingDao.verwijderDeelherstellingenByHerstellingId(herstellingId);
            
            
            Herstelling nieuweHerstelling = new Herstelling(herstellingId, meldingsdatum, huurderId, fietsnummer);
            HerstellingDao.updateHerstelling(nieuweHerstelling);
            
           
            ArrayList<Integer> defectnummerlist = CheckUserInput.convertDefectenstringNaarArrayList(defectenTxts.get(i).getText());
            for(int defectnummer : defectnummerlist) {
                Deelherstelling nieuweDeelherstelling = new Deelherstelling(herstellingId, defectnummer);
                DeelherstellingDao.voegDeelherstellingToe(nieuweDeelherstelling);
            }
        }
      
        this.setVisible(false);
    }//GEN-LAST:event_btnSaveDataAndCloseGUIActionPerformed

    public void enableDisableOpslaanButton(javax.swing.JTextField meldingsdatumTxt, javax.swing.JTextField huurderIdTxt, javax.swing.JTextField fietsnummerTxt, javax.swing.JTextField defectenTxt, javax.swing.JLabel foutmeldingLbl) {
        if(meldingsdatumTxt.getText().equals("") || huurderIdTxt.getText().equals("") || fietsnummerTxt.getText().equals("") || defectenTxt.getText().equals("")) {
            btnSaveDataAndCloseGUI.setEnabled(false);
            foutmeldingLbl.setText("Vul a.u.b. alle velden in.");
            
        } else {
            if(CheckUserInput.doesFietsnummerExist(fietsnummerTxt.getText(), foutmeldingLbl)
                    && CheckUserInput.doesHuurderIdExist(huurderIdTxt.getText(), foutmeldingLbl)
                    && CheckUserInput.isDateParsable(meldingsdatumTxt.getText(), foutmeldingLbl)
                    && CheckUserInput.isDefectenStringValid(defectenTxt.getText(), foutmeldingLbl)
                    && CheckUserInput.doDefectnummersExist(CheckUserInput.convertDefectenstringNaarArrayList(defectenTxt.getText()), foutmeldingLbl)
                    ) {
                btnSaveDataAndCloseGUI.setEnabled(true);
                foutmeldingLbl.setText(" ");
            } else {
                btnSaveDataAndCloseGUI.setEnabled(false);
            }
        }
    }
    public void checkFields(javax.swing.JTextField defectenTxt, javax.swing.JTextField kostprijsTxt, javax.swing.JLabel foutmeldingLbl) {
        if(CheckUserInput.isDefectenStringValid(defectenTxt.getText(), foutmeldingLbl) && CheckUserInput.doDefectnummersExist(CheckUserInput.convertDefectenstringNaarArrayList(defectenTxt.getText()), foutmeldingLbl)) {
            ArrayList <Integer> defectennummers = CheckUserInput.convertDefectenstringNaarArrayList(defectenTxt.getText());
            double kostprijs = Calculate.calculateHerstellingKostprijs(defectennummers);
            kostprijsTxt.setText("€" + Calculate.roundAndAddZeroes(kostprijs, 2));
        } else {
            kostprijsTxt.setText("");
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
            java.util.logging.Logger.getLogger(HerstellingenEditDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(HerstellingenEditDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(HerstellingenEditDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(HerstellingenEditDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                HerstellingenEditDialog dialog = new HerstellingenEditDialog(new javax.swing.JFrame(), true);
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
    private javax.swing.JLabel lblBedrag;
    private javax.swing.JLabel lblDefecten;
    private javax.swing.JLabel lblFietsnummer;
    private javax.swing.JLabel lblFoutmelding;
    private javax.swing.JLabel lblHerstellingId;
    private javax.swing.JLabel lblHuurderId;
    private javax.swing.JLabel lblMeldingsdatum;
    private javax.swing.JLabel lblTitel;
    // End of variables declaration//GEN-END:variables
}
