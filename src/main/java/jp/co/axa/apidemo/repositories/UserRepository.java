package jp.co.axa.apidemo.repositories;

import jp.co.axa.apidemo.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User,Long> {

    /**
     * Fetches User from the DB by the username
     *
     * @param mobile username to fetch
     * @return Optional of the User
     */
    Optional<User> findByMobile(String mobile);

    Optional<User> findByUsername(String username);
}
