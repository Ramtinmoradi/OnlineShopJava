package com.ramtinmoradiii.onlineshopjava.config;

import com.ramtinmoradiii.onlineshopjava.entity.user.Role;
import com.ramtinmoradiii.onlineshopjava.repository.user.RoleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class DataInitializer implements CommandLineRunner {

    private final RoleRepository roleRepository;

    @Override
    public void run(String... args) throws Exception {
        createRoleIfNotFound("ROLE_USER");
        createRoleIfNotFound("ROLE_ADMIN");
    }

    private void createRoleIfNotFound(String name) {
        if (roleRepository.findByName(name).isEmpty()) {
            Role role = Role.builder()
                    .name(name)
                    .description("نقش سیستمی تولید شده خودکار")
                    .build();
            roleRepository.save(role);
            System.out.println("Role created: " + name);
        }
    }
}