package com.example.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name="tbl_members")
@Data
public class MemberEntity {
   @Id
   private String username;
   private String userword;
   private String nickname;
   
}