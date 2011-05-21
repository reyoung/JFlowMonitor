/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Presentation.Statics;

import javax.swing.SwingUtilities;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.GridBagLayout;

import javax.swing.JPanel;
import javax.swing.JFrame;
import javax.swing.SpringLayout;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.GridLayout;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;
import javax.swing.Spring;
import javax.swing.border.LineBorder;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.plaf.basic.BasicBorders;

/*
 * 日期选择器。扩展自JPanel，将所有内容包装在该JPanel内，选择的日期可以通过
 * getDate():String 获取，格式为YYYY-MM-DD HH:MM:SS或者可以在jPanel3内添加鼠标动作监听器，
 * 监听选择的改变。可以直接将该JPanel放置在需要的地方进行显示，也可以使用其以提供的JDialog，
 * 使用方法为调用其showInDialog():void;
 *
 * 程序结构：顶层为BorderLayout的面板 ，
 * NORTH块jPanel，该Panel使用GridLayout布局，两行一列，
 * 第一行放置jPanel1，使用SpringLayout布局，jPanel1内 存放了五个JSpinner及对应的标签分别用于显示
 * 与改变年、月  时、分、秒。第二行放置jPanel2，使用GridLayout布局，一行七列，存放七个标签用于显示
 * 周日到周六七个列。
 * CENTER块jPanel3，该Panel显示指定年月的日期，直接使用绘图方式实现，逻辑上划分为6*7单元格，未使用其他空间，通过监听鼠标
 * 事件，获取点击的坐标，转换成单元格，底层有DateCell[6][7]存储对应位置的数据与状态，该Panel就是根据
 * DateCell矩阵绘制内容的。DateCell定义了绘制日期的样式，可定制。DateCell实现为私有内部内。
 * */
public class QDateChooser extends JPanel {

    private static final long serialVersionUID = 1L;
    private JPanel jContentPane = null;
    private JPanel jPanel = null;
    private JPanel jPanel1 = null;
    private JPanel jPanel2 = null;
    private JSpinner jSpinner = null;
    private SpinnerNumberModel sNModel = null;   //  @jve:decl-index=0:visual-constraint=""
    private JLabel jLabel7 = null;
    private JSpinner jSpinner1 = null;
    private SpinnerNumberModel sNModel1 = null;   //  @jve:decl-index=0:visual-constraint=""
    private JLabel jLabel8 = null;
    private JSpinner jSpinner2 = null;
    private JLabel jLabel9 = null;
    private JSpinner jSpinner3 = null;
    private JLabel jLabel10 = null;
    private JSpinner jSpinner4 = null;
    private JLabel jLabel11 = null;
    private SpinnerNumberModel sNModel2 = null;   //  @jve:decl-index=0:visual-constraint=""
    private SpinnerNumberModel sNModel3 = null;   //  @jve:decl-index=0:visual-constraint=""
    private SpinnerNumberModel sNModel4 = null;   //  @jve:decl-index=0:visual-constraint=""
    private JPanel jPanel3 = null;
    private DateCell[][] cells = null;
    private Calendar calendar = null;            //java类库日历，提供了日期计算算法。  //  @jve:decl-index=0:
    private JDialog dialog = null;

    public QDateChooser() {
        super();
        initialize();
    }

    private void initialize() {
        this.setSize(396, 293);
        this.setLayout(new BorderLayout());
        this.add(getJPanel(), BorderLayout.NORTH);
        this.add(getJPanel3(), BorderLayout.CENTER);
    }

    public void showInDialog() {
        Frame parent = (Frame) SwingUtilities.getAncestorOfClass(Frame.class, this);
        if (dialog == null) {
            dialog = new JDialog(parent, "选择日期");
        }
        dialog.setLayout(new BorderLayout());
        dialog.add(this, BorderLayout.CENTER);
        dialog.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        dialog.add(new JPanel() {

            {//匿名类初始化块
                setLayout(new FlowLayout());
                add(new JButton("确定") {

                    {
                        addActionListener(new ActionListener() {

                            @Override
                            public void actionPerformed(ActionEvent arg0) {
                                dialog.dispose();
                            }
                        });
                    }
                });
            }
        }, BorderLayout.SOUTH);
        dialog.setSize(400, 300);
        dialog.setVisible(true);
    }

    private Calendar getCalendar() {
        if (calendar == null) {
            calendar = new GregorianCalendar();
        }
        return calendar;
    }

    public String getDate() {
        String d = null;
        d += String.valueOf(getCalendar().get(Calendar.YEAR));
        d += "-" + String.valueOf(getCalendar().get(Calendar.MONTH));
        d += "-" + String.valueOf(getCalendar().get(Calendar.DATE));
        d += " " + String.valueOf(getCalendar().get(Calendar.HOUR));
        d += ":" + String.valueOf(getCalendar().get(Calendar.MINUTE));
        d += ":" + String.valueOf(getCalendar().get(Calendar.SECOND));
        return d;
    }
    //生成一个6*7的单元，用于显示日期,并以默认Calendar日期初始化

