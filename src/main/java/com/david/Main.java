package com.david;

import com.david.crudapl.model.Region;
import com.david.crudapl.repository.RegionRepository;
import com.david.crudapl.repository.io.JavaIORegionRepositoryImpl;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        RegionRepository regionRepository = new JavaIORegionRepositoryImpl();


        //System.out.println(regionRepository.getById((long) 1));

        //regionRepository.save(new Region((long) 5, "Оренбург"));

        //regionRepository.deleteById((long) 5);

        //regionRepository.update(new Region((long) 2, "Петерург"));

        //System.out.println(regionRepository.getAll());




    }
}
