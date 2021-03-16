package my.diplom.dev.web.manage;

import com.vaadin.flow.component.applayout.AppLayout;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.formlayout.FormLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.BeforeEvent;
import com.vaadin.flow.router.HasUrlParameter;
import com.vaadin.flow.router.Route;

@Route("manageGroup")
public class ManageGroup extends AppLayout implements HasUrlParameter<Integer> {

	private TextField groupId;
	private TextField code;
	private TextField secret;
	private TextField token;

	private FormLayout groupForm;
	private Button saveGroup;



	@Override
	public void setParameter(BeforeEvent beforeEvent, Integer integer) {

	}
}
