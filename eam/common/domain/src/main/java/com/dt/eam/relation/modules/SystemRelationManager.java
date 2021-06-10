package com.dt.eam.relation.modules;

import com.github.foxnic.dao.relation.RelationManager;

public class SystemRelationManager extends RelationManager {

	@Override
	protected void config() {
		this.setupRelations();
		this.setupProperties();
	}
 
	public void setupProperties() {
 
		// 关联下级菜单
//		this.property(Menu.class, "allChildren", Menu.class, "所有下级菜单清单", "").list()
//			.using(SYS_MENU.ID).fork(32);
//		
//		// 关联下级菜单
//		this.property(Menu.class, "validChildren", Menu.class, "可用的下级菜单清单", "").list()
//			.using(SYS_MENU.ID)
//			.addConditionEquals(SYS_MENU.DELETED, 0)
//			.addOrderBy(SYS_MENU.CREATE_TIME, true, true);
//		
//		// 关联上级菜单
//		this.property(Menu.class, "parent", Menu.class, "上级菜单", "").single()
//			.using(SYS_MENU.PARENT_ID)
//			.addRoute(SYS_MENU.ID);
//
		
		
//
//		// 用户 - 角色
//		this.property(User.class, "validRoles", Role.class, "可用角色清单", "拥有当前用户的可用角色清单").list()
//				.addRoute(SYS_USER_ROLE.$TABLE)
//				.addConditionEquals(SYS_USER_ROLE.DELETED, 0)
//				.using(SYS_USER.ID)
//				.after((user, roles) -> {
//					// 按逻辑条件过滤
//					roles = roles.stream().filter(r -> {
//						return !r.isDeleted();
//					}).collect(Collectors.toList());
//					// 处理角色
//					for (Role r : roles) {
//						r.setName(r.getName() + "-" + System.currentTimeMillis());
//					}
//					return roles;
//				});
//
//		// 角色 - 用户
//		this.property(Role.class, "users", User.class, "用户清单", "拥有当前角色的用户清单").list()
//		.addRoute(SYS_USER_ROLE.$TABLE)
//		.using(SYS_ROLE.ID);

		// 账户 - 员工
//		this.property(User.class, "employee", Employee.class, "员工", "当前账户对应的员工").single().using(SYS_USER.ID);
		// 员工 - 账户
//		this.property(Employee.class, "user", User.class, "账户", "当前员工对应的账户").single().using(CRM_EMPLOYEE.USER_ID);



	}
	
	private void setupRelations() {
		
		
	}

}
