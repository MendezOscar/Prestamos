package indesapres.grafico;

import indesapres.logica.ServiciosDB;
import java.awt.event.KeyEvent;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author oscme
 */
public class vistaDeduccion extends javax.swing.JFrame {

    DefaultTableModel modelo = new DefaultTableModel();

    public vistaDeduccion() {
        initComponents();
        mostrarDatos();
    }

    public void mostrarDatos() {
        try {
            generarColumnas();
            ServiciosDB service = new ServiciosDB();
            String query = "SELECT * FROM DEDUCCION";
            Statement st = service.con.createStatement();
            ResultSet rs = st.executeQuery(query);
            this.jTable2.setModel(modelo);
            ResultSetMetaData rsMd = rs.getMetaData();
            int cantidadColumnas = rsMd.getColumnCount();
            while (rs.next()) {
                Object[] fila = new Object[cantidadColumnas];
                for (int i = 0; i < cantidadColumnas; i++) {
                    fila[i] = rs.getObject(i + 1);
                }
                modelo.addRow(fila);
            }

        } catch (SQLException ex) {
            Logger.getLogger(vistaDeduccion.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public void generarColumnas() {
        modelo.addColumn("CODIGO DEDUCCION");
        modelo.addColumn("FECHA");
        modelo.addColumn("CODIGO PRESTAMO");
        modelo.addColumn("SALDO");
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane4 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();
        jToolBar1 = new javax.swing.JToolBar();
        jLabel1 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        jComboBox1 = new javax.swing.JComboBox<>();
        jLabel20 = new javax.swing.JLabel();
        jTextField2 = new javax.swing.JTextField();
        jLabel21 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jLabel22 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Vista de Deducciones");

        jTable2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {}
            },
            new String [] {

            }
        ));
        jTable2.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTable2KeyPressed(evt);
            }
        });
        jScrollPane4.setViewportView(jTable2);

        jToolBar1.setBackground(new java.awt.Color(204, 204, 255));
        jToolBar1.setRollover(true);

        jLabel1.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabel1.setText("Buscar por");
        jToolBar1.add(jLabel1);

        jLabel19.setForeground(new java.awt.Color(204, 204, 255));
        jLabel19.setText("......");
        jToolBar1.add(jLabel19);

        jComboBox1.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Codigo deduccion", "Codigo de prestamo", "Fecha" }));
        jToolBar1.add(jComboBox1);

        jLabel20.setForeground(new java.awt.Color(204, 204, 255));
        jLabel20.setText(".....");
        jToolBar1.add(jLabel20);

        jTextField2.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jToolBar1.add(jTextField2);

        jLabel21.setForeground(new java.awt.Color(204, 204, 255));
        jLabel21.setText("......");
        jToolBar1.add(jLabel21);

        jButton1.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jButton1.setText("Buscar");
        jButton1.setFocusable(false);
        jButton1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton1.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jToolBar1.add(jButton1);

        jLabel22.setForeground(new java.awt.Color(204, 204, 255));
        jLabel22.setText("................................................................................");
        jToolBar1.add(jLabel22);

        jLabel18.setForeground(new java.awt.Color(204, 204, 255));
        jToolBar1.add(jLabel18);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 869, Short.MAX_VALUE)
                .addContainerGap())
            .addComponent(jToolBar1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jToolBar1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 243, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(18, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jTable2KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTable2KeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTable2KeyPressed

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
            java.util.logging.Logger.getLogger(vistaDeduccion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(vistaDeduccion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(vistaDeduccion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(vistaDeduccion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            new vistaDeduccion().setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JTable jTable2;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JToolBar jToolBar1;
    // End of variables declaration//GEN-END:variables
}
