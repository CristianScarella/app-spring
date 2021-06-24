package com.projecthairdresser.app.springboothd.repositories;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.projecthairdresser.app.springboothd.entities.Local;

@Repository("localRepository")
public interface ILocalRepository extends JpaRepository<Local,Serializable> {

	public abstract Local findById(int id);
	
}
