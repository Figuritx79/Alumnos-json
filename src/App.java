import java.util.Scanner;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import org.json.JSONArray;
// import org.json.JSONArray;1
import org.json.JSONObject;

public class App {

    private static Scanner scanner = new Scanner(System.in);

    private static String nombresAlumnos;
    private static int edades;

    public static void main(String[] args) throws Exception {
        // Creamos el buffer para escribir lo que le vayamos a pasar
        BufferedWriter bw = null;
        try {
            // Le decimos donde va estar la direccion donde vamos a almacenar los datos
            File file = new File("./estudiantes.json");

            // Comprabamos que si no existe el archivo para que lo haga si no existe
            if (!file.exists()) {
                file.createNewFile();
            }

            // Creamos el fileWriter para escribir en un archivo. En este caso es un .json
            FileWriter fw = new FileWriter(file);

            bw = new BufferedWriter(fw);

            System.out.println("Hola, Que quieres realizar hoy?");

            boolean repetir = true;

            do {
                JSONObject jsonObject = new JSONObject();

                JSONArray jsonArray = new JSONArray();

                System.out.println("1.Agregar alumno, 2.Buscar alumno, 3.Mostrar alumnos");
                String opcionRealizar = scanner.next();

                opcionARealizar(opcionRealizar);
                jsonObject.put("Nombre", nombresAlumnos);

                jsonArray.put(jsonObject);

                bw.write(jsonArray.toString(6));

                repetir = repetirAccion();
            } while (repetir);

        } catch (IOException ioe) {
            ioe.printStackTrace();

        } finally {
            try {
                if (bw != null) {
                    bw.close();
                }
            } catch (Exception ex) {
                System.out.println("Erro al cerrar el Bufferd Writter " + ex);
            }

        }
        scanner.close();
    }

    private static void opcionARealizar(String opcionRealizar) {
        switch (opcionRealizar) {
            case "1":
                System.out.println("Opcion 1");
                nombreAlumno();
                break;
            case "2":
                System.out.println("Opcion 2");
                break;
            case "3":
                System.out.println("Opcion 3");
                break;
            default:

                System.out.println("Opcion no valida");
                break;
        }
    }

    // Preguntar si quiere preguntar
    private static boolean repetirAccion() {
        System.out.println("-------------------------------------");
        System.out.println("Quieres volver a escoger una opcion? [Y/N]");
        char respuesta = scanner.next().charAt(0);

        if (respuesta == 'Y' || respuesta == 'y') {
            return true;
        }
        return false;
    }

    // Pregutar su nombre
    private static void nombreAlumno() {
        System.out.println("Ingresa tu nombre completo :)");
        nombresAlumnos = scanner.next();
    }
    // Pedir su edad

    // Usar un arreglo bidimensional para almacenar materias y calificaciones
}