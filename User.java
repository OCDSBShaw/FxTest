
/**
 * Write a description of class User here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class User
{
    // instance variables - replace the example below with your own
    private String name;
    private int numCorrect;
    private byte errors;

    /**
     * Constructor for objects of class User
     */
    public User()
    {
        // initialise instance variables
        this.numCorrect = 0;
        this.errors = 0;
    }

    public int getNumCorrect(){
        return numCorrect;
    }
    //Used to increase the number of correct answers
    public void setNumCorrect(){
        this.numCorrect++;
    }
    public void setNumCorrect(int nc){
        this.numCorrect = nc;
    }
    
    public byte getErrors(){
         return this.errors;   
    }
    
    public void setErrors(int e){
         this.errors = (byte)e;   
    }
    public String toString(){
        return "Correct answers: " +this.numCorrect;
    
    }
}
