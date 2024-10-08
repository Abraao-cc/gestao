package br.ind.cmil.api.dto.mapper;

import br.ind.cmil.api.persistence.model.User;
import br.ind.cmil.api.dto.RegisterUserDTO;
import java.time.LocalDateTime;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

/**
 *
 * @author Administrativo
 */
@Component
public class UserMapper {
    
    public RegisterUserDTO toDTO(User user) {
        //List<String> roles = user.getProfiles().stream().map(p -> p.getType().getValue()).collect(Collectors.toList());
        return new RegisterUserDTO(user.getFirstName(), user.getEmail(), user.getPassword());
    }
    
    public User toEntity(RegisterUserDTO dto) {
        
        User user = new User();
        //user.setId(null);
        user.setFirstName(dto.name());
        user.setEmail(dto.email());
        user.setPassword(new BCryptPasswordEncoder().encode(dto.password()));
        user.setRegistrationDate(LocalDateTime.now());        
        //user.setVerificador(null);
        //user.setAtivo(true);
        // List<Profile> perfis = perfilService.perfis(dto.perfis());
        //user.setProfiles(perfis);
        
        return user;
    }
}
