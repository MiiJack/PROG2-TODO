package Database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Timestamp;

public class Insert {
    private boolean isDoneSuccessfully = false;
    private String error;
    /**
     * add a new row to the TODO
     * @param title set the title of the TODO
     * @param description set the description of the TODO
     * @param deadline set the deadline of the TODO
     * @param priority set the Priority of the TODO. It should be between 0 and 10
     * @param done set if the TODO is done or not
     */
    public Insert(
            String title,
            String description,
            Timestamp deadline,
            int priority,
            boolean done
    ) {
        try {
            Connection connection = new ConnectionDB().getConnection();
            String sql = """
            INSERT INTO todo
            (title,description,deadline,priority,done)
            VALUES (?,?,?,?,?);+
            """;
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1,title);
            statement.setString(2,description);
            statement.setTimestamp(3,deadline);
            statement.setInt(4,priority);
            statement.setBoolean(5,done);
            int update = statement.executeUpdate();
            this.isDoneSuccessfully = update > 0;
        } catch (SQLException e){
            if(e.toString().length() > 0){
                this.error = e.toString();
            }
            e.getStackTrace();
        }
    }
    /**
     * Return true if a new row is inserted
     */
    public boolean isInserted() {
        return isDoneSuccessfully;
    }
    /**
     * Get the message error if there is an error
     */
    public String GetError(){
        return this.error;
    }
    @Override
    public String toString() {
        if(!isDoneSuccessfully){
            return error;
        }
        return "1 row inserted successfully";
    }
}
