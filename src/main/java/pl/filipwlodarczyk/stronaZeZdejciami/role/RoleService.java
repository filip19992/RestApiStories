package pl.filipwlodarczyk.stronaZeZdejciami.role;

import org.springframework.stereotype.Service;

@Service
public class RoleService {

    private final RoleRepo roleRepo;

    public RoleService(RoleRepo roleRepo) {
        this.roleRepo = roleRepo;
    }


    public void saveRole(Role role) {
        roleRepo.save(role);
    }
}
