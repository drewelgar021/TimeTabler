package timetable;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.time.DayOfWeek;

/**
 * Loads timetables from files and saves timetables to files.
 */
public class TimetableFactory {

    /**
     * Saves a Timetable instance to a JSON file.
     *
     * @param timetable the Timetable to save
     * @param filePath the path to the JSON file
     * @throws IOException if an I/O error occurs
     */
    public static void saveTimetable(Timetable timetable, String filePath) throws IOException {
        Gson gson = new GsonBuilder().setPrettyPrinting().create();

        try (FileWriter writer = new FileWriter(filePath)) {
            gson.toJson(timetable, writer);
        }
    }

    /**
     * Loads a Timetable instance from a JSON file.
     *
     * @param filePath the path to the JSON file
     * @return the loaded Timetable
     * @throws IOException if an I/O error occurs
     */
    public static Timetable loadTimetable(String filePath) throws IOException {
        Gson gson = new Gson();

        try (FileReader reader = new FileReader(filePath)) {
            return gson.fromJson(reader, Timetable.class);
        }
    }
}

