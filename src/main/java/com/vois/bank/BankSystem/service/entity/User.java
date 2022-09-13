package com.vois.bank.BankSystem.service.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor

@ApiModel(description="Manages employee object ")
@Entity
@Table(name = "user")
public class User implements Serializable {


    @ApiModelProperty(value = "Auto generated unique id ",required = true)
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ApiModelProperty(value = "user name of user ",required = true,example = "user")
    @Column(name = "user_name")
    private String userName;

    @ApiModelProperty(value = "password of user ",required = true,example = "user")
    @Column(name = "password")
    private String password;


    @OneToMany(mappedBy = "user",
            cascade = {CascadeType.DETACH, CascadeType.MERGE,
                    CascadeType.PERSIST, CascadeType.REFRESH})
    private List<Account> accounts;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(	name = "user_roles",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "role_id"))
    private List<Role> roles;

    public User(String userName, String password, List<Role> roles) {
        this.userName = userName;
        this.password = password;
        this.roles = roles;
    }
}
