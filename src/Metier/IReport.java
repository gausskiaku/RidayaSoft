/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Metier;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.logging.Level;
import java.util.logging.Logger;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.design.JRDesignQuery;
import net.sf.jasperreports.engine.design.JasperDesign;
import net.sf.jasperreports.engine.xml.JRXmlLoader;
import net.sf.jasperreports.view.JasperViewer;

/**
 *
 * @author Gauss
 */
public class IReport {
     Connection conn;
    
    public void reportStatique(String chemin) {
        try {
            JasperReport jr = JasperCompileManager.compileReport(chemin);
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/ridayaBd", "root", "");
            JasperPrint jp = JasperFillManager.fillReport(jr, null, conn);
            JasperViewer.viewReport(jp);
        } catch (Exception ex) {
            Logger.getLogger(FactureMetier.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void reportDynamique(String chemin, String sql) {
        try {
            JasperDesign jd = JRXmlLoader.load(chemin);
        JRDesignQuery newQuery = new JRDesignQuery();
        newQuery.setText(sql);
        jd.setQuery(newQuery);
        JasperReport jr = JasperCompileManager.compileReport(jd);
        conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/ridayaBd", "root", "");
        JasperPrint jp = JasperFillManager.fillReport(jr, null, conn);
            JasperViewer.viewReport(jp);
        } catch (Exception e) {
        }
    }
}
