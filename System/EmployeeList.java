package Lists;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import javax.swing.*;
/**Fetch the data from the employee details table and display as a list*/
public class EmployeeList
{
	private JFrame frame;
	private List buslist;
	private String atrvalues=null;
	private JPanel top,bottom;
	private JLabel lblHeading,lblmenu;
	/**Inisilise the component*/
    public EmployeeList()
	{
		frame=new JFrame("List Of Employees");
		top=new JPanel();
		bottom=new JPanel();
		lblHeading=new JLabel("List Of Employees");
		lblmenu=new JLabel("Employee id         Full name                  date of Birth          Sex             Marital Status               Phone no              Identity marks               Designation              Date of Joining               Employee Type                     Present address ");
		buslist=new List();
		frame.setResizable(false);
		//frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	/**add the componetnts to the frame*/
	public void DisplayEmployeeArea()
	{
		top.setLayout(new FlowLayout(FlowLayout.CENTER,0,15));
		top.add(lblHeading);
		lblHeading.setFont(new Font("Algerian", Font.BOLD, 30));
		lblHeading.setForeground(new Color(234,53,107));
		
		bottom.setLayout(null);

		bottom.add(lblmenu);
		lblmenu.setBounds(10,20,1190,30);

		bottom.add(buslist);
		buslist.setBounds(10,50,1190,340);

		DisplayEmployeeList();

		System.out.println("out");

		frame.setLayout(new BorderLayout(0,0));
		frame.add(top, BorderLayout.NORTH);
		frame.add(bottom, BorderLayout.CENTER);

		frame.setBounds(50,50,1200,525);
		frame.setVisible(true);
	}
	/**Featching the data from the EmployeeDetails tabel and add details to the list*/
	public void DisplayEmployeeList()
	{
		try
		{
			Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
		   System.out.println("Divers loaded successfully");
		   String source = 
		   "jdbc:odbc:Driver={Microsoft Access Driver (*.mdb)};DBQ= e_transportation_system.mdb";
		   Connection con = DriverManager.getConnection(source);
		   System.out.println("Connection established successfully");
			Statement  stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery("Select * from EmployeeDetails");
 			System.out.println("in");
			atrvalues="";
			while(rs.next())
			{
  				atrvalues =rs.getString("employee_id")+"                              "+rs.getString("full_name")+"                    "+rs.getString("dob_date")+"        "+rs.getString("gender")+"                 "+rs.getString("marital_status")+"           "+rs.getString("phno")+"                 "+rs.getString("identity")+"                            "+rs.getString("designation")+"         "+rs.getString("jdate")+"                      "+rs.getString("employee_type")+"                            "+rs.getString("paddress");					
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
