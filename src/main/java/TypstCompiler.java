import java.io.File;
import java.io.IOException;

/**
 * Manages compilation of the Typst timetable builder
 */
public class TypstCompiler {
    /**
     * Generates a PDF timetable based on the timetable json located at /ConvertToPDF.json
     * @param output Path of the generated PDF file
     */
    public static void generatePDF(String output) throws IOException {
        ProcessBuilder processBuilder = new ProcessBuilder(
                "typst", "compile", "timetable_builder.typ", output
        );
        processBuilder.directory(new File(System.getProperty("user.dir")));
        processBuilder.inheritIO();

        Process process = processBuilder.start();
    }
}
