import java.util.ArrayList;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Menu:");
            System.out.println("1. Statistical Analysis");
            System.out.println("2. Sentiment Analysis");
            System.out.println("3. Article Richness Comparison");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine();

            if (choice == 1) {
                // Statistical Analysis
                System.out.print("Enter the file path for statistical analysis: ");
                String statsFilePath = scanner.nextLine();
                Handler statsHandler = new Handler(statsFilePath, 1);
                statsHandler.readAndCleanFile();
                statsHandler.computeWordFrequencies();
                statsHandler.sortWordData();
                statsHandler.displayStatistics();
            } else if (choice == 2) {
                // Sentiment Analysis
                System.out.print("Enter the file path for sentiment analysis: ");
                String sentimentFilePath = scanner.nextLine();
                Handler sentimentHandler = new Handler(sentimentFilePath, 1);
                sentimentHandler.readAndCleanFile();
                sentimentHandler.computeWordFrequencies();
                sentimentHandler.sortWordData();
                sentimentHandler.performSentimentAnalysis();
            } else if (choice == 3) {
                // Article Richness Comparison
                System.out.print("Enter the file path for the first article: ");
                String filePath1 = scanner.nextLine();
                System.out.print("Enter the file path for the second article: ");
                String filePath2 = scanner.nextLine();
                System.out.print("Enter the file path for the third article: ");
                String filePath3 = scanner.nextLine();

                Handler file1 = new Handler(filePath1, 1);
                Handler file2 = new Handler(filePath2, 2);
                Handler file3 = new Handler(filePath3, 3);

                file1.readAndCleanFile();
                file1.computeWordFrequencies();
                file2.readAndCleanFile();
                file2.computeWordFrequencies();
                file3.readAndCleanFile();
                file3.computeWordFrequencies();

                richnessComparison(file1, file2, file3);
            } else if (choice == 4) {
                // Exit
                System.out.println("Exiting program. Goodbye!");
                break;
            } else {
                System.out.println("Invalid choice. Please try again.");
            }
        }

        scanner.close();
    }

    public static void richnessComparison(Handler file1, Handler file2, Handler file3) {
        int file1vocab = file1.getUniqueWords();
        int file2vocab = file2.getUniqueWords();
        int file3vocab = file3.getUniqueWords();
        if (file1vocab > file2vocab && file1vocab > file3vocab) {
            System.out.println("File 1 has the richest vocabulary with " + file1vocab + " unique words.");
        } else if (file2vocab > file1vocab && file2vocab > file3vocab) {
            System.out.println("File 2 has the richest vocabulary with " + file2vocab + " unique words.");
        } else if (file3vocab > file1vocab && file3vocab > file2vocab) {
            System.out.println("File 3 has the richest vocabulary with " + file3vocab + " unique words.");
        } else {
            System.out.println("There is a tie for the richest vocabulary.");
        }
    }
}




//public class Main {
//    public static void main(String[] args) {
//        //you may also need to implement a function for number of words in the calculations thing
//        Handler file1 = new Handler("C:/CODE/WLAB/gta6news.txt",1);
////        file1.processingNComputations();
//
//        //always call read and clean before anyting
//
//        //OPTION 1 STATISTICAL ANALYSIS
//        file1.readAndCleanFile();
//        file1.computeWordFrequencies();
//        file1.sortWordData();
//        file1.displayStatistics();
////
//
////        System.out.println("Sentiment Analysis");
//
//        //OPTION 2  SENTIMENT ANALYSIS
//        file1.readAndCleanFile();
//        file1.computeWordFrequencies();
//        file1.sortWordData();
//        file1.performSentimentAnalysis();
//
//
//        //OPTION 3 ARTICLE RICHNESS COMPARISON
//        //ask the use for 3 articles, their filepaths and their number 1,2 or 3
//        //then it automatically performs all of this
//
////need to do this before you compare richly
//        file1.readAndCleanFile();
//        file1.computeWordFrequencies();
//
//        Handler file2 = new Handler("C:/CODE/WLAB/gta6news1.txt",2);
////        file2.processingNComputations();
//        file2.readAndCleanFile();
//        file2.computeWordFrequencies();
//        Handler file3 = new Handler("C:/CODE/WLAB/gta6news2.txt",3);
////        file3.processingNComputations();
//
//        //prints which has the richest vocab with the number of words
//        file3.readAndCleanFile();
//        file3.computeWordFrequencies();
//        richnessComparison(file1,file2,file3);
//        //make sure to be able to select the output of specific stats
//
//
//
//
////        System.out.println("----------------------------------------------");
////        System.out.println("Richest Vocabulary Test of the Three Articles:");
//        // you need to input 3 files for the comparison.
////        richnessComparison(file1,file2,file3);
//
//    }
//    public static void richnessComparison(Handler file1,Handler file2,Handler file3){
//        int file1vocab = file1.getUniqueWords();
//        int file2vocab = file2.getUniqueWords();
//        int file3vocab = file3.getUniqueWords();
//        if (file1vocab > file2vocab && file1vocab > file3vocab) {
//            System.out.println("File 1 has the richest vocabulary with " + file1vocab + " unique words.");
//        } else if (file2vocab > file1vocab && file2vocab > file3vocab) {
//            System.out.println("File 2 has the richest vocabulary with " + file2vocab + " unique words.");
//        } else if (file3vocab > file1vocab && file3vocab > file2vocab) {
//            System.out.println("File 3 has the richest vocabulary with " + file3vocab + " unique words.");
//        } else {
//            System.out.println("There is a tie for the richest vocabulary.");
//        }
//    }
//}
