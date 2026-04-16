import java.util.Map;
import java.util.TreeMap;

public class LatihanCollection3 {
    public static void main(String[] args) {
        Map<String, String> techMap = new TreeMap<>();

        techMap.put("Microsoft", "Bill Gates");
        techMap.put("Apple", "Steven Paul Jobs");
        techMap.put("Linux", "Linux Benedict Torvalds");
        techMap.put("Facebook", "Mark Zuckerberg");
        techMap.put("Twitter", "Jack Dorsey");
        techMap.put("Instagram", "Kevin Systrom");

        int no = 1;
        for (String key : techMap.keySet()) {
            System.out.println(no + ". " + key.toUpperCase() + " dikembangkan oleh " + techMap.get(key));
            no++;
        }
    }
}