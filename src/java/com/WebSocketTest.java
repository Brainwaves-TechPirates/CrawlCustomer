/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import javax.websocket.OnClose;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.ServerEndpoint;

/**
 *
 * @author Roopa
 */

@ServerEndpoint("/websocket")
public class WebSocketTest {
    Date date = new Date();
File file = new File("C:\\ClickStreamData.txt");
String newLine = System.getProperty("line.separator");
    String content = "In Home page" ;
	@OnMessage
    public void onMessage(String message, Session session) 
    	throws IOException, InterruptedException {
           
            content =  message + newLine;
            
               FileWriter fw = new FileWriter(file.getAbsoluteFile(), true);

      BufferedWriter bw = new BufferedWriter(fw);
	    bw.write(content);
            bw.close();
          
		
    }
	
    @OnOpen
    public void onOpen () throws IOException {
        if(!file.exists()){
          file.createNewFile();
        }
        System.out.println("Client connected");
    }

    @OnClose
    public void onClose () {
    	System.out.println("Connection closed");
    }
}

