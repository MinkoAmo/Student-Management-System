package entities;

import java.time.LocalDate;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "schedule")
public class Schedule {
	@Id
	@Column(name = "schedule_id")
	@GeneratedValue(generator = "uuid2")
	@GenericGenerator(name = "uuid2", strategy = "org.hibernate.id.UUIDGenerator")
	private String id;
	
	@Column(name = "date")
	@NotNull(message = "Lịch không được để trống")
	private LocalDate date;
	
	@Column(name = "time_slot")
	@NotNull(message = "Tiết dạy không được để trống")
	private String timeSlot;
	
	@JoinColumn(name = "room_id")
	@ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
	@NotNull(message = "Phòng học không được để trống")
	private Room room;
	
	@JoinColumn(name = "teaching_class_id")
	@ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
	@NotNull(message = "Lớp học không được để trống")
	private TeachingClass teachingClass;

	public Schedule() {
	}

	public Schedule(LocalDate date, String timeSlot, Room room, TeachingClass teachingClass) {
		this.date = date;
		this.timeSlot = timeSlot;
		this.room = room;
		this.teachingClass = teachingClass;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public LocalDate getDate() {
		return date;
	}

	public void setDate(LocalDate date) {
		this.date = date;
	}

	public String getTimeSlot() {
		return timeSlot;
	}

	public void setTimeSlot(String timeSlot) {
		this.timeSlot = timeSlot;
	}

	public Room getRoom() {
		return room;
	}

	public void setRoom(Room room) {
		this.room = room;
	}

	public TeachingClass getTeachingClass() {
		return teachingClass;
	}

	public void setTeachingClass(TeachingClass teachingClass) {
		this.teachingClass = teachingClass;
	}
}
