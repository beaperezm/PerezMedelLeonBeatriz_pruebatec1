package proyectoempleado.empleadojpa.persistencia;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import proyectoempleado.empleadojpa.logica.Empleado;
import proyectoempleado.empleadojpa.persistencia.exceptions.NonexistentEntityException;

public class ControladoraPersistencia {
    
    //Conecto la controladora de persistencia con el jpaController
    EmpleadoJpaController empleadoJpa = new EmpleadoJpaController();


    public void crearEmpleado(Empleado nuevoEmpleado) {
        empleadoJpa.create(nuevoEmpleado);
    }

    public List<Empleado> mostrarEmpleados() {
      // Traigo a los empleados
      List<Empleado> listadoEmpleados = new ArrayList();
      for(Empleado empleadoBucle: empleadoJpa.findEmpleadoEntities()) {
          //Si el empleado no está borrado lo añade a la lista
          if(!empleadoBucle.isBorradoLogico()) {
              listadoEmpleados.add(empleadoBucle);
          }
      }
      //retorno la lista de los empleados
      return listadoEmpleados; 
   
    }

    //
    public Empleado traerEmpleadoActualizar(int id) {
        try {
            //Traigo el empleado indicado con el id
            Empleado traerEmpleado = empleadoJpa.findEmpleado(id);
            //Si el empleado está eliminado indica que no existe sino retorna el objeto (con el return)
            if(traerEmpleado.isBorradoLogico() == true) {
                System.out.println("Ese empleado no existe ");
            }
            //Si no existe el id muestra el mensaje
        } catch (NullPointerException n) {
             System.out.println("No se encuentra ningún empleado con ese id");
          }
        return empleadoJpa.findEmpleado(id);
    }
    
    
    public void actualizarEmpleado(Empleado empleado) {
        try {
            //LLamamos a empleadoJpa y le pasamos como parámetro el objeto
            empleadoJpa.edit(empleado);
        } catch (Exception ex) {
            Logger.getLogger(ControladoraPersistencia.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
     public void eliminarEmpleado(int id) throws Exception {
        try {
          //Busco al empleado por id
            Empleado borrarEmpleado = empleadoJpa.findEmpleado(id);
            
            //Si el empleado está borrado
              if(borrarEmpleado.isBorradoLogico() == true) {
                System.out.println("Ese empleado no existe");
            }
              //Si el empleado no está borrado
               if(borrarEmpleado.isBorradoLogico() == false) {
                 System.out.println("**Usuario eliminado correctamente**");
            }
         
          //Seteo la variable borradoLogico a true porque estoy borrando un empleado
            borrarEmpleado.setBorradoLogico(true);
            
            //Modifico Empleado - edito el cambio
             empleadoJpa.edit(borrarEmpleado);
   
        } catch (NonexistentEntityException ex) {
            Logger.getLogger(ControladoraPersistencia.class.getName()).log(Level.SEVERE, null, ex);
        } catch (NullPointerException n) {
            System.out.println("Ese empleado no se puede eliminar porque no existe");
        }
        
    }
     
    public List<Empleado> filtrarPorCargo(String cargo) {
      //Traigo a los empleados
        List<Empleado> listadoCargoEmpleados = new ArrayList();
        
        //El método: findCargoEmpleado(cargo) --> está creado en EmpleadoJpaController y trae a los empleados por su cargo mediante una query
      for(Empleado empleadoBucle: empleadoJpa.findCargoEmpleado(cargo)) {
          //Si el empleado no está borrado lo añade a la lista
          if(!empleadoBucle.isBorradoLogico()) {
              listadoCargoEmpleados.add(empleadoBucle);
          }
      }
      //retorno la lista de los empleados
      return listadoCargoEmpleados;
    }


}
