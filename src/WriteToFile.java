import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class WriteToFile {

    private FileWriter writer;
    private BufferedWriter bufferedWriter;

    public WriteToFile(String file) {

        try {

            this.writer = new FileWriter(file, true);
            this.bufferedWriter = new BufferedWriter(writer);
        }  catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void writeToFile(String text) {
        try {
            this.bufferedWriter.write(text);
            this.bufferedWriter.newLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}