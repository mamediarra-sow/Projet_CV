package com.example.C_Vitae.Registration.Token;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;

@Service
@AllArgsConstructor
public class ConfirmationTokenService {
    private final ConfirmationTokenDao tokenDao;


    public void saveToken(ConfirmationToken confirmationToken){
        tokenDao.save(confirmationToken);
    }
    public Optional<ConfirmationToken> getToken(String token){
        return tokenDao.findByToken(token);
    }
    public int setConfirmedAt(String token) {
        return tokenDao.setConfirmedAt(
                token, LocalDateTime.now());
    }
}
