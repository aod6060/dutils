package com.derf.utils.items.pills;

import com.derf.utils.items.DItem;

public class DItemPill extends DItem {

	public DItemPill(String name) {
		super(name);
		this.setHasSubtypes(true);
		this.setMaxStackSize(16);
	}
	
	
}
