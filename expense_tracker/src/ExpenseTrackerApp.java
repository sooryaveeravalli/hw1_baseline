import javax.swing.table.DefaultTableModel;

/**
 * The ExpenseTrackerApp class allows users to add/remove daily transactions.
 */
public class ExpenseTrackerApp {

  public static void main(String[] args) {
    
    // Create MVC components
    DefaultTableModel tableModel = new DefaultTableModel();
    tableModel.addColumn("Serial");
    tableModel.addColumn("Amount");
    tableModel.addColumn("Category");
    tableModel.addColumn("Date");
    
    // Create the view component
    ExpenseTrackerView view = new ExpenseTrackerView(tableModel);

    // Initialize view
    view.setVisible(true);

    // Handle add transaction button clicks
    view.getAddTransactionBtn().addActionListener(e -> {
      
      // Get transaction data from view
      double amount = view.getAmountField(); 
      String category = view.getCategoryField();

      // Validate transaction data
      if (!InputValidation.validateAmount(amount)) {
        view.showErrorMessage("Amount should be greater than 0 and less than 1000.");
        return;
      }

      if (!InputValidation.validateCategory(category)) {
        view.showErrorMessage("Category should be a valid string input from the following list: \"food\", \"travel\", \"bills\", \"entertainment\", \"other\".");
        return;   
      }

      // Create transaction object
      Transaction t = new Transaction(amount, category);

      // Call controller to add transaction
      view.addTransaction(t);
    });

  }

}