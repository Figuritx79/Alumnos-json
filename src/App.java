import java.util.Scanner;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import org.json.JSONArray;
import org.json.JSONObject;

public class App {

    private static Scanner scanner = new Scanner(System.in);

    private static String nombresAlumnos;
    private static int edades;
    private static String[][] materiasCalificaciones;

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

            // Le decimos que el buffer va a escribir en fw
            bw = new BufferedWriter(fw);

            System.out.println("Hola, Que quieres realizar hoy?");

            boolean repetir = true;
            int identFactor = 1;

            JSONObject alumnos;
            JSONObject datosAlumnos = new JSONObject();
            JSONArray listaAlumnos = new JSONArray();

            do {
                alumnos = new JSONObject();
                System.out.println("1.Agregar alumno, 2.Buscar alumno, 3.Mostrar alumnos");
                String opcionRealizar = scanner.next();

                opcionARealizar(opcionRealizar);

                alumnos.put("Nombres", nombresAlumnos);
                alumnos.put("Edad", edades);

                datosAlumnos.put("Alumno" + identFactor, alumnos);

                identFactor++;
                repetir = repetirAccion();
            } while (repetir);

            listaAlumnos.put(datosAlumnos);
            // Escribimos en el buffer
            bw.write(listaAlumnos.toString());

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
                edadAlumno();
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

    // Preguntar si quiere hacer otra cosa
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
        System.out.println("Ingresa el nombre completo del alumno :)");
        nombresAlumnos = scanner.next();
    }

    // Pedir su edad
    private static void edadAlumno() {
        System.out.println("Ingresa la edad del alumno :)");
        edades = scanner.nextInt();
    }

    // Usar un arreglo bidimensional para almacenar materias y calificaciones
}