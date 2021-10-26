package com.company;

import java.util.*;

public class Main {

    public static void main(String[] args) {
        Set<Character> setDual = new HashSet<>();
        Set<Character> setFirst = new HashSet<>();
        Set<Character> setAll = new HashSet<>();
        List<Character> listDual = new LinkedList<>();
        List<Character> listFirst = new LinkedList<>();
        List<Character> listAll = new LinkedList<>();

        String firstStr = "Поясните иерархию интерфейсов в Java Collections Framework.";
        String secondStr = "Объясните скелетные классы и классы реализацию Java Collections Framework.";
        char[] firstStrChar = firstStr.toCharArray();
        char[] secondStrChar = secondStr.toCharArray();
        for (int i= 0; i< firstStrChar.length; i++){
            int index = secondStr.indexOf(firstStrChar[i]);
            if (index==-1){
                setFirst.add(firstStrChar[i]);
            } else{
                setDual.add(firstStrChar[i]);
            }
            setAll.add(firstStrChar[i]);
        }
        for (int i=0; i< secondStrChar.length; i++){
            setAll.add(secondStrChar[i]);

        }
        System.out.println("Обычный порядок");
        System.out.println(setDual);
        System.out.println(setFirst);
        System.out.println(setAll);
        System.out.println("Обратный порядок");
        setDual.forEach(value-> ((LinkedList<Character>)listDual).addLast(value));
        setFirst.forEach(value->((LinkedList<Character>)listFirst).addLast(value));
        setAll.forEach(value->((LinkedList<Character>)listAll).addLast(value));

        Collections.reverse(listDual);
        Collections.reverse(listFirst);
        Collections.reverse(listAll);

        System.out.println(listDual);
        System.out.println(listFirst);
        System.out.println(listAll);
        System.out.println("В порядке Возрастания циклического свдвига");

        foo(listDual);
        foo(listFirst);
        foo(listAll);

    }
    public static void foo(List<Character> list){
        List<Integer> listInt = new LinkedList<>();
        for(int i = 0; i< list.size(); i++){
            listInt.add(Integer.valueOf((shl(((Integer)list.get(i).hashCode()).toString()))));
        }
        for (int i = 0; i<listInt.size()-1; i++){
            int j = i+1;
            if(listInt.get(i)> listInt.get(j)){
                Integer buf = listInt.get(i);
                listInt.remove(i);
                ((LinkedList<Integer>) listInt).addLast(buf);

                Character bufChar = list.get(i);
                list.remove(i);
                ((LinkedList<Character>) list).addLast(bufChar);
                i = -1;
            }
        }
        System.out.println(listInt);
        System.out.println(list);
        System.out.println();

    }
    public static String shl(String s){
        Integer n = 2;
        StringBuilder sb = new StringBuilder(s);
        for (int i = 0; i<n; i++){
            sb.append(sb.charAt(0));
            sb.deleteCharAt(0);
        }
        return sb.toString();
    }
}
