package jp.co.axa.apidemo.entities;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;
import lombok.experimental.Accessors;

import javax.persistence.*;
import java.io.Serializable;

/**
 * User entity
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="USER")
public class User {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;

    @Column(name="mobile")
    private String mobile;

    @ApiModelProperty(value = "password")
    @Column(name="password")
    private String password;

    @ApiModelProperty(value = "name")
    @Column(name="name")
    private String username;
}
