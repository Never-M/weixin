/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package weixin.dao;

import org.springframework.data.repository.CrudRepository;
import weixin.entity.UserHasFriend;

/**
 *
 * @author zjz20
 */
public interface UserHasFriendRepository extends CrudRepository<UserHasFriend, Long>  {
}
