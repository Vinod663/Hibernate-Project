package entity;

import javax.persistence.Embeddable;

@Embeddable
public class CustomerFullName {
    private String firstName;
    private String lastName;
}
