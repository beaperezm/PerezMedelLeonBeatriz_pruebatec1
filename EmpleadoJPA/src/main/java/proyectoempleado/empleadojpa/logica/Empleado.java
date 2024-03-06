package proyectoempleado.empleadojpa.logica;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;


//En esta clase se han creado los atributos, los contructores, los getters y setters y el método toString()


//Se han añadido varias Annotations

//Indicando cuál es la entidad
@Entity
@Table(name = "empleado")
public class Empleado implements Serializable {
    
    //Indicando la Primary Key  - generada de manera automática
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    
    //Poniendo el nombre que quiero que tengan las columnas
    @Column(name="Nombre")
    private String nombre;
    
    @Column(name="Apellido")
    private String apellido;
    
    @Column(name="Cargo")
    private String cargo;
    
    @Column(name="Salario")
    private double salario;
    
    @Temporal(TemporalType.DATE)
    @Column(name="Fecha_de_inicio")
    private Date fechaInicio;
    
    @Column(name="Borrado_logico")
    private boolean borradoLogico;
    

    public Empleado() {
    }

    public Empleado(int id, String nombre, String apellido, String cargo, double salario, Date fechaInicio) {
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.cargo = cargo;
        this.salario = salario;
        this.fechaInicio = fechaInicio;
        this.borradoLogico = false; 
    }

    public Empleado(String nombre, String apellido, String cargo, double salario, Date fechaInicio) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.cargo = cargo;
        this.salario = salario;
        this.fechaInicio = fechaInicio;
        //Cuando agrego a un empleado el borrado de inicio es false
        this.borradoLogico = false;
        
    }
    

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    public double getSalario() {
        return salario;
    }

    public void setSalario(double salario) {
        this.salario = salario;
    }

    public Date getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(Date fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public boolean isBorradoLogico() {
        return borradoLogico;
    }

    public void setBorradoLogico(boolean borradoLogico) {
        this.borradoLogico = borradoLogico;
    }
    
    

    @Override
    public String toString() {
        return "\nEmpleado: " + '{'+ "id=" + id + ", nombre=" + nombre + ", apellido=" + apellido + ", cargo=" + cargo + ", salario=" + salario + ", fechaInicio=" + fechaInicio + '}';
    }
    
    
    
   
    
}
