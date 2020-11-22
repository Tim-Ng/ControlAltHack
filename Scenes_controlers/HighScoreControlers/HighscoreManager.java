package p4_group_8_repo.Scenes_controlers.HighScoreControlers;

import p4_group_8_repo.Object_Controlers.Digit;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;

public class HighscoreManager {
    // An arraylist of the type "score" we will use to work with the scores inside the class
    private ArrayList<Score> scores;
    // The name of the file where the highscores will be saved
    private static String HIGHSCORE_FILE = null;

    //Initialising an in and outputStream for working with the file
    ObjectOutputStream outputStream = null;
    ObjectInputStream inputStream = null;

    public HighscoreManager(String whichHighScore_file) {
        HIGHSCORE_FILE = whichHighScore_file;
        //initialising the scores-arraylist
        scores = new ArrayList<Score>();
    }
    private void sort() {
        ScoreComparator comparator = new ScoreComparator();
        Collections.sort(scores, comparator);
    }
    public void addScore(int score) {
        loadScoreFile();
        scores.add(new Score(score));
        sortListAndReverse();
        updateScoreFile();
    }
    public void loadScoreFile() {
        try {
            inputStream = new ObjectInputStream(new FileInputStream(HIGHSCORE_FILE));
            scores = (ArrayList<Score>) inputStream.readObject();
        } catch (FileNotFoundException e) {
            System.out.println("[Laad] FNF Error: " + e.getMessage());
        } catch (IOException e) {
            System.out.println("[Laad] IO Error: " + e.getMessage());
        } catch (ClassNotFoundException e) {
            System.out.println("[Laad] CNF Error: " + e.getMessage());
        } finally {
            try {
                if (outputStream != null) {
                    outputStream.flush();
                    outputStream.close();
                }
            } catch (IOException e) {
                System.out.println("[Laad] IO Error: " + e.getMessage());
            }
        }
    }
    public void updateScoreFile() {
        try {
            outputStream = new ObjectOutputStream(new FileOutputStream(HIGHSCORE_FILE));
            outputStream.writeObject(scores);
        } catch (FileNotFoundException e) {
            System.out.println("[Update] FNF Error: " + e.getMessage() + ",the program will try and make a new file");
        } catch (IOException e) {
            System.out.println("[Update] IO Error: " + e.getMessage());
        } finally {
            try {
                if (outputStream != null) {
                    outputStream.flush();
                    outputStream.close();
                }
            } catch (IOException e) {
                System.out.println("[Update] Error: " + e.getMessage());
            }
        }
    }
    public ArrayList<Score> getHighscoreList() {
        loadScoreFile();
        sortListAndReverse();
        return scores;
    }
    public void sortListAndReverse(){
        for (int i = 0; i < scores.size()-1; i++)
        {
            for(int j = 0; j < scores.size()-1; j++)
            {
                if(scores.get(j).getScore() > scores.get(j + 1).getScore())
                {
                    Collections.swap(scores,(j+1),j);
                }
            }
        }
        Collections.reverse(scores);
    }
}