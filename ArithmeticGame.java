import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import java.util.Random;


/* Author: Jeannine Elmasri COME BACK AND CHANGE ATTEMPTS TO SCORE AND CHANGE ORDER OF ANSWERS SO ITS NOT ALL THE FIRST ONE */

public class ArithmeticGame {

    JFrame window;
    Container con;
    JPanel titleNamePanel, mainNamePanel, startButtonPanel, mainTextPanel, choiceButtonPanel, playerPanel;    
    JLabel titleNameLabel, mainNameLabel, statsLabel, statsLabelNumber, levelLabel, levelLabelNumber;
    Font titleFont = new Font("Times New Roman", Font.PLAIN,  60);
    Font normalFont = new Font("Times New Roman", Font.PLAIN, 30);
    JButton startButton, choice1, choice2, choice3, choice4;
    JTextArea mainTextArea, mainNameText;

    titleScreenHandler tsHandler = new titleScreenHandler();
    choiceHandler choice = new choiceHandler();

    int score;
    int level;
    Random rand = new Random();
    int randNumOne = rand.nextInt(1,5);
    int randNumTwo = rand.nextInt(5,9);
    int randNumThree = rand.nextInt(1,11);
    int randNumFour = rand.nextInt(11, 21);
     int randNumFive = rand.nextInt(21,35);
    int randNumSix = rand.nextInt(35, 51);
    String position;

    public static void main (String[] args) {
        new ArithmeticGame();
    }
    public ArithmeticGame(){

        window = new JFrame();
        window.setSize(800, 600);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.getContentPane().setBackground(Color.black);
        window.setLayout(null);
        window.setVisible(true);
        con = window.getContentPane();



        titleNamePanel = new JPanel();
        titleNamePanel.setBounds(100, 100, 600, 100);
        //creates space for title text
        titleNamePanel.setBackground(Color.black);
        titleNameLabel = new JLabel("ARITHMETIC GAME");
        titleNameLabel.setForeground(Color.white);

        mainNamePanel = new JPanel();
        mainNamePanel.setBounds(70, 200, 650, 200);
        mainNamePanel.setBackground(Color.black);
        mainNameLabel = new JLabel();
        mainNameLabel.setForeground(Color.white);


        mainNameText = new JTextArea();
        mainNameText.setBounds(200, 150, 600, 250);
        mainNameText.setBackground(Color.black);
        mainNameText.setForeground(Color.white);
        mainNameText.setFont(normalFont);
        mainNameText.setLineWrap(true);
        mainNamePanel.add(mainNameText);
       
        startButtonPanel = new JPanel();
        startButtonPanel.setBounds(300, 400, 200, 100);
        startButtonPanel.setBackground(Color.black);

        startButton = new JButton();
        startButton = new JButton("START");
        startButton.setBackground(Color.black);
        //foreground is color of text of button
        startButton.setForeground(Color.white);
        startButton.setFont(normalFont);
        startButton.addActionListener(tsHandler);
        startButton.setFocusPainted(false);

        titleNamePanel.add(titleNameLabel);
        titleNameLabel.setFont(titleFont);
        mainNamePanel.add(mainNameLabel);
        mainNameLabel.setFont(normalFont);

        startButtonPanel.add(startButton);
        con.add(titleNamePanel);
        con.add(mainNamePanel);
        con.add(startButtonPanel);

        MainTitle();
    }
    public void createGameScreen(){
        titleNamePanel.setVisible(false);
        startButtonPanel.setVisible(false);
        mainNamePanel.setVisible(false);
        mainTextPanel = new JPanel();
        mainTextPanel.setBounds(100, 100, 600, 250);
        mainTextPanel.setBackground(Color.black);
        con.add(mainTextPanel);



        mainTextArea = new JTextArea();
        mainTextArea.setBounds(100, 100, 600, 250);
        mainTextArea.setBackground(Color.black);
        mainTextArea.setForeground(Color.white);
        mainTextArea.setFont(normalFont);
        mainTextArea.setLineWrap(true);//keeps text in window
        mainTextPanel.add(mainTextArea);

        choiceButtonPanel = new JPanel();
        choiceButtonPanel.setBounds(250, 350, 300, 150);
        choiceButtonPanel.setBackground(Color.black);
        choiceButtonPanel.setLayout(new GridLayout(4,1));
        con.add(choiceButtonPanel);

        choice1 = new JButton("Choice 1");
        choice1.setBackground(Color.black);
        choice1.setForeground(Color.white);
        choice1.setFont(normalFont);
        choice1.setFocusPainted(false);
        choice1.addActionListener(choice);
        choice1.setActionCommand("c1");
        choiceButtonPanel.add(choice1);

        choice2 = new JButton("Choice 2");
        choice2.setBackground(Color.blue);
        choice2.setForeground(Color.white);
        choice2.setFont(normalFont);
        choice2.setFocusPainted(false);
        choice2.addActionListener(choice);
        choice2.setActionCommand("c2");
        choiceButtonPanel.add(choice2);

        choice3 = new JButton("Choice 3");
        choice3.setBackground(Color.green);
        choice3.setForeground(Color.white);
        choice3.setFont(normalFont);
        choice3.setFocusPainted(false);
        choice3.addActionListener(choice);
        choice3.setActionCommand("c3");
        choiceButtonPanel.add(choice3);

        //stats of player
        playerPanel = new JPanel();
        playerPanel.setBounds(100, 15, 600, 50);
        playerPanel.setBackground(Color.blue);
        playerPanel.setLayout(new GridLayout(1, 4));
        con.add(playerPanel);

        statsLabel = new JLabel("Score: ");
        statsLabel.setFont(normalFont);
        statsLabel.setForeground(Color.white);
        playerPanel.add(statsLabel);

        statsLabelNumber = new JLabel();
        statsLabelNumber.setFont(normalFont);
        statsLabelNumber.setForeground(Color.white);
        playerPanel.add(statsLabelNumber);

        levelLabel = new JLabel("Level: ");
        levelLabel.setFont(normalFont);
        levelLabel.setForeground(Color.white);
        playerPanel.add(levelLabel);

        levelLabelNumber = new JLabel();
        levelLabelNumber.setFont(normalFont);
        levelLabelNumber.setForeground(Color.white);
        playerPanel.add(levelLabelNumber);

        playerSetup();
    }
    public void playerSetup(){
        score = 0;
        level= 1;
        statsLabelNumber.setText("" + score);
        levelLabelNumber.setText("" + level);
        levelOneQuestionOne();
    }
    public void MainTitle(){
        mainNameText.setText("       Welcome to the Arithmetic Game!\n       Level One is Addition and Subtraction.\n       Level Two is Multiplication and Division ");
    }

