package com.zipcodewilmington.phonebook;

import java.util.*;
import java.util.HashMap;


/**
 * Created by leon on 1/23/18.
 * Made WAY better by kristofer 6/16/20
 */
public class PhoneBook {

    private final Map<String, List<String>> phonebook;

    public PhoneBook(Map<String, List<String>> map) {
        this.phonebook = (Map<String, List<String>>) map;
    }

    public PhoneBook() {
        this(new LinkedHashMap<>());
    }

    public void add(String name, String phoneNumber) {
        phonebook.putIfAbsent(name, Collections.singletonList(phoneNumber));
    }

    public void addAll(String name, String... phoneNumbers) {
        phonebook.putIfAbsent(name, List.of(phoneNumbers));
    }

    public void remove(String name) {
        phonebook.remove(name);
    }

    public Boolean hasEntry(String name) {
        return phonebook.containsKey(name);
    }

    public List<String> lookup(String name) {
        return phonebook.get(name);
    }

    public String reverseLookup(String phoneNumber)  {
        List<String> pn = Collections.singletonList(phoneNumber); //converts into List
        Map<List<String>, String> inverseMap = new HashMap<>();
        phonebook.forEach((n,p) -> inverseMap.put(p,n));
        return inverseMap.get(pn);
    }

    public List<String> getAllContactNames() {
        //phonebook.forEach((n,p) -> System.out.println(n + p));
        List<String> answer = new ArrayList<>(phonebook.keySet());
        //System.out.println(Arrays.asList(answer));
        return answer;
    }

    public Map<String, List<String>> getMap() {
        return phonebook;
        //return null;
    }
}
