package framework.command;

import framework.entity.Account;

public interface Command {
	public void execute();
	public String undo();
        public String redo();
}
