package kiemtra;
import java.awt.event.ActionEvent;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

import javax.swing.JFileChooser;

public class Control {
    private Model model;
    private View view;
    public Control(Model model, View view) {
        this.model = model;
        this.view = view;
        view.getOpenButton().addActionListener(this::onOpen);    
        view.getSaveButton().addActionListener(this::onSave);
    }

    private void onOpen(ActionEvent e) {
        if (view.getFileChooser().showOpenDialog(view.getFrame()) == JFileChooser.APPROVE_OPTION) {
            try {
                model.loadFromFile(view.getFileChooser().getSelectedFile().toPath());
                view.getTextArea().setText(model.getText());
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
    }
    private void onSave(ActionEvent e) {
        if (view.getFileChooser().showSaveDialog(view.getFrame()) == JFileChooser.APPROVE_OPTION) {
            try {
                model.setText(view.getTextArea().getText());
                model.saveToFile(view.getFileChooser().getSelectedFile().toPath());
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
    }
}