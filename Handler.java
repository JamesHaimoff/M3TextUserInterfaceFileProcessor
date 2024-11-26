import java.util.ArrayList;

public class Handler {
    private String filepath;
    private int articleNumber;
    private int uniqueWords;
    private String[] words;
    private Integer[] counts;
    private ArrayList<String> cleanedFileContent; // Class-level variable for cleaned file content

    public Handler(String filepath, int articleNumber) {
        this.filepath = filepath;
        this.articleNumber = articleNumber;
    }

    // Main processing method that orchestrates the workflow
    public void processingNComputations() {
        System.out.println("Article " + this.articleNumber + " Information Display:");
        readAndCleanFile(); // Store cleaned file content
        computeWordFrequencies(); // No parameter needed
        sortWordData();
        displayStatistics();
        performSentimentAnalysis();
    }

    // Step 1: Read and clean the file
    public void readAndCleanFile() {
        ReadingFiles fileProcessor = new ReadingFiles();
        this.cleanedFileContent = fileProcessor.completeClean(filepath); // Store in class-level variable
    }

    // Step 2: Compute word frequencies
    public void computeWordFrequencies() {
//        if (this.cleanedFileContent == null) {
//            throw new IllegalStateException("File content must be cleaned before computing word frequencies.");
//        }
        Object[] result = Calculations.countWordFrequency(this.cleanedFileContent);
        this.words = (String[]) result[0];
        this.counts = (Integer[]) result[1];
        this.uniqueWords = this.words.length;
//        System.out.println(this.uniqueWords);
//        System.out.println("The unique words in your article is: " + this.uniqueWords);
    }

    // Step 3: Sort the word data
    public void sortWordData() {
        Statistics statistics = new Statistics();
        statistics.bubbleSortArrays(words, counts);
//        statistics.displayStatistics();

    }

    // Step 4: Display statistics
    public void displayStatistics() {
        Statistics statistics = new Statistics();
        statistics.displayStatistics(words, counts);
//        System.out.println("Unique Words Count: " + uniqueWords);
    }

    // Step 5: Perform sentiment analysis
    public void performSentimentAnalysis() {
        positiveNegative sentimentAnalyzer = new positiveNegative();
        sentimentAnalyzer.vocabCalculation(words, counts);
    }

    // Getter for unique words count
    public int getUniqueWords() {
        return this.uniqueWords;
    }
}
