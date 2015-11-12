package Booking;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import java.util.*;
/**Through this class Administrator/user can Reserve the ticket.This class is implementing the ActionListener class*/
public class Reservation implements ActionListener
{
	private JFrame frame;
	private JButton btnReserve,btnCancel,btnClear,btnPrint;
	private JLabel lblHeading,lblTicketNo,lblreservationid,lblPId,lblPName,lblRootId,lblRootDetail,lblTo,lblTravelDate,lblBusId,lblSeatNo,lblFare,lblDistance,lblVPN,lblVRId,lblVRI,lblVRD,lblVTD,lblVID,lblVSN;
	private JTextField txtTicketNo,txtreservationid,txtPName,txtto,txtRootDetail,txtTravelDate,txtFare,txtDistance;
	private JComboBox cboRootId,cboBusId,cboSeatNo,cboPid;
	private JPanel top,center,bottom;
	private ImageIcon icon;
	private Color color1,color2,color3;
	private Font font;
	private String  pid=null,pname=null,root=null,from=null,to=null,date=null,bid=null,seat=null,fare=null,distance=null,resid=null,typecast=null,ticketno=null,d=null,y=null,m=null;
	private Boolean flag=false;
	private int ticket=0,validate=0,f=0,passid=0,routeid=0,reservationid=0,m1=0,y1=0,d1=0;
	public int reserid;
	Object [] Bus={"bus id"};
	ArrayList al;
	/**used to initilise the fields of the form*/
	public Reservation()
	{
		frame=new JFrame("Reservation");
		top=new JPanel();
		center=new JPanel();
		bottom=new JPanel();

		lblHeading=new JLabel("Reservation");
		
		lblreservationid=new JLabel("Reservation Id :");
		lblTicketNo=new JLabel("Ticket No. :");
		lblPId=new JLabel("Passanger Id :");
		lblPName=new JLabel("Passanger Name :");
		lblRootId=new JLabel("Root Id : ");
		lblRootDetail=new JLabel("Root Detail : ");
		lblTo=new JLabel("To");
		lblTravelDate=new JLabel("Travel Date:");
		lblBusId=new JLabel("Bus Id :");
		lblSeatNo=new JLabel("Seat No :");
		lblFare=new JLabel("Fare :");
		lblDistance=new JLabel("Distance");
		
		txtTicketNo=new JTextField();
		txtPName=new JTextField();
		txtto=new JTextField();
		txtRootDetail=new JTextField();
		txtTravelDate=new JTextField();
		txtFare=new JTextField();
		txtDistance=new JTextField();
		txtreservationid=new JTextField();
		
		cboPid=new JComboBox();
		cboRootId=new JComboBox();
		cboBusId=new JComboBox(Bus);
		
		cboSeatNo=new JComboBox();
		for(int i=0;i<20;i++)
		{
			typecast=Integer.toString(i);;

			cboSeatNo.addItem(typecast);
		}

		center.add(lblSeatNo);

		icon=new ImageIcon("wrong.jpeg");
		lblVRId=new JLabel("enter 6-Digits number",icon,JLabel.LEFT); 
		lblVPN=new JLabel("Enter Text only",icon,JLabel.CENTER); 
		lblVRI=new JLabel("Select one of the option",icon,JLabel.CENTER); 
		lblVRD=new JLabel("Enter Text only",icon,JLabel.CENTER); 
		lblVTD=new JLabel("invalid date",icon,JLabel.CENTER); 
		lblVID=new JLabel("select one of the option",icon,JLabel.CENTER); 
		lblVSN=new JLabel("select seat no.",icon,JLabel.CENTER); 
		

		btnReserve=new JButton("Reserve",new ImageIcon(ClassLoader.getSystemResource("add1.gif")));
		btnCancel=new JButton("Cancel",new ImageIcon(ClassLoader.getSystemResource("delete.png")));
		btnClear=new JButton("Clear",new ImageIcon(ClassLoader.getSystemResource("clear.png")));
		btnPrint=new JButton("Print",new ImageIcon(ClassLoader.getSystemResource("clear.png")));

		color1=new Color(25,107,136);
		color2=new Color(191,233,247);
		color3=new Color(25,107,136);

		//frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setResizable(false);

	}
	/**set and add the component to the form*/
	public void launchFrame_Reservation()
	{
		top.setLayout(new FlowLayout(FlowLayout.CENTER,0,15));
		top.setBackground(color1);
		top.add(lblHeading);
		lblHeading.setFont(new Font("Edwardian Script ITC", Font.BOLD, 35));
		lblHeading.setForeground(new Color(255,255,255));
		
		center.setLayout(null);
		center.setBackground(color2);

		comboboxvalue();
		
		center.add(lblTicketNo);
		lblTicketNo.setBounds(100,5,120,20);

		center.add(txtTicketNo);
		txtTicketNo.setBorder(BorderFactory.createLineBorder(Color.green,1));
		txtTicketNo.setBounds(240,5,150,20);
		txtTicketNo.setEditable(false);
		///////////////////////////////////

		center.add(lblreservationid);
		lblreservationid.setBounds(100,40,120,20);

		center.add(txtreservationid);
		txtreservationid.setBorder(BorderFactory.createLineBorder(Color.green,1));
		txtreservationid.setBounds(240,40,150,20);
		center.add(lblVRId);
		lblVRId.setBounds(400,40,200,20);
		lblVRId.setVisible(false);

		center.add(lblPId);
		lblPId.setBounds(100,80,140,20);

		center.add(cboPid);
		cboPid.setBorder(BorderFactory.createLineBorder(Color.green,1));
		cboPid.setBounds(240,80,150,20);
		cboPid.addActionListener(this);


		center.add(lblPName);
		lblPName.setBounds(100,120,120,20);

		center.add(txtPName);
		txtPName.setBounds(240,120,150,20);
		txtPName.setBorder(BorderFactory.createLineBorder(Color.green,1));
		center.add(lblVPN);
		lblVPN.setBounds(350,120,200,20);
		lblVPN.setVisible(false);
		txtPName.setEditable(false);

		center.add(lblRootId);
		lblRootId.setBounds(100,160,120,20);

		center.add(cboRootId);
		cboRootId.setBorder(BorderFactory.createLineBorder(Color.green,1));
		cboRootId.setBounds(240,160,150,20);
		cboRootId.addActionListener(this);
		center.add(lblVRI);
		lblVRI.setBounds(375,160,200,20);
		lblVRI.setVisible(false);

		center.add(lblRootDetail);
		lblRootDetail.setBounds(100,200,120,20);

		center.add(txtRootDetail);
		txtRootDetail.setBorder(BorderFactory.createLineBorder(Color.green,1));
		txtRootDetail.setBounds(240,200,75,20);
		txtRootDetail.setEditable(false);

		center.add(lblTo);
		lblTo.setBounds(320,200,40,20);

		center.add(txtto);
		txtto.setBorder(BorderFactory.createLineBorder(Color.green,1));
		txtto.setBounds(340,200,75,20);
		center.add(lblVRD);
		lblVRD.setBounds(370,200,200,20);
		lblVRD.setVisible(false);
		txtto.setEditable(false);

		center.add(lblTravelDate);
		lblTravelDate.setBounds(100,240,120,20);

		center.add(txtTravelDate);
		txtTravelDate.setBorder(BorderFactory.createLineBorder(Color.green,1));
		txtTravelDate.setBounds(240,240,150,20);
		center.add(lblVTD);
		lblVTD.setBounds(345,240,200,20);
		lblVTD.setVisible(false);
		
		center.add(lblBusId);
		lblBusId.setBounds(100,280,120,20);

		center.add(cboBusId);
		cboBusId.setBorder(BorderFactory.createLineBorder(Color.green,1));
		cboBusId.setBounds(240,280,150,20);
		cboBusId.addActionListener(this);
		center.add(lblVID);
		lblVID.setBounds(380,280,200,20);
		lblVID.setVisible(false);

		
		lblSeatNo.setBounds(100,320,120,20);

		center.add(cboSeatNo);
		cboSeatNo.setBorder(BorderFactory.createLineBorder(Color.green,1));
		cboSeatNo.setBounds(240,320,150,20);
		//cboSeatNo.addActionListener(this);
		center.add(lblVSN);
		lblVSN.setBounds(355,320,200,20);
		lblVSN.setVisible(false);
		
		center.add(lblFare);
		lblFare.setBounds(100,360,120,20);

		center.add(txtFare);
		txtFare.setBorder(BorderFactory.createLineBorder(Color.green,1));
		txtFare.setBounds(240,360,150,20);
		txtFare.setEditable(false);

		center.add(lblDistance);
		lblDistance.setBounds(100,400,120,20);

		center.add(txtDistance);
		txtDistance.setBorder(BorderFactory.createLineBorder(Color.green,1));
		txtDistance.setBounds(240,400,150,20);
		txtDistance.setEditable(false);
		
		bottom.setLayout(new FlowLayout(FlowLayout.CENTER,20,20));
		bottom.setBackground(color3);
		
		bottom.add(btnReserve);
		btnReserve.addActionListener(this);
		bottom.add(btnCancel);
		btnCancel.addActionListener(this);
		bottom.add(btnClear);
		btnClear.addActionListener(this);

		bottom.add(btnPrint);
		btnPrint.addActionListener(this);
		btnPrint.setEnabled (false);
		
		frame.setLayout(new BorderLayout(0,0));
		frame.add(top, BorderLayout.NORTH);
		frame.add(bottom, BorderLayout.SOUTH);
		frame.add(center, BorderLayout.CENTER);
		
		frame.setBounds(400,50,575,620);
		frame.setVisible(true);
	  }
	
