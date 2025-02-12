package entity;

import javax.persistence.*;

@Entity
@Table(name = "customer_table") //table name
public class Customer {
    @Id//primary key
//    @GeneratedValue(strategy = GenerationType.AUTO) // auto generate Id //auto denawanm data type eka int ekak wenna one string increment karanna bari nisa
    /*@GeneratedValue(strategy = GenerationType.IDENTITY) // manual Id*/

    private int id;
    private String name;

    //First name , Last name
    /*@Embedded//field ekak bedaganna meeka use karanna puluwan
    private CustomerFullName fullName;*/

   /* @Column(name = "customer_email", nullable = false)*/

    private String email;
    private String phone;

    /*@Transient// meeka dapuawam mee field eka database eke hada gan na(Sensitive data walata wage use karanna puluwan)
    private String visaCardNumber;*/

    /*@Lob//loku data ekak save karanna use karanna puluwan
    private String description; //type eka wadenne long test*/



    public Customer() {

    }

    /*public Customer(int id, String name, String email, String phone, CustomerFullName fullName ) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.phone = phone;
    }*/

    public Customer(int id, String name, String email, String phone) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.phone = phone;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    /*public CustomerFullName getFullName(){
        return fullName;
    }*/

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    /*public void setFullName(CustomerFullName fullName) {
        this.fullName = fullName;
    }*/

    @Override
    public String toString() {
        return "Customer{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", phone='" + phone + '\'' +
                /*", fullName=" + fullName +*/
                '}';
    }
}
