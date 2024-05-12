package control;

import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.util.List;

import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

import view.NotepadView;

public class NotepadController implements ActionListener{
	private NotepadView npv;
	public NotepadController(NotepadView npv) {
		this.npv = npv;
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		String src = e.getActionCommand();
		JFileChooser fc = new JFileChooser();
		if(src.equals("Open")) {
			int returnVal = fc.showOpenDialog(this.npv);

	        if (returnVal == JFileChooser.APPROVE_OPTION) {
	            File file = fc.getSelectedFile();
	            String filename = file.getName();
	            this.npv.np.setFile(file.getAbsolutePath().toString());
	            this.npv.lblNewLabel.setText(this.npv.np.getFile());
	            if(filename.endsWith(".txt")) {
	            	try {
						List<String> allText = Files.readAllLines(file.toPath(), StandardCharsets.UTF_8);
						String result = "";
						for(String line : allText) {
							result +=line;
							result += "\n";
						}
						this.npv.np.setContent(result);
						this.npv.textArea.setText(this.npv.np.getContent());
					} catch (Exception e2) {
						// TODO: handle exception
					}
	            }else {
	            	  JFrame f=new JFrame();  
	            	  JOptionPane.showMessageDialog(f,"file error.","Alert",JOptionPane.WARNING_MESSAGE); 
	            	}
	        	}
			}
	        else if (src.equals("Save")){
	        	if(this.npv.np.getFile().length() > 0) {
	        		save(this.npv.np.getFile());
						JFrame f=new JFrame();  
						JOptionPane.showMessageDialog(f,"successfully save.","message",JOptionPane.WARNING_MESSAGE);
	        	}
	        	else {
	        		int returnVal = fc.showSaveDialog(this.npv);

	    	        if (returnVal == JFileChooser.APPROVE_OPTION) {
	    	            File file = fc.getSelectedFile();
	    	            save(file.getAbsolutePath());
	    	            JFrame f=new JFrame();  
	    	            JOptionPane.showMessageDialog(f,"luu thanh cong.","message",JOptionPane.WARNING_MESSAGE);
	    	        }
	        	}
	        }
	}
	public void save(String filename) {
		try {
			PrintWriter pw = new PrintWriter(filename, StandardCharsets.UTF_8);
			String data = this.npv.textArea.getText();
			pw.print(data);
			pw.flush();
			pw.close();
		} catch (HeadlessException e1) {
			e1.printStackTrace();
		} catch (IOException e1) {
			e1.printStackTrace();
		}
	}
}



