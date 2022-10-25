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

        //Carga mapa 1
        map.addFirstType(1, new Area("Electronic"));
        map.addFirstType(2, new Area("Administration"));
        map.addFirstType(3, new Area("Systems"));
        map.addFirstType(4, a);

        //Carga mapa2
        map.addSecondType(5, new Boss("Jhon"));
        map.addSecondType(6, new Boss("Harry"));
        map.addSecondType(7, new Boss("Jack"));
        map.addSecondType(8, new Boss("Lily"));
        map.addSecondType(12, b);


        /*
        //- Si colocamos las mismas keys en los mapas, nos salta la excepción...
        map.addFirstType(15,new Area("Marketing"));
        map.addFirstType(15,new Area("Business"));
        map.addSecondType(13,new Boss("Peter"));
        map.addSecondType(13,new Boss("Ben"));


        - Si agregamos el mismo valor a mas de 3 items, nos salta la excepción...
        map.addSecondType(13,new Boss("Lalo"));
        map.addSecondType(14,new Boss("Lalo"));
        map.addSecondType(15,new Boss("lalo"));
        map.addSecondType(16,new Boss("lalo"));
        map.addSecondType(17,new Boss("lalo"));


        -Si queremos obtener el valor de una key inexistente, nos salta la excepción...
        System.out.println(map.getMap1(5));
        System.out.println(map.getMap2(2));
        */


        //Recorremos los mapas
        System.out.println("\n* We go through our maps *");

        HashMap<Integer, Area> h1 = map.getFirstMap1();
        for (Integer i : h1.keySet()) {
            System.out.println(h1.get(i));
        }

        System.out.println(" ");

        HashMap<Integer, Boss> h2 = map.getSecondMap2();
        for (Integer i : h2.keySet()) {
            System.out.println(h2.get(i));
        }


        //Eliminamos un item de cada mapa
        System.out.println("\n* We remove an item from each map *");

        map.removeFirstType(2);
        map.removerSecondType(6);
        map.removeTwoTypes(10);

         /*Si colocamos las keys inexistentes en los mapas para remover, nos salta la excepción...

        map.removeFirstType(5);
        map.removerSecondType(3);

          */

        //Recorremos los mapas, sin los items eliminados
        System.out.println("\n* We go through the maps again *");

        HashMap<Integer, Area> hr1 = map.getFirstMap1();
        for (Integer i : hr1.keySet()) {
            System.out.println(hr1.get(i));
        }

        System.out.println(" ");

        HashMap<Integer, Boss> hr2 = map.getSecondMap2();
        for (Integer i : hr2.keySet()) {
            System.out.println(hr2.get(i));
        }

        //Primer método aux
        System.out.println(map.numberOfMapValues());

    }
}