    private DateCell[][] getCells() {

        if (cells == null) {
            cells = new DateCell[6][];
            for (int i = 0; i < 6; i++) {
                cells[i] = new DateCell[7];
                for (int j = 0; j < 7; j++) {
                    cells[i][j] = new DateCell();
                }
            }
            setCells();
        }
        return cells;
    }
    //每当日历内容发生变化时，调用该方法，重设单元格的内容与状态。

    private void setCells() {
        //保存日历当前日期
        int currentDay = getCalendar().get(Calendar.DATE);
        //定位到当月第一天
        getCalendar().set(Calendar.DATE, 1);
        int fdw = getCalendar().get(Calendar.DAY_OF_WEEK);
        getCalendar().roll(Calendar.DATE, -1);
        int lastDayOfMonth = getCalendar().get(Calendar.DATE);
        //恢复日历到当期日期
        getCalendar().set(Calendar.DATE, currentDay);
        //清空单元格的原有内容
        for (DateCell[] cls : getCells()) {
            for (DateCell c : cls) {
                c.setText("");
                c.setActive(false);
            }
        }
        int dateCount = 1;//日期计数器，用来设置单元格内
        for (int j = 0; j < 7; j++)//先设置日历的第一行
        {
            if (j + 1 == fdw) {//本月第一天从这里开始
                if (dateCount == currentDay)//如果这天是当前日期，改变状态
                {
                    cells[0][j].setActive(true);
                }
                cells[0][j].setText(String.valueOf(dateCount++));
            } else if (dateCount > 1) {
                cells[0][j].setText(String.valueOf(dateCount++));
            }
        }
        for (int i = 1; i < 6; i++) {
            for (int j = 0; j < 7; j++) {
                if (dateCount > lastDayOfMonth) {
                    break;
                }
                if (dateCount == currentDay) {
                    cells[i][j].setActive(true);
                }
                cells[i][j].setText(String.valueOf(dateCount++));
            }
        }
//		for(int i=0;i<6;i++)
//		{//将周末设为粉红色
//			cells[i][0].setCommonColor(Color.PINK);
//			cells[i][6].setCommonColor(Color.PINK);
//		}
    }

    /**
     * This method initializes jPanel
     *
     * @return javax.swing.JPanel
     */
    private JPanel getJPanel() {
        if (jPanel == null) {

            GridLayout gridLayout = new GridLayout();
            gridLayout.setRows(2);
            gridLayout.setColumns(1);
            jPanel = new JPanel();
            jPanel.setLayout(gridLayout);
            jPanel.add(getJPanel1(), null);
            jPanel.add(getJPanel2(), null);
        }
        return jPanel;
    }

    /**
     * 返回一个添加了年月 时分秒及相应文字标签的JPanel，布局采用SpringLayout
     * @return javax.swing.JPanel
     */
    private JPanel getJPanel1() {
        if (jPanel1 == null) {
            jLabel11 = new JLabel();
            jLabel11.setText("秒");
            jLabel10 = new JLabel();
            jLabel10.setText("分");
            jLabel9 = new JLabel();
            jLabel9.setText("时");
            jLabel8 = new JLabel();
            jLabel8.setText("月");
            jLabel7 = new JLabel();
            jLabel7.setText("年");
            jPanel1 = new JPanel();
            SpringLayout sLayout = new SpringLayout();
            jPanel1.setLayout(sLayout);
            jPanel1.add(getJSpinner(), null);
            jPanel1.add(jLabel7, null);
            jPanel1.add(getJSpinner1(), null);
            jPanel1.add(jLabel8, null);
            jPanel1.add(getJSpinner2(), null);
            jPanel1.add(jLabel9, null);
            jPanel1.add(getJSpinner3(), null);
            jPanel1.add(jLabel10, null);
            jPanel1.add(getJSpinner4(), null);
            jPanel1.add(jLabel11, null);
            String W = SpringLayout.WEST,
                    E = SpringLayout.EAST,
                    N = SpringLayout.NORTH,
                    S = SpringLayout.SOUTH;
            sLayout.putConstraint(W, jLabel7, 3, E, getJSpinner());
            sLayout.putConstraint(W, getJSpinner1(), 10, E, jLabel7);
            sLayout.putConstraint(W, jLabel8, 3, E, getJSpinner1());
            sLayout.putConstraint(W, jLabel9, 3, E, getJSpinner2());
            sLayout.putConstraint(W, getJSpinner3(), 10, E, jLabel9);
            sLayout.putConstraint(W, jLabel10, 3, E, getJSpinner3());
            sLayout.putConstraint(W, getJSpinner4(), 10, E, jLabel10);
            sLayout.putConstraint(W, jLabel11, 3, E, getJSpinner4());
            Spring s1 = Spring.constant(0, 40, 100);
            Spring s2 = Spring.constant(0, 100, 200);
            sLayout.putConstraint(W, getJSpinner(), s1, W, jPanel1);
            sLayout.putConstraint(W, getJSpinner2(), s2, E, jLabel8);
            sLayout.putConstraint(E, jPanel1, s1, E, jLabel11);
            sLayout.putConstraint(S, jPanel1, (int) getJSpinner().getPreferredSize().getHeight() + 4, N, jPanel1);
        }
        return jPanel1;
    }

