package my.diplom.dev.dto.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.sql.Timestamp;

@Table(name = "message_logs")
@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Message {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@Column
	private String message;

	@Column
	private Timestamp datetime;
}
