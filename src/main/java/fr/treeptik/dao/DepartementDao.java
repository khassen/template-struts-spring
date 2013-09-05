package fr.treeptik.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import fr.treeptik.entity.Department;

public interface DepartementDao  extends JpaRepository<Department, Integer>{

}
