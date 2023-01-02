package com.service;

import com.domain.UAM;
import com.domain.User;

import java.util.List;

public interface UAMService {
    public UAM create(UAM uam);
    public List<UAM> getAll();
}
