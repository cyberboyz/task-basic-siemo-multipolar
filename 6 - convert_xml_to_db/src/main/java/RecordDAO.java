import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class RecordDAO {
    private static String jdbcUsername = "root";
    private static String jdbcPassword = "";
    private static String jdbcDatabase = "xml_db";
    private static String jdbcURL = "jdbc:mysql://localhost:3306/" + jdbcDatabase +"?useSSL=false";

    private static final String INSERT_RECORD_SQL = "INSERT INTO record" + " (name, phone, email, city) VALUES "
            + " (?, ?, ?, ?);";

    public RecordDAO() {
    }

    protected static Connection getConnection() {
        Connection connection = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection(jdbcURL, jdbcUsername, jdbcPassword);
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return connection;
    }

    protected static void printSQLException(SQLException ex) {
        for (Throwable e : ex) {
            if (e instanceof SQLException) {
                e.printStackTrace(System.err);
                System.err.println("SQLState: " + ((SQLException) e).getSQLState());
                System.err.println("Error Code: " + ((SQLException) e).getErrorCode());
                System.err.println("Message: " + e.getMessage());
                Throwable t = ex.getCause();
                while (t != null) {
                    System.out.println("Cause: " + t);
                    t = t.getCause();
                }
            }
        }
    }

    public static void insertRecord(Record record) throws SQLException {
        System.out.println(INSERT_RECORD_SQL);

        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(INSERT_RECORD_SQL)) {
            preparedStatement.setString(1, record.getName());
            preparedStatement.setString(2, record.getPhone());
            preparedStatement.setString(3, record.getEmail());
            preparedStatement.setString(4, record.getCity());
            System.out.println(preparedStatement);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            printSQLException(e);
        }
    }
}
