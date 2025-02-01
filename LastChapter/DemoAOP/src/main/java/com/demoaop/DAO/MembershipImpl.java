package com.demoaop.DAO;

import org.springframework.stereotype.Repository;

@Repository
public class MembershipImpl implements MembershipDAO {

    @Override
    public boolean addAccount() {
        System.out.println(getClass() + " DOING MY DB Membership");
        return true;
    }
}
