package entities;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "room")
public class Room {
	@Id
	@Column(name = "room_id")
	@GeneratedValue(generator = "uuid2")
	@GenericGenerator(name = "uuid2", strategy = "org.hibernate.id.UUIDGenerator")
	private String id;
	
	@Column(name = "room_code", length = 10, unique = true)
	@Size(max = 10, message = "Mã phòng không được dài quá 10 kí tự")
	@NotEmpty(message = "Mã phòng không được để trống")
	private String code;
	
	@Column(name = "type", length = 50)
	@Size(max = 50, message = "Tên loại phòng không được dài quá 10 kí tự")
	private String type;
	
	@JoinColumn(name = "building_id")
	@ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
	@NotNull(message = "Phòng học phải thuộc 1 tòa nhà")
	private Building building;
	
	@OneToMany(mappedBy = "room", cascade = CascadeType.ALL)
	private Set<Schedule> scheduleList;

	public Room() {
	}

	public Room(String code, Building building) {
		this.code = code;
		this.building = building;
	}

	public Room(String code, String type, Building building) {
		this.code = code;
		this.type = type;
		this.building = building;
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

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public Building getBuilding() {
		return building;
	}

	public void setBuilding(Building building) {
		this.building = building;
	}
}
