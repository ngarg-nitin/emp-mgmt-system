package com.nitin.studies.empmgmt.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.nitin.studies.empmgmt.data.APIToken;

public interface APITokenRepository extends JpaRepository<APIToken, String> {

}
