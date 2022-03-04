package tn.esprit.spring.Entity;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Lob;
import java.io.Serializable;
import java.util.UUID;

@Data
@Entity
public class OfferImages implements Serializable {
    @Id
    @Column(name = "id", nullable = false)
    private UUID id;

    private String filename;
    private String filetype;
    @Lob
    private byte[] fileData;


}
