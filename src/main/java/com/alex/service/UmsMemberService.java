package com.alex.service;

import com.alex.common.ResultData;

/**
 * 会员管理Service
 * Created by macro on 2018/8/3.
 */
public interface UmsMemberService {

    /**
     * 生成验证码
     */
    ResultData generateAuthCode(String telephone);

    /**
     * 判断验证码和手机号码是否匹配
     */
    ResultData verifyAuthCode(String telephone, String authCode);
}
