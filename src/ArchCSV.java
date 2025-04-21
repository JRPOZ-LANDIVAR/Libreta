
import java.io.*;


public class ArchCSV {

        private static final String ARCHIVO = "contacts.csv";
        private static final String TEMPORAL = "temp.csv";

    public ArchCSV() {
    }

    public static void agregarContactoAlCSV(Contacto contacto) throws IOException {
            boolean archivoVacio = new File(ARCHIVO).length() == 0;
            int idNuevo = 0;
           try (PrintWriter writer = new PrintWriter(new FileWriter(ARCHIVO, true))) {
                if (archivoVacio){
                    writer.println("id" + "," + "nombre" + "," + "apellido" + "," + "apodo" + "," +
                            "numeroTelefono" + "," + "correo" + "," + "direccion" + "," + "fechaNacimiento");

                }

               BufferedReader reader = new BufferedReader(new FileReader(ARCHIVO));
               String linea;

               reader.readLine();
               while ((linea = reader.readLine()) != null){
                   String[] datos = linea.split(",");
                   idNuevo = Integer.parseInt(datos[0]);
               }
               idNuevo = idNuevo+1;

               contacto.setId(idNuevo);
                writer.println(contacto.toCSV());
                System.out.println("Contacto agregado correctamente al archivo.");
            } catch (IOException e) {
                System.err.println("Error al escribir en el archivo: " + e.getMessage());
            } }


    // throws IOException se coloco para indicar que si a la hora de leer el archivo falla algo, tira un error

        public static void buscarContacto(int id) throws IOException {
            BufferedReader reader = new BufferedReader(new FileReader(ARCHIVO));
            String linea;
            // variable que ayudara a almacenar cada linea que se lee del archivo
            reader.readLine();
            while ((linea = reader.readLine()) != null) {
                String[] datos = linea.split(",");
                int idpersonas = Integer.parseInt(datos[0]);
                if (id == idpersonas){
                    System.out.println("ID: " + datos[0]);
                    System.out.println("Nombre: " + datos[1]);
                    System.out.println("Apellido: " + datos[2]);
                    System.out.println("Apodo: " + datos[3]);
                    System.out.println("Teléfono: " + datos[4]);
                    System.out.println("Email: " + datos[5]);
                    System.out.println("Dirección: " + datos[6]);
                    System.out.println("Fecha de nacimiento: " + datos[7]);
                    reader.close();
                    return;
                }
            }

        }



    public static void eliminarContacto(int id) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(ARCHIVO));
        PrintWriter writer = new PrintWriter(new FileWriter(TEMPORAL));

        String linea;
        String encabezado = reader.readLine();
        writer.println(encabezado);

        while ((linea = reader.readLine()) != null) {
            String[] datos = linea.split(",");
            int idpersonas = Integer.parseInt(datos[0]);
            if (id != idpersonas){
                writer.println(linea);
            }
        }

        reader.close();
        writer.close();

        // Reemplazar el archivo original con el temporal
        File archivoOriginal = new File(ARCHIVO);
        File archivoTemp = new File(TEMPORAL);

        archivoOriginal.delete();
        archivoTemp.renameTo(archivoOriginal);
        System.out.println("El contacto ha sido eliminado correctamente");

    }



    public static void actualizarContacto(int id, Contacto contacto) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(ARCHIVO));
        PrintWriter writer = new PrintWriter(new FileWriter(TEMPORAL));

        String linea;
        String encabezado = reader.readLine();
        writer.println(encabezado);

        while ((linea = reader.readLine()) != null) {
            String[] datos = linea.split(",");
            int idpersonas = Integer.parseInt(datos[0]);
            if (id != idpersonas){
                writer.println(linea);
            }
            else {
                writer.println(contacto.toCSV());
            }
        }

        reader.close();
        writer.close();

        // Reemplazar el archivo original con el temporal
        File archivoOriginal = new File(ARCHIVO);
        File archivoTemp = new File(TEMPORAL);

        archivoOriginal.delete();
        archivoTemp.renameTo(archivoOriginal);
        System.out.println("El contacto ha sido actualizado correctamente");
    }



    public static void mostrarContactos() throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(ARCHIVO));
        String linea;

        while ((linea = reader.readLine()) != null) {
            System.out.println(linea);
        }
        reader.close();

    }



}
