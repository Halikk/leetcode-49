import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        String[] strs = {"eat", "tea", "tan", "ate", "nat", "bat"};
        boolean[] visited = new boolean[strs.length]; // Ziyaret edilen kelimeleri takip etmek için

        List<List<String>> anagramGroups = new ArrayList<>();

        for (int i = 0; i < strs.length; i++) {
            if (!visited[i]) { // Eğer kelime daha önce gruplandıysa atla
                List<String> group = new ArrayList<>();
                group.add(strs[i]);
                visited[i] = true;

                char[] sortedBase = strs[i].toCharArray();
                Arrays.sort(sortedBase);

                for (int j = i + 1; j < strs.length; j++) {
                    if (!visited[j]) {
                        char[] sortedCompare = strs[j].toCharArray();
                        Arrays.sort(sortedCompare);

                        if (Arrays.equals(sortedBase, sortedCompare)) {
                            group.add(strs[j]);
                            visited[j] = true;
                        }
                    }
                }

                anagramGroups.add(group);
            }
        }

        // Sonuçları yazdır
        for (List<String> group : anagramGroups) {
            System.out.println(group);
        }
    }
}
