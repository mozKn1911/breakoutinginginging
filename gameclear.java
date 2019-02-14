import greenfoot.*;

/**
 * Write a description of class gameclear here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class gameclear extends Actor
{
    private GreenfootImage image;
    public gameclear()
    {
        image = new GreenfootImage("GAMECLEAR.png");
        image.scale(450,200);
        setImage(image);
    }
}
