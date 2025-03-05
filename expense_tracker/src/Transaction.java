import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * The Transaction class represents a single transaction with an amount, category, and timestamp.
 */
public class Transaction {

  private double amount;
  private String category;
  private String timestamp;

  /**
   * Constructs a Transaction with the specified amount and category.
   * 
   * @param amount the amount of the transaction
   * @param category the category of the transaction
   */
  public Transaction(double amount, String category) {
    this.amount = amount;
    this.category = category;
    this.timestamp = generateTimestamp();
  }

  /**
   * Returns the amount of the transaction.
   * 
   * @return the amount of the transaction
   */
  public double getAmount() {
    return amount;
  }

  /**
   * Sets the amount of the transaction.
   * 
   * @param amount the amount to set
   */
  public void setAmount(double amount) {
    this.amount = amount;
  }

  /**
   * Returns the category of the transaction.
   * 
   * @return the category of the transaction
   */
  public String getCategory() {
    return category;
  }

  /**
   * Sets the category of the transaction.
   * 
   * @param category the category to set
   */
  public void setCategory(String category) {
    this.category = category; 
  }
  
  /**
   * Returns the timestamp of the transaction.
   * 
   * @return the timestamp of the transaction
   */
  public String getTimestamp() {
    return timestamp;
  }

  /**
   * Generates a timestamp for the transaction.
   * 
   * @return the generated timestamp
   */
  private String generateTimestamp() {
    SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy HH:mm");  
    return sdf.format(new Date());
  }

}