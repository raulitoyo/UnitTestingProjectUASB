import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Analyzer {
	/*
	 * Implement this method in Part 1
	 */
	public static List<Sentence> readFile(String filename) {
		Sentence sentence = new Sentence(0, null);

		List<String> list = new ArrayList<>();
		try {
			List<String> lines = Files.readAllLines(Paths.get(filename), StandardCharsets.UTF_8);
			list.addAll(lines);
		} catch (IOException e) {
			System.out.println("Wrong file name. File " + filename + " can not be open.");
		}

		for(int i=0;i<list.size();i++) {
			System.out.println(list.get(i));
			sentence.score = i;
			sentence.text = list.get(i);
		}

		return (List<Sentence>) sentence;
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
