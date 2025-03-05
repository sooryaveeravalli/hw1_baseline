import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

/**
 * The ExpenseTrackerView class represents the view component of the Expense Tracker application.
 * It extends JFrame and provides the user interface for adding and displaying transactions.
 */
public class ExpenseTrackerView extends JFrame {

  private JTable transactionsTable;
  private JButton addTransactionBtn;
  private JTextField amountField;
  private JTextField categoryField;
  private DefaultTableModel model;
  private List<Transaction> transactions = new ArrayList<>();

  /**
   * Returns the transactions table.
   * 
   * @return the transactions table
   */
  public JTable getTransactionsTable() {
    return transactionsTable;
  }

  /**
   * Returns the amount entered in the amount field.
   * 
   * @return the amount entered in the amount field
   */
  public double getAmountField() {
    if (amountField.getText().isEmpty()) {
      return 0;
    } else {
      double amount = Double.parseDouble(amountField.getText());
      return amount;
    }
  }

  /**
   * Sets the amount field.
   * 
   * @param amountField the amount field to set
   */
  public void setAmountField(JTextField amountField) {
    this.amountField = amountField;
  }

  /**
   * Returns the category entered in the category field.
   * 
   * @return the category entered in the category field
   */
  public String getCategoryField() {
    return categoryField.getText();
  }

  /**
   * Sets the category field.
   * 
   * @param categoryField the category field to set
   */
  public void setCategoryField(JTextField categoryField) {
    this.categoryField = categoryField;
  }

  /**
   * Returns the add transaction button.
   * 
   * @return the add transaction button
   */
  public JButton getAddTransactionBtn() {
    return addTransactionBtn;
  }

  /**
   * Returns the table model.
   * 
   * @return the table model
   */
  public DefaultTableModel getTableModel() {
    return model;
  }

  /**
   * Constructs an ExpenseTrackerView with the specified table model.
   * 
   * @param model the table model to use
   */
  public ExpenseTrackerView(DefaultTableModel model) {
    setTitle("Expense Tracker"); // Set title
    setSize(600, 400); // Make GUI larger
    this.model = model;

    addTransactionBtn = new JButton("Add Transaction");

    // Create UI components
    JLabel amountLabel = new JLabel("Amount:");
    amountField = new JTextField(10);

    JLabel categoryLabel = new JLabel("Category:");
    categoryField = new JTextField(10);
    transactionsTable = new JTable(model);

    // Layout components
    JPanel inputPanel = new JPanel();
    inputPanel.add(amountLabel);
    inputPanel.add(amountField);
    inputPanel.add(categoryLabel);
    inputPanel.add(categoryField);
    inputPanel.add(addTransactionBtn);

    JPanel buttonPanel = new JPanel();
    buttonPanel.add(addTransactionBtn);

    // Add panels to frame
    add(inputPanel, BorderLayout.NORTH);
    add(new JScrollPane(transactionsTable), BorderLayout.CENTER);
    add(buttonPanel, BorderLayout.SOUTH);

    // Set frame properties
    setSize(400, 300);
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    setVisible(true);
  }

  /**
   * Refreshes the transactions table with the specified list of transactions.
   * 
   * @param transactions the list of transactions to display
   */
  public void refreshTable(List<Transaction> transactions) {
    model.setRowCount(0);
    int rowNum = model.getRowCount();
    double totalCost = 0;
    for (Transaction t : transactions) {
      totalCost += t.getAmount();
    }

    // Add rows from transactions list
    for (Transaction t : transactions) {
      model.addRow(new Object[] { rowNum += 1, t.getAmount(), t.getCategory(), t.getTimestamp() });
    }
    Object[] totalRow = { "Total", null, null, totalCost };
    model.addRow(totalRow);

    // Fire table update
    transactionsTable.updateUI();
  }

  /**
   * Refreshes the transactions table with the current list of transactions.
   */
  public void refresh() {
    // Get transactions from model
    List<Transaction> transactions = getTransactions();

    // Pass to view
    refreshTable(transactions);
  }

  /**
   * Returns the list of transactions.
   * 
   * @return the list of transactions
   */
  public List<Transaction> getTransactions() {
    return transactions;
  }

  /**
   * Adds a transaction to the list and updates the table.
   * 
   * @param t the transaction to add
   */
  public void addTransaction(Transaction t) {
    transactions.add(t);
    getTableModel().addRow(new Object[] { t.getAmount(), t.getCategory(), t.getTimestamp() });
    refresh();
  }

  /**
   * Displays an error message dialog.
   * 
   * @param string the error message to display
   */
  public void showErrorMessage(String string) {
    // Display error message
    JOptionPane.showMessageDialog(this, string, "Error", JOptionPane.ERROR_MESSAGE);
  }

  // Other view methods
}