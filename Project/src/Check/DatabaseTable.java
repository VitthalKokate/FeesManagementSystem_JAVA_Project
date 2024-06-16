package Check;

import java.sql.*;
import javax.swing.*;
import javax.swing.table.*;

public class DatabaseTable {

    private static final String DRIVER = "com.mysql.cj.jdbc.Driver"; // Replace with your JDBC driver
    private static final String DATABASE_URL = "jdbc:mysql://localhost:3306/demo"; // Replace with your database details
    private static final String USERNAME = "root"; // Replace with your database username
    private static final String PASSWORD = "root123"; // Replace with your database password

    public static void main(String[] args) {
        JTable table = new JTable();
        Connection connection = null;

        try {
         
            Class.forName(DRIVER);
            connection = DriverManager.getConnection(DATABASE_URL, USERNAME, PASSWORD);

            // Define the SQL query to retrieve data
            String sql = "SELECT * FROM user"; // Replace with your table name and desired columns

            // Create a statement object
            Statement statement = connection.createStatement();

            // Execute the query and get the results
            ResultSet resultSet = statement.executeQuery(sql);

            // Get the meta data of the result set
            ResultSetMetaData metaData = resultSet.getMetaData();

            // Get the number of columns
            int columnCount = metaData.getColumnCount();

            // Create an empty DefaultTableModel
            DefaultTableModel model = new DefaultTableModel();

            // Add column names to the model
            for (int i = 1; i <= columnCount; i++) {
                model.addColumn(metaData.getColumnName(i));
            }

            // Add data rows to the model
            while (resultSet.next()) {
                Object[] row = new Object[columnCount];
                for (int i = 1; i <= columnCount; i++) {
                    row[i - 1] = resultSet.getObject(i);
                }
                model.addRow(row);
            }

            // Set the table model
            table.setModel(model);

            // Create a JFrame to display the JTable
            JFrame frame = new JFrame("Database Table");
            frame.add(new JScrollPane(table));
            frame.pack();
            frame.setVisible(true);

        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        } finally {
            // Close the connection
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}

