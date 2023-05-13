package PhucTong.SpringSecurity.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "user")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class User {
    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int user_id;
    @Column
    private String name;
    @Column
    private String email;
    @Column
    private String password;
    @ManyToMany( fetch = FetchType.EAGER)
    @JoinTable(name = "user_role", joinColumns ={@JoinColumn(name = "user_id", referencedColumnName = "user_id")},
        inverseJoinColumns = {@JoinColumn(name = "role_id", referencedColumnName = "role_id")}
    )
    private List<Role> roles = new ArrayList();
}
