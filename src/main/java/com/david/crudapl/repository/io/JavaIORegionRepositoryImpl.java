package com.david.crudapl.repository.io;

import com.david.crudapl.model.Region;
import com.david.crudapl.repository.RegionRepository;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Stream;


public class JavaIORegionRepositoryImpl implements RegionRepository {

    private String REGION_FILE_PATH = "src//main//resources//files//regions.txt";

    @Override
    public List<Region> getAll() {
        List<Region> regions = new ArrayList<>();
        List<String> strings = new ArrayList<>();
        try {
            File file = new File(REGION_FILE_PATH);
            FileReader fr = new FileReader(file);
            BufferedReader reader = new BufferedReader(fr);

            String line = reader.readLine();

            while (line != null) {
                strings.add(line);
                line = reader.readLine();

            }

            for(int i = 0; i < strings.size(); i++) {
                regions.add(new Region(Long.parseLong(strings.get(i).split(", ")[0]),strings.get(i).split(", ")[1]));
                System.out.println(strings.get(i));
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return regions;
    }

    @Override
    public Region getById(Long aLong) {
        Region region = null;
        List<String> strings = new ArrayList<>();
        try {
            File file = new File(REGION_FILE_PATH);
            FileReader fr = new FileReader(file);
            BufferedReader reader = new BufferedReader(fr);

            String line = reader.readLine();

            while (line != null) {
                strings.add(line);
                line = reader.readLine();

            }

            for(int i = 0; i < strings.size(); i++) {
                if(strings.get(i).split(", ")[0].equals(String.valueOf(aLong))){
                    region = new Region(Long.parseLong(strings.get(i).split(", ")[0]), strings.get(i).split(", ")[1]);
                }
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return region;
    }

    @Override
    public Region save(Region region) {
        File file = new File(REGION_FILE_PATH);
        FileWriter fr = null;
        try {
            fr = new FileWriter(file,true);
            fr.write(region.toString());

        } catch (IOException e) {
            e.printStackTrace();
        }finally{
            try {
                fr.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return region;
    }

    @Override
    public Region update(Region region) {
        List<String> strings = new ArrayList<>();
        try {
            File file = new File(REGION_FILE_PATH);
            FileReader fr = new FileReader(file);
            BufferedReader reader = new BufferedReader(fr);

            String line = reader.readLine();

            Scanner scanner = new Scanner(System.in);

            Long id = scanner.nextLong();
            String name = scanner.next();

            while (line != null) {
                if(region.getId() == Long.parseLong(line.split(", ")[0])) {
                    region.setId(id);
                    region.setName(name);
                } else {
                    strings.add(line);
                }
                line = reader.readLine();
            }


            FileWriter fwOb = new FileWriter(REGION_FILE_PATH, false);
            PrintWriter pwOb = new PrintWriter(fwOb, false);

            try {
                BufferedWriter writer = new BufferedWriter(new FileWriter(file, true));
                String lineSeparator = System.getProperty("line.separator");
                for(int i = 0; i < strings.size(); i++) {
                    writer.write(strings.get(i) + lineSeparator);
                }
                writer.write(String.valueOf(region));
                writer.flush();
                writer.close();
            } catch (IOException e) {
                e.printStackTrace();
            }


        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return region;
    }

    @Override
    public void deleteById(Long aLong) {
        List<String> strings = new ArrayList<>();

        try {
            File file = new File(REGION_FILE_PATH);
            FileReader fr = new FileReader(file);
            BufferedReader reader = new BufferedReader(fr);



            String line = reader.readLine();

            while (line != null) {
                if (!line.split(", ")[0].equals(String.valueOf(aLong))) {
                    strings.add(line);
                }
                line = reader.readLine();
            }


            FileWriter fwOb = new FileWriter(REGION_FILE_PATH, false);
            PrintWriter pwOb = new PrintWriter(fwOb, false);

            try {
                BufferedWriter writer = new BufferedWriter(new FileWriter(file, true));
                String lineSeparator = System.getProperty("line.separator");
                for(int i = 0; i < strings.size(); i++) {
                    writer.write(strings.get(i) + lineSeparator);
                }
                writer.flush();
                writer.close();
            } catch (IOException e) {
                e.printStackTrace();
            }




        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
