import model.Root;
import org.xml.sax.Attributes;
import org.xml.sax.helpers.DefaultHandler;
import utils.CountHouses;
import utils.SearchMatches;

public class ParserFile extends DefaultHandler {

    private final CountHouses countHouses;
    private final SearchMatches searchMatches;
    private boolean match;

    public ParserFile() {
        countHouses = new CountHouses();
        searchMatches = new SearchMatches();
    }

    public CountHouses getCountHouses() {
        return countHouses;
    }

    public SearchMatches getSearchMatches() {
        return searchMatches;
    }

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) {
        if (qName.equalsIgnoreCase("item")) {
            Root root = new Root();
            root.setCity(attributes.getValue("city"));
            root.setStreet(attributes.getValue("street"));
            root.setHouse(Integer.parseInt(attributes.getValue("house")));
            root.setFloor(Integer.parseInt(attributes.getValue("floor")));

            match = searchMatches.searchForMatches(root);
            if (!match)
                countHouses.searchForCountHouses(root.getCity(), root.getFloor());
        }
    }
}
