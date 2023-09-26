package com;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerStr {
    ServerSocket server = null;
    Socket client = null;
    String stringaRicevuta = null;
    String stringaModificata = null;
    BufferedReader inDalClient;
    DataOutputStream outVersoClient;

    public Socket attendi()
    {
        try
        {
            System.out.println("1 SERVER IN ESECUZIONE ...");
            server = new ServerSocket(6789);
            client = server.accept();
            server.close();
            inDalClient = new BufferedReader(new InputStreamReader(client.getInputStream()));
            outVersoClient = new DataOutputStream(client.getOutputStream());
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
            System.out.println("Errore durante l'istanza di un server!");
            System.exit(1);
        }
        return client;
    }
    public void comunica()
    {
        try
        {
            System.out.println("3 benvenuto client, scrivi una frase e la trasformo in maiuscolo. Attendo ...");
            stringaRicevuta = inDalClient.readLine();
            System.out.println("6 ricevuta la stringa del cliente : " + stringaRicevuta);
            stringaModificata = stringaRicevuta.toUpperCase();
            System.out.println("7 invio la stampa modificata al client ...");
            outVersoClient.writeBytes(stringaModificata + '\n');
            System.out.println("9 SERVER: fine elaborazione ... arrivederci!");
            client.close();
        }
        catch(Exception e){}
    }
}
