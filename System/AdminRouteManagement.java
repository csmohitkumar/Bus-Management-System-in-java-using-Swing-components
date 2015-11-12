package Route;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
/**Through this class administrator can update,search and delete the records of Route and cancel the operation.*/
public class AdminRouteManagement implements ActionListener
{
	private JFrame frame;
	private JButton btnCancel,btnDelete,btnClear,btnUpdate,btnSearch;
	private JLabel lblHeading,lblBusNo,lblRootNo,lblEmployeeNo,lblFare,lblRunTill,lblSpeed,lblTo,lblFrom,lblTravelDuration,lblDistance,lblVBN,lblVRN,lblVTD,lblVEI,lblVT,lblVF,lblVAT,lblVDT,lblVSA,lblVD;
	private JTextField txtFare,txtRunTill,txtFrom,txtTo,txtTravelDuration,txtDistance,txtspeed;
	private JComboBox cboBusNo,cboEmployeeNo,cboRootNo;
	private JPanel top,center,bottom;
	private String bus=null,route_id=null,ei=null,to=null,from=null,runtill=null,travelduration=null,distance=null,speed=null,fare=null,select=null;
	private int busid=0,validate=0,search_value=0,f=0;
	private ImageIcon icon;
	private Color color1,color2,color3;
	/**used to initilise the fields of the form*/
	public AdminRouteManagement()
	{
		frame=new JFrame("Route Management");
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
		cboRootNo=new JComboBox();
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


		btnDelete=new JButton("Delete",new ImageIcon(ClassLoader.getSystemResource("add1.gif")));
		btnCancel=new JButton("Cancel",new ImageIcon(ClassLoader.getSystemResource("delete.png")));
		btnClear=new JButton("Clear",new ImageIcon(ClassLoader.getSystemResource("clear.png")));
		btnUpdate=new JButton("Update",new ImageIcon(ClassLoader.getSystemResource("update.jpg")));
		btnSearch=new JButton("Search",new ImageIcon(ClassLoader.getSystemResource("Search.png")));
		
		color1=new Color(25,107,136);
		color2=new Color(191,233,247);
		color3=new Color(25,107,136);
		//frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	}
/**set the component of the form*/
	public void launchFrame_Route()
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
		cboBusNo.setEnabled(false);
		
		center.add(lblRootNo);
		lblRootNo.setBounds(100,40,120,20);
		center.add(cboRootNo);
		cboRootNo.addActionListener(this);
		cboRootNo.setBorder(BorderFactory.createLineBorder(Color.green,1));
		cboRootNo.setBounds(240,40,150,20);
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
		cboEmployeeNo.setEnabled(false);
		
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
		
		bottom.add(btnSearch);
		btnSearch.addActionListener(this);

		bottom.add(btnUpdate);
		btnUpdate.addActionListener(this);

		bottom.add(btnDelete);
		btnDelete.addActionListener(this);
		
		bottom.add(btnClear);
		btnClear.addActionListener(this);

		bottom.add(btnCancel);
		btnCancel.addActionListener(this);

		frame.setLayout(new BorderLayout(0,0));
		frame.add(top, BorderLayout.NORTH);
		frame.add(bottom, BorderLayout.SOUTH);
		frame.add(center, BorderLayout.CENTER);

		frame.setBounds(400,50,610,580);
		frame.setResizable(false);
		frame.setVisible(true);
	  }

	  /**implimeting the abstract method of ActionListener class with the help of which admin can perform his task*/
	  public void actionPerformed(ActionEvent e)
	  {
			try
			{
				search_value=Integer.parseInt((String)cboRootNo.getSelectedItem());
			}
			catch (Exception d)
			{
				f=1;
				JOptionPane.showMessageDialog(null,"Not a number");
			}
		
		  if(e.getSource()==cboRootNo)
		  {
			  cboBusNo.setEnabled(true);
			  cboEmployeeNo.setEnabled(true);
		  }

		     getvalue();
			
		  if(e.getSource()==btnDelete)
		  {
				delete(search_value);
		  }
		if(e.getSource()==btnClear)
		{
			clear();

		}
		if(e.getSource()==btnCancel)
	    {
		    frame.dispose();
	    }
		if(e.getSource()==btnSearch)
	  {
		  search(search_value);
	  }
	  /////////////////////////////////////////////////////////
	    if(e.getSource()==btnUpdate)

		 {
			    getvalue();
				validate=validation();
				if(validate==0)
				{
					update(search_value);
				}
			 
		 }//////////////////////////////////////////////////////////////////////////////////

		
	 }
	/**taking entered data from the form and save it to variable*/
	 public void getvalue()
	{
			bus=(String)cboBusNo.getSelectedItem();
		   // busid=Integer.parseInt(bus);
			route_id=(String)cboRootNo.getSelectedItem();
			speed=txtspeed.getText();
			ei=(String)cboEmployeeNo.getSelectedItem();
			to=txtTo.getText();
			from=txtFrom.getText();
			fare=txtFare.getText();
			runtill=txtRunTill.getText();
			travelduration=txtTravelDuration.getText();
			distance=txtDistance.getText();
	}
	
