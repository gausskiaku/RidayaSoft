/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Fenetre.Bidon;

import Entity.Bidon;
import Entity.Stock;
import Metier.Fichier;
import java.awt.Color;
import java.time.Instant;
import java.util.Date;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.swing.JOptionPane;
import ridayasoft.Metier;

/**
 *
 * @author Gauss
 */
public class StockBidonForm extends javax.swing.JPanel {

    /**
     * Creates new form GestionUserForm
     */
    EntityManagerFactory emf;
    EntityManager em;
    Metier metier = new Metier();
    Bidon idBidon;

    public StockBidonForm() {
        initComponents();
        try {
            emf = Persistence.createEntityManagerFactory("RidayaSoftPU");
            em = emf.createEntityManager();
            cbBidon();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }

    public void cbBidon() {
        Query qrBidon = em.createNamedQuery("Bidon.findAll");
        List<Bidon> listBidon = qrBidon.getResultList();
        cboTypeBidon.removeAllItems();

        for (Bidon bidon : listBidon) {
            cboTypeBidon.addItem(bidon.getTypeBidon());
        }
        cboTypeBidon.setSelectedIndex(-1);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanel6 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        btStockSave = new javax.swing.JButton();
        txtStockQuantite = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        txtStockPrixAchat = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        cboTypeBidon = new javax.swing.JComboBox();
        btStockReset = new javax.swing.JButton();

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jLabel1.setBackground(new java.awt.Color(255, 255, 255));
        jLabel1.setFont(new java.awt.Font("Segoe UI Light", 0, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 0, 0));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Création : Stock Bidon");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel6.setBackground(new java.awt.Color(255, 255, 255));

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 11)); // NOI18N
        jLabel2.setText("Enregistrement : Stock");

        jLabel3.setFont(new java.awt.Font("Segoe UI", 0, 11)); // NOI18N
        jLabel3.setText("Type Bidon");