    public void levelOneQuestionOne(){
        position = "levelOneQuestionOne";
        mainTextArea.setText("                   Welcome to Level One!\n\n                        What is 5 + 5?");
        choice1.setText("10");
        choice2.setText("" + randNumOne);
        choice3.setText("" + randNumTwo);
    }
    public void ten(){
        position = "ten";
        score++;
        mainTextArea.setText("Great Job! On to the next question!");
        statsLabelNumber.setText("" + score);
        choice1.setText(">>");
        choice2.setText("");
        choice3.setText("");
    }
    public void incorrectOne(){
        position = "incorrectOne";
        mainTextArea.setText("Nope, that's wrong. Try again");
        choice1.setText(">>");
        choice2.setText("");
        choice3.setText("");
    }
    
    public void levelOneQuestionTwo(){
        position = "levelOneQuestionTwo";
        mainTextArea.setText("\n\n                 What is 10 + 21?");
        choice2.setText("21");
        choice1.setText("" + randNumThree);
        choice3.setText("" + randNumFour);
    }
    
    public void twentyOne(){
        position = "twentyOne";
        score++;
        mainTextArea.setText("Good!");
        statsLabelNumber.setText("" + score);
        choice1.setText(">>");
        choice2.setText("");
        choice3.setText("");
    }

    public void incorrectTwo(){
        position = "incorrectTwo";
        mainTextArea.setText("Nope, that's wrong. Try again");
        choice1.setText(">>");
        choice2.setText("");
        choice3.setText("");
    }

    
 public void levelOneQuestionThree(){
        position = "levelOneQuestionThree";
        mainTextArea.setText("\n\n                 What is 25 + 26?");
        choice3.setText("51");
        choice2.setText("" + randNumThree);
        choice1.setText("" + randNumFour);
    }
public void fiftyOne(){
    position = "fiftyOne";
    mainTextArea.setText("Good job!\nNow you're on to Level 2\nMultiplication and Division");
    level++;
    score++;
    statsLabelNumber.setText("" + score);
    levelLabelNumber.setText("" + level);
    choice1.setText(">>");
    choice2.setText("");
    choice3.setText("");
}   
public void incorrectThree(){
    position = "incorrectThree";
    mainTextArea.setText("No. Try again.");
    choice1.setText(">>");
    choice2.setText("");
    choice3.setText("");
}


