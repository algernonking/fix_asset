package com.dt.eam.relation.modules;

 
import com.github.foxnic.dao.relation.RelationManager;

public class OAuthRelationManager extends RelationManager {

	@Override
	protected void config() {
		this.setupRelations();
		this.setupProperties();
	}
 
	public void setupProperties() {
//		// 用户 - 角色
//		this.property(User.class, "roles", Role.class, "角色清单", "当前用户的所有角色清单").list()
//			.using(SYS_USER.ID)
//			.addRoute(SYS_ROLE_USER.$TABLE);
//		
//		// 用户 - 菜单
//		this.property(User.class, "menus", Menu.class, "菜单清单", "当前用户的所有菜单清单").list()
//			.using(SYS_USER.ID)
//			.addRoute(SYS_ROLE_USER.$TABLE)
//			.addRoute(SYS_ROLE_MENU.$TABLE);
//		
//		
//		// 用户 - 角色菜单关系
//		this.property(User.class, "roleMenus", RoleMenu.class, "角色菜单关系清单", "当前用户的所有角色菜单关系清单").list()
//			.using(SYS_USER.ID)
//			.addRoute(SYS_ROLE_USER.$TABLE);

		
		
		

	}
	
	private void setupRelations() {
		// 菜单 - 菜单层级关系
//		this.from( SYS_MENU.ID ).join( SYS_MENU.PARENT_ID );
//		
//		// 用户 - 用户角色关系
//		this.from( SYS_USER.ID ).join( SYS_ROLE_USER.USER_ID );
//		// 角色 - 用户角色关系
//		this.from( SYS_ROLE.ID ).join( SYS_ROLE_USER.ROLE_ID );
//	 
//		//角色 - 角色菜单关系
//		this.from( SYS_ROLE.ID ).join( SYS_ROLE_MENU.ROLE_ID );
//		//菜单 - 角色菜单关系
//		this.from( SYS_MENU.ID ).join( SYS_ROLE_MENU.MENU_ID );
//		
//		//用户角色关系 - 角色菜单关系
//		this.from( SYS_ROLE_USER.ROLE_ID ).join( SYS_ROLE_MENU.ROLE_ID );
		
	}

}
