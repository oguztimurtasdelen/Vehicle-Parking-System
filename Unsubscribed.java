import java.net.Socket;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Timer;
import java.util.TimerTask;

public class Unsubscribed extends ParkStatus implements AttendingParking, Runnable
{

	@Override
	public synchronized String Placement()
	{
		try 
		{
			System.out.println("P1");
			Socket client = new Socket("127.0.0.1", 3334);
			System.out.println("P2");
			
		}
		
		catch (Exception error) 
		{
			error.getStackTrace();
		}
		
		ArrayList<String> parkCapacity = new ArrayList<String>();
		for (int parkCapacityFill = 1; parkCapacityFill < 50; parkCapacityFill++)
		{
			parkCapacity.add("A"+parkCapacityFill);
		}
		
		ArrayList<String> listReserved = new ArrayList<String>();
		
		try 
		{
			String dbDriver = "com.mysql.jdbc.Driver";
			String dbURL = "jdbc:mysql://localhost:3306/vehicleparkingsystem";
			
			
			Class.forName(dbDriver).newInstance();
			Connection DatabaseConnection = (Connection) DriverManager.getConnection(dbURL, "root", "");
			
			
			String dbQuery = "SELECT place FROM parkstatus";
			PreparedStatement preparedStatement = DatabaseConnection.prepareStatement(dbQuery);
						
			ResultSet resultSetTable = preparedStatement.executeQuery();
						
			while (resultSetTable.next()) 
			{
				listReserved.add(resultSetTable.getString("place"));
			}
						
			parkCapacity.removeAll(listReserved);
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
		
		return parkCapacity.get(parkCapacity.size()); //Last place of the park which is empty
		
	}


	@Override
	public void run() 
	{
		try 
		{
			String dbDriver = "com.mysql.jdbc.Driver";
			String dbURL = "jdbc:mysql://localhost:3306/vehicleparkingsystem";
			
			
			Class.forName(dbDriver).newInstance();
			Connection DatabaseConnection = (Connection) DriverManager.getConnection(dbURL, "root", "");
			
			String dbQuery="SELECT COUNT(carPlate) AS numberOfCarPlate FROM subscriberinfo";
			PreparedStatement preparedStatement = DatabaseConnection.prepareStatement(dbQuery);
			ResultSet resultSetTable = preparedStatement.executeQuery();
			
			
			if (resultSetTable.getInt("numberOfCarPlate")<50)
			{
				Scanner scanner = new Scanner(System.in);
				
				System.out.print("Car Plate: ");
				String carPlate = scanner.nextLine();
				System.out.print("Full Name: ");
				String fullName = scanner.nextLine();
				System.out.print("Phone Number: ");
				String phoneNumber = scanner.nextLine();
				System.out.print("E-Mail: ");
				String eMail = scanner.nextLine();
				Timestamp entryTime = null;
				String place = Placement();
				boolean isSubscribed = false;
				
				setCarPlate(carPlate);
				setFullName(fullName);
				setPhoneNumber(phoneNumber);
				seteMail(eMail);
				setEntryTime(entryTime);
				setPlace(place);
				setIsSubscribed(isSubscribed);
				
				CopyBook();
			}
			else
			{
				System.out.println("No limit for the new parking!"); //means park is allowed for only subscribed ones
			}
			
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
