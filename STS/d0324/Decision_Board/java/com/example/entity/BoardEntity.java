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
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name="Decision_board")
@EntityListeners(AuditingEntityListener.class)
@Getter
@Setter
@ToString
public class BoardEntity {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long bno;
	
	@Column(updatable=true, nullable=false, length=50)
	private String btitle;
	
	@Column(updatable=true, nullable=false, length=200)
	private String bcontent;
	
	@ManyToOne
	@JoinColumn(name="mno", nullable=false)
	private MemberEntity member;
	
	@CreatedDate
	@Column(updatable=false)
	private LocalDateTime regdate;
	
}
