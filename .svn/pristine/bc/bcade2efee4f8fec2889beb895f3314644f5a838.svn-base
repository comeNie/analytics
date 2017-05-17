package com.orienttech.statics.service.sysmng.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.orienttech.statics.commons.dynamicquery.DynamicQuery;
import com.orienttech.statics.dao.RoleMngDao;
import com.orienttech.statics.dao.entity.Role;
import com.orienttech.statics.service.sysmng.RoleMngService;

@Service
@Transactional
public class RoleMngServiceImpl implements RoleMngService {

	@Autowired
	private RoleMngDao roleMngDao;
	@Autowired
	private DynamicQuery dynamicQuery;

	/**
	 * 查询所有角色
	 * 
	 * @param pageNumber
	 *            当前页数
	 * @param pageSize
	 *            每页显示条数
	 */
	@Transactional(readOnly = true)
	@Override
	public Page<Role> findAll(Role role, String search, Integer pageNumber,
			Integer pageSize) {
		StringBuilder sb = new StringBuilder();
		sb.append("select new Role(r.id,r.name,r.status) from Role r where 1=1 ");

		int index = 1;
		List<Object> params = new ArrayList<Object>();
		String regx = "^[0-9]*$";
		Pattern pat = Pattern.compile(regx);
		Matcher mat = pat.matcher(String.valueOf(search));

		if (StringUtils.isNotEmpty(search)) {
			if (mat.find()) {
				sb.append(" and r.id =?").append(index++);
				params.add(Integer.parseInt(search));
			}else{
				sb.append(" and r.name like ?").append(index++);
				params.add("%" + search + "%");
			}
		}
		sb.append(" order by r.id desc");
		return dynamicQuery.query(Role.class, new PageRequest(pageNumber - 1,
				pageSize), sb.toString(), params.toArray());
	}

	/**
	 * 新增角色
	 */
	@Transactional
	@Override
	public void add(Role role) {
		Integer maxId = roleMngDao.getMaxId();// 得到最大角色编号
		if (role != null) {
			role.setId(maxId + 1);
		}
		roleMngDao.save(role);
	}

	/**
	 * 修改角色
	 */
	@Transactional
	@Override
	public void modify(Role role) {
		roleMngDao.modifyRole(role.getName(), role.getStatus(), role.getId());
	}
	
	/**
	 * 修改是否为查阅角色
	 */
	@Transactional
	@Override
	public void modifyIfCheckRole(String ifCheckRole, Integer id) {
		roleMngDao.modifyIfCheckRole(ifCheckRole, id);
	}

	/**
	 * 验证角色名称是否存在
	 * 
	 * @param name
	 *            角色名称
	 */
	@Transactional(readOnly = true)
	@Override
	public boolean getCountByName(int id,String name, String flag) {
		if(flag.equals("1")){
			String str = roleMngDao.findRoleByName(name);
			if(str!=null && Integer.parseInt(str)>0){
				int num =Integer.parseInt(str);
				if(num == id){
					return true;
				}else{
					return false;
				}
			}else{
				return true;
			}
		}else{
			boolean f = roleMngDao.getCountByName(name) <= 0;
			return f;
		}
		/*boolean f = false;
		if (flag.equals("1")) {// 修改状态。
			f = roleMngDao.getCountByName(name) <= 1;
		} else {
			f = roleMngDao.getCountByName(name) <= 0;
		}
		return f;*/
	}

	/**
	 * 通过Id查找角色
	 */
	@Transactional(readOnly = true)
	@Override
	public Role findById(Integer id) {
		return roleMngDao.getRoleById(id);
	}
	
	/**
	 * 通过Id查找角色(查阅角色)
	 */
	@Transactional(readOnly = true)
	@Override
	public Role findCheckRoleById(Integer id) {
		return roleMngDao.getCheckRoleById(id);
	}

	/**
	 * 删除角色权限
	 */
	@Override
	public void deleteFunction(Integer roleId) {
		roleMngDao.deleteFunction(roleId);
	}

	/**
	 * 添加角色权限
	 */
	@Override
	public void saveFunction(Integer roleId, String functionId) {
		String[] ids = functionId.split(",");
		// 先删除在赋权限
		this.deleteFunction(roleId);
		for (int i = 0; i < ids.length; i++) {
			roleMngDao.saveFunction(roleId, Integer.parseInt(ids[i]));
		}
	}

	
	
	
	/**
	 * 删除Dashboard角色权限
	 */
	@Override
	public void deleteDashboardFunction(String roleId) {
		roleMngDao.deleteDashboardFunction(roleId);
	}

	/**
	 * 添加Dashboard角色权限
	 */
	@Override
	public void saveDashboardFunction(String roleId, String functionId) {
		String[] ids = functionId.split(",");
		// 先删除在赋权限
		this.deleteDashboardFunction(roleId);
		for (int i = 0; i < ids.length; i++) {
			roleMngDao.saveDashboardFunction(roleId, ids[i]);
		}
	}
	/**
	 * 只显示if_check_role=1的角色，该角色有查阅权限。
	 * @modified by wangxy 20151013
	 */
	@Override
	public List<Role> findAllCheckRole() {
		StringBuilder sb = new StringBuilder();
		sb.append("select new Role(r.id,r.name,r.status) from Role r where r.ifCheckRole='1'");
		sb.append(" order by r.id desc");
		return dynamicQuery.query(Role.class,sb.toString());
	}
	
	@Override
	public List<Role> findAll() {
		StringBuilder sb = new StringBuilder();
		sb.append("select new Role(r.id,r.name,r.status) from Role r");
		sb.append(" order by r.id desc");
		return dynamicQuery.query(Role.class,sb.toString());
	}

}
