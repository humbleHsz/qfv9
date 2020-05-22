package com.qf.api.user;

import com.qf.v9.entity.DO.TUserDO;

public interface IUserService {

    TUserDO checkLogin(TUserDO user);
}
