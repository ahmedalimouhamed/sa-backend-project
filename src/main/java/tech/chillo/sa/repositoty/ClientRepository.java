package tech.chillo.sa.repositoty;

import org.springframework.data.jpa.repository.JpaRepository;
import tech.chillo.sa.entites.Client;

public interface ClientRepository extends JpaRepository<Client, Integer> {
    Client findByEmail(String email);
}