 public void levelTwoQuestionOne(){
        position = "levelTwoQuestionOne";
        mainTextArea.setText("\n\n                 What is 9 times 3?");
        choice3.setText("27");
        choice2.setText("" + randNumThree);
        choice1.setText("" + randNumFour);
 }
 public void twentySeven(){
    position = "twentySeven";
    score ++;
    mainTextArea.setText("Excellent. Keep going!");
    statsLabelNumber.setText("" + score);
    choice1.setText(">>");
    choice2.setText("");
    choice3.setText("");
 }
 public void incorrectFour(){
    position = "incorrectFour";
        mainTextArea.setText("Not quite. Try again.");
        choice1.setText(">>");
        choice2.setText("");
        choice3.setText("");
 }

public void levelTwoQuestionTwo(){
        position = "levelTwoQuestionTwo";
        mainTextArea.setText("\n\n                 What is 8 times 11?");
        choice1.setText("88");
        choice2.setText("" + randNumThree);
        choice3.setText("" + randNumFour);
 }
 public void eightyEight(){
        position = "eightyEight";
        score ++;
        mainTextArea.setText("Excellent. Keep going!");
        statsLabelNumber.setText("" + score);
        choice1.setText(">>");
        choice2.setText("");
        choice3.setText("");
 }
 public void incorrectFive(){
        position = "incorrectFive";
        mainTextArea.setText("Not quite. Try again.");
        choice1.setText(">>");
        choice2.setText("");
        choice3.setText("");
 }

 public void levelTwoQuestionThree(){
        position = "levelTwoQuestionThree";
        mainTextArea.setText("\n\n                 What is 12 times 11?");
        choice1.setText("121");
        choice2.setText("" + randNumThree);
        choice3.setText("" + randNumFour);
 }
 public void oneHundred(){
        position = "oneHundred";
        score ++;
        mainTextArea.setText("Excellent.\nYou have finished the Arithmetic Game.\nYou may now exit the game.");
        statsLabelNumber.setText("" + score);
        choice1.setText(">>");
        choice2.setText("");
        choice3.setText("");
 }
 public void incorrectSix(){
        position = "incorrectSix";
        mainTextArea.setText("Not quite. Try again.");
        choice1.setText(">>");
        choice2.setText("");
        choice3.setText("");
 }
 


    public class titleScreenHandler implements ActionListener{
        public void actionPerformed(ActionEvent event){
            createGameScreen(); 
        }
    }

    public class choiceHandler implements ActionListener{
        public void actionPerformed(ActionEvent event){
            String yourChoice = event.getActionCommand();
            
            switch(position){
            case "levelOneQuestionOne":
                switch(yourChoice){
                case"c1": ten(); break;                     //level one question
                case"c2": incorrectOne(); break;
                case "c3": incorrectOne(); break;
                }
            break;
            case("ten"):
                switch(yourChoice){
                    case "c1": levelOneQuestionTwo(); break;          //if user chooses right answer move on to question two
                }
            break;
            case "incorrectOne":
                switch(yourChoice){
                    case "c1": levelOneQuestionOne(); break;           //go back to question one
        
                }
            break;
           
            case "levelOneQuestionTwo":
                switch(yourChoice){
                                
                    case"c1": incorrectTwo(); break;  
                    case"c2": twentyOne(); break;          //level one question two
                    case "c3": incorrectTwo(); break;
                }
            break;

            case "twentyOne":
                switch (yourChoice){
                    case "c1": levelOneQuestionThree(); break;    // if user chooses right answer go to question three
                }
            break;
            
            case "incorrectTwo":
                switch (yourChoice){
                    case "c1": levelOneQuestionTwo(); break;    //go back to question 2
                }
            break;
            
            case "levelOneQuestionThree":
                switch(yourChoice){
                                
                    case"c1": incorrectThree(); break;  
                    case"c2": incorrectThree(); break;          //level one question two
                    case "c3": fiftyOne(); break;
                }
            break;
            case "incorrectThree":
                switch(yourChoice){
                    case "c1": levelOneQuestionThree(); break;
                }
            break;
            case "fiftyOne":
                switch(yourChoice){
                    case "c1": levelTwoQuestionOne(); break;
                }
            break;
                
            case "levelTwoQuestionOne":
                switch(yourChoice){    
                    case"c1": incorrectFour(); break;  
                    case"c2": incorrectFour(); break;          //level one question two
                    case "c3": twentySeven(); break;
                }
            break;
            case "incorrectFour":
                switch(yourChoice){
                    case "c1": levelTwoQuestionOne(); break;
                }
            break;
            case "twentySeven":
                switch(yourChoice){
                    case "c1": levelTwoQuestionTwo(); break;
                }
            break;
        

             case "levelTwoQuestionTwo":
                switch(yourChoice){    
                    case"c3": incorrectFive(); break;  
                    case"c2": incorrectFive(); break;         
                    case "c1": eightyEight(); break;
                }
            break;
            case "incorrectFive":
                switch(yourChoice){
                    case "c1": levelTwoQuestionTwo(); break;
                }
            break;
            case "eightyEight":
                switch(yourChoice){
                    case "c1": levelTwoQuestionThree(); break;
                }
            break;

             case "levelTwoQuestionThree":
                switch(yourChoice){    
                    case"c3": incorrectSix(); break;  
                    case"c2": incorrectSix(); break;          //level one question two
                    case "c1": oneHundred(); break;
                }
            break;
            case "incorrectSix":
                switch(yourChoice){
                    case "c1": levelTwoQuestionThree(); break;
                }
            break;
            
            }


        }
    }
}






