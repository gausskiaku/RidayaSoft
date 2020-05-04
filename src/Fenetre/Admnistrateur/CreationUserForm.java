/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Fenetre.Admnistrateur;

import Entity.User;
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

/**
 *
 * @author Gauss
 */
public class CreationUserForm extends javax.swing.JPanel {

    /**
     * Creates new form GestionUserForm
     */
    EntityManagerFactory emf;
    EntityManager em;

    public CreationUserForm() {
        initComponents();
        try {
            emf = Persistence.createEntityManagerFactory("RidayaSoftPU");
            em = emf.createEntityManager();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
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
        jPanel7 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        btUserSave = new javax.swing.JButton();
        txtUserLogin = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        cboUserDroit = new javax.swing.JComboBox();
        btUserReset = new javax.swing.JButton();
        txtUserMotdePasse = new javax.swing.JPasswordField();
        txtUserMotdePasseConfirmation = new javax.swing.JPasswordField();

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jLabel1.setBackground(new java.awt.Color(255, 255, 255));
        jLabel1.setFont(new java.awt.Font("Segoe UI Light", 0, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 0, 0));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Création : Utilisateur");

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

        jPanel7.setBackground(new java.awt.Color(255, 255, 255));

        jLabel6.setText("Enregistrement :User");

        jLabel7.setText("Droit :");

        btUserSave.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btUserSave.setForeground(new java.awt.Color(0, 207, 255));
        btUserSave.setText("Valider");
        btUserSave.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 207, 255)));
        btUserSave.setContentAreaFilled(false);
        btUserSave.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btUserSaveMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btUserSaveMouseExited(evt);
            }
        });
        btUserSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btUserSaveActionPerformed(evt);
            }
        });

        txtUserLogin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtUserLoginActionPerformed(evt);
            }
        });

        jLabel8.setText("Login :");

        jLabel9.setText("Mot de passe : ");

        jLabel10.setText("Confirmation mot de passe :");

        cboUserDroit.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Admin", "User only" }));
        cboUserDroit.setSelectedIndex(-1);
        cboUserDroit.addPopupMenuListener(new javax.swing.event.PopupMenuListener() {
            public void popupMenuCanceled(javax.swing.event.PopupMenuEvent evt) {
            }
            public void popupMenuWillBecomeInvisible(javax.swing.event.PopupMenuEvent evt) {
                cboUserDroitPopupMenuWillBecomeInvisible(evt);
            }
            public void popupMenuWillBecomeVisible(javax.swing.event.PopupMenuEvent evt) {
            }
        });

        btUserReset.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btUserReset.setForeground(new java.awt.Color(0, 207, 255));
        btUserReset.setText("Reinitialiser");
        btUserReset.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 207, 255)));
        btUserReset.setContentAreaFilled(false);
        btUserReset.setPreferredSize(new java.awt.Dimension(57, 35));
        btUserReset.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btUserResetMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btUserResetMouseExited(evt);
            }
        });
        btUserReset.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btUserResetActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btUserSave, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(46, 46, 46)
                        .addComponent(btUserReset, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(23, 23, 23))
                    .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel7Layout.createSequentialGroup()
                            .addContainerGap()
                            .addComponent(jLabel6))
                        .addGroup(jPanel7Layout.createSequentialGroup()
                            .addGap(187, 187, 187)
                            .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel8)
                                .addComponent(jLabel7)
                                .addComponent(jLabel9)
                                .addComponent(jLabel10))
                            .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(jPanel7Layout.createSequentialGroup()
                                    .addGap(28, 28, 28)
                                    .addComponent(txtUserMotdePasseConfirmation, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel7Layout.createSequentialGroup()
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(txtUserLogin, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(cboUserDroit, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel7Layout.createSequentialGroup()
                            .addContainerGap()
                            .addComponent(txtUserMotdePasse, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(222, Short.MAX_VALUE))
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel6)
                .addGap(12, 12, 12)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(cboUserDroit, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(txtUserLogin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(txtUserMotdePasse, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(txtUserMotdePasseConfirmation, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(33, 33, 33)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btUserSave, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btUserReset, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(36, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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

    private void btUserSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btUserSaveActionPerformed
       
       
        if (cboUserDroit.getSelectedIndex() == -1 || txtUserLogin.getText().length() < 3 || txtUserMotdePasse.getText().length() < 1) {
            JOptionPane.showMessageDialog(null, "Veuillez remplir les champs vide !", "Ridaya Soft : User", JOptionPane.ERROR_MESSAGE);
        } else {
            if (txtUserMotdePasse.getText().length() <= 5) {
                JOptionPane.showMessageDialog(null, "Le mot de passe doit contenir au moins 6 caractères", "Ridaya Soft : User", JOptionPane.ERROR_MESSAGE);

            } else if (!txtUserMotdePasse.getText().equals(txtUserMotdePasseConfirmation.getText())) {
                JOptionPane.showMessageDialog(null, "Le deux mot de passe sont differents. Recommencer!", "Ridaya Soft : User", JOptionPane.ERROR_MESSAGE);
            } else {
               
//                Query qrUser = em.createNamedQuery("User.findAll");
//       List<User> listUser = qrUser.getResultList();
//                for (User user : listUser) {
//                   if( listUser.getLogin().equals(txtUserLogin.getText()))
//                }
                try {
                    
               
                User user = new User();
                user.setDroit(cboUserDroit.getSelectedItem().toString());
                user.setLogin(txtUserLogin.getText());
                user.setMotDePasse(txtUserMotdePasse.getText());

                EntityTransaction transaction = em.getTransaction();
                transaction.begin();
                em.persist(user);
                transaction.commit();
                JOptionPane.showMessageDialog(null, "Utilisateur ajouter avec succes !", "Ridaya Soft : User", JOptionPane.INFORMATION_MESSAGE);
                  new Fichier().ecrireFichierLogAccess("Creation de l'utilisateur " + txtUserLogin.getText() + " à " + Date.from(Instant.now()));
                init();
                 } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Cet utilisateur existe déjà dans le système!", "Ridaya Soft : User", JOptionPane.ERROR_MESSAGE);
  
                }

            }

        }
    }//GEN-LAST:event_btUserSaveActionPerformed

    private void txtUserLoginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtUserLoginActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtUserLoginActionPerformed
    public void init() {
        cboUserDroit.setSelectedIndex(-1);
        txtUserLogin.setText("");
        txtUserMotdePasse.setText("");
        txtUserMotdePasseConfirmation.setText("");
    }
    private void cboUserDroitPopupMenuWillBecomeInvisible(javax.swing.event.PopupMenuEvent evt) {//GEN-FIRST:event_cboUserDroitPopupMenuWillBecomeInvisible

    }//GEN-LAST:event_cboUserDroitPopupMenuWillBecomeInvisible

    private void btUserResetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btUserResetActionPerformed
        init();
    }//GEN-LAST:event_btUserResetActionPerformed

    private void btUserSaveMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btUserSaveMouseEntered
        btUserSave.setForeground(Color.red);
    }//GEN-LAST:event_btUserSaveMouseEntered

    private void btUserSaveMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btUserSaveMouseExited
        btUserSave.setForeground(btUserReset.getForeground());
    }//GEN-LAST:event_btUserSaveMouseExited

    private void btUserResetMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btUserResetMouseEntered
        btUserReset.setForeground(Color.red);
    }//GEN-LAST:event_btUserResetMouseEntered

    private void btUserResetMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btUserResetMouseExited
        btUserReset.setForeground(btUserSave.getForeground());
    }//GEN-LAST:event_btUserResetMouseExited


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btUserReset;
    private javax.swing.JButton btUserSave;
    private javax.swing.JComboBox cboUserDroit;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JTextField txtUserLogin;
    private javax.swing.JPasswordField txtUserMotdePasse;
    private javax.swing.JPasswordField txtUserMotdePasseConfirmation;
    // End of variables declaration//GEN-END:variables
}
