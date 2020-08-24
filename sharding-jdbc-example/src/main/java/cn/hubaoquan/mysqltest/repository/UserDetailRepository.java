package cn.hubaoquan.mysqltest.repository;

import cn.hubaoquan.mysqltest.entity.UserDetail;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserDetailRepository extends JpaRepository<UserDetail,Long> {
}
