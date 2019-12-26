import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Timestamp;

public class ParkStatus
{
	
	String carPlate;
	private String fullName;
	private String phoneNumber;
	private String eMail;
	String place;
	private Timestamp entryTime;
	private boolean isSubscribed;
	
	
	public String getCarPlate() 
	{
		return carPlate;
	}
	public void setCarPlate(String carPlate) 
	{
		this.carPlate = carPlate;
	}
	
	
	
	public String getFullName() 
	{
		return fullName;
	}
	public void setFullName(String fullName) 
	{
		this.fullName = fullName;
	}
	
	
	
	public String getPhoneNumber() 
	{
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) 
	{
		this.phoneNumber = phoneNumber;
	}
	
	
	
	public String geteMail() 
	{
		return eMail;
	}
	public void seteMail(String eMail) 
	{
		this.eMail = eMail;
	}
	
	
	
	public String getPlace() 
	{
		return place;
	}
	public void setPlace(String place) 
	{
		this.place = place;
	}
	
	
	
	public Timestamp getEntryTime() 
	{
		return entryTime;
	}
	public void setEntryTime(Timestamp timestamp) 
	{
		this.entryTime = timestamp;
	}
	
	
	
	public boolean getIsSubscribed()
	{
		return isSubscribed;
	}
	public void setIsSubscribed(boolean isSubscribed)
	{
		this.isSubscribed = isSubscribed;
	}
	
	
	
	public void CopyBook()
	{
		
		String dbDriver = "com.mysql.jdbc.Driver";
		String dbURL = "jdbc:mysql://localhost:3306/vehicleparkingsystem";
		
		try 
		{
			
			Class.forName(dbDriver).newInstance();
			Connection DatabaseConnection = (Connection) DriverManager.getConnection(dbURL, "root", "");
			
			String dbQuery="INSERT INTO parkstatus (carPlate, fullName, phoneNumber, eMail, entryTime, place, isSubscribed) VALUES (?, ?, ?, ?, ?, ?, ?)";
			PreparedStatement preparedStatement = DatabaseConnection.prepareStatement(dbQuery);
			
			
			preparedStatement.setString(1, getCarPlate());
			preparedStatement.setString(2, getFullName());
			preparedStatement.setString(3, getPhoneNumber());
			preparedStatement.setString(4, geteMail());
			preparedStatement.setTimestamp(5, getEntryTime());
			preparedStatement.setString(6, getPlace());
			preparedStatement.setBoolean(7, getIsSubscribed());
			
			
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
