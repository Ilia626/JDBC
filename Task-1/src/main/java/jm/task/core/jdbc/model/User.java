package jm.task.core.jdbc.model;

import javax.persistence.*;

@Entity // отображение в виде таблицы в базе данных
@Table (name = "Users") // к какой именно таблице мы привязываем класс User
public class User {
    @Id  // говорит о том что в таблице  связынный с данным столбцом поле является первичным ключом
    @GeneratedValue(strategy = GenerationType.IDENTITY) // авто ключа на стороне постгреса
    private Long id;

    @Column(name = "name") // связывание поля name со столбцом "name"
    private String name;

    @Column(name = "lastName")
    private String lastName;

    @Column(name = "age")
    private Byte age;

    public User() {

    }

    public User(String name, String lastName, Byte age) {
        this.name = name;
        this.lastName = lastName;
        this.age = age;
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

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Byte getAge() {
        return age;
    }

    public void setAge(Byte age) {
        this.age = age;
    }
}
