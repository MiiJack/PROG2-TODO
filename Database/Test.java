package Database;

import java.sql.Timestamp;

public class Test {
    public static void main(String[] args) {
        Insert insert = new Insert(
                "test",
                "It is just a test",
                Timestamp.valueOf("2023-12-06 15:00:00"),
                3
        );
        System.out.println(insert.isInserted());
    }
}
