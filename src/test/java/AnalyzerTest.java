import org.junit.Assert;
import org.junit.Test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class AnalyzerTest {
    Analyzer reader = new Analyzer();

    @Test
    public void leerArchivo_correcto_archivo() {
        List<Sentence> listaSentence = new ArrayList<Sentence>();
        listaSentence = reader.readFile("archivo.txt");

        Assert.assertFalse(listaSentence.isEmpty());
    }

    @Test
    public void leerArchivo_vacio_archivo() {
        List<Sentence> listaSentence = reader.readFile("archivoVacio.txt");

        Assert.assertEquals("", 0, listaSentence.size());
    }

    @Test
    public void leerArchivo_noExiste_archivo() throws IOException {
         Assert.assertNull(reader.readFile("archivoNoExiste.txt"));
    }
}