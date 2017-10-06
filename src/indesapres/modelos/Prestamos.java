
package indesapres.modelos;

/**
 *
 * @author oscme
 */
public class Prestamos {
    String idPrestamo;
    String Fecha;
    float Interesanual;
    float InteresAcumulado;
    int Plazo;
    float Totalinteres;
    float Capitalinteres;
    float Deduccion;
    float Abonocapital;
    float Interesganado;
    String idCliente;

    public Prestamos(String idPrestamo, String Fecha, float Interesanual, float InteresAcumulado, int Plazo, float Totalinteres, float Capitalinteres, float Deduccion, float Abonocapital, float Interesganado, String idCliente) {
        this.idPrestamo = idPrestamo;
        this.Fecha = Fecha;
        this.Interesanual = Interesanual;
        this.InteresAcumulado = InteresAcumulado;
        this.Plazo = Plazo;
        this.Totalinteres = Totalinteres;
        this.Capitalinteres = Capitalinteres;
        this.Deduccion = Deduccion;
        this.Abonocapital = Abonocapital;
        this.Interesganado = Interesganado;
        this.idCliente = idCliente;
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

    public int getPlazo() {
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

    public void setPlazo(int Plazo) {
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
