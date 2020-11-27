package p4_group_8_repo.SceneClasses.HighScore.HighScoreControlers;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;

/***
 *    Title: Making a simple high-score system
 *    Author: Shaddix
 *    Date: Aug 27 2009
 *    Code version: 1.0
 *    Availability: http://forum.codecall.net/topic/50071-ystem/
 *    This Class is to get and sort the scores and write it in to a file
 */
public class HighscoreManager {
    /***
     * Hold an ArrayList of Score
     */
    private ArrayList<Score> scores;
    /***
     * Hold a string of the path for the data file
     */
    private static String HIGHSCORE_FILE = null;
    /***
     * Hold the outputStream of the file
     */
    ObjectOutputStream outputStream = null;
    /***
     * Hold the inputStream of the file
     */
    ObjectInputStream inputStream = null;

    /***
     * Set the file path and allocate a space for the scores array list
     * @param whichHighScore_file the path to the file
     */
    public HighscoreManager(String whichHighScore_file) {
        HIGHSCORE_FILE = whichHighScore_file;
        scores = new ArrayList<Score>();
    }

    /***
     * Add get Score from the file and add it into the score list and sort the list according to largest to the lowest and then save it into the file
     * @param score the new score
     */
    public void addScore(int score) {
        loadScoreFile();
        scores.add(new Score(score));
        sortListAndReverse();
        updateScoreFile();
    }

    /***
     * load and input the data of the file into the score arraylist
     */
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
    /***
     * Update the file with the new score
     * it will only will store the top 10 scores
     */
    public void updateScoreFile() {
        try {
            outputStream = new ObjectOutputStream(new FileOutputStream(HIGHSCORE_FILE));
            ArrayList<Score> tempScoreList = new ArrayList<Score>();
            for (int i = 0 ; i < scores.size() ; i++){
                tempScoreList.add(scores.get(i));
                if (i>10){
                    break;
                }
            }
            outputStream.writeObject(tempScoreList);
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

    /***
     * to get the scores in the list
     * @return return the array list of score
     */
    public ArrayList<Score> getHighscoreList() {
        loadScoreFile();
        sortListAndReverse();
        return scores;
    }

    /***
     * Sorts the array list Scores from largest to the lowest
     */
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