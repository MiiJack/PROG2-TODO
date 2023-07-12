package Database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Timestamp;

public class Update {
    private static final Connection connection;
    static {
        connection = new ConnectionDB().getConnection();
    }
    /**
     * A function that check if the query is updated
     * @param isUpdated the number of row that is affected
     * @param changes add a title to the message
     * @return return the message of the query
     */
    private static String log(int isUpdated,String changes){
        if(isUpdated <= 0){
            return "No TODO updated";
        }
        return String.format("%s updated successfully!",changes);
    }
    /**
     * A function that check if the query is updated
     * @param isUpdated the number of row that is affected
     * @return return the message of the query
     */
    private static String log(int isUpdated){
        if(isUpdated <= 0){
            return "No TODO updated";
        }
        return "One TODO updated successfully!";
    }
    /**
     * Update the deadline by an id
     * @param id the id that select the row
     * @param newDeadline the new deadline set
     * @return Return the message when query is done
     */
    public static String updateDeadlineById(int id,Timestamp newDeadline){
        try {
            String sql = "UPDATE todo SET priority = ? WHERE id = ?;";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setTimestamp(1,newDeadline);
            statement.setInt(2,id);
            return log(
                    statement.executeUpdate(),
                    "Deadline"
            );
        }catch (SQLException e){
            e.getStackTrace();
        }
        return "";
    }
    /**
     * Update the title and description by an id
     * @param id the id that select the row
     * @param newTitle the new title set
     * @param newDescription the new description set
     * @return Return the message when query is done
     */
    public static String updateTitleAndDescriptionById(int id,String newTitle,String newDescription){
        try {
            String sql = "UPDATE todo SET title = ?, description = ? WHERE id = ?";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1,newTitle);
            statement.setString(2,newDescription);
            statement.setInt(3,id);
            return log(
                    statement.executeUpdate(),
                    "Title and description"
            );
        }catch (SQLException e){
            e.getStackTrace();
        }
        return "";
    }
    /**
     * Update only the priority by an id
     * @param id the id that select the row
     * @param newPriority the new priority set
     * @return Return the message when query is done
     */
    public static String updatePriorityById(int id,int newPriority){
        try{
            String sql = "UPDATE todo SET priority = ? WHERE id = ?;";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1,newPriority);
            statement.setInt(2,id);
            return log(
                    statement.executeUpdate(),
                    "Priority"
            );
        }catch (SQLException e){
            e.getStackTrace();
        }
        return "";
    }
    /**
     * Update only the title by an id
     * @param id the id that select the row
     * @param newTitle the new title set
     * @return Return the message when query is done
     */
    public static String updateTitleById(int id,String newTitle){
        try {
            String sql = "UPDATE todo SET title = ? WHERE id = ?;";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1,newTitle);
            statement.setInt(2,id);
            return log(
                    statement.executeUpdate(),
                    "Title"
            );
        } catch (SQLException e){
            e.getStackTrace();
        }
        return "";
    }
    /**
     * Update only the column done by an id
     * @param id the id that select the row
     * @param done is it done or not
     * @return Return the message when query is done
     */
    public static String updateDoneById(int id,boolean done){
        try {
            String sql = "UPDATE todo SET done = ? WHERE id = ?;";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setBoolean(1,done);
            statement.setInt(2,id);
            return log(
                    statement.executeUpdate(),
                    "Done"
            );
        } catch (SQLException e){
            e.getStackTrace();
        }
        return "";
    }
    /**
     * Update all row value by its id
     * @param id the id that select the row
     * @param newTitle a new title to set
     * @param newDescription a new description to set
     * @param newDeadline the new deadline set
     * @param newPriority the priority between 0 and 10
     * @param done is it done or not
     * @return Return the message when query is done
     */
    public static String updateAllById(
            int id,
            String newTitle,
            String newDescription,
            Timestamp newDeadline,
            int newPriority,
            boolean done
    ){
        try {
            String sql = "UPDATE todo SET title = ?,description = ?,deadline = ?,priority = ?,done = ? WHERE id = ?;";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1,newTitle);
            statement.setString(2,newDescription);
            statement.setTimestamp(3,newDeadline);
            statement.setInt(4,newPriority);
            statement.setBoolean(5,done);
            statement.setInt(6,id);
            return log(
                    statement.executeUpdate()
            );
        } catch (SQLException e){
            e.getStackTrace();
        }
        return "";
    }
}
