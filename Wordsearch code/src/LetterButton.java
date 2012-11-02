import java.awt.Color;
import java.awt.Dimension;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

/******************
 * LetterButton class
 * 
 * Customized JButton that contain a single letter the x and y position it is in the Wordsearch
 * Button also changes s
 * 
 * @inherits JButton
 * @author Sarah Chan
 *
 ******************/

public class LetterButton extends JButton{
	
	private String letter; //letter that is displayed on the button
	private boolean selected; //
	private int xPos; //the wordsearch row the button is on
	private int yPos; //the wordsearch column the button is on
	private boolean foundWord; //true if the button is part of a word and was "found" by user
	
	
	//Constructor
	public LetterButton(String letter, int xP, int yP){
		super(letter);
		this.letter = letter;
		xPos = xP;
		yPos = yP;
		setPreferredSize(new Dimension(30, 30));
		setMargin(new Insets(0, 0, 0, 0));
		setSelected(false);
		
	}
	
	/**
	 * Toggle the LetterButton to be selected or unselected
	 * If the button was unselected, it becomes selected
	 * If the button was selected, it becomes unselected
	 */
	public void toggle(){
		setSelected(!selected);
	}
	
	public void setLetter(String l){
		letter = l.substring(0,1);
		setText(letter);
	}
	
	/**
	 * Accessor of the letter variable
	 * @return the letter variable
	 */
	public String getLetter(){
		return letter;
	}
	
	/**
	 * Modifier of the selected variable
	 * Set if the button was selected or not
	 * If button is selected, the colour of it is darker
	 * Otherwise if not, then the button would be white or cyan, 
	 * depending if it's part of a found word or not
	 * @param s - the boolean variable of selected
	 */
	public void setSelected(boolean s){
		this.selected = s;
		if(s)
			setBackground(new Color(0xe6, 0xe6, 0xe6));
		else if(foundWord)
			setBackground(Color.CYAN);
		else
			setBackground(Color.WHITE);
	}
	
	/**
	 * Accessor of the selected variable
	 * @return selected variable
	 */
	public boolean getSelected(){
		return selected;
	}
	
	/**
	 * Accessor of the xPos variable
	 * @return xPos - the x position of the button
	 */
	public int getXPos(){
		return xPos;
	}
	
	/**
	 * Modifier of the xPos variable
	 * @param x,  the new value of xPos
	 */
	public void setXPos(int x){
		xPos = x;
	}
	
	/**
	 * Accessor of the yPos variable
	 * @return yPos - the y position of the button
	 */
	public int getYPos(){
		return yPos;
	}
	
	/**
	 * Modifier of the yPos variable
	 * @param y,  the new value of yPos
	 */
	public void setYPos(int y){
		yPos = y;
	}

	/**
	 * Accessor for the found word variable
	 * @return foundWord variable
	 */
	public boolean isFoundWord() {
		return foundWord;
	}

	/**
	 * Modifier for the found word variable
	 * If the new value is true, change the button colour into cyan
	 * @param foundWord - the new value of the foundWord variable
	 */
	public void setFoundWord(boolean foundWord) {
		this.foundWord = foundWord;
		if(foundWord)
			setBackground(Color.CYAN);
	}

}
