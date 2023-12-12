package org.bedu.equipo15.inventary.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.awt.print.Book;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Getter
@Setter
@Entity
@ToString
@Table(name="Departament")
public class Departament {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String phone;

    @OneToMany(mappedBy = "departament", cascade = CascadeType.ALL)
    private List<Equipment> equipment;
}
