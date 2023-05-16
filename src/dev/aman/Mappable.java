package dev.aman;

  //Define enums

enum color{BLACK,BLUE,RED,GREEN, YELLOW}

enum Line_Marker{DASHED, DOTTED, SOLID}

enum Point_Marker{CIRCLE,PUSH_PIN,STAR,SQUARE,TRIANGLE}

enum Geometry {POINT,LINE,POLYGON}



public interface Mappable {
    String JSON_PROPERTY="""
              "properties":{%s}""";
    String getLabel();
    Geometry getShape();
    String getMarker();

    default String toJson(){
        return """
                "type":"%s","label":"%s","marker":"%s"
                """.formatted(getShape(),getLabel(),getMarker());
    }

    static void mapIt(Mappable mappable){
        System.out.println(JSON_PROPERTY.formatted(mappable.toJson()));
    }
}
