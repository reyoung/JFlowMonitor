/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package helloworld;

import java.awt.*;
import java.awt.event.WindowEvent;
import javax.swing.*;
import java.io.*;
/**
 *
 * @author Administrator
 */
public class FrameTest extends JFrame{
    JPanel contentPane;
    Label labelPrompt = new Label();
    TextField textFieldHost = new TextField();
    Button buttonLink = new Button();
    TextArea textAreaOutput = new TextArea();
    public FrameTest(){
    try{
        tframeInit();
    }
    catch(Exception e){
        e.printStackTrace();
    }
    }
    private void tframeInit()throws Exception{
        contentPane = (JPanel) this.getContentPane();
        contentPane.setLayout(null);
        System.out.println("Frame!");
        labelPrompt.setBounds(new Rectangle(25, 5, 180, 22));
	textFieldHost.setBounds(new Rectangle(78, 35, 280, 22));


	buttonLink.setLabel("123");
	buttonLink.setBounds(new Rectangle(375, 35, 70, 22));
//	buttonLink.addActionListener(new java.awt.event.ActionListener() {
//            public void actionPerformed(ActionEvent e) {
//	        buttonLink_actionPerformed(e);
//	      }
//	    });
	buttonLink.setEnabled(true);


        contentPane.add(labelPrompt, null);
	contentPane.add(textFieldHost, null);
	contentPane.add(buttonLink, null);
	contentPane.add(textAreaOutput, null);
	enableEvents(AWTEvent.WINDOW_EVENT_MASK);

	this.setSize(new Dimension(800, 600));
	this.setResizable(false);
	this.setTitle("FrameTest");
	this.setVisible(true);
    }
    protected void processWindowEvent(WindowEvent e) {
	super.processWindowEvent(e);
	if (e.getID() == WindowEvent.WINDOW_CLOSING) {
            System.exit(0);
	    }
	}
}
