package proyectoempleado.empleadojpa.logica;


//Excepción que hereda de Exception y que ha sido creada para que se muestre cuando el usuario introduce un cargo incorrecto

public class CargoException extends Exception {

    public CargoException() {
    }

    public CargoException(String message) {
        super(message);
    }
    
 
}
