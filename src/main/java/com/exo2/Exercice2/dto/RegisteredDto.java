package com.exo2.Exercice2.dto;

import com.exo2.Exercice2.composite.UserPartyComposite;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RegisteredDto {
    @Schema(accessMode = Schema.AccessMode.READ_ONLY)
    private UserPartyComposite id;
    private String email;
    private String password;
    private String firstName;
    private String lastName;
    private Integer age;
}
