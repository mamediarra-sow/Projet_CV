package com.example.C_Vitae.Service;

import com.example.C_Vitae.DAO.DAO_Personne;
import com.example.C_Vitae.Model.Personne;
import com.example.C_Vitae.Registration.Token.ConfirmationToken;
import com.example.C_Vitae.Registration.Token.ConfirmationTokenService;
import lombok.AllArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.UUID;

@Service
@AllArgsConstructor
public class PerService implements UserDetailsService {
    private  final DAO_Personne DAO;
    private final static String USER_NOT_FOUND_MSG = "personne with email %s is not found";
    private final BCryptPasswordEncoder bCryptPasswordEncoder;
    private final ConfirmationTokenService tokenService;
    public List<Personne> getPersonnes(){
        return DAO.findAll();
    }
    public Optional<Personne> getPersonneById(int id){
        return DAO.findById(id);
    }
    public void addNewPersonne(Personne personne) {
        if (DAO.findPersonneByEmail(personne.getEmail()).isPresent()) {
            throw new IllegalStateException("Email Taken");
        }
        DAO.save(personne);
}

    public void deletePersonne(Integer id) {
        if(!DAO.existsById(id)){
            throw new IllegalStateException("This student does not exist");
        }
        DAO.deleteById(id);

    }
    @Transactional
    public void updatePersonne(Integer id, String adresse, String email) {
       Personne personne =  DAO.findById(id).orElseThrow(()-> new IllegalStateException("This student does not exist"));
       if (adresse != null &&
               adresse.length()>0 &&
                !Objects.equals(personne.getAdresse(),adresse)){
           personne.setAdresse(adresse);
        }
       if(email !=null &&
               email.length()>0 &&
               !Objects.equals(personne.getEmail(),email)){
           if (DAO.findPersonneByEmail(email).isPresent()){
               throw new IllegalStateException("This email is taken");
           }
           personne.setEmail(email);
       }
    }

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        return DAO.findPersonneByEmail(email).orElseThrow(
                () -> new UsernameNotFoundException(String.format(USER_NOT_FOUND_MSG, email)));
    }
    public String SignUp(Personne personne){
        if(DAO.findPersonneByEmail(personne.getEmail()).isPresent()){
            throw new IllegalStateException("Email already taken");
        }
        personne.setPassword(bCryptPasswordEncoder.encode(personne.getPassword()));
        DAO.save(personne);
        String  token = UUID.randomUUID().toString();
       tokenService.saveToken(new ConfirmationToken(
               token,
               LocalDateTime.now(),
               LocalDateTime.now().plusMinutes(15), personne
        ));
        return token;
    }

    public void enablePersonne(String email) {
        DAO.EnablePersonne(email);
    }
    public Personne findByUsername(String username){
        return DAO.findByUsername(username);
    }
    public Personne findByemail(String email){return DAO.findByemail(email);}
}
