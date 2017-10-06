package indesapres.modelos;

/**
 *
 * @author oscme
 */
public class Clientes {
    private String idCliente;
    private String Nombre;
    private String Apellido;
    private String Identidad;
    private String Departamento;
    private String Municipio;
    private String Direccion;
    private String Estadocivil;
    private String Telefono;
    private String Genero;
    private int Edad;
    private String Profesion;

    public Clientes(String idCliente, String Nombre, String Apellido, String Identidad, String Departamento, String Municipio, String Direccion, String Estadocivil, String Telefono, String Genero, int Edad, String Profesion) {
        this.idCliente = idCliente;
        this.Nombre = Nombre;
        this.Apellido = Apellido;
        this.Identidad = Identidad;
        this.Departamento = Departamento;
        this.Municipio = Municipio;
        this.Direccion = Direccion;
        this.Estadocivil = Estadocivil;
        this.Telefono = Telefono;
        this.Genero = Genero;
        this.Edad = Edad;
        this.Profesion = Profesion;
    }

    public String getIdCliente() {
        return idCliente;
    }

    public String getNombre() {
        return Nombre;
    }

    public String getApellido() {
        return Apellido;
    }

    public String getIdentidad() {
        return Identidad;
    }

    public String getDepartamento() {
        return Departamento;
    }

    public String getMunicipio() {
        return Municipio;
    }

    public String getDireccion() {
        return Direccion;
    }

    public String getEstadocivil() {
        return Estadocivil;
    }

    public String getTelefono() {
        return Telefono;
    }

    public String getGenero() {
        return Genero;
    }

    public int getEdad() {
        return Edad;
    }

    public String getProfesion() {
        return Profesion;
    }

    public void setIdCliente(String idCliente) {
        this.idCliente = idCliente;
    }

    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }

    public void setApellido(String Apellido) {
        this.Apellido = Apellido;
    }

    public void setIdentidad(String Identidad) {
        this.Identidad = Identidad;
    }

    public void setDepartamento(String Departamento) {
        this.Departamento = Departamento;
    }

    public void setMunicipio(String Municipio) {
        this.Municipio = Municipio;
    }

    public void setDireccion(String Direccion) {
        this.Direccion = Direccion;
    }

    public void setEstadocivil(String Estadocivil) {
        this.Estadocivil = Estadocivil;
    }

    public void setTelefono(String Telefono) {
        this.Telefono = Telefono;
    }

    public void setGenero(String Genero) {
        this.Genero = Genero;
    }

    public void setEdad(int Edad) {
        this.Edad = Edad;
    }

    public void setProfesion(String Profesion) {
        this.Profesion = Profesion;
    }
    
    
}
