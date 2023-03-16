package com.infoshareacademy;
import javax.xml.crypto.Data;

import Data.User;

import Service.RoutePlanner;

import static Data.Menu.menu;
import static Data.UserAdder.createUser;
import static Data.UserAdder.logUser;




public class App
{
    public static void main( String[] args ) throws Exception {
        System.out.println( "RedBugs" );

        RoutePlanner routePlanner = new RoutePlanner();
        logUser();
        menu();
    }
}