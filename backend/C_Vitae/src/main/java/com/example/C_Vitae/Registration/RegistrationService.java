package com.example.C_Vitae.Registration;

import com.example.C_Vitae.Model.AppUserRole;
import com.example.C_Vitae.Model.Personne;
import com.example.C_Vitae.Registration.Token.ConfirmationToken;
import com.example.C_Vitae.Registration.Token.ConfirmationTokenDao;
import com.example.C_Vitae.Registration.Token.ConfirmationTokenService;
import com.example.C_Vitae.Service.PerService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.LocalDateTime;

@Service
@AllArgsConstructor
public class RegistrationService {
    private final EmailValidator emailValidator;
    private final PerService Serv;
    private final ConfirmationTokenService tokenService;
    public String register(RegistrationRequest request){
        boolean isValid = emailValidator.test(request.getEmail());
        if(!isValid){
            throw new IllegalStateException("Email Not Valid");
        }
        return Serv.SignUp(
                new Personne(
                        request.getUsername(),
                        request.getPassword(),
                        request.getNom(),
                        request.getPrenom(),
                        request.getDate_naissance(),
                        request.getAdresse(),
                        request.getEmail(),
                        request.getSituation_matrimoniale(),
                        request.getLangues(),
                        request.getLoisirs(),
                        request.getVie_assoc(),
                        AppUserRole.USER)
                );

    }
    @Transactional
    public String confirmToken(String token) {
        ConfirmationToken confirmationToken = tokenService
                .getToken(token)
                .orElseThrow(() ->
                        new IllegalStateException("token not found"));

        if (confirmationToken.getConfirmedAt() != null) {
            throw new IllegalStateException("email already confirmed");
        }

        LocalDateTime expiredAt = confirmationToken.getExpiredAt();

        if (expiredAt.isBefore(LocalDateTime.now())) {
            throw new IllegalStateException("token expired");
        }

        tokenService.setConfirmedAt(token);
        Serv.enablePersonne(
                confirmationToken.getPersonne().getEmail());
        return "confirmed";
    }
}
