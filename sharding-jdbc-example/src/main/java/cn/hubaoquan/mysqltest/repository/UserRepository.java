package cn.hubaoquan.mysqltest.repository;

import cn.hubaoquan.mysqltest.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
//    @Query("select id,name from tbl_user where id =:id ")
//    public Object getUserById(@Param("id")Long id);
}
