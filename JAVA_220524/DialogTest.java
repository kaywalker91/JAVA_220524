package study0524;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
 
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
 
public class DialogTest extends JFrame 
{
 
    public DialogTest() 
    {
 
        JButton btn1 = new JButton("�޽���");
        JButton btn2 = new JButton("Ȯ��");
        JButton btn3 = new JButton("�Է�");
        JPanel p = new JPanel();
 
        // ��ư�� �̺�Ʈ ó���� ���� �͸�Ŭ����
 
        ActionListener handler = new ActionListener() 
        {
 
            @Override
            public void actionPerformed(ActionEvent e) 
            {
                if (e.getActionCommand().equals("�޽���")) 
                {// �������� == �񱳰��ƴ� // .equals
                    JOptionPane.showMessageDialog(null, "ȭ�鿡 ����� �޼���", "����", JOptionPane.WARNING_MESSAGE);
                } 
                else if (e.getActionCommand().equals("Ȯ��")) 
                {
                    int result = JOptionPane.showConfirmDialog(null, "���α׷��� �����Ͻ� �ͽ��ϱ�?", "����",
                            JOptionPane.OK_CANCEL_OPTION);
 
                    System.out.printf("%d\n", result);
                    
                    if (result == 0) 
                    { //OK=0 , Cancel=2 ����
                        System.exit(0);
                    }
                } 
                else 
                {
                    // �⺻������ �ϳ� �Է¹������� ����Ѵ�. 2���̻󸸵��� �������� ���� �������� ��...
                    String id = JOptionPane.showInputDialog(null, "���� ������?", "������", JOptionPane.OK_CANCEL_OPTION);
                    System.out.println(id);
                }
            }
        };
 
        btn1.addActionListener(handler);
        btn2.addActionListener(handler);
        btn3.addActionListener(handler);
 
        p.add(btn1);
        p.add(btn2);
        p.add(btn3);
 
        add(p);
        // ũ�⸦ ���� ������Ʈ�� ũ���� ����
        pack(); // size�� �������� ���׵� �ȴ�~~~
 
        setLocation(100, 100);
        setVisible(true);
 
    }
    
 
        public static void main(String[] args) 
        {
            // TODO Auto-generated method stub
                new DialogTest();
        }
     
    }
 

