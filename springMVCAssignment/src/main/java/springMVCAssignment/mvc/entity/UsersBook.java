package springMVCAssignment.mvc.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
@AllArgsConstructor
@Entity
public class UsersBook {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	@OneToOne
	@JoinColumn(name="userId", referencedColumnName = "email")
	private Users userId;
	
	@OneToOne
	@JoinColumn(name="bookId", referencedColumnName = "bId")
	private Books bookId;
	
	private boolean readLater;
	
	private boolean liked;
	
}
