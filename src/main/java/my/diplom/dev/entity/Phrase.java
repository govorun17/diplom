package my.diplom.dev.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "bot_phrases")
@Getter
@Setter
@NoArgsConstructor
public class Phrase {
	public static final String COMMON_PHRASES = "COMMON_PHRASES";
	public static final String ELUSIVE_ANSWERS = "ELUSIVE_ANSWERS";
	public static final String PATTERNS_FOR_ANALYSIS = "PATTERNS_FOR_ANALYSIS";
	public static final String ANSWERS_BY_PATTERNS = "ANSWERS_BY_PATTERNS";

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@Column(nullable = false)
	private String type;

	@Column
	private String key;

	@Column(unique = true, nullable = false)
	private String value;
}
