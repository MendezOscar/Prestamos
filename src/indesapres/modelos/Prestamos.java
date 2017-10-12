
package indesapres.modelos;

/**
 *
 * @author oscme
 */
public class Prestamos {

    String idPrestamo;
    String Fecha;
    String idCliente;
    String Nombre;
    float Prestamos;
    float Plazo;
    float Interesanual;
    float InteresAcumulado;
    float Totalinteres;
    float Capitalinteres;
    float Deduccion;
    float Abonocapital;
    float Interesganado;
    float Saldo;

    public Prestamos(String idPrestamo, String Fecha, String idCliente, String Nombre, float Prestamos, float Plazo, float Interesanual, float InteresAcumulado, float Totalinteres, float Capitalinteres, float Deduccion, float Abonocapital, float Interesganado, float Saldo) {
        this.idPrestamo = idPrestamo;
        this.Fecha = Fecha;
        this.idCliente = idCliente;
        this.Nombre = Nombre;
        this.Prestamos = Prestamos;
        this.Plazo = Plazo;
        this.Interesanual = Interesanual;
        this.InteresAcumulado = InteresAcumulado;
        this.Totalinteres = Totalinteres;
        this.Capitalinteres = Capitalinteres;
        this.Deduccion = Deduccion;
        this.Abonocapital = Abonocapital;
        this.Interesganado = Interesganado;
        this.Saldo = Saldo;
    }

    public String getNombre() {
        return Nombre;
    }

    public float getSaldo() {
        return Saldo;
    }

    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }

    public void setSaldo(float Saldo) {
        this.Saldo = Saldo;
    }
    
    public float getPrestamos() {
        return Prestamos;
    }

    public void setPrestamos(float Prestamos) {
        this.Prestamos = Prestamos;
    }

    public String getIdPrestamo() {
        return idPrestamo;
    }

    public String getFecha() {
        return Fecha;
    }

    public float getInteresanual() {
        return Interesanual;
    }

    public float getInteresAcumulado() {
        return InteresAcumulado;
    }

    public float getPlazo() {
        return Plazo;
    }

    public float getTotalinteres() {
        return Totalinteres;
    }

    public float getCapitalinteres() {
        return Capitalinteres;
    }

    public float getDeduccion() {
        return Deduccion;
    }

    public float getAbonocapital() {
        return Abonocapital;
    }

    public float getInteresganado() {
        return Interesganado;
    }

    public String getIdCliente() {
        return idCliente;
    }

    public void setIdPrestamo(String idPrestamo) {
        this.idPrestamo = idPrestamo;
    }

    public void setFecha(String Fecha) {
        this.Fecha = Fecha;
    }

    public void setInteresanual(float Interesanual) {
        this.Interesanual = Interesanual;
    }

    public void setInteresAcumulado(float InteresAcumulado) {
        this.InteresAcumulado = InteresAcumulado;
    }

    public void setPlazo(float Plazo) {
        this.Plazo = Plazo;
    }

    public void setTotalinteres(float Totalinteres) {
        this.Totalinteres = Totalinteres;
    }

    public void setCapitalinteres(float Capitalinteres) {
        this.Capitalinteres = Capitalinteres;
    }

    public void setDeduccion(float Deduccion) {
        this.Deduccion = Deduccion;
    }

    public void setAbonocapital(float Abonocapital) {
        this.Abonocapital = Abonocapital;
    }

    public void setInteresganado(float Interesganado) {
        this.Interesganado = Interesganado;
    }

    public void setIdCliente(String idCliente) {
        this.idCliente = idCliente;
    }
    
    
}
