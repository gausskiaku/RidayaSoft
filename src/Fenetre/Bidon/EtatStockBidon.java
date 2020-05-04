/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Fenetre.Bidon;

import Metier.Fichier;
import Metier.IReport;
import Metier.StockMetier;
import java.awt.Color;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.util.Date;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import ridayasoft.Metier;

/**
 *
 * @author Gauss
 */
public class EtatStockBidon extends javax.swing.JPanel {

    StockMetier stockMetier = new StockMetier();
    EntityManagerFactory emf;
    EntityManager em;
    DefaultTableModel model;
    Metier metier = new Metier();
    String dateJour = "";

    /**
     * Creates new form EtatStock
     */
    public EtatStockBidon() {
        initComponents();
        model = (DefaultTableModel) tbEtatStock.getModel();
        try {
            emf = Persistence.createEntityManagerFactory("RidayaSoftPU");
            em = emf.createEntityManager();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
        stockActuelBidon();
    }

    public void stockActuelBidon() {
        try {
            List listBidon = stockMetier.stockActuelBidon(em);

            for (Object bidon : listBidon) {
                Object[] bidonTab = (Object[]) bidon;
                model.insertRow(model.getRowCount(), new Object[]{bidonTab[1], bidonTab[2], bidonTab[0]});
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }

    public void stockPrecedent(String date) {
        try {
            List listProduit = stockMetier.stockPrecedent(em, date);
            for (Object produit : listProduit) {
                Object[] produitTab = (Object[]) produit;
                model.insertRow(model.getRowCount(), new Object[]{produitTab[4], produitTab[1], produitTab[0], produitTab[2], produitTab[3]});
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
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
        jLabel2 = new javax.swing.JLabel();
        dtJourStock = new com.toedter.calendar.JDateChooser();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbEtatStock = new javax.swing.JTable();
        btPrintStock = new javax.swing.JButton();
        btSearchStock = new javax.swing.JButton();

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jLabel1.setBackground(new java.awt.Color(255, 0, 0));
        jLabel1.setFont(new java.awt.Font("Segoe UI Light", 0, 28)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 0, 0));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Etat de Stock");

        jLabel2.setFont(new java.awt.Font("Segoe UI Light", 0, 13)); // NOI18N
        jLabel2.setText("Jour : ");

        dtJourStock.setDateFormatString("dd MM yyyy");
        dtJourStock.setFont(new java.awt.Font("Segoe UI Light", 0, 12)); // NOI18N

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setAutoscrolls(true);

        tbEtatStock.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(39, 175, 201)));
        tbEtatStock.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        tbEtatStock.setForeground(new java.awt.Color(60, 60, 60));
        tbEtatStock.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Num Bidon", "Type Bidon", "Quantité disponible"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tbEtatStock.setGridColor(new java.awt.Color(39, 175, 201));
        tbEtatStock.setInheritsPopupMenu(true);
        jScrollPane1.setViewportView(tbEtatStock);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 635, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 195, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        btPrintStock.setFont(new java.awt.Font("Segoe UI", 0, 11)); // NOI18N
        btPrintStock.setForeground(new java.awt.Color(0, 207, 255));
        btPrintStock.setText("Imprimer");
        btPrintStock.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 207, 255), 2));
        btPrintStock.setContentAreaFilled(false);
        btPrintStock.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btPrintStockMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btPrintStockMouseExited(evt);
            }
        });
        btPrintStock.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btPrintStockActionPerformed(evt);
            }
        });

        btSearchStock.setFont(new java.awt.Font("Segoe UI", 0, 11)); // NOI18N
        btSearchStock.setForeground(new java.awt.Color(0, 207, 255));
        btSearchStock.setText("Rechercher");
        btSearchStock.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 207, 255), 2));
        btSearchStock.setContentAreaFilled(false);
        btSearchStock.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btSearchStockMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btSearchStockMouseExited(evt);
            }
        });
        btSearchStock.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btSearchStockActionPerformed(evt);
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
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(dtJourStock, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(189, 189, 189)
                .addComponent(btSearchStock, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(65, 65, 65)
                .addComponent(btPrintStock, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(21, 21, 21)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel2)
                    .addComponent(dtJourStock, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btPrintStock, javax.swing.GroupLayout.DEFAULT_SIZE, 36, Short.MAX_VALUE)
                    .addComponent(btSearchStock, javax.swing.GroupLayout.DEFAULT_SIZE, 36, Short.MAX_VALUE))
                .addGap(19, 19, 19))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 675, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 398, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btPrintStockMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btPrintStockMouseEntered
        btPrintStock.setForeground(Color.red);
    }//GEN-LAST:event_btPrintStockMouseEntered

    private void btPrintStockMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btPrintStockMouseExited
        btPrintStock.setForeground(Color.cyan);
    }//GEN-LAST:event_btPrintStockMouseExited

    private void btPrintStockActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btPrintStockActionPerformed
