package cn.hubaoquan.mysqltest.repository;

import cn.hubaoquan.mysqltest.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface UserRepository extends JpaRepository<User, Long> {
    @Query(nativeQuery = true,
            value = "select u.id,u.name,u.age,u.city,t.company,t.salary from user u,user_detail t where u.id=t.userid and  u.id =:id  ")
    Object getUserAndDetailById(@Param("id") Long id);

    @Query(nativeQuery = true,
            value = "select u.id as uid, u.name,u.age,u.city,d.id as did,d.userid,d.company,d.salary,o.id as oid ,o.user_id,o.total  " +
                    "from user u,my_order1 o,user_detail d where u.id = o.user_id  and u.id = d.userid and   u.id = :id ")
    Object getUserAndDetailAndOrderByUserId(@Param("id") long id);
}
