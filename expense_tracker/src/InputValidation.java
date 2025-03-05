/*
 * This class validates the `amount` and `category` fields of the application.
 * The `amount` should be greater than 0 and less than 1000.
 * The `category` should be a valid string input from the following list: "food", "travel", "bills", "entertainment", "other".
 */
public class InputValidation {

    /**
     * Validates the amount.
     * 
     * @param amount the amount to validate
     * @return true if the amount is greater than 0 and less than 1000, false otherwise
     */
    public static boolean validateAmount(double amount) {
        return amount > 0 && amount < 1000;
    }

    /**
     * Validates the category.
     * 
     * @param category the category to validate
     * @return true if the category is one of the valid categories, false otherwise
     */
    public static boolean validateCategory(String category) {
        return category.equals("food") || category.equals("travel") || category.equals("bills") || category.equals("entertainment") || category.equals("other");
    }
}