import java.net.ServerSocket;
import java.net.Socket;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;

import com.mysql.fabric.xmlrpc.Client;

public class Subscribed extends ParkStatus implements AttendingParking, Runnable
{
	
	@Override
	public synchronized String Placement()
	{
		
		try 
		{
			Socket client = new Socket("127.0.0.1", 3334);
			
		}
		
		catch (Exception e) 
		{
			// TODO: handle exception
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
			System.out.println("P3");
			
			
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
		
		return parkCapacity.get(0); //First place of the park which is empty
	}


	@Override
	public void run() 
	{
		System.out.println("In THREAD");
		
		try 
		{
			Scanner scanner = new Scanner(System.in);
			
			System.out.print("Enter your Car Plate:");
			String carPlateReader = scanner.nextLine();
			System.out.print("Enter your Subscription Number:");
			String subscriptionNumberReader = scanner.nextLine();
			
			java.util.Date utilDate = new java.util.Date();
			java.sql.Timestamp entryTime = new java.sql.Timestamp(utilDate.getTime());
			
			String dbDriver = "com.mysql.jdbc.Driver";
			String dbURL = "jdbc:mysql://localhost:3306/vehicleparkingsystem";
			
			Class.forName(dbDriver).newInstance();
			Connection DatabaseConnection = (Connection) DriverManager.getConnection(dbURL, "root", "");
			
			String dbQuery = "SELECT carPlate,fullName,phoneNumber,eMail FROM subscriberinfo WHERE carPlate=? AND subscriptionNumber=?";
			PreparedStatement preparedStatement = DatabaseConnection.prepareStatement(dbQuery);
			
			preparedStatement.setString(1, carPlateReader);
			preparedStatement.setString(2, subscriptionNumberReader);
			
			ResultSet resultSetTable = preparedStatement.executeQuery();

			
			if (resultSetTable.next()) //Get the row from DB and print!
			{
				setCarPlate(resultSetTable.getString("carPlate"));
				setFullName(resultSetTable.getString("fullName"));
				setPhoneNumber(resultSetTable.getString("phoneNumber"));
				seteMail(resultSetTable.getString("eMail"));
				setPlace(Placement());
				setEntryTime(entryTime);
				setIsSubscribed(true);
				CopyBook();
				
			}
			else System.out.println("Incorrect Car Plate or Password!");
			
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
