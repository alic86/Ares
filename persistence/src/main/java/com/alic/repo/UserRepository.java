package com.alic.repo;

import com.alic.domain.User;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import javax.sql.DataSource;
import java.util.Collection;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.atomic.AtomicLong;

/**
 * @author suxingzhe
 * @create 2018-06-05 下午2:31
 **/
@Repository
public class UserRepository {
    @Resource
    private DataSource dataSource;

    private final ConcurrentMap<Long, User> repository = new ConcurrentHashMap<>();
    private final AtomicLong idGenerator = new AtomicLong();

    public Boolean save(User user){
        long id = idGenerator.incrementAndGet();
        user.setId(id);

        return repository.put(id, user) == null;
    }

    public Collection<User> findAll(){
        return repository.values();
    }
}
