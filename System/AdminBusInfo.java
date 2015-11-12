package Bus;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import java.util.Vector;

/** Overiding the class Bus method */
 public class AdminBusInfo extends Bus
 {
	 public void launchFrame_bus()
	 {
		 top.setLayout(new FlowLayout(FlowLayout.CENTER,0,15));
		top.setBackground(color1);
		top.add(lblHeading);
		
		lblHeading.setFont(new Font("Algerian", Font.BOLD, 30));
		lblHeading.setForeground(new Color(234,53,107));
		
		center.setLayout(null);
		center.setBackground(color2);

		combobox();
		
		center.add(lblBusNo);
		lblBusNo.setBounds(20,10,70,30);
		center.add(cboBusNo);
		cboBusNo.setBorder(BorderFactory.createLineBorder(Color.green,1));
		cboBusNo.setBounds(120,10,150,30);
		
		center.add(lblVBN);
		lblVBN.setBounds(260,10,200,30);
		lblVBN.setVisible(false);
		
		center.add(lblModel);
		lblModel.setBounds(20,60,70,30);
		center.add(txtModel);
		txtModel.setBorder(BorderFactory.createLineBorder(Color.green,1));
		txtModel.setBounds(120,60,150,30);
		center.add(lblVM);
		lblVM.setBounds(163,60,400,30);
		lblVM.setVisible(false);
		
		center.add(lblRegNo);
		lblRegNo.setBounds(20,110,70,30);
		center.add(txtRegNo);
		txtRegNo.setBorder(BorderFactory.createLineBorder(Color.green,1));
		txtRegNo.setBounds(120,110,150,30);
		center.add(lblVRN);
		lblVRN.setBounds(240,110,200,30);
		lblVRN.setVisible(false);
		
		center.add(lblSittingCapacity);
		lblSittingCapacity.setBounds(20,160,110,30);
		center.add(txtSittingCapacity);
		txtSittingCapacity.setBorder(BorderFactory.createLineBorder(Color.green,1));
		txtSittingCapacity.setBounds(120,160,150,30);
		center.add(lblVSC);
		lblVSC.setBounds(250,160,180,30);
		lblVSC.setVisible(false);
		
		center.add(lblPurchageDate);
		lblPurchageDate.setBounds(20,210,110,30);
		center.add(txtPurchageDate);
		txtPurchageDate.setBorder(BorderFactory.createLineBorder(Color.green,1));
		txtPurchageDate.setBounds(120,210,150,30);
		center.add(lblVPD);
		lblVPD.setBounds(235,210,200,30);
		lblVPD.setVisible(false);
		
		center.add(lblInsuranceStatus);
		lblInsuranceStatus.setBounds(20,260,110,30);
		center.add(cmbInsuaranceStatus);
		cmbInsuaranceStatus.setBorder(BorderFactory.createLineBorder(Color.green,1));
		cmbInsuaranceStatus.setBounds(120,260,150,30);
		center.add(lblVIS);
		lblVIS.setBounds(275,260,210,30);
		lblVIS.setVisible(false);
		
		center.add(lblCato);
		lblCato.setBounds(20,310,110,30);
		center.add(cboCato);
		cboCato.setBorder(BorderFactory.createLineBorder(Color.green,1));
		cboCato.setBounds(120,310,110,30);
		center.add(lblVC);
		lblVC.setBounds(275,310,210,30);
		lblVC.setVisible(false);
		
		bottom.setLayout(new FlowLayout(FlowLayout.LEFT,5,5));
		bottom.setBackground(color3);
	
		bottom.add(btnSearch);
		btnSearch.addActionListener(this);

		bottom.add(btnUpdate);
		btnUpdate.addActionListener(this);

		bottom.add(btnDelete);
		btnDelete.addActionListener(this);

		bottom.add(btnCancel);
		btnCancel.addActionListener(this);

		bottom.add(btnClear);
		btnClear.addActionListener(this);
		
		frame.setLayout(new BorderLayout(0,0));
		frame.add(top, BorderLayout.NORTH);
		frame.add(bottom, BorderLayout.SOUTH);
		frame.add(center, BorderLayout.CENTER);
		
		frame.setBounds(400,50,510,525);
		frame.setVisible(true);

	}
	
}
/**class AdminBusInfo used for administrator to change the data. This class inheriting the JFrame Class and also implements all the method of ActionListener class
*/
class Bus implements ActionListener
{
	public JFrame frame;
	public JLabel lblHeading,lblBusNo,lblModel, lblRegNo,lblSittingCapacity,lblPurchageDate,lblInsuranceStatus,lblCato,lblVBN,lblVM,lblVRN,lblVSC,lblVPD,lblVIS,lblVC;
	public JTextField txtModel, txtRegNo,txtSittingCapacity,txtPurchageDate;
	public JButton btnDelete, btnCancel, btnClear,btnUpdate,btnSearch;
	private String sModel=null,sdate=null,sins=null,scato=null;
	private int sBusno=0,sRegNo=0,sSitting=0,f=0,validate=0;
	public JComboBox cmbInsuaranceStatus,cboCato,cboBusNo;
	public ImageIcon icon;
	Vector v,c;
	public JPanel top,center,bottom;
	public Color color1,color2,color3;
	private String select;
	private String Busno,Model, RegNo,Sitting,date,ins,cato;
	private int id;
/**Constructor of class used to Initilize the values*/
    public Bus()
    {
		frame=new JFrame("Bus Information");
		
		top=new JPanel();
		center=new JPanel();
		bottom=new JPanel();
		
		lblHeading=new JLabel("Bus Information");
        
		lblBusNo = new JLabel("Bus No. :");
		cboBusNo = new JComboBox();
		
		lblModel = new JLabel("Model :");
		txtModel = new JTextField();
		
		lblRegNo = new JLabel("Reg. No. :");
		txtRegNo = new JTextField();
		
		lblSittingCapacity = new JLabel("Sitting capacity :");
		txtSittingCapacity = new JTextField();
		
		lblPurchageDate = new JLabel("Purchage Date :");
		txtPurchageDate = new JTextField();
		
		lblInsuranceStatus = new JLabel("InsuranceStatus :");
		v= new Vector();
		v.addElement("Status");
		v.addElement("Insured");
		v.addElement("Expired");
		cmbInsuaranceStatus=new JComboBox(v);
		
		lblCato=new JLabel("Category:");
		c=new Vector();
		c.addElement("Category");
		c.addElement("2*2 AC");
		c.addElement("3*2 AC");
		c.addElement("Sleeper AC");
		c.addElement("2*2 Non-AC");
		c.addElement("3*2 Non-AC");
		c.addElement("Sleeper Non-AC");
		c.addElement("Cabin");
		cboCato=new JComboBox(c);

		icon=new ImageIcon("wrong.jpeg");
		lblVBN=new JLabel("enter Number 0 to 10 only ",icon,JLabel.CENTER); 
		lblVM=new JLabel("Please enter only character",icon,JLabel.CENTER); 
		lblVRN=new JLabel("Enter only 6 digits Number",icon,JLabel.CENTER); 
		lblVSC=new JLabel("Enter 2 digits number only ",icon,JLabel.CENTER); 
		lblVPD=new JLabel("enter a valid date",icon,JLabel.CENTER); 
		lblVIS=new JLabel("Should not be unselectedSelect ",icon,JLabel.CENTER); 
		lblVC=new JLabel("Should not be unselectedSelect ",icon,JLabel.CENTER);
		
		
		btnDelete = new JButton("Delete",new ImageIcon(ClassLoader.getSystemResource("add1.gif")));
		btnCancel=new JButton("Cancel",new ImageIcon(ClassLoader.getSystemResource("delete.png")));
		btnClear=new JButton("Clear",new ImageIcon(ClassLoader.getSystemResource("clear.png")));
		btnUpdate=new JButton("Update",new ImageIcon(ClassLoader.getSystemResource("update.jpg")));
		btnSearch=new JButton("Search",new ImageIcon(ClassLoader.getSystemResource("Search.png")));
		
		color1=new Color(25,107,136);
		color2=new Color(191,233,247);
		color3=new Color(25,107,136);
		
		frame.setResizable(false);
		//frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);	
	}
	/**Overridden the method by AdminBusInfo class*/
	public void launchFrame_bus()
	{
		System.out.println("PT1181120");
		
	}
	
