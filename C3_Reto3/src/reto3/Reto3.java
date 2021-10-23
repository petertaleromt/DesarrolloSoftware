/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package reto3;

import java.util.Scanner;
import java.util.HashMap;

/**
 *
 * @author peter.talero
 */
public class Reto3 {

    private final Scanner scanner = new Scanner(System.in);

    public String read() {
        return this.scanner.nextLine();
    }

    //Clase Producto
    class producto {

        private int codigo;
        private String nombre;
        private double precio;
        private int inventario;

        public producto(int codigo, String nombre, double precio, int inventario) {
            this.codigo = codigo;
            this.nombre = nombre;
            this.precio = precio;
            this.inventario = inventario;
        }

        public int getCodigo() {
            return codigo;
        }

        public void setCodigo(int codigo) {
            this.codigo = codigo;
        }

        public String getNombre() {
            return nombre;
        }

        public void setNombre(String nombre) {
            this.nombre = nombre;
        }

        public double getPrecio() {
            return precio;
        }

        public void setPrecio(double precio) {
            this.precio = precio;
        }

        public int getInventario() {
            return inventario;
        }

        public void setInventario(int inventario) {
            this.inventario = inventario;
        }
    }
    
    //Clase Base de datos
    class BaseDatosProductos {

        HashMap<Integer, producto> listaProductos = new HashMap<>();

        public void agregar(producto newRegistro) {
            if (listaProductos.containsKey(newRegistro.getCodigo())) {
                System.out.println("ERROR");
            } else {
                listaProductos.put(newRegistro.getCodigo(), newRegistro);
                generarInforme(newRegistro);
            }
        }

        public void borrar(producto newRegistro) {
            if (listaProductos.containsKey(newRegistro.getCodigo())) {
                listaProductos.remove(newRegistro.getCodigo());
                generarInforme(newRegistro);
            } else {
                System.out.println("ERROR");
            }
        }

        public void actulizar(producto newRegistro) {
            if (listaProductos.containsKey(newRegistro.getCodigo())) {
                listaProductos.put(newRegistro.getCodigo(), newRegistro);
                generarInforme(newRegistro);
            } else {
                System.out.println("ERROR");
            }
        }

        public void generarInforme(producto newRegistro) {
            int[] topThree = new int[3];
            for (int i = 0; i < 3; i++) {
                topThree[i] = topPrecio(topThree);

            }
            System.out.println(listaProductos.get(topThree[0]).getNombre() + " " + listaProductos.get(topThree[1]).getNombre() + " " + listaProductos.get(topThree[2]).getNombre());
        }

        public Integer topPrecio(int[] idProducto) {
            double maxPrecio;
            maxPrecio = 0;
            int idMaxPrecio = 0;

            for (producto datos : listaProductos.values()) {
                if (idProducto[0] != datos.getCodigo()) {
                    if (idProducto[1] != datos.getCodigo()) {
                        if (maxPrecio < datos.getPrecio()) {
                            maxPrecio = datos.getPrecio();
                            idMaxPrecio = datos.getCodigo();
                        }
                    }
                }
            }
            return listaProductos.get(idMaxPrecio).getCodigo();
        }

        //Metodo para generar el mayor precio
        public String mayorPrecio() {
            double maxPrecio;
            maxPrecio = 0;
            int idMaxPrecio = 0;
            for (producto datos : listaProductos.values()) {
                if (maxPrecio < datos.getPrecio()) {
                    maxPrecio = datos.getPrecio();
                    idMaxPrecio = datos.getCodigo();
                }
            }
            return listaProductos.get(idMaxPrecio).getNombre();
        }

        //Metodo para generar el menor precio
        public String menorPrecio() {
            double menPrecio;
            menPrecio = Double.MAX_VALUE;
            int idMenPrecio = 0;
            for (producto datos : listaProductos.values()) {
                if (menPrecio > datos.getPrecio()) {
                    menPrecio = datos.getPrecio();
                    idMenPrecio = datos.getCodigo();
                }
            }
            return listaProductos.get(idMenPrecio).getNombre();
        }

        //Metodo para generar el promedio precio
        public double promedioPrecio() {
            double sumarPrecio;
            double promedioPrecio = 0;
            sumarPrecio = 0;
            for (producto datos : listaProductos.values()) {
                sumarPrecio = sumarPrecio + datos.getPrecio();
                promedioPrecio = sumarPrecio / listaProductos.size();

            }
            return promedioPrecio;
        }

        //Metodo para generar el valor inventario
        public double valorInventario() {
            double valorInventario = 0;
            for (producto datos : listaProductos.values()) {
                valorInventario = valorInventario + (datos.getPrecio() * datos.getInventario());

            }
            return valorInventario;
        }
    }

    /**
     * método principal
     */
    public void run() {
        //llenar HashMap con la información de la Base de Datos.
        BaseDatosProductos miniSuper = new BaseDatosProductos();
        producto r1 = new producto(1, "Manzanas", 5000.0, 25);
        producto r2 = new producto(2, "Limones", 2300.0, 15);
        producto r3 = new producto(3, "Peras", 2700.0, 33);
        producto r4 = new producto(4, "Arandanos", 9300.0, 5);
        producto r5 = new producto(5, "Tomates", 2100.0, 42);
        producto r6 = new producto(6, "Fresas", 4100.0, 3);
        producto r7 = new producto(7, "Helado", 4500.0, 41);
        producto r8 = new producto(8, "Galletas", 500.0, 8);
        producto r9 = new producto(9, "Chocolates", 3500.0, 80);
        producto r10 = new producto(10, "Jamon", 15000.0, 10);
        miniSuper.listaProductos.put(r1.getCodigo(), r1);
        miniSuper.listaProductos.put(r2.getCodigo(), r2);
        miniSuper.listaProductos.put(r3.getCodigo(), r3);
        miniSuper.listaProductos.put(r4.getCodigo(), r4);
        miniSuper.listaProductos.put(r5.getCodigo(), r5);
        miniSuper.listaProductos.put(r6.getCodigo(), r6);
        miniSuper.listaProductos.put(r7.getCodigo(), r7);
        miniSuper.listaProductos.put(r8.getCodigo(), r8);
        miniSuper.listaProductos.put(r9.getCodigo(), r9);
        miniSuper.listaProductos.put(r10.getCodigo(), r10);

        //Declaración variable y recepción de Datos
        int codigo = 0;
        String nombre, opc, datos;
        double precio;
        int inventario;
        opc = scanner.nextLine();
        datos = scanner.nextLine();
        String[] cadena = datos.split(" ");
        codigo = Integer.parseInt(cadena[0]);
        nombre = cadena[1];
        precio = Double.parseDouble(cadena[2]);
        inventario = Integer.parseInt(cadena[3]);
        producto newRegistro = new producto(codigo, nombre, precio, inventario);
        if (null != opc) {
            switch (opc) {
                case "AGREGAR": {
                    miniSuper.agregar(newRegistro);
                    break;
                }
                case "BORRAR": {
                    miniSuper.borrar(newRegistro);
                    break;
                }
                case "ACTUALIZAR": {
                    miniSuper.actulizar(newRegistro);
                    break;
                }
                default:
                    break;
            }
        }
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Reto3 reto = new Reto3();
        reto.run();
    }

}