    /*
     * 	设置周日到周六的七个标题标签，并添加到网格布局的JPanel上然后返回该JPanel
     */
    private JPanel getJPanel2() {
        if (jPanel2 == null) {

            String[] labelText = {"日", "一", "二", "三", "四", "五", "六"};
            ArrayList<JLabel> list = new ArrayList<JLabel>();

            for (int i = 0; i < 7; i++) {
                JLabel label = new JLabel();
                label.setHorizontalAlignment(JLabel.CENTER);
                label.setBorder(new LineBorder(Color.GRAY));
                label.setText(labelText[i]);
                list.add(label);
            }
            GridLayout gridLayout1 = new GridLayout();
            gridLayout1.setRows(1);
            gridLayout1.setColumns(7);
            jPanel2 = new JPanel();
            jPanel2.setLayout(gridLayout1);
            jPanel2.setBorder(BasicBorders.getTextFieldBorder());
            for (JLabel l : list) {
                jPanel2.add(l);
            }
        }
        return jPanel2;
    }

    private JSpinner getJSpinner() {
        if (jSpinner == null) {
            jSpinner = new JSpinner(getSNModel());
            getSNModel().setValue(getCalendar().get(Calendar.YEAR));
            jSpinner.addChangeListener(new ChangeListener() {

                @Override
                public void stateChanged(ChangeEvent arg0) {
                    getCalendar().set(Calendar.YEAR, (Integer) jSpinner.getValue());
                    setCells();
                    getJPanel3().repaint();
                }
            });
        }
        return jSpinner;
    }

    /**
     *
     */
    private SpinnerNumberModel getSNModel() {
        if (sNModel == null) {
            sNModel = new SpinnerNumberModel();
        }
        return sNModel;
    }

    /**
     */
    private JSpinner getJSpinner1() {
        if (jSpinner1 == null) {
            jSpinner1 = new JSpinner(getSNModel1());
            getSNModel1().setValue(getCalendar().get(Calendar.MONTH) + 1);
            jSpinner1.addChangeListener(new ChangeListener() {

                @Override
                public void stateChanged(ChangeEvent arg0) {
                    getCalendar().set(Calendar.MONTH, (Integer) jSpinner1.getValue() - 1);
                    setCells();
                    getJPanel3().repaint();
                }
            });
        }
        return jSpinner1;
    }

    /**
     * This method initializes sNModel1
     */
    private SpinnerNumberModel getSNModel1() {
        if (sNModel1 == null) {
            sNModel1 = new SpinnerNumberModel();
            sNModel1.setMaximum(12);
            sNModel1.setMinimum(1);
            sNModel1.setStepSize(1);
            sNModel1.setValue(1);
        }
        return sNModel1;
    }

    /**
     * This method initializes jSpinner2
     */
    private JSpinner getJSpinner2() {
        if (jSpinner2 == null) {
            jSpinner2 = new JSpinner(getSNModel2());
            getSNModel2().setValue(getCalendar().get(Calendar.HOUR));
            jSpinner2.addChangeListener(new ChangeListener() {

                @Override
                public void stateChanged(ChangeEvent arg0) {
                    getCalendar().set(Calendar.HOUR, (Integer) jSpinner2.getValue());
                }
            });
        }
        return jSpinner2;
    }

    /**
     * This method initializes jSpinner3
     */
    private JSpinner getJSpinner3() {
        if (jSpinner3 == null) {
            jSpinner3 = new JSpinner(getSNModel3());
            getSNModel3().setValue(getCalendar().get(Calendar.MINUTE));
            jSpinner3.addChangeListener(new ChangeListener() {

                @Override
                public void stateChanged(ChangeEvent arg0) {
                    getCalendar().set(Calendar.MINUTE, (Integer) jSpinner3.getValue());
                }
            });
        }
        return jSpinner3;
    }

