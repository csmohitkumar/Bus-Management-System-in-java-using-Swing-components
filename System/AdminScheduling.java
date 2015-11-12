package Schedule;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
/**Through this class administrator can update,search and delete the records of Scheduling and cancel the operation. */
public class AdminScheduling implements ActionListener
{
	private JFrame frame;
	private JButton btnDelete,btnCancel,btnClear,btnUpdate,btnSearch;
	private JLabel lblHeading,lblSId,lblBusNo,lblBreg,lblRNo,lblRDetail,lblTo,lblDriverId,lblTravelDate,lblTravelTime,lblVBN,lblVBRN,lblVRN,lblVRD,lblVDI,lblVTD,lblVTT,lblVSId;
	private JTextField txtBusNo,txtBreg,txtRDetails,txtto,txtTravelDate,txtTravelTime;
	private JComboBox cboRNo,cboDriverId,cboBusNo,cboSID;
	private JPanel top,center,bottom;
	private ImageIcon icon;
	private String bus=null,rn=null,id=null,regno=null,to=null,from=null,tdate=null,ttime=null,a,busid=null,si=null;
	private int b,d,l,validate=0,day1=0,month1=0,year1=0,sid,intbn,intregno=0;
	private Color color1,color2,color3;
	private Font font;
		/**used to initilise the fields of the form*/
	public AdminScheduling()
	{
		frame=new JFrame("Scheduling");
		top=new JPanel();
		center=new JPanel();
		bottom=new JPanel();

		lblHeading=new JLabel("Scheduling");
		lblSId=new JLabel("Schedulind Id: ");
		lblBusNo=new JLabel("Bus No. :");
		lblBreg=new JLabel("Bus Resistration No. :");
		lblRNo=new JLabel("Root No. :");
		lblRDetail=new JLabel("Root Details: ");
		lblTo=new JLabel("To : ");
		lblDriverId=new JLabel("Driver Id :");
		lblTravelDate=new JLabel("Travel Date :");
		lblTravelTime=new JLabel("Travel Time:");

		txtTravelDate=new JTextField("DD/MM/YYYY");
		txtBreg=new JTextField();
		txtTravelTime=new JTextField("hh:mm:ss");
		txtRDetails=new JTextField();
		txtto=new JTextField();
		
		cboSID=new JComboBox();
		cboBusNo=new JComboBox();
		cboRNo=new JComboBox();
		cboDriverId=new JComboBox();

		icon=new ImageIcon("wrong.jpeg");
		lblVSId=new JLabel("incorrect format",icon,JLabel.CENTER);
		lblVBN=new JLabel("Select Bus no ",icon,JLabel.CENTER); 
		lblVBRN=new JLabel("Enter number only",icon,JLabel.CENTER); 
		lblVRN=new JLabel("Select Root",icon,JLabel.CENTER); 
		lblVRD=new JLabel("Enter text only ",icon,JLabel.CENTER); 
		lblVDI=new JLabel("Select Driver ID",icon,JLabel.CENTER); 
		lblVTD=new JLabel("incorrect format",icon,JLabel.CENTER); 
		lblVTT=new JLabel("incorrect format",icon,JLabel.CENTER);

		btnDelete=new JButton("Delete",new ImageIcon(ClassLoader.getSystemResource("add1.gif")));
		btnCancel=new JButton("Exit",new ImageIcon(ClassLoader.getSystemResource("delete.png")));
		btnClear=new JButton("Clear",new ImageIcon(ClassLoader.getSystemResource("clear.png")));
		btnUpdate=new JButton("Update",new ImageIcon(ClassLoader.getSystemResource("update.jpg")));
		btnSearch=new JButton("Search",new ImageIcon(ClassLoader.getSystemResource("Search.png")));

		color1=new Color(25,107,136);
		color2=new Color(191,233,247);
		color3=new Color(25,107,136);

		//frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setResizable(false);

	}
	/**set the component of the form*/
	public void launchFrame_Scheduling()
	{
		top.setLayout(new FlowLayout(FlowLayout.CENTER,0,15));
		top.setBackground(color1);
		top.add(lblHeading);
		lblHeading.setFont(new Font("Edwardian Script ITC", Font.BOLD, 35));
		lblHeading.setForeground(new Color(255,255,255));
		
		center.setLayout(null);
		center.setBackground(color2);
		combobox_value();

		///////////////////////////////////////////////////////////////////////////////////
		center.add(lblSId);
		lblSId.setBounds(100,5,120,20);

		center.add(cboSID);
		cboSID.setBorder(BorderFactory.createLineBorder(Color.green,1));
		cboSID.setBounds(240,5,150,20);
		center.add(lblVSId);
		lblVSId.setBounds(250,5,400,20);
		lblVSId.setVisible(false);

		//////////////////////////////////////////////////////////////////////////////////
		
		center.add(lblBusNo);
		lblBusNo.setBounds(100,40,140,20);

		center.add(cboBusNo);
		cboBusNo.setBorder(BorderFactory.createLineBorder(Color.green,1));
		cboBusNo.setBounds(240,40,150,20);
		cboBusNo.setEditable(false);
		cboBusNo.addActionListener(this);
		center.add(lblVBN);
		lblVBN.setBounds(250,5,400,20);
		lblVBN.setVisible(false);

		center.add(lblBreg);
		lblBreg.setBounds(100,80,140,20);

		center.add(txtBreg);
		txtBreg.setBorder(BorderFactory.createLineBorder(Color.green,1));
		txtBreg.setBounds(240,80,150,20);
		center.add(lblVBRN);
		lblVBRN.setBounds(260,80,400,20);
		lblVBRN.setVisible(false);

		center.add(lblRNo);
		lblRNo.setBounds(100,120,120,20);

		center.add(cboRNo);
		cboRNo.setBounds(240,120,150,20);
		cboRNo.setBorder(BorderFactory.createLineBorder(Color.green,1));
		cboRNo.setEditable(false);
		cboRNo.addActionListener(this);
		center.add(lblVRN);
		lblVRN.setBounds(340,120,200,20);
		lblVRN.setVisible(false);
		

		center.add(lblRDetail);
		lblRDetail.setBounds(100,160,120,20);

		center.add(txtRDetails);
		txtRDetails.setBorder(BorderFactory.createLineBorder(Color.green,1));
		txtRDetails.setBounds(240,160,75,20);
	
		center.add(lblTo);
		lblTo.setBounds(320,160,40,20);

		center.add(txtto);
		txtto.setBorder(BorderFactory.createLineBorder(Color.green,1));
		txtto.setBounds(335,160,75,20);
		center.add(lblVRD);
		lblVRD.setBounds(370,160,200,20);
		lblVRD.setVisible(false);

		center.add(lblDriverId);
		lblDriverId.setBounds(100,200,120,20);

		center.add(cboDriverId);
		cboDriverId.setBorder(BorderFactory.createLineBorder(Color.green,1));
		cboDriverId.setBounds(240,200,150,20);
		cboDriverId.setEditable(false);
		cboDriverId.addActionListener(this);
		center.add(lblVDI);
		lblVDI.setBounds(350,200,200,20);
		lblVDI.setVisible(false);

		center.add(lblTravelDate);
		lblTravelDate.setBounds(100,240,120,20);

		center.add(txtTravelDate);
		txtTravelDate.setBorder(BorderFactory.createLineBorder(Color.green,1));
		txtTravelDate.setBounds(240,240,150,20);
		center.add(lblVTD);
		lblVTD.setBounds(350,240,240,20);
		lblVTD.setVisible(false);
		
		
		center.add(lblTravelTime);
		lblTravelTime.setBounds(100,280,120,20);

		center.add(txtTravelTime);
		txtTravelTime.setBorder(BorderFactory.createLineBorder(Color.green,1));
		txtTravelTime.setBounds(240,280,150,20);
		center.add(lblVTT);
		lblVTT.setBounds(380,280,150,20);
		lblVTT.setVisible(false);
		
		
			
			cboDriverId.setEditable(false);
			txtBreg.setEditable(false);
			txtto.setEditable(false);
			txtRDetails.setEditable(false);
		
		
		bottom.setLayout(new FlowLayout(FlowLayout.LEFT,10,10));
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
		
		frame.setBounds(400,50,550,500);
		frame.setVisible(true);
	  }
	  /**implimeting the abstract method of ActionListener class*/
	  public void actionPerformed(ActionEvent e)
	  {	
				values();
				//l=Integer.parseInt(id);
				if(e.getSource()==cboBusNo || e.getSource()==cboRNo||e.getSource()==cboDriverId)
				 {
					search_Combo(b,d);
					//System.out.println(d);
				 }

		  if(e.getSource()==btnDelete)
		  {
			  delete(sid);
		  }
		  if(e.getSource()==btnClear)
		  {
				txtBreg.setText("");
				txtto.setText("");
				txtRDetails.setText("");
				txtTravelDate.setText("");
				txtTravelTime.setText("");
				cboDriverId.setSelectedIndex(0);
				cboBusNo.setSelectedIndex(0);
				cboRNo.setSelectedIndex(0);
				lblVBN.setVisible(false);
				lblVBRN.setVisible(false);
				lblVRN.setVisible(false);
				lblVRD.setVisible(false);
				lblVDI.setVisible(false);
				lblVTD.setVisible(false);
				lblVTT.setVisible(false);
		}
		if(e.getSource()==btnCancel)
		{
			frame. dispose();
		}
		if(e.getSource()==btnSearch)
		{
			search(sid);
		}
		if(e.getSource()==btnUpdate)
		{
			
			values();
			intregno=Integer.parseInt(regno);
			validate=validation();
			if(validate==0)
			  { 
				  update(sid);
			 }
		}
	}

