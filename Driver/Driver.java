package com.EntityPackage.Driver;

import java.util.Scanner;

import com.EntityPackage.Services.Service;

public class Driver {

    public static void main(String[] args) {
    	boolean hi = true;
    	while(hi == true )
    	{
        Scanner scn = new Scanner(System.in);
        System.out.println("Select the option:");
        System.out.println("Press 1 to Save");
        System.out.println("Press 2 to Update");
        System.out.println("Press 3 to Fetch");
        System.out.println("Press 4 to Delete");
        System.out.println("Press 5 to Exit");
        

        System.out.print("Enter the number: ");
        int num = scn.nextInt();

        switch (num) {
            case 1:
                Service.save();
                break;
            case 2:
                 Service.update();
                break;
            case 3:
                 Service.fetch();
                break;
            case 4:
                 Service.delete();
                break;
            case 5:
            	hi=false;
            	System.out.println("exited");
            	break;
            default:
                System.out.println("Invalid Number");
        }
        
    	}
    }
}
