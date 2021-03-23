package com.example.C_Vitae.Formulaire;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import java.util.List;
@Getter
@Setter
@AllArgsConstructor
public class ExpRequest {
    private String date;
    private String description;
    private List<String> technologies;
}
