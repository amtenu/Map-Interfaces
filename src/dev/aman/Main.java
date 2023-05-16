package dev.aman;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        List<Mappable> mappable=new ArrayList<>();
        mappable.add(new Building("Calgary Tower",UsageType.GOVERNMENT));
        mappable.add(new Building("Foothills Stadium",UsageType.SPORT));
        mappable.add(new Building("Landmark Cinema",UsageType.ENTERTAINMENT));

        for (var map:mappable
             ) {
            Mappable.mapIt(map);
        }
    }
}
