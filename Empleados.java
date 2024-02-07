
package com.mycompany.practicasplatzi;
import java.util.ArrayList;
import java.util.List;
/**
 *
 * @author adrib
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
    
    interface Empleado {
        int calcularSalario();
        String obtenerDetalles();
    }
    
    public static class EmpleadoPorHora extends Empleados implements Empleado{
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
        public String obtenerDetalles(){
            return "\n ID: " + idEmpleado + "\n Nombre: " + nombre + "\n Tipo de empleado: Por hora" +
                    "\n Sueldo a cobrar: " + calcularSalario();
        }  
    }
    
    public static class EmpleadoTiempoCompleto extends Empleados implements Empleado{
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
        public String obtenerDetalles() {
           return "\n ID: " + idEmpleado + "\n Nombre: " + nombre + "\n Tipo de empleado: Tiempo completo " +
                    "\n Sueldo a cobrar: " + calcularSalario();
        }
        
    }
    
    public static class EmpleadoPorComision  extends Empleados implements Empleado{
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
        public String obtenerDetalles() {
            return "\n ID: " + idEmpleado + "\n Nombre: " + nombre + "\n Tipo de empleado: Tiempo completo " +
                    "\n Sueldo a cobrar: " + calcularSalario();
        }
        
    }
    
    public static class GestorEmpleados{
       private List<Empleado> listaEmpleado; 
       
       public GestorEmpleados(){
           this.listaEmpleado = new ArrayList<>();
       }
       
       public void agregar(Empleado empleado){
           listaEmpleado.add(empleado);
       }
       
       public void eliminar(Empleado empleado){
           listaEmpleado.remove(empleado);
       }
       
       public void mostrar(){
           for (Empleado empleado : listaEmpleado){
               System.out.println(empleado.obtenerDetalles());
           }
       }
       
    }
    
    public static void main(String[] args) {
        GestorEmpleados gestor = new GestorEmpleados();
        
        Empleado  emp1 = new EmpleadoPorHora("Juan", 10, 10500);
        gestor.agregar(emp1);
        
        Empleado  emp2 = new EmpleadoTiempoCompleto("Beatriz", 1500000);
        gestor.agregar(emp2);
        
        Empleado  emp3 = new EmpleadoPorComision("Emanuel", 105000, 12);
        gestor.agregar(emp3);
        
        Empleado  emp4 = new EmpleadoPorHora("Jose Luis", 60, 12500);
        gestor.agregar(emp4);
        
        gestor.mostrar();
        
        
    }
}

