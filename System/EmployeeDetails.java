//package Employee;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
/**Through this class administrator/user can add the details of employee to the db and also implimention class ActionListener*/
public class EmployeeDetails implements ActionListener
{
	private JFrame f;
	private JButton btnAdd,btnDelete,btnClear;
	private JLabel lblHeading,lblID,lblName,lblPhNo,lblPAddress,lblDOB,lblSex,lblMStatus,lblJDate,lblIdentityMarks,lblCurrentDesignation,lblEType,lblIEmpID,lblIFN,lblIPA,lblIPN,lblIIM,lblIA,lblIDob,lblIS,lblIMS,lblIJDate,lblIEt;
	private JTextField txtID,txtName,txtPhNo,txtIdentityMarks,txtCurrentDesignation;
	private JComboBox cbogender,cbostatus, cboDobdate, cboDobmonth,cboDobyear,cboEType,cboJdate,cboJmonth,cboJyear;
	private JTextArea Address;
	private JPanel top,center,bottom;
	private Color color1,color2,color3;
	private ImageIcon icon;
	private String joindate=null,dobdate=null,id=null,fname=null,pa=null,ph=null,im=null,d=null,dobd=null,dobm=null,doby=null,sex=null,mstatus=null,jd=null,jm=null,jy=null,et=null;
	Object [] day={"Day","1","2","3","4","5","6","7","8","9","10","11","12","13","14","15","16","17","18","19","20","21","22","23","24","25","26","27","28","29","30","31"};
	Object [] month={"Month","January","February","March","April","May","June","July","August","September","October","October","December"};
	Object [] year={"Year","1970","1971","1972","1973","1974","1975","1976","1977","1978","1979","1980","1981","1982","1983","1984","1985","1986","1987","1988","1989","1990","1991","1992","1993","1994","1995"};
	Object [] type={"Type","Regular","Temporary"};
	Object [] gender={"Gender","Male","Female"};
	Object [] status={"Status","Married","Unmarried"};
	/**Used to initilise the components*/
	public EmployeeDetails()
	{
		f=new JFrame("Employee Details");
		top=new JPanel();
		center=new JPanel();
		bottom=new JPanel();
		lblHeading=new JLabel("Employee Details");
		lblID=new JLabel("Employee ID:");
		txtID=new JTextField();
		lblName=new JLabel("Full Name:");
		txtName=new JTextField();
		lblDOB=new JLabel("DOB:");
		lblSex=new JLabel("Sex:");
		lblMStatus=new JLabel("Marital Status:");
		lblPAddress=new JLabel("Present Address:");
		lblPhNo=new JLabel("Phone Number:");
		lblIdentityMarks=new JLabel("Identity Marks:");
		lblCurrentDesignation=new JLabel("Current Designation:");
		lblJDate=new JLabel("Joing date:");
		lblEType=new JLabel("Employee Type:");
		cboDobdate=new JComboBox(day);
		cboDobmonth=new JComboBox(month);
		cboDobyear=new JComboBox(year);
		/*radMale =new JRadioButton("Male");
		radFemale =new JRadioButton("Female");
		radMarried =new JRadioButton("Married");
		radUnmarried = new JRadioButton("Unmarried");*/
		Address=new JTextArea("",5,20);
		txtPhNo=new JTextField();
		txtIdentityMarks=new JTextField();	
		txtCurrentDesignation=new JTextField();
		cboEType=new JComboBox(type);
		cboJdate=new JComboBox(day);
		cboJmonth=new JComboBox(month);
		cboJyear=new JComboBox(year);
		cbogender=new JComboBox(gender);
		cbostatus=new JComboBox(status);
		
		icon=new ImageIcon("wrong.jpeg");
		lblIEmpID=new JLabel("Please enter 6 digits number ",icon,JLabel.CENTER); 
		lblIFN=new JLabel("Please enter only character",icon,JLabel.CENTER); 
		lblIPA=new JLabel("Field should not be Blank",icon,JLabel.CENTER); 
		lblIPN=new JLabel("Phone no. should be of 10 digit ",icon,JLabel.CENTER); 
		lblIIM=new JLabel("Please enter only character",icon,JLabel.CENTER); 
		lblIA=new JLabel("Field Should not be Blank",icon,JLabel.CENTER); 
		lblIDob=new JLabel("Please Select DOB",icon,JLabel.CENTER);
		lblIS=new JLabel("Please check one of the option",icon,JLabel.CENTER);
		lblIMS=new JLabel("Please check one of the option",icon,JLabel.CENTER);
		lblIJDate=new JLabel("Please Select date",icon,JLabel.CENTER);
		lblIEt=new JLabel("Please select one of the option",icon,JLabel.CENTER);

		btnAdd=new JButton("Add",new ImageIcon(ClassLoader.getSystemResource("add1.gif")));
		btnDelete=new JButton("Exit",new ImageIcon(ClassLoader.getSystemResource("delete.png")));
		btnClear=new JButton("Clear",new ImageIcon(ClassLoader.getSystemResource("clear.png")));
		
		color1=new Color(25,107,136);
		color2=new Color(191,233,247);
		color3=new Color(25,107,136);
		
		f.setResizable(false);
		//f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	}
	/**manage fields action and place and size*/
	public void launchFrame()
	{
		top.setLayout(new FlowLayout(FlowLayout.CENTER,0,15));
		top.setBackground(color1);
		top.add(lblHeading);
		lblHeading.setFont(new Font("Algerian", Font.BOLD, 30));
		lblHeading.setForeground(new Color(244,125,0));
		
		center.setLayout(null);
		center.setBackground(color2);
		
		center.add(lblID);
		lblID.setBounds(100,5,120,20);
		center.add(txtID);
		txtID.setBorder(BorderFactory.createLineBorder(Color.green,1));
		txtID.setBounds(240,5,150,20);
		center.add(lblIEmpID);
		lblIEmpID.setBounds(300,5,400,20);
		lblIEmpID.setVisible(false);

		center.add(lblName);
		lblName.setBounds(100,40,120,20);
		center.add(txtName);
		txtName.setBorder(BorderFactory.createLineBorder(Color.green,1));
		txtName.setBounds(240,40,150,20);
		center.add(lblIFN);
		lblIFN.setBounds(285,40,400,20);
		lblIFN.setVisible(false);

		center.add(lblDOB);
		lblDOB.setBounds(100,80,120,20);
		center.add(cboDobdate);
		cboDobdate.setBorder(BorderFactory.createLineBorder(Color.green,1));
		cboDobdate.setBounds(240,80,50,20);
		center.add(cboDobmonth);
		cboDobmonth.setBorder(BorderFactory.createLineBorder(Color.green,1));
		cboDobmonth.setBounds(300,80,80,20);
		center.add(cboDobyear);
		cboDobyear.setBorder(BorderFactory.createLineBorder(Color.green,1));
		cboDobyear.setBounds(400,80,80,20);
		center.add(lblIDob);
		lblIDob.setBounds(475,80,150,20);
		lblIDob.setVisible(false);
		
		center.add(lblSex);
		lblSex.setBounds(100,120,94,20);
		center.add(cbogender);
		cbogender.setBorder(BorderFactory.createLineBorder(Color.green,1));
		cbogender.setBounds(240,120,150,20);
		center.add(lblIS);
		lblIS.setBounds(430,120,200,20);
		lblIS.setVisible(false);
		
		center.add(lblMStatus);
		lblMStatus.setBounds(100,160,120,20);
		center.add(cbostatus);
		cbostatus.setBorder(BorderFactory.createLineBorder(Color.green,1));
		cbostatus.setBounds(240,160,150,20);
		center.add(lblIMS);
		lblIMS.setBounds(444,160,200,20);
		lblIMS.setVisible(false);
		
		center.add(lblPAddress);
		lblPAddress.setBounds(100,200,120,20);
		center.add(Address);
		Address.setBorder(BorderFactory.createLineBorder(Color.green,1));
		Address.setBounds(240,200,160,40);
		center.add(lblIPA);
		lblIPA.setBounds(400,200,200,40);
		lblIPA.setVisible(false);
		
		center.add(lblPhNo);
		lblPhNo.setBounds(100,260,120,20);
		center.add(txtPhNo);
		txtPhNo.setBorder(BorderFactory.createLineBorder(Color.green,1));
		txtPhNo.setBounds(240,260,150,20);
		center.add(lblIPN);
		lblIPN.setBounds(390,260,200,20);
		lblIPN.setVisible(false);

		center.add(lblIdentityMarks);
		lblIdentityMarks.setBounds(100,300,120,20);
		center.add(txtIdentityMarks);
		txtIdentityMarks.setBorder(BorderFactory.createLineBorder(Color.green,1));
		txtIdentityMarks.setBounds(240,300,150,20);
		center.add(lblIIM);
		lblIIM.setBounds(390,300,185,20);
		lblIIM.setVisible(false);

		center.add(lblCurrentDesignation);
		lblCurrentDesignation.setBounds(100,340,120,20);
		center.add(txtCurrentDesignation);
		txtCurrentDesignation.setBorder(BorderFactory.createLineBorder(Color.green,1));
		txtCurrentDesignation.setBounds(240,340,150,20);
		center.add(lblIA);
		lblIA.setBounds(390,340,180,20);
		lblIA.setVisible(false);

		center.add(lblJDate);
		lblJDate.setBounds(100,380,120,20);
		center.add(cboJdate);
		cboJdate.setBorder(BorderFactory.createLineBorder(Color.green,1));
		cboJdate.setBounds(240,380,50,20);
		center.add(cboJmonth);
		cboJmonth.setBorder(BorderFactory.createLineBorder(Color.green,1));
		cboJmonth.setBounds(300,380,80,20);
		center.add(cboJyear);
		cboJyear.setBorder(BorderFactory.createLineBorder(Color.green,1));
		cboJyear.setBounds(400,380,80,20);
		center.add(lblIJDate);
		lblIJDate.setBounds(450,380,200,20);
		lblIJDate.setVisible(false);
		
		
		center.add(lblEType);
		lblEType.setBounds(100,420,120,20);
		center.add(cboEType);
		cboEType.setBorder(BorderFactory.createLineBorder(Color.green,1));
		cboEType.setBounds(240,420,150,20);
		center.add(lblIEt);
		lblIEt.setBounds(410,420,200,20);
		lblIEt.setVisible(false);
		
		
		bottom.setLayout(new FlowLayout(FlowLayout.CENTER,20,20));
		bottom.setBackground(color3);
		
		bottom.add(btnAdd);
		btnAdd.addActionListener(this);
		bottom.add(btnDelete);
		btnDelete.addActionListener(this);
		bottom.add(btnClear);
		btnClear.addActionListener(this);
		
		f.setLayout(new BorderLayout(0,0));
		f.add(top, BorderLayout.NORTH);
		f.add(bottom, BorderLayout.SOUTH);
		f.add(center, BorderLayout.CENTER);
		
		f.setBounds(400,50,650,640);
		f.setVisible(true);

	  }
	  public static void main(String args[])
	{
			EmployeeDetails guiEmployee = new EmployeeDetails();
			guiEmployee.launchFrame();
	}
	/**impliments ActionListener method whith the help of which action perorm in database*/
	  public void actionPerformed(ActionEvent e)
	  {
		  if(e.getSource()==btnAdd)
		  {
			id=txtID.getText();
			fname=txtName.getText();
			pa=Address.getText();
			ph=txtPhNo.getText();
			im=txtIdentityMarks.getText();
			d=txtCurrentDesignation.getText();
			dobd=(String)cboDobdate.getSelectedItem();
			dobm=(String)cboDobmonth.getSelectedItem();
			doby=(String)cboDobyear.getSelectedItem();
			jd=(String)cboJdate.getSelectedItem();
			jm=(String)cboJmonth.getSelectedItem();
			jy=(String)cboJyear.getSelectedItem();
			et=(String)cboEType.getSelectedItem();
			joindate=jd+'-'+jm+'-'+jy;
			dobdate=dobd+'-'+dobm+'-'+doby;
			sex=(String)cbogender.getSelectedItem();
			mstatus=(String)cbostatus.getSelectedItem();

			int i,f=0;
			int p=0;
			for(i=0;i<id.length();i++)
			{
				if((id.charAt(i)>='0' && id.charAt(i)<='9') && id.length()==6)
					p++;	
			}
			if (p>0 && p==id.length())
			{
				lblIEmpID.setVisible(false);	

			}
			else 
			{
				f=1;
				lblIEmpID.setVisible(true);
			}
			
			p=0;
			
			for (i=0;i<fname.length();i++ )
			{
			if((fname.charAt(i)>='a' && fname.charAt(i)<='z') || (fname.charAt(i)>='A' && fname.charAt(i)<='Z')|| fname.charAt(i)==' ')
				p++;
			}
			if( p>0 && p==fname.length())
		 
				lblIFN.setVisible(false);
			else
			{
				f=2;
				lblIFN.setVisible(true);
			}


			p=0;
			if(pa.length()==0 || pa.charAt(0)==' ')
			{
				f=6;
				lblIPA.setVisible(true);
			}
			else
			{
				lblIPA.setVisible(false);
			}

			
			if(cboDobdate.getSelectedIndex()==0 || cboDobmonth.getSelectedIndex()==0|| cboDobyear.getSelectedIndex()==0)
			{
				f=3;
				lblIDob.setVisible(true);
			}
			else
			{
				lblIDob.setVisible(false);

			}
			
			if(cbogender.getSelectedIndex()==0)
			{
				f=4;
				lblIS.setVisible(true);
			}
			else
			{
				lblIS.setVisible(false);
			}

			if(cbostatus.getSelectedIndex()==0)
			{
				f=5;
				lblIMS.setVisible(true);
			}
			else
			{
				lblIMS.setVisible(false);
			}
			
			p=0;
			if(ph.length()==10)
			{
				for(i=0;i<ph.length();i++)
				{
					
					if((ph.charAt(i)>='0' && ph.charAt(i)<='9'))
						p++;	
					
				}
				if (p>0 && p==ph.length())
				{
					lblIPN.setVisible(false);	

				}
				else 
				{
					f=7;
					lblIPN.setVisible(true);
				}
			}
			else
			{
				f=7;
				lblIPN.setVisible(true);
			}
			
			
			p=0;
			
			for (i=0;i<im.length();i++ )
			{
			if((im.charAt(i)>='a' && im.charAt(i)<='z') || (im.charAt(i)>='A' && im.charAt(i)<='Z')|| im.charAt(i)==' ')
				p++;
			}
			if( p>0 && p==im.length())
		 
				lblIIM.setVisible(false);
			else
			{
				f=8;
				lblIIM.setVisible(true);
			}

			p=0;
			for (i=0;i<d.length();i++ )
			{
			if((d.charAt(i)>='a' && d.charAt(i)<='z') || (d.charAt(i)>='A' && d.charAt(i)<='Z')|| d.charAt(i)==' ')
				p++;
			}
			if( p>0 && p==d.length())
		 
				lblIA.setVisible(false);
			else
			{
				f=9;
				lblIA.setVisible(true);
			}

			if(cboJdate.getSelectedIndex()==0 || cboJmonth.getSelectedIndex()==0|| cboJyear.getSelectedIndex()==0)
			{
				f=10;
				lblIJDate.setVisible(true);
			}
			else
			{
				lblIJDate.setVisible(false);

			}

			if(cboEType.getSelectedIndex()==0)
			{
				f=11;
				lblIEt.setVisible(true);
			}
			else
			{
				lblIEt.setVisible(false);

			}
			switch(f)
			{
				case 1:
					txtID.requestFocus();
				break;
				case 2:
					txtName.requestFocus();
				break;
				case 6:
					Address.requestFocus();
				break;
				case 7:
					txtPhNo.requestFocus();
				break;
				case 8:
					txtIdentityMarks.requestFocus();
				break;
				case 9:
					txtCurrentDesignation.requestFocus();
				break;
				case 3:
					cboDobyear.requestFocus();
				break;
				case 4:
					cbogender.requestFocus();
				break;
				case 5:
					cbostatus.requestFocus();
				break;
				case 10:
					cboJmonth.requestFocus();
				break;
				case 11:
					cboEType.requestFocus();
				break;
				default:
					add();
			}
		}
		if(e.getSource()==btnClear)
		{
			txtID.setText("");
			txtName.setText("");
			txtPhNo.setText("");
			txtIdentityMarks.setText("");
			txtCurrentDesignation.setText("");
			Address.setText("");
			cboDobdate.setSelectedIndex(0);
			cboDobmonth.setSelectedIndex(0);
			cboDobyear.setSelectedIndex(0);
			cboEType.setSelectedIndex(0);
			cboJdate.setSelectedIndex(0);
			cboJmonth.setSelectedIndex(0);
			cboJyear.setSelectedIndex(0);
			cbogender.setSelectedIndex(0);
			cbostatus.setSelectedIndex(0);
			
			lblIEmpID.setVisible(false);
			lblIFN.setVisible(false);
			lblIDob.setVisible(false);
			lblIS.setVisible(false);
			lblIMS.setVisible(false);
			lblIPA.setVisible(false);
			lblIPN.setVisible(false);
			lblIIM.setVisible(false);
			lblIA.setVisible(false);
			lblIJDate.setVisible(false);
			
		}
		if(e.getSource()==btnDelete)
	    {
		    f. dispose();
	    }
	}
	/**Addd the details of employee to the db with the help of JdbcOdbcDriver*/
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
			String sql = "INSERT INTO EmployeeDetails " + "VALUES ('" + id + "','" + fname + "','" + dobdate + "','" + sex + "','" + mstatus + "','" + pa + "','" + ph + "','" + im + "','" + d  + "','" + joindate +"','" + et + "')";
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