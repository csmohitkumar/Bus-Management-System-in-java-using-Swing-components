package Booking;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import javax.swing.*;
/**fatch information about reservation form and display an other form to print ticket*/
public class TicketPrint
{
	private JFrame frame;
	private List buslist;
	private String atrvalues,tn,rn,bi,sn,d,nm,fr,t,fa,di,pn,strfirst="",strsecond="",strthird="",strfourth="",strmiddle="";
	private JPanel top,bottom;
	private JLabel lblHeading,lblmenu,lblsub;
	private int x,id;
	/**Constractor having public access and having an regument x as reservation id*/
    public TicketPrint(int x)
	{
		frame=new JFrame("Ticket");
		top=new JPanel();
		bottom=new JPanel();
		lblHeading=new JLabel("COSMOS Travels Private LDT.");
		lblsub=new JLabel("Electronic Reservation Slip");
		buslist=new List();

		tn="Ticket Numer: ";
		rn="Reservation Id: ";
		bi="Bus Id: ";
		d="Travel Date: ";
		fr="From: ";
		t="To: ";
		sn="Seat No: ";
		fa="Fare: ";
		di="Distance: ";
		pn="Passanger Name: ";
		id=x;
		System.out.println(id);
		frame.setResizable(false);
		//frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	/**add the componetnts to the frame. method having public access*/
	public void DisplayPassengerArea()
	{
		top.setLayout(new FlowLayout(FlowLayout.CENTER,0,10));
		top.add(lblHeading);
		lblHeading.setFont(new Font("Algerian", Font.BOLD, 14));
		lblHeading.setForeground(new Color(234,53,107));

		bottom.setLayout(null);

		bottom.add(lblsub);
		lblsub.setFont(new Font("Algerian", Font.BOLD, 14));
		lblsub.setForeground(new Color(180,43,95));
		lblsub.setBounds(100,30,250,30);

		bottom.add(buslist);
		buslist.setBounds(5,65,373,180);

		DisplayPassengerList(id);

		System.out.println("out");

		frame.setLayout(new BorderLayout(0,0));
		frame.add(top, BorderLayout.NORTH);
		frame.add(bottom, BorderLayout.CENTER);

		frame.setBounds(400,50,395,320);
		frame.setVisible(true);
	}
		/**Featching the data from the reservation details tabel and add details to the list with new line*/
	public void DisplayPassengerList(int id)
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
			ResultSet rs = stmt.executeQuery("select * from bus_reservation where reservation_id="+ id +"");
 			System.out.println("in");
			atrvalues="";
			while(rs.next())
			{
  				strfirst =tn+" "+rs.getString("ticket_no")+"        "+rn+" "+rs.getString("reservation_id");
				strsecond=bi+" "+rs.getString("bus_id")+"           "+d+" "+rs.getString("travel_date");
				strmiddle=pn+" "+rs.getString("passanger_name");
				strthird=fr+" "+rs.getString("from_detail")+"       "+t+" "+rs.getString("to");
				strfourth=sn+" "+rs.getString("seat_no")+"       "+fa+" "+rs.getString("fare")+"           "+di+" "+rs.getString("distance");
				buslist.add(strfirst);	
				buslist.add(" ");
				buslist.add(strsecond);
				buslist.add(" ");
				buslist.add(strmiddle);
				buslist.add(" ");
				buslist.add(strthird);
				buslist.add(" ");
				buslist.add(strfourth);
			}	
			System.out.println("atrvalues");
		}
	    catch(Exception e)
		{
			JOptionPane.showMessageDialog(null, "Error ! Check database is open");
		}	
	}
	
		
	}
