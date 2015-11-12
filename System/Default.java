import Lists.BusList;
import Lists.EmployeeList;
import Lists.PassengerList;
import Lists.RouteList;
import Bus.AdminBusInfo;
import Bus.BusInfo;
import Employee.AdminEmployeeDetails;
import Employee.EmployeeDetails;
import Passenger.PassengerDetails;
import Passenger.AdminPassengerDetails;
import Route.RouteManagement;
import Route.AdminRouteManagement;
import Schedule.AdminScheduling;
import Schedule.Scheduling;
import Booking.Reservation;
import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
/**This class contains frame,menubar,menuItem through which administrator or user can easily work*/
public class Default implements ActionListener
{
  
	private JFrame f;
	private JMenuBar menubar;
	private JLabel lblImage;
	private JMenu newmenu,UpdateMenu,schedulingmenu,Reservationmenu,list;
	private JMenuItem NewBus,NewEmployee,NewPassenger,NeRoot,NewClose,UpdateBus,UpdateEmployee,UpdatePassenger,UpdateRoot,SchedulingNew ,SchedulingUpdate,ReservationNew,ReservationUpdate,Buslist,Employeelist,Passengerlist,Routelist;
	/**Initilise the components and create object*/
	public Default()
	{
		f = new JFrame("COSMOS TRAVELS PRIVATE LDT.");
		menubar = new JMenuBar();
		newmenu = new JMenu("New");
		UpdateMenu = new JMenu("Administator");
		schedulingmenu = new JMenu("Scheduling");
		Reservationmenu = new JMenu("Reservation");
		list=new JMenu("Lists");
		
		NewBus = new JMenuItem("Bus",new ImageIcon("Bus.jpg"));
		NewEmployee = new JMenuItem("Employ",new ImageIcon("employee.jpg"));
		NewPassenger = new JMenuItem("Passenger",new ImageIcon("passenger.jpg"));
		NeRoot = new JMenuItem("Route",new ImageIcon("route.JPG"));
		NewClose = new JMenuItem("Close",new ImageIcon("delete.png"));
		
		UpdateBus = new JMenuItem("Bus",new ImageIcon("Bus.jpg"));
		UpdateEmployee = new JMenuItem("Employee",new ImageIcon("employee.jpg"));
		UpdatePassenger = new JMenuItem("Passenger",new ImageIcon("passenger.jpg"));
		UpdateRoot = new JMenuItem("Route",new ImageIcon("route.JPG"));
		
		SchedulingNew = new JMenuItem("New",new ImageIcon("Scheduling.jpg"));
	    SchedulingUpdate=new JMenuItem("Update/Delete",new ImageIcon("Scheduling.jpg"));

		ReservationNew = new JMenuItem("New",new ImageIcon("reservation.jpg"));
	  //  ReservationUpdate = new JMenuItem("Update/Delete");
		
		Buslist= new JMenuItem("List of Buses",new ImageIcon("list.jpg"));
		Passengerlist= new JMenuItem("List of Passengers",new ImageIcon("list.jpg"));
		Employeelist= new JMenuItem("List of Employees",new ImageIcon("list.jpg"));
		Routelist=new JMenuItem("List of Routes",new ImageIcon("list.jpg"));
		
		lblImage=new JLabel("Select one of the option",new ImageIcon("volvo.jpg"),JLabel.LEFT);
		f.add(lblImage);
		lblImage.setBounds(0,0,400,500);
		  menubar.add(newmenu);
		  menubar.add(UpdateMenu);
		  menubar.add(schedulingmenu);
		  menubar.add(Reservationmenu);
		  menubar.add(list);
		
		  newmenu.add(NewBus);
		  NewBus.addActionListener(this);
		  newmenu.add(NewEmployee);
		  NewEmployee.addActionListener(this);
		  newmenu.add(NewPassenger);
		  NewPassenger.addActionListener(this);
		  newmenu.add(NeRoot);
		  NeRoot.addActionListener(this);
		  newmenu.add(NewClose);
		  NewClose.addActionListener(this);

		  UpdateMenu.add(UpdateBus);
		  UpdateBus.addActionListener(this);
		  UpdateMenu.add(UpdateEmployee);
		  UpdateEmployee.addActionListener(this);
		  UpdateMenu.add(UpdatePassenger);
		  UpdatePassenger.addActionListener(this);
		  UpdateMenu.add(UpdateRoot);
		  UpdateRoot.addActionListener(this);

		  schedulingmenu.add(SchedulingNew);
		  SchedulingNew.addActionListener(this);

		  schedulingmenu.add(SchedulingUpdate);
		  SchedulingUpdate.addActionListener(this);

		  Reservationmenu.add(ReservationNew);
		  ReservationNew.addActionListener(this);
		 // Reservationmenu.add(ReservationUpdate);
		 // ReservationUpdate.addActionListener(this);

		list.add(Buslist);
	    Buslist.addActionListener(this);
		list.add(Passengerlist);
	    Passengerlist.addActionListener(this);
		list.add(Employeelist);
		Employeelist.addActionListener(this);
		list.add(Routelist);
		Routelist.addActionListener(this);
	

		  f.setJMenuBar(menubar);

		  f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		  f.setSize(400,400);
		  f.setBounds(400,20, 700,600);
		  f.setVisible(true);
		  f.setResizable(false);
	 }
	/**implementing method of ActionListener class*/
	public void actionPerformed(ActionEvent e)
	{
		if (e.getSource() == NewBus)
		{
			
			BusInfo guibusinfo = new BusInfo();
			guibusinfo.launchFrame_bus();
		}
		if (e.getSource() == NewEmployee)
		{
			EmployeeDetails guiEmployee = new EmployeeDetails();
			guiEmployee.launchFrame();
		}
		if (e.getSource() == NewPassenger)
		{
			PassengerDetails guiEmployee = new PassengerDetails();
			guiEmployee.launchFrame_passenger();
		}

		if(e.getSource()==NeRoot)
		{
			RouteManagement route = new RouteManagement();
			route.launchFrame_Root();
		}
		if (e.getSource() == NewClose)
		{
			f. dispose();
		}

		if(e.getSource()==UpdateBus)
		{
			AdminBusInfo guibusinfo = new AdminBusInfo();
			guibusinfo.launchFrame_bus();
		}
		if(e.getSource()==UpdateEmployee)
		{
			AdminEmployeeDetails guiEmployee = new AdminEmployeeDetails();
			guiEmployee.launchFrame();
		}
		if(e.getSource()==UpdatePassenger)
		{
			AdminPassengerDetails  guiEmployee = new AdminPassengerDetails ();
			guiEmployee.launchFrame_passenger();
		}
		if(e.getSource()==UpdateRoot)
		{
			AdminRouteManagement route = new AdminRouteManagement();
			route.launchFrame_Route();
		}

		if(e.getSource()==SchedulingNew)
		{
			Scheduling guiScheduling = new Scheduling();
			guiScheduling.launchFrame_Scheduling();
		}
		if(e.getSource()==SchedulingUpdate)
		{
			AdminScheduling guiScheduling = new AdminScheduling();
			guiScheduling.launchFrame_Scheduling();
		}

		if(e.getSource()==ReservationNew)
		{
			Reservation guiReservation = new Reservation();
			guiReservation.launchFrame_Reservation();
		}

		/*if(e.getSource()==ReservationUpdate)
		{
			AdminReservation guiReservation = new AdminReservation();
			guiReservation.launchFrame_AdminReservation();
		}*/

		if(e.getSource()==Buslist)
		{
			BusList bl=new BusList();
			bl.DisplayArea();
		}
		if(e.getSource()==Employeelist)
		{
			EmployeeList el=new EmployeeList();
			el.DisplayEmployeeArea();
		}
		if(e.getSource()==Passengerlist)
		{
			PassengerList el=new PassengerList();
			el.DisplayPassengerArea();
		}
		
		if(e.getSource()==Routelist)
		{
			RouteList route=new RouteList();
			route.DisplayArea();
		}

	}
  
}