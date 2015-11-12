package Route;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
/**through this clss administrator or user can manage the bus with their route and also implimenting the ActionListener class*/
public class RouteManagement implements ActionListener
{
	private JFrame f;
	private JButton btnCancel,btnAdd,btnClear;
	private JLabel lblHeading,lblBusNo,lblRootNo,lblEmployeeNo,lblFare,lblRunTill,lblSpeed,lblTo,lblFrom,lblTravelDuration,lblDistance,lblVBN,lblVRN,lblVTD,lblVEI,lblVT,lblVF,lblVAT,lblVDT,lblVSA,lblVD;
	private JTextField txtRootNo,txtFare,txtRunTill,txtFrom,txtTo,txtTravelDuration,txtDistance,txtspeed;
	private JComboBox cboBusNo,cboEmployeeNo;
	private JPanel top,center,bottom;
	private String bus=null,route_id=null,ei=null,to=null,from=null,runtill=null,travelduration=null,distance=null,speed=null,fare=null;
	private int busid=0;
	private ImageIcon icon;
	private Color color1,color2,color3;
	Object [] day={"Day","1","2","3","4","5","6","7","8","9","10","11","12","13","14","15","16","17","18","19","20","21","22","23","24","25","26","27","28","29","30","31"};
	Object [] month={"Month","January","February","March","April","May","June","July","August","September","October","October","December"};
	Object [] year={"Year","2013"};
	Object [] BusNo={"Bus No.","2255","2256","6855","6865","9856","4653","5645"};
	Object [] RootNo={"Root","1","2","3","4","5","6","7","8","9","10","11"};
	Object [] EmployeeNo={"Emp","jsdfj"};
	/**used to initilise the fields of the form*/
	public RouteManagement()
	{
		f=new JFrame("Route Management");
		top=new JPanel();
		center=new JPanel();
		bottom=new JPanel();
		lblHeading=new JLabel("Route Management");
		lblBusNo=new JLabel("Bus No.:");
		lblRootNo=new JLabel("Route No.:");
		lblEmployeeNo=new JLabel("Employee ID:");
		lblSpeed=new JLabel("Avg. Speed:");
		lblFare=new JLabel("Fare:");
		lblRunTill=new JLabel("Run Till:");
		lblFrom=new JLabel("From:");
		lblTo=new JLabel("To:");
		lblTravelDuration=new JLabel("Travel Duration:");
		txtTravelDuration=new JTextField();
		cboBusNo=new JComboBox();
		txtRootNo=new JTextField();
		cboEmployeeNo=new JComboBox();
		txtspeed=new JTextField();
		
		

		txtFare=new JTextField();
		txtRunTill=new JTextField();
		txtFrom=new JTextField();
		txtTo=new JTextField();
		lblDistance=new JLabel("Distance");
		txtDistance=new JTextField();

		icon=new ImageIcon("wrong.jpeg");
		lblVBN=new JLabel("Select one of the option",icon,JLabel.CENTER); 
		lblVRN=new JLabel("enter number only",icon,JLabel.CENTER); 
		lblVTD=new JLabel("enter number only",icon,JLabel.CENTER); 
		lblVEI=new JLabel("Select one of the option ",icon,JLabel.CENTER); 
		lblVT=new JLabel("Enter Text only",icon,JLabel.CENTER); 
		lblVF=new JLabel("Enter Text only",icon,JLabel.CENTER); 
		lblVAT=new JLabel("only number ",icon,JLabel.CENTER);
		lblVDT=new JLabel("only number ",icon,JLabel.CENTER);
		lblVSA=new JLabel("enter number only",icon,JLabel.CENTER);
		lblVD=new JLabel("only Enter number",icon,JLabel.CENTER);


		btnAdd=new JButton("Add",new ImageIcon(ClassLoader.getSystemResource("add1.gif")));
		btnCancel=new JButton("Cancel",new ImageIcon(ClassLoader.getSystemResource("delete.png")));
		btnClear=new JButton("Clear",new ImageIcon(ClassLoader.getSystemResource("clear.png")));
		
		color1=new Color(25,107,136);
		color2=new Color(191,233,247);
		color3=new Color(25,107,136);
		//f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	}
	/**set the component of the form. this method has no return type and contains no arguments*/
	public void launchFrame_Root()
	{
		top.setLayout(new FlowLayout(FlowLayout.CENTER,0,15));
		top.setBackground(color1);
		
		top.add(lblHeading);
		lblHeading.setFont(new Font("Edwardian Script ITC", Font.BOLD, 35));
		lblHeading.setForeground(new Color(42,2,14));
		
		center.setLayout(null);
		center.setBackground(color2);

		comboboxvalue();
		
		center.add(lblBusNo);
		lblBusNo.setBounds(100,5,120,20);
		center.add(cboBusNo);
		cboBusNo.setBorder(BorderFactory.createLineBorder(Color.green,1));
		cboBusNo.setBounds(240,5,150,20);
		cboBusNo.addActionListener(this);
		center.add(lblVBN);
		lblVBN.setBounds(370,5,200,20);
		lblVBN.setVisible(false);
		
		center.add(lblRootNo);
		lblRootNo.setBounds(100,40,120,20);
		center.add(txtRootNo);
		txtRootNo.setBorder(BorderFactory.createLineBorder(Color.green,1));
		txtRootNo.setBounds(240,40,150,20);
		center.add(lblVRN);
		lblVRN.setBounds(355,40,200,20);
		lblVRN.setVisible(false);
		
		center.add(lblSpeed);
		lblSpeed.setBounds(100,80,120,20);
		center.add(txtspeed);
		txtspeed.setBorder(BorderFactory.createLineBorder(Color.green,1));
		txtspeed.setBounds(240,80,150,20);
		center.add(lblVTD);
		lblVTD.setBounds(355,80,200,20);
		lblVTD.setVisible(false);
		
		center.add(lblEmployeeNo);
		lblEmployeeNo.setBounds(100,120,120,20);
		center.add(cboEmployeeNo);
		cboEmployeeNo.setBorder(BorderFactory.createLineBorder(Color.green,1));
		cboEmployeeNo.setBounds(240,120,150,20);
		center.add(lblVEI);
		lblVEI.setBounds(370,120,200,20);
		lblVEI.setVisible(false);
		
		center.add(lblFare);
		lblFare.setBounds(100,240,120,20);
		center.add(txtFare);
		txtFare.setBorder(BorderFactory.createLineBorder(Color.green,1));
		txtFare.setBounds(240,240,150,20);
		center.add(lblVAT);
		lblVAT.setBounds(345,240,200,20);
		lblVAT.setVisible(false);
		
		center.add(lblRunTill);
		lblRunTill.setBounds(100,280,120,20);
		center.add(txtRunTill);
		txtRunTill.setBorder(BorderFactory.createLineBorder(Color.green,1));
		txtRunTill.setBounds(240,280,150,20);
		center.add(lblVDT);
		lblVDT.setBounds(350,280,185,20);
		lblVDT.setVisible(false);	
		
		center.add(lblTo);
		lblTo.setBounds(100,160,120,20);
		center.add(txtTo);
		txtTo.setBorder(BorderFactory.createLineBorder(Color.green,1));
		txtTo.setBounds(240,160,150,20);
		center.add(lblVT);
		lblVT.setBounds(350,160,200,20);
		lblVT.setVisible(false);
		
		
		center.add(lblFrom);
		lblFrom.setBounds(100,200,120,20);
		center.add(txtFrom);
		txtFrom.setBorder(BorderFactory.createLineBorder(Color.green,1));
		txtFrom.setBounds(240,200,150,20);
		center.add(lblVF);
		lblVF.setBounds(350,200,200,20);
		lblVF.setVisible(false);
	
		
		center.add(lblTravelDuration);
		lblTravelDuration.setBounds(100,320,120,20);
		center.add(txtTravelDuration);
		txtTravelDuration.setBorder(BorderFactory.createLineBorder(Color.green,1));
		txtTravelDuration.setBounds(240,320,150,20);
		center.add(lblVSA);
		lblVSA.setBounds(365,300,180,60);
		lblVSA.setVisible(false);

		
		center.add(lblDistance);
		lblDistance.setBounds(100,360,120,20);
		center.add(txtDistance);
		txtDistance.setBorder(BorderFactory.createLineBorder(Color.green,1));
		txtDistance.setBounds(240,360,150,20);
		center.add(lblVD);
		lblVD.setBounds(360,360,200,20);
		lblVD.setVisible(false);
		
		bottom.setLayout(new FlowLayout(FlowLayout.CENTER,20,20));
		bottom.setBackground(color3);

		bottom.add(btnAdd);
		btnAdd.addActionListener(this);
		bottom.add(btnCancel);
		btnCancel.addActionListener(this);
		bottom.add(btnClear);
		btnClear.addActionListener(this);

		f.setLayout(new BorderLayout(0,0));
		f.add(top, BorderLayout.NORTH);
		f.add(bottom, BorderLayout.SOUTH);
		f.add(center, BorderLayout.CENTER);

		f.setBounds(400,50,610,580);
		f.setResizable(false);
		f.setVisible(true);
	  }
	  /**implimeting the abstract method of ActionListener class with the help of which admin can perform his task*/
	  public void actionPerformed(ActionEvent e)
	  {
		     bus=(String)cboBusNo.getSelectedItem();
		   // busid=Integer.parseInt(bus);
			route_id=txtRootNo.getText();
			speed=txtspeed.getText();
			ei=(String)cboEmployeeNo.getSelectedItem();
			to=txtTo.getText();
			from=txtFrom.getText();
			fare=txtFare.getText();
			runtill=txtRunTill.getText();
			travelduration=txtTravelDuration.getText();
			distance=txtDistance.getText();
		  if(e.getSource()==btnAdd)
		  {add();
			
			
			int i=0,f=0;
			int p=0;
			if(cboBusNo.getSelectedIndex()==0 )
			{
				f=7;
				lblVBN.setVisible(true);
			}
			else
			{
				lblVBN.setVisible(false);

			}

			p=0;
			for(i=0;i<route_id.length();i++)
			{
				if((route_id.charAt(i)>='0' && route_id.charAt(i)<='9'))
					p++;	
			}
			if(p>0 && p==route_id.length())
			{
				lblVRN.setVisible(false);
				
			}
			else
			{
				f=8;
				lblVRN.setVisible(true);

			}
			p=0;
			for(i=0;i<speed.length();i++)
			{
				if((speed.charAt(i)>='0' && speed.charAt(i)<='9'))
					p++;	
			}
			if(p>0 && p==speed.length())
			{
				f=9;
				lblVTD.setVisible(false);
			}
			else
			{
				lblVTD.setVisible(true);

			}

			if(cboEmployeeNo.getSelectedIndex()==0 )
			{
				lblVEI.setVisible(true);
			}
			else
			{
				f=10;
				lblVEI.setVisible(false);

			}
			p=0;
			for (i=0;i<to.length();i++ )
			{
			if((to.charAt(i)>='a' && to.charAt(i)<='z') || (to.charAt(i)>='A' && to.charAt(i)<='Z')|| to.charAt(i)==' ')
				p++;
			}
			if( p>0 && p==to.length())
		 
				lblVT.setVisible(false);
			else
			{
				f=1;
				lblVT.setVisible(true);
			}
			
			p=0;
			for (i=0;i<from.length();i++ )
			{
			if((from.charAt(i)>='a' && from.charAt(i)<='z') || (from.charAt(i)>='A' && from.charAt(i)<='Z')|| from.charAt(i)==' ')
				p++;
			}
			if( p>0 && p==from.length())
		 
				lblVF.setVisible(false);
			else
		    {
				f=2;
				lblVF.setVisible(true);
			}

			p=0;
			for(i=0;i<fare.length();i++)
			{
				if((fare.charAt(i)>='0' && fare.charAt(i)<='9' ))
					p++;	
			}
			if (p>0 && p==fare.length())
			{
				lblVAT.setVisible(false);	

			}
			else 
			{
				f=3;
				lblVAT.setVisible(true);
			}

			int c=0;
			p=0;
			int j=0,sum=0,first=0,last=0,sub;
			for (i=0;i<runtill.length();i++ )
			{
				if((runtill.charAt(i)>='0' && runtill.charAt(i)<='9'))
				{
					p++;
				}
				if(runtill.charAt(i)=='/')
				{
						c++;
				}

			}
			sum=c+p;
			first=runtill.indexOf('/');
			last=runtill.lastIndexOf('/');
			sub=last-first;
		
			
			if (p>0 && sum==runtill.length() && c==2 && runtill.length()==10 && sub==3 )
		 
				lblVDT.setVisible(false);
			else
			{
				f=4;
				lblVDT.setVisible(true);
			}
			String d=runtill.substring(0,2);
			String m=runtill.substring((first+1),(last));
			String y=runtill.substring(last+1,last+5);
			int d1=0,m1=0,y1=0;
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
			if((d1>=1 && d1<=31) && (m1>=1 &&m1<=12) && (y1>=2000 && y1<=2013))
			{
				lblVDT.setVisible(false);
			}
			else
			{
				f=4;
				lblVDT.setVisible(true);
			}

			p=0;
			for (i=0;i<travelduration.length();i++ )
			{
			if((travelduration.charAt(i)>='0' && travelduration.charAt(i)<='9'))
				p++;
			}
			if( p>0 && p==travelduration.length())
		 
				lblVSA.setVisible(false);
			else
		    {
				f=5;
				lblVSA.setVisible(true);
			}

			p=0;
			for(i=0;i<distance.length();i++)
			{
				if((distance.charAt(i)>='0' && distance.charAt(i)<='9'))
					p++;	
			}
			if (p>0 && p==distance.length())
			{
				lblVD.setVisible(false);	

			}
			else 
			{
				f=6;
				lblVD.setVisible(true);
			}
			switch(f)
			{
				case 1:
					txtTo.requestFocus();
				break;
				case 2:
					txtFrom.requestFocus();
				break;
				case 3:
					txtFare.requestFocus();
				break;
				case 4:
					txtRunTill.requestFocus();
				break;
				case 5:
					txtTravelDuration.requestFocus();
				break;
				case 6:
					txtDistance.requestFocus();
				break;
				default:
					add();
			}
			
		}
		if(e.getSource()==btnClear)
		{
			txtFare.setText("");
			txtRootNo.setText("");
			txtRunTill.setText("");
			txtFrom.setText("");
			txtTo.setText("");
			txtTravelDuration.setText("");
			txtDistance.setText("");
			txtspeed.setText("");

			cboBusNo.setSelectedIndex(0);
			cboEmployeeNo.setSelectedIndex(0);
			
			
			lblVBN.setVisible(false);
			lblVRN.setVisible(false);
			lblVTD.setVisible(false);
			lblVEI.setVisible(false);
			lblVAT.setVisible(false);
			lblVDT.setVisible(false);
			lblVT.setVisible(false);
			lblVF.setVisible(false);
			lblVSA.setVisible(false);
			lblVD.setVisible(false);

		}
		if(e.getSource()==btnCancel)
	    {
		    f.dispose();
	    }
		
	 }
	 /**Adding the Details of route with their respective buses to the database*/
	public void add()
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
			String sql = "INSERT INTO routemanagement(bus_no,root_no,avg_speed,employee_id,to1,from1,fare,run_till,travel_duration,distance1) VALUES ('" + bus + "','" + route_id + "','" + speed + "','" + ei + "','" + to + "','" + from + "','" + fare + "','" + runtill + "','" + travelduration  + "','" + distance +  "')";
			state.execute(sql);
			JOptionPane.showMessageDialog(null, "Record added Successfully");
			System.out.println("Statement executed successfully");
			state.close();
            connect.close();
		}
		catch (Exception e) 
		{
           System.out.print(e);
		}
	}
/**get value of combobox from the Businformation,EmployeeDetails,routemanagement tables with respect to their id*/
	public void comboboxvalue()
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
			   String sql = "SELECT busno FROM Businformation order by busno";
			   ResultSet rst = state.executeQuery(sql);
			  while (rst.next()) 
			  {
					cboBusNo.addItem(rst.getString(1));	
			  }
			   String sql2 = "SELECT employee_id FROM EmployeeDetails order by employee_id";
			   ResultSet rm = state.executeQuery(sql2);
			  while (rm.next()) 
			  {
					cboEmployeeNo.addItem(rm.getString(1));	
			  }
			
			//rst.close();
			//rm.close();
			 state.close();
			 connect.close();
		}
        catch (Exception e)
		{
           System.out.print(e);
        }
	}
}
