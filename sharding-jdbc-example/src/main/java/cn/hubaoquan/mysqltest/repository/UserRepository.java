package cn.hubaoquan.mysqltest.repository;

import cn.hubaoquan.mysqltest.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface UserRepository extends JpaRepository<User, Long> {
    @Query(nativeQuery = true,
            value = "select u.id,u.name,u.age,u.city,t.company,t.salary from user u,user_detail t where u.id=t.userid and  u.id =:id  ")
    Object getUserById(@Param("id") Long id);
}
