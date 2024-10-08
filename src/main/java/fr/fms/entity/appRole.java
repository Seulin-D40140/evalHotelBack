package fr.fms.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
//testjenkins
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Data @NoArgsConstructor @AllArgsConstructor @ToString
public class appRole
{
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String rolename;
}
