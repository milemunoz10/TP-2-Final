package Tp;

import Exceptions.GetNonexistentValueException;
import Exceptions.RemoveItemFromAnExistingKeyExceptions;
import Exceptions.RepeatedValuesExeption;
import Exceptions.TheKeyExistsException;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class EpicDoubleHashMap <K extends Number, V, T> {
    HashMap<K, V> mapValue1;
    HashMap<K, T> mapValue2;
    private boolean flagValue = false;

    public EpicDoubleHashMap(){
        mapValue1 = new HashMap<>();
        mapValue2 = new HashMap<>();
    }


    // --- GET METHOD // EXCEPTION D

    //
     public V getMap1(K key) throws GetNonexistentValueException {
         if (mapValue1.get(key) == null) {
             throw new GetNonexistentValueException("The value of the key:"+key+ " cannot be returned, since it does not exist");
         }
         return mapValue1.get(key);
     }

    public T getMap2(K key) throws GetNonexistentValueException {
        if (mapValue2.get(key) == null) {
            throw new GetNonexistentValueException("The value of the key:"+key+ " cannot be returned, since it does not exist");
        }
        return mapValue2.get(key);
    }

    public HashMap<K, V> getFirstMap1() {

        return mapValue1;
    }
    public HashMap<K, T> getSecondMap2() {
        return mapValue2;
    }

//---------------------------------------------------------

    // --- ADD ITEMS TO MAPS // EXCEPTIONS A AND C

    // map1
    public void addFirstType(K key, V value) throws TheKeyExistsException, RepeatedValuesExeption {
       if (mapValue1.containsKey(key) || mapValue2.containsKey(key)) {
           throw new TheKeyExistsException("It's not possible to add the value" +value+ ", since the key exists and " +
                   "with other values");
       }
       repeatedValuesMap1(value);
       mapValue1.put(key, value);

    }
    // map2
    public void addSecondType(K key, T value2) throws TheKeyExistsException, RepeatedValuesExeption{
        if (mapValue2.containsKey(key) || mapValue1.containsKey(key)) {
            throw new TheKeyExistsException("It's not possible to add the value" +value2+ ", since the key exists and " +
                    "with other values");
        }
        repeatedValuesMap2(value2);
        mapValue2.put(key, value2);
    }

    // Both maps
    public void addTwoTypes(K key, V value, T value2) throws TheKeyExistsException, RepeatedValuesExeption{
        if (mapValue1.containsKey(key) || mapValue2.containsKey(key)) {
            throw new TheKeyExistsException("It's not possible to add the values" + value+ "and" +value2+ ", since the key exists and " +
                    "with other values");
        }
        repeatedValuesMaps(value, value2);
        mapValue1.put(key, value);
        mapValue2.put(key, value2);
    }

    /*
    public void addSecondType(K key, T value2)  {
        try{
            if (mapValue2.containsKey(key)) {
                throw new TheKeyExistsException("It's not possible to add the value" +value2+ ", since the key exists " +
                        "and with other values");
            } mapValue2.put(key, value2);
        } catch(TheKeyExistsException e){
            e.printStackTrace();
        }
    }
    }
     */

//---------------------------------------------------------

    // --- REMOVE ITEMS // EXCEPTION B

    // map1
    public void removeFirstType(K key){
        try{
            if (!mapValue1.containsKey(key)) {
                throw new RemoveItemFromAnExistingKeyExceptions("It's not possible to remove the item, because " +
                        "the key" + key+ "doesn't exist");
            } mapValue1.remove(key);
        } catch(RemoveItemFromAnExistingKeyExceptions e){
            e.printStackTrace();
        }
    }
    // map2
    public void removerSecondType(K key){
        try{
            if (!mapValue2.containsKey(key)) {
                throw new RemoveItemFromAnExistingKeyExceptions("It's not possible to remove the item, because the " +
                        "key" + key+ "doesn't exist");
            } mapValue2.remove(key);
        } catch(RemoveItemFromAnExistingKeyExceptions e){
            e.printStackTrace();
        }
    }
    // Both maps
    public void removeTwoTypes(K key){
        try{
            if (!mapValue1.containsKey(key) || !mapValue2.containsKey(key)) {
                throw new RemoveItemFromAnExistingKeyExceptions("It's not possible to remove the item, because the " +
                        "key" + key+ "doesn't exist");
            }
            mapValue1.remove(key);
            mapValue2.remove(key);
        } catch(RemoveItemFromAnExistingKeyExceptions e){
            e.printStackTrace();
        }
    }

//---------------------------------------------------------

    // -- REPEAT METHOD
    //map1
    public void repeatedValuesMap1(V value) throws RepeatedValuesExeption{
        int val= 0;
        Set<K> keys = mapValue1.keySet();
        for(K key : keys){
            if(mapValue1.get(key).equals(value) && !mapValue2.containsKey(key)){
                val++;
                flagValue = true; // -- THIRD AUXILIARY METHOD
            }
        }
        if (val >=2){
            throw new RepeatedValuesExeption(" Cannot be added, because the value " +value+
                    "is repeated more than 3 times");
        }
    }
    //map2
    public void repeatedValuesMap2(T value2)throws RepeatedValuesExeption{
        int val= 0;
        Set<K> keys = mapValue2.keySet();
        for(K key : keys){
            if(mapValue2.get(key).equals(value2) && !mapValue1.containsKey(key)){
                val++;
                flagValue = true;
            }
        }
        if (val >=2){
            throw new RepeatedValuesExeption(" Cannot be added, because the value " +value2+
                    "is repeated more than 3 times");
        }
    }
    // Both maps
    public void repeatedValuesMaps(V value, T value2)throws RepeatedValuesExeption{
        int val= 0;
        Set<K> keys = mapValue1.keySet();
        for(K key : keys){
            if(mapValue1.get(key).equals(value) && !mapValue2.containsKey(key)){
                val++;
                flagValue = true;
            }
        }
        Set<K> keys2 = mapValue2.keySet();
        for(K key : keys2){
            if(mapValue2.get(key).equals(value) && !mapValue1.containsKey(key)){
                val++;
                flagValue = true;
            }
        }

        if (val >=2){
            throw new RepeatedValuesExeption(" Cannot be added, because the values " +value+ "and "+value2+
                    "is repeated more than 3 times");
        }
    }

//---------------------------------------------------------

    // --- AUXILIARY METHODS

    // First auxiliary method
    public String numberOfMapValues(){
        if (mapValue1.size() > mapValue2.size()){
            return "\nThe first map has more values than the second map.";
        } else if (mapValue1.size() == mapValue2.size()){
            return "\nMaps have the same number of values.";
        } else {
            return "\nThe second map has more values than the first map.";
        }
    }

    // Second auxiliary method - opc1
    /*
    public String sameValues(K key0) {
        int sameValV = 0;
        int sameValT = 0;
        Set<K> keys1 = mapValue1.keySet();
        for (K key : keys1) {
            if (mapValue1.get(key).equals(mapValue1.get(key0))) {
                sameValV++;
            }
        }
        Set<K> keys2 = mapValue2.keySet();
        for (K key : keys2) {
            if (mapValue2.get(key).equals(mapValue2.get(key0))) {
                sameValT++;
            }
        }
        int val = sameValV + sameValT;
        return "\nThe number of values equal to the value associated with the key " + key0 + " are: " + val;
    }
    */

    // Second auxiliary method - opc2

    //Método realizado por DENIS TULIAN -----
    public int sameValues(K key){
        if (!mapValue1.containsKey(key) && !mapValue2.containsKey(key)) return 0;

        V valueV = mapValue1.containsKey(key) ? mapValue1.get(key) : null;
        T valueT = mapValue2.containsKey(key) ? mapValue2.get(key) : null;

        int count = 0;
        if (valueV != null && valueT == null){
            for (V element : mapValue1.values()){
                if (element.equals(valueV)) count ++;
            }
        } else if (valueT != null && valueV == null){
            for (T element : mapValue2.values()){
                if (element.equals(valueT)) count++;
            }
        }
        if (valueV != null && valueT != null) {
            for (Map.Entry<K, V> entry1 : mapValue1.entrySet()) {
                for (Map.Entry<K, T> entry2 : mapValue2.entrySet()) {
                    if (entry1.getKey().equals(entry2.getKey())) {
                        if ((valueV.equals(entry1.getValue()) && valueT.equals(entry2.getValue()))) count++;
                    }
                }
            }
        }return count;
    }


    // Third auxiliary method
    /*
    public boolean thereAreRepeatedValues () {
        return  flagValue;
    }
    */
    //Método realizado por DENIS TULIAN -----
    public boolean  thereAreRepeatedValues(){
        for (K key : mapValue1.keySet()){
            if (sameValues(key)>1){
                return true;
            }
        }
        for (K key : mapValue2.keySet()){
            if (sameValues(key)>1){
                return true;
            }
        }return false;
    }

}