import java.util.ArrayList;
import java.util.List;
/**
 *
 * @author Adriana Noeli Benitez Arguello
 */

/*
    Programa sencillo de gestion de empleados, se crea un objeto EmpleadoInterfaz con sus caracteristicas y
    se agrega al gestor: se puede eliminar, agregar o buscar por ID.
    Implementacion de:
        -Interfaz
        -Objetos
        -Herencia  
        -Encapsulamiento: uso de private, final y static donde crei necesario
*/
public class Empleados {
    public String nombre;
    public static int id=0;
    public int idEmpleado;
    
    public Empleados(String nombre){
        this.nombre = nombre;
        id++;
        this.idEmpleado = id;
    }

    
    interface EmpleadoInterfaz {
        int calcularSalario();
        String obtenerDetalles();
        int obtenerId();
    }
    
    public static class EmpleadoPorHora extends Empleados implements EmpleadoInterfaz{
        public int horas;
        public int sueldoPorHora;
       // public String nombre;
        
        public EmpleadoPorHora(String nombre, int horas, int sueldoPorHora){
            super(nombre);
            this.horas = horas;
            this.sueldoPorHora = sueldoPorHora;
            
        }
        @Override
        public int calcularSalario() {
            return horas * sueldoPorHora;
        }
        
        @Override
        public int obtenerId(){
            return idEmpleado;
        }
        
        @Override
        public String obtenerDetalles(){
            return "\n ID: " + obtenerId() + "\n Nombre: " + nombre + "\n Tipo de empleado: Por hora" +
                    "\n Total horas trabajadas: " + horas + "\n Paga por hora: " + sueldoPorHora +
                    "\n Sueldo a cobrar: " + calcularSalario();
        }  
    }
    
    public static class EmpleadoTiempoCompleto extends Empleados implements EmpleadoInterfaz{
        public int sueldoMensual;
        
        public EmpleadoTiempoCompleto(String nombre, int sueldoMensual){
            super(nombre);
            this.sueldoMensual = sueldoMensual;
        }

        @Override
        public int calcularSalario() {
            return sueldoMensual;
        }
        
        @Override 
         public int obtenerId(){
            return idEmpleado;
        }
        
        @Override
        public String obtenerDetalles() {
           return "\n ID: " + obtenerId() + "\n Nombre: " + nombre + "\n Tipo de empleado: Tiempo completo " +
                    "\n Sueldo a cobrar: " + calcularSalario();
        }
        
    }
    
    public static class EmpleadoPorComision  extends Empleados implements EmpleadoInterfaz{
        public int  comisionPorVenta;
        public int cantVentas;
        
        public EmpleadoPorComision(String nombre, int comisionPorVenta, int cantVentas){
            super(nombre);
            this.comisionPorVenta = comisionPorVenta;
            this.cantVentas = cantVentas;
        }

        @Override
        public int calcularSalario() {
            return cantVentas * comisionPorVenta;
        }
        
        
        @Override 
         public int obtenerId(){
            return idEmpleado;
        }
       
        @Override
        public String obtenerDetalles() {
            return "\n ID: " + obtenerId() + "\n Nombre: " + nombre + "\n Tipo de empleado: Por comision " +
                    "\n Cantidad de ventas concretadas: " +  cantVentas + "\n Comision por venta: " +comisionPorVenta+
                    "\n Sueldo a cobrar: " + calcularSalario();
        }
        
    }
    
    public static class GestorEmpleados{
       private final List<EmpleadoInterfaz> listaEmpleado; 
       
       public GestorEmpleados(){
           this.listaEmpleado = new ArrayList<>();
       }
       
       //Agrega un nuevo empleado al gestor
       public void agregar(EmpleadoInterfaz empleado){
           listaEmpleado.add(empleado);
       }
       
       //Elimina un empleado especifico
       public void eliminar(EmpleadoInterfaz empleado){
           listaEmpleado.remove(empleado);
           System.out.println("\n----------------------------");
           System.out.println("Se elimino al empleado: " + empleado.obtenerDetalles());
           System.out.println("\n----------------------------");
       }
        
        //Imprime todos los empleados existentes
       public void mostrar(){
           for (EmpleadoInterfaz empleado : listaEmpleado){
               System.out.println(empleado.obtenerDetalles());
           }
       }
       //Buscar un ID en especifico, devuelve la informacion del empleado
       public void buscarID(int idBuscado){
           for (EmpleadoInterfaz empleado : listaEmpleado){
               if ( empleado.obtenerId() == idBuscado ){
                   System.out.println("\nEl empleado con el ID buscado:" + empleado.obtenerDetalles());
               }    
           }
       }
       
    }
    
    public static void main(String[] args) {
        //Creacion del gestor
        GestorEmpleados gestor = new GestorEmpleados();
        
        //Creacion y asignacion de los empleados
        EmpleadoInterfaz  emp1 = new EmpleadoPorHora("Juan", 10, 10500);
        //Agregar el empleado al gestor
        gestor.agregar(emp1);
        
        EmpleadoInterfaz  emp2 = new EmpleadoTiempoCompleto("Beatriz", 1500000);
        gestor.agregar(emp2);
        
        EmpleadoInterfaz  emp3 = new EmpleadoPorComision("Emanuel", 105000, 12);
        gestor.agregar(emp3);
        
        EmpleadoInterfaz  emp4 = new EmpleadoPorHora("Jose Luis", 60, 12500);
        gestor.agregar(emp4);
        
        //Imprimir en consola todos los empleados
        gestor.mostrar();
        
        
        gestor.buscarID(3);
        
        gestor.eliminar(emp3);
        
        System.out.println("\nTodos los empleados: ");
        gestor.mostrar();
        
        
    }
}

