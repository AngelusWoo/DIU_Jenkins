package com.example.ValleInclanTutoriales.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data @Entity 
@NoArgsConstructor 
@AllArgsConstructor
public class Tutorial {
    
    @Id
    String id;
    String title, description;
    boolean published;
}
