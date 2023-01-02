package com.repository;

import com.domain.UAM;
import com.domain.User;

import java.util.List;

public interface UAMRepository {
    public UAM create(UAM uam);
    public List<UAM> getAll();
}
