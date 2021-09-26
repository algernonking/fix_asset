package com.dt.platform.relation.modules;

 
import com.dt.platform.constants.db.EAMTables;
import com.github.foxnic.dao.relation.RelationManager;
import com.github.foxnic.sql.meta.DBField;
import org.github.foxnic.web.constants.db.FoxnicWeb;
import org.github.foxnic.web.domain.oauth.Menu;
import org.github.foxnic.web.domain.oauth.Role;
import org.github.foxnic.web.domain.oauth.RoleMenu;
import org.github.foxnic.web.domain.oauth.User;

public class HrmRelationManager extends RelationManager {

	@Override
	protected void config() {
		this.setupRelations();
		this.setupProperties();
	}
 
	public void setupProperties() {

	}
	
	private void setupRelations() {

	}
	private void setupDcRack() {
//				this.property(DC_RACK.class, "roles", Role.class, "角色清单", "当前用户的所有角色清单").list().
//				using(new DBField[]{FoxnicWeb.SYS_USER.ID}).
//				join(new DBField[]{FoxnicWeb.SYS_ROLE_USER.USER_ID}).
//				using(new DBField[]{FoxnicWeb.SYS_ROLE_USER.ROLE_ID}).
//				join(new DBField[]{FoxnicWeb.SYS_ROLE.ID});
}


}
