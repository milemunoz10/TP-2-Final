package Tp;

import java.util.HashMap;

public class Main {
    public static void main (String[] args){

        EpicDoubleHashMap<Integer, Object, Object> map = new EpicDoubleHashMap<>();

        Area a = new Area("Accountancy");
        Boss b = new Boss("Rick");

        //Carga mapa 1
        map.addFirstType(1,new Area("Electronic"));
        map.addFirstType(2,new Area("Administration"));
        map.addFirstType(3,new Area("Systems"));
        map.addFirstType(4,a);

        //Carga mapa2
        map.addSecondType(1,new Boss("Jhon"));
        map.addSecondType(2,new Boss("Harry"));
        map.addSecondType(3,new Boss("Jack"));
        map.addSecondType(4,b);

        //Recorremos los mapas
        System.out.println("\n* We go through our maps *");

        HashMap<Integer, Object> h1 = map.getFirstMap1();
        for (Integer i : h1.keySet()){
            System.out.println(h1.get(i));
        }

        System.out.println(" ");

        HashMap<Integer, Object> h2 = map.getSecondMap2();
        for ( Integer i : h2.keySet()) {
            System.out.println(h2.get(i));
        }

        //Eliminamos un item de cada mapa
        System.out.println("\n* We remove an item from each map *");

        map.removeFirstType(2);
        map.removerSecondType(4);

        //Recorremos los mapas, sin los items eliminados
        System.out.println("\n* We go through the maps again *");

        HashMap<Integer, Object> hr1 = map.getFirstMap1();
        for (Integer i : hr1.keySet()){
            System.out.println(hr1.get(i));
        }

        System.out.println(" ");

        HashMap<Integer, Object> hr2 = map.getSecondMap2();
        for ( Integer i : hr2.keySet()) {
            System.out.println(hr2.get(i));
        }
    }
}
