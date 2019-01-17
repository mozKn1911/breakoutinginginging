import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.awt.Color;


public class Board extends World
{
    public static Paddle paddle;
    private static final int VOFFSET = 10;
    private static final int HOFFSET = 10;
    private static final int BRICKWIDTH = 80;
    private static final int BRICKHEIGHT = 50;
    public int lives = 4;
    public int thend = 0;
    private Live live = new Live();
    private Live love = new Live();
    private Live lave = new Live();
    
    public Board()
    {    
        super(450, 900, 1);
        paddle = new Paddle();
        addObject ( paddle, getWidth() / 2, getHeight() - 40);
        for ( int i = 1; i <= 5; i++)
        {
            addObject( new Brick(1), (BRICKWIDTH * (i - 1)) + (BRICKWIDTH / 2) + (HOFFSET *  i), VOFFSET + (BRICKHEIGHT / 2));   
        }
        for ( int i = 1; i <= 5; i++)
        {
            addObject( new Brick(1), (BRICKWIDTH * (i - 1)) + (BRICKWIDTH / 2) + (HOFFSET *  i), BRICKHEIGHT + (VOFFSET * 2) + (BRICKHEIGHT / 2));   
        }
        for ( int i = 1; i <= 5; i++)
        {
            addObject( new Brick(1), (BRICKWIDTH * (i - 1)) + (BRICKWIDTH / 2) + (HOFFSET *  i), (BRICKHEIGHT * 2) + (VOFFSET * 3) + (BRICKHEIGHT / 2));   
        }
        addObject( live, 20, 850);
        addObject( love, 40, 850);
        addObject( lave, 60, 850);
        
        //thend = Brick.trans;
        if( thend == 1 ){
        
            showText("game clear",100,400);
                
        }
        
    }
    
    public void ballIsOut()
    {
        paddle.newBall();
        lifeLost();
    }
    
    public void lifeLost()
    {
        lives--;
    }
    
    public void act()
    {
        checkLives();
    }
    
    private void checkLives()
    {
        if (lives == 3) 
        {
            removeObject(lave);
        }
        if (lives == 2)
        { 
            removeObject(love);
        }
        if (lives == 1)
        { 
            removeObject(live);
            Greenfoot.stop();
        }   
    } 
}
