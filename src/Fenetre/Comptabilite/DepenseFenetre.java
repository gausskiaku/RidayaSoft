/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Fenetre.Comptabilite;

import Entity.Depense;
import Entity.User;
import Metier.DepenseMetier;
import Metier.Fichier;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.util.Date;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import ridayasoft.Metier;

/**
 *
 * @author Gauss
 */
public class DepenseFenetre extends javax.swing.JPanel {

    EntityManagerFactory emf;
    EntityManager em;
    Metier metier = new Metier();
    DepenseMetier depenseMetier = new DepenseMetier();
    DefaultTableModel model;
    String dateJour = "";

    public DepenseFenetre() {
        initComponents();
        model = (DefaultTableModel) tbDepense.getModel();
        try {
            emf = Persistence.createEntityManagerFactory("RidayaSoftPU");
            em = emf.createEntityManager();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
        allDepense();
    }

    public void allDepense() {
        try {
            List<Entity.Depense> listDepense = depenseMetier.allDepense(em);

            for (Entity.Depense depense : listDepense) {
                model.insertRow(model.getRowCount(), new Object[]{depense.getIdDepense(), depense.getDateDepense(), depense.getMotif(), depense.getMontant()});
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }

    public void depenseByDate(String date) {
        try {
            String sql = " SELECT * FROM Depense Where dateDepense LIKE '" + date + " %'";
            Query qr = em.createNativeQuery(sql);
            List listDepense = qr.getResultList();

            for (Object depense : listDepense) {
                Object[] depenseTab = (Object[]) depense;
                model.insertRow(model.getRowCount(), new Object[]{depenseTab[0], depenseTab[3], depenseTab[1], depenseTab[2]});
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }

    public void init() {
        txtMontant.setText("");
        txtMotif.setText("");
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
        jPanel2 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        txtMotif = new javax.swing.JTextArea();
        jLabel4 = new javax.swing.JLabel();
        txtMontant = new javax.swing.JTextField();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        btSaveDepense = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbDepense = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        dtDepense = new com.toedter.calendar.JDateChooser();
        btSearch = new javax.swing.JButton();

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jLabel1.setBackground(new java.awt.Color(255, 0, 0));
        jLabel1.setFont(new java.awt.Font("Segoe UI Light", 0, 28)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 0, 0));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Depense");

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setAutoscrolls(true);

        txtMotif.setColumns(20);
        txtMotif.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        txtMotif.setLineWrap(true);
        txtMotif.setRows(5);
        jScrollPane2.setViewportView(txtMotif);

        jLabel4.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        jLabel4.setText("Motif : ");

        txtMontant.setFont(new java.awt.Font("Segoe UI", 0, 11)); // NOI18N
        txtMontant.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtMontantKeyReleased(evt);
            }
        });

        jLabel15.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        jLabel15.setText("Montant : ");

        jLabel16.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        jLabel16.setText("Fc");

        btSaveDepense.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btSaveDepense.setText("Valider la dépense");
        btSaveDepense.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(39, 175, 201), 2));
        btSaveDepense.setContentAreaFilled(false);
        btSaveDepense.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btSaveDepenseMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btSaveDepenseMouseExited(evt);
            }
        });
        btSaveDepense.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btSaveDepenseActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(txtMontant, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel16))
                            .addComponent(jLabel15)))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(36, 36, 36)
                        .addComponent(btSaveDepense, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(167, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addGroup(jPanel2Layout.createSequentialGroup()
                            .addComponent(jLabel15)
                            .addGap(9, 9, 9)
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(txtMontant, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel16))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btSaveDepense, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        tbDepense.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(39, 175, 201)));
        tbDepense.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        tbDepense.setForeground(new java.awt.Color(60, 60, 60));
        tbDepense.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Numéro", "Date", "Motif", "Montant en Fc"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tbDepense.setGridColor(new java.awt.Color(39, 175, 201));
        tbDepense.setInheritsPopupMenu(true);
        jScrollPane1.setViewportView(tbDepense);

        jLabel2.setFont(new java.awt.Font("Segoe UI Light", 0, 13)); // NOI18N
        jLabel2.setText("Jour : ");

        dtDepense.setDateFormatString("yyyy-MM-dd");
        dtDepense.setFont(new java.awt.Font("Segoe UI Light", 0, 12)); // NOI18N
        dtDepense.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                dtDepenseMouseClicked(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                dtDepenseMouseReleased(evt);
            }
        });

        btSearch.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btSearch.setText("Rechercher");
        btSearch.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(39, 175, 201)));
        btSearch.setContentAreaFilled(false);
        btSearch.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btSearchMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btSearchMouseExited(evt);
            }
        });
        btSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btSearchActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 655, Short.MAX_VALUE))
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(dtDepense, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(11, 11, 11))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(jLabel2)
                        .addComponent(dtDepense, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void dtDepenseMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_dtDepenseMouseClicked

    }//GEN-LAST:event_dtDepenseMouseClicked

    private void dtDepenseMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_dtDepenseMouseReleased

    }//GEN-LAST:event_dtDepenseMouseReleased

    private void txtMontantKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtMontantKeyReleased
        if (!metier.isNumeric(evt.getKeyChar())) {
            txtMontant.setText(txtMontant.getText().replace(String.valueOf(evt.getKeyChar()), ""));
        }
    }//GEN-LAST:event_txtMontantKeyReleased

    private void btSaveDepenseMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btSaveDepenseMouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_btSaveDepenseMouseEntered

    private void btSaveDepenseMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btSaveDepenseMouseExited
        // TODO add your handling code here:
    }//GEN-LAST:event_btSaveDepenseMouseExited

    private void btSaveDepenseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btSaveDepenseActionPerformed
        if (txtMotif.getText().length() < 15) {
            JOptionPane.showMessageDialog(null, "Decrivez correctement le motif !!! 15 Caractères au moins...", "Ridaya : Depense", JOptionPane.ERROR_MESSAGE);
        } else if (txtMontant.getText().isEmpty() || txtMontant.getText().length() < 3) {
            JOptionPane.showMessageDialog(null, "Ecrivez un montant existant... Le montant doit etre en Fc !", "Ridaya : Depense", JOptionPane.ERROR_MESSAGE);
        } else {
            try {
                Depense depense = new Depense();
                depense.setDateDepense(Date.from(Instant.now()));
                depense.setMontant(Integer.parseInt(txtMontant.getText()));
                depense.setMotif(txtMotif.getText());

                User user = new User();
                user.setIdUser(Integer.parseInt(new Fichier().lireFichier().trim()));
                depense.setIdUser(user);

                EntityTransaction transaction = em.getTransaction();
                transaction.begin();
                em.persist(depense);
                transaction.commit();
                new Fichier().ecrireFichierLogAccess("Une depense de " + txtMontant.getText() + " à " + Date.from(Instant.now()));
                JOptionPane.showMessageDialog(null, "Depense acceptée et enregistrée avec succès...", "RidayaSoft : Depense", JOptionPane.INFORMATION_MESSAGE);

                init();
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Depense refusée, malheureusement... " + e.getMessage(), "RidayaSoft : Depense", JOptionPane.ERROR_MESSAGE);

            }
        }
        new Metier().supTab(model);
        allDepense();
    }//GEN-LAST:event_btSaveDepenseActionPerformed

    private void btSearchMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btSearchMouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_btSearchMouseEntered

    private void btSearchMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btSearchMouseExited
        // TODO add your handling code here:
    }//GEN-LAST:event_btSearchMouseExited

    private void btSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btSearchActionPerformed
        try {
            if (dtDepense.getDate().toString().isEmpty()) {
                JOptionPane.showMessageDialog(null, "Veillez choisir une date...", "Ridaya Soft : Depense", JOptionPane.ERROR_MESSAGE);
            } else {
                SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
                String date = sdf.format(dtDepense.getDate());
                dateJour = date;

//                JOptionPane.showMessageDialog(null, date);
                new Metier().supTab(model);
                depenseByDate(dateJour);
           
        }
            } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }

    }//GEN-LAST:event_btSearchActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btSaveDepense;
    private javax.swing.JButton btSearch;
    private com.toedter.calendar.JDateChooser dtDepense;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable tbDepense;
    private javax.swing.JTextField txtMontant;
    private javax.swing.JTextArea txtMotif;
    // End of variables declaration//GEN-END:variables
}