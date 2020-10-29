/*
 * Author: Ronak Trivedi
 * Date: 10/10/20
 * Purpose: This program simulate a lottery style game called Keno, which is driven by user input 
 * 
 * 
 */
/*
 * Utility Imports
 */
import java.util.HashMap;
import java.util.Random;
import java.util.ArrayList;
/*
 * FX Imports
 */
import javafx.util.Duration;
import javafx.animation.KeyFrame;
import javafx.animation.PauseTransition;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.event.EventType;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.control.MenuBar;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuItem;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.geometry.Rectangle2D;
import javafx.geometry.Pos;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import javafx.stage.Screen;

//Main class
public class JavaFXTemplate extends Application {
	
	/*
	 * Constant strings to be used in the spots and drawing choice boxes
	 */
	static final String oneSpot = "1 Spot";
	static final String fourSpots = "4 Spots";
	static final String eightSpots = "8 Spots";
	static final String tenSpots = "10 Spots";
	static final String oneDraw = "1 draw";
	static final String twoDraws = "2 draws";
	static final String threeDraws = "3 draws";
	static final String fourDraws = "4 draws";

	
	//Buttons
	Button playButton; //Declaring the button to begin the game
	Button playAgain; //Declaring the button to begin a new bet card
	Button exitHome; //Declaring the button to return to the home screen
	Button randomPicks; //Declaring the button to select random picks for the user
	Button clearPicks; //Declaring the button to clear the current picks and start over
	Button confirmSpots; //Declaring the button to submit the user's desired number of spots to play
	Button confirmDrawings; //Declaring the button to submit the user's desired number draws to play the current bet card
	Button confirmStart; //Declaring the button to submit the user's desired number of spots to play
	Button returnHome; //Declaring a button to return to the home screen
	Button returnHome1; //Declaring a button to return to the home screen
	Button returnToGame; //Declaring a button to return to the game from the odds
	Button returnToGame1; //Declaring a button to return to the game from the rules
	Button nextDrawing1; //Declaring a button to move to the next drawing
	Button nextDrawing2; //Declaring a button to move to the next drawing
	Button nextDrawing3; //Declaring a button to move to the next drawing
	Button nextDrawing4; //Declaring a button to move to the next drawing
	
	//EventHandlers
	EventHandler<ActionEvent> pressedPlay; //Declaring an event handler to handle the event when user presses the play button
	EventHandler<ActionEvent> backHome; //Declaring an event handler to handle the event when user presses the return home button
	EventHandler<ActionEvent> backToGame; //Declaring an event handler to handle the event when user presses the return to game button
	EventHandler<ActionEvent> pressedOdds; //Declaring an event handler to handle the event when user presses the odds button on the home screen
	EventHandler<ActionEvent> pressedOdds1; //Declaring an event handler to handle the event when user presses the odds button on the game screen
	EventHandler<ActionEvent> pressedRules; //Declaring an event handler to handle the event when user presses the rules button 
	EventHandler<ActionEvent> pressedExit; //Declaring an event handler to handle the event when user presses the exit button 
	EventHandler<ActionEvent> exitingHome; //Declaring an event handler to handle the event when user presses the return home button 
	
	//TextFields
	private TextField choiceBoxAnswer; //Displays number of spots to be played
	private TextField choiceBoxInstructions1; //Displays the spot selection rules
	private TextField choiceBoxInstructions2; //Displays the spot selection rules
	private TextField choiceBoxAnswer1; //Displays number of drawings to play the current bet card
	private TextField choiceBoxInstructions3; //Displays the drawings selection rules
	private TextField choiceBoxInstructions4; //Displays the drawings selection rules
	private TextField picks; //Displays the users picks
	private TextField picksLabel; //Label for the user picks display field
	private TextField drawing1Label; //Label for the drawings display field
	private TextField drawing2Label; //Label for the drawings display field
	private TextField drawing3Label; //Label for the drawings display field
	private TextField drawing4Label; //Label for the drawings display field
	private TextField kenoWelcome; //Welcome text on home screen
	private TextField drawing1; //Displays the current round's drawings
	private TextField drawing2; //Displays the current round's drawings
	private TextField drawing3; //Displays the current round's drawings
	private TextField drawing4; //Displays the current round's drawings
	private TextField matches1; //Displays the current round's matches
	private TextField matches2; //Displays the current round's matches
	private TextField matches3; //Displays the current round's matches
	private TextField matches4; //Displays the current round's matches
	private TextField numMatches1; //Displays the number of matches in the current round
	private TextField numMatches2; //Displays the number of matches in the current round
	private TextField numMatches3; //Displays the number of matches in the current round
	private TextField numMatches4; //Displays the number of matches in the current round
	private TextField numMatches1Label; //Label for the number of matches display field
	private TextField numMatches2Label; //Label for the number of matches display field
	private TextField numMatches3Label; //Label for the number of matches display field
	private TextField numMatches4Label; //Label for the number of matches display field
	private TextField matches1Label; //Label for the current matches display field
	private TextField matches2Label; //Label for the current matches display field
	private TextField matches3Label; //Label for the current matches display field
	private TextField matches4Label; //Label for the current matches display field
	private TextField totalWinnings; //Displays the users accumulated winnings throughout the life of the program
	private TextField drawingAmount1Label; //Label for the current drawing winnings display field
	private TextField drawingAmount2Label; //Label for the current drawing winnings display field
	private TextField drawingAmount3Label; //Label for the current drawing winnings display field
	private TextField drawingAmount4Label; //Label for the current drawing winnings display field
	private TextField drawingAmount1; //Displays the current drawing winnings 
	private TextField drawingAmount2; //Displays the current drawing winnings 
	private TextField drawingAmount3; //Displays the current drawing winnings 
	private TextField drawingAmount4; //Displays the current drawing winnings 
	private TextField totalAmount1; //Displays the users accumulated winnings throughout the life of the program
	private TextField totalAmount2; //Displays the users accumulated winnings throughout the life of the program
	private TextField totalAmount3; //Displays the users accumulated winnings throughout the life of the program
	private TextField totalAmount4; //Displays the users accumulated winnings throughout the life of the program
	private TextField totalAmount1Label; //Label for the total winnings display
	private TextField totalAmount2Label; //Label for the total winnings display
	private TextField totalAmount3Label; //Label for the total winnings display
	private TextField totalAmount4Label; //Label for the total winnings display
	private TextField separator1; //Text field to be colored and used for design
	private TextField separator2; //Text field to be colored and used for design
	private TextField separator3; //Text field to be colored and used for design
	private TextField separator4; //Text field to be colored and used for design
	
	//Labels
	private Label rulesList; //Label to contain the rules list on the home page
	private Label rulesList1; //Label to contain the rules list on the game page
	
	//Booleans
	private boolean spotsChosen = false; //Variable to indicate whether the user has chosen a number of spots to play
	private boolean drawingsChosen = false; //Variable to indicate whether the user has chosen a number of drawings to play the current bet card
	private boolean picksChosen = false; //Variable to indicate whether the user has chosen their final picks
	private boolean started = false; //Variable to indicate whether the user has started the game
	
	//Counters/Integers
	private Integer currently;
	private Integer randomNum; //Integer to hold current random number
	private Integer randPick; //Integer to hold current random pick
	private int currentDrawNum; //Integer to hold current number in the drawing
	private int numSpots; //Number of spots to be played chosen by the user
	private int numDrawings; //Number to indicate the number of drawings chosen by the user
	private int current_pick;
	private int numPicks = 0; //Number of picks selected currently
	private int numDisabled = 0; //Number of buttons disabled on the grid
	private int currentWinAmount; //Current winnings on the current drawing
	private int totalWinAmount = 0; //Total winnings of the user throughout the programs current run
	
	private int numMatches; //Number of matches in current drawing
	
	//Menu Setup
	MenuBar menu_bar1; //Menu bar on home screen
	Menu theMenu; //Menu bar option on the menu bar on home screen
	MenuItem rules; //Menu option on the menu on the menu bar on home screen
	MenuItem odds; //Menu option on the menu on the menu bar on home screen
	MenuItem exitGame; //Menu option on the menu on the menu bar on home screen
	
	MenuItem rules1; //Menu bar on game screen
	MenuItem odds1; //Menu bar option on the menu bar on game screen
	MenuItem exitGame1; //Menu option on the menu on the menu bar on game screen
	MenuItem newLook; //Menu option on the menu on the menu bar on game screen
	Menu theMenu1; //Menu option on the menu on the menu bar on game screen
	
	//BorderPanes
	private BorderPane game_bp; //Declaring a border pane to align objects on the game screen
	private BorderPane odds_bp; //Declaring a border pane to align objects on the odds screen
	private BorderPane odds1_bp; //Declaring a border pane to align objects on the odds screen
	
	//GridPane
	GridPane GridPane; //Declaring the grid pane to hold buttons
	
	//HBox/VBox
	private VBox vb; //Declaring a VBox to hold objects in a vertical order
	private HBox hb; //Declaring a HBox to hold objects in a vertical order
	VBox z1; //Declaring a VBox to hold an HBox
	VBox z2; //Declaring a VBox to hold an HBox
	VBox z3; //Declaring a VBox to hold an HBox
	VBox z4; //Declaring a VBox to hold an HBox
	HBox options_box; //HBox to hold choice boxes
	HBox hb2; //Random HBox
	VBox grand_vb; //Declaring VBox to hold all other boxes
	
	//ChoiceBox/MenuBar
	ChoiceBox<String> cb,cb2; //Choice boxes for the spots and drawings options
	MenuBar menu_bar; //Declaring the menu bar to store different options
	
	//ArrayLists
	ArrayList<Integer> currentPicks = new ArrayList<Integer>(); //ArrayList holding the current numbers picked
	ArrayList<Integer> winningPicks = new ArrayList<Integer>(); //ArrayList to hold the current winning picks
	ArrayList<Button> gridButtons; //ArrayList holding all 80 buttons on the GridPane
	ArrayList<Integer> whichMatches = new ArrayList<Integer>(); //Storing which matches were made on the current drawing
	
	//HashMap
	HashMap<String, Scene> sceneMap; //Declaring the HashMap to store the different scenes
	
