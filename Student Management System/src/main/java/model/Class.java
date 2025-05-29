package model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "class")
@Inheritance(strategy = InheritanceType.JOINED)
public class Class {
	@Id
	@GeneratedValue(generator = "uuid2")
	@GenericGenerator(name = "uuid2", strategy = "org.hibernate.id.UUIDGenerator")
	@Column(name = "class_id")
	private String id;

	@Column(name = "class_code", length = 10, unique = true)
	@Size(max = 10, message = "Mã lớp không được dài quá 10 kí tự")
	@NotEmpty(message = "Mã lớp không được để trống")
	private String code;

	@Column(name = "class_name", length = 50)
	@Size(max = 50, message = "Tên lớp không được dài quá 50 kí tự")
	@NotEmpty(message = "Tên lớp không được để trống")
	private String name;

	public Class() {
	}

	public Class(String code, String name) {
		this.code = code;
		this.name = name;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "Class [id=" + id + ", code=" + code + ", name=" + name + "]";
	}
	
}
