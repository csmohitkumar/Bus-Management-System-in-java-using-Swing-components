package Lists;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import javax.swing.*;
/**fetch the information about bues from the database and display it to screen*/
public class RouteList
{
	private JFrame frame;
	private List buslist;
	private String atrvalues;
	private JPanel top,bottom;
	private JLabel lblHeading,lblmenu;
	/**Initilise the components of the form*/
    public RouteList()
	{
		frame=new JFrame("List Of Route");
		top=new JPanel();
		bottom=new JPanel();
		lblHeading=new JLabel("List Of Route");
		lblmenu=new JLabel("bus_no         root_no                  avg_speed          employee_id              to                from              fare             run_till           travel_duration           distance1 ");
		buslist=new List();
		frame.setResizable(false);
		//frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	/**add the compponent to  the frame and set its property*/
	public void DisplayArea()
	{
		top.setLayout(new FlowLayout(FlowLayout.CENTER,0,15));
		top.add(lblHeading);
		lblHeading.setFont(new Font("Algerian", Font.BOLD, 30));
		lblHeading.setForeground(new Color(234,53,107));
		
		bottom.setLayout(null);

		bottom.add(lblmenu);
		lblmenu.setBounds(10,20,840,30);

		bottom.add(buslist);
		buslist.setBounds(10,50,840,340);

		DisplayList();

		System.out.println("out");

		frame.setLayout(new BorderLayout(0,0));
		frame.add(top, BorderLayout.NORTH);
		frame.add(bottom, BorderLayout.CENTER);

		frame.setBounds(400,50,850,525);
		frame.setVisible(true);
	}
	/**Collect information about the bues and display it on screen with the help of list*/
	public void DisplayList()
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
			ResultSet rs = stmt.executeQuery("Select * from routemanagement");
 			System.out.println("in");
			atrvalues="";
			while(rs.next())
			{ 
  				atrvalues =rs.getString("bus_no")+"                 "+rs.getString("root_no")+"                             "+rs.getString("avg_speed")+"                    "+rs.getString("employee_id")+"                             "+rs.getString("to1")+"          "+rs.getString("from1")+"                        "+rs.getString("fare")+"                     "+rs.getString("run_till")+"                   "+rs.getString("travel_duration")+"                           "+rs.getString("distance1");					
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
