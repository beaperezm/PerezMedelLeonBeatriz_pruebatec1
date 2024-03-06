package proyectoempleado.empleadojpa;


import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import proyectoempleado.empleadojpa.logica.CargoException;
import proyectoempleado.empleadojpa.logica.Controladora;
import proyectoempleado.empleadojpa.logica.Empleado;


public class EmpleadoJPA {

    public static void main(String[] args) throws Exception {
        
        //Conecto el main con la controladora
        Controladora control = new Controladora();
        
        
        List<Empleado> empleados = new ArrayList <Empleado>();
        Empleado nuevoEmpleado = new Empleado();
        Scanner sc = new Scanner(System.in);
        int opcion;
        boolean bandera = false;
        
        
       /*  Creando un bucle do - while - siempre se ejecutará una vez y después continuará ejecutándose 
           mientras el usuario no indique que quiere salir
       */
       
       do {
           
           System.out.println("Menú de opciones");
           System.out.println("1. Insertar Empleado");
           System.out.println("2. Listar Empleados");
           System.out.println("3. Actualizar Empleado"); 
           System.out.println("4. Eliminar Empleado");
           System.out.println("5. Buscar empleado por cargo");
           System.out.println("6. Salir");
           opcion = sc.nextInt();
           
           
           
           /*  En cada caso creo el método pertinente, el cuál se lo paso a la controladora. 
               (Los parámetros pasados son los que se han utilizado en el método creado en la controladora)
           */
           
           switch(opcion) {
           case 1:
                control.crearEmpleado(sc, nuevoEmpleado, empleados);
                break;
            
           case 2:
               System.out.println(control.mostrarEmpleados(empleados));
               break;
               
           case 3:
           
               Empleado empleado = control.traerEmpleadoActualizar(sc);
              
            //Si empleado no está vacío se ejecuta todo lo que está entre los paréntesis
               if(empleado != null){
                   
              
                /* Se ha creado un menú para que el usuario pueda indicar qué dato es el que quiere modificar - cuando ya no quiere modificar más - pondrá 6
                   en la consola y bandera pasará a true - se sale de este bucle pero continúa dentro del menú de opciones. 
                   En este caso se ha creado un bucle while que se ejecutará por primera vez si el empleado no está eliminado.
               */
                
               while (bandera == false && empleado.isBorradoLogico() == false) {
                    System.out.println("¿Qué desea modificar?");
                    System.out.println("1. Nombre");
                    System.out.println("2. Apellido");
                    System.out.println("3. Cargo");
                    System.out.println("4. Salario");
                    System.out.println("5. Fecha de inicio");
                    System.out.println("6. Salir");
                    opcion = sc.nextInt();

                    if(opcion == 1) {
                        control.actualizarNombreEmpleado(empleado, sc);  
                    } 
                    if(opcion == 2) {
                        control.actualizarApellidoEmpleado(empleado, sc);   
                    } 
                    if(opcion == 3) {
                        control.actualizarCargoEmpleado(empleado, sc);
                        
                    }
                    if(opcion == 4) {
                        control.actualizarSalarioEmpleado(empleado, sc);
                        
                    }
                    if(opcion == 5) {
                         control.actualizarFechaInicioEmpleado(empleado, sc);
                    }
                    if(opcion == 6) {
                        System.out.println("Ya no puedes actualizar más datos");
                        bandera = true;
                       
                    }
               } 
          } 
               bandera = false;
               break;
 
           case 4:
               control.eliminarEmpleado(sc);
               break;
               
           case 5:
               
               //Creando una excepción para que si el cargo introducido no existe muestre el mensaje al usuario
               {
                   try {
                       String cargo = "";
                       System.out.println(control.filtrarPorCargo(sc, cargo));
                   } catch (CargoException ex) {
                       System.out.println("**Ese cargo no existe en la base de datos**");
                   }
               }
               
               break;


           case 6:
               bandera = true;
               System.out.println("Hasta pronto");
               break;
               
           default:
               System.out.println("La opción elegida es incorrecta");
               break;
           
          }
           
       } while(opcion != 6 || bandera == false);
               
       
       
    }
}
           
        
   
        
        
    

   

