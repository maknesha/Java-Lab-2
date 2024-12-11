import java.util.Scanner;

public class Lab2 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        try {
            // Введення тексту з клавіатури
            System.out.println("Введіть текст:");
            String text = scanner.nextLine();

            // Виклик методу пошуку максимального паліндрому
            String palindrome = findLongestPalindromeWithSpaces(text);

            // Вивід результату
            if (!palindrome.isEmpty()) {
                System.out.println("Найдовший паліндром: " + palindrome);
            } else {
                System.out.println("Паліндромів не знайдено.");
            }
        } catch (NullPointerException e) {
            System.out.println("Помилка: Текст не може бути null.");
        } catch (Exception e) {
            System.out.println("Сталася непередбачена помилка: " + e.getMessage());
        } finally {
            scanner.close(); // Закриття сканера
        }
    }

    public static String findLongestPalindromeWithSpaces(String input) {
        if (input == null) {
            throw new NullPointerException("Текст не може бути null.");
        }

        int maxLength = 0;
        String longestPalindrome = "";

        for (int i = 0; i < input.length(); i++) {
            for (int j = i + 1; j <= input.length(); j++) {
                String substring = input.substring(i, j);

                // Перевірка, чи є підрядок паліндромом
                if (isPalindrome(substring)) {
                    if (substring.length() > maxLength) {
                        maxLength = substring.length();
                        longestPalindrome = substring;
                    }
                }
            }
        }

        return longestPalindrome;
    }

    public static boolean isPalindrome(String str) {
        int left = 0;
        int right = str.length() - 1;

        while (left < right) {
            // Пропускаємо пробіли
            while (left < right && !Character.isLetterOrDigit(str.charAt(left))) {
                left++;
            }
            while (left < right && !Character.isLetterOrDigit(str.charAt(right))) {
                right--;
            }

            // Порівняння символів, ігноруючи регістр
            if (Character.toLowerCase(str.charAt(left)) != Character.toLowerCase(str.charAt(right))) {
                return false;
            }
            left++;
            right--;
        }

        return true;
    }
}
