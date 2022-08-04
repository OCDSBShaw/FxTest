import java.util.Random;

/**
 * Generates a problem to be solved before unlocking phone
 *
 * @Shaw,Jennifer
 * @July 19,2022
 */
public class Problem
{
    // instance variables - replace the example below with your own
    private int x,y;
    private char opperator;//add(+), subtract(-), multiply(x) or divide(/)
    private byte level;
    private int ans;
    final byte ADD = 0;//used to randomly generate an appropriat opperator
    final byte SUBTRACT = 1;
    final byte MULTIPLY = 2;
    final byte DIVIDE = 3;
    private Random r = new Random();
    /**
     * Constructor for objects of class Problem
     */
    public Problem()
    {
        // initialise instance variables
        level = 1;
        opperator = '+';
        x = r.nextInt(10);
        y = r.nextInt(10);    
    }

    public int getAnswer(){
        return ans;
    }

    public void setAnswer(int a){
        this.ans = a;
    }
    /**
     * Method setLevel
     * used to level up when a certain number of questions are 
     * answered correctly 
     */
    public void setLevel(){
         this.level++;   
    }
    
    /**
     * Overloaded Method setLevel
     * used for diminishing level when too many mistakes
     * @parameter l - level to set (one down)
     */
    public void setLevel(int l){
        this.level=(byte)l;
    }
    public byte getLevel(){
         return this.level;   
    }
    public boolean checkAnswer(){
        if(opperator == '+')
            return (x+y==ans);
        else if(opperator == '-')
            return (x-y==ans);
        else if(opperator == 'x')
            return x*y==ans;
        else
            return x/y==ans;
    }
/* TO DO: Keep track of errors and decrease level after 4 errors
 * TO DO: Test to determine starting level
 * TO DO: Teach concept before increasing level
 */
    public void generateQuestion(){
        switch (level){
            case 1:
            //add numbers between 0-10
                x = r.nextInt(10);
                y = r.nextInt(10);
                break;//this is set up in the constructor
            case 2:
            //subtract or add numbers between 0-10
                x = r.nextInt(10)+1;
                y = r.nextInt(x);
                setOpperator(SUBTRACT);//randomly get + or -
                //so there is never a negative answer
                //must add one incase x is zero
                break;            
            case 3:
            //multiply, subtract or add numbers between 0-10
                x = r.nextInt(10)+1;
                y = r.nextInt(10);
                setOpperator(MULTIPLY);//ramdomly get +,- or x
                if(this.opperator =='-')
                    y = r.nextInt(x);
                break;
            case 4:
            //divide, multiply, subtract or add numbers between 0-10
                x = r.nextInt(10);
                y = r.nextInt(10);
                setOpperator(DIVIDE);//randomly get +,-,x or /
                if(this.opperator == '/'){
                    if (y==0)//Never want to divide by zero
                        y++;
                    x = y * r.nextInt(5);
                    //add 1 so never dividing by zero
                    //multiply by y so even result
                }else if(this.opperator =='-')
                    y = r.nextInt(x);//no negative answers           
                break;
            case 5://Divide, multiply, subtract or add numbers between 1-20
            //with x = 1-20 and y = 1-10
                setOpperator();
                x = r.nextInt(20)+1; System.out.println("x:" + x);
                y = r.nextInt(10)+1; System.out.println("y:" +y);
                if(this.opperator == '/')
                    x = y+1 * r.nextInt(10);                
                break;
            default://Divide, multiply, subtract or add numbers between 1-20
                //negative subtraction result possible
                //x = 10-20
                setOpperator();
                x = r.nextInt(10);//negatives possible for subtraction
                y = r.nextInt(10)+1;
                if(this.opperator == '/')
                    if(y==0)
                        y++;//No dividing by zero
                    x = x * y;//always an even division
                break;
        }
    }

    /**
     * Method setOpperator
     * Chooses a random opperator given level
     */
    public void setOpperator(int max){
        Random op = new Random();
        //get a random number between 0-level
        int chosenOpperator = op.nextInt(max+1);
        System.out.println("Opperator: " + chosenOpperator);
        if(chosenOpperator==ADD)
            this.opperator = '+';
        else if(chosenOpperator==SUBTRACT)
            this.opperator = '-';
        else if (chosenOpperator==MULTIPLY)
            this.opperator = 'x';
        else
            this.opperator = '/';
    }
    //Overloaded when all possibilities (+ - x or /)
    public void setOpperator(){
        setOpperator(DIVIDE);
    }
    /**
     * toString gives a String representation of the Problem
     */
    public String toString()
    {
        String question = ""+ x +" " + opperator + " " + y + " =";

        return question;
    }
}
