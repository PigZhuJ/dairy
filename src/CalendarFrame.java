
import java.awt.*;
import java.awt.event.*;
import java.util.Calendar;
import javax.swing.*;

public class CalendarFrame implements ActionListener, MouseListener {
    JButton dayButton[] = new JButton[42];
    JButton titleName[] = new JButton[7];
    JButton jButton1,jButton2,jButton3;
    JButton button;
    String name[] = {"Sun", "Mon", "Tues", "Wed", "Thur", "Fri", "Sat"};
    JButton nextMonth, previousMonth, showAllNotes;
    int year = Calendar.getInstance().get(Calendar.YEAR), month = Calendar.getInstance().get(Calendar.MONTH) + 1;
    int date = Calendar.getInstance().get(Calendar.DATE); //启动程序显示的日期信息
    CalendarBean calendar;
    JLabel showMessage = new JLabel("", JLabel.CENTER);
    JLabel lbl2 = new JLabel("      ");
    JLabel jLabel = new JLabel("");
    JScrollPane jScrollPane = new JScrollPane();
    JSplitPane jSplitPane;
    JPanel calendarPanle = new JPanel();
    JPanel jTableJpanel = new JPanel();
    JPanel operatePanel = new JPanel();
    JTextArea jTextArea = new JTextArea();

    public CalendarFrame() {
        JFrame jFrame = new JFrame("Appointment Dairy");
        Container container = jFrame.getContentPane();
        jFrame.setSize(800, 350);
        jFrame.setBackground(new Color(55, 91, 122));
        jFrame.setLocationRelativeTo(null);
        addCalendar(container, jFrame);
        jFrame.setVisible(true);
    }

    public void addCalendar(Container container, JFrame jFrame) {
        calendarPanle.setLayout(new BorderLayout());
        JPanel pCenter = new JPanel();
        pCenter.setBackground(new Color(0, 139, 139));

        //将pCenter的布局设置为7行7列的GridLayout 布局。
        pCenter.setLayout(new GridLayout(7, 7));
        //pCenter添加组件titleName[i]
        for (int i = 0; i < 7; i++) {
            titleName[i] = new JButton(name[i]);
            pCenter.add(titleName[i]);
        }

        //pCenter添加组件labelDay[i]
        for (int i = 0; i < 42; i++) {
            dayButton[i] = new JButton("");
            pCenter.add(dayButton[i]);//增加组件
        }
        calendar = new CalendarBean();
        calendar.setYear(year);
        calendar.setMonth(month);
        calendar.setDate(date);
        String day[] = calendar.getCalendar();

        for (int i = 0; i < 42; i++) {
            if (day[i] != null) {
                dayButton[i].setText(calendar.month + "/" + day[i]);
            }
        }

        for (int i = 0; i < dayButton.length; i++) {
            if ((dayButton[i].getText() != null)) {
                int finalI = i;
                dayButton[i].addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        String currentdata = calendar.year + "/" + dayButton[finalI].getText();
                        jLabel.setText(currentdata);
                    }

                });
            }
        }
        for (int i = 0; i < dayButton.length; i++) {
            if ((dayButton[i].getText() != null) && (dayButton[i].getText().equals(month + "/" + date))) {
                dayButton[i].setForeground(Color.RED);
            }
        }

        nextMonth = new JButton("NextMonth");
        previousMonth = new JButton("LastMonth");
        showAllNotes = new JButton("Show AllNotes");
        //注册监听器
        nextMonth.addActionListener(this);
        previousMonth.addActionListener(this);

        JPanel pNorth = new JPanel(),
                pSouth = new JPanel();
        pNorth.add(showMessage);
        pNorth.add(lbl2);
        pNorth.add(previousMonth);
        pNorth.add(nextMonth);
        pNorth.add(showAllNotes);
        showMessage.setText("Calendar：" + calendar.getYear() + "-" + calendar.getMonth() + "-" + calendar.getDate());
        showMessage.setFont(new Font("雅黑", Font.LAYOUT_RIGHT_TO_LEFT, 16));
        ScrollPane scrollPane = new ScrollPane();
        scrollPane.add(pCenter);
        calendarPanle.add(pNorth, BorderLayout.NORTH);// 窗口添加pNorth 在北面区域
        calendarPanle.add(scrollPane, BorderLayout.CENTER);// 窗口添加scrollPane在中心区域
        calendarPanle.add(pSouth, BorderLayout.SOUTH);// 窗口添加pSouth 在南区域。
        jTableJpanel.setLayout(new BorderLayout());
        jScrollPane.setViewportView(jTextArea);
        jTableJpanel.add(jScrollPane, BorderLayout.CENTER);
        jTableJpanel.add(operatePanel, BorderLayout.SOUTH);
        jTableJpanel.add(jLabel, BorderLayout.NORTH);
        jButton1=new JButton(" add  ");
        jButton1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
               new  MessageFrame().showFrame("add");
            }
        });
        jButton2=new JButton("delete");
        jButton3=new JButton("alter ");
        operatePanel.add(jButton1);
        operatePanel.add(jButton2);
        operatePanel.add(jButton3);
        jSplitPane = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, calendarPanle, jTableJpanel);
        container.add(jSplitPane, BorderLayout.CENTER);
        jSplitPane.setContinuousLayout(true);
        jSplitPane.setDividerLocation(510);
        jSplitPane.setEnabled(true);
    }


    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == nextMonth) {
            month = month + 1;
            if (month > 12)
                month = 1;
            calendar.setMonth(month);
            String day[] = calendar.getCalendar();

            for (int i = 0; i < 42; i++) {
                dayButton[i].setText(day[i]);
            }
        } else if (e.getSource() == previousMonth) {
            month = month - 1;
            if (month < 1)
                month = 12;
            calendar.setMonth(month);
            String day[] = calendar.getCalendar();

            for (int i = 0; i < 42; i++) {
                dayButton[i].setText(day[i]);
            }
        }
        showMessage.setText("Calendar：" + calendar.getYear() + "-" + calendar.getMonth() + "-" + calendar.date);
        showMessage.setFont(new Font("雅黑", Font.LAYOUT_RIGHT_TO_LEFT, 16));
    }



    @Override
    public void mouseClicked(MouseEvent e) {
        ((JButton) e.getSource()).setBackground(Color.RED);
    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {
        ((JButton) e.getSource()).setBackground(Color.gray);
    }

}