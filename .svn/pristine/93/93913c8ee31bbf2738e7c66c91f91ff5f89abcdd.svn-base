package com.orienttech.statics.service.cognos;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.google.common.collect.Lists;
import com.orienttech.statics.service.model.usermng.OrgNodeBo;


/**
 * 获取子节点
 */
public class NodeHelper {
	
	private List<OrgNodeBo> returnList = Lists.newArrayList();
	/**
	 * 根据父节点的ID获取所有子节点
	 * @param list 分类表
	 * @param typeId 传入的父节点ID
	 * @return String
	 */
	public List<OrgNodeBo> getChildNodes(List<OrgNodeBo> list, OrgNodeBo father) {
		if (father == null) {
			return returnList;
		}
		returnList.add(father);
		String pId = father.getId();
		if(list == null || pId == null) return null;
		for (Iterator<OrgNodeBo> iterator = list.iterator(); iterator.hasNext();) {
			OrgNodeBo orgNodeBo = (OrgNodeBo) iterator.next();
			// 一、根据传入的某个父节点ID,遍历该父节点的所有子节点
			if (orgNodeBo.getParentId().equals(pId)) {
				recursionFn(list, orgNodeBo);
			}
		}
		return returnList;
	}
	
	private void recursionFn(List<OrgNodeBo> list, OrgNodeBo orgNodeBo) {
		List<OrgNodeBo> childList = getChildList(list, orgNodeBo);// 得到子节点列表
		if (hasChild(list, orgNodeBo)) {// 判断是否有子节点
			returnList.add(orgNodeBo);
			Iterator<OrgNodeBo> it = childList.iterator();
			while (it.hasNext()) {
				OrgNodeBo n = (OrgNodeBo) it.next();
				recursionFn(list, n);
			}
		} else {
			returnList.add(orgNodeBo);
		}
	}
	
	// 得到子节点列表
	private List<OrgNodeBo> getChildList(List<OrgNodeBo> list, OrgNodeBo orgNodeBo) {
		List<OrgNodeBo> nodeList = new ArrayList<OrgNodeBo>();
		Iterator<OrgNodeBo> it = list.iterator();
		while (it.hasNext()) {
			OrgNodeBo n = (OrgNodeBo) it.next();
			if (n.getParentId() == orgNodeBo.getId()) {
				nodeList.add(n);
			}
		}
		return nodeList;
	}

	// 判断是否有子节点
	private boolean hasChild(List<OrgNodeBo> list, OrgNodeBo orgNodeBo) {
		return getChildList(list, orgNodeBo).size() > 0 ? true : false;
	}
	
	/**
	 * 根据传入节点找到一级节点
	 * @param list 分类表
	 * @param typeId 传入的父节点ID
	 * @return String
	 */
	public OrgNodeBo getLevel1Nodes(List<OrgNodeBo> list, OrgNodeBo cNode, String levelId) {
		//如果是顶级节点
		if (levelId.equals(cNode.getId())) {
			return cNode;
		}
		while(!levelId.equals(cNode.getId()) && !levelId.equals(cNode.getParentId())) {
			OrgNodeBo fNode = getFather(list, cNode, levelId);
			if (fNode.getParentId().equals(levelId)) {
				return fNode;
			}
		}
		return cNode;
	}
	private OrgNodeBo getFather(List<OrgNodeBo> list, OrgNodeBo cNode, String levelId) {
		OrgNodeBo fNode = null;
		for (Iterator<OrgNodeBo> iterator = list.iterator(); iterator.hasNext();) {
			OrgNodeBo orgNodeBo = (OrgNodeBo) iterator.next();
			if (levelId.equals(orgNodeBo.getId())&&orgNodeBo.getId().equals(cNode.getParentId())) {
				fNode = orgNodeBo;
				break;
			}
		}
		return fNode;
	}
}
