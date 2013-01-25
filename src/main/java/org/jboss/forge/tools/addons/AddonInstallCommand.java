package org.jboss.forge.tools.addons;

import javax.inject.Singleton;

import org.jboss.forge.container.services.Exported;
import org.jboss.forge.ui.Result;
import org.jboss.forge.ui.UICommand;
import org.jboss.forge.ui.UICommandID;
import org.jboss.forge.ui.UIContext;
import org.jboss.forge.ui.UIInput;
import org.jboss.forge.ui.UIValidationContext;
import org.jboss.forge.ui.base.SimpleUICommandID;

@Singleton
@Exported
public class AddonInstallCommand implements UICommand {

	private static final String COMMAND_NAME = 
			"org.jboss.forge.tools.addons.install";
	private static final String COMMAND_DESCRIPTION = 
			"Command to install a Forge 2 addon.";
	
	private UIInput<String> groupId;
	private UIInput<String> name;
	private UIInput<String> version;

	public UICommandID getId() {
		return new SimpleUICommandID(COMMAND_NAME, COMMAND_DESCRIPTION);
	}

	public void initializeUI(UIContext context) throws Exception {
		initializeGroupIdInput(context);
		initializeNameInput(context);
		initializeVersionInput(context);
	}

	private void initializeGroupIdInput(UIContext context) {
		groupId.setLabel("Group Id:");
		groupId.setRequired(true);
		context.getUIBuilder().add(groupId);
	}

	private void initializeNameInput(UIContext context) {
		name.setLabel("Name:");
		name.setRequired(true);
		context.getUIBuilder().add(name);
	}

	private void initializeVersionInput(UIContext context) {
		version.setLabel("Version:");
		version.setRequired(true);
		context.getUIBuilder().add(version);
	}

	public void validate(UIValidationContext context) {
		// TODO Auto-generated method stub

	}

	public Result execute(UIContext context) throws Exception {
		String coordinates = 
				groupId.getValue() + ':' + 
				name.getValue() + ',' +
				version.getValue();
		System.out.println("Installing addon '" + coordinates + "'");
		return Result.success();
	}
	
}
