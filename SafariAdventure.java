import java.util.Scanner;
import java.util.Random;

public class SafariAdventure {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random rand = new Random();
        int totalPoints = 0;

        System.out.println("🌄 Welcome to Safari Adventure!\n");

        // 1. for loop — 6 days of exploration
        for (int day = 1; day <= 6; day++) {
            System.out.println("Day " + day + ":");

            // 2. do...while loop — choose area to explore
            String area;
            do {
                System.out.print("Where would you like to explore? (Jungle, River, Desert, Mountains): ");
                area = scanner.nextLine().trim();
            } while (!area.equalsIgnoreCase("Jungle") &&
                     !area.equalsIgnoreCase("River") &&
                     !area.equalsIgnoreCase("Desert") &&
                     !area.equalsIgnoreCase("Mountains"));

            System.out.println("You chose: " + area);
            System.out.println("Exploring " + area + "...\n");

            // 3. while loop — simulate up to 3 events
            int eventCount = 0;
            int dayPoints = 0;

            while (eventCount < 3) {
                eventCount++;

                // Random event type
                int eventType = rand.nextInt(6); // 0-4
                switch (eventType) {
                    case 0:
                        System.out.println("Event " + eventCount + ": You spotted a bird. 🐦");
                        System.out.println("(Too small to track. Moving on.)\n");
                        continue; // 4. continue — skip harmless event

                    case 1:
                        System.out.println("Event " + eventCount + ": You found edible fruits! (+15 points)");
                        dayPoints += 15;
                        break;

                    case 2:
                        System.out.println("Event " + eventCount + ": You discovered unique flowers! (+20 points)");
                        dayPoints += 20;
                        break;

                    case 3:
                        System.out.println("Event " + eventCount + ": You encountered a sandstorm! (+10 points for surviving)");
                        dayPoints += 10;
                        break;

                    case 4:
                        String danger = area.equalsIgnoreCase("River") ? "crocodile" : "lion";
                        System.out.println("Event " + eventCount + ": A " + danger + " appears! 😱");
                        System.out.print("Type 'run' to escape: ");
                        String action = scanner.nextLine().trim();
                        if (action.equalsIgnoreCase("run")) {
                            System.out.println("You escaped safely, ending the day early.\n");
                            break; // 5. break — danger, end day
                        } else {
                            System.out.println("You froze... but the animal wandered off. You're lucky!\n");
                            continue;
                        }
                }

                // Optional: stop early if enough points for the day
                if (dayPoints >= 30) {
                    System.out.println("You've collected enough resources for today.\n");
                    break;
                }
            }

            totalPoints += dayPoints;
            System.out.println("Day Summary: " + dayPoints + " points earned.");
            System.out.println("-----------------------------------\n");
        }

        // End of safari
        System.out.println("🎉 Safari Complete! You collected " + totalPoints + " points!");
        if (totalPoints >= 100) {
            System.out.println("You survived and completed the adventure!");
        } else {
            System.out.println("You didn't collect enough resources. Better luck next time!");
        }

        scanner.close();
    }
}
