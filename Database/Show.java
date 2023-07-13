package Database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;

public class Show {
    public Show() {
        try {
            Connection connection = new ConnectionDB().getConnection();

            String query = "SELECT * FROM todo";
            PreparedStatement preparedStatement = connection.prepareStatement(query);

            // Execute the SQL query and retrieve the result set
            ResultSet resultSet = preparedStatement.executeQuery();

            // Iterate over the result set and display each todo
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String title = resultSet.getString("title");
                String description = resultSet.getString("description");
                Timestamp deadline = resultSet.getTimestamp("deadline");
                int priority = resultSet.getInt("priority");

                System.out.println("ID: " + id);
                System.out.println("Title: " + title);
                System.out.println("Description: " + description);
                System.out.println("Deadline: " + deadline);
                System.out.println("Priority: " + priority);
                System.out.println();
            }

            // Close the result set, prepared statement, and connection
            resultSet.close();
            preparedStatement.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
