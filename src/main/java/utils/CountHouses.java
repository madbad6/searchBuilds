package utils;

import java.util.HashMap;
import java.util.Map;

public class CountHouses {

    private final Map<String, int[]> countFloor;
    private final SearchMatches searchMatches;

    public CountHouses() {
        countFloor = new HashMap<>();
        searchMatches = new SearchMatches();
    }

    public void searchForCountHouses(String city, int floor) {
        if (floor <= 5) {
            int[] floors = countFloor.getOrDefault(city, new int[]{0, 0, 0, 0, 0});
            ++floors[floor - 1];
            countFloor.put(city, floors);
        }
    }

    public void outputOfFloors() {
        String format = "%-20s %-6s %-6s %-6s %-6s %-6s";
        System.out.format(format, "City", "1", "2", "3", "4", "5");
        System.out.println();
        countFloor
                .entrySet()
                .parallelStream()
                .forEach(root -> {
                    int[] array = root.getValue();
                    System.out.format(format, root.getKey(), array[0], array[1], array[2], array[3], array[4]);
                    System.out.println();
                });
    }
}