        btStockSave.setFont(new java.awt.Font("Segoe UI", 1, 11)); // NOI18N
        btStockSave.setForeground(new java.awt.Color(0, 207, 255));
        btStockSave.setText("Valider");
        btStockSave.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 207, 255)));
        btStockSave.setContentAreaFilled(false);
        btStockSave.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btStockSaveMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btStockSaveMouseExited(evt);
            }
        });
        btStockSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btStockSaveActionPerformed(evt);
            }
        });

        txtStockQuantite.setFont(new java.awt.Font("Segoe UI", 0, 11)); // NOI18N
        txtStockQuantite.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtStockQuantiteActionPerformed(evt);
            }
        });
        txtStockQuantite.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtStockQuantiteKeyReleased(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Segoe UI", 0, 11)); // NOI18N
        jLabel4.setText("Quatinté : ");

        txtStockPrixAchat.setFont(new java.awt.Font("Segoe UI", 0, 11)); // NOI18N
        txtStockPrixAchat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtStockPrixAchatActionPerformed(evt);
            }
        });
        txtStockPrixAchat.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtStockPrixAchatKeyReleased(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Segoe UI", 0, 11)); // NOI18N
        jLabel6.setText("Prix d'achat : ");

        cboTypeBidon.setFont(new java.awt.Font("Segoe UI", 0, 11)); // NOI18N
        cboTypeBidon.addPopupMenuListener(new javax.swing.event.PopupMenuListener() {
            public void popupMenuCanceled(javax.swing.event.PopupMenuEvent evt) {
            }
            public void popupMenuWillBecomeInvisible(javax.swing.event.PopupMenuEvent evt) {
                cboTypeBidonPopupMenuWillBecomeInvisible(evt);
            }
            public void popupMenuWillBecomeVisible(javax.swing.event.PopupMenuEvent evt) {
            }
        });

        btStockReset.setFont(new java.awt.Font("Segoe UI", 1, 11)); // NOI18N
        btStockReset.setForeground(new java.awt.Color(0, 207, 255));
        btStockReset.setText("Reinitialiser");
        btStockReset.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 207, 255)));
        btStockReset.setContentAreaFilled(false);
        btStockReset.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btStockResetMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btStockResetMouseExited(evt);
            }
        });
        btStockReset.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btStockResetActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel2))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(187, 187, 187)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(btStockSave, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(47, 47, 47)
                                .addComponent(btStockReset, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addGroup(jPanel3Layout.createSequentialGroup()
                                    .addComponent(jLabel6)
                                    .addGap(32, 32, 32)
                                    .addComponent(txtStockPrixAchat, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(jPanel3Layout.createSequentialGroup()
                                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel4)
                                        .addComponent(jLabel3))
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(txtStockQuantite, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(cboTypeBidon, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)))))))
                .addContainerGap(237, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2)
                .addGap(25, 25, 25)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(cboTypeBidon, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(txtStockQuantite, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(txtStockPrixAchat, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(37, 37, 37)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btStockSave, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btStockReset, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(41, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(51, 51, 51)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(58, Short.MAX_VALUE))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btStockSaveMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btStockSaveMouseEntered
        btStockSave.setForeground(Color.red);
    }//GEN-LAST:event_btStockSaveMouseEntered

    private void btStockSaveMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btStockSaveMouseExited
        btStockSave.setForeground(btStockReset.getForeground());
    }//GEN-LAST:event_btStockSaveMouseExited

    private void btStockSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btStockSaveActionPerformed
        if (cboTypeBidon.getSelectedIndex() == -1 || txtStockQuantite.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Veuillez remplir les champs vide !", "Ridaya Soft : Stock", JOptionPane.ERROR_MESSAGE);
        } else {
            Stock stock = new Stock();

            stock.setIdBidon(idBidon);
            stock.setDateStock(Date.from(Instant.now()));
            try {
              stock.setPrixAchat(Double.parseDouble(txtStockPrixAchat.getText()));  
            } catch (Exception e) {
                stock.setPrixAchat(0.0);
            }
            stock.setQuantite(Integer.parseInt(txtStockQuantite.getText()));

            EntityTransaction transaction = em.getTransaction();
            transaction.begin();
            em.persist(stock);
            transaction.commit();
            JOptionPane.showMessageDialog(null, "Bidon ajouté avec succes !", "Ridaya Soft : Bidon", JOptionPane.INFORMATION_MESSAGE);
            new Fichier().ecrireFichierLogAccess("Ajout dans le stock du bidon " + cboTypeBidon.getSelectedItem() + ", quantité : " + txtStockQuantite.getText() + " à " + Date.from(Instant.now()));
            init();
        }
    }//GEN-LAST:event_btStockSaveActionPerformed

    private void txtStockQuantiteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtStockQuantiteActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtStockQuantiteActionPerformed

    private void txtStockQuantiteKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtStockQuantiteKeyReleased
        if (!metier.isNumeric(evt.getKeyChar())) {
            txtStockQuantite.setText(txtStockQuantite.getText().replace(String.valueOf(evt.getKeyChar()), ""));
        }
    }//GEN-LAST:event_txtStockQuantiteKeyReleased

    private void txtStockPrixAchatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtStockPrixAchatActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtStockPrixAchatActionPerformed

    private void txtStockPrixAchatKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtStockPrixAchatKeyReleased
        if (!metier.isNumeric(evt.getKeyChar())) {
            txtStockPrixAchat.setText(txtStockPrixAchat.getText().replace(String.valueOf(evt.getKeyChar()), ""));
        }
    }//GEN-LAST:event_txtStockPrixAchatKeyReleased

    private void cboTypeBidonPopupMenuWillBecomeInvisible(javax.swing.event.PopupMenuEvent evt) {//GEN-FIRST:event_cboTypeBidonPopupMenuWillBecomeInvisible
        try {
            Query qrBidon = em.createNamedQuery("Bidon.findByTypeBidon");
            qrBidon.setParameter("typeBidon", cboTypeBidon.getSelectedItem());
            List<Bidon> listBidon = qrBidon.getResultList();
            Bidon lastBidon = listBidon.get(listBidon.size() - 1); // Last Id
            idBidon = lastBidon;
        } catch (Exception e) {
        }
    }//GEN-LAST:event_cboTypeBidonPopupMenuWillBecomeInvisible

    private void btStockResetMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btStockResetMouseEntered
        btStockReset.setForeground(Color.red);
    }//GEN-LAST:event_btStockResetMouseEntered

    private void btStockResetMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btStockResetMouseExited
        btStockReset.setForeground(btStockSave.getForeground());
    }//GEN-LAST:event_btStockResetMouseExited

    private void btStockResetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btStockResetActionPerformed
        init();
    }//GEN-LAST:event_btStockResetActionPerformed
    public void init() {
        cboTypeBidon.setSelectedIndex(-1);
        txtStockPrixAchat.setText("");
        txtStockQuantite.setText("");
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btStockReset;
    private javax.swing.JButton btStockSave;
    private javax.swing.JComboBox cboTypeBidon;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JTextField txtStockPrixAchat;
    private javax.swing.JTextField txtStockQuantite;
    // End of variables declaration//GEN-END:variables
}
