package Check;

import java.awt.BorderLayout;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingUtilities;

public class Panel {

    // Replace with your database connection details
    private static final String DATABASE_URL = "jdbc:mysql://localhost:3306/project";
    private static final String DATABASE_USERNAME = "root";
    private static final String DATABASE_PASSWORD = "root123";

    // Replace with your SQL query to fetch data
    private static final String SQL_QUERY = "SELECT * FROM fees_details";

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                createAndDisplayGUI();
            }
        });
    }

    private static void createAndDisplayGUI() {
        JFrame frame = new JFrame("Database Table");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel panel = new JPanel(new BorderLayout());

        JTable table = null;
        try {
            table = createTableFromDatabase();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        if (table != null) {
            JScrollPane scrollPane = new JScrollPane(table);
            panel.add(scrollPane, BorderLayout.CENTER);
        }

        frame.getContentPane().add(panel);
        frame.pack();
        frame.setVisible(true);
    }

    private static JTable createTableFromDatabase() throws SQLException {
        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;

        try {
            // Connect to the database
            connection = DriverManager.getConnection(DATABASE_URL, DATABASE_USERNAME, DATABASE_PASSWORD);
            statement = connection.createStatement();

            // Execute the SQL query
            resultSet = statement.executeQuery(SQL_QUERY);

            // Get metadata about the result set
            int columnCount = resultSet.getMetaData().getColumnCount();
            String[] columnNames = new String[columnCount];
            for (int i = 1; i <= columnCount; i++) {
                columnNames[i - 1] = resultSet.getMetaData().getColumnName(i);
            }

            // Create a list to hold the data
            java.util.List<String[]> data = new java.util.ArrayList<>();

            // Extract data from the result set
            while (resultSet.next()) {
                String[] rowData = new String[columnCount];
                for (int i = 1; i <= columnCount; i++) {
                    rowData[i - 1] = resultSet.getString(i);
                }
                data.add(rowData);
            }

            // Convert the data list to a 2D array for JTable
            String[][] tableData = new String[data.size()][columnCount];
            for (int i = 0; i < data.size(); i++) {
                tableData[i] = data.get(i);
            }

            // Create the JTable object
            return new JTable(tableData, columnNames);
        } finally {
            // Close resources
            if (resultSet != null) {
                resultSet.close();
            }
            if (statement != null) {
                statement.close();
            }
            if (connection != null) {
                connection.close();
            }
        }
    }
}

