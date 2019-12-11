package com.example.azure.workshopapp.service;

import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class ОтмазкиService {

    private final List<String> отмазки = new ArrayList<>();

    public String getОтмазка() {
        Random rand = new Random();
        return отмазки.get(rand.nextInt(отмазки.size()));
    }

    public void setОтмазки(String отмазка)
    {
        String[] split = отмазка.split("\n");
        List<String> strings = Arrays.asList(split);
        отмазки.addAll(strings);
    }
}
