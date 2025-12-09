import java.sql.*;
import javax.swing.JOptionPane;

public class InventoryManager {

    private Connection conn;

    public InventoryManager() {
        conn = DBConnection.getConnection();
    }

    // Add a new item
    public void addItem(String name, int quantity, double price) {
        String sql = "INSERT INTO items (name, quantity, price) VALUES (?, ?, ?)";
        try (PreparedStatement pst = conn.prepareStatement(sql)) {
            pst.setString(1, name);
            pst.setInt(2, quantity);
            pst.setDouble(3, price);
            pst.executeUpdate();
            JOptionPane.showMessageDialog(null, "Item added successfully!");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Update an existing item
    public void updateItem(int id, String name, int quantity, double price) {
        String sql = "UPDATE items SET name=?, quantity=?, price=? WHERE id=?";
        try (PreparedStatement pst = conn.prepareStatement(sql)) {
            pst.setString(1, name);
            pst.setInt(2, quantity);
            pst.setDouble(3, price);
            pst.setInt(4, id);
            pst.executeUpdate();
            JOptionPane.showMessageDialog(null, "Item updated successfully!");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Delete an item
    public void deleteItem(int id) {
        String sql = "DELETE FROM items WHERE id=?";
        try (PreparedStatement pst = conn.prepareStatement(sql)) {
            pst.setInt(1, id);
            pst.executeUpdate();
            JOptionPane.showMessageDialog(null, "Item deleted successfully!");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // List all items
    public void listItems() {
        String sql = "SELECT * FROM items";
        try (Statement st = conn.createStatement()) {
            ResultSet rs = st.executeQuery(sql);
            StringBuilder sb = new StringBuilder();
            while (rs.next()) {
                sb.append("ID: ").append(rs.getInt("id"))
                  .append(", Name: ").append(rs.getString("name"))
                  .append(", Quantity: ").append(rs.getInt("quantity"))
                  .append(", Price: ").append(rs.getDouble("price"))
                  .append("\n");
            }
            JOptionPane.showMessageDialog(null, sb.toString());
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
