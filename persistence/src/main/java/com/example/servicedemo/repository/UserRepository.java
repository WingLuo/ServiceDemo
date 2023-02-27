package com.example.servicedemo.repository;

import com.example.servicedemo.domain.User;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * {@link User}
 * {@link Repository}
 */
@Repository
public class UserRepository {
    private final ConcurrentHashMap<Integer, User> repository = new ConcurrentHashMap<Integer, User>();
    private static final AtomicInteger idGenerator = new AtomicInteger();


    public boolean save(User user) {
        int id = idGenerator.incrementAndGet();
        user.setId(id);
        return repository.put(id, user) == null;

    }


    public Collection<User> findAll() {
        return  repository.values();
    }
}
