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

        String os = System.getProperty("os.name").toLowerCase();
        String typstPath;

        if (os.contains("win")) {
            typstPath = "Typst/win/typst.exe";
        } else if (os.contains("mac")) {
            typstPath = "Typst/mac/typst";
        } else {
            typstPath = "Typst/linux/typst";
        }

        ProcessBuilder processBuilder = new ProcessBuilder(
                typstPath, "compile", "timetable_builder.typ", output
        );
        processBuilder.directory(new File(System.getProperty("user.dir")));
        processBuilder.inheritIO();

        Process process = processBuilder.start();
    }
}
