import javax.swing.*;
import java.awt.*;

public class MessageFrame {
    JFrame jFrame;
    Container container;
    JLabel jLabel1=new JLabel();
    JLabel jLabel2=new JLabel("Date");
    JLabel jLabel3=new JLabel();
    JLabel jLabel4=new JLabel();
    JLabel jLabel5=new JLabel();
    JTextField jTextFiled1=new JTextField();
    JTextField jTextFiled2=new JTextField();
    JTextField jTextFiled3=new JTextField();
    JTextField jTextFiled4=new JTextField();
    JButton Jbutton1=new JButton("cancel ");
    JButton Jbutton2=new JButton("confirm");
    JPanel jPanel1=new JPanel();
    JPanel jPanel2=new JPanel();
    JPanel jPanel3=new JPanel();
    JPanel jPanel4=new JPanel();
    JPanel jPanel5=new JPanel();
    public void showFrame(String info){
         jFrame=new JFrame(info);
         container=jFrame.getContentPane();
         container.setLayout(new GridLayout(5,1));
         jLabel1.setText(info);
         jPanel1.add(jLabel1);
         jPanel2.add(jLabel2);
         jTextFiled1.setColumns(13);
         jPanel2.add(jTextFiled1);
         container.add(jPanel1);
         container.add(jPanel2);
         jFrame.setSize(300,180);
         jFrame.setVisible(true);
    }
}
