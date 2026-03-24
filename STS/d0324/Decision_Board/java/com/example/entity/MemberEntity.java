package com.example.entity;

import java.time.LocalDateTime;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="Decision_board")
@Data
@EntityListeners(AuditingEntityListener.class)
@NoArgsConstructor
public class MemberEntity {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long mno;
	
	@Column(updatable=false, unique=true, length=20)
	private String id;
	
	@Column(updatable=false, length=20)
	private String password;
	
	@Column(updatable=false, length=15)
	private String nickname;
	
	@CreatedDate
	@Column(updatable=false)
	private LocalDateTime regdate;
	
}
