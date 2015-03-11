/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package motorcontrol;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import javax.swing.text.*;
import java.io.*;
import java.net.*;
public class Client
{
    Socket mySocket;
    DataInputStream dis;
    PrintStream ps;
/*
    public static void main(String[] args)
    {
        new Client();
    }
*/
    public Client()
    {
        try
        {
            mySocket = new Socket("127.0.0.1",5005);
            dis = new DataInputStream(mySocket.getInputStream());
            ps = new PrintStream(mySocket.getOutputStream());
            ps.println("M.RAOUF");
            String replyMsg = dis.readLine();
            System.out.println(replyMsg);
        }
        catch(IOException ex)
        {
            ex.printStackTrace();
        }
        try
        {
            ps.close();
            dis.close();
            mySocket.close();
        }
        catch(Exception ex)
        {
            ex.printStackTrace();
        }
    }
}