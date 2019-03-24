package weixin.dao;

import java.util.Optional;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import weixin.entity.Person;

/**
 *
 * @author zjz20
 */
@Repository
public interface PersonRepository extends CrudRepository<Person, Long> {

    @Query(value = "select * from person where user_name = :userName", nativeQuery = true)
    public Optional<Person> findByUserName(@Param("userName") String userName);
    @Query(value = "select password from person where user_name = :userName", nativeQuery = true)
    public String getByUserName(@Param("userName") String userName);
}
