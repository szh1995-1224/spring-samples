package org.szh.demo;

import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Repository;

@Repository
@Scope(value = "prototype",proxyMode = ScopedProxyMode.TARGET_CLASS)
public class UserDao {
}
