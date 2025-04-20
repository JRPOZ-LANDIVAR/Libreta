import java.util.Date;
import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {

    public static void main(String[] args) {

        String nombre= "", apellido= "", apodo= "", numeroTelefono= "", correo= "", fechaNacimiento= "", direccion = "";


//



        int opcion = 0;
        Scanner entrada = new Scanner(System.in);

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

        switch (opcion){
            case 1:
                Contacto contacto = new Contacto( nombre,  apellido,  apodo,  numeroTelefono, correo,  direccion,  fechaNacimiento);
                ArchCSV archCSV;
                ArchCSV.agregarContactoAlCSV(contacto);
            break;
        }

}while (opcion != 6);
    }
}


