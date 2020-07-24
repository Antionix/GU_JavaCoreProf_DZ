import java.sql.*;
import java.util.Random;

public class MainApp {

    //    private static String dbName = "main.db";
    private static Connection connection;
    private static Statement stmt;
    private static PreparedStatement psCheckTable;
    private static PreparedStatement psCreateTable;

    //    private static PreparedStatement psCreateTableStudent;
//    private static PreparedStatement psClearTableStudent;
    private static PreparedStatement psInsertStudent;
    private static PreparedStatement psDeleteStudent;
    private static PreparedStatement psUpdateStudentName;
    //    private static PreparedStatement psUpdateStudentScore;
//    private static PreparedStatement psGetIdStudent;
    private static PreparedStatement psGetAllStudent;

    public static void connect() throws ClassNotFoundException, SQLException {
        Class.forName("org.sqlite.JDBC");
        connection = DriverManager.getConnection("jdbc:sqlite:lesson02/main.db");
//        connection = DriverManager.getConnection("jdbc:sqlite:%s".format(dbName));
        stmt = connection.createStatement();
    }

    public static void disconnect() {
        try {
            stmt.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        try {
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void prepareAllStatement() throws SQLException {
//        psCheckTable = connection.prepareStatement("");
        psCheckTable = connection.prepareStatement("" +
                "SELECT name FROM sqlite_master " +
                "  WHERE type='table' AND name=?;");

//        psCreateTable = connection.prepareStatement("SELECT * FROM students;");

//        psClearTableStudent = connection.prepareStatement("DELETE FROM students;");

        psInsertStudent = connection.prepareStatement("" +
                "INSERT INTO students(fullname, score) VALUES (?, ?);");

        psDeleteStudent = connection.prepareStatement("" +
                "DELETE FROM students WHERE id = ?;");

        psUpdateStudentName = connection.prepareStatement("" +
                "UPDATE students SET fullname = ? WHERE id = ?;");

//        psUpdateStudentScore = connection.prepareStatement("" +
//                "UPDATE students SET score = ? WHERE id = ?;");

        psGetAllStudent = connection.prepareStatement("" +
                "SELECT * FROM students;");

//        psGetIdStudent = connection.prepareStatement("" +
//                "SELECT * FROM students " +
//                "  WHERE fullname like ?;");
    }

    private boolean isExistsTable(String tableName) throws SQLException {
        psCheckTable.setString(1, tableName);
        ResultSet rows = psCheckTable.executeQuery();
//        System.out.println(String.format("[isExistsTable] row = ", rows.));
        System.out.println("[isExistsTable] row = " + rows);
//        return rows.getFetchSize() > 0;
        if (rows.next()) {
            return true;
        } else {
            return false;
        }
    }

    private void createTable(String tableName) throws SQLException {
        String sql = "";
        switch (tableName) {
            case "students": {
                sql = "CREATE TABLE students (" +
                        "  id       INTEGER PRIMARY KEY AUTOINCREMENT, " +
                        "  fullname TEXT, " +
                        "  score    INTEGER " +
                        ");";
                stmt.executeUpdate(sql);
                break;
            }
            case "test": { //заглушка
                sql = "CREATE TABLE students (" +
                        "  id       INTEGER PRIMARY KEY AUTOINCREMENT, " +
                        "  fullname TEXT, " +
                        "  score    INTEGER " +
                        ");";
                stmt.executeUpdate(sql);
            }
            default: {
                System.out.println("Unknown table = " + tableName);
            }
        }
    }

    public MainApp() {
        try {
            connect();

            prepareAllStatement();

            if (!isExistsTable("students")) {
//                createTable("students");
            }

            // insert
            for (int i = 1; i < 10; i++) {
                psInsertStudent.setString(1, "Student_" + i);
                psInsertStudent.setInt(2, new Random().nextInt(50));
                psInsertStudent.executeUpdate();
            }

            // display
            System.out.println("------------------------------------");
            ResultSet rs = psGetAllStudent.executeQuery();
            while (rs.next()) {
                System.out.printf("%d - %s - %d\n",
                        rs.getInt("id"),
                        rs.getString("fullname"),
                        rs.getInt("score"));
            }

            //update
            stmt.executeUpdate("UPDATE students SET score = 100 WHERE score > 35;");

            psUpdateStudentName.setString(1, "Student_100");
            psUpdateStudentName.setInt(2, 5);
            psUpdateStudentName.executeUpdate();

            // display
            System.out.println("------------------------------------");
            rs = psGetAllStudent.executeQuery();
            while (rs.next()) {
                System.out.printf("%d - %s - %d\n",
                        rs.getInt("id"),
                        rs.getString("fullname"),
                        rs.getInt("score"));
            }

            // delete
            psDeleteStudent.setInt(1, 3);
            psDeleteStudent.executeUpdate();

            // display
            System.out.println("------------------------------------");
            rs = psGetAllStudent.executeQuery();
            while (rs.next()) {
                System.out.printf("%d - %s - %d\n",
                        rs.getInt("id"),
                        rs.getString("fullname"),
                        rs.getInt("score"));
            }

            // clear
//            psClearTableStudent.executeUpdate();
            clearTable();

            // display
            System.out.println("------------------------------------");
            rs = psGetAllStudent.executeQuery();
            while (rs.next()) {
                System.out.printf("%d - %s - %d\n",
                        rs.getInt("id"),
                        rs.getString("fullname"),
                        rs.getInt("score"));
            }

            disconnect();
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        new MainApp();
    }

    private static void clearTable() throws SQLException {
        stmt.executeUpdate("DELETE FROM students;");
    }

}
