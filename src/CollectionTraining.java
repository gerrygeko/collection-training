import java.util.*;

import static java.util.Comparator.comparing;

public class CollectionTraining {


    public static void main(String[] args) {
        System.out.println("This is the popular size method 1: " + popularSize());
        System.out.println("This is the popular size method 2: " + popularSize2());
        System.out.println("This is the popular name for popular size method 2: " + popularName());
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
        Map.Entry<Integer, Integer> maxEntry = Collections.max(mapOfOccurrances.entrySet(), comparing(Map.Entry::getValue));
        List<Integer> listSizes = new ArrayList<>();
        for (int i = 0; i < API.getListLength(); i ++) {
            listSizes.add(API.getSize(i));
        }
        Collection<Integer> values = mapOfOccurrances.values();
        if (Collections.frequency(values, maxEntry.getValue()) == 1) {
            return maxEntry.getKey();
        }
        return -1;
    }

    private static int popularSize2() {
        int listSize = API.getListLength();
        Set<Integer> setOfUniqueSizes = new HashSet<>();
        List<Integer> listOfAllSizes = new ArrayList<>();
        for(int i = 0; i < listSize; i ++) {
            setOfUniqueSizes.add(API.getSize(i));
            listOfAllSizes.add(API.getSize(i));
        }
        Map<Integer, Integer> mapOfOccurrences = new HashMap<>();
        setOfUniqueSizes.forEach(size -> mapOfOccurrences.put(size, Collections.frequency(listOfAllSizes, size)));
        Map.Entry<Integer, Integer> maxEntry = Collections.max(mapOfOccurrences.entrySet(), comparing(Map.Entry::getValue));
        if(Collections.frequency(mapOfOccurrences.values(), maxEntry.getValue()) == 1) {
            return maxEntry.getKey();
        }
        return -1;
    }


    // Find and return the most popular shoe size in the given list of shoe size. If there is no unique common name, return empty string
    public static String popularName() {
        int popularSize = popularSize2();
        int listSize = API.getListLength();
        List<String> listOfNames = new ArrayList<>();
        if (popularSize != -1){
            for (int i = 0; i < listSize; i ++) {
                if (API.getSize(i) == popularSize) {
                    listOfNames.add(API.getName(i));
                }
            }
            Map<String, Integer> mapOfOccurrencesForName = new HashMap<>();
            listOfNames.forEach(name -> mapOfOccurrencesForName.put(name, Collections.frequency(listOfNames, name)));
            Map.Entry<String, Integer> maxName = Collections.max(mapOfOccurrencesForName.entrySet(), comparing(Map.Entry::getValue));
            if(Collections.frequency(mapOfOccurrencesForName.values(), maxName.getValue()) == 1) {
                return maxName.getKey();
            }
        }
        return "No unique common name";
    }


}
