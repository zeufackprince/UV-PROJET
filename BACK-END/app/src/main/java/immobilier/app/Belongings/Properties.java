package immobilier.app.Belongings;

import jakarta.persistence.*;

@Entity
@Table
public class Properties {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String Prop_Description;
    private  String Prop_Dimensions;
    private String Prop_Localisation;
    private PropType Prop_Type;
    private Integer Prop_Price;

    public Properties() {
    }

    public Properties(Long id, String prop_Description, String prop_Dimensions, String prop_Localisation, PropType prop_Type, Integer prop_Price) {
        this.id = id;
        Prop_Description = prop_Description;
        Prop_Dimensions = prop_Dimensions;
        Prop_Localisation = prop_Localisation;
        Prop_Type = prop_Type;
        Prop_Price = prop_Price;
    }

    public Properties(String prop_Description, String prop_Dimensions, String prop_Localisation, PropType prop_Type, Integer prop_Price) {
        Prop_Description = prop_Description;
        Prop_Dimensions = prop_Dimensions;
        Prop_Localisation = prop_Localisation;
        Prop_Type = prop_Type;
        Prop_Price = prop_Price;
    }

    public Long getProp_id() {

        return id;
    }

    public void setProp_id(Long prop_id) {
        id = prop_id;
    }

    public String getProp_Description() {
        return Prop_Description;
    }

    public void setProp_Description(String prop_Description) {
        Prop_Description = prop_Description;
    }

    public String getProp_Dimensions() {
        return Prop_Dimensions;
    }

    public void setProp_Dimensions(String prop_Dimensions) {
        Prop_Dimensions = prop_Dimensions;
    }

    public String getProp_Localisation() {
        return Prop_Localisation;
    }

    public void setProp_Localisation(String prop_Localisation) {
        Prop_Localisation = prop_Localisation;
    }

    public PropType getProp_Type() {
        return Prop_Type;
    }

    public void setProp_Type(PropType prop_Type) {
        Prop_Type = prop_Type;
    }

    public Integer getProp_Price() {
        return Prop_Price;
    }

    public void setProp_Price(Integer prop_Price) {
        Prop_Price = prop_Price;
    }

    @Override
    public String toString() {
        return "Properties{" +
                "Prop_id=" + id +
                ", Prop_Description='" + Prop_Description + '\'' +
                ", Prop_Dimensions='" + Prop_Dimensions + '\'' +
                ", Prop_Localisation='" + Prop_Localisation + '\'' +
                ", Prop_Type=" + Prop_Type +
                ", Prop_Price=" + Prop_Price +
                '}';
    }
}
