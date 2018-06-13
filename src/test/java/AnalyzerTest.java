import com.sun.xml.internal.bind.v2.runtime.reflect.opt.Const;
import org.junit.Assert;
import org.junit.Test;
import org.testng.annotations.BeforeMethod;

import java.io.IOException;
import java.util.*;

public class AnalyzerTest {
    private Analyzer reader;
    static int TOTAL_PALABRAS_EN_ARCHIVO_TXT = 40;

    @BeforeMethod
    public void beforeMethod() {
        Analyzer reader = new Analyzer();
    }

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

    @Test
    public void todasPalabras_totalPalabras_enArchivo() {
        Set<Word> listaWord = todasPalabras();

        Assert.assertEquals(TOTAL_PALABRAS_EN_ARCHIVO_TXT, listaWord.size());
    }

    @Test
    public void todasPalabras_buscar_palabraIt() {
        Set<Word> listaWord = todasPalabras();

        String palabraBuscar = "it";

        int apariciones = 0;
        for (Word palabra : listaWord) {
            if(palabraBuscar.equals(palabra.getText())){
                apariciones = palabra.getCount();
            }
        }

        Assert.assertEquals(3, apariciones);
    }

    @Test
    public void todasPalabras_acumulativo_palabraNot() {
        Set<Word> listaWord = todasPalabras();

        String palabraBuscar = "not";

        int acumulativo = 0;
        for (Word palabra : listaWord) {
            if(palabraBuscar.equals(palabra.getText())){
                acumulativo = palabra.getTotal();
            }
        }

        Assert.assertEquals(4, acumulativo);
    }

    @Test
    public void calcularScore_sentimiento_palabraFun() {
        Set<Word> listaWord = todasPalabras();

        Map<String, Double> map = new HashMap<String, Double>();

        String palabraBuscar = "fun";

        map = Analyzer.calculateScores(listaWord);

        double sentimiento = 0;
        for (Map.Entry<String, Double> entry : map.entrySet()) {
            if (palabraBuscar.equals(entry.getKey())) {
                sentimiento = entry.getValue();
            }
        }

        Assert.assertEquals(0.8, sentimiento, 0.001);
    }

    private Set<Word> todasPalabras() {
        List<Sentence> listaSentence = new ArrayList<Sentence>();
        Set<Word> listaWord = new TreeSet<Word>();

        listaSentence = reader.readFile("archivo.txt");
        listaWord = reader.allWords(listaSentence);

        return listaWord;
    }
}