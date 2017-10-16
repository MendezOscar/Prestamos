package indesapres.grafico;

import indesapres.logica.ServiciosDB;
import indesapres.modelos.Clientes;
import indesapres.modelos.Prestamos;
import java.awt.event.KeyEvent;
import java.math.BigDecimal;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author oscme
 */
public class registrarPrestamo extends javax.swing.JFrame {

    public DefaultTableModel tm;
    Date fechaActual;
    
    public registrarPrestamo() {
        initComponents();
        setearFecha();
    }

    public void setearFecha() {
        fechaActual = new Date();
        jDate.setText(new SimpleDateFormat("dd/MM/yyyy").format(fechaActual));
    }

    public Prestamos enviarDatos() {
        Prestamos pres;
        String idPrestamo = jCodigo.getText();
        String fecha = jDate.getText();
        String idCliente = jCodigo1.getText();
        String Nombre = jCodigo2.getText();
        float prestamo = Float.parseFloat(jPrestamo.getText());
        float porInteresanual = Float.parseFloat(jporAnual.getText());
        float porInteresAcumulado = Float.parseFloat(String.valueOf(tm.getValueAt(0, 0)));
        int plazo = Integer.parseInt(jPlazo.getText());
        float totalIntereses = Float.parseFloat(String.valueOf(tm.getValueAt(0, 1)));
        float capitalInteres = Float.parseFloat(String.valueOf(tm.getValueAt(0, 2)));
        float deduccion = Float.parseFloat(String.valueOf(tm.getValueAt(0, 3)));
        float abonocapital = Float.parseFloat(String.valueOf(tm.getValueAt(0, 4)));
        float interesGanado = Float.parseFloat(String.valueOf(tm.getValueAt(0, 5)));
        float saldo = Float.parseFloat(String.valueOf(tm.getValueAt(0, 6)));
        pres = new Prestamos(idPrestamo, fecha, idCliente, Nombre, prestamo, plazo, porInteresanual, porInteresAcumulado, totalIntereses, capitalInteres, deduccion, abonocapital, interesGanado, saldo);
        return pres;
    }

    public void limpiar() {
        jCodigo.setText("");
        jCodigo1.setText("");
        jDate.setText("");
        jCodigo2.setText("");
        jPrestamo.setText("");
        jPlazo.setText("");
        jporAnual.setText("");
        jTable2.setValueAt(0.0, 0, 0);
        jTable2.setValueAt(0.0, 0, 1);
        jTable2.setValueAt(0.0, 0, 2);
        jTable2.setValueAt(0.0, 0, 3);
        jTable2.setValueAt(0.0, 0, 4);
        jTable2.setValueAt(0.0, 0, 5);
        jTable2.setValueAt(0.0, 0, 6);
    }

    public void setearBusqueda(Prestamos pres) {
        this.tm = (DefaultTableModel) jTable2.getModel();
        jCodigo.setText(pres.getIdPrestamo());
        jCodigo1.setText(pres.getIdCliente());
        jDate.setText(pres.getFecha());
        jPrestamo.setText(Float.toString(pres.getPrestamos()));
        jPlazo.setText(Float.toString(pres.getPlazo()));
        jporAnual.setText(Float.toString(pres.getInteresanual()));
        jTable2.setValueAt(pres.getInteresAcumulado(), 0, 0);
        jTable2.setValueAt(pres.getTotalinteres(), 0, 1);
        jTable2.setValueAt(pres.getCapitalinteres(), 0, 2);
        jTable2.setValueAt(pres.getDeduccion(), 0, 3);
        jTable2.setValueAt(pres.getAbonocapital(), 0, 4);
        jTable2.setValueAt(pres.getInteresganado(), 0, 5);
        jTable2.setValueAt(pres.getSaldo(), 0, 6);
        buscarCliente();
    }

