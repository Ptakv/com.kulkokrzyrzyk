import javax.swing.JFrame;
import javax.swing.JPanel;

public class Frame extends JFrame
{
    private static final long serialVersionUID = 1L;
    public Frame()
    {
        super("kolko i krzyzyk");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(300, 400);
        setLocation(300, 100);
        
        JPanel buttonsPanel = new Buttons();
        add(buttonsPanel);

        setVisible(true);
    }
}
