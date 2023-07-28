package com.geekster.Music.Streaming.Service.API.model;

import com.geekster.Music.Streaming.Service.API.model.enums.UserType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class User {

    @Id
    @GeneratedValue
    private Integer id;

    @NotBlank(message = "Username is required")
    private String username;

    private UserType role;
}
