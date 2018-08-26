package com.gouge.service;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by grandfen on 17/4/24.
 */
public interface ApiAuthorizedService {

    boolean apiAuthorizedLogin(HttpServletRequest request);

    boolean apiAuthorizedSwingLogin(HttpServletRequest request);
}
