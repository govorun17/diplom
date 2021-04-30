package my.diplom.dev.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.JsonNode;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.jackson.JsonComponent;

import java.util.ArrayList;

@Getter
@RequiredArgsConstructor
@JsonComponent
public class MessageDto {
	private Integer data;
	@JsonProperty(value = "from_id")
	private Integer fromId;
	private Integer id;
	private Integer out;
	@JsonProperty(value = "peer_id")
	private Integer peerId;
	private String text;
	@JsonProperty(value = "conversation_message_id")
	private Integer conversationMessageId;
	@JsonProperty(value = "fwd_messages")
	private ArrayList<JsonNode> fwdMessages;
	private Boolean important;
	@JsonProperty(value = "random_id")
	private Integer randomId;
	private ArrayList<JsonNode> attachments;
	@JsonProperty(value = "is_hidden")
	private Boolean isHidden;
}
