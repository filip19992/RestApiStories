package pl.filipwlodarczyk.stronaZeZdejciami.role;

import org.springframework.stereotype.Service;
import pl.filipwlodarczyk.stronaZeZdejciami.RoleFoundException;

import java.util.List;

@Service
public class RoleService {

    private final RoleRepo roleRepo;

    public RoleService(RoleRepo roleRepo) {
        this.roleRepo = roleRepo;
    }


    public void saveRole(Role role) throws Exception {
        List<Role> all = roleRepo.findAll();

        for(Role r : all) {
            if(r.getRoleName().equals(role.getRoleName())) {
                throw new RoleFoundException(role.getRoleName());
            }
        }

        if(role!=null) {
            roleRepo.save(role);
        } else {
            throw new Exception("Could not have save role");
        }
    }
}
