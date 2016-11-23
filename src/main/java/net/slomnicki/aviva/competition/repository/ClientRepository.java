package net.slomnicki.aviva.competition.repository;

import net.slomnicki.aviva.competition.model.Client;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author Marek Słomnicki <marek@slomnicki.net>
 */
public interface ClientRepository extends JpaRepository<Client, Long> {
}
