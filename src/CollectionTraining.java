import java.util.*;

import static java.util.Comparator.comparing;

public class CollectionTraining {


    public static void main(String[] args) {
        System.out.println(popularSize2());
    }

    // Return the number of occurrences for the most popular sizes present in the collection. If more sizes have the max occurrences, return -1
    private static int popularSize() {
        int listSize = API.getListLength();
        Set<Integer> setOfSizes = new HashSet<>();
        for(int i = 0; i < listSize; i ++) {
            setOfSizes.add(API.getSize(i));
        }
        Map<Integer, Integer> mapOfOccurrances = new HashMap<>();
        setOfSizes.forEach(singleSize -> {
            int count = 0;
            for (int i = 0; i < listSize; i ++) {
                if (API.getSize(i) == singleSize) {
                    count ++;
                }
            }
            mapOfOccurrances.put(singleSize, count);
        });
        System.out.println(mapOfOccurrances.toString());
        Map.Entry<Integer, Integer> maxEntry = Collections.max(mapOfOccurrances.entrySet(), comparing(Map.Entry::getValue));
        List<Integer> listSizes = new ArrayList<>();
        for (int i = 0; i < API.getListLength(); i ++) {
            listSizes.add(API.getSize(i));
        }
        Collection<Integer> values = mapOfOccurrances.values();
        if (Collections.frequency(values, maxEntry.getValue()) == 1) {
            return maxEntry.getValue();
        }
        return -1;
    }

    private static int popularSize2() {
        int listSize = API.getListLength();
        Set<Integer> setOfUniqueSizes = new HashSet<>();
        for(int i = 0; i < listSize; i ++) {
            setOfUniqueSizes.add(API.getSize(i));
        }
        List<Integer> listOfAllSizes = new ArrayList<>();
        for(int i = 0; i < listSize; i ++) {
            listOfAllSizes.add(API.getSize(i));
        }
        Map<Integer, Integer> mapOfOccurrences = new HashMap<>();
        setOfUniqueSizes.forEach(size -> mapOfOccurrences.put(size, Collections.frequency(listOfAllSizes, size)));
        Map.Entry<Integer, Integer> maxEntry = Collections.max(mapOfOccurrences.entrySet(), comparing(Map.Entry::getValue));
        System.out.println(maxEntry);
        if(Collections.frequency(mapOfOccurrences.values(), maxEntry.getValue()) == 1) {
            return maxEntry.getValue();
        }
        return -1;
    }


    //TODO
    // Find and return the most popular shoe size in the given list of shoe size. If there is no inquely common name, return empty string
    public static String popularName() {
        int popularSize = popularSize();
        List<String> nameForSize = new ArrayList<>();
        for (int i = 0; i < API.getListLength(); i ++) {
            if (API.getSize(i) == popularSize) {
                nameForSize.add(API.getName(i));
            }
        }
        System.out.println(nameForSize.toString());
        return "";
    }


}
