import javax.swing.*;
import java.awt.event.*;

public class Main {
    public static void main(String[] args) {
        InventoryManager manager = new InventoryManager();

        JFrame frame = new JFrame("Inventory Management System");
        frame.setSize(400, 400);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(null);

        JButton addBtn = new JButton("Add Item");
        addBtn.setBounds(50, 50, 120, 30);
        addBtn.addActionListener(e -> {
            String name = JOptionPane.showInputDialog("Enter item name:");
            int qty = Integer.parseInt(JOptionPane.showInputDialog("Enter quantity:"));
            double price = Double.parseDouble(JOptionPane.showInputDialog("Enter price:"));
            manager.addItem(name, qty, price);
        });

        JButton updateBtn = new JButton("Update Item");
        updateBtn.setBounds(200, 50, 120, 30);
        updateBtn.addActionListener(e -> {
            int id = Integer.parseInt(JOptionPane.showInputDialog("Enter item ID to update:"));
            String name = JOptionPane.showInputDialog("Enter new item name:");
            int qty = Integer.parseInt(JOptionPane.showInputDialog("Enter new quantity:"));
            double price = Double.parseDouble(JOptionPane.showInputDialog("Enter new price:"));
            manager.updateItem(id, name, qty, price);
        });

        JButton deleteBtn = new JButton("Delete Item");
        deleteBtn.setBounds(50, 120, 120, 30);
        deleteBtn.addActionListener(e -> {
            int id = Integer.parseInt(JOptionPane.showInputDialog("Enter item ID to delete:"));
            manager.deleteItem(id);
        });

        JButton listBtn = new JButton("List Items");
        listBtn.setBounds(200, 120, 120, 30);
        listBtn.addActionListener(e -> manager.listItems());

        frame.add(addBtn);
        frame.add(updateBtn);
        frame.add(deleteBtn);
        frame.add(listBtn);

        frame.setVisible(true);
    }
}
