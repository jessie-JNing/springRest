package spring.model;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "ADDRESS")
public class Address implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ADDRESS_ID", nullable = false)
    private long id;

    @Column(name = "COUNTRY", nullable = false)
    private String country;

    @Column(name = "PROVINCE", nullable = false)
    private String province;

    @Column(name = "CITY", nullable = false)
    private String city;

    @OneToOne
    @JoinColumn(name="PERSON", referencedColumnName = "PERSON_ID",
            unique=true, nullable=false, updatable=false)
    private Person person;

    public Address() {}

    public Address(String country, String province, String city) {
        this.country = country;
        this.province = province;
        this.city = city;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    @Override
    public String toString() {
        return "Address{" +
                "country='" + country + '\'' +
                ", province='" + province + '\'' +
                ", city='" + city + '\'' +
                '}';
    }
}
