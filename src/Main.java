import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.*;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {



    public static void main(String[] args) throws IOException {
        String nombre= "", apellido= "", apodo= "", numeroTelefono= "", correo= "", fechaNacimiento= "", direccion = "";
        Scanner entrada = new Scanner(System.in);

        int opcion = 0;

        do {


        System.out.println("------------------------------------------");
        System.out.println("        Que accion desea realizar        ");
        System.out.println("------------------------------------------");
        System.out.println("1) Agregar contacto");
        System.out.println("2) Eliminar contacto");
        System.out.println("3) Actualizar contacto");
        System.out.println("4) Buscar por ID");
        System.out.println("5) Mostrar contactos");
        System.out.println("6) Crear Arboles");
        System.out.println("7) salir");
        opcion = entrada.nextInt();
        entrada.nextLine();
        switch (opcion){
            case 1:

                System.out.println("nombre: ");
                nombre = entrada.nextLine();
                System.out.println("apellido: ");
                apellido = entrada.nextLine();
                System.out.println("apodo: ");
                apodo = entrada.nextLine();
                System.out.println("numero de Telefono: ");
                numeroTelefono = entrada.nextLine();
                System.out.println("correo: ");
                correo = entrada.nextLine();
                System.out.println("direccion: ");
                direccion = entrada.nextLine();
                System.out.println("fecha de Nacimiento: ");
                fechaNacimiento = entrada.nextLine();
                Contacto contacto = new Contacto( nombre,  apellido,  apodo,  numeroTelefono, correo,  direccion,  fechaNacimiento);
                ArchCSV.agregarContactoAlCSV(contacto);
            break;

            case 2:
                int idEliminar = 0;
                System.out.println("Ingrese el Id para eliminar: ");
                idEliminar = entrada.nextInt();
                entrada.nextLine();
                ArchCSV.eliminarContacto(idEliminar);
            break;

            case 3:
                int idActualizar= 0;
                System.out.println("Ingrese el Id para Actualizar: ");
                idActualizar = entrada.nextInt();
                entrada.nextLine();
                       System.out.println("nombre: ");
                       nombre = entrada.nextLine();
                       System.out.println("apellido: ");
                       apellido = entrada.nextLine();
                       System.out.println("apodo: ");
                       apodo = entrada.nextLine();
                       System.out.println("numero de Telefono: ");
                       numeroTelefono = entrada.nextLine();
                       System.out.println("correo: ");
                       correo = entrada.nextLine();
                       System.out.println("fecha de Nacimiento: ");
                       fechaNacimiento = entrada.nextLine();
                       contacto = new Contacto( nombre,  apellido,  apodo,  numeroTelefono, correo,  direccion,  fechaNacimiento);

                ArchCSV.actualizarContacto(idActualizar, contacto);
            break;

            case 4:
                int idBuscar = 0;
                System.out.println("Ingrese el Id para buscar: ");
                idBuscar = entrada.nextInt();
                entrada.nextLine();
                ArchCSV.buscarContacto(idBuscar);
                break;

            case 5:
                ArchCSV.mostrarContactos();
                break;



            case 6:

                System.out.println("Elige campo para ordenar");
                System.out.println("1) nombre ");
                System.out.println("2) apellido");
                System.out.println("3) apodo");
                System.out.println("4) numeroTelefono ");
                System.out.println("5) correo");
                int opcion1 = entrada.nextInt();
                entrada.nextLine();
                String campo = "";
                String tipoArbol = "";
                switch (opcion1){case 1: campo = "nombre"; break;case 2: campo = "apellido"; break;case 3: campo = "apodo"; break;case 4: campo = "numeroTelefono"; break; case 5: campo = "correo"; break;}
                HashMap<Integer, String> datos = ArchCSV.guardarPorCampo(opcion1);
                int opcion2 =0;
                List<Integer> idsOrdenados = null;
                Nodo root = null;
                System.out.println("Que tipo de arbol desea");
                System.out.println("1) Arbol AVL");
                System.out.println("1) BST");
                opcion2 = entrada.nextInt();entrada.nextLine();
                switch (opcion2){
                    case 1:
                        ArbolAVL arbolAVL = new ArbolAVL(String::compareToIgnoreCase);
                        for (Map.Entry<Integer, String> entrada1 : datos.entrySet()) {
                            int clave = entrada1.getKey();
                            String valor = entrada1.getValue();
                            arbolAVL.insert(clave, valor);
                        }

                         idsOrdenados = arbolAVL.recorridoPorNiveles();
                        tipoArbol = "avl";
                        root = arbolAVL.getRoot();
                        break;

                    case 2:
                        ArbolBST arbolBST = new ArbolBST(String::compareToIgnoreCase);
                        for (Map.Entry<Integer, String> entrada1 : datos.entrySet()) {
                            int clave = entrada1.getKey();
                            String valor = entrada1.getValue();
                            arbolBST.insert(clave, valor);
                        }

                        idsOrdenados = arbolBST.recorridoPorNiveles();

                        tipoArbol = "bst";
                        root = arbolBST.getRoot();

                        break;

                    default:
                        System.out.println("No existe esa opcion");
                        break;
                }


                ArchivoIndice.guardarEstructuraConNulls(root,  campo,  tipoArbol);
                break;
        }



}while (opcion != 7);
    }


}


