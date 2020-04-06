package cn.gathub.oauth2.server.service;

import cn.gathub.oauth2.server.domain.TbUser;

public interface TbUserService {
    default TbUser getByUsername(String username) {
        return null;
    }
}
