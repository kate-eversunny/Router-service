package com.gornostaeva.Router.repository;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class RouterRepositoryImpl implements RouterRepository {

    HashMap<Integer, List<Integer>> data = new HashMap<>();

    public RouterRepositoryImpl(String filePath)  {
        try {
            parseFile(filePath);
        } catch (FileNotFoundException e) {
            System.out.println(filePath);
            System.out.println("The route file could not be open. Please ensure that a correct file path provided");
            System.exit(0);
        }
    }

    private void parseFile(String fileName) throws FileNotFoundException {
        Scanner scanner = new Scanner(new File(fileName));
        while (scanner.hasNext()) {
            int id = 0;
            List<Integer> stops = new LinkedList<>();
            String[] line = scanner.nextLine().split(" ");
            for (int i = 0; i < line.length; i++) {
                if (line[i].isEmpty()) continue;
                if (i == 0) {
                    id = Integer.parseInt(line[i]);
                } else {
                    stops.add(Integer.parseInt(line[i]));
                }
            }
            data.put(id, stops);
        }
    }

    public int getSize() {
        return data.size();
    }

    public List<Integer> getRoute(int index) {
        return data.get(index);
    }
}
