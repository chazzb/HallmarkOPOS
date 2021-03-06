//    uniCenta oPOS  - Touch Friendly Point Of Sale
//    Copyright (c) 2009-2013 uniCenta & previous Openbravo POS works
//    http://www.unicenta.com
//
//    This file is part of uniCenta oPOS
//
//    uniCenta oPOS is free software: you can redistribute it and/or modify
//    it under the terms of the GNU General Public License as published by
//    the Free Software Foundation, either version 3 of the License, or
//    (at your option) any later version.
//
//   uniCenta oPOS is distributed in the hope that it will be useful,
//    but WITHOUT ANY WARRANTY; without even the implied warranty of
//    MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
//    GNU General Public License for more details.
//
//    You should have received a copy of the GNU General Public License
//    along with uniCenta oPOS.  If not, see <http://www.gnu.org/licenses/>.

package com.openbravo.pos.customers;

import com.openbravo.basic.BasicException;
import com.openbravo.data.gui.ListCellRendererBasic;
import com.openbravo.data.loader.ComparatorCreator;
import com.openbravo.data.loader.TableDefinition;
import com.openbravo.data.loader.Vectorer;
import com.openbravo.data.user.EditorRecord;
import com.openbravo.data.user.ListProvider;
import com.openbravo.data.user.ListProviderCreator;
import com.openbravo.data.user.SaveProvider;
import com.openbravo.pos.forms.AppLocal;
import com.openbravo.pos.panels.JPanelTable;
import javax.swing.ListCellRenderer;

public class SuppliersPanel extends JPanelTable {
    
    private TableDefinition tsuppliers;
    private SuppliersView jeditor;
    
    /** Creates a new instance of SuppliersPanel */
    public SuppliersPanel() {    
    }
    
    @Override
    protected void init() {        
        DataLogicCustomers dlCustomers  = (DataLogicCustomers) app.getBean("com.openbravo.pos.customers.DataLogicCustomers");
        tsuppliers = dlCustomers.getTableSuppliers();        
        jeditor = new SuppliersView(app, dirty);    
    }
    
    @Override
    public void activate() throws BasicException { 
        
        jeditor.activate();         
        super.activate();
    }
    
    @Override
    public ListProvider getListProvider() {
        return new ListProviderCreator(tsuppliers);
    }
    
    @Override
    public SaveProvider getSaveProvider() {
        return new SaveProvider(tsuppliers, new int[] {0, 1, 2, 3, 4, 5, 6, 7, 10, 11, 12, 13, 14, 15, 16});      
    }
    
    @Override
    public Vectorer getVectorer() {
        return tsuppliers.getVectorerBasic(new int[]{4});
    }
    
    @Override
    public ComparatorCreator getComparatorCreator() {
        return tsuppliers.getComparatorCreator(new int[] {4});
    }
    
    @Override
    public ListCellRenderer getListCellRenderer() {
        return new ListCellRendererBasic(tsuppliers.getRenderStringBasic(new int[]{4}));
    }
    
    @Override
    public EditorRecord getEditor() {
        return jeditor;
    }       
    
    @Override
    public String getTitle() {
        return AppLocal.getIntString("Menu.Suppliers");
    }    
}
