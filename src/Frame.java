import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Frame extends JFrame implements ActionListener {
    JLabel timeLabel = new JLabel();
    JButton startButton = new JButton("START");
    JButton resetButton = new JButton("RESET");
    int elapsedTime = 0;
    int hour = 0;
    int minute = 0;
    int second = 0;
    boolean started = false; // Check button is stated or not
    String second_string = String.format("%02d", second); // format string to Double-Digit int format ex. 00
    String minute_string = String.format("%02d", minute); // format string to Double-Digit int format ex. 00
    String hour_string = String.format("%02d", hour); // format string to Double-Digit int format ex. 00

    // Timer class for increment time by 1000 milliseconds
    // timer class start
    Timer timer = new Timer(1000,
            (e) -> {
        elapsedTime += 1000;
        hour = elapsedTime / 3600000;
        minute = elapsedTime / '\uea60' % 60;
        second = elapsedTime / 1000;
        second_string = String.format("%02d", second);
        minute_string = String.format("%02d", minute);
        hour_string = String.format("%02d", hour);
        timeLabel.setText(hour_string + " : " + minute_string + " : " + second_string);
    });
    // timer class end

    Frame() {

        // label which represent time as 00 : 00 : 00
        // JLabel timeLabel start
        timeLabel.setText(hour_string + " : " + minute_string + " : " + second_string);
        timeLabel.setPreferredSize(new Dimension(450, 100));
        timeLabel.setFont(new Font("Chilanka", Font.PLAIN, 80));
        timeLabel.setBorder(BorderFactory.createBevelBorder(1));
        timeLabel.setBackground(Color.YELLOW);
        timeLabel.setOpaque(true);
        timeLabel.setHorizontalAlignment(0);
        timeLabel.setVerticalAlignment(0);
        // JLabel timeLabel end

        // start button start
        startButton.setFont(new Font("aakar", Font.ITALIC, 30));
        startButton.setPreferredSize(new Dimension(200, 50));
        startButton.setFocusable(false);
        startButton.addActionListener(this);
        // start button end

        // reset button start
        resetButton.setFont(new Font("aakar", Font.ITALIC, 30));
        resetButton.setPreferredSize(new Dimension(200, 50));
        resetButton.setFocusable(false);
        resetButton.addActionListener(this);
        // reset button end

        // adding components in JFrame start
        this.add(timeLabel);
        this.add(startButton);
        this.add(resetButton);
        // adding components in JFrame end

        // JFrame start
        this.setTitle("Harsh Stop Watch");
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setLayout(new FlowLayout(FlowLayout.CENTER, 20, 20));
        this.setSize(500, 250);
        this.setResizable(false);
        this.setLocationRelativeTo(null);
        this.setVisible(true);
        // JFrame end
    }

    // ActionPerformed method which accept action listener
    // ActionPerformed start
    public void actionPerformed(ActionEvent e) {
        // start button action listener start
        if (e.getSource() == startButton) {
            if (!started) {
                started = true;
                startButton.setText("STOP");
                start();
            }
            // convert start button to stop button
            else {
                started = false;
                startButton.setText("START");
                stop();
            }
        }
        // start button action listener end

        // reStart button action listener start
        if (e.getSource() == resetButton) {
            started = false;
            startButton.setText("START");
            reStart();
        }
        // reStart button action listener end
    }
    // ActionPerformed end

    // start timer method start
    public void start() {
        timer.start();
        timeLabel.setBackground(Color.GREEN);
    }
    // start timer method end

    // stop timer method start
    public void stop() {
        timer.stop();
        timeLabel.setBackground(Color.RED);
    }
    // stop timer method start

    // reStart timer method start
    private void reStart() {
        stop();
        elapsedTime = 0;
        hour = 0;
        minute = 0;
        second = 0;
        second_string = String.format("%02d", second);
        minute_string = String.format("%02d", minute);
        hour_string = String.format("%02d", hour);
        timeLabel.setBackground(Color.YELLOW);
        timeLabel.setText(hour_string + " : " + minute_string + " : " + second_string);
    }
    // reStart timer method start
}