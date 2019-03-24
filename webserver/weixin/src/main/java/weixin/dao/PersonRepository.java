package weixin.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import weixin.entity.Person;

/**
 *
 * @author zjz20
 */
@Repository
public interface PersonRepository extends CrudRepository<Person, Long> {

    public Person findByUserName(String userName);
}
