//package com.demo.dao;
//
//import com.demo.model.InputString;
//
//import java.sql.Connection;
//import java.sql.DriverManager;
//import java.sql.PreparedStatement;
//import java.sql.ResultSet;
//import java.sql.SQLException;
//import java.util.ArrayList;
//import java.util.List;
//
//
///**
// * AbstractDAO.java This DAO class provides CRUD database operations for the
// * table users in the database.
// *
// * @author Ramesh Fadatare
// *
// */
//
//public class InputStringDAO {
//	private String jdbcURL = "jdbc:mysql://localhost:3306/basic1string?useSSL=false";
//	private String jdbcUsername = "root";
//	private String jdbcPassword = "";
//
//	private static final String INSERT_INPUT_STRING_SQL = "INSERT INTO basic" + " (input, output, repeated_words) VALUES "
//			+ " (?, ?, ?);";
//	private static final String SELECT_ALL_INPUT_STRING = "select * from basic";
//	private static final String SELECT_LAST_INPUT_STRING = "select * from basic order by id desc limit 1";
//
//	public InputStringDAO() {
//	}
//
//	protected Connection getConnection() {
//		Connection connection = null;
//		try {
//			Class.forName("com.mysql.cj.jdbc.Driver");
//			connection = DriverManager.getConnection(jdbcURL, jdbcUsername, jdbcPassword);
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} catch (ClassNotFoundException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		return connection;
//	}
//
//	public void insertInputString(InputString inputString) throws SQLException {
//		System.out.println(INSERT_INPUT_STRING_SQL);
//		// try-with-resource statement will auto close the connection.
//		try (Connection connection = getConnection();
//				PreparedStatement preparedStatement = connection.prepareStatement(INSERT_INPUT_STRING_SQL)) {
//			preparedStatement.setString(1, inputString.getInput());
//			preparedStatement.setString(2, inputString.getOutput());
//			preparedStatement.setString(3, inputString.getRepeatedWords());
//			System.out.println(preparedStatement);
//			preparedStatement.executeUpdate();
//		} catch (SQLException e) {
//			printSQLException(e);
//		}
//	}
//
//	private void printSQLException(SQLException ex) {
//		for (Throwable e : ex) {
//			if (e instanceof SQLException) {
//				e.printStackTrace(System.err);
//				System.err.println("SQLState: " + ((SQLException) e).getSQLState());
//				System.err.println("Error Code: " + ((SQLException) e).getErrorCode());
//				System.err.println("Message: " + e.getMessage());
//				Throwable t = ex.getCause();
//				while (t != null) {
//					System.out.println("Cause: " + t);
//					t = t.getCause();
//				}
//			}
//		}
//	}
//
//	public List<InputString> selectAllInputStrings() {
//
//		// using try-with-resources to avoid closing resources (boiler plate code)
//		List<InputString> inputString = new ArrayList<>();
//		// Step 1: Establishing a Connection
//		try {
//            Connection connection = getConnection();
//            try {
//                PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_INPUT_STRING);
//                try {
//                    System.out.println(preparedStatement);
//                    // Step 3: Execute the query or update query
//                    ResultSet rs = preparedStatement.executeQuery();
//
//                    // Step 4: Process the ResultSet object.
//                    while (rs.next()) {
//                        int id = rs.getInt("id");
//                        String input = rs.getString("input");
//                        String output = rs.getString("output");
//                        String processing_date = rs.getString("processing_date");
//                        String repeated_words = rs.getString("repeated_words");
//                        inputString.add(new InputString(id, input, output, processing_date, repeated_words));
//                    }
//                } finally {
//                    preparedStatement.close();
//                }
//            } finally {
//                connection.close();
//            }
//        } catch (SQLException e) {
//			printSQLException(e);
//		}
//		return inputString;
//	}
//
//    public InputString selectLastInputString() {
//
//        // using try-with-resources to avoid closing resources (boiler plate code)
//        InputString inputString = new InputString();
//        // Step 1: Establishing a Connection
//        try (Connection connection = getConnection();
//
//             // Step 2:Create a statement using connection object
//             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_LAST_INPUT_STRING);) {
//            System.out.println(preparedStatement);
//            // Step 3: Execute the query or update query
//            ResultSet rs = preparedStatement.executeQuery();
//
//            // Step 4: Process the ResultSet object.
//            while (rs.next()) {
//                int id = rs.getInt("id");
//                String input = rs.getString("input");
//                String output = rs.getString("output");
//                String processing_date = rs.getString("processing_date");
//                inputString = new InputString(id, input, output, processing_date);
//            }
//        } catch (SQLException e) {
//            printSQLException(e);
//        }
//        return inputString;
//    }
//
//}
