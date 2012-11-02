import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

/******************
 * WordsearchGenerator class
 * 
 * Uses the WordGenerator class to generate random words
 * Arrange the words randomly in a wordsearch board which is represented by a 2D String array
 * 
 * @author Sarah Chan
 *
 ******************/

public class WordsearchGenerator {

	private int numOfWords;	//Number of words in the wordsearch
	private String board[][]; //[row] [col]
	private WordGenerator generator;
	private ArrayList<String> listOfWords = new ArrayList<String>();
	private int length;
	
	public WordsearchGenerator(int numOfWords, int length){
		generator = new WordGenerator();
		this.numOfWords = numOfWords;
		this.length = length;
	}

	/**
	 * Sets up the wordsearch grid by generating random words and inserting them into the 2D board array
	 */
	public void setUp(){
		int numGenerated = 0;
		
		//Create 2D array that represent the board
		board = new String[length][length];
		
		Random rand = new Random();
		
		while(numGenerated < numOfWords){
			
			ArrayList<Integer> randRow = new ArrayList<Integer>();
			ArrayList<Integer> randCol = new ArrayList<Integer>();
			
			String word =generator.generateWord();
			listOfWords.add(word);

			//determine if the word will be vertical or horizontal
			boolean vertical;
			int n = (rand.nextInt())%2;
			if(n == 0)
				vertical = true;
			else
				vertical = false;
			
			
			//generate a row 0 to the length - 1
			if(vertical){
				
				for(int i = 0; i<length; i++){
					randCol.add(i);
				}
				
				for(int j = 0; j<(length-word.length()); j++){
					randRow.add(j);
				}
				Collections.shuffle(randCol, new Random());
				Collections.shuffle(randRow, new Random());
				
				for(int j = 0; j < randCol.size(); j++){
					boolean success = false;
					for(int i = 0; i < randRow.size(); i++){
						int r = randRow.get(i);
						
						//check if the spots are empty in the 2d array
						boolean haveRoom = true;
						for(int k = 0; k < word.length(); k++){
							if(board[k+r][randCol.get(j)]!=null){
								//check for overlapping letters
								if(!board[k+r][randCol.get(j)].equals(word.substring(k, k+1))){
									haveRoom = false;
									break;
								}
							}
						}
						//if there's room, insert the word
						if(haveRoom){
							//insert each letter in the word into the board
							for(int k = 0; k < word.length(); k++){
								board[k+r][randCol.get(j)] = word.substring(k, k+1);
							}
							success = true;
							break;
						}
					}
					if(success)
						break;
				}
			}else{
				for(int i = 0; i<length; i++){
					randRow.add(i);
				}
				
				for(int j = 0; j<length-word.length(); j++){
					randCol.add(j);
				}
				
				Collections.shuffle(randCol, new Random());
				Collections.shuffle(randRow, new Random());
				
				for(int j = 0; j < randRow.size(); j++){
					boolean success = false;
					for(int i = 0; i < randCol.size(); i++){
						int c = randCol.get(i);
						
						//check if the spots are empty in the 2d array
						boolean haveRoom = true;
						for(int k = 0; k < word.length(); k++){
							if(board[randRow.get(j)][k+c]!=null){
								//check for overlapping letters
								if(!board[randRow.get(j)][k+c].equals(word.substring(k, k+1))){
									haveRoom = false;
									break;
								}
							}
						}
						//if there's room, insert the word
						if(haveRoom){
							//insert each letter in the word into the board
							for(int k = 0; k < word.length(); k++){
								board[randRow.get(j)][k+c] = word.substring(k, k+1);
							}
							success = true;
							break;
						}
					}
					if(success)
						break;
				}
			}
			numGenerated++;
		}
	}
	

	/**
	 * Accessor for the number of words
	 * @return numOfWords
	 */
	public int getNumOfWords() {
		return numOfWords;
	}

	/**
	 * Set the variable numOfWords to the given param
	 * @param numOfWords - the number of words
	 */
	public void setNumOfWords(int numOfWords) {
		this.numOfWords = numOfWords;
	}

	/**
	 * Accessor for the wordsearch board variable
	 * @return board - the 2D String array that represent the wordsearch board
	 */
	public String[][] getBoard() {
		return board;
	}

	/**
	 * Accessor the the list of words that were generated
	 * @return listOfWords - the list of words
	 */
	public ArrayList<String> getListOfWords() {
		return listOfWords;
	}

}
