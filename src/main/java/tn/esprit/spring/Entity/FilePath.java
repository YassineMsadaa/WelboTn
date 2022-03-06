package tn.esprit.spring.Entity;

import lombok.Data;

import java.io.Serializable;

@Data
public class FilePath implements Serializable {
    private String path;
    private String filename;
}
