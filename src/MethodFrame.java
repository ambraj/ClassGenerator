import java.awt.Frame;
import java.awt.TextField;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;


public class MethodFrame extends Frame
{
	TextField objField = null;
	
	public MethodFrame()
	{
		setLayout(null);
		//System.out.print("hello");
		setBounds(350, 300, 300, 300);
		setVisible(true);
	
		objField = new TextField();
		objField.setBounds(30, 50, 200, 25);
		add(objField);
		
		addWindowListener(new WindowAdapter()
		{
			@Override
			public void windowClosing(WindowEvent e)
			{
				dispose();
			}
		});
	}
	
}
