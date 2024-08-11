package com.min01.ewlegacy.entity.model;

import com.min01.ewlegacy.entity.skill.EntityWaterMinion;

import net.minecraft.client.model.AbstractZombieModel;
import net.minecraft.client.model.geom.ModelPart;

public class ModelWaterMinion extends AbstractZombieModel<EntityWaterMinion>
{
	public ModelWaterMinion(ModelPart p_170337_)
	{
		super(p_170337_);
	}

	@Override
	public boolean isAggressive(EntityWaterMinion p_101999_) 
	{
		return p_101999_.isAggressive();
	}
}
