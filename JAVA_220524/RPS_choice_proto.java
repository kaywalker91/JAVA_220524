package study0524;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Choice;
import java.awt.Dialog;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Frame;
import java.awt.Label;
import java.awt.Panel;
import java.awt.TextArea;
import java.awt.TextField;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class RPS_choice_proto 
{
	public static void main(String[] args) 
	{
		Game g = new Game();

	}
}

class Game extends Frame implements ActionListener 
{
	//내전적 표시
	int winCnt=0, lossCnt=0, drawCnt=0, totCnt=0;
	int myChoice = 0; //0 가위 1바위 2보
	int pcChoice = 0; //컴퓨터

	private Dimension dimen, dimen1;
	private int xpos, ypos;
	
	Label lbTitle = new Label("가위바위보게임");	
	Label lbMy = new Label("내 선택");
	Label lbCom = new Label("컴퓨터 : ");
	Label lbComResult = new Label("대기중...");
	Label lbResult = new Label("최종결과 : ");
	Label lbFinalResult = new Label("대기중...");
		
	Button btnStart = new Button("게임시작");
	Button btnHistory = new Button("통계");
	
	Choice ch = new Choice();
	
	public Game() 
	{
		super("가위바위보게임");
		this.init();
		this.start();
		this.setSize(400, 450);	
		
		dimen = Toolkit.getDefaultToolkit().getScreenSize();
		dimen1 = this.getSize();
		xpos = (int) (dimen.getWidth() / 2 - dimen1.getWidth() / 2);
		ypos = (int) (dimen.getHeight() / 2 - dimen1.getHeight() / 2);
		this.setLocation(xpos, ypos);
		
		this.setVisible(true);
	}

	public void init() 
	{
		// 앱솔루트방식  : 직접 좌표 입력방식.
		this.setLayout(null);

		Font font20 = new Font("SansSerif", Font.BOLD, 20);
		Font font15 = new Font("SansSerif", Font.BOLD, 15);
		Font font10 = new Font("SansSerif", Font.BOLD, 10);
		
		//타이틀
		this.add(lbTitle);
		lbTitle.setBounds(100, 50, 300, 30);		
		lbTitle.setFont(font20);
		
		this.add(lbMy);
		lbMy.setBounds(70, 100, 70, 30);
		lbMy.setFont(font15);
		
		this.add(btnStart);
		btnStart.setBounds(220, 100, 150, 50);
		btnStart.setFont(font15);
		
		this.add(ch);
		ch.setBounds(70, 150, 100, 50);
		ch.setFont(font15);		
		ch.add("가위");
		ch.add("바위");
		ch.add("보");
		
		this.add(lbCom);
		lbCom.setBounds(70, 200, 100, 30);
		lbCom.setFont(font15);	
		
		this.add(lbComResult);
		lbComResult.setBounds(200, 200, 100, 30);
		lbComResult.setFont(font15);	
		
		this.add(lbResult);
		lbResult.setBounds(70, 250, 100, 30);
		lbResult.setFont(font15);	
		
		this.add(lbFinalResult);
		lbFinalResult.setBounds(200, 250, 100, 30);
		lbFinalResult.setFont(font15);
		
		this.add(btnHistory);
		btnHistory.setBounds(120, 330, 150, 40);
		btnHistory.setFont(font15);
		
	}

	public void start() 
	{
		
		btnStart.addActionListener(this); 
		btnHistory.addActionListener(this);
		
		this.addWindowListener(new WindowAdapter() 
		{
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});
	}

