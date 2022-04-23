package board.controller;

public class BoardFactory {
	private BoardFactory() {}
	private static BoardFactory instance = new BoardFactory();
	public static BoardFactory getInstance() {
		return instance;

}
	 
	public CommandIf createCommand(String cmd) {
		CommandIf cmdIf = null;
		if (cmd.equals("/list.board")) {
			cmdIf = new ListCommand();
		}else if(cmd.equals("/writeForm.board")) {
			cmdIf = new WriteFormCommand();
		}else if(cmd.equals("/writePro.board")) {
			cmdIf = new WriteProCommand();
		}else if(cmd.equals("/content.board")) {
			cmdIf = new ContentCommand(); 
		}else if(cmd.equals("/deleteForm.board")) {
			cmdIf = new DeleteFormCommand();
		}else if(cmd.equals("/deletePro.board")) {
			cmdIf = new DeleteProCommand();
		}else if(cmd.equals("/updateForm.board")) {
			cmdIf = new UpdateFormCommand();
		}else if(cmd.equals("/updatePro.board")) {
			cmdIf = new UpdateProCommand();
		}
		return cmdIf;
	}
	
}
