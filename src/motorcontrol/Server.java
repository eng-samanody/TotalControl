/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package motorcontrol;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.lang.*;
import javax.swing.text.*;
import java.io.*;
import java.net.*;



public class Server
{
    ServerSocket myServerSocket;
    Socket s;
    DataInputStream dis;
    PrintStream ps;
    public static void main(String[] args)
    {
        new Server();
    }

    public Server()
    {
        try
        {
            myServerSocket = new ServerSocket(5006);
            s = myServerSocket.accept();
            dis = new DataInputStream(s.getInputStream());
            ps = new PrintStream(s.getOutputStream());
            String msg = dis.readLine();
            System.out.println(msg);
            ps.println("Server say's : Hello! " + msg);
        }
        catch(IOException ex)
        {
            ex.printStackTrace();
        }
        finally 
        {
            try
            {
                ps.close();
                dis.close();
                s.close();
                myServerSocket.close();
            }
            catch(Exception ex)
            {
                ex.printStackTrace();
            }
    }

    }
}