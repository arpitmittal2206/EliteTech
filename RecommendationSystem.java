import java.util.*;

public class RecommendationSystem {

    public static void main(String[] args) {
        Map<String, List<String>> userData = new HashMap<>();
        userData.put("Arpit", Arrays.asList("Java", "Python", "Machine Learning"));
        userData.put("Manas", Arrays.asList("Java", "Cybersecurity", "Python"));
        userData.put("Armaan", Arrays.asList("Machine Learning", "AI", "Python"));

        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter user name (e.g., Arpit): ");
        String user = scanner.nextLine();

        if (!userData.containsKey(user)) {
            System.out.println("User not found.");
            return;
        }

        List<String> interests = userData.get(user);
        Set<String> recommendations = new HashSet<>();

        for (Map.Entry<String, List<String>> entry : userData.entrySet()) {
            if (!entry.getKey().equals(user)) {
                for (String item : entry.getValue()) {
                    if (interests.contains(item)) {
                        recommendations.addAll(entry.getValue());
                    }
                }
            }
        }

        recommendations.removeAll(interests);
        System.out.println("Recommended topics for " + user + ": " + recommendations);
    }
}