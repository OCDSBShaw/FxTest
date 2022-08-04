
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import javafx.scene.control.TextField;

/**
 * Write a description of JavaFX class GUI here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class GUI extends Application
{
    // We keep track of the count, and label displaying the count:
    private int count = 0;
    private Label myLabel = new Label("0");
    private Label feedback = new Label();
    private TextField input;
    Problem p;
    static User u = new User();
    final int LEVEL_UP = 2;
    final int MAX_ERRORS = 4;
    /**
     * The start method is the main entry point for every JavaFX application. 
     * It is called after the init() method has returned and after 
     * the system is ready for the application to begin running.
     *
     * @param  stage the primary stage for this application.
     */
    @Override
    public void start(Stage stage)
    {
        p = new Problem();
        //for tessting
        //u.setNumCorrect(10);
        // Create a Button or any control item
        Button myButton = new Button("Submit");

        //create the TextField
        input = new TextField();
        input.setPromptText("Enter answer here");
        // Create a new grid pane
        GridPane pane = new GridPane();
        pane.setPadding(new Insets(10, 10, 10, 10));
        pane.setMinSize(300, 300);
        pane.setVgap(10);
        pane.setHgap(10);

        //set an action on the button using method reference
        myButton.setOnAction(this::buttonClick);

        myLabel.setText(p.toString());
        // Add the button and label into the pane
        pane.add(myButton, 0, 0);
        pane.add(myLabel, 1, 0);
        pane.add(input,2,0);
        pane.add(feedback,0,1);

        // JavaFX must have a Scene (window content) inside a Stage (window)
        Scene scene = new Scene(pane, 400,100);
        stage.setTitle("JavaFX Example");
        stage.setScene(scene);

        // Show the Stage (window)
        stage.show();
    }

    /**
     * This will be executed when the button is clicked
     * It increments the count by 1
     */
    private void buttonClick(ActionEvent event)
    {
        p.setAnswer(Integer.parseInt(input.getText()));
        // calls check answer an outputs a message according to the boolean
        if(p.checkAnswer()){
            feedback.setText(p.getAnswer() + " is correct!\n"+this.p.getLevel());
            u.setNumCorrect();//add to correct answers
            if(u.getNumCorrect() >= LEVEL_UP){
                p.setLevel();
                u.setNumCorrect(0);//reset correct for new level
                u.setErrors(0);//same for errors
            }            
            //Call generateQuestion
            p.generateQuestion();  
            myLabel.setText(p.toString());
            input.setText("");
        }
        else{
            feedback.setText(p.getAnswer() + " is incorrect :(\n try again");
            u.setErrors(u.getErrors()+1);//add one to errors
        }
        //When errors reach a certain value level down
        checkErrors();
        //For debugging purposes
        System.out.println(p);
        System.out.println("Level: " +p.getLevel());
    }
    public void checkErrors(){
         if(u.getErrors()>=MAX_ERRORS) 
             p.setLevel(p.getLevel()-1);
    }
    public static void main(String[] args)
    {
        launch(args);
    }
}
