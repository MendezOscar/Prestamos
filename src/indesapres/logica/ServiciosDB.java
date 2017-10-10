package indesapres.logica;

import indesapres.modelos.Clientes;
import indesapres.modelos.Deducciones;
import indesapres.modelos.Prestamos;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author oscme
 */
public class ServiciosDB {
    private Connection con = null;
    Statement st;
    String url = "jdbc:oracle:thin:@localhost:1521/xe";
    String username = "indesapres";
    String password = "emanuel17";
    
    public ServiciosDB(){
        try {
            con = DriverManager.getConnection(url, username, password);
        } catch (SQLException se) {
            JOptionPane.showMessageDialog(null, "Error al conectar");
        }
    }
     
    public void createCliente(Clientes clie){
        String query = "INSERT INTO CLIENTES "
                + "(IDCLIENTE, NOMBRE, APELLIDO, IDENTIDAD, DEPARTAMENTO, MUNICIPIO, DIRECCION, ESTADOCIVIL, TELEFONO, GENERO, EDAD, PROFESION) "
                + "VALUES (? , ? , ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        try (PreparedStatement stmt = con.prepareStatement(query)) {
            stmt.setString(1, clie.getIdCliente());
            stmt.setString(2, clie.getNombre());
            stmt.setString(3, clie.getApellido());
            stmt.setString(4, clie.getIdentidad());
            stmt.setString(5, clie.getDepartamento());
            stmt.setString(6, clie.getMunicipio());
            stmt.setString(7, clie.getDireccion());
            stmt.setString(8, clie.getEstadocivil());
            stmt.setString(9, clie.getTelefono());
            stmt.setString(10, clie.getGenero());
            stmt.setInt(11, clie.getEdad());
            stmt.setString(12, clie.getProfesion());
            stmt.executeUpdate();
            JOptionPane.showMessageDialog(null," El Cliente: " + clie.getIdCliente() +" se ha guardado Exitosamente.");
        } catch (SQLException se) {
            JOptionPane.showMessageDialog(null, "Error El Cliente: " + clie.getIdCliente() +" no se ha guardado Exitosamente.");
        }
    }
    
    public void updateCliente(String id, Clientes clie) throws SQLException {
        String query = "UPDATE CLIENTES "
                + "SET NOMBRE= ?, APELLIDO= ?, IDENTIDAD= ?, DEPARTAMENTO= ?, MUNICIPIO= ?, DIRECCION= ?, ESTADOCIVIL= ?, TELEFONO= ?, GENERO= ?, EDAD= ?, PROFESION= ?"
                + "WHERE IDCLIENTE= ?";
        try (PreparedStatement stmt = con.prepareStatement(query)) {
            stmt.setString(1, clie.getNombre());
            stmt.setString(2, clie.getApellido());
            stmt.setString(3, clie.getIdentidad());
            stmt.setString(4, clie.getDepartamento());
            stmt.setString(5, clie.getMunicipio());
            stmt.setString(6, clie.getDireccion());
            stmt.setString(7, clie.getEstadocivil());
            stmt.setString(8, clie.getTelefono());
            stmt.setString(9, clie.getGenero());
            stmt.setInt(10, clie.getEdad());
            stmt.setString(11, clie.getProfesion());
            stmt.setString(12, clie.getIdCliente());
            stmt.executeUpdate();
            JOptionPane.showMessageDialog(null, "El Ciente: " + id + " se ha actualizado correctamente.");
        } catch (SQLException se) {
            System.out.println(se.toString());
            JOptionPane.showMessageDialog(null, "ERROR El Ciente: " + id + " no ha actualizado correctamente.");
        }
    }
    
    public void deleteCliente(String id) throws SQLException {
        Clientes clie = findByIdClientes(id);
        if (clie == null) {
            JOptionPane.showMessageDialog(null, "Codigo de cliente: " + id + " no existe.");
        }
        String query = "DELETE FROM CLIENTES WHERE IDCLIENTE= ?";
        try (PreparedStatement stmt = con.prepareStatement(query)) {  
            stmt.setString(1, id);
            stmt.executeUpdate();
            JOptionPane.showMessageDialog(null, "Codigo de cliente: " + id + "se ha borrado.");
        } catch (SQLException se) {
            JOptionPane.showMessageDialog(null, "ERROR Codigo de cliente: " + id + "no se ha borrado.");
        }
    }

     public Clientes findByIdClientes(String id) throws SQLException {
        String query = "SELECT * FROM CLIENTES WHERE IDCLIENTE = ?";
        try (PreparedStatement stmt = con.prepareStatement(query)) {
            stmt.setString(1, id);
            ResultSet rs = stmt.executeQuery();
            if (!rs.next()) {
                return null;
            }
            return (new Clientes(rs.getString("IDCLIENTE"),rs.getString("NOMBRE"), rs.getString("APELLIDO"), 
                    rs.getString("IDENTIDAD"), rs.getString("DEPARTAMENTO"), rs.getString("MUNICIPIO"),
                    rs.getString("DIRECCION"), rs.getString("ESTADOCIVIL"), rs.getString("TELEFONO"),
                    rs.getString("GENERO"), rs.getInt("EDAD"), rs.getString("PROFESION")));
        } catch (SQLException se) {
            JOptionPane.showMessageDialog(null, "ERROR Codigo de cliente: " + id + "no se ha encontrado.");
        }
        return null;
    }
     
     public List<Clientes> findAllClientes() throws SQLException {
        try (Statement stmt = con.createStatement()) {
            String query = "SELECT * FROM CLIENTES";
            ResultSet rs = stmt.executeQuery(query);
            ArrayList<Clientes> depts = new ArrayList<>();
            while (rs.next()) {
                depts.add(new Clientes(rs.getString("IDCLIENTE"),rs.getString("NOMBRE"), rs.getString("APELLIDO"), 
                    rs.getString("IDENTIDAD"), rs.getString("DEPARTAMENTO"), rs.getString("MUNICIPIO"),
                    rs.getString("DIRECCION"), rs.getString("ESTADOCIVIL"), rs.getString("TELEFONO"),
                    rs.getString("GENERO"), rs.getInt("EDAD"), rs.getString("PROFESION")));
            }
            return depts;
        } catch (SQLException se) {
            JOptionPane.showMessageDialog(null, "ERROR.");
        }
        return null;
    } 
     
     //PRESTAMOS --------------------------------------------------------------------------------------
     
     public void createPrestamos(Prestamos pres){
        String query = "INSERT INTO PRESTAMOS "
                + "(IDPRESTAMO, FECHA, INTERESANUAL, INTERESACUMULADO, PLAZO, TOTALINTERESES, CAPITALINTERES, DEDUCCION, ABONOCAPITAL, INTERESGANADO, IDCLIENTE, PRESTAMO) "
                + "VALUES (? , ? , ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
         System.out.println(query);
        try (PreparedStatement stmt = con.prepareStatement(query)) {
            stmt.setString(1, pres.getIdPrestamo());
            stmt.setString(2, pres.getFecha());
            stmt.setFloat(3, pres.getInteresanual());
            stmt.setFloat(4, pres.getInteresAcumulado());
            stmt.setInt(5, pres.getPlazo());
            stmt.setFloat(6, pres.getTotalinteres());
            stmt.setFloat(7, pres.getCapitalinteres());
            stmt.setFloat(8, pres.getDeduccion());
            stmt.setFloat(9, pres.getAbonocapital());
            stmt.setFloat(10, pres.getInteresganado());
            stmt.setString(11, pres.getIdCliente());
            stmt.setFloat(12, pres.getPrestamos());
            System.out.println(query);
            stmt.executeUpdate();
            JOptionPane.showMessageDialog(null, " El Cliente: " + pres.getIdPrestamo() + " se ha guardado Exitosamente.");
        } catch (SQLException se) {
            JOptionPane.showMessageDialog(null, "Error El Cliente: " + pres.getIdPrestamo() +" no se ha guardado Exitosamente.");
        }
    }
     
    public void updatePrestamo(String id, Prestamos pres) throws SQLException {
        String query = "UPDATE PRESTAMOS "
                + "SET FECHA= ?, INTERESANUAL= ?, INTERESACUMULADO= ?, PLAZO= ?, TOTALINTERESES= ?, CAPITALINTERES= ?, DEDUCCION= ?, ABONOCAPITAL= ?, INTERESGANADO= ?, IDCLIENTE= ?, PRESTAMO= ?"
                + "WHERE IDPRESTAMO= ?";
        try (PreparedStatement stmt = con.prepareStatement(query)) {
            stmt.setString(1, pres.getFecha());
            stmt.setFloat(2, pres.getInteresanual());
            stmt.setFloat(3, pres.getInteresAcumulado());
            stmt.setInt(4, pres.getPlazo());
            stmt.setFloat(5, pres.getTotalinteres());
            stmt.setFloat(6, pres.getCapitalinteres());
            stmt.setFloat(7, pres.getDeduccion());
            stmt.setFloat(8, pres.getAbonocapital());
            stmt.setFloat(9, pres.getInteresganado());
            stmt.setString(10, pres.getIdCliente());
            stmt.setFloat(11, pres.getPrestamos());
            stmt.setString(12, pres.getIdPrestamo());
            stmt.executeUpdate();
            JOptionPane.showMessageDialog(null, "El Prestamo: " + id + " se ha actualizado correctamente.");
        } catch (SQLException se) {
            System.out.println(se.toString());
            JOptionPane.showMessageDialog(null, "ERROR El Prestamo: " + id + " no ha actualizado correctamente.");
        }
    }
    
    public void deletePrestamo(String id) throws SQLException {
        Prestamos pres = findByIdPrestamos(id);
        if (pres == null) {
            JOptionPane.showMessageDialog(null, "Codigo de cliente: " + id + " no existe.");
        }
        String query = "DELETE FROM PRESTAMOS WHERE IDPRESTAMO= ?";
        try (PreparedStatement stmt = con.prepareStatement(query)) {  
            stmt.setString(1, id);
            stmt.executeUpdate();
            JOptionPane.showMessageDialog(null, "Codigo de prestamo: " + id + "se ha borrado.");
        } catch (SQLException se) {
            JOptionPane.showMessageDialog(null, "ERROR Codigo de prestamo: " + id + "no se ha borrado.");
        }
    }

    public Prestamos findByIdPrestamos(String id) {
        String query = "SELECT * FROM PRESTAMOS WHERE IDPRESTAMO = ?";
        try (PreparedStatement stmt = con.prepareStatement(query)) {
            stmt.setString(1, id);
            ResultSet rs = stmt.executeQuery();
            if (!rs.next()) {
                return null;
            }
            return (new Prestamos(rs.getString("IDPRESTAMO"),rs.getString("FECHA"), rs.getFloat("INTERESANUAL"), 
                    rs.getFloat("INTERESACUMULADO"), rs.getInt("PLAZO"), rs.getFloat("TOTALINTERESES"),
                    rs.getFloat("CAPITALINTERES"), rs.getFloat("DEDUCCION"), rs.getFloat("ABONOCAPITAL"),
                    rs.getFloat("INTERESGANADO"), rs.getString("IDCLIENTE"), rs.getFloat("PRESTAMO")));
        } catch (SQLException se) {
            JOptionPane.showMessageDialog(null, "ERROR Codigo de Prestamo: " + id + "no se ha encontrado.");
        }
        return null;
    }
    
    public List<Prestamos> findAllPrestamos() throws SQLException {
        try (Statement stmt = con.createStatement()) {
            String query = "SELECT * FROM PRESTAMOS";
            ResultSet rs = stmt.executeQuery(query);
            ArrayList<Prestamos> depts = new ArrayList<>();
            while (rs.next()) {
                depts.add(new Prestamos(rs.getString("IDPRESTAMO"),rs.getString("FECHA"), rs.getFloat("INTERESANUAL"), 
                    rs.getFloat("INTERESACUMULADO"), rs.getInt("PLAZO"), rs.getFloat("TOTALINTERESES"),
                    rs.getFloat("CAPITALINTERES"), rs.getFloat("DEDUCCION"), rs.getFloat("ABONOCAPITAL"),
                    rs.getFloat("INTERESGANADO"), rs.getString("IDCLIENTE"), rs.getFloat("PRESTAMO")));
            }
            return depts;
        } catch (SQLException se) {
            JOptionPane.showMessageDialog(null, "ERROR.");
        }
        return null;
    } 
    
    // Deducciones ----------------------------------------------------------------------------------
    
    public void createDeduccion(Deducciones ded){
        String query = "INSERT INTO DEDUCCION "
                + "(IDDEDUCCION, FECHA, IDPRESTAMO, SALDO) "
                + "VALUES (? , ? , ?, ?)";
         System.out.println(query);
        try (PreparedStatement stmt = con.prepareStatement(query)) {
            stmt.setString(1, ded.getIdDeduccion());
            stmt.setString(2, ded.getFecha());
            stmt.setString(3, ded.getIdPrestamo());
            stmt.setFloat(4, ded.getSaldo());
            System.out.println(query);
            stmt.executeUpdate();
            JOptionPane.showMessageDialog(null, " La Deduccion: " + ded.getIdDeduccion() + " se ha guardado Exitosamente.");
        } catch (SQLException se) {
            JOptionPane.showMessageDialog(null, "Error La Deduccion: " + ded.getIdDeduccion()  +" no se ha guardado Exitosamente.");
        }
    }
    
     public void updateDeduccion(String id, Deducciones ded) throws SQLException {
        String query = "UPDATE DEDUCCION "
                + "SET FECHA= ?, IDPRESTAMO= ?, SALDO= ?"
                + "WHERE IDDEDUCCION= ?";
        try (PreparedStatement stmt = con.prepareStatement(query)) {
            stmt.setString(1, ded.getFecha());
            stmt.setString(2, ded.getIdPrestamo());
            stmt.setFloat(3, ded.getSaldo());
            stmt.setString(4, ded.getIdDeduccion());
            stmt.executeUpdate();
            JOptionPane.showMessageDialog(null, "La deduccion: " + id + " se ha actualizado correctamente.");
        } catch (SQLException se) {
            System.out.println(se.toString());
            JOptionPane.showMessageDialog(null, "ERROR La deduccion: " + id + " no ha actualizado correctamente.");
        }
    }
    
     public void deleteDeduccion(String id) throws SQLException {
        Deducciones ded = findByIdDeduccion(id);
        if (ded == null) {
            JOptionPane.showMessageDialog(null, "Codigo de Deduccion: " + id + " no existe.");
        }
        String query = "DELETE FROM DEDUCCION WHERE IDDEDUCCION= ?";
        try (PreparedStatement stmt = con.prepareStatement(query)) {  
            stmt.setString(1, id);
            stmt.executeUpdate();
            JOptionPane.showMessageDialog(null, "Deduccion de prestamo: " + id + "se ha borrado.");
        } catch (SQLException se) {
            JOptionPane.showMessageDialog(null, "ERROR Deduccion de prestamo: " + id + "no se ha borrado.");
        }
    }

    public Deducciones findByIdDeduccion(String id) {
        String query = "SELECT * FROM DEDUCCION WHERE IDDEDUCCION = ?";
        try (PreparedStatement stmt = con.prepareStatement(query)) {
            stmt.setString(1, id);
            ResultSet rs = stmt.executeQuery();
            if (!rs.next()) {
                return null;
            }
            return (new Deducciones(rs.getString("IDEDUCCION"),rs.getString("FECHA"), rs.getString("IDPRESTAMO"), 
                    rs.getFloat("SALDO")));
        } catch (SQLException se) {
            JOptionPane.showMessageDialog(null, "ERROR Codigo de Deduccion: " + id + "no se ha encontrado.");
        }
        return null;
    } 
    
    public List<Deducciones> findAllDeducciones() throws SQLException {
        try (Statement stmt = con.createStatement()) {
            String query = "SELECT * FROM DEDUCCION";
            ResultSet rs = stmt.executeQuery(query);
            ArrayList<Deducciones> depts = new ArrayList<>();
            while (rs.next()) {
                depts.add(new Deducciones(rs.getString("IDEDUCCION"),rs.getString("FECHA"), rs.getString("IDPRESTAMO"), 
                    rs.getFloat("SALDO")));
            }
            return depts;
        } catch (SQLException se) {
            JOptionPane.showMessageDialog(null, "ERROR.");
        }
        return null;
    } 
}
