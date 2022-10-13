
import javax.swing.JButton;

public class block
{
    public int around;
    public boolean bomb;
    public boolean revealed;
    public boolean border;
    public JButton block;
    public int index;
    public boolean flaged;
    
    public block()
    {
        around = 0;
        bomb = false;
        revealed = false;
        block = new JButton();
        border = false;
        flaged = false;
    }
    
    public void setButton()
    {
        
    }
    public JButton getButton()
    {
        return this.block;
    }
    
    public void setRevealed(boolean value)
    {
        this.revealed = value;
    }
    public boolean getRevealed()
    {
        return this.revealed;
    }
    
    public void setAround(int value)
    {
        this.around = value;
    }
    public int getAround()
    {
        return this.around;
    }
    
    public void setBomb(boolean value)
    {
        this.bomb = value;
    }
    public boolean getBomb()
    {
        return this.bomb;
    }
    
    public void setBorder(boolean value)
    {
        this.border = value;
    }
    public boolean getBorder()
    {
        return this.border;
    }
    
    public void setIndex(int value)
    {
        this.index = value;
    }
    public int getIndex()
    {
        return this.index;
    }
    
    public void setFlaged(boolean value)
    {
        this.flaged = value;
    }
    public boolean getFlaged()
    {
        return this.flaged;
    }
}
