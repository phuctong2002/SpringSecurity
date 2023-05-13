package PhucTong.SpringSecurity.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Role {
    @Column
    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY)
    private int role_id;
    @Column(name = "role_name")
    private String name;
    @ManyToMany( fetch = FetchType.EAGER)
    private List<User> users = new ArrayList<>();
}
