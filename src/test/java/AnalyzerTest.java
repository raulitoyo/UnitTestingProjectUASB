import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.AfterClass;
import org.junit.Test;
import sun.misc.IOUtils;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class AnalyzerTest {
    Analyzer reader = new Analyzer();
    String lineasArchivo = "1 Web development";

    @Test
    public void leerArchivoCorrecto() {
        List<String> strings = Arrays.asList(lineasArchivo);

        Assert.assertTrue(reader.readFile("archivo.txt").equals(strings));
    }

    @Test
    public void leerArchivoVacio() {
         Assert.assertNull(reader.readFile("archivoVacio.txt"));
    }

    @Test
    public void leerArchivoNoExiste() throws IOException {
         Assert.assertNull(reader.readFile("archivoNoExiste.txt"));
    }
}