	  /**implimeting the abstract method of ActionListener class*/
	  public void actionPerformed(ActionEvent e)
	 {
		  getvalue();
		  al = new ArrayList();
		 if(e.getSource()==cboPid)
		 {
			 passenger(passid);

		 }
		
		 if(e.getSource()==cboRootId)
		 {
			 cboBusId.removeAllItems();
			 schedulingfield(root);
			 routefill(routeid);

		 }
		 ///////////////////////////////
		/*if(e.getSource()==cboBusId)
		 {
			 //seat(date,passid);

		 }//////////////////////*/
		  if(e.getSource()==btnReserve)
		  {
			  validate=validation();
			  if(validate==0)
			  {
				  add();
				  flag=true;
				  btnPrint.setEnabled (true);
				  //btnClear.setEnabled (false);

			  }
		}
		if(e.getSource()==btnPrint)
		{
			if(flag=true)
			{
				getvalue();
				reserid=Integer.parseInt(resid);
				TicketPrint el=new TicketPrint(reserid);
				el.DisplayPassengerArea();
			}
		}

		if(e.getSource()==btnClear)
		{
			System.out.println(al);
			clear();
		}
		if(e.getSource()==btnCancel)
	    {
		    frame. dispose();
	    }
	 }
	 /**Add the details of Reservation form to the database with the help of JdbcOdbcDriver*/
	 void add()
	{
		try
		{
			Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
		   System.out.println("Divers loaded successfully");
		   String source = 
		   "jdbc:odbc:Driver={Microsoft Access Driver (*.mdb)};DBQ= e_transportation_system.mdb";
		   Connection connect = DriverManager.getConnection(source);
		   System.out.println("Connection established successfully");
           Statement state = connect.createStatement();
			String sql = "INSERT INTO bus_reservation(reservation_id,passanger_id,passanger_name,root_id,from_detail,to,travel_date,bus_id,seat_no,fare,distance)VALUES ('" + reservationid+ "','" + pid + "','" + pname + "','" + root + "','" + from + "','" + to + "','" + date + "','" + bid + "','" + seat + "','" + fare + "','" + distance + "')";
			state.execute(sql);
			JOptionPane.showMessageDialog(null, "Record added Successfully");
			System.out.println("Statement executed successfully");

			String sql1 = "select * from bus_reservation where reservation_id="+ reservationid +"";
			ResultSet rst = state.executeQuery(sql1);
			while (rst.next()) 
			{
				  ticketno=rst.getString("ticket_no");
				  txtTicketNo.setText(ticketno);
				  JOptionPane.showMessageDialog(null, "Your ticket number is "+ticketno);
			  }
			state.close();
            connect.close();
			
		}
		catch (Exception e) 
		{
           System.out.print(e);
		}
	}
/**Get combobox values from the routemanagement table*/
	public void comboboxvalue()
	{
		String a;
		try
		{
			  Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
		   System.out.println("Divers loaded successfully");
		   String source = 
		   "jdbc:odbc:Driver={Microsoft Access Driver (*.mdb)};DBQ= e_transportation_system.mdb";
		   Connection connect = DriverManager.getConnection(source);
		   System.out.println("Connection established successfully");
           Statement state = connect.createStatement();
			   String sql = "SELECT passenger_id FROM passenger_details order by passenger_id";
			   ResultSet rst = state.executeQuery(sql);
			  while (rst.next()) 
			  {
					cboPid.addItem(rst.getString(1));	
			  }
			   String sql2 = "SELECT root_no FROM routemanagement order by root_no";
			   ResultSet rm = state.executeQuery(sql2);
			  while (rm.next()) 
			  {
					cboRootId.addItem(rm.getString(1));	
			  }
			 state.close();
			 connect.close();
		}
		 catch (Exception e)
		{
           System.out.print(e);
        }
	}
	/**taking the passenger name from the passenger_details table and set it to crossponding combobox*/
	public void passenger(int p)
	{
		try
		{
			   Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
		   System.out.println("Divers loaded successfully");
		   String source = 
		   "jdbc:odbc:Driver={Microsoft Access Driver (*.mdb)};DBQ= e_transportation_system.mdb";
		   Connection connect = DriverManager.getConnection(source);
		   System.out.println("Connection established successfully");
           Statement state = connect.createStatement();
			   String sql = "select * from passenger_details where passenger_id="+ p +"";
			   ResultSet rst = state.executeQuery(sql);
			  while (rst.next()) 
			  {
				  String first,middle,full;
				  first=rst.getString("fname");
				 middle=rst.getString("lname");
				  full=first+" "+middle;
				  txtPName.setText(full);
			  }
			  
			 state.close();
			 connect.close();
		}
        catch (Exception e)
		{
           System.out.print(e);
        }
	}

/**Get data from scheduling database*/
public void schedulingfield(String route1)
	{
		try
		{
			  Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
		   System.out.println("Divers loaded successfully");
		   String source = 
		   "jdbc:odbc:Driver={Microsoft Access Driver (*.mdb)};DBQ= e_transportation_system.mdb";
		   Connection connect = DriverManager.getConnection(source);
		   System.out.println("Connection established successfully");
           Statement state = connect.createStatement();
			   String sql = "select * from scheduling where root_no='"+ route1 +"'";
			   ResultSet rst = state.executeQuery(sql);
			  while (rst.next()) 
			  { 
				  txtRootDetail.setText(rst.getString("root_from"));
				  txtto.setText(rst.getString("root_to"));
				  cboBusId.addItem(rst.getString("bus_no"));  
				  txtTravelDate.setText(rst.getString("travel_date"));
			  }
			  
			 state.close();
			 connect.close();
		}
        catch (Exception e)
		{
           System.out.print(e);
        }
	}

/**Taking route details,bus id,fare,distance from the routemanagement table having argument q as route id*/
	public void routefill(int q)
	{
		try
		{
			  Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
		   System.out.println("Divers loaded successfully");
		   String source = 
		   "jdbc:odbc:Driver={Microsoft Access Driver (*.mdb)};DBQ= e_transportation_system.mdb";
		   Connection connect = DriverManager.getConnection(source);
		   System.out.println("Connection established successfully");
           Statement state = connect.createStatement();
			   String sql = "select * from routemanagement where root_no="+ q +"";
			   ResultSet rst = state.executeQuery(sql);
			  while (rst.next()) 
			  {  
				  txtFare.setText(rst.getString("fare"));
				  txtDistance.setText(rst.getString("distance1"));
			  }
			  
			 state.close();
			 connect.close();
		}
        catch (Exception e)
		{
           System.out.print(e);
        }
	}
	/**Validting the field's values befor adding the details in the database*/

