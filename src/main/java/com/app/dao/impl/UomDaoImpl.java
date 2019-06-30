package com.app.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;

import com.app.dao.IUomDao;
import com.app.model.Uom;

@Repository
public class UomDaoImpl implements IUomDao {
	
	@Autowired
	private HibernateTemplate ht;

	@Override
	public Integer saveUom(Uom uom) {
		return (Integer) ht.save(uom);
	}

	@Override
	public void updateUom(Uom uom) {
		ht.update(uom);
	}

	@Override
	public void deleteUom(Integer id) {
		ht.delete(new Uom(id));
	}

	@Override
	public Uom getUomById(Integer id) {
		return ht.get(Uom.class, id);
	}

	@Override
	public List<Uom> getAllUom() {
		return ht.loadAll(Uom.class);
	}

	@Override
	public List<Object[]> getUomTypeCount() {		
		String hql = "select uomType, count(uomType) from "+Uom.class.getName()+" group by uomType";		
		return (List<Object[]>) ht.find(hql);
	}

	@Override
	public boolean isUomModelExist(String uomModel) {
		long count = 0;
		String hql = " select count(uomModel) from "+Uom.class.getName()+" where uomModel = ? ";
		List<Long> list = (List<Long>) ht.find(hql, uomModel);
		if(list != null && !list.isEmpty() ) {
			count = list.get(0);
		}
		return count>0?true:false;
	}

}
