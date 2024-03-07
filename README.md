
![logo](https://github.com/beaperezm/PerezMedelBeatriz_pruebatec1/assets/113792109/0894bc97-f17d-448c-849c-73b583456b54)

Empleados es el desarrollo del backend lógico para la aplicación de gestión de empleados de una empresa.

## Objetivos del proyecto

El usuario puede:

✅ Insertar empleados: el nombre, apellidos, cargo, salario y fecha de inicio

✅ Ver qué empleados hay dados de alta en la base de datos

✅ Actualizar los datos de los empleados

✅ Eliminar empleados

✅ Buscar empleados por su cargo - mostrando la información de dichos empleados


El objetivo es que se realice un CRUD (Crear, Leer, Actualizar, Borrar) conectado directamente con la base de datos

![usuario eliminado en phpmyadmin](https://github.com/beaperezm/PerezMedelBeatriz_pruebatec1/assets/113792109/e3c71a63-3120-4698-a222-a1d15212477b)


## Explicación Código

El proveedor utilizado es EclipseLink

En el proyecto se ha utilizado el modelo de capas:

1. Capa interfaz gráfica de usuario (igu) - en esta práctica no hay código dentro de esta capa
   
3. Capa lógica de negocios
   
5. Capa de persistencia

Estas tres capas se comunican entre sí mediante clases controladoras - para ello se han creado la

a- Controladora --> que se encuentra dentro de la capa lógica de negocios

b- ControladoraPersistencia --> que se encuentra dentro de la capa de persistencia

Además también tenemos:

- Clase Empleado - con las annotations, atributos (en private), constructores, getters, setters (son los que se usan para acceder o modificar datos de los atributos) y método toString() --> dentro de la lógica de negocio
  
- CargoException - se encuentra en la lógica de negocio y se utiliza para capturar posible fallo a la hora de filtrar por cargo
  
- Clase EmpleadoJpaController - con todos los métodos crear, editar, filtrar... --> se encuentra dentro de la persistencia
  
- Clase EmpleadoJpa - en la cual se encuentra el método main

Para cada opción del menú se han creado métodos, cada uno con su lógica correspondiente:

🔹 crearEmpleado -- a través de éste método vamos a insertar a los empleados - se ingresan por teclado - se guardan en el arrayList - y se insertan en la base de datos

🔹 mostrarEmpleados -- retorna el listado con todos los empleados activos - se realiza un bucle sobre el ArrayList y utilizando el método toString() de la clase Empleado mostramos los datos

🔹 En el caso de que lo que se quiera sea actualizar algún dato lo que hace la aplicación es:

- Buscar al empleado que queramos modificar y traer el objeto - de esto se encarga el método traerEmpleadoActualizar
  Si el id insertado no se encuentra muestra un mensaje por consola y no sigue con el proceso
  
- Con los métodos actualizar lo que estamos haciendo es guardar el objeto en una nueva instancia, hacer las modificaciones y volver a mandar el objeto de vuelta a la base de datos
  Si se ha realizado la modificación con éxito muestra un mensaje por consola

🔹eliminarEmpleado -- en este caso estamos haciendo un borrado lógico - cuando el usuario se elimina ésta pasa a "true" (pasa a estar 'inactivo'). Es el usuario el que decide qué empleado eliminar insertando el id por teclado.
Si el empleado indicado por el usuario no existe le manda un mensaje por consola, sino elimina al empleado y le muestra también un mensaje de éxito

🔹filtrarPorCargo - en este caso se ha creado una query para que filtre en función del cargo que el usuario introduzca por teclado.
Si el cargo existe nos muestra los datos del empleado y si no la aplicación nos muestra un mensaje avisándonos de que el cargo no existe.

En el código se han utilizado varias estructuras, entre ellas:

✔️ condicionales:

▫️ If

`if(opcion == 1) {  control.actualizarNombreEmpleado(empleado, sc);  }`

▫️ Switch para mostrar el menú de opciones

```java
switch(opcion) {
           case 1:
                control.crearEmpleado(sc, nuevoEmpleado, empleados);
                break;

           case 2:
               System.out.println(control.mostrarEmpleados(empleados));
               break;

          { ... }

           default:
               System.out.println("La opción elegida es incorrecta");
               break;

          }
```

✔️ repetitivas

   ▫️ do - while - controlado por bandera

 ```java
do {

           System.out.println("Menú de opciones");
           System.out.println("1. Insertar Empleado");
           System.out.println("2. Listar Empleados");
           System.out.println("3. Actualizar Empleado");
           System.out.println("4. Eliminar Empleado");
           System.out.println("5. Buscar empleado por cargo");
           System.out.println("6. Salir");
           opcion = sc.nextInt();

           { ... }


       } while(opcion != 6 || bandera == false);
```

   ▫️ While
  ```java
            while (bandera == false && empleado.isBorradoLogico() == false) {
                    System.out.println("¿Qué desea modificar?");
                    System.out.println("1. Nombre");
                    System.out.println("2. Apellido");
                    System.out.println("3. Cargo");
                    System.out.println("4. Salario");
                    System.out.println("5. Fecha de inicio");
                    System.out.println("6. Salir");
                    opcion = sc.nextInt();

                    { ... }

                } 
 ```


   ▫️ For - para recorrer Arrays
  ```java        
     for(Empleado empleadoBucle : empleados) {
          empleadoBucle.toString();
      } 
  ```

✔️ Collections

▫️ List - ArrayList

```java    
List<Empleado> empleados = new ArrayList <Empleado>();
```



### Supuestos

Algunos de los suspuestos a la hora de crear el proyecto son:

- El usuario conoce el ID del empleado.
  
- El usuario introduce siempre el cargo escrito igual.
  
- El usuario introduce la fecha correctamente.



## Tecnologías utilizadas

![java](https://github.com/beaperezm/PerezMedelBeatriz_pruebatec1/assets/113792109/6288edf5-8e0f-4beb-9941-b41d3ca33e79)

![Netbeans](https://github.com/beaperezm/PerezMedelBeatriz_pruebatec1/assets/113792109/eeb75421-0e86-43f5-8db5-404b9710006b)


y algunos "imports"

```java
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
 ```













