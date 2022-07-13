package tentang.tech.java.validation;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public class Person {
  @Size(max = 20, message = "first name length max must 20 characters")
  @NotBlank(message = "first name can not blank")
  private String firstname;

  @Size(max = 20, message = "last name length max must 20 characters")
  @NotBlank(message = "last name can not blank")
  private String lastname;

  @NotNull(message = "address can not null")
  @Valid
  private Address address;


  public Person() {
  }

  public Person(String firstname, String lastname) {
    this.firstname = firstname;
    this.lastname = lastname;
  }

  public String getFirstname() {
    return firstname;
  }

  public void setFirstname(String firstname) {
    this.firstname = firstname;
  }

  public String getLastname() {
    return lastname;
  }

  public void setLastname(String lastname) {
    this.lastname = lastname;
  }

  public Address getAddress() {
    return address;
  }

  public void setAddress(Address address) {
    this.address = address;
  }

  public void sayHello(@NotBlank(message = "nama must not blank") String name) {
    System.out.println("hello" + name + "my name is" + firstname);
  }

  public String fullName() {
    return firstname + lastname;
  }
}
