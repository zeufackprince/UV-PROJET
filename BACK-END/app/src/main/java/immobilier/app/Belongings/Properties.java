package immobilier.app.Belongings;

import java.util.List;

import immobilier.app.Image.Image;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table
@AllArgsConstructor @NoArgsConstructor
@Setter @Getter @ToString
public class Properties {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String Prop_Description;
    
    private  String Prop_Dimensions;

    private String Prop_Localisation;

    private PropType Prop_Type;

    private Double Prop_Price;

    @OneToMany
    @JoinColumn(name = "property_image_id")
    private List<Image> images;
}
