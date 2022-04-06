package com.company;

import com.google.gson.GsonBuilder;
import com.google.gson.Gson;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

public class Main {


    public static final GsonBuilder BUILDER = new GsonBuilder();
    public static final Gson GSON = BUILDER.setPrettyPrinting().create();
    public static final Path WRITE_PATH = Paths.get("./car.json");
    public static void main(String[] args) {
        Car [] cars = {
                Car.makeCar("honda",6000,Type.SEDAN),
                Car.makeCar("honda akkord",4000,Type.JEEP)
        };
        String  json = GSON.toJson(cars);
        write(json);
    }
    private static void write(String obj){
        Path write = Paths.get((String.valueOf(WRITE_PATH)));
        try {
            Files.writeString(write,obj, StandardOpenOption.CREATE,StandardOpenOption.WRITE);
        }catch (IOException e){
            e.getMessage();
        }
    }
}
