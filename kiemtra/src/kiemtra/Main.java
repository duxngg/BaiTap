package kiemtra;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Scanner;

import javax.swing.*;


public class Main {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            Model model = new Model();
            Scanner scanner = new Scanner(System.in);

            System.out.print("Nhập đường dẫn thư mục: ");
            Path directoryPath = Paths.get(scanner.nextLine());
            //Path directoryPath = Paths.get("C:\\Users\\HP\\Desk top\\BaiTapHTML\\HTML");
            try {
                List<Path> directories = model.listFiles(directoryPath);
                for (Path directory : directories) {
                    //System.out.println(directory.getFileName());
                    Path outputPath = Paths.get("data.txt");
                    Files.write(outputPath, directories.stream().map(Path::toString).toList());
                    //System.out.println("Dữ liệu đã được ghi vào tệp tin data.txt.");
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
            Path filePath = Paths.get("data.txt");
            try {
                model.loadFromFile(filePath);
                String text = model.getText();
                System.out.println("Dữ liệu được load từ tệp tin data.txt:");
                System.out.println(text);
            } catch (IOException e) {
                e.printStackTrace();
            }
            View view = new View();
            new Control(model, view);
            JFrame jFrame = new JFrame();
			jFrame.setVisible(true);
        });
    }
}