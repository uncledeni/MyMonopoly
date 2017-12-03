import javafx.scene.chart.AxisBuilder;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;

public class MainDemo2 extends JFrame {

    JButton mov = new JButton("Кинуть кубик");
    JButton createHouse = new JButton("Создать дом");
    JButton Buy = new JButton("Купить");
    JButton end = new JButton("Конец хода");
    JTextArea textArea = new JTextArea();

    MainDemo2(){
        super("Test frame"); // Называем наш фрейм, вызывая суперконструктор Jframe.
        createGUI(); // Вызываем метод проектирования
    }
    public static void main(String[] args) { //
        javax.swing.SwingUtilities.invokeLater(new Runnable() { // Создание фонового потока с целью предотвращения

// зависания программы. Или повисания при запуске

// иными словами отдаём проектирование фрейма другому

            // потоку
            public void run() {
                MainDemo2 frame = new MainDemo2();
                frame.pack(); // упаковщик. Распологает все элементы в нужной и заранее определенной последовательности
                // Необходим!
                frame.setLocationRelativeTo(null);
                frame.setVisible(true);
            }
        });
    }

    private void createGUI() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //Способно закрываться

        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.X_AXIS));
        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new BoxLayout(buttonPanel, BoxLayout.Y_AXIS));
        buttonPanel.add(mov);
        buttonPanel.add(createHouse);
        buttonPanel.add(Buy);
        buttonPanel.add(end);
        //0
        JPanel jPanel = new JPanel();
        jPanel.setPreferredSize(new Dimension(520, 520));
        jPanel.setLayout(null);
        JPanel jPanel1 = new JPanel();
        jPanel1.setPreferredSize(new Dimension(520, 80));
        jPanel1.setLayout(new BoxLayout(jPanel1, BoxLayout.X_AXIS));
        JPanel jPanel2 = new JPanel();
        jPanel2.setPreferredSize(new Dimension(80, 360));
        jPanel2.setLayout(new BoxLayout(jPanel2, BoxLayout.Y_AXIS));
        JPanel jPanel3 = new JPanel();
        jPanel3.setPreferredSize(new Dimension(520, 80));
        jPanel3.setLayout(new BoxLayout(jPanel3, BoxLayout.X_AXIS));
        JPanel jPanel4 = new JPanel();
        jPanel4.setPreferredSize(new Dimension(80, 360));
        jPanel4.setLayout(new BoxLayout(jPanel4, BoxLayout.Y_AXIS));

        JPanel GO = new JPanel();
        GO.setPreferredSize(new Dimension(80,80));
        GO.add(new Label("GO"));
        GO.setBorder(BorderFactory.createLineBorder(Color.GRAY, 2));

        JPanel BROWN1 = new JPanel();
        BROWN1.setBorder(BorderFactory.createLineBorder(Color.GRAY, 2));
        BROWN1.setLayout(new BoxLayout(BROWN1, BoxLayout.Y_AXIS));
        JPanel BROWN1one = new JPanel();
        BROWN1.add(BROWN1one);
        JPanel BROWN1two = new JPanel();
        BROWN1two.setBackground(Color.darkGray);
        BROWN1.add(BROWN1two);
        JPanel BROWN1three = new JPanel();
        BROWN1.add(BROWN1three);
        JPanel CommunityChest1 = new JPanel();
        CommunityChest1.setBorder(BorderFactory.createLineBorder(Color.GRAY, 2));
        JPanel BROWN2 = new JPanel();
        BROWN2.setBorder(BorderFactory.createLineBorder(Color.GRAY, 2));
        BROWN2.setLayout(new BoxLayout(BROWN2, BoxLayout.Y_AXIS));
        JPanel BROWN2one = new JPanel();
        BROWN2.add(BROWN2one);
        JPanel BROWN2two = new JPanel();
        BROWN2two.setBackground(Color.darkGray);
        BROWN2.add(BROWN2two);
        JPanel BROWN2three = new JPanel();
        BROWN2.add(BROWN2three);
        JPanel PayMoney1 = new JPanel();
        // PayMoney1.add(new Label("-"));
        PayMoney1.setBorder(BorderFactory.createLineBorder(Color.GRAY, 2));
        JPanel Railroad1 = new JPanel();
        // Railroad1.add(new Label("RR"));
        Railroad1.setBorder(BorderFactory.createLineBorder(Color.GRAY, 2));
        JPanel AZURE1 = new JPanel();
        AZURE1.setLayout(new BoxLayout(AZURE1, BoxLayout.Y_AXIS));
        AZURE1.setBorder(BorderFactory.createLineBorder(Color.GRAY, 2));
        JPanel AZURE1one = new JPanel();
        AZURE1.add(AZURE1one);
        JPanel AZURE1two = new JPanel();
        AZURE1two.setBackground(Color.cyan);
        AZURE1.add(AZURE1two);
        JPanel AZURE1three = new JPanel();
        AZURE1.add(AZURE1three);
        JPanel Chance1 = new JPanel();
        // Chance1.add(new Label("?"));
        Chance1.setBorder(BorderFactory.createLineBorder(Color.GRAY, 2));
        JPanel AZURE2 = new JPanel();
        AZURE2.setBorder(BorderFactory.createLineBorder(Color.GRAY, 2));
        AZURE2.setLayout(new BoxLayout(AZURE2, BoxLayout.Y_AXIS));
        JPanel AZURE2one = new JPanel();
        AZURE2.add(AZURE2one);
        JPanel AZURE2two = new JPanel();
        AZURE2two.setBackground(Color.cyan);
        AZURE2.add(AZURE2two);
        JPanel AZURE2three = new JPanel();
        AZURE2.add(AZURE2three);
        JPanel AZURE3 = new JPanel();
        AZURE3.setBorder(BorderFactory.createLineBorder(Color.GRAY, 2));
        AZURE3.setLayout(new BoxLayout(AZURE3, BoxLayout.Y_AXIS));
        JPanel AZURE3one = new JPanel();
        AZURE3.add(AZURE3one);
        JPanel AZURE3two = new JPanel();
        AZURE3two.setBackground(Color.cyan);
        AZURE3.add(AZURE3two);
        JPanel AZURE3three = new JPanel();
        AZURE3.add(AZURE3three);
        //1
        JPanel JAIL = new JPanel();
        JAIL.setPreferredSize(new Dimension(80,80));
        JAIL.setBorder(BorderFactory.createLineBorder(Color.GRAY, 2));
        JPanel PINK1 = new JPanel();
        PINK1.setLayout(new BoxLayout(PINK1, BoxLayout.X_AXIS));
        PINK1.setBorder(BorderFactory.createLineBorder(Color.GRAY, 2));
        JPanel PINK1one = new JPanel();
        PINK1.add(PINK1one);
        JPanel PINK1two = new JPanel();
        PINK1two.setBackground(Color.MAGENTA);
        PINK1.add(PINK1two);
        JPanel PINK1three = new JPanel();
        PINK1.add(PINK1three);
        JPanel SERVICES1 = new JPanel();
        SERVICES1.setBorder(BorderFactory.createLineBorder(Color.GRAY, 2));
        JPanel PINK2 = new JPanel();
        PINK2.setBorder(BorderFactory.createLineBorder(Color.GRAY, 2));
        PINK2.setLayout(new BoxLayout(PINK2, BoxLayout.X_AXIS));
        JPanel PINK2one = new JPanel();
        PINK2.add(PINK2one);
        JPanel PINK2two = new JPanel();
        PINK2two.setBackground(Color.MAGENTA);
        PINK2.add(PINK2two);
        JPanel PINK2three = new JPanel();
        PINK2.add(PINK2three);
        JPanel PINK3 = new JPanel();
        PINK3.setBorder(BorderFactory.createLineBorder(Color.GRAY, 2));
        PINK3.setLayout(new BoxLayout(PINK3, BoxLayout.X_AXIS));
        JPanel PINK3one = new JPanel();
        PINK3.add(PINK3one);
        JPanel PINK3two = new JPanel();
        PINK3two.setBackground(Color.MAGENTA);
        PINK3.add(PINK3two);
        JPanel PINK3three = new JPanel();
        PINK3.add(PINK3three);
        JPanel Railroad2 = new JPanel();
        Railroad2.setBorder(BorderFactory.createLineBorder(Color.GRAY, 2));
        JPanel ORANGE1 = new JPanel();
        ORANGE1.setBorder(BorderFactory.createLineBorder(Color.GRAY, 2));
        ORANGE1.setLayout(new BoxLayout(ORANGE1, BoxLayout.X_AXIS));
        JPanel ORANGE1one = new JPanel();
        ORANGE1.add(ORANGE1one);
        JPanel ORANGE1two = new JPanel();
        ORANGE1two.setBackground(Color.ORANGE);
        ORANGE1.add(ORANGE1two);
        JPanel ORANGE1three = new JPanel();
        ORANGE1.add(ORANGE1three);
        JPanel CommunityChest2 = new JPanel();
        CommunityChest2.setBorder(BorderFactory.createLineBorder(Color.GRAY, 2));
        JPanel ORANGE2 = new JPanel();
        ORANGE2.setBorder(BorderFactory.createLineBorder(Color.GRAY, 2));
        ORANGE2.setLayout(new BoxLayout(ORANGE2, BoxLayout.X_AXIS));

        JPanel ORANGE2one = new JPanel();
        ORANGE2.add(ORANGE2one);
        JPanel ORANGE2two = new JPanel();
        ORANGE2two.setBackground(Color.ORANGE);
        ORANGE2.add(ORANGE2two);
        JPanel ORANGE2three = new JPanel();
        ORANGE2.add(ORANGE2three);
        JPanel ORANGE3 = new JPanel();
        ORANGE3.setBorder(BorderFactory.createLineBorder(Color.GRAY, 2));
        ORANGE3.setLayout(new BoxLayout(ORANGE3, BoxLayout.X_AXIS));
        JPanel ORANGE3one = new JPanel();
        ORANGE3.add(ORANGE3one);
        JPanel ORANGE3two = new JPanel();
        ORANGE3two.setBackground(Color.ORANGE);
        ORANGE3.add(ORANGE3two);
        JPanel ORANGE3three = new JPanel();
        ORANGE3.add(ORANGE3three);
        //2
        JPanel FreeParking = new JPanel();
        FreeParking.setPreferredSize(new Dimension(80,80));
        FreeParking.setBorder(BorderFactory.createLineBorder(Color.GRAY, 2));
        FreeParking.add(new Label("FREE"));
        JPanel RED1 = new JPanel();
        //RED1.setPreferredSize(new Dimension(80,60));
        RED1.setBorder(BorderFactory.createLineBorder(Color.GRAY, 2));
        RED1.setLayout(new BoxLayout(RED1, BoxLayout.Y_AXIS));
        JPanel RED1one = new JPanel();
        RED1.add(RED1one);
        JPanel RED1two = new JPanel();
        RED1two.setBackground(Color.RED);
        RED1.add(RED1two);
        JPanel RED1three = new JPanel();
        RED1.add(RED1three);
        JPanel Chance2 = new JPanel();
        Chance2.setBorder(BorderFactory.createLineBorder(Color.GRAY, 2));
        JPanel RED2 = new JPanel();
        RED2.setBorder(BorderFactory.createLineBorder(Color.GRAY, 2));
        RED2.setLayout(new BoxLayout(RED2, BoxLayout.Y_AXIS));
        JPanel RED2one = new JPanel();
        RED2.add(RED2one);
        JPanel RED2two = new JPanel();
        RED2two.setBackground(Color.RED);
        RED2.add(RED2two);
        JPanel RED2three = new JPanel();
        RED2.add(RED2three);
        JPanel Railroad3 = new JPanel();
        Railroad3.setBorder(BorderFactory.createLineBorder(Color.GRAY, 2));
        JPanel RED3 = new JPanel();
        RED3.setBorder(BorderFactory.createLineBorder(Color.GRAY, 2));
        RED3.setLayout(new BoxLayout(RED3, BoxLayout.Y_AXIS));
        JPanel RED3one = new JPanel();
        RED3.add(RED3one);
        JPanel RED3two = new JPanel();
        RED3two.setBackground(Color.RED);
        RED3.add(RED3two);
        JPanel RED3three = new JPanel();
        RED3.add(RED3three);
        JPanel YELLOW1 = new JPanel();
        YELLOW1.setBorder(BorderFactory.createLineBorder(Color.GRAY, 2));
        YELLOW1.setLayout(new BoxLayout(YELLOW1, BoxLayout.Y_AXIS));
        JPanel YELLOW1one = new JPanel();
        YELLOW1.add(YELLOW1one);
        JPanel YELLOW1two = new JPanel();
        YELLOW1two.setBackground(Color.yellow);
        YELLOW1.add(YELLOW1two);
        JPanel YELLOW1three = new JPanel();
        YELLOW1.add(YELLOW1three);
        JPanel YELLOW2 = new JPanel();
        YELLOW2.setBorder(BorderFactory.createLineBorder(Color.GRAY, 2));
        YELLOW2.setLayout(new BoxLayout(YELLOW2, BoxLayout.Y_AXIS));
        JPanel YELLOW2one = new JPanel();
        YELLOW2.add(YELLOW2one);
        JPanel YELLOW2two = new JPanel();
        YELLOW2two.setBackground(Color.yellow);
        YELLOW2.add(YELLOW2two);
        JPanel YELLOW2three = new JPanel();
        YELLOW2.add(YELLOW2three);
        JPanel SERVICES3 = new JPanel();
        SERVICES3.setBorder(BorderFactory.createLineBorder(Color.GRAY, 2));
        JPanel YELLOW3 = new JPanel();
        YELLOW3.setBorder(BorderFactory.createLineBorder(Color.GRAY, 2));
        YELLOW3.setLayout(new BoxLayout(YELLOW3, BoxLayout.Y_AXIS));
        JPanel YELLOW3one = new JPanel();
        YELLOW3.add(YELLOW3one);
        JPanel YELLOW3two = new JPanel();
        YELLOW3two.setBackground(Color.yellow);
        YELLOW3.add(YELLOW3two);
        JPanel YELLOW3three = new JPanel();
        YELLOW3.add(YELLOW3three);
        //3
        JPanel GoToJail = new JPanel();
        GoToJail.setPreferredSize(new Dimension(80,80));
        GoToJail.setBorder(BorderFactory.createLineBorder(Color.GRAY, 2));
        GoToJail.add(new Label("Go To JAIL"));
        JPanel GREAN1 = new JPanel();
        //GREAN1.setPreferredSize(new Dimension(80, 40));
        GREAN1.setBorder(BorderFactory.createLineBorder(Color.GRAY, 2));
        GREAN1.setLayout(new BoxLayout(GREAN1, BoxLayout.X_AXIS));
        JPanel GREAN1one = new JPanel();
        GREAN1.add(GREAN1one);
        JPanel GREAN1two = new JPanel();
        GREAN1two.setBackground(Color.GREEN);
        GREAN1.add(GREAN1two);
        JPanel GREAN1three = new JPanel();
        GREAN1.add(GREAN1three);
        JPanel GREAN2 = new JPanel();
        GREAN2.setBorder(BorderFactory.createLineBorder(Color.GRAY, 2));
        GREAN2.setLayout(new BoxLayout(GREAN2, BoxLayout.X_AXIS));
        JPanel GREAN2one = new JPanel();
        GREAN2.add(GREAN2one);
        JPanel GREAN2two = new JPanel();
        GREAN2two.setBackground(Color.GREEN);
        GREAN2.add(GREAN2two);
        JPanel GREAN2three = new JPanel();
        GREAN2.add(GREAN2three);
        JPanel CommunityChest3 = new JPanel();
        CommunityChest3.setBorder(BorderFactory.createLineBorder(Color.GRAY, 2));
        JPanel GREAN3 = new JPanel();
        GREAN3.setBorder(BorderFactory.createLineBorder(Color.GRAY, 2));
        GREAN3.setLayout(new BoxLayout(GREAN3, BoxLayout.X_AXIS));
        JPanel GREAN3one = new JPanel();
        GREAN3.add(GREAN3one);
        JPanel GREAN3two = new JPanel();
        GREAN3two.setBackground(Color.GREEN);
        GREAN3.add(GREAN3two);
        JPanel GREAN3three = new JPanel();
        GREAN3.add(GREAN3three);
        JPanel Railroad4 = new JPanel();
        Railroad4.setBorder(BorderFactory.createLineBorder(Color.GRAY, 2));
        JPanel Chance3 = new JPanel();
        Chance3.setBorder(BorderFactory.createLineBorder(Color.GRAY, 2));
        JPanel BLUE1 = new JPanel();
        BLUE1.setBorder(BorderFactory.createLineBorder(Color.GRAY, 2));
        BLUE1.setLayout(new BoxLayout(BLUE1, BoxLayout.X_AXIS));
        JPanel BLUE1one = new JPanel();
        BLUE1.add(BLUE1one);
        JPanel BLUE1two = new JPanel();
        BLUE1two.setBackground(Color.blue);
        BLUE1.add(BLUE1two);
        JPanel BLUE1three = new JPanel();
        BLUE1.add(BLUE1three);
        JPanel PayMoney2 = new JPanel();
        PayMoney2.setBorder(BorderFactory.createLineBorder(Color.GRAY, 2));
        JPanel BLUE2 = new JPanel();
        BLUE2.setBorder(BorderFactory.createLineBorder(Color.GRAY, 2));
        BLUE2.setLayout(new BoxLayout(BLUE2, BoxLayout.X_AXIS));
        JPanel BLUE2one = new JPanel();
        BLUE2.add(BLUE2one);
        JPanel BLUE2two = new JPanel();
        BLUE2two.setBackground(Color.blue);
        BLUE2.add(BLUE2two);
        JPanel BLUE2three = new JPanel();
        BLUE2.add(BLUE2three);

        jPanel1.add(JAIL);
        jPanel1.add(AZURE3);
        jPanel1.add(AZURE2);
        jPanel1.add(Chance1);
        jPanel1.add(AZURE1);
        jPanel1.add(Railroad1);
        jPanel1.add(PayMoney1);
        jPanel1.add(BROWN2);
        jPanel1.add(CommunityChest1);
        jPanel1.add(BROWN1);
        jPanel1.add(GO);

        jPanel2.add(ORANGE3);
        jPanel2.add(ORANGE2);
        jPanel2.add(CommunityChest2);
        jPanel2.add(ORANGE1);
        jPanel2.add(Railroad2);
        jPanel2.add(PINK3);
        jPanel2.add(PINK2);
        jPanel2.add(SERVICES1);
        jPanel2.add(PINK1);

        jPanel3.add(FreeParking);
        jPanel3.add(RED1);
        jPanel3.add(RED2);
        jPanel3.add(Chance2);
        jPanel3.add(RED3);
        jPanel3.add(Railroad3);
        jPanel3.add(YELLOW1);
        jPanel3.add(YELLOW2);
        jPanel3.add(SERVICES3);
        jPanel3.add(YELLOW3);
        jPanel3.add(GoToJail);

        jPanel4.add(GREAN1);
        jPanel4.add(GREAN2);
        jPanel4.add(CommunityChest3);
        jPanel4.add(GREAN3);
        jPanel4.add(Railroad4);
        jPanel4.add(Chance3);
        jPanel4.add(BLUE1);
        jPanel4.add(PayMoney2);
        jPanel4.add(BLUE2);

        jPanel.add(jPanel1);
        jPanel.add( jPanel2);
        jPanel.add( jPanel4);
        jPanel.add( jPanel3);

        Insets insets = jPanel.getInsets();
        Dimension size = jPanel1.getPreferredSize();

        jPanel1.setBounds(insets.left, 437 + insets.top, size.width, size.height);
        size = jPanel2.getPreferredSize();
        jPanel2.setBounds(insets.left, 80 + insets.top, size.width, size.height);
        size = jPanel3.getPreferredSize();
        jPanel3.setBounds(insets.left, insets.top,  size.width, size.height);
        size = jPanel4.getPreferredSize();
        jPanel4.setBounds(437 + insets.right, 80 + insets.top,  size.width, size.height);

        JPanel textInfo = new JPanel();
        textInfo.setLayout(new BorderLayout());
        textInfo.setPreferredSize(new Dimension(120 ,300));
        Border titled = BorderFactory.createTitledBorder("Информация");
        textInfo.setBorder(titled);
        JScrollPane scroller = new JScrollPane(textArea);
        scroller.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        textArea.setLineWrap(true);
        textArea.setWrapStyleWord(true);
        textArea.setEditable(false);
        textInfo.add(scroller);
        buttonPanel.add(textInfo);

        mainPanel.add(jPanel);
        mainPanel.add(buttonPanel);

        getContentPane().add(mainPanel); // добавляем финальную панель во фрейм

        setPreferredSize(new Dimension(720, 550)); // Задаём фрейму размеры
    }
}
