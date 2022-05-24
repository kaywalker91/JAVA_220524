package study0524;

import java.util.*;
import java.util.Scanner;

class Lotto
{
	private int[] num = new int[6];
	
	public int[] getNum()
	{
		return num;
	}
	
	public void start()
	{
		int cnt = 0;
		Random rd = new Random();
		int n;
		
		jump:
		while(cnt<6)
		{
			n = rd.nextInt(45)+1;
			
			for(int i=0; i<cnt; i++)
			{
				if(num[i] == n)
				{
					continue jump;
				}
			}
			
			num[cnt++] = n;
		}
		sorting();
	}
	
	void sorting()
	{
		Arrays.sort(num);
	}
}

public class Study152_Lotto extends Lotto
{
	public static void main(String[] args) 
	{
		Lotto lotto = new Lotto();
		
		for(int i = 1; i<=5; i++)
		{
			lotto.start();
			
			for(int n : lotto.getNum())
			{
				System.out.printf("%4d",n);
			}
			System.out.println("");
		}
	}
}

	


