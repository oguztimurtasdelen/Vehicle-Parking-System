import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.naming.spi.DirStateFactory.Result;

public class SubscriberInfo 
{
	
	void MakeSubscriber(String carPlate, String subscriptionNumber, String fullName, String phoneNumber, String eMail, String creditCardNumber, String subscriptionDate)
	{
		
		String dbDriver = "com.mysql.jdbc.Driver";
		String dbURL = "jdbc:mysql://localhost:3306/vehicleparkingsystem";
		
		
		
		// --- DATABASE CONNECTION ---
		try 
		{
			System.out.println("A");
			
			Class.forName(dbDriver).newInstance();
			Connection DatabaseConnection = (Connection) DriverManager.getConnection(dbURL, "root", "");
			
			System.out.println("B");
			
			String dbQuery="INSERT INTO subscriberinfo (carPlate, subscriptionNumber, fullName, phoneNumber, eMail, creditCard, subscriptionDate) VALUES (?, ?, ?, ?, ?, ?, ?)";
			PreparedStatement preparedStatement = DatabaseConnection.prepareStatement(dbQuery);
			
			System.out.println("C");
			
			preparedStatement.setString(1, carPlate);
			preparedStatement.setString(2, subscriptionNumber);
			preparedStatement.setString(3, fullName);
			preparedStatement.setString(4, phoneNumber);
			preparedStatement.setString(5, eMail);
			preparedStatement.setString(6, creditCardNumber);
			preparedStatement.setString(7, subscriptionDate); // add util.sql.date format here
			
			System.out.println("D");
			
			preparedStatement.execute();
			
			System.out.println("E");
			
			DatabaseConnection.close();
			
			System.out.println("F");
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
	
	
	
	void MakeUnsubscriber()
	{
		
		String dbDriver = "com.mysql.jdbc.Driver";
		String dbURL = "jdbc:mysql://localhost:3306/vehicleparkingsystem";
		
		
		
		// --- DATABASE CONNECTION ---
		try 
		{
			
			Class.forName(dbDriver).newInstance();
			Connection DatabaseConnection = (Connection) DriverManager.getConnection(dbURL, "root", "");
			
			String dbQuery="DELETE FROM subscriberInfo WHERE carPlate=? AND subscriptionNumber=?";
			PreparedStatement preparedStatement = DatabaseConnection.prepareStatement(dbQuery);

			// get Car Plate and subscriptionNumber(Password) here means decrypted password, then set Prepared Statements!


			preparedStatement.execute();
			
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
	
	
	
	void UpdateInfo()
	{
		
		String dbDriver = "com.mysql.jdbc.Driver";
		String dbURL = "jdbc:mysql://localhost:3306/vehicleparkingsystem";
		
		try 
		{
			
			Class.forName(dbDriver).newInstance();
			Connection DatabaseConnection = (Connection) DriverManager.getConnection(dbURL, "root", "");
			
			String dbQuery="SELECT * FROM subscriberInfo WHERE carPlate=? AND subscriptionNumber=?";
			PreparedStatement preparedStatement = DatabaseConnection.prepareStatement(dbQuery);
			
			ResultSet resultSetTable = preparedStatement.executeQuery();
			
			if (resultSetTable.next()) 
			{
				String carPlate = resultSetTable.getString("carPlate");
				String fullName = resultSetTable.getString("fulName");
				String subscriptionNumber = resultSetTable.getString("subscriptionNumber");
				String phoneNumber = resultSetTable.getString("phoneNumber");
				String eMail = resultSetTable.getString("eMail");
				String creditCardNumber = resultSetTable.getString("creditCard");
				String subscriptionDate = resultSetTable.getString("subscriptionDate");
				
				System.out.println("carPlate");
				System.out.println("fullName");
				System.out.println("subscriptionNumber");
				System.out.println("phoneNumber");
				System.out.println("eMail");
				System.out.println("creditCardNumber");
				System.out.println("subscriptionDate");
				
				
			}
			else System.out.println("Incorrect Car Plate or Password!"); UpdateInfo();
			
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
