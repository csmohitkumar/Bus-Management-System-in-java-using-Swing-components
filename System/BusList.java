package Lists;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import javax.swing.*;
/**fetch the information about bues from the database and display it to screen*/
public class BusList
{
	private JFrame frame;
	private List buslist;
	private String atrvalues;
	private JPanel top,bottom;
	private JLabel lblHeading,lblmenu;
	/**Initilise the components of the form*/
    public BusList()
	{
		frame=new JFrame("List Of Buses");
		top=new JPanel();
		bottom=new JPanel();
		lblHeading=new JLabel("List Of Buses");
		lblmenu=new JLabel("Bus No.         Model                  Reg No.          Capacity             Purchage Date                Status              Category");
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
		lblmenu.setBounds(10,20,700,30);

		bottom.add(buslist);
		buslist.setBounds(10,50,700,340);

		DisplayList();

		System.out.println("out");

		frame.setLayout(new BorderLayout(0,0));
		frame.add(top, BorderLayout.NORTH);
		frame.add(bottom, BorderLayout.CENTER);

		frame.setBounds(400,50,740,525);
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
			ResultSet rs = stmt.executeQuery("Select * from Businformation");
 			System.out.println("in");
			atrvalues="";
			while(rs.next())
			{
  				atrvalues =rs.getString("busno")+"                 "+rs.getString("model")+"        "+rs.getString("regno")+"        "+rs.getString("sitting")+"                 "+rs.getString("qdate")+"                            "+rs.getString("ins")+"        "+rs.getString("cato");					
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
