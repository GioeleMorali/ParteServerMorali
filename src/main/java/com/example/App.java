package com.example;

import java.io.IOException;

public class App 
{
    public static void main( String[] args ) throws IOException
    {
        ServerStr servente = new ServerStr();
        servente.attendi();
        servente.comunica();
    }
}