    public void buscarCliente() {
        String id = jCodigo1.getText();
        if ("".equals(id)) {
            JOptionPane.showMessageDialog(null, "No hay codigo de cliente ingresado");
        } else {
            try {
                Clientes clie;
                ServiciosDB service = new ServiciosDB();
                clie = service.findByIdClientes(id);
                if (clie != null) {
                    setearCliente(clie);
                } else {
                    JOptionPane.showMessageDialog(null, "El Cliente: " + id + " no existe");
                }

            } catch (SQLException ex) {
                Logger.getLogger(registrarCliente.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    public void setearCliente(Clientes clie) {
        jCodigo2.setText(clie.getNombre() + " " + clie.getApellido());
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jToolBar1 = new javax.swing.JToolBar();
        jLabel19 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        jLabel25 = new javax.swing.JLabel();
        jLabel26 = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jLabel14 = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        jLabel15 = new javax.swing.JLabel();
        jButton3 = new javax.swing.JButton();
        jLabel16 = new javax.swing.JLabel();
        jButton4 = new javax.swing.JButton();
        jLabel17 = new javax.swing.JLabel();
        jButton5 = new javax.swing.JButton();
        jLabel18 = new javax.swing.JLabel();
        jButton6 = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jCodigo = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jCodigo1 = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jCodigo2 = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();
        jLabel6 = new javax.swing.JLabel();
        jPrestamo = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jPlazo = new javax.swing.JTextField();
        jButton7 = new javax.swing.JButton();
        jDate = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jporAnual = new javax.swing.JTextField();
        jButton8 = new javax.swing.JButton();

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Registrar Prestamo");

        jToolBar1.setBackground(new java.awt.Color(204, 204, 255));
        jToolBar1.setRollover(true);

        jLabel19.setForeground(new java.awt.Color(204, 204, 255));
        jLabel19.setText("......");
        jToolBar1.add(jLabel19);

        jLabel20.setForeground(new java.awt.Color(204, 204, 255));
        jLabel20.setText("......");
        jToolBar1.add(jLabel20);

        jLabel21.setForeground(new java.awt.Color(204, 204, 255));
        jLabel21.setText("......");
        jToolBar1.add(jLabel21);

        jLabel22.setForeground(new java.awt.Color(204, 204, 255));
        jLabel22.setText("......");
        jToolBar1.add(jLabel22);

        jLabel25.setForeground(new java.awt.Color(204, 204, 255));
        jLabel25.setText("..............");
        jToolBar1.add(jLabel25);

        jLabel26.setForeground(new java.awt.Color(204, 204, 255));
        jLabel26.setText("......");
        jToolBar1.add(jLabel26);

        jLabel23.setForeground(new java.awt.Color(204, 204, 255));
        jLabel23.setText(".............");
        jToolBar1.add(jLabel23);

        jLabel24.setForeground(new java.awt.Color(204, 204, 255));
        jLabel24.setText("......");
        jToolBar1.add(jLabel24);

        jButton1.setFont(new java.awt.Font("Times New Roman", 0, 12)); // NOI18N
        jButton1.setIcon(new javax.swing.ImageIcon("C:\\Users\\oscme\\OneDrive\\Documents\\NetBeansProjects\\Prestamos\\pictures\\save.png")); // NOI18N
        jButton1.setText("Guardar");
        jButton1.setToolTipText("");
        jButton1.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jButton1.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jButton1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton1.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jToolBar1.add(jButton1);

        jLabel14.setForeground(new java.awt.Color(204, 204, 255));
        jLabel14.setText(".......");
        jToolBar1.add(jLabel14);

        jButton2.setFont(new java.awt.Font("Times New Roman", 0, 12)); // NOI18N
        jButton2.setIcon(new javax.swing.ImageIcon("C:\\Users\\oscme\\OneDrive\\Documents\\NetBeansProjects\\Prestamos\\pictures\\editar.png")); // NOI18N
        jButton2.setText("Modificar");
        jButton2.setToolTipText("");
        jButton2.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jButton2.setFocusable(false);
        jButton2.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jButton2.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton2.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jToolBar1.add(jButton2);

        jLabel15.setForeground(new java.awt.Color(204, 204, 255));
        jLabel15.setText(".......");
        jToolBar1.add(jLabel15);

        jButton3.setFont(new java.awt.Font("Times New Roman", 0, 12)); // NOI18N
        jButton3.setIcon(new javax.swing.ImageIcon("C:\\Users\\oscme\\OneDrive\\Documents\\NetBeansProjects\\Prestamos\\pictures\\eliminar.png")); // NOI18N
        jButton3.setText("Eliminar");
        jButton3.setToolTipText("");
        jButton3.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jButton3.setFocusable(false);
        jButton3.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jButton3.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton3.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        jToolBar1.add(jButton3);

        jLabel16.setForeground(new java.awt.Color(204, 204, 255));
        jLabel16.setText(".......");
        jToolBar1.add(jLabel16);

        jButton4.setFont(new java.awt.Font("Times New Roman", 0, 12)); // NOI18N
        jButton4.setIcon(new javax.swing.ImageIcon("C:\\Users\\oscme\\OneDrive\\Documents\\NetBeansProjects\\Prestamos\\pictures\\nwe.png")); // NOI18N
        jButton4.setText("Limpiar");
        jButton4.setToolTipText("");
        jButton4.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jButton4.setFocusable(false);
        jButton4.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jButton4.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton4.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });
        jToolBar1.add(jButton4);

        jLabel17.setForeground(new java.awt.Color(204, 204, 255));
        jLabel17.setText(".......");
        jToolBar1.add(jLabel17);

        jButton5.setFont(new java.awt.Font("Times New Roman", 0, 12)); // NOI18N
        jButton5.setIcon(new javax.swing.ImageIcon("C:\\Users\\oscme\\OneDrive\\Documents\\NetBeansProjects\\Prestamos\\pictures\\buscar.png")); // NOI18N
        jButton5.setText("Buscar");
        jButton5.setToolTipText("");
        jButton5.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jButton5.setFocusable(false);
        jButton5.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jButton5.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton5.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });
        jToolBar1.add(jButton5);

        jLabel18.setForeground(new java.awt.Color(204, 204, 255));
        jLabel18.setText(".......");
        jToolBar1.add(jLabel18);

        jButton6.setFont(new java.awt.Font("Times New Roman", 0, 12)); // NOI18N
        jButton6.setIcon(new javax.swing.ImageIcon("C:\\Users\\oscme\\OneDrive\\Documents\\NetBeansProjects\\Prestamos\\pictures\\kista.png")); // NOI18N
        jButton6.setText("reporte");
        jButton6.setToolTipText("");
        jButton6.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jButton6.setFocusable(false);
        jButton6.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jButton6.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton6.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });
        jToolBar1.add(jButton6);

        jLabel2.setIcon(new javax.swing.ImageIcon("C:\\Users\\oscme\\OneDrive\\Documents\\NetBeansProjects\\Prestamos\\pictures\\PrestamoGrande.png")); // NOI18N

        jLabel1.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabel1.setText("CODIGO DEL PRESTAMO");

        jCodigo.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jCodigo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCodigoActionPerformed(evt);
            }
        });
        jCodigo.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jCodigoKeyPressed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabel3.setText("FECHA");

        jLabel4.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabel4.setText("CODIGO CLIENTE");

        jCodigo1.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jCodigo1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCodigo1ActionPerformed(evt);
            }
        });
        jCodigo1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jCodigo1KeyPressed(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabel5.setText("NOMBRE CLIENTE");

        jCodigo2.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jCodigo2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCodigo2ActionPerformed(evt);
            }
        });

        jTable2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "% Interes Acum.", "Total Interes Ganado", "Capital + Interes", "Deduccion", "Abono a Capital", "Interes Ganado", "Saldo"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Float.class, java.lang.Float.class, java.lang.Float.class, java.lang.Float.class, java.lang.Float.class, java.lang.Float.class, java.lang.Float.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jTable2.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTable2KeyPressed(evt);
            }
        });
        jScrollPane2.setViewportView(jTable2);

        jLabel6.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabel6.setText("PRESTAMO");

        jPrestamo.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jPrestamo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jPrestamoActionPerformed(evt);
            }
        });

        jLabel7.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabel7.setText("PLAZO");

        jPlazo.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jPlazo.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jPlazoMouseClicked(evt);
            }
        });
        jPlazo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jPlazoActionPerformed(evt);
            }
        });

        jButton7.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jButton7.setText("Calcular");
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });

        jDate.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jDate.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jDateMouseClicked(evt);
            }
        });
        jDate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jDateActionPerformed(evt);
            }
        });

        jLabel8.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabel8.setText("% INTERES ANUAL");

        jporAnual.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jporAnual.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jporAnualMouseClicked(evt);
            }
        });
        jporAnual.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jporAnualActionPerformed(evt);
            }
        });

        jButton8.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jButton8.setText("Buscar");
        jButton8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton8ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jToolBar1, javax.swing.GroupLayout.DEFAULT_SIZE, 1052, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel4)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jCodigo1, javax.swing.GroupLayout.DEFAULT_SIZE, 238, Short.MAX_VALUE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jButton8)
                                .addGap(47, 47, 47)
                                .addComponent(jLabel3)
                                .addGap(18, 18, 18)
                                .addComponent(jDate, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(237, 237, 237))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel5)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jCodigo2, javax.swing.GroupLayout.DEFAULT_SIZE, 605, Short.MAX_VALUE)
                                .addGap(172, 172, 172))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane2)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel6)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jPrestamo, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabel7)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jPlazo, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabel8)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jporAnual, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(37, 37, 37)
                                .addComponent(jButton7)))
                        .addContainerGap())))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jToolBar1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(37, 37, 37)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(jDate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4)
                            .addComponent(jCodigo1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton8))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(jCodigo2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(jCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(jPrestamo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7)
                    .addComponent(jPlazo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton7)
                    .addComponent(jLabel8)
                    .addComponent(jporAnual, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(16, 16, 16)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 161, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        String id = jCodigo.getText();
        if ("".equals(jCodigo.getText())) {
            JOptionPane.showMessageDialog(null, "Ingrese codigo");
        } else {
            ServiciosDB service = new ServiciosDB();
            if (service.findByIdPrestamos(id) == null) {
                Prestamos pres;
                pres = enviarDatos();
                service.createPrestamos(pres);
            } else {
                JOptionPane.showMessageDialog(null, "EL Prestamo: " + id + " ya existe");
            }
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        String id = jCodigo.getText();
        if ("".equals(jCodigo.getText())) {
            JOptionPane.showMessageDialog(null, "Ingrese codigo");
        } else {
            try {
                Prestamos pres;
                pres = enviarDatos();
                ServiciosDB service = new ServiciosDB();
                service.updatePrestamo(id, pres);
            } catch (SQLException ex) {
                Logger.getLogger(registrarCliente.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
        try {
            String id = jCodigo.getText();
            ServiciosDB service = new ServiciosDB();
            service.deletePrestamo(id);
            limpiar();
        } catch (SQLException ex) {
            Logger.getLogger(registrarCliente.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        // TODO add your handling code here:
        limpiar();
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        // TODO add your handling code here:
        String id = jCodigo.getText();
        if ("".equals(id)) {
            JOptionPane.showMessageDialog(null, "Ingrese codigo");
        } else {
            Prestamos pres;
            ServiciosDB service = new ServiciosDB();
            pres = service.findByIdPrestamos(id);
            if (pres != null) {
                setearBusqueda(pres);
            } else {
                JOptionPane.showMessageDialog(null, "El Prestamo: " + id + " no existe");
            }
        }
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton6ActionPerformed

    private void jCodigoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCodigoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jCodigoActionPerformed

    private void jCodigo1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCodigo1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jCodigo1ActionPerformed

    private void jCodigo2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCodigo2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jCodigo2ActionPerformed

    private void jTable2KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTable2KeyPressed
        // TODO add your handling code here:

    }//GEN-LAST:event_jTable2KeyPressed

    private void jPrestamoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jPrestamoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jPrestamoActionPerformed

    private void jPlazoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jPlazoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jPlazoActionPerformed

    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed
        // TODO add your handling code here:
        this.tm = (DefaultTableModel) jTable2.getModel();
        float interesAnual = Float.parseFloat(jporAnual.getText());
        float prestamo = Float.parseFloat(jPrestamo.getText());
        float plazo = Float.parseFloat(jPlazo.getText());
        if (prestamo == 0.0) {
            JOptionPane.showMessageDialog(null, "Introduzca la cantidad del prestamo");
        }
        if (plazo == 0) {
            JOptionPane.showMessageDialog(null, "Introduzca el plazo del prestamo");
        } else {
            if (plazo <= 12) {
                float Totalinteresganado = (float) (prestamo * interesAnual);
                float Capitalinteres = prestamo + Totalinteresganado;
                float deduccion = Capitalinteres / (plazo * 2);
                float abonocapital = prestamo / (plazo * 2);
                float interesganado = Totalinteresganado / (plazo * 2);
                jTable2.setValueAt(0.0, 0, 0);
                jTable2.setValueAt(Totalinteresganado, 0, 1);
                jTable2.setValueAt(Capitalinteres, 0, 2);
                jTable2.setValueAt(deduccion, 0, 3);
                jTable2.setValueAt(abonocapital, 0, 4);
                jTable2.setValueAt(interesganado, 0, 5);
                jTable2.setValueAt(prestamo, 0, 6);
            } else {
               float interesAcumulado;
                float base = (float) 1200;
                float porcentaje = obtenerInteres(interesAnual);
                interesAcumulado = (prestamo * porcentaje * plazo) / base;
                System.out.println("interesAcumulado: " + interesAcumulado);
                float Totalinteresganado = interesAcumulado;
                float capitalInteres = prestamo + Totalinteresganado;
                float deduccion = capitalInteres / (plazo * 2);
                float abonoCapital = prestamo / (plazo * 2);
                double interesganado = Totalinteresganado / (plazo * 2);
                jTable2.setValueAt(0.0, 0, 0);
                jTable2.setValueAt(Totalinteresganado, 0, 1);
                jTable2.setValueAt(capitalInteres, 0, 2);
                jTable2.setValueAt(deduccion, 0, 3);
                jTable2.setValueAt(abonoCapital, 0, 4);
                jTable2.setValueAt(interesganado, 0, 5);
            }
        }
    }//GEN-LAST:event_jButton7ActionPerformed

    private void jDateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jDateActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jDateActionPerformed

    private void jPlazoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPlazoMouseClicked
        // TODO add your handling code here:
        float prestamo = Float.parseFloat(jPrestamo.getText());
        if (prestamo >= 1000 && prestamo <= 5000) {
            int plazo = 5;
            jPlazo.setText(Integer.toString(plazo));
        } else if (prestamo >= 5001 && prestamo <= 20000) {
            int plazo = 15;
            jPlazo.setText(Integer.toString(plazo));
        } else if (prestamo >= 20001 && prestamo <= 50000) {
            int plazo = 22;
            jPlazo.setText(Integer.toString(plazo));
        } else if (prestamo >= 50001 && prestamo <= 80000) {
            int plazo = 24;
            jPlazo.setText(Integer.toString(plazo));
        } else if (prestamo >= 80001 && prestamo <= 100000) {
            int plazo = 26;
            jPlazo.setText(Integer.toString(plazo));
        }else if (prestamo >= 100001 && prestamo <= 150000) {
            int plazo = 36;
            jPlazo.setText(Integer.toString(plazo));
        }  
        else if (prestamo <= 150001) {
            JOptionPane.showMessageDialog(null, "Sujeto a analisis");
        }
    }//GEN-LAST:event_jPlazoMouseClicked

    private void jporAnualMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jporAnualMouseClicked
        // TODO add your handling code here:
       int plazo = Integer.parseInt(jPlazo.getText());
        float prestamo = Float.parseFloat(jPrestamo.getText());
        if (plazo == 5) {
            float interesanual = (float) 0.18;
            jporAnual.setText(Float.toString(interesanual));
        }else if (plazo == 15) {
            float interesanual = (float) 0.20;
            jporAnual.setText(Float.toString(interesanual));
        }else if (plazo == 22) {
            float interesanual = (float) 0.22;
            jporAnual.setText(Float.toString(interesanual));
        }else if (plazo == 24 && (prestamo >= 50001 && prestamo <= 80000)) {
            float interesanual = (float) 0.23;
            jporAnual.setText(Float.toString(interesanual));
        }else if (plazo == 26 && (prestamo >= 80001 && prestamo <= 100000)) {
            float interesanual = (float) 0.25;
            jporAnual.setText(Float.toString(interesanual));
        }else if (plazo == 36 && (prestamo >= 100001 && prestamo <= 150000)) {
            float interesanual = (float) 0.255;
            jporAnual.setText(Float.toString(interesanual));
        }else {
            JOptionPane.showMessageDialog(null, "Sujeto a analisis");
        }
    }//GEN-LAST:event_jporAnualMouseClicked

    private void jporAnualActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jporAnualActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jporAnualActionPerformed

    private void jCodigoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jCodigoKeyPressed
        // TODO add your handling code here:
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            String id = jCodigo.getText();
            if ("".equals(id)) {
                JOptionPane.showMessageDialog(null, "Ingrese codigo");
            } else {
                Prestamos pres;
                ServiciosDB service = new ServiciosDB();
                pres = service.findByIdPrestamos(id);
                if (pres != null) {
                    setearBusqueda(pres);
                } else {
                    JOptionPane.showMessageDialog(null, "El Prestamo: " + id + " no existe");
                }
            }
        }
    }//GEN-LAST:event_jCodigoKeyPressed

    private void jDateMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jDateMouseClicked
        // TODO add your handling code here:
        setearFecha();
    }//GEN-LAST:event_jDateMouseClicked

    private void jCodigo1KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jCodigo1KeyPressed
        // TODO add your handling code here:
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            buscarCliente();
            generarCodigo();
        }
    }//GEN-LAST:event_jCodigo1KeyPressed

    private void jButton8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton8ActionPerformed
        // TODO add your handling code here
        vistaClientes vc = new vistaClientes();
        vc.setVisible(true);
    }//GEN-LAST:event_jButton8ActionPerformed

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
            java.util.logging.Logger.getLogger(registrarPrestamo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(registrarPrestamo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(registrarPrestamo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(registrarPrestamo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            new registrarPrestamo().setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7;
    private javax.swing.JButton jButton8;
    private javax.swing.JTextField jCodigo;
    public static javax.swing.JTextField jCodigo1;
    private javax.swing.JTextField jCodigo2;
    private javax.swing.JTextField jDate;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JTextField jPlazo;
    private javax.swing.JTextField jPrestamo;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable1;
    private javax.swing.JTable jTable2;
    private javax.swing.JToolBar jToolBar1;
    private javax.swing.JTextField jporAnual;
    // End of variables declaration//GEN-END:variables

    public int obtenermes(String dfanio) {
        int mes;
        float anio = Float.parseFloat(dfanio);
        String montoEnLetras = Float.toString(anio);
        String[] nums = montoEnLetras.split("\\.");
        String montoEnLetrasDecimal = nums[1];
        mes = Integer.parseInt(montoEnLetrasDecimal);
        Math.round(mes);
        switch (mes) {
            case 1:
                mes = 2;
                return mes;
            case 2:
                mes = 3;
                return mes;
            case 3:
                mes = 4;
                return mes;
            case 4:
                mes = 5;
                return mes;
            case 5:
                mes = 6;
                return mes;
            case 6:
                mes = 7;
                return mes;
            case 8:
                mes = 9;
                return mes;
            case 9:
                mes = 10;
                return mes;
            case 0:
                mes = 1;
                return mes;
            default:
                break;
        }
        return mes;
    }

    public int obtenerInteres(float year) {
        String montoEnLetras = Float.toString(year);
        String[] nums = montoEnLetras.split("\\.");
        String montoEnLetrasDecimal = nums[1];
        int newInteres = Integer.parseInt(montoEnLetrasDecimal);
        System.out.println("newInteres: " + newInteres);
        return newInteres;
    }

    public float convertirInteres(String interes) {
        float cinteres = Float.parseFloat(interes);
        BigDecimal number = new BigDecimal(interes);
        int iPart = number.intValue();
        BigDecimal fraccion = number.remainder(BigDecimal.ONE);
        System.out.println("interes: " + interes);
        System.out.println("number: " + number);
        System.out.println("iPart: " + iPart);
        if (isFloat(cinteres)) {
            String montoEnLetras = fraccion.toString();
            System.out.println("montoEnLetras: " + montoEnLetras);
            String[] nums = montoEnLetras.split("\\.");
            String montoEnLetrasDecimal = nums[1];
            System.out.println("montoEnLetrasDecimal: "+ montoEnLetrasDecimal);
            int newFrac = Integer.parseInt(montoEnLetrasDecimal);
            String interesletras = "0." + iPart + newFrac;
            cinteres = Float.parseFloat(interesletras);
            return cinteres;
        } else {
            String interesletras = "0." + iPart + fraccion;
            cinteres = Float.parseFloat(interesletras);
            return cinteres;
        }
    }

    public boolean isFloat(float n) {
        return n % 1 != 0;
    }
    
    public void generarCodigo() {
        String idCliente = jCodigo1.getText();
        int cont = 1;
        String idPrestamo = idCliente + "-" + cont;
        cont++;
        jCodigo.setText(idPrestamo);
    }
}
