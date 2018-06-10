import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.AfterClass;
import org.junit.Test;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class AnalyzerTest {
    Analyzer reader = new Analyzer();
    File archivoVacio;
    File archivo;
    String lineasArchivo = "2 Web delopment";


    @BeforeClass
    public void iniciarArchivos() throws IOException {
        archivo = new File("archivo.txt");
        archivoVacio = new File("archivoVacio.txt");
        FileWriter writer = new FileWriter(archivo);
        writer.write(lineasArchivo);
        writer.close();
        archivo.createNewFile();
        archivoVacio.createNewFile();
    }

    @AfterClass
    public void eliminarArchivos() {
        archivo.delete();
        archivoVacio.delete();
    }

    @Test
    public void leerArchivoCorrecto() {
        ArrayList<String> strings = new ArrayList<>();
        strings.add(lineasArchivo);

        Assert.assertTrue(reader.readFile("archivo.txt").equals(strings));
    }

    @Test
    public void leerArchivoVacio() {
        ArrayList<String> strings = new ArrayList<>();

        Assert.assertNotNull(reader.readFile("archivoVacio.txt"));
    }

    @Test
    public void leerArchivoNoExiste() throws IOException {
        reader.readFile("archivoNoExiste.txt");
    }
}