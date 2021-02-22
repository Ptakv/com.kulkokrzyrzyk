import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Buttons extends JPanel implements ActionListener 
{
    private static final long serialVersionUID = 1L;
    JButton reset;
    JButton[] button = new JButton[9];
    boolean turn = true;
    

    public Buttons() 
    {

        for (int i = 0; i < button.length; i++) 
        {
            button[i] = new JButton("");
            button[i].addActionListener(this);
            add(button[i]);
        }

        reset = new JButton("RESET");
        add(reset);
        reset.addActionListener(this);
        setLayout(new GridLayout(4, 3));
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        Object source = e.getSource();
        char symbol = 'X';
        turn = !turn;

        if(turn)
        {
            symbol = 'O';
        }

        for (int i = 0; i < button.length; i++)
        {
            if(source.equals(reset))
            {
                button[i].setText("");
            }

            if(source.equals(button[i]))
            {
                button[i].setText("" + symbol);
            }
            
        }



    }

   
  

    
}