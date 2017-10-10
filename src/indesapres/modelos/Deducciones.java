
package indesapres.modelos;

/**
 *
 * @author oscme
 */
public class Deducciones {
    String idDeduccion;
    String fecha;
    String idPrestamo;
    float Saldo;

    public Deducciones(String idDeduccion, String fecha, String idPrestamo, float Saldo) {
        this.idDeduccion = idDeduccion;
        this.fecha = fecha;
        this.idPrestamo = idPrestamo;
        this.Saldo = Saldo;
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

    public float getSaldo() {
        return Saldo;
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

    public void setSaldo(float Saldo) {
        this.Saldo = Saldo;
    }
    
    
}