		/**Search the fields of the Route with respect to route id from the database*/
	 public boolean search(int id)
	  {
		  boolean result=false;
		  try
		  {
			  Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
		   System.out.println("Divers loaded successfully");
		   String source = 
		   "jdbc:odbc:Driver={Microsoft Access Driver (*.mdb)};DBQ= e_transportation_system.mdb";
		   Connection connect = DriverManager.getConnection(source);
		   System.out.println("Connection established successfully");
           Statement state = connect.createStatement();
              String sql = "select * from routemanagement where root_no="+ id +"";
              ResultSet rs=state.executeQuery(sql);
		      if(rs.next())
              {
				  
				    cboRootNo.setSelectedItem(rs.getString("root_no"));
					cboEmployeeNo.setSelectedItem(rs.getString("employee_id"));
					cboBusNo.setSelectedItem(rs.getString("bus_no"));

                    txtspeed.setText(rs.getString("avg_speed"));
                    txtTo.setText(rs.getString("to1"));
					txtFrom.setText(rs.getString("from1"));
                    txtFare.setText(rs.getString("fare"));
					txtRunTill.setText(rs.getString("run_till"));
                    txtTravelDuration.setText(rs.getString("travel_duration"));
					txtDistance.setText(rs.getString("distance1"));
                    result=true;
              }
		      JOptionPane.showMessageDialog(null, "Record Found Successfully");
		      System.out.println("Statement executed successfully");
		      rs.close();
              state.close();
              connect.close();
		  }
		 
          catch (Exception e) {
          System.out.print(e);
          }
		  return result;
          }


		 /**update fields of the database*/
		 public void update(int id)
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
				String sql0 = "update routemanagement set bus_no='"+ bus+"'where root_no="+ id +"";
				String sql1 = "update routemanagement set avg_speed='"+ speed+"' where root_no="+ id +"";
				String sql2 = "update routemanagement set employee_id='"+ ei+"' where root_no="+ id +"";
				String sql3 = "update routemanagement set to1='"+to+"' where root_no="+ id +"";
				String sql4 = "update routemanagement set from1='"+from+"' where root_no="+ id +"";
				String sql5 = "update routemanagement set fare='"+ fare+"' where root_no="+ id +"";
				String sql6 = "update routemanagement set run_till='"+runtill+"' where root_no="+ id +"";
				String sql7 = "update routemanagement set travel_duration='"+travelduration+"' where root_no="+ id +"";
				String sql8 = "update routemanagement set distance1='"+distance+"' where root_no="+ id +"";
				
				state.execute(sql0);
				state.execute(sql1);
				state.execute(sql2);
				state.execute(sql3);
				state.execute(sql4);
				state.execute(sql5);
				state.execute(sql6);
				state.execute(sql7);
				state.execute(sql8);
				JOptionPane.showMessageDialog(null, "Record update Successfully");
				System.out.println("Statement executed successfully");
				state.close();
				connect.close();
			 }
			 catch (Exception e) 
			 {
				System.out.print(e);
             }
		  }
		 /**Delete record of the Route from the table*/ 
		 public void delete(int i)
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
				 String sql="delete from routemanagement where root_no="+ i +"";
				 state.execute(sql);
				 cboRootNo.removeItem(i);
				JOptionPane.showMessageDialog(null, "Record delete Successfully");
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
			   String sql3 = "SELECT root_no FROM routemanagement order by root_no";
			   ResultSet r3 = state.executeQuery(sql3);
			  while (r3.next()) 
			  {
					cboRootNo.addItem(r3.getString(1));	
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

	/**Validating the values entered in the field*/
	public int validation()
	{
			int i=0;
			f=0;
			int p=0;
			if(bus.charAt(0)==' ' )
			{
				f=7;
				lblVBN.setVisible(true);
			}
			else
			{
				//f=0;
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
				//f=0;
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
				
				lblVTD.setVisible(false);
			}
			else
			{
				f=9;
				lblVTD.setVisible(true);

			}

			if(cboEmployeeNo.getSelectedIndex()==0 )
			{
				f=10;
				lblVEI.setVisible(true);
			}
			else
			{
				
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



			/*p=0;
			for(i=0;i<runtill.length();i++)
			{
				if((runtill.charAt(i)>='0' && runtill.charAt(i)<='9' || runtill.charAt(i)==':' ))
					p++;	
			}
			if (p>0 && p==runtill.length())
			{
				lblVDT.setVisible(false);	
			}
			else 
			{
				f=4;
				lblVDT.setVisible(true);
			}*/

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
				case 7:
					cboBusNo.requestFocus();
				break;
				case 8:
					cboRootNo.requestFocus();
				break;
				case 9:
					txtspeed.requestFocus();
				break;
				case 10:
					cboEmployeeNo.requestFocus();
				break;
			}
			return f;

	}
	/**Used to clear the fields of the form*/
	public void clear()
	{
		txtFare.setText("");
			cboRootNo.setSelectedIndex(0);
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
}