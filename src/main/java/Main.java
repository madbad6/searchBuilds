import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class Main {

    static SAXParserFactory saxParserFactory;
    static SAXParser saxParser;
    static ParserFile parserFile;

    public static void main(String[] args) {
        startedApp();
    }

    public static String userInput(String string) {
        System.out.println(string);
        String userInput = new Scanner(System.in).nextLine();
        if (userInput.equals("out")) {
            System.exit(0);
        }
        return userInput;
    }

    public static void startedApp() {
        parserFile = new ParserFile();
        File file = new File(userInput("enter the file address or the \"out\" to exit"));
        if (file.isFile() && file.exists()) {
            try {
                saxParserFactory = SAXParserFactory.newInstance();
                saxParser = saxParserFactory.newSAXParser();
                saxParser.parse(file, parserFile);
            } catch (ParserConfigurationException | SAXException | IOException e) {
                e.printStackTrace();
            }
            parserFile.getSearchMatches().outputNumberRepetition();
            parserFile.getCountHouses().outputOfFloors();
        } else {
            System.out.println("File not found");
            startedApp();
        }
        startedApp();
    }
}
