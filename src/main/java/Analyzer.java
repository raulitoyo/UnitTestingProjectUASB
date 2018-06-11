import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;

public class Analyzer {
	/*
	 * Implement this method in Part 1
	 */
	public static List<Sentence> readFile(String filename) {
		Sentence sentence = new Sentence(0, null);

		String cadenaLinea;
		String cadenaPalabra;

		List<String> list = new ArrayList<>();
		try {
			List<String> lines = Files.readAllLines(Paths.get(filename), StandardCharsets.UTF_8);
			list.addAll(lines);
			if (list.size() > 0) {
				for(int i=0; i<list.size(); i++) {
					cadenaLinea = list.get(i);

					System.out.println("cadenaLinea: " + cadenaLinea);

					int numTokens = 0;
					StringTokenizer st = new StringTokenizer(cadenaLinea);

					while (st.hasMoreTokens()) 	{
						cadenaPalabra = st.nextToken();
						numTokens++;

						if (numTokens == 1) {
							try
							{
								int score = Integer.parseInt(cadenaPalabra);

								if (score >= -2 & score <= 2) {
									String espacio = cadenaLinea.substring(cadenaPalabra.length(), cadenaPalabra.length() + 1);

									if (espacio.charAt(0) == ' ') {
										System.out.println("Linea valida");

										sentence.score = score;
										sentence.text = cadenaLinea.substring(cadenaPalabra.length() + 1, cadenaLinea.length()).toUpperCase();
									} else {
										System.out.println("Linea no valida");
									}
								}
							}
							catch (NumberFormatException nfe)
							{
								System.out.println("NumberFormatException: " + nfe.getMessage());
								System.out.println("Linea no valida");
							}
							break;
						}
					}
					System.out.println("---------------------------------------");
					System.out.println(sentence.score);
					System.out.println(sentence.text);
				}
				
				return (List<Sentence>) sentence;
			} else {
				return null;
			}

		} catch (IOException e) {
			System.out.println("Wrong file name. File " + filename + " can not be open.");
			return null;
		}
	}

	/*
	 * Implement this method in Part 2
	 */
	public static Set<Word> allWords(List<Sentence> sentences) {

		return null;

	}

	/*
	 * Implement this method in Part 3
	 */
	public static Map<String, Double> calculateScores(Set<Word> words) {

		return null;

	}

}
