package com.oski.epoint.recruitmenttaskbackend.model;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "elements")
@Getter @Setter
@NoArgsConstructor
@RequiredArgsConstructor
@ToString @EqualsAndHashCode
public class Element {

  @Id
  @GeneratedValue
  Integer id;

  @NonNull
  String name;
}
