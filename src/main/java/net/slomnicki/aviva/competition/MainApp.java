package net.slomnicki.aviva.competition;

import net.slomnicki.aviva.competition.error.XmlParseException;
import net.slomnicki.aviva.competition.model.Clients;

import java.io.File;

/**
 * Main application class
 *
 * @author Marek Słomnicki <marek@slomnicki.net>
 */
public class MainApp {

    public static void main(String[] args) {
        // Check args
        if(args.length != 1) {
            System.err.println("You have to provide XML file name as a parameter");
            System.exit(0);
        }
        XmlParser parser = new XmlParser();
        try {
            Clients clients = parser.readAndParseXmlFile(new File(args[0]));
            clients.getClientList().forEach(System.out::println);
        } catch (XmlParseException e) {
            System.err.println("Error occured: " + e.getMessage());
        }
    }
}
