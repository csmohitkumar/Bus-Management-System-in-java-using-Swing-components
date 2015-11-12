/*User name=mohit      password=mohit*/
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
public class Login extends JFrame implements ActionListener
{
	private JLabel lblPassword,lblUName, lblRem,lblVUN,lblVP;
	private JTextField txtUName;
	private JPasswordField txtPassword;
	private JCheckBox chkBox;
	private ImageIcon icon,Iconbtn;
	private JButton btnSignin, btnCancel;
	private Color color1;
	private boolean check=false;
	public static void main(String args[])
    {
        new Login();
    }
    public Login()
    {
        this.setTitle("Login");
        setBounds(400, 200, 450, 220);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
		
		setLayout(null);
		
		lblUName = new JLabel("User name");
		add(lblUName);
		lblUName.setBounds(20,10,70,30);
		lblPassword = new JLabel("Password");
		add(lblPassword);
		lblPassword.setBounds(20,60,70,30);

		
		txtUName = new JTextField();
		add(txtUName);
		txtUName.setBounds(120,10,150,30);
		
		txtPassword=new JPasswordField();
		add(txtPassword);
		txtPassword.setBounds(120,60,150,30);
		
		icon=new ImageIcon("wrong.jpeg");
		lblVUN=new JLabel("Invalid user name ",icon,JLabel.CENTER); 
		add(lblVUN);
		lblVUN.setBounds(240,10,200,30);
		lblVUN.setVisible(false);

		lblVP=new JLabel("Invalid Password",icon,JLabel.CENTER);
		add(lblVP);
		lblVP.setBounds(240,60,200,30);
		lblVP.setVisible(false);
		
		Iconbtn=new ImageIcon("Login.png");
		btnSignin = new JButton("Signin",Iconbtn);
		add(btnSignin);
		btnSignin.addActionListener(this);
		btnSignin.setBounds(70,140,100,40);
		
		btnCancel = new JButton("Cancel",new ImageIcon("close1.png"));
		add(btnCancel);
		btnCancel.addActionListener(this);
		btnCancel.setBounds(200,140,100,40);  
		this.setResizable(false);
    }
	public void actionPerformed(ActionEvent e)
	{	
		if(e.getSource()==btnSignin)
		{
			
		   String uname=txtUName.getText();
			char[] pass=txtPassword.getPassword();
			//String pass=(String)pw;
			  System.out.println(pass);
			  System.out.println("user==="+uname);
			int f=0;
			if( uname.length()!=0)
				lblVUN.setVisible(false);
			else
			{
				f=1;
				lblVUN.setVisible(true);
			}
			
			if(pass.length>0 && pass.length<=12 && pass.length>=5 )
				lblVP.setVisible(false);
			else
			{
				f=2;
				lblVP.setVisible(true);
			}

				switch(f)
				{
					case 1:
						txtUName.requestFocus();
					break;
					case 2:
						txtPassword.requestFocus();
					break;
					default:
						check=true;
					break;
				}
				if(check==true)
				{
					if(pass[0]=='m' && pass[1]=='o' && pass[2]=='h'&& pass[3]=='i' && pass[4]=='t' && uname.equals("mohit"))
					{
					
						new Default();
						this.dispose();
					}
					else
					{
						JOptionPane.showMessageDialog(null, "User name or password is missmatch! Please try again");
					}
				}
			

		}
		if(e.getSource()==btnCancel)
		{
			dispose();
		}
	 }
}