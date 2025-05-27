package model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "grade")
public class Grade {
	@Id
	@Column(name = "grade_id")
	@GeneratedValue(generator = "uuid2")
	@GenericGenerator(name = "uuid2", strategy = "org.hibernate.id.UUIDGenerator")
	private String id;

	@JoinColumn(name = "student_id")
	@ManyToOne(cascade = { CascadeType.PERSIST, CascadeType.MERGE })
	@NotNull(message = "Không được để trống học sinh")
	private Student student;

	@JoinColumn(name = "teaching_class_id")
	@ManyToOne(cascade = { CascadeType.PERSIST, CascadeType.MERGE })
	@NotNull(message = "Không được để trống lớp học")
	private TeachingClass teachingClass;

	@Column(name = "mid_term_score")
	private float midTermScore;

	@Column(name = "final_term_score")
	private float finalTermScore;

	@Column(name = "exam_score")
	private float examTermScore;

	public Grade() {
	}

	public Grade(Student student, TeachingClass teachingClass) {
		this.student = student;
		this.teachingClass = teachingClass;
	}

	public Grade(Student student, TeachingClass teachingClass, float midTermScore, float finalTermScore,
			float examTermScore) {
		this.student = student;
		this.teachingClass = teachingClass;
		this.midTermScore = midTermScore;
		this.finalTermScore = finalTermScore;
		this.examTermScore = examTermScore;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Student getStudent() {
		return student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}

	public TeachingClass getTeachingClass() {
		return teachingClass;
	}

	public void setTeachingClass(TeachingClass teachingClass) {
		this.teachingClass = teachingClass;
	}

	public float getMidTermScore() {
		return midTermScore;
	}

	public void setMidTermScore(float midTermScore) {
		this.midTermScore = midTermScore;
	}

	public float getFinalTermScore() {
		return finalTermScore;
	}

	public void setFinalTermScore(float finalTermScore) {
		this.finalTermScore = finalTermScore;
	}

	public float getExamTermScore() {
		return examTermScore;
	}

	public void setExamTermScore(float examTermScore) {
		this.examTermScore = examTermScore;
	}

	@Override
	public String toString() {
		return "Grade [id=" + id + ", student=" + student + ", teachingClass=" + teachingClass + ", midTermScore="
				+ midTermScore + ", finalTermScore=" + finalTermScore + ", examTermScore=" + examTermScore + "]";
	}
}
