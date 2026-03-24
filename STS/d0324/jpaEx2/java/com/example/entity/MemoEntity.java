package com.example.entity;

import java.time.LocalDateTime;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
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
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="tbl_memos")
@Data
@EntityListeners(AuditingEntityListener.class)
@NoArgsConstructor
public class MemoEntity {
   
   @Id
   @GeneratedValue(strategy=GenerationType.AUTO)
   private Long mno;
   
   private String message;
   // 작성자
   @ManyToOne
   @JoinColumn(name="writer")
   private MemberEntity member;
   
   @CreatedDate
   @Column(updatable=false)
   private LocalDateTime regDate;
   
   @LastModifiedDate
   private LocalDateTime modifyDate;
   
   @Builder
   public MemoEntity(String message, MemberEntity member) {
      this.message = message;
      this.member = member;
   }
}
