package com.example.C_Vitae.Configuration;

import com.example.C_Vitae.DAO.DAO_Personne;
import com.example.C_Vitae.Model.Personne;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class PersonneConfig {
    List<String> langues = List.of("Wolof","Anglais","Français");
    List<String> loisirs = List.of("Lecture","Jeu video");
    List<String> assoc = List.of("Membre de Les élites Sénégalaise","Trésoriere du club informatique");
    @Bean
    CommandLineRunner commandLineRunner(DAO_Personne dao){
        return args -> {
          Personne Mame = new Personne( "Sow",
                                        "Mame Diarra",
                                        "01/07/1999","Grand-Standing,Thiès",
                                        "sow.mamediarra@live.fr",
                                        "Célibatire",langues,loisirs,assoc


                    );
            Personne Fallou = new Personne( "Diakhaté",
                    "Fallou",
                    "01/06/1998","Joal-Fadiouth,Thiès",
                    "diakhate.fallou@live.fr",
                    "Célibatire",langues,loisirs,assoc


            );
            Personne Mouhameth= new Personne( "Tall",
                    "Mouhameth",
                    "09/03/1998","Golf-Sud,DAKAR",
                    "tall.mouhameth@live.fr",
                    "Célibatire",langues,loisirs,assoc


            );
            dao.saveAll(List.of(Mame,Fallou,Mouhameth));
        };

    }
}