	/**getting values from scheduling,Businformation,routemanagement tables and set it to their respective combo box*/
	public void combobox_value()
	{
		    try{
           Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
		   System.out.println("Divers loaded successfully");
		   String source = 
		   "jdbc:odbc:Driver={Microsoft Access Driver (*.mdb)};DBQ= e_transportation_system.mdb";
		   Connection connect = DriverManager.getConnection(source);
		   System.out.println("Connection established successfully");
           Statement state = connect.createStatement();
		   String sql6 = "SELECT scheduling_id FROM scheduling order by scheduling_id";
           ResultSet rst12 = state.executeQuery(sql6);
		  while (rst12.next()) 
		  {
				cboSID.addItem(rst12.getString(1));
				//txtBreg.setText(rst.getString(2));	
          }
           String sql = "SELECT busno FROM Businformation order by busno";
           ResultSet rst = state.executeQuery(sql);
		  while (rst.next()) 
		  {
				cboBusNo.addItem(rst.getString(1));
				//txtBreg.setText(rst.getString(2));	
          }
		   String sql2 = "SELECT root_no FROM routemanagement order by root_no";
           ResultSet st2 = state.executeQuery(sql2);
		  while (st2.next()) 
		  {
				cboRNo.addItem(st2.getString(1));
				//txtBreg.setText(rst.getString(2));	
          }

		   String sql3 = "SELECT employee_id FROM EmployeeDetails order by employee_id";
           ResultSet st3 = state.executeQuery(sql3);
		  while (st3.next()) 
		  {
				cboDriverId.addItem(st3.getString(1));
				//txtBreg.setText(rst.getString(2));	
          }

           state.close();
           connect.close();
		}
        catch (Exception e) {
           System.out.print(e);
        }
	}
	/**get the values from Businformation,routemanagement and set it to their respective fields*/	
	public boolean search_Combo(int id2,int routeid)
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
              String sql = "select * from Businformation where busno="+ id2 +"";
              ResultSet ro=state.executeQuery(sql);
		      if(ro.next())
              {
				   txtBreg.setText(ro.getString("regno"));

                    result=true;
              }
			  String sql2 = "select * from routemanagement where root_no="+ routeid +"";
              ResultSet src=state.executeQuery(sql2);
		      if(src.next())
              {
					txtRDetails.setText(src.getString("from1"));
					txtto.setText(src.getString("to1"));
                    result=true;
              }
		      ro.close();
			  src.close();
              state.close();
              connect.close();
		  }
          catch (Exception e) {
          System.out.print(e);
          }
		  return result;
          }
	/**Search the fields of the passenger with respect to id from the database*/

		 public boolean search(int scid)
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
				  String sql = "select * from scheduling where scheduling_id="+ scid +"";
				  ResultSet rs=state.executeQuery(sql);
				  if(rs.next())
				  {
					  //cboSId.setSelectedItem(rs.getString("scheduling_id"));
					  String strbus=rs.getString("bus_no");
					  cboBusNo.setSelectedItem(strbus);

						txtBreg.setText(rs.getString("reg_no"));

						String route=rs.getString("root_no");
						cboRNo.setSelectedItem(route);

						txtto.setText(rs.getString("root_to"));
						txtRDetails.setText(rs.getString("root_from"));

						String strdriver=rs.getString("driver_id");
						cboDriverId.setSelectedItem(strdriver);

						txtTravelDate.setText(rs.getString("travel_date"));
						txtTravelTime.setText(rs.getString("travel_time"));

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
		  public void update(int idp)
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
				String sql0 = "update scheduling set bus_no='"+ b+"' where scheduling_id="+idp+"";
				String sql1 = "update scheduling set reg_no='"+ intregno+"' where scheduling_id="+idp+"";
				String sql2 = "update scheduling set root_no="+ rn+" where scheduling_id="+idp+"";
				String sql4 = "update scheduling set root_from='"+ from+"' where scheduling_id="+idp+"";
				String sql5 = "update scheduling set root_to='"+ to+"' where scheduling_id="+idp+"";
				String sql8 = "update scheduling set driver_id='"+ id+"' where scheduling_id="+idp+"";
				String sql6 = "update scheduling set travel_date='"+ tdate+"' where scheduling_id="+idp+"";
				String sql7 = "update scheduling set travel_time='"+ ttime+"' where scheduling_id="+idp+"";
				state.execute(sql0);
				state.execute(sql1);
				state.execute(sql2);
				state.execute(sql6);
				state.execute(sql4);
				state.execute(sql5);
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
		 /**Delete record of the Scheduling from the table*/
		  public void delete(int ii)
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
				 String sql="delete from scheduling where scheduling_id="+ ii +"";
				 state.execute(sql);
				 cboSID.removeItem(ii);
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
		  /**Validating the values entered in the field*/
		  public int validation()
		  {
		  		int i;
				int f=0;
				int p=0;

				
				p=0;

				for(i=0;i<regno.length();i++)
				{
					if((regno.charAt(i)>='0' && regno.charAt(i)<='9'))
						p++;	
				}
				if (p>0 && p==regno.length())
				{
					lblVBRN.setVisible(false);	

				}
				else 
				{
					f=1;
					lblVBRN.setVisible(true);
				}


				
				int r=0,q=0,y=0;
				for (i=0;i<to.length();i++ )
				{
				if((to.charAt(i)>='a' && to.charAt(i)<='z') || (to.charAt(i)>='A' && to.charAt(i)<='Z')|| to.charAt(i)==' ')
					y++;
				}
				for (i=0;i<from.length();i++ )
				{
				if((from.charAt(i)>='a' && from.charAt(i)<='z') || (from.charAt(i)>='A' && from.charAt(i)<='Z')|| from.charAt(i)==' ')
					q++;
				}
				r=y+q;
				if( y>0 && q>0 && r==(to.length()+from.length()))
			 
					lblVRD.setVisible(false);
				else
				{
					f=2;
					lblVRD.setVisible(true);
				}
				

				int c=0;
				p=0;
				int j=0,s=0,first=0,last=0,sub;
				for(i=0;i<tdate.length();i++)
				{
					if((tdate.charAt(i)>='0' && tdate.charAt(i)<='9'))
					{
						p++;
					}
					if(tdate.charAt(i)=='/')
					{
						c++;
					}
				}
				s=c+p;
				first=tdate.indexOf('/');
				last=tdate.lastIndexOf('/');
				sub=last-first;
				

				if (p>0 && s==tdate.length() && c==2 && tdate.length()==10 && sub==3 )//&& sub==3 && day==2 && month==2 && year==4 )
				{
					lblVTD.setVisible(false);	
				}
				else 
				{
					f=3;
					lblVTD.setVisible(true);
				}



				String d=tdate.substring(0,2);
			String m=tdate.substring((first+1),(last));
			String y5=tdate.substring(last+1,last+5);
			int d1=0,m1=0,y1=0;
			try
			{
				d1=Integer.parseInt(d);
				m1=Integer.parseInt(m);
				y1=Integer.parseInt(y5);
			}
			catch (Exception as )
			{
				 JOptionPane.showMessageDialog(null, "date field contains only number and /");
			}
			if((d1>=1 && d1<=31) && (m1>=1 &&m1<=12) && (y1>=2000 && y1<=2013))
			{
				lblVTD.setVisible(false);	
			}
			else 
			{
				f=3;
				lblVTD.setVisible(true);
			}



				p=0;
				c=0;
				s=0;
				for(i=0;i<ttime.length();i++)
				{
					if((ttime.charAt(i)>='0' && ttime.charAt(i)<='9') )
					{
						p++;	
					}
					if(ttime.charAt(i)==':')
					{
						c++;
					}
				}
				s=p+c;
				if (p>0 && s==ttime.length() && c==2 && ttime.length()==8 )
				{
					lblVTT.setVisible(false);	
				}
				else 
				{
					f=4;
					lblVTT.setVisible(true);
				}
				//System.out.println(f);
				switch(f)
				{
					case 1:
						txtBreg.requestFocus();
					break;
					case 2:
						txtRDetails.requestFocus();
					break;
					case 3:
						txtTravelDate.requestFocus();
					break;
					case 4:
						txtTravelTime.requestFocus();
					break;
					
				}
		  return f;
	 }
	/**taking entered data from the form and save it to variable*/
	public void values()
	{
		 si=(String)cboSID.getSelectedItem();
		 sid=Integer.parseInt(si);
		  		bus=(String)cboBusNo.getSelectedItem();
				rn=(String)cboRNo.getSelectedItem();
				id=(String)cboDriverId.getSelectedItem();
				regno=txtBreg.getText();
				to=txtto.getText();
				from=txtRDetails.getText();
				tdate=txtTravelDate.getText();
				ttime=txtTravelTime.getText();
				b=Integer.parseInt(bus);
				d=Integer.parseInt(rn);
				//intregno=Integer.parseInt(regno);

	}
	

}
