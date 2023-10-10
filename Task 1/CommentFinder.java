import java.util.Scanner;

public class CommentFinder {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);  

        System.out.print("Enter a line of Java code: ");
        String line = scanner.nextLine();

        if (isSingleLineComment(line)) {
            System.out.println("The line is a single-line comment.");
        } else if (isStartOfMultiLineComment(line)) {
            System.out.println("The line starts a multi-line comment.");
        } else if (isEndOfMultiLineComment(line)) {
            System.out.println("The line ends a multi-line comment.");
        } else if (isMultiLineComment(line)) {
            System.out.println("The line is a multi-line comment.");
        } else {
            System.out.println("The line is not a comment.");
        }
        scanner.close();
    }

    public static boolean isSingleLineComment(String line) {
        String trimmedLine = line.trim();
        return trimmedLine.startsWith("//");
    }

    public static boolean isStartOfMultiLineComment(String line) {
        String trimmedLine = line.trim();
        return trimmedLine.startsWith("/*") && !trimmedLine.endsWith("*/");
    }

    public static boolean isEndOfMultiLineComment(String line) {
        String trimmedLine = line.trim();
        return !trimmedLine.startsWith("/*") && trimmedLine.endsWith("*/");
    }
    public static boolean isMultiLineComment(String line) {
        String trimmedLine = line.trim();
        return trimmedLine.startsWith("/*") && trimmedLine.endsWith("*/");
    }
}
