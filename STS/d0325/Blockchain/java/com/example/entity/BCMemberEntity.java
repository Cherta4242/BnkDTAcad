package com.example.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name="bc_tbl")
@Data
public class BCMemberEntity {
	
	@Id
	private String id;
	private String pw;
	private String name;
}
