import java.io.*;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.nio.charset.StandardCharsets;

public class Ejercicio0 {
    public static void main(String[] args) {
        //Bloque try catch para controlar las posibles excepciones IOException (InputStream) y MalformedURLException (URL).
        try {
            //Creación del objeto de la clase URL al que le pasamos la url de la web en la cual vamos a trabajar.
            URL url = new URL("https://informatica.es.zone/course/dam-programacion-de-servicios-y-procesos/");

            //Creación del objeto de la clase URLConnection la cual nos permitirá trabajar con la URL.
            URLConnection urlConnection = url.openConnection();

            //Utilizamos el método getInputStream() de la clase URLConnection para pasar el código fuente de la web de la URL para
            //poder mostrar el código en el programa.
            InputStream inputStream = urlConnection.getInputStream();

            //Creación de un InputStreamReader y de un BufferedReader.
            InputStreamReader isr = new InputStreamReader(inputStream, StandardCharsets.UTF_8);
            BufferedReader bufferedReader = new BufferedReader(isr);

            /*- Utilizo una expresión lambda para mostrar por pantalla mediante un println linea a linea.
            - El método lines() devuelve todas las lineas del bufferedReader y forEach() ejecuta la expresión
            lambda que le pasemos por parámetro en todas las lineas.
            - Se podría substituir por un bucle for.*/
            bufferedReader.lines().forEach(line -> System.out.println(line));

        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
