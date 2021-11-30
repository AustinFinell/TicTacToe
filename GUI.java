package tictactoe;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;

public class GUI implements ActionListener{

	JFrame frame;
	
	JPanel titlePanel;
	JPanel turnPanel;
	JPanel buttonPanel;
	
	JButton[] buttons;
	JButton again;
	
	JLabel titleLabel;
	JLabel turnLabel;
	
	TicTacToe tct = new TicTacToe();
	
	GUI(){
		frame = new JFrame();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLayout(new BorderLayout());
		frame.setSize(400, 400);
		frame.setTitle("Tic-Tac-Toe");
		frame.setVisible(true);
		
		buttonPanel = new JPanel();
		buttonPanel.setLayout(new GridLayout(3, 3));
		
		buttons = new JButton[9];
		
		again = new JButton();
		again.addActionListener(this);
		again.setFont(new Font("Bell MT", Font.PLAIN, 20));
		again.setText("Play Again?");
		
		for (int i = 0; i < 9; i++) {
			buttons[i] = new JButton();
			buttonPanel.add(buttons[i]);
			buttons[i].addActionListener(this);
			buttons[i].setBackground(Color.white);
			buttons[i].setFont(new Font("Arial Black", Font.PLAIN, 30));
		}
		
		titleLabel = new JLabel("Tic-Tac-Toe");
		titleLabel.setFont(new Font("Bell MT", Font.BOLD, 40));
		titleLabel.setForeground(new Color(255, 255, 255));
		
		turnLabel = new JLabel("Turn: " + tct.getTurn());
		turnLabel.setFont(new Font("Bell MT", Font.BOLD, 40));
		turnLabel.setForeground(new Color(255, 255, 255));
		
		titlePanel = new JPanel();
		titlePanel.setBackground(new Color(0,25,100));
		titlePanel.add(titleLabel);
		
		turnPanel = new JPanel();
		turnPanel.setBackground(new Color(0,25,100));
		turnPanel.add(turnLabel);
		
		frame.add(titlePanel, BorderLayout.NORTH);
		frame.add(buttonPanel, BorderLayout.CENTER);
		frame.add(turnPanel, BorderLayout.SOUTH);
	}

	public void actionPerformed(ActionEvent e) {
		int[] won;
		for(int i = 0; i < 9; i++) {
			if (e.getSource() == buttons[i]) {
				if (buttons[i].getText().equals("")) {
					buttons[i].setText(tct.getTurn());
					tct.move(i);
					turnLabel.setText("Turn: " + tct.getTurn());
					if (tct.checkWin().equals("X") || tct.checkWin().equals("O")){
						tct.changeTurn();
						won = tct.getWonCells();
						wins(won[0], won[1], won[2], tct.getTurn());
					}
					if (tct.checkWin().equals("Draw")) {
						for(int j = 0; j < 9; j++) {
							buttons[j].setEnabled(false);
							buttons[j].setBackground(new Color(100, 100, 100));
						}
						titleLabel.setText("Cat's Game");
						turnPanel.remove(turnLabel);
						turnPanel.add(again);
					}
				}
				
			}
		
		}
		
		if(e.getSource() == again) {
			for (int i = 0; i < 9; i++) {
				buttons[i].setText("");
				buttons[i].setEnabled(true);
				buttons[i].setBackground(Color.white);
				tct.clearMoveArr();
				tct.clearMoveCount();
				tct.changeTurn();
				titleLabel.setText("Tic-Tac-Toe");
				turnPanel.remove(again);
				turnPanel.add(turnLabel);
				turnLabel.setText("Turn: " + tct.getTurn());
			}
			
		}
		
	}
	
	public void wins(int a, int b, int c, String turn) {
		buttons[a].setBackground(Color.GREEN);
		buttons[b].setBackground(Color.GREEN);
		buttons[c].setBackground(Color.GREEN);
		
		for(int i = 0; i < 9; i++) {
			buttons[i].setEnabled(false);
		}
		titleLabel.setText(turn + " Wins!");
		turnPanel.remove(turnLabel);
		turnPanel.add(again);
	}
	

	
	
	
}
