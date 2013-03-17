import java.awt.Button;
import java.awt.Checkbox;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;


public class Handler implements ActionListener
{

	@Override
	public void actionPerformed(ActionEvent e)
	{
		
		
		
		if(e.getActionCommand().equals("add fields"))
		{
			Button btn = (Button)e.getSource();
			MainFrame mainFrm = (MainFrame)btn.getParent();
			new FieldFrame();
		}
		else if(e.getActionCommand().equals("add methods"))
		{
			new MethodFrame();
		}
		else if(e.getActionCommand().equals("remove fields"))
		{
			
		}
		else if(e.getActionCommand().equals("remove methods"))
		{
			
		}
		else if(e.getActionCommand().equals("Add"))
		{
			MainFrame mainFrm = null;
			
			Button btnn = (Button)e.getSource();
			FieldFrame frm = (FieldFrame)btnn.getParent();
			
			//mainFrm.fieldList.add(frm.objField.getText());
			String field = frm.objField.getText();
			
			Checkbox chk = frm.chkGrp.getSelectedCheckbox();
			String access = chk.getLabel();
			
			String type = frm.objChoice.getSelectedItem();
			//writeData(access+" "+type+" "+field);
			
			mainFrm.fieldList.add(access + " " + type +" " + field);
			
			frm.dispose();

		}
		else if(e.getActionCommand().equals("Generate Class"))
		{

			Button btn = (Button)e.getSource();
			MainFrame mainFrm = (MainFrame)btn.getParent();
		
			Checkbox modifier = mainFrm.chkGrp.getSelectedCheckbox();
			
			String[] fields = mainFrm.fieldList.getSelectedItems();
			
			
			mainFrm.objTArea.setText(modifier.getLabel() + " class " + mainFrm.objTxt.getText());
			mainFrm.objTArea.appendText("\n{\n");
			
			for(String fldTmp : fields)
				mainFrm.objTArea.appendText("   "+fldTmp+";\n");			
			
			mainFrm.objTArea.appendText("\n}");
		}
		
		
	}
	
}
