/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Fenetre.Admnistrateur;

import Entity.User;
import Metier.ConnexionBD;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import javax.swing.JOptionPane;

/**
 *
 * @author Gauss
 */
public class ModifUser extends javax.swing.JDialog {

    /**
     * Creates new form ModifUser
     */
    EntityManager em;

    public ModifUser(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();

        try {
            em = new ConnexionBD().getConnexion();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Connexion : " + e.getMessage());
        }

        jLabel3.setVisible(false);
        jLabel4.setVisible(false);
        jLabel5.setVisible(false);
        txtLogin.setVisible(false);
        txtPassword.setVisible(false);
        cbDroit.setVisible(false);
        btModifUser.setEnabled(false);
        btSuppUser.setEnabled(false);
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
        jLabel2 = new javax.swing.JLabel();
        txtMatricule = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txtLogin = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        txtPassword = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        btModifUser = new javax.swing.JButton();
        btAffichageUser = new javax.swing.JButton();
        cbDroit = new javax.swing.JComboBox();
        btSuppUser = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Ridaya Soft : Update User");

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jLabel1.setFont(new java.awt.Font("Segoe UI Light", 0, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 0, 0));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Modification de l'utilisateur");

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 11)); // NOI18N
        jLabel2.setText("Matricule : ");

        txtMatricule.setEditable(false);
        txtMatricule.setFont(new java.awt.Font("Segoe UI", 0, 11)); // NOI18N
        txtMatricule.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtMatriculeActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Segoe UI", 0, 11)); // NOI18N
        jLabel3.setText("Login : ");

        txtLogin.setFont(new java.awt.Font("Segoe UI", 0, 11)); // NOI18N
        txtLogin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtLoginActionPerformed(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Segoe UI", 0, 11)); // NOI18N
        jLabel4.setText("Mot de passe : ");

        txtPassword.setFont(new java.awt.Font("Segoe UI", 0, 11)); // NOI18N
        txtPassword.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtPasswordActionPerformed(evt);
            }
        });
        txtPassword.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtPasswordKeyReleased(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Segoe UI", 0, 11)); // NOI18N
        jLabel5.setText("Droit : ");

        btModifUser.setFont(new java.awt.Font("Segoe UI", 0, 11)); // NOI18N
        btModifUser.setText("Modifier");
        btModifUser.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 207, 255)));
        btModifUser.setContentAreaFilled(false);
        btModifUser.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btModifUserActionPerformed(evt);
            }
        });

        btAffichageUser.setFont(new java.awt.Font("Segoe UI", 0, 11)); // NOI18N
        btAffichageUser.setText("Afficher Info");
        btAffichageUser.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 207, 255)));
        btAffichageUser.setContentAreaFilled(false);
        btAffichageUser.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btAffichageUserActionPerformed(evt);
            }
        });

        cbDroit.setFont(new java.awt.Font("Segoe UI", 0, 11)); // NOI18N
        cbDroit.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Admin", "User only" }));
        cbDroit.setSelectedIndex(-1);

        btSuppUser.setFont(new java.awt.Font("Segoe UI", 0, 11)); // NOI18N
        btSuppUser.setText("Supprimer");
        btSuppUser.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 207, 255)));
        btSuppUser.setContentAreaFilled(false);
        btSuppUser.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btSuppUserActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3)
                            .addComponent(jLabel4)
                            .addComponent(jLabel5))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtPassword, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtLogin, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtMatricule, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cbDroit, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(33, 33, 33)
                        .addComponent(btModifUser, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btSuppUser, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btAffichageUser, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(31, Short.MAX_VALUE))
            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(38, 38, 38)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtMatricule, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtLogin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(txtPassword, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(cbDroit, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 41, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btModifUser, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btAffichageUser, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btSuppUser, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(13, 13, 13))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void txtMatriculeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtMatriculeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtMatriculeActionPerformed

    private void txtLoginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtLoginActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtLoginActionPerformed

    private void txtPasswordActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtPasswordActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtPasswordActionPerformed

    private void txtPasswordKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtPasswordKeyReleased
//        if (!new Metier().isNumeric(evt.getKeyChar())) {
//            txtPassword.setText(txtPassword.getText().replace(String.valueOf(evt.getKeyChar()), ""));
//        }
    }//GEN-LAST:event_txtPasswordKeyReleased

    private void btModifUserActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btModifUserActionPerformed
        try {
            if (!txtLogin.getText().isEmpty() || !txtPassword.getText().isEmpty()) {
                User user = em.find(User.class, Integer.parseInt(txtMatricule.getText().trim()));
                user.setLogin(txtLogin.getText());
                user.setMotDePasse(txtPassword.getText());
                user.setDroit(cbDroit.getSelectedItem().toString());

                EntityTransaction transaction = em.getTransaction();
                transaction.begin();
                em.merge(user);
                transaction.commit();
                JOptionPane.showMessageDialog(null, "La modification de l'utilisateur " + user.getLogin() + " a été effectué avec succès", "Ridaya Soft : User", JOptionPane.PLAIN_MESSAGE);
                this.dispose();
            } else {
                JOptionPane.showMessageDialog(null, "Aucune modication effectuer... Veuillez verifier certains champs vide", "Ridaya Soft : User", JOptionPane.ERROR_MESSAGE);
            }
        } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Aucune modication effectuer... " + e.getMessage(), "Ridaya Soft : User", JOptionPane.ERROR_MESSAGE);
        }


    }//GEN-LAST:event_btModifUserActionPerformed

    private void btAffichageUserActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btAffichageUserActionPerformed
        jLabel3.setVisible(true);
        jLabel4.setVisible(true);
        jLabel5.setVisible(true);
        txtLogin.setVisible(true);
        txtPassword.setVisible(true);
        cbDroit.setVisible(true);
        btModifUser.setEnabled(true);
        btSuppUser.setEnabled(true);
        getInfoUser();
    }//GEN-LAST:event_btAffichageUserActionPerformed
    private void getInfoUser() {
        try {
            Query qr = em.createNamedQuery("User.findByIdUser");
            qr.setParameter("idUser", Integer.parseInt(txtMatricule.getText().trim()));
            List<User> listUser = qr.getResultList();
            User user = listUser.get(0);
            txtLogin.setText(user.getLogin());
            txtPassword.setText(String.valueOf(user.getMotDePasse()));
            if (user.getDroit().equals("Admin")) {
                cbDroit.setSelectedIndex(0);
            } else {
                cbDroit.setSelectedIndex(1);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Info : " + e.getMessage());
        }

    }
    private void btSuppUserActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btSuppUserActionPerformed
        try {
            
                User user = em.find(User.class, Integer.parseInt(txtMatricule.getText().trim()));
                

                EntityTransaction transaction = em.getTransaction();
                transaction.begin();
                em.remove(user);
                transaction.commit();
                JOptionPane.showMessageDialog(null, "La suppression de l'utilisateur " + user.getLogin() + " a été effectué avec succès", "Ridaya Soft : User", JOptionPane.PLAIN_MESSAGE);
                this.dispose();
           
        } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Aucune suppression effectuer... " + e.getMessage(), "Ridaya Soft : User", JOptionPane.ERROR_MESSAGE);
        }       
    }//GEN-LAST:event_btSuppUserActionPerformed

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
            java.util.logging.Logger.getLogger(ModifUser.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ModifUser.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ModifUser.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ModifUser.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                ModifUser dialog = new ModifUser(new javax.swing.JFrame(), true);
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
    private javax.swing.JButton btAffichageUser;
    private javax.swing.JButton btModifUser;
    private javax.swing.JButton btSuppUser;
    private javax.swing.JComboBox cbDroit;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTextField txtLogin;
    public static javax.swing.JTextField txtMatricule;
    private javax.swing.JTextField txtPassword;
    // End of variables declaration//GEN-END:variables
}
