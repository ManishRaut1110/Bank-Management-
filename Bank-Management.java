import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.*;
import java.io.*;
import java.nio.file.*;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;



class MyFrame extends JFrame implements ActionListener
{
	public static int findIndex(int arr[], int t)
    {
  
        if (arr == null) {
            return -1;
        }
  
        int len = arr.length;
        int i = 0;
  
        while (i < len) {
  
            if (arr[i] == t) {
                return i;
            }
            else {
                i = i + 1;
            }
        }
        return -1;
    }

	public static int deposite_money(int acc_no_index, int ammount_deposite)
	{
		int amt_input = list_amt.get(acc_no_index);
		int sample3_output = amt_input - ammount_deposite;
		return sample3_output;
	}

	int[] list_accno = {1,2,3,4,5,6,7,8,9,10,11,12,13,14};
	int[] list_accpin = {7234,2083,2485,2847,9045,3646,1644,2049,9284,1244,4032,7141,5323,2362};
	int[] list_amt = {12623,5887323,19859000,23743221,4327173,9999999,34276471,38377214,347381734,125312413,14636166,52625323,31746783,33847435};

	Container c;

	JTabbedPane tab_view;

	JPanel tab_1;
	JPanel tab_2;
	JPanel tab_3;
	JPanel tab_4;
	JPanel tab_5;

	JLabel title;
	JLabel tab1_accno;
	JLabel tab1_accpin;
	JLabel tab1_balance;
	JLabel error1_accno;
	JLabel error1_accpin;
	JLabel tab3_accno;
	JLabel tab3_accpin;
	JLabel tab3_output;
	JLabel error3_accno;
	JLabel error3_accpin;
	
	JTextField tab1_accno_input;
	JTextField tab1_accpin_input;
	JTextField tab3_accno_input;
	JTextField tab3_accpin_input;

	JButton tab_1_button;
	JButton tab_3_button;
	
	public MyFrame() throws IOException
	{

		setTitle("Bank Management");
		setBounds(150,30,1100,700);
		setDefaultCloseOperation(EXIT_ON_CLOSE);

		c = getContentPane();
		c.setLayout(null);

		title = new JLabel("Bank Account Management System");
		title.setFont(new Font("Ubuntu", Font.PLAIN, 30));
		title.setSize(600, 35);
		title.setLocation(330, 10);
		c.add(title);

		tab_view = new JTabbedPane();
		tab_view.setSize(1100, 640);
		tab_view.setLocation(0, 60);
		c.add(tab_view);

		tab_1 = new JPanel();
		tab_2 = new JPanel();
		tab_3 = new JPanel();
		tab_4 = new JPanel();
		tab_5 = new JPanel();

		tab_view.add("Check Balance", tab_1);
		tab_view.add("Create Account", tab_2);
		tab_view.add("Deposite", tab_3);
		tab_view.add("Withdraw", tab_4);
		tab_view.add("Delete Account", tab_5);

		tab_1.setLayout(null);
		tab_2.setLayout(null);
		tab_3.setLayout(null);
		tab_4.setLayout(null);
		tab_5.setLayout(null);

		tab1_accno = new JLabel("Enter Account Number: ");
		tab1_accno.setSize(180, 30);
		tab1_accno.setLocation(150, 10);
		tab_1.add(tab1_accno);

		tab1_accno_input = new JTextField();
		tab1_accno_input.setSize(180, 30);
		tab1_accno_input.setLocation(330, 10);
		tab_1.add(tab1_accno_input);

		error1_accno = new JLabel("*Account Number can only contain whole numbers(0-9)");
		error1_accno.setFont(new Font("Ubuntu", Font.PLAIN, 10));
		error1_accno.setSize(280, 20);
		error1_accno.setLocation(230, 40);
		error1_accno.setForeground(Color.RED);
		error1_accno.setVisible(false);
		tab_1.add(error1_accno);

		tab1_accpin = new JLabel("Enter your Pin: ");
		tab1_accpin.setSize(130, 30);
		tab1_accpin.setLocation(550, 10);
		tab_1.add(tab1_accpin);

		tab1_accpin_input = new JTextField();
		tab1_accpin_input.setSize(180, 30);
		tab1_accpin_input.setLocation(680, 10);
		// set Echo char
		tab_1.add(tab1_accpin_input);

		error1_accpin = new JLabel("*Account pin Invalid");
		error1_accpin.setFont(new Font("Ubuntu", Font.PLAIN, 10));
		error1_accpin.setSize(100,20);
		error1_accpin.setLocation(680, 40);
		error1_accpin.setForeground(Color.RED);
		error1_accpin.setVisible(false);
		tab_1.add(error1_accpin);

		tab_1_button = new JButton("Check");
		tab_1_button.setSize(100, 30);
		tab_1_button.setLocation(490, 80);
		tab_1_button.addActionListener(this);
		tab_1.add(tab_1_button);

		tab1_balance = new JLabel(" ");
		tab1_balance.setSize(800, 100);
		tab1_balance.setFont(new Font("Ubuntu", Font.PLAIN, 50));
		tab1_balance.setLocation(425,250);
		tab_1.add(tab1_balance);

		setVisible(true);
	}

	public void actionPerformed(ActionEvent e)
	{
		if (e.getSource() == tab_1_button) 
		{
			String tab1_input = tab1_accno_input.getText();
			int tab1_input_int = 0;
			tab1_input_int = Integer.parseInt(tab1_input);
			int check_index = findIndex(list_accno, tab1_input_int);
			String tab1_input2 = tab1_accpin_input.getText();
			int tab1_input2_int = Integer.parseInt(tab1_input2);


			if(tab1_input_int == 0 || tab1_input_int <= 14)
			{
				error1_accno.setVisible(false);
				if(tab1_input2_int == list_accpin[check_index])
				{
					error1_accpin.setVisible(false);
					tab1_balance.setText("₹" + list_amt[check_index]);
				}
				
				else{
					error1_accpin.setVisible(true);
					tab1_balance.setText("");
				}
			}

			else
			{
				error1_accno.setVisible(true);
			}
		}
	}
}

class Bank_management
{
	public static void main(String[] args) throws IOException
	{
		MyFrame f = new MyFrame();
	}
}
