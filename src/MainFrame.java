import java.awt.Button;
import java.awt.Checkbox;
import java.awt.CheckboxGroup;
import java.awt.Color;
import java.awt.Font;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.Label;
import java.awt.List;
import java.awt.TextArea;
import java.awt.TextField;
import java.awt.event.MouseListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;


public class MainFrame extends Frame
{
	TextField objTxt = null;
	Checkbox [] objChk = null;
	CheckboxGroup chkGrp = null;
	TextArea objTArea = null;
	static List fieldList = null;
	List mthdList = null;
	FieldFrame fldFrm = null;
	
	
	public MainFrame()
	{
		setLayout(null);
		setBounds(0, 0, 900, 800);
		setTitle("Class Generator");
		setVisible(true);
		
		String [] lblNames = {"Class Name","Fields","Preview","Methods","Modifiers"};
		Label [] lblArr = new Label[lblNames.length];
		
		for(int iTmp = 0, xPos = 40, yPos = 50; iTmp < lblNames.length; iTmp++, yPos += 150)
		{
			if(iTmp == 2)
			{
				yPos -= 150;
				xPos += 400;
			}
			if(iTmp == 3)
			{
				xPos -= 400;
				yPos += 100;
			}
			if(iTmp == 4)
			{
				//xPos -= 400;
				yPos -= 470;
			}
			lblArr[iTmp] = new Label(lblNames[iTmp]);
			//lblArr[iTmp].setFont(Font.BOLD);
			lblArr[iTmp].setBounds(xPos, yPos, 80, 20);
			add(lblArr[iTmp]);
		}
		
		objTxt = new TextField();
		objTxt.setBounds(150, 50, 400, 25);
		add(objTxt);
		
		String [] chkNames = {"public","default"};
		Checkbox [] chkArr = new Checkbox[chkNames.length];
		chkGrp = new CheckboxGroup();
		for(int iTmp = 0, xPos = 150, yPos = 130; iTmp < chkNames.length; iTmp++, xPos += 120)
		{
			chkArr[iTmp] = new Checkbox(chkNames[iTmp]);
			chkArr[iTmp].setBounds(xPos, yPos, 80, 20);
			chkArr[iTmp].setCheckboxGroup(chkGrp);
			add(chkArr[iTmp]);
			
			
		}
		
		fieldList = new List();
		fieldList.setBounds(30, 230, 250, 200);
		add(fieldList);
		fieldList.setMultipleMode(true);
		/*String field = readData();
		fieldList.add(field);*/
		
		//fieldList.add("hi");
		
		mthdList = new List();
		mthdList.setBounds(30, 500, 250, 200);
		add(mthdList);
		mthdList.setMultipleMode(true);
		
		objTArea = new TextArea();
		objTArea.setBounds(450, 230, 400, 400);
		add(objTArea);
		
		String [] btnNames = {"Add","Remove","Add","Remove"};
		Button [] objBtn = new Button[4];
		
		for(int iTmp = 0, xPos = 300, yPos = 270; iTmp < btnNames.length; iTmp++, yPos += 100)
		{
			if(iTmp == 2)
				yPos += 70;
			objBtn[iTmp] = new Button(btnNames[iTmp]);
			objBtn[iTmp].setBounds(xPos, yPos, 80, 30);			
			add(objBtn[iTmp]);			
			objBtn[iTmp].addActionListener(new Handler());
		}
		
		objBtn[0].setActionCommand("add fields");
		objBtn[1].setActionCommand("remove fields");
		objBtn[2].setActionCommand("add methods");
		objBtn[3].setActionCommand("remove methods");
		
		Button genBtn = new Button("Generate Class");
		genBtn.setBounds(560, 680, 200, 40);
		genBtn.setBackground(Color.LIGHT_GRAY);
		add(genBtn);
		genBtn.addActionListener(new Handler());
		
		addWindowListener(new WindowAdapter()
		{
			@Override
			public void windowClosing(WindowEvent e)
			{
				dispose();
			}
			/*@Override
			public void windowActivated(WindowEvent e)
			{

				String field = readData();
				fieldList.add(field);
				
			}*/
		});
		
	}
	
	public void paint(Graphics grp)
	{
		/*String field = readData();
		fieldList.add(field);*/
	}
	
	public static String readData()
	{
		FileInputStream fis = null;
		DataInputStream dis = null;
		try
		{			
			File objFile = new File("D:\\class generator\\field.txt");
			
			if(!objFile.exists())
			{
				System.out.print("No such file or dir");
				return null;
			}
			fis = new FileInputStream(objFile);
			dis = new DataInputStream(fis);  
			
			String data = dis.readUTF();
			System.out.print(data);
			return data;
			
		}
		catch (FileNotFoundException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

}






















