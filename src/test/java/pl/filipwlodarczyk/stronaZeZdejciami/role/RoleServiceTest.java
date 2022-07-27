package pl.filipwlodarczyk.stronaZeZdejciami.role;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;

import org.junit.jupiter.api.Disabled;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import pl.filipwlodarczyk.stronaZeZdejciami.RoleFoundException;

@ContextConfiguration(classes = {RoleService.class})
@ExtendWith(SpringExtension.class)
class RoleServiceTest {
    @MockBean
    private RoleRepo roleRepo;

    @Autowired
    private RoleService roleService;

    /**
     * Method under test: {@link RoleService#saveRole(Role)}
     */
    @Test
    void testSaveRole() throws Exception {
        when(roleRepo.save((Role) any())).thenReturn(new Role());
        when(roleRepo.findAll()).thenReturn(new ArrayList<>());
        roleService.saveRole(new Role());
        verify(roleRepo).save((Role) any());
        verify(roleRepo).findAll();
    }

    /**
     * Method under test: {@link RoleService#saveRole(Role)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testSaveRole2() throws Exception {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.NullPointerException: Cannot invoke "String.equals(Object)" because "str" is null
        //       at pl.filipwlodarczyk.stronaZeZdejciami.role.RoleService.saveRole(RoleService.java:22)
        //   In order to prevent saveRole(Role)
        //   from throwing NullPointerException, add constructors or factory
        //   methods that make it easier to construct fully initialized objects used in
        //   saveRole(Role).
        //   See https://diff.blue/R013 to resolve this issue.

        ArrayList<Role> roleList = new ArrayList<>();
        roleList.add(new Role());
        when(roleRepo.save((Role) any())).thenReturn(new Role());
        when(roleRepo.findAll()).thenReturn(roleList);
        roleService.saveRole(new Role());
    }

    /**
     * Method under test: {@link RoleService#saveRole(Role)}
     */
    @Test
    void testSaveRole3() throws Exception {
        when(roleRepo.save((Role) any())).thenReturn(new Role());
        when(roleRepo.findAll()).thenReturn(new ArrayList<>());
        assertThrows(Exception.class, () -> roleService.saveRole(null));
        verify(roleRepo).findAll();
    }

    /**
     * Method under test: {@link RoleService#saveRole(Role)}
     */
    @Test
    void testSaveRole4() throws Exception {
        when(roleRepo.save((Role) any())).thenThrow(new RoleFoundException("Role Name"));
        when(roleRepo.findAll()).thenThrow(new RoleFoundException("Role Name"));
        assertThrows(RoleFoundException.class, () -> roleService.saveRole(new Role()));
        verify(roleRepo).findAll();
    }

    /**
     * Method under test: {@link RoleService#saveRole(Role)}
     */
    @Test
    void testSaveRole5() throws Exception {
        ArrayList<Role> roleList = new ArrayList<>();
        roleList.add(new Role("Role Name"));
        when(roleRepo.save((Role) any())).thenReturn(new Role());
        when(roleRepo.findAll()).thenReturn(roleList);
        roleService.saveRole(new Role());
        verify(roleRepo).save((Role) any());
        verify(roleRepo).findAll();
    }

    /**
     * Method under test: {@link RoleService#saveRole(Role)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testSaveRole6() throws Exception {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.NullPointerException: Cannot invoke "pl.filipwlodarczyk.stronaZeZdejciami.role.Role.getRoleName()" because "r" is null
        //       at pl.filipwlodarczyk.stronaZeZdejciami.role.RoleService.saveRole(RoleService.java:22)
        //   In order to prevent saveRole(Role)
        //   from throwing NullPointerException, add constructors or factory
        //   methods that make it easier to construct fully initialized objects used in
        //   saveRole(Role).
        //   See https://diff.blue/R013 to resolve this issue.

        ArrayList<Role> roleList = new ArrayList<>();
        roleList.add(null);
        when(roleRepo.save((Role) any())).thenReturn(new Role());
        when(roleRepo.findAll()).thenReturn(roleList);
        roleService.saveRole(new Role());
    }

    /**
     * Method under test: {@link RoleService#saveRole(Role)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testSaveRole7() throws Exception {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.NullPointerException: Cannot invoke "pl.filipwlodarczyk.stronaZeZdejciami.role.Role.getRoleName()" because "role" is null
        //       at pl.filipwlodarczyk.stronaZeZdejciami.role.RoleService.saveRole(RoleService.java:22)
        //   In order to prevent saveRole(Role)
        //   from throwing NullPointerException, add constructors or factory
        //   methods that make it easier to construct fully initialized objects used in
        //   saveRole(Role).
        //   See https://diff.blue/R013 to resolve this issue.

        ArrayList<Role> roleList = new ArrayList<>();
        roleList.add(new Role());
        when(roleRepo.save((Role) any())).thenReturn(new Role());
        when(roleRepo.findAll()).thenReturn(roleList);
        roleService.saveRole(null);
    }

    /**
     * Method under test: {@link RoleService#saveRole(Role)}
     */
    @Test
    void testSaveRole8() throws Exception {
        ArrayList<Role> roleList = new ArrayList<>();
        roleList.add(new Role("Role Name"));
        when(roleRepo.save((Role) any())).thenReturn(new Role());
        when(roleRepo.findAll()).thenReturn(roleList);
        assertThrows(RoleFoundException.class, () -> roleService.saveRole(new Role("Role Name")));
        verify(roleRepo).findAll();
    }
}

