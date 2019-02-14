import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.awt.Color;


public class Board extends World
{
    public static Paddle paddle;
    private static final int VOFFSET = 3;
    private static final int HOFFSET = 3;
    private static final int BRICKWIDTH = 80;
    private static final int BRICKHEIGHT = 50;
    public int lives = 4;
    public int thend = 0;
    private Live live = new Live();
    private Live love = new Live();
    private Live lave = new Live();
    private GreenfootImage image;
    
    public Board()
    {    
        super(1250, 900, 1);
        paddle = new Paddle();
        addObject ( paddle, getWidth() / 2, getHeight() - 40);
        for ( int i = 1; i <= 15; i++)
        {
            addObject( new Brick(1), (BRICKWIDTH * (i - 1)) + (BRICKWIDTH / 2) + (HOFFSET *  i), VOFFSET + (BRICKHEIGHT / 2));   
        }
        for ( int i = 1; i <= 15; i++)
        {
            addObject( new Brick(1), (BRICKWIDTH * (i - 1)) + (BRICKWIDTH / 2) + (HOFFSET *  i), BRICKHEIGHT + (VOFFSET * 2) + (BRICKHEIGHT / 2));   
        }
        for ( int i = 1; i <= 15; i++)
        {
            addObject( new Brick(1), (BRICKWIDTH * (i - 1)) + (BRICKWIDTH / 2) + (HOFFSET *  i), (BRICKHEIGHT * 2) + (VOFFSET * 3) + (BRICKHEIGHT / 2));   
        }
        for ( int i = 1; i <= 15; i++)
        {
            addObject( new Brick(1), (BRICKWIDTH * (i - 1)) + (BRICKWIDTH / 2) + (HOFFSET *  i), (BRICKHEIGHT * 3) + (VOFFSET * 4) + (BRICKHEIGHT / 2));   
        }
        for ( int i = 1; i <= 15; i++)
        {
            addObject( new Brick(1), (BRICKWIDTH * (i - 1)) + (BRICKWIDTH / 2) + (HOFFSET *  i), (BRICKHEIGHT * 4) + (VOFFSET * 5) + (BRICKHEIGHT / 2));   
        }
        addObject( live, 20, 850);
        addObject( love, 40, 850);
        addObject( lave, 60, 850);
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
        checkClear();
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
            addObject( new gameover(), 625, 450); 
            Ball.cnt=0;
            Greenfoot.stop();
        }   
    } 
    private void checkClear()
    {
        if (Ball.cnt==75) 
        {
            Ball.cnt=0;
            addObject( new gameclear(), 625, 450);
            Greenfoot.stop();
        }
    } 
}
