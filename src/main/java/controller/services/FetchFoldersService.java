package controller.services;

import javax.mail.Folder;

import model.EmailAccountBean;
import model.folder.EmailFolderBean;

import javafx.concurrent.Service;
import javafx.concurrent.Task;

public class FetchFoldersService extends Service<Void>{
	
	private EmailFolderBean<String> foldersRoot;
	private EmailAccountBean emailAccountBean;
	

	public FetchFoldersService(EmailFolderBean<String> foldersRoot, EmailAccountBean emailAccountBean) {
		this.foldersRoot = foldersRoot;
		this.emailAccountBean = emailAccountBean;
	}


	@Override
	protected Task<Void> createTask() {
		return new Task<Void>(){
			@Override
			protected Void call() throws Exception {
				if(emailAccountBean != null){
					Folder[] folders = emailAccountBean.getStore().getDefaultFolder().list();
					
					for(Folder folder:folders){
						EmailFolderBean<String> item = new EmailFolderBean<String>(folder.getName(), folder.getFullName());
						foldersRoot.getChildren().add(item);
						item.setExpanded(true);
						FetchMessagesOnFolderService fetchMessagesOnFolderService = new FetchMessagesOnFolderService(item, folder);
						fetchMessagesOnFolderService.start();
						System.out.println("added: " + folder.getName());
						Folder[] subFolders = folder.list();
						for(Folder subFolder: subFolders){
							EmailFolderBean<String> subItem = new EmailFolderBean<String>(subFolder.getName(), subFolder.getFullName());
							item.getChildren().add(subItem);
							FetchMessagesOnFolderService fetchMessagesOnSubFolderService = new FetchMessagesOnFolderService(subItem, subFolder);
							fetchMessagesOnSubFolderService.start();
							System.out.println("added: " + subFolder.getName());
						}						
					}					
				}
				return null;
			}
			
		};
	}

}