    /**
     * This method initializes jSpinner4

     */
    private JSpinner getJSpinner4() {
        if (jSpinner4 == null) {
            jSpinner4 = new JSpinner(getSNModel4());
            getSNModel4().setValue(getCalendar().get(Calendar.SECOND));
            jSpinner4.addChangeListener(new ChangeListener() {

                @Override
                public void stateChanged(ChangeEvent arg0) {
                    getCalendar().set(Calendar.SECOND, (Integer) jSpinner4.getValue());
                }
            });
        }
        return jSpinner4;
    }

    /**
     * This method initializes sNModel2
     */
    private SpinnerNumberModel getSNModel2() {
        if (sNModel2 == null) {
            sNModel2 = new SpinnerNumberModel();
            sNModel2.setMaximum(23);
            sNModel2.setMinimum(0);
            sNModel2.setStepSize(1);
        }
        return sNModel2;
    }

    /**
     * This method initializes sNModel3
     */
    private SpinnerNumberModel getSNModel3() {
        if (sNModel3 == null) {
            sNModel3 = new SpinnerNumberModel();
            sNModel3.setMaximum(59);
            sNModel3.setMinimum(0);
            sNModel3.setStepSize(1);
        }
        return sNModel3;
    }

    /**
     * This method initializes sNModel4
     */
    private SpinnerNumberModel getSNModel4() {
        if (sNModel4 == null) {
            sNModel4 = new SpinnerNumberModel();
            sNModel4.setMaximum(59);
            sNModel4.setMinimum(0);
            sNModel4.setStepSize(1);
        }
        return sNModel4;
    }

    /**
     * 	返回一个画了6*7个单元格的JPanel，并能够响应鼠标时间，改变相应单元格的状态
     */
    private JPanel getJPanel3() {
        if (jPanel3 == null) {
            jPanel3 = new JPanel() {
                //在这里调用每一个单元格，让他们绘制自己

                public void paintComponent(Graphics g) {
                    super.paintComponent(g);
                    int w = getWidth() / 7;
                    int h = getHeight() / 6;
                    DateCell[][] cls = getCells();
                    for (int i = 0; i < 6; i++) {
                        for (int j = 0; j < 7; j++) {
                            cls[i][j].drawYourself(g, w * j, h * i, w, h);
                        }
                    }
                }
            };
            jPanel3.setLayout(null);
            //监听鼠标单击事件，并定位到单元格，改变单元格被选中状态。
            jPanel3.addMouseListener(new MouseAdapter() {

                public void mouseClicked(MouseEvent e) {
                    int W = jPanel3.getWidth();
                    int H = jPanel3.getHeight();
                    int cw = W / 7;
                    int ch = H / 6;
                    int X = e.getX();
                    int Y = e.getY();
                    int row = Y / ch;
                    int column = X / cw;
                    //首先将所有单元格设置为未选中
                    for (DateCell[] dc : getCells()) {
                        for (DateCell c : dc) {
                            c.setActive(false);
                        }
                    }
                    //将被选中单元格状态设置为选中
                    getCells()[row][column].setActive(true);
                    jPanel3.repaint();
                    int day = 0;
                    String dayText = getCells()[row][column].getText();
                    if (dayText != null && !dayText.equals("")) {
                        day = Integer.parseInt(dayText);
                        getCalendar().set(Calendar.DATE, day);
                    }

                }
            });
        }
        return jPanel3;
    }

    private class DateCell {

        private Color commonColor = null;//未被选中时的方格颜色
        private Color activeColor = Color.YELLOW;//被选中时的颜色
        private String text = null;
        private boolean isActive = false;
        //private boolean isCurrentDay=false//是否是当前天

        public void setCommonColor(Color c) {
            commonColor = c;
        }

        public void setActiveColor(Color c) {
            activeColor = c;
        }

        public void setText(String text) {
            this.text = text;
        }
        //Test Code

        public String getText() {
            return text;
        }

        public void drawYourself(Graphics g, int x, int y, int width, int height) {
            if (text == null || text.equals("")) {
                return;
            } else {
                Graphics g2 = g.create();
                g2.setFont(new Font("SansSerif", Font.BOLD, (int) height * 1 / 2));
                if (!isActive) {
                    if (commonColor != null) {
                        g2.setColor(commonColor);
                        g2.fillRect(x, y, width, height);
                    }
                } else {

                    g2.setColor(activeColor);
                    g2.fillRect(x + width / 6, y + height / 6, width * 2 / 3, height * 2 / 3);
                }
                g2.setColor(Color.BLACK);
                g2.drawString(text, x + width / 3, y + height * 2 / 3);
            }
        }

        public void setActive(boolean active) {
            isActive = active;
        }
    }

//    public static void main(String[] arg) {
//        new QDateChooser().showInDialog();
//    }
}
