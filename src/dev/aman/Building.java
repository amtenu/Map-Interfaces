package dev.aman;



enum UsageType{
    ENTERTAINMENT,
    SPORT,
    RESIDENTIAL,
    GOVERNMENT
   }

public class Building implements Mappable {
    private String name;
    private UsageType usage;

    public Building(String name, UsageType usage) {
        this.name = name;
        this.usage = usage;
    }

    @Override
    public String getLabel() {
       return name +" ("+ usage +")";
    }

    @Override
    public Geometry getShape() {
        return Geometry.POINT;
    }

    @Override
    public String getMarker() {
        return switch (usage){
            case ENTERTAINMENT -> color.GREEN+ " "+ Point_Marker.TRIANGLE;
            case GOVERNMENT -> color.RED+" " +Point_Marker.STAR;
            case RESIDENTIAL -> color.BLUE +" "+ Point_Marker.SQUARE;
            case SPORT -> color.YELLOW+ " "+ Point_Marker.PUSH_PIN;
            default -> color.BLACK+ " "+ Point_Marker.CIRCLE;
        };
    }

    @Override
    public String toJson() {
        return Mappable.super.toJson() + """
              ,"name:"%s","usage":"%s"  """.formatted(name,usage);
    }
}
