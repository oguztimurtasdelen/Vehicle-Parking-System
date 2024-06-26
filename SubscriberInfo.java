import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;
//import javax.naming.spi.DirStateFactory.Result;

public class SubscriberInfo 
{
	
	static Scanner scanner = new Scanner(System.in);
	
	void MakeSubscriber()
	{
		
		//Subscriber capacity is equal to park capacity which is 50
		
		String dbDriver = "com.mysql.jdbc.Driver";
		String dbURL = "jdbc:mysql://localhost:3306/vehicleparkingsystem";
		
		
		try 
		{
			
			Class.forName(dbDriver).newInstance();
			Connection DatabaseConnection = (Connection) DriverManager.getConnection(dbURL, "root", "");
			
			String dbQuery="SELECT COUNT(carPlate) AS numberOfCarPlate FROM subscriberinfo";
			PreparedStatement preparedStatement = DatabaseConnection.prepareStatement(dbQuery);
			ResultSet resultSetTable = preparedStatement.executeQuery();
			
			
			if (resultSetTable.getInt("numberOfCarPlate")<50) 
			{
				System.out.print("Enter your car plate: ");
				String carPlate = scanner.nextLine();
				
				System.out.print("Enter your full name: ");
				String fullName = scanner.nextLine();
				
				System.out.print("Enter your phone number: ");
				String phoneNumber = scanner.nextLine();
				
				System.out.print("Enter your e-mail address: ");
				String eMail = scanner.nextLine();
				
				System.out.print("Enter your credit card number: ");
				String creditCardNumber = scanner.nextLine();
				
				long d = System.currentTimeMillis();
				Date date = new Date(d);
				Date subscriptionDate = date;
				
				String subscriptionNumber = passwordCreator();
				
				dbQuery="SELECT carPlate FROM subscriberinfo";
				preparedStatement = DatabaseConnection.prepareStatement(dbQuery);
				resultSetTable = preparedStatement.executeQuery();
				while (resultSetTable.next()) 
				{
					if (carPlate.equals(resultSetTable.getString("carPlate")) || creditCardNumber.length()!=16 || phoneNumber.length()!=11) 
					{
						System.out.println("This car plate may have been already subscribed!");
						System.out.println("Credit Card Number may be invalid!");
						System.out.println("Phone Number may be invalid!");
						break;
						
					}
					else
					{
						dbQuery="INSERT INTO subscriberinfo (carPlate, subscriptionNumber, fullName, phoneNumber, eMail, creditCard, subscriptionDate) VALUES (?, ?, ?, ?, ?, ?, ?)";
						preparedStatement = DatabaseConnection.prepareStatement(dbQuery);
						
						
						preparedStatement.setString(1, carPlate);
						preparedStatement.setString(2, subscriptionNumber);
						preparedStatement.setString(3, fullName);
						preparedStatement.setString(4, phoneNumber);
						preparedStatement.setString(5, eMail);
						preparedStatement.setString(6, creditCardNumber);
						preparedStatement.setDate(7, subscriptionDate);
						
						preparedStatement.execute();
						
						DatabaseConnection.close();
					}
					
				}
				
			}
			else System.out.println("No limit for the new subscription");
			
			
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
	
	private String passwordCreator()
	{
		// Apply encryption to password here!
		
		System.out.print("Please set a subscription number: ");
		String subscriptionNumber = scanner.nextLine();
		System.out.print("Please confirm your subscription number: ");
		String subscriptionNumberConfirmation = scanner.nextLine();
		
		if (subscriptionNumber.length() <= 6 && subscriptionNumber.equals(subscriptionNumberConfirmation) ) 
		{
			return subscriptionNumber;
		}
		else System.out.println("Please follow the conditions to set a password!"); return passwordCreator();
		
	}
	
	
	
	
	void MakeUnsubscriber()
	{
		
		String dbDriver = "com.mysql.jdbc.Driver";
		String dbURL = "jdbc:mysql://localhost:3306/vehicleparkingsystem";
		
		
		System.out.print("Enter your car plate: ");
		String carPlate = scanner.nextLine();
		
		System.out.print("Enter your subscription number: ");
		String subscriptionNumber = scanner.nextLine();
		
		
		// --- DATABASE CONNECTION ---
		try 
		{
			
			Class.forName(dbDriver).newInstance();
			Connection DatabaseConnection = (Connection) DriverManager.getConnection(dbURL, "root", "");
			
			String dbQuery="DELETE FROM subscriberinfo WHERE carPlate=? AND subscriptionNumber=?";
			PreparedStatement preparedStatement = DatabaseConnection.prepareStatement(dbQuery);
			
			preparedStatement.setString(1, carPlate);
			preparedStatement.setString(2, subscriptionNumber);

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
			
			String dbQuery = "SELECT * FROM subscriberinfo WHERE carPlate=? AND subscriptionNumber=?";
			PreparedStatement preparedStatement = DatabaseConnection.prepareStatement(dbQuery);
			ResultSet resultSetTable = preparedStatement.executeQuery();
			
			
			//Get the row from DB and print!
			if (resultSetTable.next()) 
			{
				
				System.out.println(resultSetTable.getString("carPlate"));
				System.out.println(resultSetTable.getString("fulName"));
				System.out.println(resultSetTable.getString("subscriptionNumber"));
				System.out.println(resultSetTable.getString("phoneNumber"));
				System.out.println(resultSetTable.getString("eMail"));
				System.out.println(resultSetTable.getString("creditCard"));
				System.out.println(resultSetTable.getString("subscriptionDate"));
				
			}
			else System.out.println("Incorrect Car Plate or Password!"); UpdateInfo();
			
			
			// Place the variables into the textBoxes
			String carPlate = resultSetTable.getString("carPlate");
			String subscriptionNumber = resultSetTable.getString("subscriptionNumber");
			String fullName = resultSetTable.getString("fullName");
			String phoneNumber = resultSetTable.getString("phoneNumber");
			String eMail = resultSetTable.getString("eMail");
			String creditCardNumber = resultSetTable.getString("creditCardNumber");
			Date subscriptionDate = resultSetTable.getDate("subscriptionDate");
			
			
			dbQuery = "UPDATE subscriberinfo SET carPlate=? AND subscriptionNumber=? AND fullName=? AND phoneNumber=? AND eMail=? AND creditCardNumber=? WHERE subscriptionNumber=?";
			preparedStatement = DatabaseConnection.prepareStatement(dbQuery);
			
			preparedStatement.setString(1, carPlate);
			preparedStatement.setString(2, subscriptionNumber);
			preparedStatement.setString(3, fullName);
			preparedStatement.setString(4, phoneNumber);
			preparedStatement.setString(5, eMail);
			preparedStatement.setString(6, creditCardNumber);
			preparedStatement.setString(7, ""); //get old subscription number before update
			
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

}
