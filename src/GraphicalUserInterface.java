import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;

public class GraphicalUserInterface {
    public static void main(String[] args) {
        JFrame f = new JFrame("SYLLABUS APP");
        JTextArea searchBar;
        JButton benjamin, benjamin1, benjamin2, benjamin3, benjamin4, benjamin5;

        searchBar = new JTextArea();
        searchBar.setBounds(200, 10, 350, 25);

        benjamin = new JButton("Search");
        benjamin.setBounds(555, 10, 100, 25);

        benjamin1 = new JButton("Add");
        benjamin2 = new JButton("Edit");
        benjamin3 = new JButton("Delete");
        benjamin4 = new JButton("Save");
        benjamin5 = new JButton("<html>Previous<br/>Versions</html>");

        f.add(benjamin);
        f.add(benjamin1);
        f.add(benjamin2);
        f.add(benjamin3);
        f.add(benjamin4);
        f.add(benjamin5);
        f.add(searchBar);

        f.addComponentListener(new ComponentAdapter() {
            public void componentResized(ComponentEvent e) {
                int width = f.getContentPane().getWidth();
                int height = f.getContentPane().getHeight();

                benjamin1.setBounds(width - 150, 100, 100, 25);
                benjamin2.setBounds(width - 150, 130, 100, 25);
                benjamin3.setBounds(width - 150, 160, 100, 25);
                benjamin4.setBounds(width - 150, 625, 100, 25);
                benjamin5.setBounds(width - 150, 190, 100, 50);
            }
        });
        JLabel currentVersion = new JLabel("Current Syllabus");
        currentVersion.setHorizontalAlignment(SwingConstants.CENTER);
        currentVersion.setVerticalAlignment(SwingConstants.CENTER);

        currentVersion.setBounds(100, 50, 500, 600);
        currentVersion.setBorder(BorderFactory.createEtchedBorder());


        f.add(currentVersion, BorderLayout.CENTER);





        benjamin5.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                JFrame previousVersionsFrame = new JFrame("Previous Versions");
                JButton btn1, btn2;
                btn1 = new JButton("Next");
                btn2 = new JButton("Previous");

                previousVersionsFrame.add(btn1);
                previousVersionsFrame.add(btn2);


                previousVersionsFrame.addComponentListener(new ComponentAdapter() {
                    public void componentResized(ComponentEvent e) {
                        int width = previousVersionsFrame.getContentPane().getWidth();
                        int height = previousVersionsFrame.getContentPane().getHeight();

                        btn1.setBounds( width - 150, 480, 100, 25);
                        btn2.setBounds(50,   480, 100, 25);

                        int labelWidth = (width - 150) / 2; // Genişlik ayarı
                        int labelHeight = height - 100; // Yükseklik ayarı

                        JLabel previousVersionsLabel1 = new JLabel("Former Version");
                        previousVersionsLabel1.setBorder(BorderFactory.createEtchedBorder()); // Sınır çizgisi eklemek için

                        JLabel previousVersionsLabel2 = new JLabel("Current Version");
                        previousVersionsLabel2.setBorder(BorderFactory.createEtchedBorder()); // Sınır çizgisi eklemek için

                        JPanel panel = new JPanel(new GridLayout(1, 2)); // 1 satır, 2 sütunlu bir grid layout
                        panel.setBounds(50, 50, width - 100, height - 100);
                        panel.add(previousVersionsLabel1);
                        panel.add(previousVersionsLabel2);

                        previousVersionsFrame.add(panel);
                    }

                });

                previousVersionsFrame.setSize(600, 550);
                previousVersionsFrame.setLayout(null);
                previousVersionsFrame.setVisible(true);
            }
        });

        f.setSize(800, 725);
        f.setLayout(null);
        f.setVisible(true);
        f.setLocationRelativeTo(null);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}