	public int validation()
	{
		int i=0;
		f=0;
			int p=0;
			try
			{
				reservationid=Integer.parseInt(resid);
				if(resid.length()==6)
				{
					lblVRId.setVisible(false);
				}
				else
				{
					f=4;
					lblVRId.setVisible(true);
				}
				
			}
			catch (Exception fd)
			{
				f=4;
					
				lblVRId.setVisible(true);
				JOptionPane.showMessageDialog(null, "enter 6-Digits number");
			}

			
			for (i=0;i<pname.length();i++ )
			{
			if((pname.charAt(i)>='a' && pname.charAt(i)<='z') || (pname.charAt(i)>='A' && pname.charAt(i)<='Z')|| pname.charAt(i)==' ')
				p++;
			}
			if( p>0 && p==pname.length())
		 
				lblVPN.setVisible(false);
			else
			{
				f=1;
				lblVPN.setVisible(true);
			}

			if(cboRootId.getSelectedIndex()==0)
			{
				lblVRI.setVisible(true);
			}
			else
			{
				lblVRI.setVisible(false);
			}

			p=0;
			int s=0,q=0;
			for (i=0;i<from.length();i++ )
			{
			if((from.charAt(i)>='a' && from.charAt(i)<='z') || (from.charAt(i)>='A' && pname.charAt(i)<='Z')|| from.charAt(i)==' ')
				p++;
			}
			for (i=0;i<to.length();i++ )
			{
			if((to.charAt(i)>='a' && to.charAt(i)<='z') || (to.charAt(i)>='A' && to.charAt(i)<='Z')|| to.charAt(i)==' ')
				q++;
			}
			s=p+q;

			if( p>0 && q>0 && s==from.length()+to.length())
		 
				lblVRD.setVisible(false);
			else
			{
				f=2;
				lblVRD.setVisible(true);
			}

			int c=0;
			p=0;
			int j=0,sum=0,first=0,last=0,sub;
			for (i=0;i<date.length();i++ )
			{
				if((date.charAt(i)>='0' && date.charAt(i)<='9'))
				{
					p++;
				}
				if(date.charAt(i)=='/')
				{
						c++;
				}

			}
			sum=c+p;
			first=date.indexOf('/');
			last=date.lastIndexOf('/');
			sub=last-first;
		
			
			if (p>0 && sum==date.length() && c==2 && date.length()==10 && sub==3 )
		 
				lblVTD.setVisible(false);
			else
			{
				f=3;
				lblVTD.setVisible(true);
			}
				d=date.substring(0,2);
			m=date.substring((first+1),(last));
			y=date.substring(last+1,last+5);
			try
			{
				d1=Integer.parseInt(d);
				m1=Integer.parseInt(m);
				y1=Integer.parseInt(y);
			}
			catch (Exception as )
			{
				 JOptionPane.showMessageDialog(null, "date field contains only number and /");
			}
			if((d1>=1 && d1<=31) && (m1>=1 &&m1<=12) && (y1==2013))
			{
				lblVTD.setVisible(false);
			}
			else
			{
				f=3;
				lblVTD.setVisible(true);
			}




			/*if(cboBusId.getSelectedIndex()==0)
			{
				lblVID.setVisible(true);
			}
			else
			{
				lblVID.setVisible(false);
			}

			if(cboSeatNo.getSelectedIndex()==0)
			{
				lblVSN.setVisible(true);
			}
			else
			{
				lblVSN.setVisible(false);
			}*/
			switch(f)
			{
				case 1:
					txtPName.requestFocus();
				break;
				case 2:
					txtto.requestFocus();
				break;
				case 3:
					txtTravelDate.requestFocus();
				break;
				case 4:
					txtreservationid.requestFocus();
				break;
			}
			return f;
	}
	void getvalue()
	{
			resid=txtreservationid.getText();
			ticket=0;//txtTicketNo.getText();
			pid =(String)cboPid.getSelectedItem();
			try
			{
				passid=Integer.parseInt(pid);
			}
			catch (Exception ew)
			{
				JOptionPane.showMessageDialog(null, "enter  number");
			}
			

			fare=txtFare.getText();
			distance=txtDistance.getText();
		    pname=txtPName.getText();
			from=txtRootDetail.getText();
			to=txtto.getText();
			date=txtTravelDate.getText();
			bid=(String)cboBusId.getSelectedItem();
			root=(String)cboRootId.getSelectedItem();
			routeid=Integer.parseInt(root);
			seat=(String)cboSeatNo.getSelectedItem();
	}
	/**Clear the fields of the form*/
	public void clear()
	{
		txtTicketNo.setText("");
		txtreservationid.setText("");
			cboPid.setSelectedIndex(0);
			txtPName.setText("");
			txtto.setText("");
			txtRootDetail.setText("");
			txtTravelDate.setText("");
			txtFare.setText("");
			txtDistance.setText("");

			cboRootId.setSelectedIndex(0);
			cboBusId.setSelectedIndex(0);
			cboSeatNo.setSelectedIndex(0);

			lblVPN.setVisible(false);
			lblVRId.setVisible(false);
			lblVRI.setVisible(false);
			lblVRD.setVisible(false);
			lblVTD.setVisible(false);
			lblVID.setVisible(false);
			lblVSN.setVisible(false);
	}
}