//         String lienReport = getClass().getResource("/Report/VenteJournaliereReport.jrxml").toString().replace("file:/", "");
        String chemin = getClass().getResource("/Report/EtatStockReport.jrxml").toString().replace("file:/", "");;
        try {
            if (dateJour.isEmpty()) {
                new IReport().reportStatique(chemin);
            } else {
                int printFacture = JOptionPane.showConfirmDialog(null, "Pour le stock actuel, appuyer sur OUI\n"
                        + "Pour celui de la dernière recherche appuyer sur NON", "RidayaSoft : Etat stock", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
                if (printFacture == JOptionPane.YES_OPTION) {
                    new IReport().reportStatique(chemin);
                } else {
                    String sql = "SELECT ( coalesce( ( "
                            + "SELECT SUM( stock.quantite ) "
                            + "FROM stock "
                            + "WHERE produit.idProduit = stock.idProduit ) , 0) - coalesce( ("
                            + "SELECT SUM( commander.quantiteCommande ) "
                            + "FROM commander "
                            + "WHERE commander.idProduit = produit.idProduit "
                            + "AND commander.dateCommande <= '" + dateJour + "' ) , 0 )) AS "
                            + "solde, nomProduit, prixUnitaire, seuil, idProduit "
                            + "FROM produit";

                    new IReport().reportDynamique(chemin, sql);
                    new Fichier().ecrireFichierLogAccess("Impression : Etat stock "+ " à " + Date.from(Instant.now()));
                }

            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }//GEN-LAST:event_btPrintStockActionPerformed

    private void btSearchStockMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btSearchStockMouseEntered
        btSearchStock.setForeground(Color.red);
    }//GEN-LAST:event_btSearchStockMouseEntered

    private void btSearchStockMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btSearchStockMouseExited
        btSearchStock.setForeground(Color.cyan);
    }//GEN-LAST:event_btSearchStockMouseExited

    private void btSearchStockActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btSearchStockActionPerformed
        try {
            if (dtJourStock.getDate().toString().isEmpty()) {
                JOptionPane.showMessageDialog(null, "Pas de date choisi ! ", "RidayaSoft : Etat Stock", JOptionPane.ERROR_MESSAGE);
            } else {
                SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
                String date = sdf.format(dtJourStock.getDate());
                dateJour = date;
                if (model.getRowCount() > 0) {
                    for (int i = model.getRowCount() - 1; i > -1; i--) {
                        model.removeRow(i);
                    }
                }
                stockPrecedent(dateJour);
                  new Fichier().ecrireFichierLogAccess("Recherche etat stock du " + dateJour + " à " + Date.from(Instant.now()));
            }
          
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Date inconnu : Verifie la date de recherche", "RidayaSoft : Etat Stock", JOptionPane.ERROR_MESSAGE);
            stockActuelBidon();
        }
    }//GEN-LAST:event_btSearchStockActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btPrintStock;
    private javax.swing.JButton btSearchStock;
    private com.toedter.calendar.JDateChooser dtJourStock;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tbEtatStock;
    // End of variables declaration//GEN-END:variables
}