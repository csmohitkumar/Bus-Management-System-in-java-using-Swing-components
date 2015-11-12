package Bus;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import java.util.Vector;
/**class AdminBusInfo used for user/administrator to change the data related to buses. This class inheriting the JFrame Class and also implements  the method of ActionListener class*/
public class BusInfo  implements ActionListener
{
	private JFrame f;
	private JLabel lblHeading,lblBusNo,lblModel, lblRegNo,lblSittingCapacity,lblPurchageDate,lblInsuranceStatus,lblCato,lblVBN,lblVM,lblVRN,lblVSC,lblVPD,lblVIS,lblVC;
	private JTextField txtBusNo,txtModel, txtRegNo,txtSittingCapacity,txtPurchageDate;
	private JButton btnAdd, btnCancel, btnClear;
	private JComboBox cmbInsuaranceStatus,cboCato;
	private ImageIcon icon;
	Vector v,c;
	private JPanel top,center,bottom;
	private Color color1,color2,color3;
	private String Busno=null, Model=null, RegNo=null,Sitting=null,date=null,ins=null,cato=null;
/**Constructor of class used to Initilize the values*/
    public BusInfo()
    {
		f=new JFrame("Bus Information");
		
		top=new JPanel();
		center=new JPanel();
		bottom=new JPanel();
		
		lblHeading=new JLabel("Bus Information");
        
		lblBusNo = new JLabel("Bus No. :");
		txtBusNo = new JTextField();
		
		lblModel = new JLabel("Model :");
		txtModel = new JTextField();
		
		lblRegNo = new JLabel("Reg. No. :");
		txtRegNo = new JTextField();
		
		lblSittingCapacity = new JLabel("Sitting capacity :");
		txtSittingCapacity = new JTextField();
		
		lblPurchageDate = new JLabel("Purchage Date :");
		txtPurchageDate = new JTextField("DD/MM/YYYY");
		
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
		lblVRN=new JLabel("Enter only Number",icon,JLabel.CENTER); 
		lblVSC=new JLabel("Enter number only ",icon,JLabel.CENTER); 
		lblVPD=new JLabel("DD-MM-YYYY",icon,JLabel.CENTER); 
		lblVIS=new JLabel("Should not be unselectedSelect ",icon,JLabel.CENTER); 
		lblVC=new JLabel("Should not be unselectedSelect ",icon,JLabel.CENTER);
		
		
		btnAdd = new JButton("Add",new ImageIcon(ClassLoader.getSystemResource("add1.gif")));
		btnCancel=new JButton("Cancel",new ImageIcon(ClassLoader.getSystemResource("delete.png")));
		btnClear=new JButton("Clear",new ImageIcon(ClassLoader.getSystemResource("clear.png")));
		
		color1=new Color(25,107,136);
		color2=new Color(191,233,247);
		color3=new Color(25,107,136);
		
		f.setResizable(false);
		//f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);	
	}
	/**set the position,size and add the components*/ 
	public void launchFrame_bus()
	{
		top.setLayout(new FlowLayout(FlowLayout.CENTER,0,15));
		top.setBackground(color1);
		top.add(lblHeading);
		
		lblHeading.setFont(new Font("Algerian", Font.BOLD, 30));
		lblHeading.setForeground(new Color(234,53,107));
		
		center.setLayout(null);
		center.setBackground(color2);
		
		center.add(lblBusNo);
		lblBusNo.setBounds(20,10,70,30);
		center.add(txtBusNo);
		txtBusNo.setBorder(BorderFactory.createLineBorder(Color.green,1));
		txtBusNo.setBounds(120,10,150,30);
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
		
		f.setBounds(400,50,500,525);
		f.setVisible(true);
	}
	/**implimenting the method of ActionListiner used to click event*/
	 public void actionPerformed(ActionEvent e)
	 {	
		    Busno=txtBusNo.getText();
			Model=txtModel.getText();
			RegNo=txtRegNo.getText();
			Sitting=txtSittingCapacity.getText();
			date=txtPurchageDate.getText();
			ins=(String)cmbInsuaranceStatus.getSelectedItem();
			cato=(String)cboCato.getSelectedItem();
			if(e.getSource()==btnAdd)
			{
				int i,f=0;
				int p=0;
				for(i=0;i<Busno.length();i++)
				{
					if((Busno.charAt(i)>='0' && Busno.charAt(i)<='9') && Busno.length()==4 )
						p=p+1;	
				}
				System.out.println(p);
				if (p>0 && p==Busno.length())
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
					if((RegNo.charAt(i)>='0' && RegNo.charAt(i)<='9') && RegNo.length()==6)
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
					if((Sitting.charAt(i)>='0' && Sitting.charAt(i)<='9'))
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
				////////////daaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa
				int c=0;
				p=0;
				int j=0,s=0,first=0,last=0,sub;
				
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
				s=c+p;
				first=date.indexOf('/');
				last=date.lastIndexOf('/');
				sub=last-first;
				if (p>0 && s==date.length() && c==2 && date.length()==10 && sub==3 )
			 
					lblVPD.setVisible(false);
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
						txtBusNo.setText("");
						txtBusNo.requestFocus();
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
					default:
						add();
						//System.out.println("Statement executed successfully")
						
				}
		}
		
		if(e.getSource()==btnClear)
		{
			txtPurchageDate.setText("");
			txtSittingCapacity.setText("");
			txtRegNo.setText("");
			txtModel.setText("");
			txtBusNo.setText("");
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
	  if(e.getSource()==btnCancel)
	  {
		    f. dispose();
	  }

	 }
	 /**Add details of bus to the database with the help of JdbcOdbcDriver*/
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
			String sql = "INSERT INTO Businformation " + "VALUES ('" + Busno + "','" + Model + "','" + RegNo + "','" + Sitting + "','" + date + "','" + ins +"','" +cato+ "')";
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
}