package Lists;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import javax.swing.*;
/**Featch all the data from the passenger database and display it to screen*/
public class PassengerList 
{
	private JFrame frame;
	private List buslist;
	private String atrvalues=null;
	private JPanel top,bottom;
	private JLabel lblHeading,lblmenu;
	/**Initilise the components of the frame*/
    public PassengerList()
	{
		frame=new JFrame("List Of Passengers");
		top=new JPanel();
		bottom=new JPanel();
		lblHeading=new JLabel("List Of Passengers");
		lblmenu=new JLabel("Passenger id           First name     Last Name    Father Name     Occupation       Blood Group       Email           Gender        DOB                   Contact No                    Address");
		buslist=new List();
		frame.setResizable(false);
		//frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	/**add the componetnts to the frame. method having public access*/
	public void DisplayPassengerArea()
	{
		top.setLayout(new FlowLayout(FlowLayout.CENTER,0,15));
		top.add(lblHeading);
		lblHeading.setFont(new Font("Algerian", Font.BOLD, 30));
		lblHeading.setForeground(new Color(234,53,107));
		
		bottom.setLayout(null);

		bottom.add(lblmenu);
		lblmenu.setBounds(10,20,1000,30);

		bottom.add(buslist);
		buslist.setBounds(10,50,1000,340);

		DisplayPassengerList();

		System.out.println("out");

		frame.setLayout(new BorderLayout(0,0));
		frame.add(top, BorderLayout.NORTH);
		frame.add(bottom, BorderLayout.CENTER);

		frame.setBounds(20,50,1024,525);
		frame.setVisible(true);
	}
	/**Featching the data from the passenger_details tabel and add details to the list*/

	void DisplayPassengerList()
	{
		try
		{
			Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
		   System.out.println("Divers loaded successfully");
		   String source = 
		   "jdbc:odbc:Driver={Microsoft Access Driver (*.mdb)};DBQ= e_transportation_system.mdb";
		   Connection connect = DriverManager.getConnection(source);
		   System.out.println("Connection established successfully");
          Statement stmt = connect.createStatement();
			ResultSet rs = stmt.executeQuery("Select * from passenger_details");
 			System.out.println("in");
			atrvalues="";
			while(rs.next())
			{
  				atrvalues =rs.getString("passenger_id")+"                  "+rs.getString("fname")+"               "+rs.getString("lname")+"        "+rs.getString("father_name")+"        "+rs.getString("occupation")+"                    "+rs.getString("blood_group")+"        "+rs.getString("email")+"   "+rs.getString("gender")+"   "+rs.getString("dobdate")+"   "+rs.getString("contact_no")+"       "+rs.getString("address");					
				buslist.add(atrvalues);								
			}	
			System.out.println("atrvalues");
		}
	    catch(Exception e)
		{
			JOptionPane.showMessageDialog(null, "Error ! Check database is open");
		}	
	}
	

}
