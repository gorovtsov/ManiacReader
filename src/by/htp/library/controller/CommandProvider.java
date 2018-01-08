package by.htp.library.controller;

import java.util.HashMap;

import java.util.Map;

import by.htp.library.controller.command.Command;
import by.htp.library.controller.command.impl.*;

public class CommandProvider {
	
	private Map<String, Command> commands = new HashMap<>();
	
	public CommandProvider() {
		commands.put("logination", new LoginationCommand());
		commands.put("registration", new RegistrationCommand());
		commands.put("showAllUsers", new GetAllUsersCommand());
		commands.put("showAllBooks", new GetAllBooksCommand());
		commands.put("local", new LocalCommand());
		commands.put("goToPage", new GoToPageCommand());
		commands.put("addBook", new AddBookCommand());
		commands.put("changeRole", new ChangeRoleCommand());
		
	}
	
	Command getCommand(String commandName) {
		
		Command command;
		command = commands.get(commandName);
		return command;
	}

	

}
