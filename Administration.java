import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.Scanner;

public class Administration 
{
	Scanner scanner = new Scanner (System.in);
	
	boolean loginScreen()
	{
		System.out.print("UserName: ");
		String username = scanner.nextLine();
		
		System.out.print("Password: ");
		String password = scanner.nextLine();
		
		if (username.equals("admin") && password.equals("admin"))
		{
			
			return true;
			
		}
		else System.out.println("Incorrect Username or Password!"); return loginScreen();
	}
	
	public void Ticketing()
	{
		loginScreen();
		
		Scanner scanner = new Scanner(System.in);
		int Price;
		
		System.out.print("Enter Car Plate to make Ticketing process: ");
		String carPlateReader = scanner.nextLine();
		
		String dbDriver = "com.mysql.jdbc.Driver";
		String dbURL = "jdbc:mysql://localhost:3306/vehicleparkingsystem";
		
		
		try 
		{
			Class.forName(dbDriver).newInstance();
			Connection DatabaseConnection = (Connection) DriverManager.getConnection(dbURL, "root", "");
			
			String dbQuery = "SELECT * FROM parkstatus WHERE carPLate=?";
			PreparedStatement preparedStatement = DatabaseConnection.prepareStatement(dbQuery);
			preparedStatement.setString(1, carPlateReader);
			
			ResultSet resultSetTable = preparedStatement.executeQuery();
			
			if (resultSetTable.next()) 
			{
				String carPlate = resultSetTable.getString("carPlate");
				String fullName  = resultSetTable.getString("fullName");
				String phoneNumber = resultSetTable.getString("phoneNumber");
				String eMail =resultSetTable.getString("eMail");
				Timestamp entryTime = resultSetTable.getTimestamp("entryTime");
				String place = resultSetTable.getString("place");
				boolean isSubscribed = resultSetTable.getBoolean("isSubscribed");
				
				java.util.Date utilDate = new java.util.Date();
				java.sql.Timestamp exitTime = new java.sql.Timestamp(utilDate.getTime());
				System.out.println("D");
				
				//Time difference will be increased by 1 hour when 1 minute elapses.
				long timeDiff = exitTime.getTime() - entryTime.getTime();
				int parkDuration = (int) timeDiff / (60 * 60 * 1000);
				
				if (resultSetTable.getBoolean("isSubscribed") == false) //Only Unsubscribed one pays
				{
					Price = parkDuration*10; //Price is 10$ per an hour!
				}
				else Price = 0;
				
				
				dbQuery="INSERT INTO parkrecords (carPlate, fullName, phoneNumber, eMail, entryTime, exitTime, parkDuration, place, isSubscribed) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
				preparedStatement = DatabaseConnection.prepareStatement(dbQuery);
				
				
				preparedStatement.setString(1, carPlate);
				preparedStatement.setString(2, fullName);
				preparedStatement.setString(3, phoneNumber);
				preparedStatement.setString(4, eMail);
				preparedStatement.setTimestamp(5, entryTime);
				preparedStatement.setTimestamp(6, exitTime);
				preparedStatement.setInt(7, parkDuration);
				preparedStatement.setString(8, place);
				preparedStatement.setBoolean(9, isSubscribed);
				
				preparedStatement.execute(); //Data Transfer from 'parkstatus' Table to 'parkrecord' Table
				
				
				
				
				
				dbQuery = "DELETE FROM parkstatus WHERE carPlate=?";
				preparedStatement = DatabaseConnection.prepareStatement(dbQuery);
				preparedStatement.setString(1, carPlateReader);
				preparedStatement.execute(); //After the data transfer process, delete the record from parkstatus table
				
				DatabaseConnection.close();
				
				
				
				
			}
			else System.out.println("Incorrect Car Plate!");
			
			
		}
		catch (ClassNotFoundException error) 
		{
			// Show error message here
			error.getStackTrace();
		}
		catch (IllegalAccessException error) 
		{
			// Show error message here
			error.getStackTrace();
		}
		catch (InstantiationException error) 
		{
			// Show error message here
			error.getStackTrace();
		}
		catch (SQLException error) 
		{
			// Show error message here
			error.getStackTrace();
		}
		catch (Exception error)
		{
			// Show error message here
			error.getStackTrace();
		}
		
	}
	
	void Messenger()
	{
		String dbDriver = "com.mysql.jdbc.Driver";
		String dbURL = "jdbc:mysql://localhost:3306/vehicleparkingsystem";
		
		System.out.print("Select a Place: ");
		String placeReader = scanner.nextLine();
		
		try 
		{
			
			Class.forName(dbDriver).newInstance();
			Connection DatabaseConnection = (Connection) DriverManager.getConnection(dbURL, "root", "");
			
			String dbQuery = "SELECT * FROM parkstatus WHERE place=?";
			PreparedStatement preparedStatement = DatabaseConnection.prepareStatement(dbQuery);
			preparedStatement.setString(1, placeReader);
			ResultSet resultSetTable = preparedStatement.executeQuery();
			
			
			System.out.println(resultSetTable.getString("carPlate"));
			System.out.println(resultSetTable.getString("fulName"));
			System.out.println(resultSetTable.getString("phoneNumber"));
			System.out.println(resultSetTable.getString("eMail"));
			System.out.println(resultSetTable.getTimestamp("entryTime"));
			System.out.println(resultSetTable.getString("place"));
			System.out.println(resultSetTable.getBoolean("isSubscribed"));

			
			DatabaseConnection.close();
			
		}
		catch (ClassNotFoundException error) 
		{
			// Show error message here
			error.getStackTrace();
		}
		catch (IllegalAccessException error) 
		{
			// Show error message here
			error.getStackTrace();
		}
		catch (InstantiationException error) 
		{
			// Show error message here
			error.getStackTrace();
		}
		catch (SQLException error) 
		{
			// Show error message here
			error.getStackTrace();
		}
		catch (Exception error)
		{
			// Show error message here
			error.getStackTrace();
		}
		
		
	}
	

}
