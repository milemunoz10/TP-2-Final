package Tp;

import Exceptions.GetNonexistentValueException;
import Exceptions.RepeatedValuesExeption;
import Exceptions.TheKeyExistsException;

import java.util.HashMap;

public class Main {
    public static void main (String[] args) throws TheKeyExistsException, RepeatedValuesExeption, GetNonexistentValueException {

        EpicDoubleHashMap<Integer, Area, Boss> map = new EpicDoubleHashMap<>();

        Area a = new Area("Accountancy");
        Boss b = new Boss("Rick");


        //--- MAP LOADING

        //map 1 by 1 value
        map.addFirstType(1, new Area("Electronic"));
        map.addFirstType(2, new Area("Administration"));
        map.addFirstType(3, new Area("Systems"));
        map.addFirstType(4, a);

        //map 2 by 1 value
        map.addSecondType(5, new Boss("Jhon"));
        map.addSecondType(6, new Boss("Harry"));
        map.addSecondType(7, new Boss("Jack"));
        map.addSecondType(8, new Boss("Lily"));
        map.addSecondType(12, b);

        //loading both maps, with 2 values
        map.addTwoTypes(20,new Area("Mechanics"), new Boss ("Charlie"));
        map.addTwoTypes(21,new Area("Chemistry"), new Boss ("Jennifer"));
        map.addTwoTypes(22,new Area("Sales"), new Boss ("Samanta"));

    //---------------------------------------------------------

        //--- EXCEPTIONS

        // -- Exception A
        /*

        // If we put the same keys in the maps, we get the exception...
        map.addFirstType(15,new Area("Marketing"));
        map.addFirstType(15,new Area("Business"));
        map.addSecondType(13,new Boss("Peter"));
        map.addSecondType(13,new Boss("Ben"));


        // -- Exception C

        // If we add the same value to more than 3 elements, we get the exception...
        map.addSecondType(13,new Boss("Lalo"));
        map.addSecondType(14,new Boss("Lalo"));
        map.addSecondType(15,new Boss("lalo"));
        map.addSecondType(16,new Boss("lalo"));
        map.addSecondType(17,new Boss("lalo"));



        // -- Exception D

        // If we want to obtain the value of a nonexistent key, the exception is thrown...
        System.out.println(map.getMap1(5));
        System.out.println(map.getMap2(2));
        */

    //---------------------------------------------------------

        //--- WE GO THROUGH THE MAPS

        System.out.println("\n* We go through our maps *");
        // map1
        HashMap<Integer, Area> h1 = map.getFirstMap1();
        for (Integer i : h1.keySet()) {
            System.out.println(h1.get(i));
        }

        System.out.println(" ");
        // map2
        HashMap<Integer, Boss> h2 = map.getSecondMap2();
        for (Integer i : h2.keySet()) {
            System.out.println(h2.get(i));
        }

    //---------------------------------------------------------

        // --- REMOVE ITEM

        // Remove one element from each map
        System.out.println("\n* We remove an item from each map *");

        map.removeFirstType(2);
        map.removerSecondType(6);
        map.removeTwoTypes(20);



        // --- EXCEPTION

        // -- Exception B

        /*
        // If we put the nonexistent keys in the maps to delete, the exception is thrown...
        map.removeFirstType(5);
        map.removerSecondType(3);
        */

    //---------------------------------------------------------

        // --- WE GO THROUGH THE MAPS
        //We review the maps, without the deleted elements

        System.out.println("\n* We go through the maps again *");
        // map1
        HashMap<Integer, Area> hr1 = map.getFirstMap1();
        for (Integer i : hr1.keySet()) {
            System.out.println(hr1.get(i));
        }

        System.out.println(" ");
        // map2
        HashMap<Integer, Boss> hr2 = map.getSecondMap2();
        for (Integer i : hr2.keySet()) {
            System.out.println(hr2.get(i));
        }

    //---------------------------------------------------------

        // --- AUXILIARY METHODS

        // First auxiliary method
        System.out.println(map.numberOfMapValues());

        // Second auxiliary method
        map.addFirstType(20, new Area("Systems"));
        System.out.println("\nThe number of values equal to the value associated with the key are: " + map.sameValues(3));

        // Third auxiliary method
        System.out.println("\nThere are repeated Values?: "+ map.thereAreRepeatedValues());

    }
}