	//Strings
	private String userPicks; //String to hold the users current picks
	private String currentWinners; //String to hold the current winning picks
	private String yourMatches; //String to hold the current round's matches
	private String rulesText; //String to hold text for the rules screen

	//Random instance
	Random randomGenerator; //Random number generator for the picks
	Random random1; //Random number generator for the winning numbers
	
	//Rectangle to obtain user screen size
	Rectangle2D user_screen_dimensions;
	
	//Timeline transition
	Timeline pausing1;
	Timeline pausing2;
	Timeline pausing3;
	Timeline pausing4;
	
	
	Integer tempNum;
	int index;
	
	//Main method
	public static void main(String[] args) {

		// TODO Auto-generated method stub
		launch(args);
	}
	
	@Override
	public void start(Stage primaryStage) throws Exception 
	{
		primaryStage.setTitle("Keno!"); //Setting the title
		sceneMap = new HashMap<String, Scene>(); //Initializing the scene map
	
		//Rules of the game
		rulesText = "Rules:\n" + 
				"\n" + 
				"	1) Select how many spots to play for the your bet card (1, 4, 8, or 10 spots)\n" + 
				"\n" + 
				"	2) Select how many drawings you want to play for your bet card (1, 2, 3, or 4 drawings)\n" + 
				"\n" + 
				"	3) Select your desired picks from the yellow number grid (picks include numbers 1 through 80) or select ‘Random Picks’\n" + 
				"\n" + 
				"	4) You can change the number of spots to play, number of drawings, and your picks at any time before selecting ‘Confirm Picks and Start Game’\n" + 
				"\n" + 
				"	5) Select ‘Confirm Picks and Start Game’ to begin the drawings\n" + 
				"\n" + 
				"	6) To begin the next drawing select ’Next Drawing’\n" + 
				"\n" + 
				"	7) Select ‘Play Again’ to restart the game with a new bet card, new number of spots to play, and new number of drawings\n" + 
				"";
		
		//Labels for the rules screen
		rulesList = new Label();
		rulesList.setText(rulesText);
		rulesList.setStyle("-fx-font-weight: bold; -fx-font-size: 27; -fx-text-fill: Maroon;-fx-font-family: Impact; -fx-background-color: transparent; -fx-border-color: transparent;");
		rulesList1 = new Label();
		rulesList1.setText(rulesText);
		rulesList1.setStyle("-fx-font-weight: bold; -fx-font-size: 27; -fx-text-fill: Maroon;-fx-font-family: Impact; -fx-background-color: transparent; -fx-border-color: transparent;");
		
		/*
		 * Initializing and designing the welcome message
		 */
		kenoWelcome = new TextField("Welcome to Keno!");
		kenoWelcome.setEditable(false);
		kenoWelcome.setStyle("-fx-font-weight: bold; -fx-font-size: 95; -fx-text-fill: SandyBrown;-fx-font-family: Chalkduster; -fx-background-color: transparent; -fx-border-color: transparent;-fx-effect: dropshadow(gaussian,IndianRed,9,.5,9,9)");
		
		/*
		 * Initializing, designing, and aligning the play button
		 */
		playButton = new Button("Play Now!"); //Initializing the start game button
		playButton.setMaxSize(350, 125);
		playButton.setStyle("-fx-font-size: 45;-fx-text-stroke:teal;-fx-text-stroke-width:3; -fx-text-fill:linear-gradient(from 0% 100% to 100% 200%, repeat, IndianRed 5%, DarkOliveGreen 50%);-fx-font-family: Impact; -fx-background-color: SandyBrown; -fx-border-color: SeaGreen; -fx-border-width:7px");
		playButton.setOnAction(backHome);		
		
		/*
		 * Initializing the menu bar and all of its options
		 */
		menu_bar1 = new MenuBar();  
		menu_bar1.setStyle("-fx-font-family: Impact;-fx-font-size: 15; -fx-text-fill: #00C8ff;-fx-background-color: SeaGreen; -fx-border-color: SandyBrown; -fx-border-width:4px");
		theMenu = new Menu("Menu");
		theMenu.setStyle("-fx-text-fill:linear-gradient(from 0% 100% to 100% 200%, repeat, IndianRed 5%, DarkOliveGreen 50%);-fx-font-family: Impact;-fx-font-size: 15; -fx-background-color: SandyBrown; -fx-border-color: teal; -fx-border-width:4px");
		rules = new MenuItem("View Rules");
		rules.setStyle("-fx-font-family: Impact;-fx-font-size: 15; -fx-text-fill: IndianRed; -fx-background-color: SandyBrown; -fx-border-color: teal; -fx-border-width:4px");
		odds = new MenuItem("View Odds");
		odds.setStyle("-fx-font-family: Impact;-fx-font-size: 15; -fx-text-fill: IndianRed; -fx-background-color: SandyBrown; -fx-border-color: teal; -fx-border-width:4px");
		exitGame = new MenuItem("Exit Game"); 
		exitGame.setStyle("-fx-font-family: Impact;-fx-font-size: 15; -fx-text-fill: IndianRed; -fx-background-color: SandyBrown; -fx-border-color: teal; -fx-border-width:4px");
		
		theMenu.getItems().addAll(rules,odds,exitGame); //Adding menu items to the menu
		menu_bar1.getMenus().addAll(theMenu); //Adding the menu to the menu bar
		/*
		 *  
		 */
		/*
		 * Initializing the menu bar and all of its options
		 */
		menu_bar1 = new MenuBar();  
		menu_bar1.setStyle("-fx-font-family: Impact;-fx-font-size: 15; -fx-text-fill: #00C8ff;-fx-background-color: SeaGreen; -fx-border-color: SandyBrown; -fx-border-width:4px");
		theMenu = new Menu("Menu");
		theMenu.setStyle("-fx-text-fill:linear-gradient(from 0% 100% to 100% 200%, repeat, IndianRed 5%, DarkOliveGreen 50%);-fx-font-family: Impact;-fx-font-size: 15; -fx-background-color: SandyBrown; -fx-border-color: teal; -fx-border-width:4px");
		rules = new MenuItem("View Rules");
		rules.setStyle("-fx-font-family: Impact;-fx-font-size: 15; -fx-text-fill: IndianRed; -fx-background-color: SandyBrown; -fx-border-color: teal; -fx-border-width:4px");
		odds = new MenuItem("View Odds");
		odds.setStyle("-fx-font-family: Impact;-fx-font-size: 15; -fx-text-fill: IndianRed; -fx-background-color: SandyBrown; -fx-border-color: teal; -fx-border-width:4px");
		exitGame = new MenuItem("Exit Game"); 
		exitGame.setStyle("-fx-font-family: Impact;-fx-font-size: 15; -fx-text-fill: IndianRed; -fx-background-color: SandyBrown; -fx-border-color: teal; -fx-border-width:4px");
		
		theMenu.getItems().addAll(rules,odds,exitGame); //Adding menu items to the menu
		menu_bar1.getMenus().addAll(theMenu); //Adding the menu to the menu bar
		/*
		 *  
		 */
		menu_bar = new MenuBar();  
		menu_bar.setStyle("-fx-font-family: Impact;-fx-font-size: 15; -fx-text-fill: #00C8ff;-fx-background-color: SeaGreen; -fx-border-color: SandyBrown; -fx-border-width:4px");
		theMenu1 = new Menu("Menu");
		theMenu1.setStyle("-fx-text-fill:linear-gradient(from 0% 100% to 100% 200%, repeat, IndianRed 5%, DarkOliveGreen 50%);-fx-font-family: Impact;-fx-font-size: 15; -fx-background-color: SandyBrown; -fx-border-color: teal; -fx-border-width:4px");
		rules1 = new MenuItem("View Rules");
		rules1.setStyle("-fx-font-family: Impact;-fx-font-size: 15; -fx-text-fill: IndianRed; -fx-background-color: SandyBrown; -fx-border-color: teal; -fx-border-width:4px");
		odds1 = new MenuItem("View Odds");
		odds1.setStyle("-fx-font-family: Impact;-fx-font-size: 15; -fx-text-fill: IndianRed; -fx-background-color: SandyBrown; -fx-border-color: teal; -fx-border-width:4px");
		exitGame1 = new MenuItem("Exit Game"); 
		exitGame1.setStyle("-fx-font-family: Impact;-fx-font-size: 15; -fx-text-fill: IndianRed; -fx-background-color: SandyBrown; -fx-border-color: teal; -fx-border-width:4px");
		newLook = new MenuItem("New Look");
		newLook.setStyle("-fx-font-family: Impact;-fx-font-size: 15; -fx-text-fill: IndianRed; -fx-background-color: SandyBrown; -fx-border-color: teal; -fx-border-width:4px");
		
		theMenu1.getItems().addAll(rules1,odds1,exitGame1,newLook); //Adding menu items to the menu
		menu_bar.getMenus().addAll(theMenu1); //Adding the menu to the menu bar
		
		sceneMap.put("odds", createOddsScreen()); //Putting the odds screen on the scene map
		sceneMap.put("odds2", createOddsScreen2()); //Putting the odds screen on the scene map
		sceneMap.put("home", createHomeScreen()); //Putting the home screen on the scene map
		sceneMap.put("game", createGameScreen()); //Putting the game play screen on the scene map
		sceneMap.put("rules", createRulesScreen()); //Putting the rules screen on the scene map
		sceneMap.put("rules2", createRulesScreen2()); //Putting the rules screen on the scene map
		
		//Play button handler
		pressedPlay = new EventHandler<ActionEvent>(){
			public void handle(ActionEvent event){
				//Button b = (Button)event.getSource();
				primaryStage.setScene(sceneMap.get("game"));
		
			}
		};
		
		//Home button handler, used by multiple buttons
		backHome = new EventHandler<ActionEvent>(){
			public void handle(ActionEvent event){
				//Button b = (Button)event.getSource();
				primaryStage.setScene(sceneMap.get("home"));
		
			}
		};
		//Home button handler, used by multiple buttons
		backToGame = new EventHandler<ActionEvent>(){
			public void handle(ActionEvent event){
				//Button b = (Button)event.getSource();
				primaryStage.setScene(sceneMap.get("game"));
		
			}
		};
	
		returnHome.setOnAction(new EventHandler<ActionEvent>() {
			//Changing the scene to the home screen upon a button click
			public void handle(ActionEvent a) 
			{
				primaryStage.setScene(sceneMap.get("home"));
				
			}			
		});
		returnHome1.setOnAction(new EventHandler<ActionEvent>() {
			//Changing the scene to the home screen upon a button click
			public void handle(ActionEvent a) 
			{
				primaryStage.setScene(sceneMap.get("home"));
				
			}			
		});
		exitGame.setOnAction(new EventHandler<ActionEvent>() {
			//Changing the scene to the home screen upon a button click
			public void handle(ActionEvent a) 
			{
				Platform.exit();
				System.exit(0);
				
			}			
		});
		exitingHome = new EventHandler<ActionEvent>() {
			//Changing the scene to the home screen upon a button click
			public void handle(ActionEvent a) 
			{
				numSpots = 0;
				numDrawings = 0;
				confirmStart.setVisible(false);
				randomPicks.setVisible(false);
				clearPicks.setVisible(false);
				options_box.setVisible(false);
				picks.setVisible(false);
				picksLabel.setVisible(false);
				currentPicks.clear();
				userPicks = "";
				picksChosen = false;
				spotsChosen = false;
				drawingsChosen = false;
				choiceBoxAnswer.clear();
				choiceBoxAnswer1.clear();
				started=false;
				
				z1.setVisible(false);
				z2.setVisible(false);
				z3.setVisible(false);
				z4.setVisible(false);
				primaryStage.setScene(sceneMap.get("home"));
				
			}			
		};
		//Exiting the game
		exitGame1.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent a) 
			{
				Platform.exit();
				System.exit(0);
				
			}			
		});
		returnToGame.setOnAction(new EventHandler<ActionEvent>() {
			//Changing the scene to the game screen upon a button click
			public void handle(ActionEvent a) 
			{
				primaryStage.setScene(sceneMap.get("game"));
				
			}			
		});
		returnToGame1.setOnAction(new EventHandler<ActionEvent>() {
			//Changing the scene to the game screen upon a button click
			public void handle(ActionEvent a) 
			{
				primaryStage.setScene(sceneMap.get("game"));
				
			}			
		});
		
		/*
		* Setting actions to change the scene
		*/
		playButton.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent a) 
			{
				sceneMap.put("game", createGameScreen()); //Putting the game play screen on the scene map
				primaryStage.setScene(sceneMap.get("game"));
				
			}			
		});
		
		odds.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent a) 
			{
				primaryStage.setScene(sceneMap.get("odds"));
			}			
		});
		odds1.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent a) 
			{
				primaryStage.setScene(sceneMap.get("odds2"));
			}			
		});
		rules.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent a) 
			{
				primaryStage.setScene(sceneMap.get("rules"));
			}			
		});
		
		rules1.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent a) 
			{
				primaryStage.setScene(sceneMap.get("rules2"));
			}			
		});
		
		//This action changes the entire look of the game screen
		newLook.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent a) 
			{
				separator1.setStyle("-fx-background-color: linear-gradient(from 100% 5% to 95% 195%, repeat, Green 0%, GoldenRod 60%)");
				separator4.setStyle("-fx-background-color: linear-gradient(from 100% 5% to 95% 195%, repeat, Green 0%, GoldenRod 60%)");
				separator3.setStyle("-fx-background-color: linear-gradient(from 100% 5% to 95% 195%, repeat, Green 0%, GoldenRod 60%)");
				separator2.setStyle("-fx-background-color: linear-gradient(from 100% 5% to 95% 195%, repeat, Green 0%, GoldenRod 60%)");
				game_bp.setStyle("-fx-background-color: linear-gradient(from 100% 5% to 95% 195%, repeat, SteelBlue 0%, GoldenRod 60%)"); //Coloring the game screen background
				choiceBoxInstructions1.setStyle("-fx-background-color: IndianRed;-fx-text-fill:white;-fx-font-family:Impact");
				choiceBoxInstructions2.setStyle("-fx-background-color: IndianRed;-fx-text-fill:white;-fx-font-family:Impact");
				choiceBoxInstructions3.setStyle("-fx-background-color: IndianRed;-fx-text-fill:white;-fx-font-family:Impact");
				choiceBoxInstructions4.setStyle("-fx-background-color: IndianRed;-fx-text-fill:white;-fx-font-family:Impact");
				choiceBoxAnswer.setStyle("-fx-background-color: MediumPurple;-fx-text-fill:white;-fx-font-family:Impact");
				choiceBoxAnswer1.setStyle("-fx-background-color: MediumPurple;-fx-text-fill:white;-fx-font-family:Impact");
				cb.setStyle("-fx-background-color: MediumPurple;-fx-text-fill:white;-fx-font-family:Impact");
				cb2.setStyle("-fx-background-color: MediumPurple;-fx-text-fill:white;-fx-font-family:Impact");
				picksLabel.setStyle("-fx-background-color: transparent;-fx-text-fill:Maroon;-fx-font-size:15;-fx-font-family:Impact");
				picks.setStyle("-fx-background-color: transparent;-fx-text-fill:Maroon;-fx-font-size:15;-fx-font-family:Impact");
				hb2.setStyle("-fx-border-color:blue;-fx-border-weight:50");
				grand_vb.setStyle("-fx-border-color:blue;-fx-border-weight:50");
				playAgain.setStyle("-fx-font-size: 27;-fx-text-stroke:teal;-fx-text-stroke-width:3; -fx-text-fill:LightBlue;-fx-font-family: Impact; -fx-background-color: LightGoldenRodYellow; -fx-border-color: LightCoral; -fx-border-width:7px");
				exitHome.setStyle("-fx-font-size: 27;-fx-text-stroke:teal;-fx-text-stroke-width:3; -fx-text-fill:LightBlue;-fx-font-family: Impact; -fx-background-color: LightGoldenRodYellow; -fx-border-color: LightCoral; -fx-border-width:7px");
				
				
				drawing1.setStyle("-fx-background-color: DarkGray;-fx-text-fill:IndianRed;-fx-font-size:15;-fx-font-family:Impact");
				drawing2.setStyle("-fx-background-color: DarkGray;-fx-text-fill:IndianRed;-fx-font-size:15;-fx-font-family:Impact");
				drawing3.setStyle("-fx-background-color: DarkGray;-fx-text-fill:IndianRed;-fx-font-size:15;-fx-font-family:Impact");
				drawing4.setStyle("-fx-background-color: DarkGray;-fx-text-fill:IndianRed;-fx-font-size:15;-fx-font-family:Impact");
				
				drawingAmount1.setStyle("-fx-background-color: DarkGray;-fx-text-fill:IndianRed;-fx-font-size:15;-fx-font-family:Impact");
				drawingAmount2.setStyle("-fx-background-color: DarkGray;-fx-text-fill:IndianRed;-fx-font-size:15;-fx-font-family:Impact");
				drawingAmount3.setStyle("-fx-background-color: DarkGray;-fx-text-fill:IndianRed;-fx-font-size:15;-fx-font-family:Impact");
				drawingAmount4.setStyle("-fx-background-color: DarkGray;-fx-text-fill:IndianRed;-fx-font-size:15;-fx-font-family:Impact");
				
				totalAmount1.setStyle("-fx-background-color: DarkGray;-fx-text-fill:IndianRed;-fx-font-size:15;-fx-font-family:Impact");
				totalAmount2.setStyle("-fx-background-color: DarkGray;-fx-text-fill:IndianRed;-fx-font-size:15;-fx-font-family:Impact");
				totalAmount3.setStyle("-fx-background-color: DarkGray;-fx-text-fill:IndianRed;-fx-font-size:15;-fx-font-family:Impact");
				totalAmount4.setStyle("-fx-background-color: DarkGray;-fx-text-fill:IndianRed;-fx-font-size:15;-fx-font-family:Impact");
				
				matches1.setStyle("-fx-background-color: DarkGray;-fx-text-fill:IndianRed;-fx-font-size:15;-fx-font-family:Impact");
				matches2.setStyle("-fx-background-color: DarkGray;-fx-text-fill:IndianRed;-fx-font-size:15;-fx-font-family:Impact");
				matches3.setStyle("-fx-background-color: DarkGray;-fx-text-fill:IndianRed;-fx-font-size:15;-fx-font-family:Impact");
				matches4.setStyle("-fx-background-color: DarkGray;-fx-text-fill:IndianRed;-fx-font-size:15;-fx-font-family:Impact");
				
				for(Button b: gridButtons)
				{
					b.setStyle("-fx-background-color: MediumPurple;-fx-text-fill: NavajoWhite; -fx-border-color: NavajoWhite;-fx-border-weight: 30;-fx-font-family:Impact");
				}
				
				drawing1Label.setStyle("-fx-background-color: DarkOrchid;-fx-text-fill:white;-fx-font-family:Impact");
				
				drawing2Label.setStyle("-fx-background-color: DarkOrchid;-fx-text-fill:white;-fx-font-family:Impact");
				
				drawing3Label.setStyle("-fx-background-color: DarkOrchid;-fx-text-fill:white;-fx-font-family:Impact");
				
				drawing4Label.setStyle("-fx-background-color: DarkOrchid;-fx-text-fill:white;-fx-font-family:Impact");
	
				matches1Label.setStyle("-fx-background-color: DarkOrchid;-fx-text-fill:white;-fx-font-family:Impact");
		
				matches2Label.setStyle("-fx-background-color: DarkOrchid;-fx-text-fill:white;-fx-font-family:Impact");
		
				matches3Label.setStyle("-fx-background-color: DarkOrchid;-fx-text-fill:white;-fx-font-family:Impact");
		
				matches4Label.setStyle("-fx-background-color: DarkOrchid;-fx-text-fill:white;-fx-font-family:Impact");
				
			
				numMatches1Label.setStyle("-fx-background-color: DarkOrchid;-fx-text-fill:white;-fx-font-family:Impact");
			
				numMatches2Label.setStyle("-fx-background-color: DarkOrchid;-fx-text-fill:white;-fx-font-family:Impact");
		
				numMatches3Label.setStyle("-fx-background-color: DarkOrchid;-fx-text-fill:white;-fx-font-family:Impact");
			
				numMatches4Label.setStyle("-fx-background-color: DarkOrchid;-fx-text-fill:white;-fx-font-family:Impact");
				
			
				drawingAmount1Label.setStyle("-fx-background-color: DarkOrchid;-fx-text-fill:white;-fx-font-family:Impact");
				
				drawingAmount2Label.setStyle("-fx-background-color: DarkOrchid;-fx-text-fill:white;-fx-font-family:Impact");
				
				drawingAmount3Label.setStyle("-fx-background-color: DarkOrchid;-fx-text-fill:white;-fx-font-family:Impact");
				
				drawingAmount4Label.setStyle("-fx-background-color: DarkOrchid;-fx-text-fill:white;-fx-font-family:Impact");
			
				totalAmount1Label.setStyle("-fx-background-color: DarkOrchid;-fx-text-fill:white;-fx-font-family:Impact");
			
				totalAmount2Label.setStyle("-fx-background-color: DarkOrchid;-fx-text-fill:white;-fx-font-family:Impact");
				
				totalAmount3Label.setStyle("-fx-background-color: DarkOrchid;-fx-text-fill:white;-fx-font-family:Impact");
				
				totalAmount4Label.setStyle("-fx-background-color: DarkOrchid;-fx-text-fill:white;-fx-font-family:Impact");
				
				totalAmount1.setStyle("-fx-background-color: DarkGray;-fx-text-fill:white;-fx-font-family:Impact");
				
				totalAmount2.setStyle("-fx-background-color: DarkGray;-fx-text-fill:white;-fx-font-family:Impact");
				
				totalAmount3.setStyle("-fx-background-color: DarkGray;-fx-text-fill:white;-fx-font-family:Impact");
				
				totalAmount4.setStyle("-fx-background-color: DarkGray;-fx-text-fill:white;-fx-font-family:Impact");
			}			
		});
		
		
		
		/*
		 * 
		 */
		primaryStage.setScene(sceneMap.get("home")); //Setting the start screen to be the home screen
		/*
		 * Changing the window size to the users screen size
		 */
		user_screen_dimensions = Screen.getPrimary().getVisualBounds();
		primaryStage.setX(user_screen_dimensions.getMinX());
		primaryStage.setY(user_screen_dimensions.getMinY());
		primaryStage.setWidth(user_screen_dimensions.getWidth());
		primaryStage.setHeight(user_screen_dimensions.getHeight());
		/*
		 * 
		 */
		
		
		primaryStage.show(); //Making the stage visible
		
	}
	
	public Scene createHomeScreen()
	{
		
		BorderPane home_pane = new BorderPane();
		
		HBox menu_bar_box = new HBox(menu_bar1);
		HBox hbKeno = new HBox(kenoWelcome);
		HBox hbPlay = new HBox(playButton);
		menu_bar_box.setAlignment(Pos.BASELINE_CENTER);
		hbPlay.setAlignment(Pos.BASELINE_CENTER);
		hbKeno.setAlignment(Pos.BASELINE_CENTER);
		
		VBox welcome_vb = new VBox(60,menu_bar_box,hbKeno,hbPlay);
		

		
		home_pane.setTop(welcome_vb);
		home_pane.setStyle("-fx-background-color: linear-gradient(from 100% 5% to 95% 195%, repeat, SteelBlue 0%, IndianRed 60%);"); //Coloring the home screen background
		
		
		
		return new Scene(home_pane, 850, 750);
		
	}
	
	public Scene createRulesScreen()
	{
		BorderPane rule1_pane = new BorderPane();
		
		HBox rule1_box = new HBox(rulesList);
		rule1_box.setAlignment(Pos.BASELINE_CENTER);
		
		//Return Home button and listener
		returnHome1 = new Button("Return Home"); //Initializing the start game button
		returnHome1.setMaxSize(350, 125);
		returnHome1.setStyle("-fx-font-size: 45;-fx-text-stroke:teal;-fx-text-stroke-width:3; -fx-text-fill:linear-gradient(from 0% 100% to 100% 200%, repeat, IndianRed 5%, DarkOliveGreen 50%);-fx-font-family: Impact; -fx-background-color: SandyBrown; -fx-border-color: SeaGreen; -fx-border-width:7px");
		returnHome1.setOnAction(backHome);
		
		VBox rules1_vb = new VBox(15,rule1_box,returnHome1);
		
		rule1_pane.setTop(rules1_vb);
		rule1_pane.setStyle("-fx-background-color: linear-gradient(from 100% 5% to 95% 195%, repeat, SteelBlue 0%, GoldenRod 60%);"); //Coloring the home screen background
	
		
		
		return new Scene(rule1_pane, 850, 750);
	}
	public Scene createRulesScreen2()
	{
		BorderPane rule2_pane = new BorderPane();
		
		HBox rule2_box = new HBox(rulesList1);
		rule2_box.setAlignment(Pos.BASELINE_CENTER);
		
		//Return Home button and listener
		returnToGame1 = new Button("Return to the Game!"); //Initializing the start game button
		returnToGame1.setMaxSize(450, 125);
		returnToGame1.setStyle("-fx-font-size: 45;-fx-text-stroke:teal;-fx-text-stroke-width:3; -fx-text-fill:linear-gradient(from 0% 100% to 100% 200%, repeat, IndianRed 5%, DarkOliveGreen 50%);-fx-font-family: Impact; -fx-background-color: SandyBrown; -fx-border-color: SeaGreen; -fx-border-width:7px");
		returnToGame1.setOnAction(backToGame);
		
		VBox rules2_vb = new VBox(20,rule2_box,returnToGame1);
		

		
		rule2_pane.setTop(rules2_vb);
		rule2_pane.setStyle("-fx-background-color: linear-gradient(from 100% 5% to 95% 195%, repeat, SteelBlue 0%, GoldenRod 60%);"); //Coloring the home screen background
		
		
		
		return new Scene(rule2_pane, 850, 750);
	}
	
	public Scene createOddsScreen()
	{
		//Displaying odds of winning by playing 1 spot
		Image odds1 = new Image("odds1.jpeg");
		ImageView vOdds1 = new ImageView(odds1);
		vOdds1.setFitHeight(375);
		vOdds1.setFitWidth(375);
		vOdds1.setPreserveRatio(true);
		Button oddsButton1 = new Button();
		oddsButton1.setGraphic(vOdds1);
		
		//Displaying odds of winning by playing 4 spots
		Image odds4 = new Image("odds4.jpeg");
		ImageView vOdds4 = new ImageView(odds4);
		vOdds4.setFitHeight(350);
		vOdds4.setFitWidth(350);
		vOdds4.setPreserveRatio(true);
		Button oddsButton4 = new Button();
		oddsButton4.setGraphic(vOdds4);
		
		//Displaying odds of winning by playing 8 spots
		Image odds8 = new Image("odds8.jpeg");
		ImageView vOdds8 = new ImageView(odds8);
		vOdds8.setFitHeight(320);
		vOdds8.setFitWidth(320);
		vOdds8.setPreserveRatio(true);
		Button oddsButton8 = new Button();
		oddsButton8.setGraphic(vOdds8);
		
		//Displaying odds of winning by playing 10 spots
		Image odds10 = new Image("odds10.jpeg");
		ImageView vOdds10 = new ImageView(odds10);
		vOdds10.setFitHeight(300);
		vOdds10.setFitWidth(300);
		vOdds10.setPreserveRatio(true);
		Button oddsButton10 = new Button();
		oddsButton10.setGraphic(vOdds10);
		
		
		//Odds help message
		TextField oddsMessage = new TextField();
		oddsMessage.setEditable(false);
		oddsMessage.setText("Note: The odds of winning when playing 1,4,8, or 10 spots are displayed at the bottom of the corresponding yellow boxes below.");
		oddsMessage.setMinSize(705, 30);
		oddsMessage.setStyle("-fx-background-color:linear-gradient(from 100% 5% to 95% 195%, repeat, SteelBlue 0%, IndianRed 60%);-fx-text-fill: white;-fx-font-family:arial");
		
		
		//Return Home button and listener
		returnHome = new Button("Return Home"); //Initializing the start game button
		returnHome.setMaxSize(350, 125);
		returnHome.setStyle("-fx-font-size: 45;-fx-text-stroke:teal;-fx-text-stroke-width:3; -fx-text-fill:linear-gradient(from 0% 100% to 100% 200%, repeat, IndianRed 5%, DarkOliveGreen 50%);-fx-font-family: Impact; -fx-background-color: SandyBrown; -fx-border-color: SeaGreen; -fx-border-width:7px");
		returnHome.setOnAction(backHome);
		
		//Displaying all aspects of the odds scene to the stage
		HBox oddsBox = new HBox(oddsButton1,oddsButton4,oddsButton8,oddsButton10);
		HBox helpMessageBox = new HBox(oddsMessage);
		HBox returnHomeBox = new HBox(returnHome);
		oddsBox.setAlignment(Pos.BASELINE_CENTER);
		helpMessageBox.setAlignment(Pos.BASELINE_CENTER);
		returnHomeBox.setAlignment(Pos.BASELINE_CENTER);
		VBox allOddsBoxes = new VBox(helpMessageBox,oddsBox,returnHomeBox);
		odds_bp = new BorderPane();
		odds_bp.setTop(allOddsBoxes);
		odds_bp.setStyle("-fx-background-color:linear-gradient(from 100% 5% to 95% 195%, repeat, SteelBlue 0%, IndianRed 60%)");
		
		
		return new Scene(odds_bp,900,900);
		
	}
	
	public Scene createOddsScreen2()
	{
		//Displaying odds of winning by playing 1 spot
		Image odds1 = new Image("odds1.jpeg");
		ImageView vOdds1 = new ImageView(odds1);
		vOdds1.setFitHeight(375);
		vOdds1.setFitWidth(375);
		vOdds1.setPreserveRatio(true);
		Button oddsButton1 = new Button();
		oddsButton1.setGraphic(vOdds1);
		
		//Displaying odds of winning by playing 4 spots
		Image odds4 = new Image("odds4.jpeg");
		ImageView vOdds4 = new ImageView(odds4);
		vOdds4.setFitHeight(350);
		vOdds4.setFitWidth(350);
		vOdds4.setPreserveRatio(true);
		Button oddsButton4 = new Button();
		oddsButton4.setGraphic(vOdds4);
		
		//Displaying odds of winning by playing 8 spots
		Image odds8 = new Image("odds8.jpeg");
		ImageView vOdds8 = new ImageView(odds8);
		vOdds8.setFitHeight(320);
		vOdds8.setFitWidth(320);
		vOdds8.setPreserveRatio(true);
		Button oddsButton8 = new Button();
		oddsButton8.setGraphic(vOdds8);
		
		//Displaying odds of winning by playing 10 spots
		Image odds10 = new Image("odds10.jpeg");
		ImageView vOdds10 = new ImageView(odds10);
		vOdds10.setFitHeight(300);
		vOdds10.setFitWidth(300);
		vOdds10.setPreserveRatio(true);
		Button oddsButton10 = new Button();
		oddsButton10.setGraphic(vOdds10);
		
		
		//Odds help message
		TextField oddsMessage = new TextField();
		oddsMessage.setEditable(false);
		oddsMessage.setText("Note: The odds of winning when playing 1,4,8, or 10 spots are displayed at the bottom of the corresponding yellow boxes below.");
		oddsMessage.setMinSize(705, 30);
		oddsMessage.setStyle("-fx-background-color:linear-gradient(from 100% 5% to 95% 195%, repeat, SteelBlue 0%, IndianRed 60%);-fx-text-fill: white;-fx-font-family:arial");
		
		
		//Return Home button and listener
		returnToGame = new Button("Return to Game!"); //Initializing the start game button
		returnToGame.setMaxSize(450, 125);
		returnToGame.setStyle("-fx-font-size: 45;-fx-text-stroke:teal;-fx-text-stroke-width:3; -fx-text-fill:linear-gradient(from 0% 100% to 100% 200%, repeat, IndianRed 5%, DarkOliveGreen 50%);-fx-font-family: Impact; -fx-background-color: SandyBrown; -fx-border-color: SeaGreen; -fx-border-width:7px");
		returnToGame.setOnAction(backToGame);
	
		//Displaying all aspects of the odds scene to the stage
		HBox oddsBox = new HBox(oddsButton1,oddsButton4,oddsButton8,oddsButton10);
		HBox helpMessageBox = new HBox(oddsMessage);
		HBox returnHomeBox = new HBox(returnToGame);
		oddsBox.setAlignment(Pos.BASELINE_CENTER);
		helpMessageBox.setAlignment(Pos.BASELINE_CENTER);
		returnHomeBox.setAlignment(Pos.BASELINE_CENTER);
		VBox allOddsBoxes = new VBox(helpMessageBox,oddsBox,returnHomeBox);
		odds1_bp = new BorderPane();
		odds1_bp.setTop(allOddsBoxes);
		odds1_bp.setStyle("-fx-background-color:linear-gradient(from 100% 5% to 95% 195%, repeat, SteelBlue 0%, IndianRed 60%)");
		
		
		return new Scene(odds1_bp,900,900);
		
	}
	public Scene createGameScreen()
	{
		gridButtons = new ArrayList<Button>();
		
		GridPane = new GridPane(); //Initializing a new grid pane to hold numbers 1-80
		int num = 1; //Button counter
		int currentCol = 0; //Variable to keep track of current column when initializing the grid pane
		int currentRow = 0; //Variable to keep track of current row when initializing the grid pane
		while(num<81) 
		{
			
			gridButtons.add(new Button(String.valueOf(num)));
			num++;
			
		}
		int count = 1;
		currentCol = 0;
		currentRow = 0;
		while(count<81) 
		{
			if(currentCol < 10)
			{
				GridPane.add((gridButtons.get(count-1) ),currentCol,currentRow);
				currentCol++;
				count++;
			}
			if(currentCol == 10)
			{
				currentCol = 0;
				currentRow++;
			}
		}
		
		clearPicks = new Button("Clear Picks");
		randomPicks = new Button("Random Picks");
		randomPicks.setStyle("-fx-font-family:arial");
		clearPicks.setStyle("-fx-font-family:arial");
		confirmStart = new Button("Confirm Picks and Start Game!");
		confirmStart.setStyle("-fx-background-color:blue;-fx-text-fill:white;-fx-border-color: gold;-fx-border-weight:5;-fx-font-family:arial");
		confirmStart.setVisible(false);
		
		game_bp = new BorderPane(); //Initializing the parent pane for this scene
		
		
		/*
		 * Selected picks
		 */
		picksLabel = new TextField("Your Picks:");
		picksLabel.setMaxSize(100,20);
		picksLabel.setEditable(false);
		picks = new TextField();
		picks.setEditable(false);
		picks.setMinSize(300, 25);
		
		TextField pickingHelp = new TextField();
		pickingHelp.setText("Note: To start selecting picks, confirm the number of spots you want to play.");
		pickingHelp.setStyle("-fx-background-color: LightGreen;-fx-border-color: DarkCyan;-fx-font-family:arial");
		pickingHelp.setMinSize(460, 30);
		pickingHelp.setEditable(false);
		TextField startHelp = new TextField();
		startHelp.setText("Note: To start the drawings, confirm the number of drawings you want to play this bet card for.");
		startHelp.setStyle("-fx-background-color: LightGreen;-fx-border-color: DarkCyan;-fx-font-family:arial");
		startHelp.setMinSize(540, 30);
		startHelp.setEditable(false);
		
	
		
		HBox hb0 = new HBox(pickingHelp); //Creating HBox for menu bar
		hb0.setAlignment(Pos.BASELINE_LEFT); //Aligning new HBox
		
		HBox hb1 = new HBox(menu_bar); //Creating HBox for menu bar
		hb1.setAlignment(Pos.BASELINE_CENTER); //Aligning new HBox
		
		hb2 = new HBox(GridPane); //Creating HBox for the number grid
		hb2.setAlignment(Pos.BASELINE_CENTER); //Aligning new HBox
		hb2.setStyle("-fx-border-color:maroon;-fx-border-weight:15");
		
		HBox hb3 = new HBox(picksLabel,picks,randomPicks,clearPicks,confirmStart); //Creating HBox for the number grid
		hb3.setAlignment(Pos.BASELINE_CENTER); //Aligning new HBox
		
		HBox hb4 = new HBox(startHelp); //Creating HBox for the number grid
		hb4.setAlignment(Pos.BASELINE_LEFT); //Aligning new HBox
		
		
		picks.setVisible(false);
		picksLabel.setStyle("-fx-background-color: blue;-fx-text-fill:white;-fx-font-family:arial");
		picks.setStyle("-fx-background-color: IndianRed; -fx-font-family: Impact; -fx-text-fill: wheat;-fx-font-size: 20;-fx-border-color: blue; -fx-border-weight:15");
		picksLabel.setVisible(false);
		randomPicks.setVisible(false);
		clearPicks.setVisible(false);
		VBox sub_vb1 = new VBox(hb0,hb2);
		
		
		/*
		 * Number of spots played user interface
		 */
		
		choiceBoxInstructions1 = new TextField();
		choiceBoxInstructions1.setText("Please select a number of spots to play from the drop-down menu below.");
		choiceBoxInstructions1.setMinSize(520, 30);
		choiceBoxInstructions2 = new TextField();
		choiceBoxInstructions2.setText("Note: Click the 'Confirm Number of Spots' button to verify your input.");
		choiceBoxInstructions2.setMinSize(645, 30);
		choiceBoxAnswer = new TextField();
		choiceBoxAnswer.setStyle("-fx-font-family:arial");
		choiceBoxAnswer.setText(" "); 

		choiceBoxAnswer.setMaxSize(320, 25);
		choiceBoxInstructions1.setStyle("-fx-background-color: LightGreen;-fx-border-color: DarkCyan;-fx-font-family:arial");
		choiceBoxInstructions2.setStyle("-fx-background-color: LightGreen;-fx-border-color: DarkCyan;-fx-font-family:arial");
		choiceBoxInstructions1.setEditable(false);
		choiceBoxInstructions2.setEditable(false);
		
		
		cb = new ChoiceBox<String>();
		cb.setStyle("-fx-font-family:arial");
		cb.getItems().add(oneSpot);  
		cb.getItems().add(fourSpots);
		cb.getItems().add(eightSpots);
		cb.getItems().add(tenSpots);
		confirmSpots = new Button("Confirm Number of Spots");
		confirmSpots.setStyle("-fx-font-family:arial");
		confirmSpots.setMaxSize(320, 55);
		separator1 = new TextField("");
		separator1.setEditable(false);
		separator1.setStyle("-fx-background-color: DarkCyan;-fx-text-fill: DarkCyan");
		separator4 = new TextField("");
		separator4.setEditable(false);
		separator4.setStyle("-fx-background-color: DarkCyan;-fx-text-fill: DarkCyan");
		VBox instructions = new VBox(separator1,choiceBoxInstructions1,choiceBoxInstructions2,separator4);
		VBox choice = new VBox(hb0,cb,confirmSpots);
		
		VBox spots_vb = new VBox(35,instructions,choice,choiceBoxAnswer);
		
		
		/*
		 * 
		 */
		
		/*
		 * Number of drawings for current card
		 */
		
		cb2 = new ChoiceBox<String>();
		cb2.getItems().add(oneDraw);  
		cb2.getItems().add(twoDraws);
		cb2.getItems().add(threeDraws);
		cb2.getItems().add(fourDraws);
		
		cb2.setStyle("-fx-font-family:arial");
		confirmDrawings = new Button("Confirm Number of Drawings");
		confirmDrawings.setStyle("-fx-font-family:arial");
		confirmDrawings.setMaxSize(320, 55);
		
		choiceBoxInstructions3 = new TextField();
		choiceBoxInstructions3.setText("Please select a number of drawings to play your current bet card from the drop-down menu below.");
		choiceBoxInstructions3.setMinSize(520, 30);
		choiceBoxInstructions4 = new TextField();
		choiceBoxInstructions4.setText("Note: Click the 'Confirm Number of Drawings' button to verify your input");
		choiceBoxInstructions4.setMinSize(645, 30);
		choiceBoxAnswer1 = new TextField();
		choiceBoxAnswer1.setText(" "); 
		choiceBoxAnswer1.setMaxSize(320, 25);
		choiceBoxAnswer1.setStyle("-fx-font-family:arial");
		choiceBoxInstructions3.setStyle("-fx-background-color: LightGreen;-fx-border-color: DarkCyan;-fx-font-family:arial");
		choiceBoxInstructions4.setStyle("-fx-background-color: LightGreen;-fx-border-color: DarkCyan;-fx-font-family:arial");
		choiceBoxInstructions3.setEditable(false);
		choiceBoxInstructions4.setEditable(false);
		
		separator2 = new TextField("");
		separator2.setStyle("-fx-background-color: DarkCyan;-fx-text-fill: DarkCyan");
		separator3 = new TextField("");
		separator3.setStyle("-fx-background-color: DarkCyan;-fx-text-fill: DarkCyan");
		separator2.setEditable(false);
		separator3.setEditable(false);
		VBox instructions1 = new VBox(separator2,choiceBoxInstructions3,choiceBoxInstructions4,separator3);
		VBox choice1 = new VBox(hb4,cb2,confirmDrawings);
		
		VBox drawings_vb = new VBox(35,instructions1,choice1,choiceBoxAnswer1);
		grand_vb = new VBox(50,spots_vb,drawings_vb);
		grand_vb.setStyle("-fx-border-color:maroon;-fx-border-weight:15");
		game_bp.setLeft(grand_vb);
		/*
		 * 
		 */
		/*
		 * 
		 */
		confirmSpots.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent a) 
			{
				if (started == false)
				{
					spotsChosen = true;
					for(Button b : gridButtons)
					{
						b.setDisable(false);
					}
					confirmStart.setVisible(false);
					picksChosen = false;
					numDisabled = 0;
					currentPicks = new ArrayList<Integer>();
					if (picksChosen != true)
					{
						picks.setVisible(true);
						picksLabel.setVisible(true);
						randomPicks.setVisible(true);
						clearPicks.setVisible(true);
						if(oneSpot.equals(cb.getValue()))
						{
							choiceBoxAnswer.setText(oneSpot+" Selected");
							numSpots = 1;
							numPicks = 0;
							currentPicks.clear();
							picks.setText(" ");
						}
						else if(fourSpots.equals(cb.getValue()))
						{
							choiceBoxAnswer.setText(fourSpots+" Selected");
							numSpots = 4;
							numPicks = 0;
							currentPicks.clear();
							picks.setText(" ");
						}
						else if(eightSpots.equals(cb.getValue()))
						{
							choiceBoxAnswer.setText(eightSpots+" Selected");
							numSpots = 8;
							numPicks = 0;
							currentPicks.clear();
							picks.setText(" ");
						}
						else if(tenSpots.equals(cb.getValue()))
						{
							choiceBoxAnswer.setText(tenSpots+" Selected");
							numSpots = 10;
							numPicks = 0;
							currentPicks.clear();
							picks.setText(" ");
						} 
						else
						{
							choiceBoxAnswer.setText("Nothing Selected");
							numSpots = 0;
							spotsChosen = false;
							picks.setVisible(false);
							picksLabel.setVisible(false);
							randomPicks.setVisible(false);
							clearPicks.setVisible(false);
						}
					}
				}
			}			
		});
		confirmDrawings.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent a) 
			{
				drawingsChosen = true;
				if(numSpots == numPicks && spotsChosen == true && picksChosen != true)
				{
					confirmStart.setVisible(true);
				}
				if (picksChosen != true)
				{
					
					if(oneDraw.equals(cb2.getValue()))
					{
						choiceBoxAnswer1.setText(oneDraw+" Selected");
						numDrawings = 1;
					}
					else if(twoDraws.equals(cb2.getValue()))
					{
						choiceBoxAnswer1.setText(twoDraws+" Selected");
						numDrawings = 2;
					}
					else if(threeDraws.equals(cb2.getValue()))
					{
						choiceBoxAnswer1.setText(threeDraws+" Selected");
						numDrawings = 3;
					}
					else if(fourDraws.equals(cb2.getValue()))
					{
						choiceBoxAnswer1.setText(fourDraws+" Selected");
						numDrawings = 4;
					} 
					else
					{
						choiceBoxAnswer1.setText("Nothing Selected");
					}
				}
				
			}			
		});
		/*
		 * 
		 */
		/*
		 * Clearing the current picks when the clear button is pressed
		 */
		clearPicks.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent a) 
			{
				numPicks = 0;
				currentPicks.clear();
				picks.setText(" ");
				confirmStart.setVisible(false);
				for(Button b : gridButtons)
				{
					b.setDisable(false);
				}
				numDisabled = 0;
			}			
		});
		
		/*
		 * 
		 */
		/*
		 * Selecting random picks for the user
		 */
		randomPicks.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent a) 
			{
				for(Button b : gridButtons)
				{
					b.setDisable(false);
				}
				numDisabled = numSpots;
				if(drawingsChosen == true)
					confirmStart.setVisible(true);
				numPicks = 0;
				currentPicks.clear();
				userPicks = "";
				while(currentPicks.size() < numSpots)
				{
					randomGenerator = new Random();
					randomNum = randomGenerator.nextInt(79) + 1;
					if(currentPicks.indexOf(randomNum)==-1)
					{
						currentPicks.add( randomNum );
						userPicks += (String.valueOf(randomNum) + "  ");
						picks.setText(userPicks);
						numPicks++;
					}
				}
			}			
		});
		
		/*
		 * 
		/*
		 * Setting up eventHandlers for all buttons on the GridPane
		 */
		for(Button b : gridButtons)
		{
			b.setStyle("-fx-background-color: gold;-fx-text-fill: DarkCyan; -fx-border-color:red;-fx-font-family:arial");
			final Button currentButton = b;
			currentButton.setOnAction(new EventHandler<ActionEvent>() {
				public void handle(ActionEvent a) 
				{
					if(currentPicks.indexOf(gridButtons.indexOf(b)+1)==-1 && spotsChosen == true && numPicks<numSpots)
					{
						userPicks = "";
						currentPicks.add( (gridButtons.indexOf(b)+1) );
						for(Integer p : currentPicks)
						{
							userPicks += (String.valueOf(p) + "  ");
						}
						picks.setText(userPicks);
						numPicks++;
					}
					if(spotsChosen == true && numDisabled < numSpots) 
					{
						numDisabled++;
						if(b.isDisabled())
						{
							b.setDisable(false);
						}
						else
						{
							b.setDisable(true);
						}
					}
					if(drawingsChosen == true && numDisabled == (numSpots) && picksChosen == false)
					{
						confirmStart.setVisible(true);
					}
	
				}			
			});
		}
		/*
		 * 
		 */
		drawing1Label = new TextField("Drawing #1: ");
		drawing1Label.setMaxSize(100,20);
		drawing1Label.setStyle("-fx-background-color: DarkCyan;-fx-text-fill:white;-fx-font-family: arial");
		drawing2Label = new TextField("Drawing #2: ");
		drawing2Label.setMaxSize(100,20);
		drawing2Label.setStyle("-fx-background-color: DarkCyan;-fx-text-fill:white;-fx-font-family: arial");
		drawing3Label = new TextField("Drawing #3: ");
		drawing3Label.setMaxSize(100,20);
		drawing3Label.setStyle("-fx-background-color: DarkCyan;-fx-text-fill:white;-fx-font-family: arial");
		drawing4Label = new TextField("Drawing #4: ");
		drawing4Label.setMaxSize(100,20);
		drawing4Label.setStyle("-fx-background-color: DarkCyan;-fx-text-fill:white;-fx-font-family: arial");
		
		
		matches1Label = new TextField("Drawing #1 Matches: ");
		matches1Label.setMaxSize(250,20);
		matches1Label.setStyle("-fx-background-color: DarkCyan;-fx-text-fill:white;-fx-font-family: arial");
		matches2Label = new TextField("Drawing #2 Matches: ");
		matches2Label.setMaxSize(250,20);
		matches2Label.setStyle("-fx-background-color: DarkCyan;-fx-text-fill:white;-fx-font-family: arial");
		matches3Label = new TextField("Drawing #3 Matches: ");
		matches3Label.setMaxSize(250,20);
		matches3Label.setStyle("-fx-background-color: DarkCyan;-fx-text-fill:white;-fx-font-family: arial");
		matches4Label = new TextField("Drawing #4 Matches: ");
		matches4Label.setMaxSize(250,20);
		matches4Label.setStyle("-fx-background-color: DarkCyan;-fx-text-fill:white;-fx-font-family: arial");
		
		numMatches1Label = new TextField("Number of Matches: ");
		numMatches1Label.setMaxSize(250,20);
		numMatches1Label.setStyle("-fx-background-color: DarkCyan;-fx-text-fill:white;-fx-font-family: arial");
		numMatches2Label = new TextField("Number of Matches: ");
		numMatches2Label.setMaxSize(250,20);
		numMatches2Label.setStyle("-fx-background-color: DarkCyan;-fx-text-fill:white;-fx-font-family: arial");
		numMatches3Label = new TextField("Number of Matches: ");
		numMatches3Label.setMaxSize(250,20);
		numMatches3Label.setStyle("-fx-background-color: DarkCyan;-fx-text-fill:white;-fx-font-family: arial");
		numMatches4Label = new TextField("Number of Matches: ");
		numMatches4Label.setMaxSize(250,20);
		numMatches4Label.setStyle("-fx-background-color: DarkCyan;-fx-text-fill:white;-fx-font-family: arial");
		
		drawingAmount1Label = new TextField("Drawing #1 Winnings: ");
		drawingAmount1Label.setMaxSize(270,20);
		drawingAmount1Label.setStyle("-fx-background-color: DarkCyan;-fx-text-fill:white;-fx-font-family: arial");
		drawingAmount2Label = new TextField("Drawing #2 Winnings: ");
		drawingAmount2Label.setMaxSize(270,20);
		drawingAmount2Label.setStyle("-fx-background-color: DarkCyan;-fx-text-fill:white;-fx-font-family: arial");
		drawingAmount3Label = new TextField("Drawing #3 Winnings: ");
		drawingAmount3Label.setMaxSize(270,20);
		drawingAmount3Label.setStyle("-fx-background-color: DarkCyan;-fx-text-fill:white;-fx-font-family: arial");
		drawingAmount4Label = new TextField("Drawing #4 Winnings: ");
		drawingAmount4Label.setMaxSize(270,20);
		drawingAmount4Label.setStyle("-fx-background-color: DarkCyan;-fx-text-fill:white;-fx-font-family: arial");
	
		totalAmount1Label = new TextField("Total Winnings: ");
		totalAmount1Label.setMaxSize(270,20);
		totalAmount1Label.setStyle("-fx-background-color: DarkCyan;-fx-text-fill:white;-fx-font-family: arial");
		totalAmount2Label = new TextField("Total Winnings: ");
		totalAmount2Label.setMaxSize(270,20);
		totalAmount2Label.setStyle("-fx-background-color: DarkCyan;-fx-text-fill:white;-fx-font-family: arial");
		totalAmount3Label = new TextField("Total Winnings: ");
		totalAmount3Label.setMaxSize(270,20);
		totalAmount3Label.setStyle("-fx-background-color: DarkCyan;-fx-text-fill:white;-fx-font-family: arial");
		totalAmount4Label = new TextField("Total Winnings: ");
		totalAmount4Label.setMaxSize(270,20);
		totalAmount4Label.setStyle("-fx-background-color: DarkCyan;-fx-text-fill:white;-fx-font-family: arial");
		
	/*
		drawing1Label.setVisible(false);
		drawing2Label.setVisible(false);
		drawing3Label.setVisible(false);
		drawing4Label.setVisible(false);
		*/
		drawing1Label.setEditable(false);
		drawing2Label.setEditable(false);
		drawing3Label.setEditable(false);
		drawing4Label.setEditable(false);
		
		totalAmount1Label.setEditable(false);
		totalAmount2Label.setEditable(false);
		totalAmount3Label.setEditable(false);
		totalAmount4Label.setEditable(false);
		
		drawingAmount1Label.setEditable(false);
		drawingAmount2Label.setEditable(false);
		drawingAmount3Label.setEditable(false);
		drawingAmount4Label.setEditable(false);
		

		nextDrawing2 = new Button("Begin Drawing #2");
		nextDrawing3 = new Button("Begin Drawing #3");
		nextDrawing4 = new Button("Begin Drawing #4");
		
		nextDrawing2.setStyle("-fx-background-color: GoldenRod;-fx-border-color:green;-fx-border-weight:30;-fx-font-family: arial");
		nextDrawing3.setStyle("-fx-background-color: GoldenRod;-fx-border-color:green;-fx-border-weight:30;-fx-font-family: arial");
		nextDrawing4.setStyle("-fx-background-color: GoldenRod;-fx-border-color:green;-fx-border-weight:30;-fx-font-family: arial");
		
		nextDrawing2.setVisible(false);
		nextDrawing3.setVisible(false);
		nextDrawing4.setVisible(false);
		
		drawing1 = new TextField();
		drawing2 = new TextField();
		drawing3 = new TextField();
		drawing4 = new TextField();
		
		drawing1.setStyle("-fx-font-family: arial");
		drawing2.setStyle("-fx-font-family: arial");
		drawing3.setStyle("-fx-font-family: arial");
		drawing4.setStyle("-fx-font-family: arial");
		
		drawingAmount1 = new TextField();
		drawingAmount2 = new TextField();
		drawingAmount3 = new TextField();
		drawingAmount4 = new TextField();
		
		totalAmount1 = new TextField();
		totalAmount2 = new TextField();
		totalAmount3 = new TextField();
		totalAmount4 = new TextField();
		
		totalAmount1.setStyle("-fx-font-family: arial");
		totalAmount2.setStyle("-fx-font-family: arial");
		totalAmount3.setStyle("-fx-font-family: arial");
		totalAmount4.setStyle("-fx-font-family: arial");
		
		drawingAmount1.setStyle("-fx-font-family: arial");
		drawingAmount2.setStyle("-fx-font-family: arial");
		drawingAmount3.setStyle("-fx-font-family: arial");
		drawingAmount4.setStyle("-fx-font-family: arial");

		totalAmount1.setMaxSize(90, 20);
		totalAmount2.setMaxSize(90, 20);
		totalAmount3.setMaxSize(90, 20);
		totalAmount4.setMaxSize(90, 20);
		
		drawingAmount1.setMaxSize(90, 20);
		drawingAmount2.setMaxSize(90, 20);
		drawingAmount3.setMaxSize(90, 20);
		drawingAmount4.setMaxSize(90, 20);
		
		matches1 = new TextField();
		matches2 = new TextField();
		matches3 = new TextField();
		matches4 = new TextField();
		
		matches1.setStyle("-fx-font-family: arial");
		matches2.setStyle("-fx-font-family: arial");
		matches3.setStyle("-fx-font-family: arial");
		matches4.setStyle("-fx-font-family: arial");
		
		numMatches1 = new TextField();
		numMatches2 = new TextField();
		numMatches3 = new TextField();
		numMatches4 = new TextField();
		
		numMatches1.setStyle("-fx-font-family: arial");
		numMatches2.setStyle("-fx-font-family: arial");
		numMatches3.setStyle("-fx-font-family: arial");
		numMatches4.setStyle("-fx-font-family: arial");
		
		
		drawing1.setMinSize(500, 25);
		drawing2.setMinSize(500, 25);
		drawing3.setMinSize(500, 25);
		drawing4.setMinSize(500, 25);
		
		matches1.setMinSize(400, 25);
		matches2.setMinSize(400, 25);
		matches3.setMinSize(400, 25);
		matches4.setMinSize(400, 25);
		
		numMatches1.setMaxSize(60, 20);
		numMatches2.setMaxSize(60, 20);
		numMatches3.setMaxSize(60, 20);
		numMatches4.setMaxSize(60, 20);
		
	
		totalAmount1.setEditable(false);
		totalAmount2.setEditable(false);
		totalAmount3.setEditable(false);
		totalAmount4.setEditable(false);
		
		drawing1.setEditable(false);
		drawing2.setEditable(false);
		drawing3.setEditable(false);
		drawing4.setEditable(false);
		
		matches1.setEditable(false);
		matches2.setEditable(false);
		matches3.setEditable(false);
		matches4.setEditable(false);
		
		
		HBox d1 = new HBox(drawing1Label,drawing1);
		HBox d2 = new HBox(drawing2Label,drawing2);
		HBox d3 = new HBox(drawing3Label,drawing3);
		HBox d4 = new HBox(drawing4Label,drawing4);
		
		HBox d5 = new HBox(matches1Label,matches1,numMatches1Label,numMatches1);
		HBox d6 = new HBox(matches2Label,matches2,numMatches2Label,numMatches2);
		HBox d7 = new HBox(matches3Label,matches3,numMatches3Label,numMatches3);
		HBox d8 = new HBox(matches4Label,matches4,numMatches4Label,numMatches4);
		
		HBox d9 = new HBox(drawingAmount1Label,drawingAmount1,totalAmount1Label,totalAmount1,nextDrawing2);
		HBox d10 = new HBox(drawingAmount2Label,drawingAmount2,totalAmount2Label,totalAmount2,nextDrawing3);
		HBox d11= new HBox(drawingAmount3Label,drawingAmount3,totalAmount3Label,totalAmount3,nextDrawing4);
		HBox d12 = new HBox(drawingAmount4Label,drawingAmount4,totalAmount4Label,totalAmount4);
		
		
		d1.setAlignment(Pos.BASELINE_LEFT);
		d2.setAlignment(Pos.BASELINE_LEFT);
		d3.setAlignment(Pos.BASELINE_LEFT);
		d4.setAlignment(Pos.BASELINE_LEFT);
		d5.setAlignment(Pos.BASELINE_LEFT);
		d6.setAlignment(Pos.BASELINE_LEFT);
		d7.setAlignment(Pos.BASELINE_LEFT);
		d8.setAlignment(Pos.BASELINE_LEFT);
		d9.setAlignment(Pos.BASELINE_LEFT);
		d10.setAlignment(Pos.BASELINE_LEFT);
		d11.setAlignment(Pos.BASELINE_LEFT);
		d12.setAlignment(Pos.BASELINE_LEFT);
		
		z1 = new VBox(d1,d5,d9);
		z2 = new VBox(d2,d6,d10);
		z3 = new VBox(d3,d7,d11);
		z4 = new VBox(d4,d8,d12);
		
		z1.setVisible(false);
		z2.setVisible(false);
		z3.setVisible(false);
		z4.setVisible(false);
		

		nextDrawing2.setOnAction(new EventHandler<ActionEvent>() 
		{
			public void handle(ActionEvent a) 
			{
				z2.setVisible(true);
				if(numDrawings ==2)
				{
					playAgain.setVisible(true);
					exitHome.setVisible(true);
				}
			}
		});
		nextDrawing3.setOnAction(new EventHandler<ActionEvent>() 
		{
			public void handle(ActionEvent a) 
			{
				z3.setVisible(true);
				if(numDrawings ==3)
				{
					playAgain.setVisible(true);
					exitHome.setVisible(true);
				}
			}
		});
		nextDrawing4.setOnAction(new EventHandler<ActionEvent>() 
		{
			public void handle(ActionEvent a) 
			{
				z4.setVisible(true);
				if(numDrawings ==4)
				{
					playAgain.setVisible(true);
					exitHome.setVisible(true);
				}
			}
		});
		
		
		
		
		playAgain = new Button("Play Again!"); //Initializing the play again button
		playAgain.setMaxSize(300, 30);
		playAgain.setStyle("-fx-font-size: 27;-fx-text-stroke:teal;-fx-text-stroke-width:3; -fx-text-fill:linear-gradient(from 0% 100% to 100% 200%, repeat, IndianRed 5%, DarkOliveGreen 50%);-fx-font-family: Impact; -fx-background-color: SandyBrown; -fx-border-color: SeaGreen; -fx-border-width:7px");
		playAgain.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent a) 
			{
				for(Button b : gridButtons)
				{
					b.setDisable(false);
				}
				playAgain.setVisible(false);
				exitHome.setVisible(false);
				numSpots = 0;
				numDisabled = 0;
				numDrawings = 0;
				started = false;
				confirmStart.setVisible(false);
				randomPicks.setVisible(false);
				clearPicks.setVisible(false);
				options_box.setVisible(false);
				picks.setVisible(false);
				picksLabel.setVisible(false);
				currentPicks.clear();
				userPicks = "";
				picksChosen = false;
				spotsChosen = false;
				drawingsChosen = false;
				choiceBoxAnswer.clear();
				choiceBoxAnswer1.clear();
				
				z1.setVisible(false);
				z2.setVisible(false);
				z3.setVisible(false);
				z4.setVisible(false);
				nextDrawing1.setVisible(false);
				nextDrawing1.setVisible(false);
				nextDrawing1.setVisible(false);
				nextDrawing1.setVisible(false);
				
			}
		});
		
		exitHome = new Button("Return Home!"); //Initializing the start game button
		exitHome.setMaxSize(300, 30);
		exitHome.setStyle("-fx-font-size: 27;-fx-text-stroke:teal;-fx-text-stroke-width:3; -fx-text-fill:linear-gradient(from 0% 100% to 100% 200%, repeat, IndianRed 5%, DarkOliveGreen 50%);-fx-font-family: Impact; -fx-background-color: SandyBrown; -fx-border-color: SeaGreen; -fx-border-width:7px");
		exitHome.setOnAction(exitingHome);
		
		playAgain.setVisible(false);
		exitHome.setVisible(false);
		options_box = new HBox(10,playAgain,exitHome);
		options_box.setAlignment(Pos.BASELINE_CENTER);
		options_box.setVisible(false);
		
		VBox drawings_box = new VBox(10,z1,z2,z3,z4,options_box);
		
		VBox sub_vb2 = new VBox(20,hb3,drawings_box);
		
		vb = new VBox(10,hb1,sub_vb1,sub_vb2); //Initializing the VBox with the HBoxes
		
		game_bp.setCenter(vb); //Centering the VBox
		
		EventHandler<ActionEvent> timePause = (e->{
			randPick = random1.nextInt(79) + 1;
			winningPicks.add( randPick );
			currentWinners += (String.valueOf(randPick) + "  ");
			if(currentDrawNum == 1)
			{
				drawing1.setText(currentWinners);
			}
			else if(currentDrawNum == 2)
			{
				drawing2.setText(currentWinners);
			}
			else if(currentDrawNum == 3)
			{
				drawing3.setText(currentWinners);					
			}
			else if(currentDrawNum == 4)
			{
				drawing4.setText(currentWinners);
			}
		});
			
		pausing1 = new Timeline(
				new KeyFrame(Duration.seconds(3), timePause),
				new KeyFrame(Duration.millis(5000))
				
		);
		pausing2 = new Timeline(
				new KeyFrame(Duration.seconds(3), timePause),
				new KeyFrame(Duration.millis(5000))
				
		);
		pausing3 = new Timeline(
				new KeyFrame(Duration.seconds(3), timePause),
				new KeyFrame(Duration.millis(5000))
				
		);
		pausing4 = new Timeline(
				new KeyFrame(Duration.seconds(3), timePause),
				new KeyFrame(Duration.millis(5000))
				
		);
		pausing1.setCycleCount(20);
		pausing2.setCycleCount(40);
		pausing3.setCycleCount(60);
		pausing4.setCycleCount(80);
		
		confirmStart.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent a) 
			{
				picksChosen = true;
				started = true;
				numMatches = 0;
				currentWinAmount = 0;
				currentDrawNum = 1;
				confirmStart.setVisible(false);
				randomPicks.setVisible(false);
				clearPicks.setVisible(false);
				options_box.setVisible(true);
				z1.setVisible(true);
				
				if(numDrawings==1)
				{
					nextDrawing2.setVisible(false);
					playAgain.setVisible(true);
					exitHome.setVisible(true);
				}
				if(numDrawings > 1)
				{
					nextDrawing2.setVisible(true);
				}
				if(numDrawings > 2)
				{
					nextDrawing3.setVisible(true);
					
				}
				if(numDrawings > 3)
				{
					nextDrawing4.setVisible(true);
				}
				
				
				winningPicks.clear();
				currentWinners = "";
				yourMatches = "";
				
				random1 = new Random();
				
				while(winningPicks.size() < 20 && currentDrawNum<=numDrawings)
				{
					randPick = random1.nextInt(79) + 1;
					if(winningPicks.indexOf(randPick)==-1)
					{
						winningPicks.add( randPick );
						currentWinners += (String.valueOf(randPick) + "  ");
						if(currentDrawNum == 1)
						{
							drawing1.setText(currentWinners);
						}
						else if(currentDrawNum == 2)
						{
							drawing2.setText(currentWinners);
						}
						else if(currentDrawNum == 3)
						{
							drawing3.setText(currentWinners);					
						}
						else if(currentDrawNum == 4)
						{
							drawing4.setText(currentWinners);
						}
						
		
						if(winningPicks.size() == 20)
						{
							for(Integer num : currentPicks)
							{
								if(winningPicks.indexOf(num) != -1)
								{
									numMatches++;
									whichMatches.add(num);
								}
							}
							//1 match
							if(numMatches == 0)
							{
								if(numSpots == 10)
								{
									currentWinAmount = 5;
									totalWinAmount += 5;
								}
								else
								{
									currentWinAmount = 0;
								}
							}
							//1 match
							else if(numMatches == 1)
							{
								if(numSpots == 1)
								{
									currentWinAmount = 2;
									totalWinAmount += 2;
								}
								else
								{
									currentWinAmount = 0;
								}
							}
							
							//2 matches
							else if(numMatches == 2)
							{
								if(numSpots == 4)
								{
									currentWinAmount = 1;
									totalWinAmount += 1;
								}
								else
								{
									currentWinAmount = 0;
								}
							}
							
							//3 matches
							else if(numMatches == 3)
							{
								if(numSpots == 4)
								{
									currentWinAmount = 5;
									totalWinAmount += 5;
								}
								else
								{
									currentWinAmount = 0;
								}
							}
							
							//4 matches
							else if(numMatches == 4)
							{
								if(numSpots == 4)
								{
									currentWinAmount = 75;
									totalWinAmount += 75;
								}
								else if(numSpots == 8)
								{
									currentWinAmount = 2;
									totalWinAmount += 2;
								}
								else
								{
									currentWinAmount = 0;
								}
							}
							
							//5 matches
							else if(numMatches == 5)
							{
								if(numSpots == 8)
								{
									currentWinAmount = 12;
									totalWinAmount += 12;
								}
								else if(numSpots ==10)
								{
									currentWinAmount = 2;
									totalWinAmount += 2;
								}
							}
							
							//6 matches
							else if(numMatches == 6)
							{
								if(numSpots == 8)
								{
									currentWinAmount = 50;
									totalWinAmount += 50;
								}
								else if(numSpots ==10)
								{
									currentWinAmount = 15;
									totalWinAmount += 15;
								}
							}
							
							//7 matches
							else if(numMatches == 7)
							{
								if(numSpots == 8)
								{
									currentWinAmount = 750;
									totalWinAmount += 750;
								}
								else if(numSpots ==10)
								{
									currentWinAmount = 40;
									totalWinAmount += 40;
								}
							}
							
							//8 matches
							else if(numMatches == 8)
							{
								if(numSpots == 8)
								{
									currentWinAmount = 10000;
									totalWinAmount += 10000;
								}
								else if(numSpots ==10)
								{
									currentWinAmount = 450;
									totalWinAmount += 450;
								}
							}
							
							//9 matches
							else if(numMatches == 9)
							{
								if(numSpots ==10)
								{
									currentWinAmount = 4250;
									totalWinAmount += 4250;
								}
							}
							
							//10 matches
							else if(numMatches == 10)
							{
								if(numSpots ==10)
								{
									currentWinAmount = 100000;
									totalWinAmount += 100000;
								}
							}
							for(Integer match : whichMatches)
							{
								yourMatches +=String.valueOf(match)+"  ";
							}
							
							if(currentDrawNum == 1)
							{
								numMatches1.setText(String.valueOf(numMatches));
								if(yourMatches.equals("") == true)
									matches1.setText("No Matches");
								else
									matches1.setText(yourMatches);
								totalAmount1.setText(String.valueOf(totalWinAmount));
								drawingAmount1.setText(String.valueOf(currentWinAmount));
								currentWinAmount = 0;
							}
							else if(currentDrawNum == 2)
							{
								numMatches2.setText(String.valueOf(numMatches));
								if(yourMatches.equals("") == true)
									matches2.setText("No Matches");
								else
									matches2.setText(yourMatches);
								totalAmount2.setText(String.valueOf(totalWinAmount));
								drawingAmount2.setText(String.valueOf(currentWinAmount));
								currentWinAmount = 0;
							}
							else if(currentDrawNum == 3)
							{
								numMatches3.setText(String.valueOf(numMatches));
								if(yourMatches.equals("") == true)
									matches3.setText("No Matches");
								else
									matches3.setText(yourMatches);
								totalAmount3.setText(String.valueOf(totalWinAmount));
								drawingAmount3.setText(String.valueOf(currentWinAmount));
								currentWinAmount = 0;
							}
							else if(currentDrawNum == 4)
							{
								numMatches4.setText(String.valueOf(numMatches));
								if(yourMatches.equals("") == true)
									matches4.setText("No Matches");
								else
									matches4.setText(yourMatches);
								totalAmount4.setText(String.valueOf(totalWinAmount));
								drawingAmount4.setText(String.valueOf(currentWinAmount));
								currentWinAmount = 0;
							}
							numMatches = 0;
							whichMatches.clear();
							currentDrawNum++;
							currentWinners = "";
							yourMatches = "";
							winningPicks.clear();
					}
				}
			}}			
		});
		
		
		game_bp.setStyle("-fx-background-color: IndianRed;"); //Coloring the game screen background
		
		
		return new Scene(game_bp,700,700);
	}
}
