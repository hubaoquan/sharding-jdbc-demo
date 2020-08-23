package cn.hubaoquan.mysqltest.idgenerator;

import org.apache.shardingsphere.spi.keygen.ShardingKeyGenerator;

import java.net.Inet4Address;
import java.net.UnknownHostException;
import java.util.Properties;


//实现sharding主键生成接口
public class MyGenerator implements ShardingKeyGenerator {
    // sharding自己实现的雪花算法id生成器SnowflakeShardingKeyGenerator，可以参考一下
    // SnowflakeShardingKeyGenerator snowflakeShardingKeyGenerator = new SnowflakeShardingKeyGenerator();

    //序列号作为随机因子
    private volatile long seq = 0;
    //获取当前主机ip作为随机因子
    private final long hashIP = Inet4Address.getLocalHost().getHostAddress().hashCode();

    public MyGenerator() throws UnknownHostException {
    }

    // 只要返回的id保证是唯一值，并且性能高效实用就可以了
    // 根据本人实际测试 该方法生成的id还是比较均匀的。
    // 测试数据量小非常小100时分配库1有54条，分配到库2有46条
    // 测试了20000数据分配到数据库1有9998条，分配到库2有10002条
    public synchronized Comparable<?> generateKey() {
        // return snowflakeShardingKeyGenerator.generateKey();
        //获取当前系统时间纳秒，作为随机因子
        // long id = System.nanoTime() + hashIP + (seq++);
        //System.out.println("自定义主键:"+id);
        return System.nanoTime() + hashIP + (seq++);
    }

    public String getType() {
        return "HBQ";
    }

    public Properties getProperties() {
        return null;
    }

    public void setProperties(Properties properties) {

    }
}
