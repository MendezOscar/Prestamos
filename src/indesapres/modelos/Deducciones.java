
package indesapres.modelos;

/**
 *
 * @author oscme
 */
public class Deducciones {
    String idDeduccion;
    String fecha;
    String idPrestamo;
    String Nombre;
    float Prestamo;
    float Deduccion;
    float Saldodeudor;

    public Deducciones(String idDeduccion, String fecha, String idPrestamo, String Nombre, float Prestamo, float Deduccion, float Saldodeudor) {
        this.idDeduccion = idDeduccion;
        this.fecha = fecha;
        this.idPrestamo = idPrestamo;
        this.Nombre = Nombre;
        this.Prestamo = Prestamo;
        this.Deduccion = Deduccion;
        this.Saldodeudor = Saldodeudor;
    }

    public String getNombre() {
        return Nombre;
    }

    public float getPrestamo() {
        return Prestamo;
    }

    public float getDeduccion() {
        return Deduccion;
    }

    public float getSaldoDeudor() {
        return Saldodeudor;
    }

    
    
    public String getIdDeduccion() {
        return idDeduccion;
    }

    public String getFecha() {
        return fecha;
    }

    public String getIdPrestamo() {
        return idPrestamo;
    }

    public void setIdDeduccion(String idDeduccion) {
        this.idDeduccion = idDeduccion;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public void setIdPrestamo(String idPrestamo) {
        this.idPrestamo = idPrestamo;
    }

    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }

    public void setPrestamo(float Prestamo) {
        this.Prestamo = Prestamo;
    }

    public void setDeduccion(float Deduccion) {
        this.Deduccion = Deduccion;
    }

    public void setSaldoDeudor(float Saldoduedor) {
        this.Saldodeudor = Saldodeudor;
    }

    
    
}
