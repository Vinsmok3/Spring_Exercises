package co.develhope.springrepositories2.entities;

import javax.persistence.*;

@Entity
public class ProgrammingLanguage {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private String name;
    private Integer yearOfFirstAppearance;
    @Column(nullable = false)
    private String inventor;

    public ProgrammingLanguage() {}

    public ProgrammingLanguage(String name, Integer yearOfFirstAppearance, String inventor) {
        this.name = name;
        this.yearOfFirstAppearance = yearOfFirstAppearance;
        this.inventor = inventor;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getYearOfFirstAppearance() {
        return yearOfFirstAppearance;
    }

    public void setYearOfFirstAppearance(Integer yearOfFirstAppearance) {
        this.yearOfFirstAppearance = yearOfFirstAppearance;
    }

    public String getInventor() {
        return inventor;
    }

    public void setInventor(String inventor) {
        this.inventor = inventor;
    }
}
