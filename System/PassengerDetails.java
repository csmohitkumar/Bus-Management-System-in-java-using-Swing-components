package Passenger;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
/**Through this class administrator/user can add details of passenger in the database*/
public class PassengerDetails implements ActionListener
{
	private JFrame f;
	private JButton btnAdd,btnClear,btnExit;
	private JLabel lblHeading,lblFName,lblLName,lblFaName,lblOccu,lblEmail,lblGender,lblDOB,lblAddress,lblCNo,lblBG,lblID,lblVFN,lblVLN,lblVFAN,lblVO,lblVBG,lblVEM,lblVG,lblVDob,lblVA,lblVCN,lblVPI;
	private JTextField txtFName,txtLName,txtUName,txtEmail,txtCNo,txtFaName,txtOccu,txtBG,txtID;
	private JComboBox cboDobdate, cboDobmonth,cboDobyear,cbogender;
	private JTextArea Address;
	private JPanel top,center,bottom;
	private Color color1,color2,color3;
	private Font font;
	private String fname=null,date=null,lname=null,father=null,occu=null,bg=null,em=null,address=null,cn=null,id=null,gender=null,dobd=null,dobm=null,doby=null;
	private ImageIcon icon;
	Object [] day={"Day","1","2","3","4","5","6","7","8","9","10","11","12","13","14","15","16","17","18","19","20","21","22","23","24","25","26","27","28","29","30","31"};
	Object [] month={"Month","January","February","March","April","May","June","July","August","September","October","October","December"};
	Object [] year={"Year","1970","1971","1972","1973","1974","1975","1976","1977","1978","1979","1980","1981","1982","1983","1984","1985","1986","1987","1988","1989","1990","1991","1992","1993","1994"};
	Object [] gender1={"Gender","Male","Female"};
/**used to initilise the fields of the form*/
	public PassengerDetails()
	{
		f=new JFrame("Passenger Detail");
		top=new JPanel();
		center=new JPanel();
		bottom=new JPanel();

		lblHeading=new JLabel("Passenger Detail");
		lblFName=new JLabel("First Name:");
		lblLName=new JLabel("Last Name:");
		lblFaName=new JLabel("Father Name:");
		lblOccu=new JLabel("Occupation:");
		lblBG=new JLabel("Blood Group: ");
		lblEmail=new JLabel("Email Address:");
		lblGender=new JLabel("Gender:");
		lblDOB=new JLabel("DOB:");
		lblAddress=new JLabel("Address:");
		lblCNo=new JLabel("Contact Number:");
		lblID=new JLabel("Passenger ID:");
		
		txtID=new JTextField();
		txtFName=new JTextField();
		txtLName=new JTextField();
		txtFaName=new JTextField();
		txtOccu=new JTextField();
		txtBG=new JTextField();
		txtCNo=new JTextField();
		txtEmail=new JTextField();
		
		cbogender=new JComboBox(gender1);
		cboDobdate=new JComboBox(day);
		cboDobmonth=new JComboBox(month);
		cboDobyear=new JComboBox(year);
		
		Address=new JTextArea("",5,20);

		icon=new ImageIcon("wrong.jpeg");
		lblVFN=new JLabel("Enter Text only",icon,JLabel.CENTER); 
		lblVLN=new JLabel("Enter Text only",icon,JLabel.CENTER); 
		lblVFAN=new JLabel("Enter Text only",icon,JLabel.CENTER); 
		lblVO=new JLabel("Enter Text only ",icon,JLabel.CENTER); 
		lblVBG=new JLabel("Field Should not be Blank",icon,JLabel.CENTER); 
		lblVEM=new JLabel("Field Should not be Blank",icon,JLabel.CENTER); 
		lblVG=new JLabel("Select one of the option",icon,JLabel.CENTER);
		lblVDob=new JLabel("Select Dob",icon,JLabel.CENTER);
		lblVA=new JLabel("Field Should not be Blank",icon,JLabel.CENTER);
		lblVCN=new JLabel("Enter 10 digit number",icon,JLabel.CENTER);
		lblVPI=new JLabel("Please Number only",icon,JLabel.CENTER);
		
		btnAdd=new JButton("Add",new ImageIcon(ClassLoader.getSystemResource("add1.gif")));
		btnClear=new JButton("Clear",new ImageIcon(ClassLoader.getSystemResource("delete.png")));
		btnExit=new JButton("Exit",new ImageIcon(ClassLoader.getSystemResource("clear.png")));
		
		color1=new Color(25,107,136);
		color2=new Color(191,233,247);
		color3=new Color(25,107,136);
		
		//f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setResizable(false);

	}
/**set and add the component of the form*/
	public void launchFrame_passenger()
	{
		top.setLayout(new FlowLayout(FlowLayout.CENTER,0,15));
		top.setBackground(color1);
		top.add(lblHeading);
		
		lblHeading.setFont(new Font("Edwardian Script ITC", Font.BOLD, 35));
		lblHeading.setForeground(new Color(255,255,255));
		
		center.setLayout(null);
		center.setBackground(color2);
		
		center.add(lblFName);
		lblFName.setBounds(100,5,120,20);
		center.add(txtFName);
		txtFName.setBorder(BorderFactory.createLineBorder(Color.green,1));
		txtFName.setBounds(240,5,150,20);
		center.add(lblVFN);
		lblVFN.setBounds(350,5,200,20);
		lblVFN.setVisible(false);
		
		center.add(lblLName);
		lblLName.setBounds(100,40,120,20);
		center.add(txtLName);
		txtLName.setBorder(BorderFactory.createLineBorder(Color.green,1));
		txtLName.setBounds(240,40,150,20);
		center.add(lblVLN);
		lblVLN.setBounds(350,40,200,20);
		lblVLN.setVisible(false);
		
		center.add(lblFaName);
		lblFaName.setBounds(100,80,120,20);
		center.add(txtFaName);
		txtFaName.setBounds(240,80,150,20);
		txtFaName.setBorder(BorderFactory.createLineBorder(Color.green,1));
		center.add(lblVFAN);
		lblVFAN.setBounds(350,80,200,20);
		lblVFAN.setVisible(false);
		
		center.add(lblOccu);
		lblOccu.setBounds(100,120,120,20);
		center.add(txtOccu);
		txtOccu.setBorder(BorderFactory.createLineBorder(Color.green,1));
		txtOccu.setBounds(240,120,150,20);
		center.add(lblVO);
		lblVO.setBounds(350,120,200,20);
		lblVO.setVisible(false);
		
		center.add(lblBG);
		lblBG.setBounds(100,160,120,20);
		center.add(txtBG);
		txtBG.setBorder(BorderFactory.createLineBorder(Color.green,1));
		txtBG.setBounds(240,160,150,20);
		center.add(lblVBG);
		lblVBG.setBounds(380,160,200,20);
		lblVBG.setVisible(false);
		
		center.add(lblEmail);
		lblEmail.setBounds(100,200,120,20);
		center.add(txtEmail);
		txtEmail.setBorder(BorderFactory.createLineBorder(Color.green,1));
		txtEmail.setBounds(240,200,150,20);
		center.add(lblVEM);
		lblVEM.setBounds(380,200,200,20);
		lblVEM.setVisible(false);
		
		center.add(lblGender);
		lblGender.setBounds(100,240,120,20);
		center.add(cbogender);
		cbogender.setBorder(BorderFactory.createLineBorder(Color.green,1));
		cbogender.setBounds(240,240,150,20);
		
		center.add(lblVG);
		lblVG.setBounds(400,240,200,20);
		lblVG.setVisible(false);
		
		center.add(lblDOB);
		lblDOB.setBounds(100,280,120,20);
		center.add(cboDobdate);
		cboDobdate.setBorder(BorderFactory.createLineBorder(Color.green,1));
		cboDobdate.setBounds(240,280,50,20);
		center.add(cboDobmonth);
		cboDobmonth.setBorder(BorderFactory.createLineBorder(Color.green,1));
		cboDobmonth.setBounds(300,280,80,20);
		center.add(cboDobyear);
		cboDobyear.setBorder(BorderFactory.createLineBorder(Color.green,1));
		cboDobyear.setBounds(400,280,80,20);
		center.add(lblVDob);
		lblVDob.setBounds(430,280,185,20);
		lblVDob.setVisible(false);

		center.add(lblAddress);
		lblAddress.setBounds(100,320,120,20);
		center.add(Address);
		Address.setBorder(BorderFactory.createLineBorder(Color.green,1));
		Address.setBounds(240,320,150,60);
		center.add(lblVA);
		lblVA.setBounds(400,320,180,60);
		lblVA.setVisible(false);

		center.add(lblCNo);
		lblCNo.setBounds(100,400,120,20);
		center.add(txtCNo);
		txtCNo.setBorder(BorderFactory.createLineBorder(Color.green,1));
		txtCNo.setBounds(240,400,150,20);
		center.add(lblVCN);
		lblVCN.setBounds(380,400,200,20);
		lblVCN.setVisible(false);
		
		center.add(lblID);
		lblID.setBounds(100,440,120,20);
		center.add(txtID);
		txtID.setBounds(240,440,150,20);
		txtID.setBorder(BorderFactory.createLineBorder(Color.green,1));
		center.add(lblVPI);
		lblVPI.setBounds(380,440,200,20);
		lblVPI.setVisible(false);
		
		bottom.setLayout(new FlowLayout(FlowLayout.CENTER,20,20));
		bottom.setBackground(color3);
		
		bottom.add(btnAdd);
		btnAdd.addActionListener(this);
		bottom.add(btnClear);
		btnClear.addActionListener(this);
		bottom.add(btnExit);
		btnExit.addActionListener(this);
		
		f.setLayout(new BorderLayout(0,0));
		f.add(top, BorderLayout.NORTH);
		f.add(bottom, BorderLayout.SOUTH);
		f.add(center, BorderLayout.CENTER);
		
		f.setBounds(400,50,600,660);
		f.setVisible(true);
	  }
	    /**implimeting the abstract method of ActionListener class*/
	  public void actionPerformed(ActionEvent e)
	 {
		  if(e.getSource()==btnAdd)
		  {
			fname=txtFName.getText();
			lname=txtLName.getText();
			father=txtFaName.getText();
			occu=txtOccu.getText();
			bg=txtBG.getText();
			em=txtEmail.getText();
			address=Address.getText();
			cn=txtCNo.getText();
			id=txtID.getText();
			dobd=(String)cboDobdate.getSelectedItem();
			dobm=(String)cboDobmonth.getSelectedItem();
			doby=(String)cboDobyear.getSelectedItem();
			date=dobd+"/"+dobm+"/"+doby;
			gender=(String)cbogender.getSelectedItem();
			int i=0,f;
			int p=0;
			f=0;

			for (i=0;i<fname.length();i++ )
			{
			if((fname.charAt(i)>='a' && fname.charAt(i)<='z') || (fname.charAt(i)>='A' && fname.charAt(i)<='Z'))
				p++;
			}
			if( p>0 && p==fname.length())
		 
				lblVFN.setVisible(false);
			else
			{
				f=1;
				lblVFN.setVisible(true);
			}

			p=0;
			for (i=0;i<lname.length();i++ )
			{
			if((lname.charAt(i)>='a' && lname.charAt(i)<='z') || (lname.charAt(i)>='A' && lname.charAt(i)<='Z'))
				p++;
			}
			if( p>0 && p==lname.length())
		 
				lblVLN.setVisible(false);
			else
			{
				f=2;
				lblVLN.setVisible(true);
			}

			p=0;
			
			for (i=0;i<father.length();i++ )
			{
			if((father.charAt(i)>='a' && father.charAt(i)<='z') || (father.charAt(i)>='A' && father.charAt(i)<='Z')|| father.charAt(i)==' ')
				p++;
			}
			if( p>0 && p==father.length())
		 
				lblVFAN.setVisible(false);
			else
			{
				f=3;
				lblVFAN.setVisible(true);
			}

			p=0;
			
			for (i=0;i<occu.length();i++ )
			{
			if((occu.charAt(i)>='a' && occu.charAt(i)<='z') || (occu.charAt(i)>='A' && occu.charAt(i)<='Z')|| occu.charAt(i)==' ')
				p++;
			}
			if( p>0 && p==occu.length())
		 
				lblVO.setVisible(false);
			else
			{
				f=4;
				lblVO.setVisible(true);
			}

			
			p=0;	
			for (i=0;i<bg.length();i++ )
			{
				if((bg.charAt(i)>='a' && bg.charAt(i)<='z') || (bg.charAt(i)>='A' && bg.charAt(i)<='Z' ) || bg.charAt(i)=='+' || bg.charAt(i)=='-')
					p++;
			}
			if( p>0 && p==bg.length())
			 
				lblVBG.setVisible(false);
			else
			{
				f=5;
				lblVBG.setVisible(true);
			}

			p=0;
			if(em.length()!=0)
				lblVEM.setVisible(false);
			else
			{
				f=6;
				lblVEM.setVisible(true);
			}
			
			
			if(cbogender.getSelectedIndex()==0 )
			{
				f=10;
				lblVG.setVisible(true);
			}
			else
			{
				lblVG.setVisible(false);
			}

			
			if(cboDobdate.getSelectedIndex()==0 || cboDobmonth.getSelectedIndex()==0|| cboDobyear.getSelectedIndex()==0)
			{
				lblVDob.setVisible(true);
			}
			else
			{
				lblVDob.setVisible(false);

			}
			p=0;
			if(address.length()>0)
		 
				lblVA.setVisible(false);
			else
			{
				f=7;
				lblVA.setVisible(true);
			}
			

			p=0;
			if(cn.length()==10)
			{
			for(i=0;i<cn.length();i++)
			{
				if((cn.charAt(i)>='0' && cn.charAt(i)<='9'))
					p++;		
			}
			if (p>0 && p==cn.length())
			{
				lblVCN.setVisible(false);	

			}
			else 
			{
				f=8;
				lblVCN.setVisible(true);
			}
			}
			else
			{
				f=8;
				lblVCN.setVisible(true);
			}

			p=0;
			for(i=0;i<id.length();i++)
			{
				if((id.charAt(i)>='0' && id.charAt(i)<='9') && id.length()==6)
					p++;	
			}
			if (p>0 && p==id.length())
			{
				lblVPI.setVisible(false);	

			}
			else 
			{
				f=9;
				lblVPI.setVisible(true);
			}
			switch(f)
			{
				case 1:
					txtFName.requestFocus();
				break;
				case 2:
					txtLName.requestFocus();
				break;
				case 3:
					txtFaName.requestFocus();
				break;
				case 4:
					txtOccu.requestFocus();
				break;
				case 5:
					txtBG.requestFocus();
				break;
				case 6:
					txtEmail.requestFocus();
				break;
				case 7:
					Address.requestFocus();
				break;
				case 8:
					txtCNo.requestFocus();
				break;
				case 9:
					txtID.requestFocus();
				break;
				case 10:
					cbogender.requestFocus();
				break;
				default:
					add();
				break;
			}
		  }
		if(e.getSource()==btnClear)
		{
			txtFName.setText("");
			txtLName.setText("");
			txtFaName.setText("");
			txtOccu.setText("");
			txtBG.setText("");
			txtEmail.setText("");
			Address.setText("");
			txtCNo.setText("");
			txtID.setText("");

			cboDobdate.setSelectedIndex(0);
			cboDobmonth.setSelectedIndex(0);
			cboDobyear.setSelectedIndex(0);
			cbogender.setSelectedIndex(0);

			lblVFN.setVisible(false);
			lblVLN.setVisible(false);
			lblVFAN.setVisible(false);
			lblVO.setVisible(false);
			lblVBG.setVisible(false);
			lblVEM.setVisible(false);
			lblVG.setVisible(false);
			lblVDob.setVisible(false);
			lblVA.setVisible(false);
			lblVCN.setVisible(false);
			lblVPI.setVisible(false);
		}
		if(e.getSource()==btnExit)
	    {
		    f.dispose();
	    }
	 }
	 /**Add the details of passenger in the db*/
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
			String sql = "INSERT INTO passenger_details " + "VALUES ('" + id + "','" + fname + "','" + lname + "','" + father + "','" + occu + "','" + bg +"','" + em + "','" + gender+"','" + date + "','" + address + "','" + cn + "')";
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