	/**implimenting the method of ActionListiner used to click event*/
	 public void actionPerformed(ActionEvent e)
	 {	
		getvalue();
		if(e.getSource()==btnDelete)
		{
				delete(id);	
		}
		if(e.getSource()==btnClear)
		{
			clear();
	  }
	  if(e.getSource()==btnCancel)
	  {
		    frame. dispose();
	  }
	  
	  //int id=0;
	  if(e.getSource()==btnSearch)
	  {
		  search(id);
	  }
	  if(e.getSource()==btnUpdate)
	  {
				sBusno=Integer.parseInt(((String)cboBusNo.getSelectedItem()));
				 sModel=txtModel.getText();
				 sRegNo=Integer.parseInt(txtRegNo.getText());
				 sSitting=Integer.parseInt(txtSittingCapacity.getText());
				 sdate=txtPurchageDate.getText();
				 sins=(String)cmbInsuaranceStatus.getSelectedItem();
				 scato=(String)cboCato.getSelectedItem();
				 validate=validation();
				if(validate==0)
				{

					update(id);
					clear();
				}
			 
		 }


	 }
	/**Method of AdminBusInfo class used to get value of bus number field in JCombobox from Businformation dataBase*/
    public void combobox()
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
           state.close();
           connect.close();
		}
        catch (Exception e) {
           System.out.print(e);
        }
	 }	
	 /** Method of class Businformation used to search the values of the field with respect to Bus id having boolean return type*/
	 public boolean search(int id)
	  {
		  boolean result=false;
		  try
		  { Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
		   System.out.println("Divers loaded successfully");
		   String source = 
		   "jdbc:odbc:Driver={Microsoft Access Driver (*.mdb)};DBQ= e_transportation_system.mdb";
		   Connection connect = DriverManager.getConnection(source);
              Statement state = connect.createStatement();
              String sql = "select * from Businformation where busno="+ Busno +"";
              ResultSet rs=state.executeQuery(sql);
		      if(rs.next())
              {
				  
                    cboBusNo.setSelectedItem(rs.getString("busno"));
                    txtModel.setText(rs.getString("model"));
					txtRegNo.setText(rs.getString("regno"));
					txtSittingCapacity.setText(rs.getString("sitting"));
                    txtPurchageDate.setText(rs.getString("qdate"));
					String strins=rs.getString("ins");
					cmbInsuaranceStatus.setSelectedItem(strins);
					String strCato=rs.getString("cato");
					cboCato.setSelectedItem(strCato);
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
		/**method of class Businformation used to delete the record with respect to entered id*/
		 public void delete(int i)
		  {
			  try
			  {
				 Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
		   System.out.println("Divers loaded successfully");
		   String source = 
		   "jdbc:odbc:Driver={Microsoft Access Driver (*.mdb)};DBQ= e_transportation_system.mdb";
		   Connection connect = DriverManager.getConnection(source);
				 Statement state = connect.createStatement();
				 String sql="delete from Businformation where busno="+ Busno +"";
				 state.execute(sql);
				 cboBusNo.removeItem(Busno);
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
		  /**Method of class Businformation used to update the fiels of the class */
		  public  void update(int id)
		  {
			  try
			  {
				  Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
				System.out.println("Divers loaded successfully");
				String source = 
				"jdbc:odbc:Driver={Microsoft Access Driver (*.mdb)};DBQ= e_transportation_system.mdb";
				Connection connect = DriverManager.getConnection(source);
				 Statement state = connect.createStatement();
				String sql0 = "update Businformation set model='"+ sModel+"' where busno="+sBusno+"";
				String sql1 = "update Businformation set regno="+ sRegNo+" where busno="+sBusno+"";
				String sql2 = "update Businformation set sitting="+ sSitting+" where busno="+sBusno+"";
				String sql3 = "update Businformation set qdate='"+sdate+"' where busno="+sBusno+"";
				String sql4 = "update Businformation set ins='"+ sins+"' where busno="+sBusno+"";
				String sql5 = "update Businformation set cato='"+ scato+"' where busno="+sBusno+"";
				state.execute(sql0);
				state.execute(sql1);
				state.execute(sql2);
				state.execute(sql3);
				state.execute(sql4);
				state.execute(sql5);				
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
		  /**Metod of class Businformation used to validate the fiels of the class and return a numric or integer value*/
		public int validation()
		  {
			  int i;
				int p=0;
				f=0;
				for(i=0;i<Busno.length();i++)
				{
					if((Busno.charAt(i)>='0' && Busno.charAt(i)<='9'))
						p=p+1;	
				}
				//System.out.println(p);
				if (p>0 && p==Busno.length() && Busno.length()==4)
				{
					lblVBN.setVisible(false);	

				}
				else 
				{
					f=1;
					lblVBN.setVisible(true);
				}
				
				p=0;
				
				for (i=0;i<Model.length();i++ )
				{
				if((Model.charAt(i)>='a' && Model.charAt(i)<='z') || (Model.charAt(i)>='A' && Model.charAt(i)<='Z')|| Model.charAt(i)==' ')
					p++;
				}
				if( p>0 && p==Model.length())
			 
					lblVM.setVisible(false);
				else
				{
					f=2;
					lblVM.setVisible(true);
				}

				p=0;
				for(i=0;i<RegNo.length();i++)
				{
					if((RegNo.charAt(i)>='0' && RegNo.charAt(i)<='9') && RegNo.length()==6 )
						p=p+1;	
				}
				if (p>0 && p==RegNo.length())
				{
					lblVRN.setVisible(false);	

				}
				else 
				{
					f=3;
					lblVRN.setVisible(true);
				}

				p=0;
					for(i=0;i<Sitting.length();i++)
				{
					if((Sitting.charAt(i)>='0' && Sitting.charAt(i)<='9' && Sitting.length()==2))
						p=p+1;	
				}
				if (p>0 && p==Sitting.length())
				{
					lblVSC.setVisible(false);	

				}
				else 
				{
					f=4;
					lblVSC.setVisible(true);
				}
				
				int c=0;
				p=0;
				int j=0,sum=0,first=0,last=0,sub;
				
				for(i=0;i<date.length();i++)
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
				
					lblVPD.setVisible(false);
				else
				{
					f=5;
					lblVPD.setVisible(true);
				}

				String d=date.substring(0,2);
				String m=date.substring((first+1),(last));
				String y=date.substring(last+1,last+5);
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
					lblVPD.setVisible(false);
				}
				else
				{
					f=5;
					lblVPD.setVisible(true);
				}

				if(cmbInsuaranceStatus.getSelectedIndex()==0)
				{
					f=6;
					lblVIS.setVisible(true);
				}
				else
				{
					lblVIS.setVisible(false);
				}

				if(cboCato.getSelectedIndex()==0)
				{
					f=7;
					lblVC.setVisible(true);
				}
				else
				{
					lblVC.setVisible(false);
				}

				switch(f)
				{
					case 1:
						
						cboBusNo.requestFocus();
					break;
					case 2:
						txtModel.setText("");
						txtModel.requestFocus();
					break;
					case 3:
						txtRegNo.setText("");
						txtRegNo.requestFocus();
					break;
					case 4:
						txtSittingCapacity.setText("");
						txtSittingCapacity.requestFocus();
					break;
					case 5:
						txtPurchageDate.setText("");
						txtPurchageDate.requestFocus();
					break;
					case 6:
						cmbInsuaranceStatus.requestFocus();
					break;
					case 7:
						cboCato.requestFocus();
					break;						
				}
				return f;
		  }
		  /**Method used to get values from the form and stroed it in the variables*/
		  public void getvalue()
		  {
			Busno=(String)cboBusNo.getSelectedItem();
			id=Integer.parseInt(Busno);
			Model=txtModel.getText();
			RegNo=txtRegNo.getText();
			Sitting=txtSittingCapacity.getText();
			date=txtPurchageDate.getText();
			ins=(String)cmbInsuaranceStatus.getSelectedItem();
			cato=(String)cboCato.getSelectedItem();
		  }
		  /**Method use to clear the of the form*/
		 public void clear()
		  {
			  txtPurchageDate.setText("");
			txtSittingCapacity.setText("");
			txtRegNo.setText("");
			txtModel.setText("");
			cboBusNo.setSelectedIndex(0);
			cmbInsuaranceStatus.setSelectedIndex(0);
			cboCato.setSelectedIndex(0);
			lblVBN.setVisible(false);
			lblVM.setVisible(false);
			lblVRN.setVisible(false);
			lblVSC.setVisible(false);
			lblVPD.setVisible(false);
			lblVIS.setVisible(false);
			lblVC.setVisible(false);

		  }
	}
	
