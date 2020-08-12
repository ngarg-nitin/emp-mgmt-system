package com.nitin.studies.empmgmt.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.nitin.studies.empmgmt.data.APIToken;

@Repository
public interface APITokenRepository extends JpaRepository<APIToken, String> {

}
