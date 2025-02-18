/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fietsverhuur.swing;

import fietsverhuur.dao.*;
import fietsverhuur.model.*;
import java.util.ArrayList;
import javax.swing.DefaultListModel;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;

/**
 *
 * @author Myra
 */
public class HuurdersSearchDialog extends javax.swing.JDialog {

    private DefaultListModel<Huurder> huurderModel;
    
    public HuurdersSearchDialog(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        huurderModel = new DefaultListModel<Huurder>();
        lstZoekresultaten.setModel(huurderModel);
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

        btnCloseThisGUI = new javax.swing.JButton();
        lblHuurderId = new javax.swing.JLabel();
        txtStad = new javax.swing.JTextField();
        lblZoekresultatenList = new javax.swing.JLabel();
        btnSearchHuurders = new javax.swing.JButton();
        lblTitel = new javax.swing.JLabel();
        btnOpenHuurdersEditDialog = new javax.swing.JButton();
        btnOpenHuurdersDeleteDialog = new javax.swing.JButton();
        txtHuurderId = new javax.swing.JTextField();
        lblEmailadres = new javax.swing.JLabel();
        lblVoornaam = new javax.swing.JLabel();
        txtEmailadres = new javax.swing.JTextField();
        txtVoornaam = new javax.swing.JTextField();
        lblAchternaam = new javax.swing.JLabel();
        txtAchternaam = new javax.swing.JTextField();
        lblTelefoonnummer = new javax.swing.JLabel();
        txtTelefoonnummer = new javax.swing.JTextField();
        lblStad = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        lstZoekresultaten = new javax.swing.JList();
        lblFoutmelding = new javax.swing.JLabel();
        btnOpenHuurdersDetailsDialog = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        btnCloseThisGUI.setText("Sluit venster");
        btnCloseThisGUI.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCloseThisGUIActionPerformed(evt);
            }
        });

        lblHuurderId.setText("HuurderId");

        txtStad.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtStadKeyReleased(evt);
            }
        });

        lblZoekresultatenList.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        lblZoekresultatenList.setText("Resultaten:");

        btnSearchHuurders.setText("Zoek huurder");
        btnSearchHuurders.setEnabled(false);
        btnSearchHuurders.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSearchHuurdersActionPerformed(evt);
            }
        });

        lblTitel.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        lblTitel.setText("Zoek huurders");
        lblTitel.setToolTipText("");

        btnOpenHuurdersEditDialog.setText("Details/Edit selectie");
        btnOpenHuurdersEditDialog.setEnabled(false);
        btnOpenHuurdersEditDialog.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnOpenHuurdersEditDialogActionPerformed(evt);
            }
        });

        btnOpenHuurdersDeleteDialog.setText("Verwijder selectie");
        btnOpenHuurdersDeleteDialog.setEnabled(false);
        btnOpenHuurdersDeleteDialog.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnOpenHuurdersDeleteDialogActionPerformed(evt);
            }
        });

        txtHuurderId.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtHuurderIdKeyReleased(evt);
            }
        });

        lblEmailadres.setText("E-mailadres");

        lblVoornaam.setText("Voornaam");

        txtEmailadres.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtEmailadresKeyReleased(evt);
            }
        });

        txtVoornaam.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtVoornaamKeyReleased(evt);
            }
        });

        lblAchternaam.setText("Achternaam");

        txtAchternaam.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtAchternaamKeyReleased(evt);
            }
        });

        lblTelefoonnummer.setText("Telefoonnummer");

        txtTelefoonnummer.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtTelefoonnummerKeyReleased(evt);
            }
        });

        lblStad.setText("Stad");
        lblStad.setToolTipText("");

        lstZoekresultaten.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                lstZoekresultatenValueChanged(evt);
            }
        });
        jScrollPane1.setViewportView(lstZoekresultaten);

        lblFoutmelding.setText(" ");

        btnOpenHuurdersDetailsDialog.setText("Details selectie");
        btnOpenHuurdersDetailsDialog.setEnabled(false);
        btnOpenHuurdersDetailsDialog.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnOpenHuurdersDetailsDialogActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 391, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(btnOpenHuurdersDeleteDialog, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnOpenHuurdersEditDialog, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnOpenHuurdersDetailsDialog, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(lblStad)
                                    .addComponent(txtStad, javax.swing.GroupLayout.DEFAULT_SIZE, 92, Short.MAX_VALUE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lblTelefoonnummer)
                                    .addComponent(txtTelefoonnummer, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lblEmailadres)
                                    .addComponent(txtEmailadres)))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(btnCloseThisGUI)
                                    .addComponent(lblZoekresultatenList)
                                    .addComponent(lblTitel)
                                    .addComponent(btnSearchHuurders)
                                    .addComponent(lblFoutmelding))
                                .addGap(28, 28, 28))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtHuurderId, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(lblHuurderId))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtVoornaam, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(lblVoornaam))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lblAchternaam)
                                    .addComponent(txtAchternaam, javax.swing.GroupLayout.DEFAULT_SIZE, 86, Short.MAX_VALUE))))
                        .addGap(0, 226, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblTitel)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblHuurderId, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(lblVoornaam, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(lblAchternaam, javax.swing.GroupLayout.Alignment.TRAILING))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txtVoornaam, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(txtHuurderId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(txtAchternaam, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblStad)
                            .addComponent(lblTelefoonnummer))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(txtStad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtTelefoonnummer, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(lblEmailadres)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtEmailadres, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addComponent(btnSearchHuurders)
                .addGap(18, 18, 18)
                .addComponent(lblFoutmelding)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 36, Short.MAX_VALUE)
                .addComponent(lblZoekresultatenList, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnOpenHuurdersEditDialog)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnOpenHuurdersDeleteDialog)
                        .addGap(11, 11, 11)
                        .addComponent(btnOpenHuurdersDetailsDialog)))
                .addGap(18, 18, 18)
                .addComponent(btnCloseThisGUI)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtStadKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtStadKeyReleased
        if(checkIfEmpty(txtStad)) {
            btnSearchHuurders.setEnabled(false);
        } else {
            btnSearchHuurders.setEnabled(true);
        }
    }//GEN-LAST:event_txtStadKeyReleased

    private void txtHuurderIdKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtHuurderIdKeyReleased
        if(checkIfEmpty(txtHuurderId)) {
            btnSearchHuurders.setEnabled(false);
        } else {
            if(CheckUserInput.isStringInteger(txtHuurderId.getText())) {
                btnSearchHuurders.setEnabled(true);
                lblFoutmelding.setText("");
            } else {
                btnSearchHuurders.setEnabled(false);
                lblFoutmelding.setText("Vul a.u.b. een geldig nummer in.");
            }
        }
    }//GEN-LAST:event_txtHuurderIdKeyReleased

    private void txtEmailadresKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtEmailadresKeyReleased
        if(checkIfEmpty(txtEmailadres)) {
            btnSearchHuurders.setEnabled(false);
        } else {
            btnSearchHuurders.setEnabled(true);
        }
    }//GEN-LAST:event_txtEmailadresKeyReleased

    private void txtVoornaamKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtVoornaamKeyReleased
        if(checkIfEmpty(txtVoornaam)) {
            btnSearchHuurders.setEnabled(false);
        } else {
            if(CheckUserInput.isNameValid(txtVoornaam.getText(), lblFoutmelding)) {
                btnSearchHuurders.setEnabled(true);
            } else {
                btnSearchHuurders.setEnabled(false);
            }
        }
    }//GEN-LAST:event_txtVoornaamKeyReleased

    private void txtAchternaamKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtAchternaamKeyReleased
        if(checkIfEmpty(txtAchternaam)) {
            btnSearchHuurders.setEnabled(false);
        } else {
             if(CheckUserInput.isNameValid(txtAchternaam.getText(), lblFoutmelding)) {
                 btnSearchHuurders.setEnabled(true);
             } else {
                 btnSearchHuurders.setEnabled(false);
             }
         }
    }//GEN-LAST:event_txtAchternaamKeyReleased

    private void txtTelefoonnummerKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtTelefoonnummerKeyReleased
        if(checkIfEmpty(txtTelefoonnummer)) {
            btnSearchHuurders.setEnabled(false);
        } else {
            btnSearchHuurders.setEnabled(true);
        }
    }//GEN-LAST:event_txtTelefoonnummerKeyReleased

    private void btnCloseThisGUIActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCloseThisGUIActionPerformed
        this.setVisible(false);
    }//GEN-LAST:event_btnCloseThisGUIActionPerformed

    private void btnOpenHuurdersEditDialogActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnOpenHuurdersEditDialogActionPerformed
        ArrayList <Huurder> huurdersToEdit = new ArrayList <Huurder> (lstZoekresultaten.getSelectedValuesList());
        JFrame frame= (JFrame) SwingUtilities.getWindowAncestor(this);
        HuurdersEditDialog dialog = new HuurdersEditDialog(frame, true);
        dialog.createTextFieldsAndSetHuurders(huurdersToEdit);
        dialog.setLocation(this.getX() + this.getWidth()/2, this.getY() + this.getHeight()/2);
        dialog.showDialog();
        btnSearchHuurdersActionPerformed(evt);
    }//GEN-LAST:event_btnOpenHuurdersEditDialogActionPerformed

    private void btnOpenHuurdersDeleteDialogActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnOpenHuurdersDeleteDialogActionPerformed
        ArrayList <Huurder> huurdersToDelete = new ArrayList <Huurder> (lstZoekresultaten.getSelectedValuesList());
                
        
        ArrayList <Verhuring> existingVerhuringen = new ArrayList <Verhuring>();
        ArrayList <Herstelling> existingHerstellingen = new ArrayList <Herstelling>();
        for(Huurder huurder : huurdersToDelete) {
            for(Verhuring verhuring : VerhuringDao.getVerhuringenByHuurderId(huurder.getHuurderId())) {
                existingVerhuringen.add(verhuring);
            }
            for(Herstelling herstelling : HerstellingDao.getHerstellingenByHuurderId(huurder.getHuurderId())) {
                existingHerstellingen.add(herstelling);
            }
        }
        
        if(existingVerhuringen.size() > 0 || existingHerstellingen.size() > 0) {
            String message = "Onderstaande verhuringen en/of herstellingen zijn teruggevonden op de door u geselecteerde huurders:\n\n";
            for(Verhuring verhuring: existingVerhuringen) {
                message += "Verhuring " + Integer.toString(verhuring.getVerhuringId()) + ": huurder " + Integer.toString(verhuring.getHuurderId()) + ".\n";
            }
            for(Herstelling herstelling: existingHerstellingen) {
                message += "Herstelling " + Integer.toString(herstelling.getHerstellingId()) + ": huurder " + Integer.toString(herstelling.getHuurderId()) + ".\n";
            }
            message += "\nU kunt de geselecteerde huurders pas verwijderen, wanneer deze verhuringen en/of herstellingen verwijderd zijn.\nWenst u deze eerst te verwijderen?";
            Object[] options = {"Nee, verwijder niets.", "Ja, verwijder de verhuringen/herstellingen"};
            int choice = JOptionPane.showOptionDialog(this,
                                                      message,
                                                      "Verhuringen/herstellingen teruggevonden",
                                                      JOptionPane.YES_NO_OPTION,
                                                      JOptionPane.INFORMATION_MESSAGE,
                                                      null,
                                                      options,
                                                      options[0]);
            if (choice == 1) {
                for(Verhuring verhuring: existingVerhuringen) {
                    VerhuringDao.verwijderVerhuring(verhuring.getVerhuringId());
                }
                for(Herstelling herstelling: existingHerstellingen) {
                    DeelherstellingDao.verwijderDeelherstellingenByHerstellingId(herstelling.getHerstellingId());
                    HerstellingDao.verwijderHerstelling(herstelling.getHerstellingId());
                }
                
                JFrame frame= (JFrame) SwingUtilities.getWindowAncestor(this);
                HuurdersDeleteDialog dialog = new HuurdersDeleteDialog(frame, true);
                dialog.createTextFieldsAndSetHuurders(huurdersToDelete);
                dialog.setLocation(this.getX() + this.getWidth()/2, this.getY() + this.getHeight()/2);
                if(dialog.showDialog() == HuurdersDeleteDialog.Resultaat.BEVESTIGD) {
                    for(Huurder huurder: huurdersToDelete) {
                        HuurderDao.verwijderHuurder(huurder.getHuurderId());
                    }
                }
                btnSearchHuurdersActionPerformed(evt);
            }
        } else {
            JFrame frame= (JFrame) SwingUtilities.getWindowAncestor(this);
            HuurdersDeleteDialog dialog = new HuurdersDeleteDialog(frame, true);
            dialog.createTextFieldsAndSetHuurders(huurdersToDelete);
            dialog.setLocation(this.getX() + this.getWidth()/2, this.getY() + this.getHeight()/2);
            if(dialog.showDialog() == HuurdersDeleteDialog.Resultaat.BEVESTIGD) {
                for(Huurder huurder: huurdersToDelete) {
                    HuurderDao.verwijderHuurder(huurder.getHuurderId());
                }
            }
            btnSearchHuurdersActionPerformed(evt);
        }
        
    }//GEN-LAST:event_btnOpenHuurdersDeleteDialogActionPerformed

    private void btnSearchHuurdersActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSearchHuurdersActionPerformed
        huurderModel.clear();
        if(txtHuurderId.isEnabled()) {
            int huurderId = Integer.parseInt(txtHuurderId.getText());
            Huurder gevondenHuurder = HuurderDao.getHuurderById(huurderId);
            huurderModel.addElement(gevondenHuurder);
        }
        
        if(txtVoornaam.isEnabled()) {
            if(txtVoornaam.getText().equals("")) {
                ArrayList<Huurder> gevondenHuurdersLijst = HuurderDao.searchHuurdersByAchternaam(txtAchternaam.getText());
                for(Huurder gevondenHuurder : gevondenHuurdersLijst) {
                    huurderModel.addElement(gevondenHuurder);
                }
            } else if (txtAchternaam.getText().equals("")){
                ArrayList<Huurder> gevondenHuurdersLijst = HuurderDao.searchHuurdersByVoornaam(txtVoornaam.getText());
                for(Huurder gevondenHuurder : gevondenHuurdersLijst) {
                    huurderModel.addElement(gevondenHuurder);
                }
            } else {
                ArrayList<Huurder> gevondenHuurdersLijst = HuurderDao.searchHuurdersByNaam(txtVoornaam.getText(), txtAchternaam.getText());
                for(Huurder gevondenHuurder : gevondenHuurdersLijst) {
                    huurderModel.addElement(gevondenHuurder);
                }
            }
            
        }
        
        if(txtStad.isEnabled()) {
            ArrayList<Huurder> gevondenHuurdersLijst = HuurderDao.searchHuurdersByStad(txtStad.getText());
            for(Huurder gevondenHuurder : gevondenHuurdersLijst) {
                huurderModel.addElement(gevondenHuurder);
            }
        }
        if(txtTelefoonnummer.isEnabled()) {
            ArrayList<Huurder> gevondenHuurdersLijst = HuurderDao.searchHuurdersByTelefoonnummer(txtTelefoonnummer.getText());
            for(Huurder gevondenHuurder : gevondenHuurdersLijst) {
                huurderModel.addElement(gevondenHuurder);
            }
        }
        
        if(txtEmailadres.isEnabled()) {
            ArrayList<Huurder> gevondenHuurdersLijst = HuurderDao.searchHuurdersByEmailadres(txtEmailadres.getText());
            for(Huurder gevondenHuurder : gevondenHuurdersLijst) {
                huurderModel.addElement(gevondenHuurder);
            }
        }
    }//GEN-LAST:event_btnSearchHuurdersActionPerformed

    private void lstZoekresultatenValueChanged(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_lstZoekresultatenValueChanged
        if (lstZoekresultaten.isSelectionEmpty()) {
            btnOpenHuurdersDeleteDialog.setEnabled(false);
            btnOpenHuurdersEditDialog.setEnabled(false);
            btnOpenHuurdersDetailsDialog.setEnabled(false);
        } else {
            btnOpenHuurdersDeleteDialog.setEnabled(true);
            btnOpenHuurdersEditDialog.setEnabled(true);
            btnOpenHuurdersDetailsDialog.setEnabled(true);
        }
    }//GEN-LAST:event_lstZoekresultatenValueChanged

    private void btnOpenHuurdersDetailsDialogActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnOpenHuurdersDetailsDialogActionPerformed
        ArrayList <Huurder> huurdersToShow = new ArrayList <Huurder> (lstZoekresultaten.getSelectedValuesList());
        JFrame frame= (JFrame) SwingUtilities.getWindowAncestor(this);
        HuurdersDetailsDialog dialog = new HuurdersDetailsDialog(frame, true);
        dialog.createTextFieldsAndSetHuurders(huurdersToShow);
        dialog.setLocation(this.getX() + this.getWidth()/2, this.getY() + this.getHeight()/2);
        dialog.showDialog();
    }//GEN-LAST:event_btnOpenHuurdersDetailsDialogActionPerformed

    public void setAllOtherTextFields(boolean status, javax.swing.JTextField textfield1, javax.swing.JTextField textfield2) {
        ArrayList <javax.swing.JTextField> textfields = new ArrayList<>(9);
        textfields.add(txtHuurderId);
        textfields.add(txtVoornaam);
        textfields.add(txtAchternaam);
        textfields.add(txtStad);
        textfields.add(txtTelefoonnummer);
        textfields.add(txtEmailadres);
        for(javax.swing.JTextField currenttextfield : textfields) {
            if(currenttextfield != textfield1 && currenttextfield != textfield2) {
                currenttextfield.setEnabled(status);
            }
        }
    }
    public boolean checkIfEmpty(javax.swing.JTextField currenttextfield) {
        boolean hasTwinTextfield = false;
        boolean noTextInTwintextfield = true;
        javax.swing.JTextField twintextfield = null;
        
        if(currenttextfield == txtVoornaam) {twintextfield = txtAchternaam; hasTwinTextfield = true;}
        if(currenttextfield == txtAchternaam) {twintextfield = txtVoornaam; hasTwinTextfield = true;}
        
        if(hasTwinTextfield) {
            if(!twintextfield.getText().equals("")) {
                noTextInTwintextfield = false;
            }
        }
        
        if(currenttextfield.getText().equals("") && noTextInTwintextfield) {
            setAllOtherTextFields(true, currenttextfield, currenttextfield);
            lblFoutmelding.setText("");
            return true;
        } else {
            if(hasTwinTextfield) {
                setAllOtherTextFields(false, currenttextfield, twintextfield);
            } else {
                setAllOtherTextFields(false, currenttextfield, currenttextfield);
            }
            return false;
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
            java.util.logging.Logger.getLogger(HuurdersSearchDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(HuurdersSearchDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(HuurdersSearchDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(HuurdersSearchDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                HuurdersSearchDialog dialog = new HuurdersSearchDialog(new javax.swing.JFrame(), true);
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
    private javax.swing.JButton btnCloseThisGUI;
    private javax.swing.JButton btnOpenHuurdersDeleteDialog;
    private javax.swing.JButton btnOpenHuurdersDetailsDialog;
    private javax.swing.JButton btnOpenHuurdersEditDialog;
    private javax.swing.JButton btnSearchHuurders;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblAchternaam;
    private javax.swing.JLabel lblEmailadres;
    private javax.swing.JLabel lblFoutmelding;
    private javax.swing.JLabel lblHuurderId;
    private javax.swing.JLabel lblStad;
    private javax.swing.JLabel lblTelefoonnummer;
    private javax.swing.JLabel lblTitel;
    private javax.swing.JLabel lblVoornaam;
    private javax.swing.JLabel lblZoekresultatenList;
    private javax.swing.JList lstZoekresultaten;
    private javax.swing.JTextField txtAchternaam;
    private javax.swing.JTextField txtEmailadres;
    private javax.swing.JTextField txtHuurderId;
    private javax.swing.JTextField txtStad;
    private javax.swing.JTextField txtTelefoonnummer;
    private javax.swing.JTextField txtVoornaam;
    // End of variables declaration//GEN-END:variables
}
