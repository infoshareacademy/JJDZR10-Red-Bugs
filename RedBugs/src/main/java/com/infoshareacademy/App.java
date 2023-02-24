package com.infoshareacademy;

import Service.RoutePlanner;

import static Data.Menu.menu;

/**
 * Hello world!
 *
 */
public class App
{
    public static void main( String[] args ) throws Exception {
        System.out.println( "RedBugs" );

        // menu();

        RoutePlanner routePlanner = new RoutePlanner();

        System.out.println(routePlanner.chooseBeginningStop());


    }
}