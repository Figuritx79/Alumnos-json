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

    public static void main(String[] args) throws Exception {
        BufferedWriter bw = null;
        try {
            // Le decimos donde va estar la direccion donde vamos a almacenar los datos
            File file = new File("./estudiantes.json");

            if (!file.exists()) {
                file.createNewFile();
            }

            // Creamos el buffer para escribir lo que le vayamos a pasar
            FileWriter fw = new FileWriter(file);
            bw = new BufferedWriter(fw);
            JSONObject jsonObject = new JSONObject();

            JSONArray jsonArray = new JSONArray();

            System.out.println("Hola, Que quieres realizar hoy?");

            boolean repetir = true;

            do {
                System.out.println("1.Agregar alumno, 2.Buscar alumno, 3.Mostrar alumnos");
                int opcionRealizar = scanner.nextInt();

                opcionARealizar(opcionRealizar, nombresAlumnos);
                jsonObject.put("Nombre", nombresAlumnos);
                jsonObject.put("Edad", 4);
                jsonObject.put("Menos", 12);
                jsonObject.put("NOse", 13);

                jsonArray.put(jsonObject);

                System.out.println(nombresAlumnos);

                bw.write(jsonArray.toString(4));

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

    private static void opcionARealizar(int opcionRealizar, String nombresAlumnos) {
        switch (opcionRealizar) {
            case 1:
                System.out.println("Opcion 1");
                nombreAlumno(nombresAlumnos);
                break;
            case 2:
                System.out.println("Opcion 2");
                break;
            case 3:
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
    private static void nombreAlumno(String nombreAlumnos) {
        System.out.println("Ingresa tu nombre completo :)");
        nombresAlumnos = scanner.next();
    }
    // Pedir su edad

    // Usar un arreglo bidimensional para almacenar materias y calificaciones
}