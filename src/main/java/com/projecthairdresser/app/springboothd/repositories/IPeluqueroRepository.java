package com.projecthairdresser.app.springboothd.repositories;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import com.projecthairdresser.app.springboothd.entities.Peluquero;


@Repository("peluqueroRepository")
public interface IPeluqueroRepository extends JpaRepository<Peluquero,Serializable>{


}
