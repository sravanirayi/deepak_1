package pkg;

import java.io.File;
import java.io.IOException;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import jxl.Cell;
import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;

public class CLass1
{

	@Test(dataProvider="data_2")
	public void abc(String user,String password,String a)
	{
		System.out.println(user);
		System.out.println(password);
		System.out.println(a);
	}
	
	@DataProvider
	public Object[][] data_1()
	{
		Object[][] ob=new Object[3][2];
		ob[0][0]="Deepak";
		ob[0][1]="Chanana";
		ob[1][0]="deep";
		ob[1][1]="dee";
		ob[2][0]="deepakk";
		ob[2][1]="d";
		
		return ob;
	}
	
	@DataProvider
	public Object[][] data_2() throws BiffException, IOException
	{
		File f=new File(".\\deepak.xls");
		Workbook wk=Workbook.getWorkbook(f);
		Sheet s=wk.getSheet(0);
		int r=s.getRows();
		int c=s.getColumns();
		Object[][] ob=new Object[r][c];
		
		for(int i=0;i<r;i++)
		{
			for(int j=0;j<c;j++)
			{
				Cell c1=s.getCell(j,i);
				ob[i][j]=c1.getContents();
			}
		}
		
		return ob;
		
		
	}
	
}
