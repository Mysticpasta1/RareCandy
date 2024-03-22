package gg.generations.rarecandy.tools;

import com.google.gson.GsonBuilder;
import gg.generations.rarecandy.pokeutils.tracs.TRACST;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class MainTracl {
    public static void main(String[] args) throws IOException {
        var path = Path.of("C:\\Users\\water\\Downloads\\pm0245_00_00_base.tracs");

        var obj = TRACST.deserializeFromBinary(Files.readAllBytes(path));

        System.out.println(new GsonBuilder().setPrettyPrinting().create().toJson(obj));
    }
}