	@Override
	public void actionPerformed(ActionEvent e) {
			
		if(e.getSource() == btnStart) {
			
			ing();//3..2..1.. 표시하는 녀석...			
			
			myChoice = ch.getSelectedIndex();
			pcChoice = (int)(Math.random()*3);
			System.out.println("내선택값 : " + myChoice);
			System.out.println("컴퓨터선택값 : " + pcChoice);
			
			if(myChoice==0)//난 가위
			{
				if(pcChoice == 0) 
				{
					lbComResult.setText("가위");
					lbFinalResult.setText("무승부!!");
					totCnt++; drawCnt++;
				}
				else if(pcChoice  == 1) 
				{
					lbComResult.setText("바위");
					lbFinalResult.setText("패배!!");
					totCnt++; lossCnt++;
				}
				else if(pcChoice  == 2) 
				{
					lbComResult.setText("보");
					lbFinalResult.setText("승리!!");
					totCnt++; winCnt++;
				}
			}
			else if(myChoice==1)//난 바위
			{
				if(pcChoice == 0) 
				{
					lbComResult.setText("가위");
					lbFinalResult.setText("승리!!");
					totCnt++; winCnt++;
				}
				else if(pcChoice  == 1) 
				{
					lbComResult.setText("바위");
					lbFinalResult.setText("무승부!!");
					totCnt++; drawCnt++;
				}
				else if(pcChoice  == 2) 
				{
					lbComResult.setText("보");
					lbFinalResult.setText("패배!!");
					totCnt++; lossCnt++;
				}
			}
			else if(myChoice==2)//난 보
			{
				if(pcChoice == 0) 
				{
					lbComResult.setText("가위");
					lbFinalResult.setText("패배!!");
					totCnt++; lossCnt++;
				}
				else if(pcChoice  == 1) 
				{
					lbComResult.setText("바위");
					lbFinalResult.setText("승리!!");
					totCnt++; winCnt++;
				}
				else if(pcChoice  == 2) 
				{
					lbComResult.setText("보");
					lbFinalResult.setText("무승부!!");
					totCnt++; drawCnt++;
				}
			}		
		}
		
		else if(e.getSource() == btnHistory) 
		{		
			
			final Dialog dlg = new Dialog(this, "전적 통계", true);
			
			dlg.setLayout(null);	
			
			Font font15 = new Font("SansSerif", Font.BOLD, 15);
			Font font10 = new Font("SansSerif", Font.BOLD, 10);
			
			Label lbTitle = new Label("전적보기");
			Label lbTot = new Label("총전적 : ");
			Label lbTotResult = new Label(totCnt+"판");
			Label lbWin = new Label("내승리 : ");
			Label lbWinResult = new Label(winCnt+"승");
			Label lbLoss = new Label("내패배 : ");
			Label lbLossResult = new Label(lossCnt+"패");
			Label lbDraw = new Label("무승부 : ");
			Label lbDrawResult = new Label(drawCnt+"무");
			
			Button bt = new Button("확인");
			
			bt.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					dlg.setVisible(false);
				}
			});
			
			dlg.addWindowListener(new WindowAdapter() {
				public void windowClosing(WindowEvent e) {
					dlg.setVisible(false);
				}
			});
			
			dlg.add(lbTitle);
			lbTitle.setBounds(150, 50, 300, 30);		
			lbTitle.setFont(font15);
			
			dlg.add(lbTot);
			lbTot.setBounds(100, 100, 70, 30);		
			lbTot.setFont(font15);
			
			dlg.add(lbTotResult);
			lbTotResult.setBounds(200, 100, 70, 30);		
			lbTotResult.setFont(font15);
			
			dlg.add(lbWin);
			lbWin.setBounds(100, 150, 70, 30);		
			lbWin.setFont(font15);
			
			dlg.add(lbWinResult);
			lbWinResult.setBounds(200, 150, 70, 30);		
			lbWinResult.setFont(font15);
			
			dlg.add(lbLoss);
			lbLoss.setBounds(100, 200, 70, 30);		
			lbLoss.setFont(font15);
			
			dlg.add(lbLossResult);
			lbLossResult.setBounds(200, 200, 70, 30);		
			lbLossResult.setFont(font15);
			
			dlg.add(lbDraw);
			lbDraw.setBounds(100, 250, 70, 30);		
			lbDraw.setFont(font15);
			
			dlg.add(lbDrawResult);
			lbDrawResult.setBounds(200, 250, 70, 30);		
			lbDrawResult.setFont(font15);
			
			dlg.add(bt);
			bt.setBounds(150, 300, 100, 30);		
			bt.setFont(font15);
			
			dlg.setLocation(xpos, 400);
			dlg.setSize(400, 400);
			dlg.setVisible(true);	
		}
		
	}
	
	void ing()
	{
		try {
			Thread.sleep(500);
		} catch (InterruptedException e1) {			
		}
		
		lbComResult.setText("3...");
		try {
			Thread.sleep(500);
		} catch (InterruptedException e1) {			
		}
		
		lbComResult.setText("2...");
		try {
			Thread.sleep(500);
		} catch (InterruptedException e1) {			
		}
		
		lbComResult.setText("1...");
		
		try {
			Thread.sleep(500);
		} catch (InterruptedException e1) {			
		}
	}
}

