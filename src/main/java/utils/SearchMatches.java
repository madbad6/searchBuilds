package utils;

import model.Root;

import java.util.HashMap;
import java.util.Map;


public class SearchMatches {

    private final Map<Root, Long> roots;

    public SearchMatches() {
        roots = new HashMap<>();
    }

    public boolean searchForMatches(Root root) {
        if (roots.containsKey(root)) {
            roots.put(root, roots.get(root) + 1);
            return true;
        } else {
            roots.put(root, 1L);
            return false;
        }
    }

    public void outputNumberRepetition() {
        String format = "%-50s %-6s";
        System.out.format(format, "Address replay", "count");
        System.out.println();
        roots
                .entrySet()
                .parallelStream()
                .filter(root -> root.getValue() > 1)
                .forEach(result -> {
                    Root root = result.getKey();
                    System.out.format(format, root.getCity() + ", " + root.getStreet() + ", " + root.getHouse() + ", " + root.getFloor(), result.getValue());
                    System.out.println();
                });
        System.out.println();
    }
}
