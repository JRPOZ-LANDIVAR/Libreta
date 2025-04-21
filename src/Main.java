import java.io.IOException;
import java.util.Date;
import java.util.Scanner;

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
        System.out.println("6) salir");
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
        }



}while (opcion != 6);
    }


}


