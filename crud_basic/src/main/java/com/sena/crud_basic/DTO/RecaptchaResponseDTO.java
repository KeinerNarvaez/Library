package com.sena.crud_basic.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.AccessLevel;

@Data
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class RecaptchaResponseDTO {
    Boolean success;
    String challenge_ts;
    String hostname;
    Double score;
    String action;
}
