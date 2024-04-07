package kiemtra;
import java.io.IOException;
import java.nio.file.*;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Model {
    private List<String> lines;

    public Model() {
        this.lines = new ArrayList<>();
    }

    public void loadFromFile(Path filePath) throws IOException {
        try (Stream<String> stream = Files.lines(filePath)) {
            lines = stream.collect(Collectors.toList());
        }
    }

    public void saveToFile(Path filePath) throws IOException {
        Files.write(filePath, lines);
    }

    public void setText(String text) {
        lines = Arrays.asList(text.split("\n"));
    }

    public String getText() {
        return String.join("\n", lines);	
    }
    public List<Path> listFiles(Path path) throws IOException {
        if (!Files.isDirectory(path)) {
            return Collections.emptyList();
        }
        try (Stream<Path> walk = Files.walk(path)) {
            return walk.filter(Files::isRegularFile).collect(Collectors.toList());
        }
    }
}