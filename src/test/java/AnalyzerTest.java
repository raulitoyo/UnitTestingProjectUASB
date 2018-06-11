import org.junit.Assert;
import org.junit.Test;

import java.io.IOException;
import java.util.*;

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

    @Test
    public void todasPalabras_cantidad_palabras() {
        List<Sentence> listaSentence = new ArrayList<Sentence>();
        Set<Word> listaWord = new TreeSet<Word>();

        listaSentence = reader.readFile("archivo.txt");
        listaWord = reader.allWords(listaSentence);

        Assert.assertEquals(40, listaWord.size());
    }

    @Test
    public void todasPalabras_buscar_palabraIt() {
        List<Sentence> listaSentence = new ArrayList<Sentence>();
        Set<Word> listaWord = new TreeSet<Word>();

        listaSentence = reader.readFile("archivo.txt");
        listaWord = reader.allWords(listaSentence);

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
        List<Sentence> listaSentence = new ArrayList<Sentence>();
        Set<Word> listaWord = new TreeSet<Word>();

        listaSentence = reader.readFile("archivo.txt");
        listaWord = reader.allWords(listaSentence);

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
        List<Sentence> listaSentence = new ArrayList<Sentence>();
        Set<Word> listaWord = new TreeSet<Word>();
        Map<String, Double> map = new HashMap<String, Double>();

        listaSentence = reader.readFile("archivo.txt");
        listaWord = reader.allWords(listaSentence);

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
}