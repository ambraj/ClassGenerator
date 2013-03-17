import java.awt.Button;
import java.awt.Checkbox;
import java.awt.CheckboxGroup;
import java.awt.Choice;
import java.awt.Color;
import java.awt.Frame;
import java.awt.Label;
import java.awt.TextField;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;


@SuppressWarnings("serial")
public class FieldFrame extends Frame
{
	
	CheckboxGroup chkGrp = null;
	TextField objField = null;
	Choice objChoice = null;
	Checkbox [] chkArr = null;
	
	public FieldFrame()
	{
		setLayout(null);
		setBounds(350, 300, 400, 300);
		setVisible(true);
		
		String [] lblNames = {"Field Name","Field Type"};
		Label [] lblArr = new Label[lblNames.length];
		
		for(int iTmp = 0, xPos = 30, yPos = 50; iTmp < lblNames.length; iTmp++, yPos += 50)
		{
			lblArr[iTmp] = new Label(lblNames[iTmp]);
			//lblArr[iTmp].setFont(Font.BOLD);
			lblArr[iTmp].setBounds(xPos, yPos, 70, 20);
			add(lblArr[iTmp]);
		}
		
		objField = new TextField();
		objField.setBounds(120, 50, 200, 25);
		add(objField);
		
		
		objChoice = new Choice(); 
		objChoice.setBounds(120,100 , 200, 20);
		String [] chName = {"short","int","long","float","double","char","byte","boolean"};
		for(int iTmp = 0 ; iTmp < chName.length ; iTmp++)
		{
			objChoice.add(chName[iTmp]);
		}
		add(objChoice);
		
		
		String [] chkNames = {"public","default","private","protected" };
		chkArr = new Checkbox[chkNames.length];
		chkGrp = new CheckboxGroup();
		for(int iTmp = 0, xPos = 50, yPos = 170; iTmp < chkNames.length; iTmp++, xPos += 80)
		{
			chkArr[iTmp] = new Checkbox(chkNames[iTmp]);
			chkArr[iTmp].setBounds(xPos, yPos, 70, 20);
			chkArr[iTmp].setCheckboxGroup(chkGrp);
			add(chkArr[iTmp]);
			
		}
		
		Button genBtn = new Button("Add");
		genBtn.setBounds(150, 220, 100, 40);
		genBtn.setBackground(Color.LIGHT_GRAY);
		add(genBtn);
		genBtn.addActionListener(new Handler());
		
		addWindowListener(new WindowAdapter()
		{
			@Override
			public void windowClosing(WindowEvent e)
			{

				/*String field = readData();
				MainFrame.fieldList.add(field);*/
		
				dispose();
			}
		});
	}
	@SuppressWarnings("resource")
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
