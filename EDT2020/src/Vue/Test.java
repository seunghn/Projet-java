package Vue;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.GridLayout;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;
import java.awt.Color;
import java.awt.GridBagLayout;
import javax.swing.JTable;
import java.awt.GridBagConstraints;
import javax.swing.table.DefaultTableModel;

import Controle.coursaff;
import Controle.edt;

import java.awt.Insets;
import javax.swing.BoxLayout;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JTextField;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import javax.swing.JPanel;

public class Test {

	public edt emp;
	public ArrayList<String> aff ;
	public JFrame frame;
	public JTable table;
	public JTextField value;
	private JTextField mail;
	private JTextField mdp;
	private JTextField welcome;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Test window = new Test();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Test() {
		initialize();
		emp=new edt();
		//lol=new ArrayList();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	public void remp()
	{
		//a acces a l array list de coursaffa
		// le but c est de remplir aff non pas du tt
		int col=0;
		int lig=0;
		for(int i=0;i<emp.ccaff.size();i++)
		{
			System.out.println(emp.ccaff.get(i).hd);
			//set col
			if(emp.ccaff.get(i).date.equals("lundi"))
			{
				col=0;
			}
			if(emp.ccaff.get(i).date.equals("mardi"))
			{
				col=1;
			}
			if(emp.ccaff.get(i).date.equals("jeudi"))
			{
				col=3;
			}
			if(emp.ccaff.get(i).date.contentEquals("mercredi"))
			{
				col=2;
			}
			if(emp.ccaff.get(i).date.equals("vendredi"))
			{
				col=4;
			}
			//set lig
			if(emp.ccaff.get(i).hd.equals("8"))
			{
				lig=1;
			}
			if(emp.ccaff.get(i).hd.equals("10"))
			{
				lig=4;
			}
			if(emp.ccaff.get(i).hd.equals("13"))
			{
				lig=8;
			}
			if(emp.ccaff.get(i).hd.contentEquals("15"))
			{
				lig=11;
			}
			
			//c est la qu on rigole
			table.setValueAt(emp.ccaff.get(i).cours, lig, col);
			table.setValueAt(emp.ccaff.get(i).profs, lig+1, col);
			table.setValueAt(emp.ccaff.get(i).salles, lig+2, col);
		}
	
		
		
		
		
	}
	public void reset()

	{
		for(int i=0;i<5;i++)
		{
			for(int j=1;j<7;j++)
			{
				table.setValueAt("",j,i);
			}
			for(int j=8;j<14;j++)
			{
				table.setValueAt("",j,i);
			}
		}
	}
		
		private void initialize() {
	
		frame = new JFrame();
		frame.getContentPane().setBackground(Color.WHITE);
		frame.getContentPane().setLayout(null);
		
		table = new JTable();
		table.setBounds(0, 116, 784, 445);
		table.setToolTipText("");
		table.setRowHeight(30);
		table.setModel(new DefaultTableModel(
			new Object[][] {
				{"Lundi", "Mardi", "Mercredi", "Jeudi", "Vendredi"},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{"pause", "pause","pause","pause","pause"},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
			},
			new String[] {
				"Lundi", "Mardi", "Mercredi", "Jeudi", "Vendredi"
			}
		) {
			Class[] columnTypes = new Class[] {
				String.class, String.class, String.class, String.class, String.class
			};
			public Class getColumnClass(int columnIndex) {
				return columnTypes[columnIndex];
			}
		});
		frame.getContentPane().add(table);
		
		JButton btnNewButton = new JButton("Connexion");
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				emp.identification(mail.getText()+","+mdp.getText());
				
			}
		});
		btnNewButton.setBounds(0, 68, 89, 23);
		frame.getContentPane().add(btnNewButton);
		
		JComboBox param = new JComboBox();
		param.setModel(new DefaultComboBoxModel(new String[] {"enseignant", "groupe", "salle"}));
		param.setMaximumRowCount(3);
		param.setBounds(100, 0, 131, 23);
		frame.getContentPane().add(param);
		
		value = new JTextField();
		value.setText("cal\r\n");
		value.setBounds(421, 0, 152, 23);
		frame.getContentPane().add(value);
		value.setColumns(10);
		
		
		JComboBox semaine = new JComboBox();
		semaine.setModel(new DefaultComboBoxModel(new String[] {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31", "32", "33", "34", "35", "36", "37", "38", "39", "40", "41", "42", "43", "44", "45", "46", "47", "48", "49", "50", "51", "52", "53"}));
		semaine.setMaximumRowCount(53);
		semaine.setToolTipText("Semaine");
		semaine.setBounds(312, 0, 71, 22);
		frame.getContentPane().add(semaine);
		
		mail = new JTextField();
		mail.setBounds(3, 1, 86, 20);
		frame.getContentPane().add(mail);
		mail.setColumns(10);
		
		mdp = new JTextField();
		mdp.setText("");
		mdp.setBounds(0, 37, 86, 20);
		frame.getContentPane().add(mdp);
		mdp.setColumns(10);
		
		welcome = new JTextField();
		welcome.setText("bienvenue");
		welcome.setBounds(100, 37, 86, 20);
		frame.getContentPane().add(welcome);
		welcome.setColumns(10);
		frame.setBounds(100, 100, 800, 600);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		

		JButton btnNewButton_1 = new JButton("Chercher");
		btnNewButton_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				reset();
				if(emp.getuser()!=null)
				{
					int s;
					try {
						s = Integer.parseInt((String)semaine.getSelectedItem());
					} catch (NumberFormatException c) {s=0;
					}
					
					welcome.setText(welcome.getText()+emp.getuser().getnom());
					
					
					emp.get(s,"id_"+(String)param.getSelectedItem(),emp.shearch((String)param.getSelectedItem(),"nom", value.getText()));
					System.out.println(s);
					System.out.println("id_"+(String)param.getSelectedItem());
					System.out.println(value.getText());
					if(emp.ccaff.isEmpty())
					{
						table.setValueAt("pouet", 3, 2);
					}else {remp();}
					
					
				}
				
				
			}
		});
		btnNewButton_1.setBounds(583, 0, 89, 23);
		frame.getContentPane().add(btnNewButton_1);
	}
}
