
package main.layers.roads;

import main.types.roads.LineString;
import main.types.roads.MultiLineString;
import main.geo.BoundingBox;

import java.util.*;
import javax.annotation.Generated;
//import org.apache.commons.lang.builder.ToStringBuilder;

@Generated("org.jsonschema2pojo")
public class Geometry {

    private String type;
    private List coordinates = new ArrayList<>();
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();
    private LineString lineString;
    private MultiLineString multiLineString;

    /**
     * No args constructor for use in serialization
     */
    public Geometry() {

    }

    /**
     * @param type
     * @param coordinates
     */
    public Geometry(String type, List coordinates) {
        this.type = type;
        this.coordinates = coordinates;
    }

    /**
     * @return The type
     */
    public String getType() {
        return type;
    }

    /**
     * @param type The type
     */
    public void setType(String type) {
        this.type = type;
    }

    /**
     * @return The coordinates
     */
    public List getCoordinates() {
        return coordinates;
    }

    @Override
    public String toString() {

        if (this.lineString == null) {
            return "Geometry{" +
                    "type='" + type + '\'' +
                    ", coordinates=" + multiLineString.getLineStrings() +
                    " coordinates=" + coordinates +
                    '}';
        }
        return "Geometry{" +
                "type='" + type + '\'' +
                ", coordinates=" + lineString + ", coordinates=" + multiLineString +
                " coordinates=" + coordinates +
                '}';
    }
    /*
    all roads as LineStrings, format [ [], [] ,[]   ]
     */

    public void createGeometryTypes(BoundingBox box, int width, int height) {
        if (this.type.equals("LineString")) {
            lineString = new LineString((ArrayList) this.getCoordinates()).toApplicationDimension(box, width, height);
        } else if (this.type.equals("MultiLineString")) {
            for (Object o : this.getCoordinates())
//            multiLineString = new MultiLineString((ArrayList) this.getCoordinates(), box, width, height);
                multiLineString = new MultiLineString(new LineString((ArrayList) o).toApplicationDimension(box, width, height));
//            for (Object o : this.getCoordinates())
////            multiLineString = new MultiLineString(new LineString((ArrayList) this.getCoordinates().get(0)).toApplicationDimension(box, width, height));
        }

    }

//    public void toApplicationDimesions(BoundingBox box,int width, int height){
//        createGeometryTypes();
//        ArrayList<Vec2D> result = new ArrayList<>();
//        float geoLeft = box.getLongMin();
//        float geoRigth = box.getLongMax();
//        float geoTop = box.getLatMin();
//        float geoBottom = box.getLatMax();
//        for (Vec2D v: this.lineString.getPoints()){
//            float x = width * (v.x() - geoLeft) / (geoRigth - (geoLeft));
//            float y = (height - height * (v.y() - geoTop) / (geoBottom - geoTop));
//            result.add(new Vec2D(x,y));
//        }


    //    }
    public MultiLineString getMultiLineString() {
        return this.multiLineString;
    }

    public LineString getLineString(){
        return this.lineString;
    }

    /**
     * @param coordinates The coordinates
     */
    public void setCoordinates(List coordinates) {
        this.coordinates = coordinates;
    }

//    @Override
//    public String toString() {
//        return ToStringBuilder.reflectionToString(this);
//    }

    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}
