package br.ufg.inf.backend.drtransfer.model;

import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@Entity
@Data

public class Hospital extends SuperClass {



    private String name;
    private String address;
    private String telephoneNumber;
    private String email;
    private Double latitute;
    private Double longitude;
    private Integer availableBeds;





}
