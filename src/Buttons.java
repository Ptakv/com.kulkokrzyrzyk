import javax.swing.JButton;
import javax.swing.JPanel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.*;
public class Buttons extends JPanel implements ActionListener
{
    private static final long serialVersionUID = 1L;
    JButton reset;
    JButton[] button = new JButton[9];
    boolean myTurn = true;
    public Buttons()
    {
      for (int i = 0; i < button.length; i++)
      {
          button[i] = new JButton("");
          button[i].addActionListener(this);
          button[i].setBackground(Color.WHITE);
          add(button[i]);
      }
      reset = new JButton("RESET");
      reset.addActionListener(this);
      reset.setBackground(Color.WHITE);
      add(reset);
      setLayout(new GridLayout(4, 3));
    }
    @Override
    public void actionPerformed(ActionEvent e)
    {
        Object source = e.getSource();
        char symbol = 'X';
        if(myTurn){
          symbol = 'O';
        }
        myTurn = !myTurn;
        for (int i = 0; i < button.length; i++)
        {
          if (source.equals(reset)) 
          {
            button[i].setText("");
            button[i].setEnabled(true);
            button[i].setBackground(Color.WHITE);
            System.out.println("WYSZŁO!");
          }

          if(source.equals(button[i]))
          {
            button[i].setText(""+symbol);
            button[i].setEnabled(false);
          }
        }
        if(checkResult())
        {
          for (int i = 0; i < button.length; i++){
            button[i].setEnabled(false);
          }
        }

    }
    public boolean checkResult()
    {
      boolean result = false;
      for(int fi = 0; fi < 8; fi++)
      {
        int i = fi*3;
        int id[] = new int[3];
        if(fi < 3)
        {
          id[0] = i;
          id[1] = i+1;
          id[2] = i+2;
        }else if(fi < 6)
        {
          id[0] = fi - 3;
          id[1] = fi;
          id[2] = fi+3;
        }else if(fi == 6)
        {
          id[0] = 0;
          id[1] = 4;
          id[2] = 8;
        }else if(fi == 7)
        {
          id[0] = 2;
          id[1] = 4;
          id[2] = 6;
        }
        if(button[id[0]].getText().equals(button[id[1]].getText()) 
        && button[id[0]].getText().equals(button[id[2]].getText())
        && !button[id[0]].getText().equals(""))
        {
          button[id[0]].setBackground(Color.GREEN);
          button[id[1]].setBackground(Color.GREEN);
          button[id[2]].setBackground(Color.GREEN);
          result = true;
        }
      }
      return result;
    }
}