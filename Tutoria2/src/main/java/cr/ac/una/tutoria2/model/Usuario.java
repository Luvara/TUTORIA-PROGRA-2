package cr.ac.una.tutoria2.model;

import java.time.LocalDate;
import java.time.Period;
import javafx.scene.image.Image;

/**
 *
 * @author USUARIO PZ UNA
 */
public class Usuario {

    private String nombre;
    private String primerApellido;
    private String segundoApellido;
    private String cedula;
    private LocalDate fechaNacimiento;
    private Integer edad;
    private String edadCompleta;
    private Sexo sexo;
    private EnumEstCivil estadoCivil;
    private String usuario;
    private String contrasena;
    private Boolean isAdmin;
    private Image fotoUsuario;

    public Usuario() {
    }

    public Usuario(String nombre, String primerApellido, 
            String segundoApellido, String cedula, 
            LocalDate fechaNacimiento, Sexo sexo, 
            EnumEstCivil estadoCivil, String usuario, 
            String contrasena, Boolean isAdmin, Image fotoUsuario) {
        this.nombre = nombre;
        this.primerApellido = primerApellido;
        this.segundoApellido = segundoApellido;
        this.cedula = cedula;
        this.fechaNacimiento = fechaNacimiento;
        this.sexo = sexo;
        this.estadoCivil = estadoCivil;
        this.usuario = usuario;
        this.contrasena = contrasena;
        this.fotoUsuario = fotoUsuario;
        this.isAdmin = isAdmin;
        calcularEdad();
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getPrimerApellido() {
        return primerApellido;
    }

    public void setPrimerApellido(String primerApellido) {
        this.primerApellido = primerApellido;
    }

    public String getSegundoApellido() {
        return segundoApellido;
    }

    public void setSegundoApellido(String segundoApellido) {
        this.segundoApellido = segundoApellido;
    }

    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public LocalDate getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(LocalDate fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public Sexo getSexo() {
        return sexo;
    }

    public void setSexo(Sexo sexo) {
        this.sexo = sexo;
    }

    public EnumEstCivil getEstadoCivil() {
        return estadoCivil;
    }

    public void setEstadoCivil(EnumEstCivil estadoCivil) {
        this.estadoCivil = estadoCivil;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }

    public Image getFotoUsuario() {
        return fotoUsuario;
    }

    public void setFotoUsuario(Image fotoUsuario) {
        this.fotoUsuario = fotoUsuario;
    }

    public Integer getEdad() {
        return edad;
    }

    public Boolean getIsAdmin() {
        return isAdmin;
    }

    public void setIsAdmin(Boolean isAdmin) {
        this.isAdmin = isAdmin;
    }
    
    

    public String getEdadCompleta() {
        return edadCompleta;
    }

    private void calcularEdad() {
        Period period = Period.between(fechaNacimiento, LocalDate.now());
        
        int anios = period.getYears();
        int meses = period.getMonths();
        int dias = period.getDays();
        
        this.edad = anios;
         this.edadCompleta = anios + " años, " + meses + " meses y " + dias + " días.";
    }
    
    public String getNombreCompleto(){
        return "Nombre: " + nombre + " " + primerApellido + " " + segundoApellido + ".";
    }

    public enum Sexo {
        FEMENINO,
        MASCULINO
    }

    public enum EnumEstCivil {
        SOLTERO,
        CASADO,
        DIVORCIADO,
        VIUDO,
        UNION_LIBRE
    }
}
