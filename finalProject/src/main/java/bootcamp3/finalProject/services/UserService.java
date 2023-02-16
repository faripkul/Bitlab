package bootcamp3.finalProject.services;

import bootcamp3.finalProject.model.Permission;
import bootcamp3.finalProject.model.Places;
import bootcamp3.finalProject.model.User;
import bootcamp3.finalProject.repository.PermissionRepository;
import bootcamp3.finalProject.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.ArrayList;
import java.util.List;


public class UserService implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private PermissionRepository permissionRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user=userRepository.findByEmail(username);
        if(user==null){
            throw new UsernameNotFoundException("User not found");
        }
        return user;
    }

    //отображение данных сессии
    public User getUser(){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if(!(authentication instanceof AnonymousAuthenticationToken)){
            User user = (User) authentication.getPrincipal();
            return user;
        }
        return null;
    }

    public Boolean registerUser(String email, String password, String rePassword, String fullname){
        Boolean result = null;
        if(password.equals(rePassword)){
            result = Boolean.FALSE;
            User user = userRepository.findByEmail(email);
            if(user==null){
                User account = new User();
                account.setEmail(email);
                account.setPassword(passwordEncoder.encode(password));
                account.setFullName(fullname);

                List<Permission> permissions = new ArrayList<>();
                Permission defaultPermission = permissionRepository.findByName("ROLE_USER");

                if(defaultPermission!=null){
                    permissions.add(defaultPermission);
                    account.setPermissions(permissions);
                    userRepository.save(account);
                    result=Boolean.TRUE;
                }
            }
        }
        return result;
    }

    public Boolean updatePassword(String oldPassword, String newPassword, String reNewPassword){
     Boolean result=null;
     User currentUser = getUser();
     if(currentUser!=null){
       if(passwordEncoder.matches(oldPassword,currentUser.getPassword())){
           result=Boolean.FALSE;
         if(newPassword.equals(reNewPassword)){
             currentUser.setPassword(passwordEncoder.encode(newPassword));
             userRepository.save(currentUser);
             result=Boolean.TRUE;
         }
     }

     }
     return  result;
    }

}
