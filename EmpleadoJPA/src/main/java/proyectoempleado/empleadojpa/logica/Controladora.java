package proyectoempleado.empleadojpa.logica;

import java.util.Date;
import java.util.List;
import java.util.Scanner;
import proyectoempleado.empleadojpa.persistencia.ControladoraPersistencia;

public class Controladora {
    
    //Conecto la controladora con la controladora de persistencia
    ControladoraPersistencia controlPersis = new ControladoraPersistencia();

    //Los métodos void no me devuelven nada porque estoy haciendo un procedimiento (simplemente le digo que haga X función)
    
    
    //Con este método creamos empleados - es el usuario quien ingresa los datos por consola
    public void crearEmpleado(Scanner sc, Empleado nuevoEmpleado, List<Empleado> empleados) {
              sc.nextLine();
               System.out.println("Introducir nombre: ");
               String nombre = sc.nextLine();
               System.out.println("Introducir apellido: ");
               String apellido = sc.nextLine(); 
               System.out.println("Introducir cargo: ");
               String cargo = sc.nextLine();
               System.out.println("Introducir salario");
               double salario = sc.nextDouble();
               System.out.println("Introducir año de inicio (yyyy)");
               int anio = sc.nextInt();
               anio -= 1900;
               System.out.println("Introducir mes de inicio (mm)");
               int mes = sc.nextInt();
               mes -= 1;
               System.out.println("Introducir día de inicio (dd)");
               int dia = sc.nextInt();
               Date fechaInicio = new Date(anio, mes, dia);
               
               //Instancio el objeto Empleado con los datos incluídos por el usuario
               nuevoEmpleado = new Empleado(nombre, apellido, cargo, salario, fechaInicio);
               //Añado al ArrayList el objeto instanciado
               empleados.add(nuevoEmpleado);
               
               //Llamo al método crearEmpleado de la controladora de persistencia pasándole el objeto nuevoEmpleado con los datos de éste
               controlPersis.crearEmpleado(nuevoEmpleado);
               
               //Mensaje informativo que se muestra una vez el usuario ha introducido todos los datos
               System.out.println("**Usuario insertado correctamente**");
               
    
    }

    //Dicho método me devuelve la lista de empleados
    public List<Empleado> mostrarEmpleados(List<Empleado> empleados) {
        /* Hago bucle forEach al Array empleados y mediante el método toString creado en la clase Empleado imprimo todos los datos 
           de todos los empleados activos en ese momento
        */
        for(Empleado empleadoBucle : empleados) {
                   empleadoBucle.toString();
               }
       return controlPersis.mostrarEmpleados();
       
    }

  
    
    /* Mediante el id que introduzca el usuario por consola,
       traemos el objeto de dicho Empleado para posteriormente pasar a modificarlo (me devuelve el objeto)
    */
    public Empleado traerEmpleadoActualizar(Scanner sc) {
        System.out.println("Introducir el id de usuario que se quiere actualizar");
        int id = sc.nextInt();
        // Llamo al método traerEmpleadoActualizar creado en la controladora de persistencia - pasándole el id como parámetro 
        return controlPersis.traerEmpleadoActualizar(id);
    }
    
//En los métodos actualizar ->  el try / catch maneja la exception NullPointerException en el caso de que el empleado no exista
    
    public void actualizarNombreEmpleado(Empleado empleado, Scanner sc) {
        sc.nextLine();
        System.out.println("Introducir nuevo nombre: ");
        String nombre = sc.nextLine();
        
        try {
            //Modifico el nombre de manera lógica en el objeto
            empleado.setNombre(nombre);
            //Paso la posición en memoria y la modificación al método (llamando al método de la controladora de persistencia)
            controlPersis.actualizarEmpleado(empleado);
            System.out.println("**Nombre modificado correctamente**");
            
        } catch(NullPointerException n) {
            System.out.println("No se puede cambiar el nombre porque ese empleado no existe");
        }
    }

    public void actualizarApellidoEmpleado(Empleado empleado, Scanner sc) {
        sc.nextLine();
        System.out.println("Introducir nuevo apellido: ");
        String apellido = sc.nextLine();
        
        try {
            empleado.setApellido(apellido);
            controlPersis.actualizarEmpleado(empleado);
            System.out.println("**Apellido modificado correctamente**");
        } catch(NullPointerException n) {
            System.out.println("No se puede cambiar el apellido porque ese empleado no existe");
        }
        
    }

    public void actualizarCargoEmpleado(Empleado empleado, Scanner sc) {
        sc.nextLine();
        System.out.println("Introducir nuevo cargo: ");
        String cargo = sc.nextLine();
        
        try {
            empleado.setCargo(cargo);
            controlPersis.actualizarEmpleado(empleado);
            System.out.println("**Cargo modificado correctamente**");
        } catch(NullPointerException n) {
            System.out.println("No se puede cambiar el cargo porque ese empleado no existe");
        }
        
    }

    public void actualizarSalarioEmpleado(Empleado empleado, Scanner sc) {
        System.out.println("Introducir nuevo salario: ");
        double salario = sc.nextDouble();
        
        try {
            empleado.setSalario(salario);
            controlPersis.actualizarEmpleado(empleado);
            System.out.println("**Salario modificado correctamente**"); 
        } catch(NullPointerException n) {
            System.out.println("No se puede cambiar el salario porque ese empleado no existe");
        }
        
    }

    public void actualizarFechaInicioEmpleado(Empleado empleado, Scanner sc) {
        System.out.println("Introducir año de inicio (yyyy)");
        int anio = sc.nextInt();
        anio -= 1900;
        System.out.println("Introducir mes de inicio (mm)");
        int mes = sc.nextInt();
        mes -= 1;
        System.out.println("Introducir día de inicio (dd)");
        int dia = sc.nextInt();
        Date fechaInicio = new Date(anio, mes, dia);
        
        try {
             empleado.setFechaInicio(fechaInicio);
            controlPersis.actualizarEmpleado(empleado);
            System.out.println("**Fecha de inicio modificada correctamente**");  
        } catch(NullPointerException n) {
            System.out.println("No se puede cambiar la fecha de inicio porque ese empleado no existe");
        }
       
    }
    
      //El usuario nos indica qué empleado quiere eliminar introduciendo el id por consola
    public void eliminarEmpleado(Scanner sc) throws Exception{
        System.out.println("Introducir el id de usuario que se quiere borrar");
        int id = sc.nextInt();
        controlPersis.eliminarEmpleado(id);
       
    }
    
    /* Método filtrarPorCargo(cargo) está creado en el JpaController usando una query - teniendo en cuenta el cargo que introduce el usuario 
       Dicho método me devuelve la lista de empleados
    */
    public List<Empleado> filtrarPorCargo(Scanner sc, String cargo) throws CargoException {
        sc.nextLine();
        System.out.println("Introducir cargo a buscar: ");
        cargo = sc.nextLine();
        if(controlPersis.filtrarPorCargo(cargo).isEmpty()) {
            throw new CargoException ("Ese cargo no existe");
            
        }
         return controlPersis.filtrarPorCargo(cargo);
    }

     
    
}

  