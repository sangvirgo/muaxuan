package com.demoaop.DAO;

import org.springframework.stereotype.Repository;

@Repository
public class MembershipImpl implements MembershipDAO {

    @Override
    public void addAccount() {
        System.out.println(getClass() + " DOING MY DB Membership");
    }
}
