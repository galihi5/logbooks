package gaw.logbook.auth.menu;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

public class Menu {
	@JsonIgnore
	private String menuId;
	
	@JsonIgnore
	private String parentId;
	private String path;
	private boolean collapse;
	private String name;
	private String icon;
	private String state;
	private String mini;
	private String component;
	private String layout;
	private List<Menu> views;

	public Menu() {
		super();
	}

	public Menu(String menuId, String parentId, String path, boolean collapse, String name, String icon, String state,
			String mini, String component, String layout, List<Menu> views) {
		super();
		this.menuId = menuId;
		this.parentId = parentId;
		this.path = path;
		this.collapse = collapse;
		this.name = name;
		this.icon = icon;
		this.state = state;
		this.mini = mini;
		this.component = component;
		this.layout = layout;
		this.views = views;
	}

	public String getMenuId() {
		return menuId;
	}

	public void setMenuId(String menuId) {
		this.menuId = menuId;
	}

	public String getParentId() {
		return parentId;
	}

	public void setParentId(String parentId) {
		this.parentId = parentId;
	}

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}

	public boolean isCollapse() {
		return collapse;
	}

	public void setCollapse(boolean collapse) {
		this.collapse = collapse;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getIcon() {
		return icon;
	}

	public void setIcon(String icon) {
		this.icon = icon;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getMini() {
		return mini;
	}

	public void setMini(String mini) {
		this.mini = mini;
	}

	public String getComponent() {
		return component;
	}

	public void setComponent(String component) {
		this.component = component;
	}

	public String getLayout() {
		return layout;
	}

	public void setLayout(String layout) {
		this.layout = layout;
	}

	public List<Menu> getViews() {
		return views;
	}

	public void setViews(List<Menu> views) {
		this.views = views;
	}

}
