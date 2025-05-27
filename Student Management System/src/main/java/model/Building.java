package model;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "building")
public class Building {
	@Id
	@Column(name = "building_id")
	@GeneratedValue(generator = "uuid2")
	@GenericGenerator(name = "uuid2", strategy = "org.hibernate.id.UUIDGenerator")
	private String id;
	
	@Column(name = "building_name", length = 50, unique = true)
	@Size(max = 50, message = "Tên tòa nhà không quá 50 kí tự")
	@NotEmpty(message = "Tên tòa nhà không được để trống")
	private String name;
	
	@Column(name = "location")
	private String location;
	
	@OneToMany(mappedBy = "building", cascade = CascadeType.ALL)
	private Set<Room> roomList;

	public Building() {
	}

	public Building(String name) {
		this.name = name;
	}

	public Building(String name, String location) {
		this.name = name;
		this.location = location;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	@Override
	public String toString() {
		return "Building [id=" + id + ", name=" + name + ", location=" + location + "]";
	}

}
