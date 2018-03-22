import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.*;
import java.io.*;
public class SimpleCalc
{
	JFrame window;
	Container content ;
	JButton[] digits = new JButton[12]; 
	JButton[] ops = new JButton[4];
	JTextField expression;
	JButton equals;
	JTextField result;
	public SimpleCalc()
	{
		window = new JFrame( "Simple Calc");
		content = window.getContentPane();
		content.setLayout(new GridLayout(2,1));
		ButtonListener listener = new ButtonListener();
		JPanel topPanel = new JPanel();
		topPanel.setLayout(new GridLayout(1,3));
		expression = new JTextField();
		expression.setFont(new Font("verdana", Font.BOLD, 16));
		expression.setText("");
		equals = new JButton("=");
		equals.setFont(new Font("verdana", Font.BOLD, 20 ));
		equals.addActionListener( listener ); 
		result = new JTextField();
		result.setFont(new Font("verdana", Font.BOLD, 16));
		result.setText("");
		topPanel.add(expression);
		topPanel.add(equals);
		topPanel.add(result);
		JPanel bottomPanel = new JPanel();
		bottomPanel.setLayout(new GridLayout(1,2));
		JPanel  digitsPanel = new JPanel();
		digitsPanel.setLayout(new GridLayout(4,3));	
		for (int i=0 ; i<10 ; i++ )
		{
			digits[i] = new JButton( ""+i );
			digitsPanel.add( digits[i] );
			digits[i].addActionListener( listener ); 
		}
		digits[10] = new JButton( "C" );
		digitsPanel.add( digits[10] );
		digits[10].addActionListener( listener ); 
		digits[11] = new JButton( "CE" );
		digitsPanel.add( digits[11] );
		digits[11].addActionListener( listener ); 		
		JPanel opsPanel = new JPanel();
		opsPanel.setLayout(new GridLayout(4,1));
		String[] opCodes = { "+", "-", "*", "/" };
		for (int i=0 ; i<4 ; i++ )
		{
			ops[i] = new JButton( opCodes[i] );
			opsPanel.add( ops[i] );
			ops[i].addActionListener( listener ); 
		}
		bottomPanel.add( digitsPanel );
		bottomPanel.add( opsPanel );
		content.add( topPanel );
		content.add( bottomPanel );
		window.setSize( 640,480);
		window.setVisible( true );
	}
	class ButtonListener implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{
			Component whichButton = (Component) e.getSource();
			String[] opCodes = { "+", "-", "*", "/" };
			for(int i =0;i<4;i++)
				if(whichButton == ops[i])
					expression.setText(expression.getText() + opCodes[i]);
			for (int i=0 ; i<10 ; i++ ) 
				if (whichButton == digits[i])
					expression.setText( expression.getText() + i );
			if(whichButton == digits[10])
				expression.setText("");
			if(whichButton == digits[11]) {
				if(expression.getText().length() > 0) {
						expression.setText(expression.getText().substring(0,expression.getText().length()-1));
				}
			}
			if(whichButton == equals){
				String expr = expression.getText();
				ArrayList<String> operatorList = new ArrayList<String>();
				ArrayList<Double> operandList = new ArrayList<Double>();
				StringTokenizer st = new StringTokenizer( expr,"+-*/", true );
				while (st.hasMoreTokens()) {
					String token = st.nextToken();
					if ("+-/*".contains(token))
						operatorList.add(token);
					else
						operandList.add( Double.parseDouble( token) );
				}
				if(operatorList.size() >= operandList.size()){
					expression.setText("EXP INVALID");
				} else{
					result.setText(""+eval(operatorList, operandList));
				}
			}
		}
	}
	public Double eval(ArrayList<String> operatorList, ArrayList<Double> operandList) {
		Double result = 0.0;
		while(operandList.size()>1){
			for(int i = 0; i<operatorList.size(); i++){
				if(operatorList.contains("*") || operatorList.contains("/")){
					if(operatorList.indexOf("*") == i) {
						operandList.set(i, operandList.get(i) * operandList.get(i+1));
						operandList.remove(i+1);
						operatorList.remove(i);
					}
					if(operatorList.indexOf("/") == i) {
						operandList.set(i, operandList.get(i) / operandList.get(i+1));
						operandList.remove(i+1);
						operatorList.remove(i);
					}
				}
			}
			for(int i = 0; i<operatorList.size(); i++){
				if(operatorList.contains("+")||operatorList.contains("-")){
					if(operatorList.indexOf("+") == i) {
						operandList.set(i, operandList.get(i) + operandList.get(i+1));
						operandList.remove(i+1);
						operatorList.remove(i);
					}
					if(operatorList.indexOf("-") == i) {
						operandList.set(i, operandList.get(i) - operandList.get(i+1));
						operandList.remove(i+1);
						operatorList.remove(i);
					}
				}
			}
		}
		return operandList.get(0);
	}
	public static void main(String [] args)
	{
		new SimpleCalc();
	}
}

