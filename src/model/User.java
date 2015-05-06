package model;

import javax.persistence.*;
import java.util.Date;

@MappedSuperclass //da provare e vedere effetti
public abstract class User {

    @Id
    @GeneratedValue
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String lastname;

    private Date birthDate;
    private Date registrationDate;

    @Column(nullable = false, unique = true)
    private String email;

    @OneToMany
    @JoinColumn(name = "address_id")
    private Address address;

    public User(String name, String lastname, Date birthDate, String email, Address address) {
        this.name = name;
        this.lastname = lastname;
        this.birthDate = birthDate;
        this.email = email;
        this.address = address;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    public Date getRegistrationDate() {
        return registrationDate;
    }

    public void setRegistrationDate(Date registrationDate) {
        this.registrationDate = registrationDate;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof User)) return false;

        User user = (User) o;

        if (birthDate != null ? !birthDate.equals(user.birthDate) : user.birthDate != null) return false;
        if (email != null ? !email.equals(user.email) : user.email != null) return false;
        if (lastname != null ? !lastname.equals(user.lastname) : user.lastname != null) return false;
        if (name != null ? !name.equals(user.name) : user.name != null) return false;
        if (registrationDate != null ? !registrationDate.equals(user.registrationDate) : user.registrationDate != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = name != null ? name.hashCode() : 0;
        result = 31 * result + (lastname != null ? lastname.hashCode() : 0);
        result = 31 * result + (birthDate != null ? birthDate.hashCode() : 0);
        result = 31 * result + (registrationDate != null ? registrationDate.hashCode() : 0);
        result = 31 * result + (email != null ? email.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", lastname='" + lastname + '\'' +
                ", birthDate=" + birthDate +
                ", registrationDate=" + registrationDate +
                ", email='" + email + '\'' +
                '}';
    }
}