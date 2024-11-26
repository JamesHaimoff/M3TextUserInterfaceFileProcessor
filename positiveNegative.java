import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class positiveNegative {
    public void vocabCalculation(String[] words, Integer[] counts) {
        // Predefined size for lexicon arrays
        String[] lexiconWords = new String[10000];
        double[] lexiconScores = new double[10000];
        int index = 0;

        String filePath = "C:/CODE/WLAB/ReadingFiles/src/lexicon_scores.txt";


        //load all of the file data into arrays with words and their corresponding scores

        //reading in files
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;

            //if info in line not null
            while ((line = br.readLine()) != null) {
                String[] parts = line.split("\t");

                //saving to word and score of string arrays 0 and 1
                if (parts.length == 2) {
                    String word = parts[0].toLowerCase();
                    String scoreStr = parts[1];
                    //need as double
                    double score = 0.0;

                    //if there is an issue catch and ignore
                    try {
                        score = Double.parseDouble(scoreStr);
                    } catch (NumberFormatException ignored) {
                        continue;
                    }

                    lexiconWords[index] = word;
                    lexiconScores[index] = score;
                    index++;
                }
            }
        } catch (IOException e) {
            System.out.println("Error reading the lexicon file.");
            return;
        }

        // Initialize positive and negative values
        double positiveValue = 0.0;
        double negativeValue = 0.0;


        //
        for (int i = 0; i < words.length; i++) {
            String word = words[i].toLowerCase();
            int count = counts[i];
            //checking if it equals and getting the scores for the calculation per each article
            for (int j = 0; j < index; j++) {
                if (word.equals(lexiconWords[j])) {
                    double score = lexiconScores[j];
                    if (score > 0) {
                        positiveValue += score * count;
                    } else {
                        negativeValue += score * count;
                    }
                    break;
                }
            }
        }

        // Display results
        System.out.println("_______________________________________");
        System.out.println("Performing Sentiment Analysis...");
        System.out.println("Total Positive Value: " + positiveValue);
        System.out.println("Total Negative Value: " + negativeValue);
        if (positiveValue+negativeValue > 0) {
            System.out.println("The article is more positive than negative.");
            System.out.println("The final value comparison is: "+ (positiveValue+negativeValue));
        } else if (0 > positiveValue+negativeValue) {
            System.out.println("The article is more negative than positive." );
            System.out.println("The final value comparison is: "+ (positiveValue+negativeValue));
        } else {
            System.out.println("The article has a balanced sentiment.");
            System.out.println("The final value comparison is: "+ (positiveValue+negativeValue));

        }
        System.out.println("_______________________________________");

    }
}
