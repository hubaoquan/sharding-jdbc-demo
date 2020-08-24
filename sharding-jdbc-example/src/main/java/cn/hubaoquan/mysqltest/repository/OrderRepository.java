package cn.hubaoquan.mysqltest.repository;

import cn.hubaoquan.mysqltest.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, Long> {
}
