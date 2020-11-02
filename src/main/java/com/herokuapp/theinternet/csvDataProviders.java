package com.herokuapp.theinternet;

import com.opencsv.CSVReader;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Method;
import java.util.*;

public class csvDataProviders {

    public static Iterator<Object[]> csvReader(Method method) {
        List<Object[]> list = new ArrayList<>();
        String pathname = "src" + File.separator + "test" + File.separator + "resources" + File.separator + "dataProviders" +
                File.separator + method.getDeclaringClass().getSimpleName() + File.separator + method.getName() + ".csv";
        File file = new File(pathname);


        try {
            CSVReader reader = new CSVReader(new FileReader(file));
            String[] keys = reader.readNext();
            if (keys != null) {
                String[] dataParts;
                while ((dataParts = reader.readNext()) != null) {
                    Map<String, String> testData = new HashMap<String, String>();
                    for (int i = 0; i < keys.length; i++) {
                        testData.put(keys[1], dataParts[i]);
                    }
                    list.add(new Object[]{testData});
                }

                reader.close();
            }
        } catch (FileNotFoundException e) {
        } catch (IOException n) {
        }
        return list.iterator();
    }
}
