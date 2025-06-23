import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Nothing extends JFrame {

    private JLabel label;
    private Timer timer;
    private int secs=0;

    private boolean stillStanding=true;


    public Nothing() {

        setSize(400,300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("Nothing");
        setLocationRelativeTo(null);
        setResizable(false);
        setLayout(new BorderLayout());

        label = new JLabel("Time: "+secs+"seconds",SwingConstants.CENTER);
        label.setFont(new Font("Times New Roman", Font.PLAIN, 25));
        add(label,BorderLayout.CENTER);

        timer = new Timer(1000, e ->{
            secs++;
            label.setText("Time: "+secs+"seconds");
        });

        addKeyListener(new KeyAdapter() {
            public void keyPressed(KeyEvent e) {
                byebyeMissAmericanPie();
            }
        });

        addMouseMotionListener(new MouseMotionAdapter() {
            public void mouseMoved(MouseEvent e) {
                byebyeMissAmericanPie();
            }
        });


        setFocusable(true);
        requestFocusInWindow();
        setVisible(true);
        timer.start();

    }

    private void  byebyeMissAmericanPie(){

        if(!stillStanding){return;}

        stillStanding=false;
        timer.stop();

        if(secs<3){
            JOptionPane.showMessageDialog(this,"OH CMON DUDE \nOnly "+secs+" seconds");
        } else if (secs<7) {
            JOptionPane.showMessageDialog(this,"Not the hero we expected \n"+secs+" seconds");
        }
        else if(secs<10){
            JOptionPane.showMessageDialog(this,"Do or not there is no try "+"\n Seconds "+secs+" only been survived");
        }
        else{
            JOptionPane.showMessageDialog(this,"Congrats you have the ability to do nothing, now go get a life"+"\n"+secs+" seconds");
        }

        System.exit(0);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(()->new Nothing());
    }
}
