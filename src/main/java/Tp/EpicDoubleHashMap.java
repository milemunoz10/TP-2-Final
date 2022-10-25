package Tp;

import Exceptions.GetNonexistentValueException;
import Exceptions.RemoveItemFromAnExistingKeyExceptions;
import Exceptions.RepeatedValuesExeption;
import Exceptions.TheKeyExistsException;

import java.util.HashMap;
import java.util.Set;

public class EpicDoubleHashMap <K extends Number, V, T> {
    HashMap<K, V> mapValue1;
    HashMap<K, T> mapValue2;

    public EpicDoubleHashMap(){
        mapValue1 = new HashMap<>();
        mapValue2 = new HashMap<>();
    }

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

    public void addFirstType(K key, V value) throws TheKeyExistsException, RepeatedValuesExeption {
       if (mapValue1.containsKey(key)) {
           throw new TheKeyExistsException("It's not possible to add the value" +value+ ", since the key exists and " +
                   "with other values");
       }
       repeatedValuesMap1(value);
       mapValue1.put(key, value);

    }


    public void addSecondType(K key, T value2) throws TheKeyExistsException, RepeatedValuesExeption{
        if (mapValue2.containsKey(key)) {
            throw new TheKeyExistsException("It's not possible to add the value" +value2+ ", since the key exists and " +
                    "with other values");
        }
        repeatedValuesMap2(value2);
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
    public void removeTwoTypes(K key){
        mapValue1.remove(key);
        mapValue2.remove(key);
    }
    public void repeatedValuesMap1(V value) throws RepeatedValuesExeption{
        int val= 0;
        Set<K> keys = mapValue1.keySet();
        for(K key : keys){
            if(mapValue1.get(key).equals(value)){
                val++;
            }
        }
        if (val >=2){
            throw new RepeatedValuesExeption(" Cannot be added, because the value " +value+
                    "is repeated more than 3 times");
        }
    }

    public void repeatedValuesMap2(T value2)throws RepeatedValuesExeption{
        int val= 0;
        Set<K> keys = mapValue2.keySet();
        for(K key : keys){
            if(mapValue2.get(key).equals(value2)){
                val++;
            }
        }
        if (val >=2){
            throw new RepeatedValuesExeption(" Cannot be added, because the value " +value2+
                    "is repeated more than 3 times");
        }
    }

    /*
    public void repeatedValuesMap1(K key1, V value) throws RepeatedValuesExeption{
        int val= 0;
        for(K key : mapValue1.keySet()){
            if(mapValue1.get(key).equals(value) && !mapValue2.containsKey(key)){
                val++;
            }
        }
        if (val >=2){
            throw new RepeatedValuesExeption("The item with key " + key1+" cannot be added, because its value " +value+
                    "is repeated more than 3 times");
        };
    }
    */

    // Métodos auxiliares

    public String numberOfMapValues(){
        if (mapValue1.size() > mapValue2.size()){
            System.out.println("The first map has more values than the second map.");
        } else if (mapValue1.size() == mapValue2.size()){
            System.out.println("Maps have the same number of values.");
        } else {
            System.out.println("The second map has more values than the first map.");
        }
        return null;
    }


}