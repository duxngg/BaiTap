package kiemtra;
import javax.swing.*;
import java.awt.*;

public class View {
    private JFrame frame;
    private JTextArea textArea;
    private JButton openButton;
    private JButton saveButton;
    private JFileChooser fileChooser;

    public View() {
        frame = new JFrame("Text Editor");
        textArea = new JTextArea(20, 40);
        openButton = new JButton("Open");
        saveButton = new JButton("Save");
        fileChooser = new JFileChooser();

        frame.setLayout(new BorderLayout());
        frame.add(openButton, BorderLayout.NORTH);
        frame.add(new JScrollPane(textArea), BorderLayout.CENTER);
        frame.add(saveButton, BorderLayout.SOUTH);

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setLocationRelativeTo(null);
    }


    public JFrame getFrame() {
        return frame;
    }

    public JTextArea getTextArea() {
        return textArea;
    }

    public JButton getOpenButton() {
        return openButton;
    }

    public JButton getSaveButton() {
        return saveButton;
    }

    public JFileChooser getFileChooser() {
        return fileChooser;
    }
}