import java.util.ArrayList;
import java.util.Scanner;

public class StudentGradeTracker {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Integer> grades = new ArrayList<>();
        boolean continueInput = true;

        System.out.println("Enter student grades. Type 'done' when finished:");

        while (continueInput) {
            String input = scanner.next();
            if (input.equalsIgnoreCase("done")) {
                continueInput = false;
            } else {
                try {
                    int grade = Integer.parseInt(input);
                    grades.add(grade);
                } catch (NumberFormatException e) {
                    System.out.println("Invalid input. Please enter a valid grade or 'done' to finish.");
                }
            }
        }

        if (grades.isEmpty()) {
            System.out.println("No grades entered.");
        } else {
            double average = calculateAverage(grades);
            int highest = findHighest(grades);
            int lowest = findLowest(grades);

            System.out.println("Grades entered: " + grades);
            System.out.println("Average grade: " + average);
            System.out.println("Highest grade: " + highest);
            System.out.println("Lowest grade: " + lowest);
        }

        scanner.close();
    }

    private static double calculateAverage(ArrayList<Integer> grades) {
        int sum = 0;
        for (int grade : grades) {
            sum += grade;
        }
        return (double) sum / grades.size();
    }

    private static int findHighest(ArrayList<Integer> grades) {
        int highest = grades.get(0);
        for (int grade : grades) {
            if (grade > highest) {
                highest = grade;
            }
        }
        return highest;
    }

    private static int findLowest(ArrayList<Integer> grades) {
        int lowest = grades.get(0);
        for (int grade : grades) {
            if (grade < lowest) {
                lowest = grade;
            }
        }
        return lowest;
    }
}
