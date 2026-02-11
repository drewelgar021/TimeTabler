package timetable;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import java.io.File;
import java.io.IOException;
import java.time.DayOfWeek;

/**
 * Loads timetables from files and saves timetables to files.
 */
public class TimetableFactory {

    /**
     * Saves a Timetable instance to an XML file.
     *
     * @param timetable the Timetable to save
     * @param filePath the path to the XML file
     * @throws ParserConfigurationException if a DocumentBuilder cannot be created
     * @throws TransformerException if an error occurs during XML transformation
     */
    public static void saveTimetable(Timetable timetable, String filePath)
            throws ParserConfigurationException, TransformerException {

        DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder docBuilder = docFactory.newDocumentBuilder();
        Document doc = docBuilder.newDocument();

        // Root element: timetable
        Element rootElement = doc.createElement("timetable");
        doc.appendChild(rootElement);

        // Timetable title
        Element titleElement = doc.createElement("title");
        titleElement.setTextContent(timetable.getTitle());
        rootElement.appendChild(titleElement);

        // Start time
        Element startTimeElement = doc.createElement("startTime");
        startTimeElement.setTextContent(String.valueOf(timetable.getStartTime()));
        rootElement.appendChild(startTimeElement);

        // End time
        Element endTimeElement = doc.createElement("endTime");
        endTimeElement.setTextContent(String.valueOf(timetable.getEndTime()));
        rootElement.appendChild(endTimeElement);

        // Events container
        Element eventsElement = doc.createElement("events");
        rootElement.appendChild(eventsElement);

        // Add each event
        for (Event event : timetable.getEvents()) {
            Element eventElement = doc.createElement("event");

            // Event title
            Element eventTitle = doc.createElement("title");
            eventTitle.setTextContent(event.getTitle());
            eventElement.appendChild(eventTitle);

            // Event description
            Element eventDescription = doc.createElement("description");
            eventDescription.setTextContent(event.getDescription());
            eventElement.appendChild(eventDescription);

            // Event day
            Element eventDay = doc.createElement("day");
            eventDay.setTextContent(event.getDay().name());
            eventElement.appendChild(eventDay);

            // Event start time
            Element eventStartTime = doc.createElement("startTime");
            eventStartTime.setTextContent(String.valueOf(event.getStartTime()));
            eventElement.appendChild(eventStartTime);

            // Event end time
            Element eventEndTime = doc.createElement("endTime");
            eventEndTime.setTextContent(String.valueOf(event.getEndTime()));
            eventElement.appendChild(eventEndTime);

            // Event type
            Element eventType = doc.createElement("eventType");
            eventType.setTextContent(event.getEventType().name());
            eventElement.appendChild(eventType);

            eventsElement.appendChild(eventElement);
        }

        // Write to XML file
        TransformerFactory transformerFactory = TransformerFactory.newInstance();
        Transformer transformer = transformerFactory.newTransformer();
        transformer.setOutputProperty(OutputKeys.INDENT, "yes");
        transformer.setOutputProperty("{http://xml.apache.org/xslt}indent-amount", "4");

        DOMSource source = new DOMSource(doc);
        StreamResult result = new StreamResult(new File(filePath));
        transformer.transform(source, result);
    }

    /**
     * Loads a Timetable instance from an XML file.
     *
     * @param filePath the path to the XML file
     * @return the loaded Timetable
     * @throws ParserConfigurationException if a DocumentBuilder cannot be created
     * @throws IOException if an I/O error occurs
     * @throws SAXException if a parsing error occurs
     */
    public static Timetable loadTimetable(String filePath)
            throws ParserConfigurationException, IOException, SAXException {

        File xmlFile = new File(filePath);
        DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder docBuilder = docFactory.newDocumentBuilder();
        Document doc = docBuilder.parse(xmlFile);
        doc.getDocumentElement().normalize();

        // Read timetable title
        String title = doc.getElementsByTagName("title").item(0).getTextContent();

        // Read start and end times
        int startTime = Integer.parseInt(doc.getElementsByTagName("startTime").item(0).getTextContent());
        int endTime = Integer.parseInt(doc.getElementsByTagName("endTime").item(0).getTextContent());

        // Create timetable
        Timetable timetable = new Timetable(title, startTime, endTime);

        // Read events
        NodeList eventNodes = doc.getElementsByTagName("event");
        for (int i = 0; i < eventNodes.getLength(); i++) {
            Element eventElement = (Element) eventNodes.item(i);

            String eventTitle = eventElement.getElementsByTagName("title").item(0).getTextContent();
            String eventDescription = eventElement.getElementsByTagName("description").item(0).getTextContent();
            DayOfWeek eventDay = DayOfWeek.valueOf(eventElement.getElementsByTagName("day").item(0).getTextContent());
            double eventStartTime = Double.parseDouble(eventElement.getElementsByTagName("startTime").item(0).getTextContent());
            double eventEndTime = Double.parseDouble(eventElement.getElementsByTagName("endTime").item(0).getTextContent());
            EventType eventType = EventType.valueOf(eventElement.getElementsByTagName("eventType").item(0).getTextContent());

            Event event = new Event(eventTitle, eventDescription, eventDay, eventStartTime, eventEndTime, eventType);
            timetable.addEvent(event);
        }

        return timetable;
    }
}

